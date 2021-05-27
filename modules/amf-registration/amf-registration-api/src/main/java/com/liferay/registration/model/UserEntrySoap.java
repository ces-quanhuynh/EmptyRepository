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

package com.liferay.registration.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.registration.service.http.UserEntryServiceSoap}.
 *
 * @author quanhuynh
 * @generated
 */
public class UserEntrySoap implements Serializable {

	public static UserEntrySoap toSoapModel(UserEntry model) {
		UserEntrySoap soapModel = new UserEntrySoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setUserEntryId(model.getUserEntryId());
		soapModel.setHomePhone(model.getHomePhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static UserEntrySoap[] toSoapModels(UserEntry[] models) {
		UserEntrySoap[] soapModels = new UserEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserEntrySoap[][] toSoapModels(UserEntry[][] models) {
		UserEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserEntrySoap[] toSoapModels(List<UserEntry> models) {
		List<UserEntrySoap> soapModels = new ArrayList<UserEntrySoap>(
			models.size());

		for (UserEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserEntrySoap[soapModels.size()]);
	}

	public UserEntrySoap() {
	}

	public long getPrimaryKey() {
		return _userEntryId;
	}

	public void setPrimaryKey(long pk) {
		setUserEntryId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserEntryId() {
		return _userEntryId;
	}

	public void setUserEntryId(long userEntryId) {
		_userEntryId = userEntryId;
	}

	public String getHomePhone() {
		return _homePhone;
	}

	public void setHomePhone(String homePhone) {
		_homePhone = homePhone;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _userEntryId;
	private String _homePhone;
	private String _mobilePhone;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private String _zipCode;
	private long _userId;

}