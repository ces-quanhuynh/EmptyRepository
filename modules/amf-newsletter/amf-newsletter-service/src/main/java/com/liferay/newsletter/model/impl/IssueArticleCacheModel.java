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

package com.liferay.newsletter.model.impl;

import com.liferay.newsletter.model.IssueArticle;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing IssueArticle in entity cache.
 *
 * @author quanhuynhces
 * @generated
 */
public class IssueArticleCacheModel
	implements CacheModel<IssueArticle>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IssueArticleCacheModel)) {
			return false;
		}

		IssueArticleCacheModel issueArticleCacheModel =
			(IssueArticleCacheModel)object;

		if (issueArticleId == issueArticleCacheModel.issueArticleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, issueArticleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", issueArticleId=");
		sb.append(issueArticleId);
		sb.append(", issueNumber=");
		sb.append(issueNumber);
		sb.append(", title=");
		sb.append(title);
		sb.append(", author=");
		sb.append(author);
		sb.append(", order=");
		sb.append(order);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IssueArticle toEntityModel() {
		IssueArticleImpl issueArticleImpl = new IssueArticleImpl();

		if (uuid == null) {
			issueArticleImpl.setUuid("");
		}
		else {
			issueArticleImpl.setUuid(uuid);
		}

		issueArticleImpl.setIssueArticleId(issueArticleId);
		issueArticleImpl.setIssueNumber(issueNumber);

		if (title == null) {
			issueArticleImpl.setTitle("");
		}
		else {
			issueArticleImpl.setTitle(title);
		}

		if (author == null) {
			issueArticleImpl.setAuthor("");
		}
		else {
			issueArticleImpl.setAuthor(author);
		}

		issueArticleImpl.setOrder(order);

		if (content == null) {
			issueArticleImpl.setContent("");
		}
		else {
			issueArticleImpl.setContent(content);
		}

		issueArticleImpl.resetOriginalValues();

		return issueArticleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		issueArticleId = objectInput.readLong();

		issueNumber = objectInput.readLong();
		title = objectInput.readUTF();
		author = objectInput.readUTF();

		order = objectInput.readLong();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(issueArticleId);

		objectOutput.writeLong(issueNumber);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (author == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(author);
		}

		objectOutput.writeLong(order);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public String uuid;
	public long issueArticleId;
	public long issueNumber;
	public String title;
	public String author;
	public long order;
	public String content;

}