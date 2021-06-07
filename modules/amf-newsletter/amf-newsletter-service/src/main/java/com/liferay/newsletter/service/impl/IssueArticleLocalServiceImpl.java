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
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.newsletter.model.Issue;
import com.liferay.newsletter.model.IssueArticle;
import com.liferay.newsletter.service.base.IssueArticleLocalServiceBaseImpl;
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
		List<String> dataFromContent = new ArrayList<>();

		long issueArticleId = counterLocalService.increment();

		IssueArticle issueArticle = issueArticlePersistence.create(issueArticleId);
		String xml = journalArticle.getContent();

		for(int i=0;i<5;i++){
			String data = xml.substring(xml.indexOf("[CDATA")+7,xml.indexOf("]]></dynamic-content>"));
			dataFromContent.add(data);
			xml = xml.substring(xml.indexOf("]]></dynamic-content>")+21);
		}

		issueArticle.setIssueNumber(Long.parseLong(dataFromContent.get(0)));

		issueArticle.setTitle(dataFromContent.get(1));

		issueArticle.setAuthor(dataFromContent.get(2));

		issueArticle.setOrder(Long.parseLong(dataFromContent.get(3)));

		issueArticle.setContent(dataFromContent.get(4));

		issueArticlePersistence.updateImpl(issueArticle);

		return issueArticle;
	}

	public List<IssueArticle> getAllIssueArticles(long groupId) throws PortalException, ParseException {
		List<JournalArticle> journalArticles = _journalArticleLocalService.getArticles(groupId);
		List<JournalArticle> journalArticleNewVersion = new ArrayList<>();
		List<IssueArticle> issueArticles = new ArrayList<>();

		for(int j = 0;j<journalArticles.size();j++){
			int check = haveIssueArticle(journalArticles.get(j),journalArticleNewVersion);
			if (check != -1) {
				journalArticleNewVersion.remove(check);
			}
			journalArticleNewVersion.add(journalArticles.get(j));
		}

		journalArticleNewVersion = journalArticleNewVersion.stream().filter(journalArticle -> journalArticle.getDDMStructureKey().equals("35684")).collect(Collectors.toList());

		for(int i = 0; i < journalArticleNewVersion.size(); i++){
			issueArticles.add(getIssueArticle(groupId,journalArticleNewVersion.get(i).getArticleId()));
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
}