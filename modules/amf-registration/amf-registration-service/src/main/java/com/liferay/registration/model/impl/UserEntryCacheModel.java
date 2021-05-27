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

package com.liferay.registration.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.registration.model.UserEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserEntry in entity cache.
 *
 * @author quanhuynh
 * @generated
 */
public class UserEntryCacheModel
	implements CacheModel<UserEntry>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserEntryCacheModel)) {
			return false;
		}

		UserEntryCacheModel userEntryCacheModel = (UserEntryCacheModel)object;

		if ((userEntryId == userEntryCacheModel.userEntryId) &&
			(mvccVersion == userEntryCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, userEntryId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", userEntryId=");
		sb.append(userEntryId);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserEntry toEntityModel() {
		UserEntryImpl userEntryImpl = new UserEntryImpl();

		userEntryImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			userEntryImpl.setUuid("");
		}
		else {
			userEntryImpl.setUuid(uuid);
		}

		userEntryImpl.setUserEntryId(userEntryId);

		if (homePhone == null) {
			userEntryImpl.setHomePhone("");
		}
		else {
			userEntryImpl.setHomePhone(homePhone);
		}

		if (mobilePhone == null) {
			userEntryImpl.setMobilePhone("");
		}
		else {
			userEntryImpl.setMobilePhone(mobilePhone);
		}

		if (address1 == null) {
			userEntryImpl.setAddress1("");
		}
		else {
			userEntryImpl.setAddress1(address1);
		}

		if (address2 == null) {
			userEntryImpl.setAddress2("");
		}
		else {
			userEntryImpl.setAddress2(address2);
		}

		if (city == null) {
			userEntryImpl.setCity("");
		}
		else {
			userEntryImpl.setCity(city);
		}

		if (state == null) {
			userEntryImpl.setState("");
		}
		else {
			userEntryImpl.setState(state);
		}

		if (zipCode == null) {
			userEntryImpl.setZipCode("");
		}
		else {
			userEntryImpl.setZipCode(zipCode);
		}

		userEntryImpl.setUserId(userId);

		userEntryImpl.resetOriginalValues();

		return userEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		userEntryId = objectInput.readLong();
		homePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zipCode = objectInput.readUTF();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userEntryId);

		if (homePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(homePhone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (address1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (address2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		objectOutput.writeLong(userId);
	}

	public long mvccVersion;
	public String uuid;
	public long userEntryId;
	public String homePhone;
	public String mobilePhone;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String zipCode;
	public long userId;

}