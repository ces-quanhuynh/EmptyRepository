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

package com.liferay.newsletter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.newsletter.service.http.IssueArticleServiceSoap}.
 *
 * @author quanhuynhces
 * @generated
 */
public class IssueArticleSoap implements Serializable {

	public static IssueArticleSoap toSoapModel(IssueArticle model) {
		IssueArticleSoap soapModel = new IssueArticleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIssueArticleId(model.getIssueArticleId());
		soapModel.setIssueNumber(model.getIssueNumber());
		soapModel.setTitle(model.getTitle());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setOrder(model.getOrder());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static IssueArticleSoap[] toSoapModels(IssueArticle[] models) {
		IssueArticleSoap[] soapModels = new IssueArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IssueArticleSoap[][] toSoapModels(IssueArticle[][] models) {
		IssueArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IssueArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IssueArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IssueArticleSoap[] toSoapModels(List<IssueArticle> models) {
		List<IssueArticleSoap> soapModels = new ArrayList<IssueArticleSoap>(
			models.size());

		for (IssueArticle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IssueArticleSoap[soapModels.size()]);
	}

	public IssueArticleSoap() {
	}

	public long getPrimaryKey() {
		return _issueArticleId;
	}

	public void setPrimaryKey(long pk) {
		setIssueArticleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getIssueArticleId() {
		return _issueArticleId;
	}

	public void setIssueArticleId(long issueArticleId) {
		_issueArticleId = issueArticleId;
	}

	public long getIssueNumber() {
		return _issueNumber;
	}

	public void setIssueNumber(long issueNumber) {
		_issueNumber = issueNumber;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public long getOrder() {
		return _order;
	}

	public void setOrder(long order) {
		_order = order;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private String _uuid;
	private long _issueArticleId;
	private long _issueNumber;
	private String _title;
	private String _author;
	private long _order;
	private String _content;

}