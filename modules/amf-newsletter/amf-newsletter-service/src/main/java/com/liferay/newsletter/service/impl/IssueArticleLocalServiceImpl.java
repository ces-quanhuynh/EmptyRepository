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
import com.liferay.newsletter.service.base.IssueArticleLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The implementation of the issue article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.newsletter.service.IssueArticleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author quanhuynhces
 * @see IssueArticleLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.newsletter.model.IssueArticle",
	service = AopService.class
)
public class IssueArticleLocalServiceImpl extends IssueArticleLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.newsletter.service.IssueArticleLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.newsletter.service.IssueArticleLocalServiceUtil</code>.
	 */
	public IssueArticle getIssueArticle(long groupId, String articleId) throws PortalException, ParseException {

		JournalArticle journalArticle = _journalArticleLocalService.getArticle(groupId, articleId);
		DDMStructure ddmStructure = journalArticle.getDDMStructure();
		Fields fields = _journalConverter.getDDMFields(ddmStructure,journalArticle.getContent());

		long issueArticleId = counterLocalService.increment();
		IssueArticle issueArticle = issueArticlePersistence.create(issueArticleId);

		issueArticle.setIssueNumber(Long.valueOf((String) fields.get("IssueNumberBelongTo").getValue()));
		issueArticle.setTitle((String)fields.get("Tittle").getValue());
		issueArticle.setAuthor((String)fields.get("Author").getValue());
		issueArticle.setOrder(Long.valueOf((String) fields.get("Order").getValue()));
		issueArticle.setContent((String)fields.get("Content").getValue());

		return issueArticle;
	}

	public List<IssueArticle> getAllIssueArticles(long groupId) throws PortalException, ParseException {
		List<JournalArticle> journalArticles = _journalArticleLocalService.getArticles(groupId);
		List<JournalArticle> journalArticleNewVersions = new ArrayList<>();
		List<IssueArticle> issueArticles = new ArrayList<>();

		for (JournalArticle article : journalArticles) {
			int check = haveIssueArticle(article, journalArticleNewVersions);
			if (check != -1) {
				journalArticleNewVersions.remove(check);
			}
			journalArticleNewVersions.add(article);
		}

		journalArticleNewVersions = journalArticleNewVersions.stream().
				filter(journalArticle -> journalArticle.getDDMStructure().getNameCurrentValue().equals(ContentNames.ISSUE_ARTICLE)).
				collect(Collectors.toList());

		for (JournalArticle journalArticleNewVersion : journalArticleNewVersions) {
			issueArticles.add(getIssueArticle(groupId, journalArticleNewVersion.getArticleId()));
		}

		return issueArticles;
	}

	public int haveIssueArticle(JournalArticle journalArticle, List<JournalArticle> journalArticles){
		for(int i=0; i<journalArticles.size();i++){
			if(journalArticles.get(i).getArticleId().equals(journalArticle.getArticleId())){
				return i;
			}
		}
		return -1;
	}

	@Reference
	public JournalArticleLocalService _journalArticleLocalService;

	@Reference
	public JournalConverter _journalConverter;
}