/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.newsletter.service.impl;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.util.JournalConverter;
import com.liferay.newsletter.content.ContentNames;
import com.liferay.newsletter.model.Issue;
import com.liferay.newsletter.model.IssueArticle;
import com.liferay.newsletter.service.IssueArticleLocalService;
import com.liferay.newsletter.service.base.IssueLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The implementation of the issue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.newsletter.service.IssueLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author quanhuynhces
 * @see IssueLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.newsletter.model.Issue",
	service = AopService.class
)
public class IssueLocalServiceImpl extends IssueLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.newsletter.service.IssueLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.newsletter.service.IssueLocalServiceUtil</code>.
	 */

	public Issue getIssue(long groupId, String articleId) throws PortalException, ParseException {

		JournalArticle journalArticle = _journalArticleLocalService.getArticle(groupId, articleId);
		DDMStructure ddmStructure = journalArticle.getDDMStructure();
		Fields fields = _journalConverter.getDDMFields(ddmStructure,journalArticle.getContent());

		long issueId = counterLocalService.increment();
		Issue issue = issuePersistence.create(issueId);

		issue.setIssueNumber(Long.valueOf((String)fields.get("IssueNumber").getValue()));
		issue.setTitle((String)fields.get("Tittle").getValue());
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)fields.get("IssueDate").getValue());
		issue.setIssueDate(date);
		issue.setDescription((String)fields.get("Description").getValue());

		return issue;
	}

	public List<Issue> getAllIssues(long groupId) throws PortalException, ParseException {
		List<JournalArticle> journalArticles = _journalArticleLocalService.getArticles(groupId);
		List<JournalArticle> journalArticleNewVersion = new ArrayList<>();
		List<Issue> issues = new ArrayList<>();

		for (JournalArticle article : journalArticles) {
			int check = haveIssue(article, journalArticleNewVersion);
			if (check != -1) {
				journalArticleNewVersion.remove(check);
			}
			journalArticleNewVersion.add(article);
		}

		journalArticleNewVersion = journalArticleNewVersion.stream()
				.filter(journalArticle -> journalArticle.getDDMStructure().getNameCurrentValue().equals(ContentNames.ISSUE))
				.collect(Collectors.toList());

		for (JournalArticle journalArticle : journalArticleNewVersion) {
			issues.add(getIssue(groupId, journalArticle.getArticleId()));
		}

		return issues;
	}

	public List<Issue> getIssuesBySearch(long groupId, List<JournalArticle> journalArticles) throws PortalException, ParseException {
		List<Issue> issues = new ArrayList<>();
		List<JournalArticle> journalArticleIssue = new ArrayList<>();

		for(int i = 0; i<journalArticles.size(); i++){
			if(journalArticles.get(i).getDDMStructure().getNameCurrentValue().equals(ContentNames.ISSUE) && haveIssue(journalArticles.get(i),journalArticleIssue)==-1){

				journalArticleIssue.add(journalArticles.get(i));

			} else if(journalArticles.get(i).getDDMStructure().getNameCurrentValue().equals(ContentNames.ISSUE_ARTICLE)){

				JournalArticle journalArticleCheck = getIssueByIssueArticle(groupId,journalArticles.get(i));

				if(journalArticleCheck!=null&&haveIssue(journalArticleCheck,journalArticleIssue)==-1){
					journalArticleIssue.add(journalArticleCheck);
				}
			}
		}

		for (JournalArticle journalArticle : journalArticleIssue) {
			issues.add(getIssue(groupId, journalArticle.getArticleId()));
		}
		return issues;
	}

	public int haveIssue(JournalArticle journalArticle, List<JournalArticle> journalArticles){
		for(int i=0; i<journalArticles.size();i++){
			if(journalArticles.get(i).getArticleId().equals(journalArticle.getArticleId())){
				return i;
			}
		}
		return -1;
	}

	public JournalArticle getIssueByIssueArticle (long groupId, JournalArticle journalArticle) throws ParseException, PortalException {

		IssueArticle issueArticle = _issueArticleLocalService.getIssueArticle(groupId,journalArticle.getArticleId());

		List<JournalArticle> journalArticles = _journalArticleLocalService.getArticles(groupId);
		for(int i = 0; i<journalArticles.size(); i++){

			if(journalArticles.get(i).getDDMStructure().getNameCurrentValue().equals(ContentNames.ISSUE)){

				Issue issue = getIssue(groupId,journalArticles.get(i).getArticleId());

				if(issue.getIssueNumber()==issueArticle.getIssueNumber()){
					return journalArticles.get(i);
				}
			}
		}
		return null;
	}

	@Reference
	public JournalArticleLocalService _journalArticleLocalService;

	@Reference
	public JournalConverter _journalConverter;

	@Reference
	public IssueArticleLocalService _issueArticleLocalService;
}