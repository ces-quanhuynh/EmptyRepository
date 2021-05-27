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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserEntry}.
 * </p>
 *
 * @author quanhuynh
 * @see UserEntry
 * @generated
 */
public class UserEntryWrapper
	extends BaseModelWrapper<UserEntry>
	implements ModelWrapper<UserEntry>, UserEntry {

	public UserEntryWrapper(UserEntry userEntry) {
		super(userEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("userEntryId", getUserEntryId());
		attributes.put("homePhone", getHomePhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zipCode", getZipCode());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userEntryId = (Long)attributes.get("userEntryId");

		if (userEntryId != null) {
			setUserEntryId(userEntryId);
		}

		String homePhone = (String)attributes.get("homePhone");

		if (homePhone != null) {
			setHomePhone(homePhone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	 * Returns the address1 of this user entry.
	 *
	 * @return the address1 of this user entry
	 */
	@Override
	public String getAddress1() {
		return model.getAddress1();
	}

	/**
	 * Returns the address2 of this user entry.
	 *
	 * @return the address2 of this user entry
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the city of this user entry.
	 *
	 * @return the city of this user entry
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the home phone of this user entry.
	 *
	 * @return the home phone of this user entry
	 */
	@Override
	public String getHomePhone() {
		return model.getHomePhone();
	}

	/**
	 * Returns the mobile phone of this user entry.
	 *
	 * @return the mobile phone of this user entry
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the mvcc version of this user entry.
	 *
	 * @return the mvcc version of this user entry
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this user entry.
	 *
	 * @return the primary key of this user entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this user entry.
	 *
	 * @return the state of this user entry
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the user entry ID of this user entry.
	 *
	 * @return the user entry ID of this user entry
	 */
	@Override
	public long getUserEntryId() {
		return model.getUserEntryId();
	}

	/**
	 * Returns the user ID of this user entry.
	 *
	 * @return the user ID of this user entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this user entry.
	 *
	 * @return the user uuid of this user entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user entry.
	 *
	 * @return the uuid of this user entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the zip code of this user entry.
	 *
	 * @return the zip code of this user entry
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address1 of this user entry.
	 *
	 * @param address1 the address1 of this user entry
	 */
	@Override
	public void setAddress1(String address1) {
		model.setAddress1(address1);
	}

	/**
	 * Sets the address2 of this user entry.
	 *
	 * @param address2 the address2 of this user entry
	 */
	@Override
	public void setAddress2(String address2) {
		model.setAddress2(address2);
	}

	/**
	 * Sets the city of this user entry.
	 *
	 * @param city the city of this user entry
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the home phone of this user entry.
	 *
	 * @param homePhone the home phone of this user entry
	 */
	@Override
	public void setHomePhone(String homePhone) {
		model.setHomePhone(homePhone);
	}

	/**
	 * Sets the mobile phone of this user entry.
	 *
	 * @param mobilePhone the mobile phone of this user entry
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the mvcc version of this user entry.
	 *
	 * @param mvccVersion the mvcc version of this user entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this user entry.
	 *
	 * @param primaryKey the primary key of this user entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this user entry.
	 *
	 * @param state the state of this user entry
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the user entry ID of this user entry.
	 *
	 * @param userEntryId the user entry ID of this user entry
	 */
	@Override
	public void setUserEntryId(long userEntryId) {
		model.setUserEntryId(userEntryId);
	}

	/**
	 * Sets the user ID of this user entry.
	 *
	 * @param userId the user ID of this user entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this user entry.
	 *
	 * @param userUuid the user uuid of this user entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user entry.
	 *
	 * @param uuid the uuid of this user entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the zip code of this user entry.
	 *
	 * @param zipCode the zip code of this user entry
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected UserEntryWrapper wrap(UserEntry userEntry) {
		return new UserEntryWrapper(userEntry);
	}

}