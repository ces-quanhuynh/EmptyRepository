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

package com.liferay.registration.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserEntryLocalService}.
 *
 * @author quanhuynh
 * @see UserEntryLocalService
 * @generated
 */
public class UserEntryLocalServiceWrapper
	implements ServiceWrapper<UserEntryLocalService>, UserEntryLocalService {

	public UserEntryLocalServiceWrapper(
		UserEntryLocalService userEntryLocalService) {

		_userEntryLocalService = userEntryLocalService;
	}

	@Override
	public com.liferay.registration.model.UserEntry addUserEntry(
			long creatorUserId, long companyId, boolean autoPassword,
			String password1, String password2, boolean autoScreenName,
			String screenName, String emailAddress, long facebookId,
			String openId, java.util.Locale locale, String firstName,
			String middleName, String lastName, long prefixId, long suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear,
			String jobTitle, long[] groupIds, long[] organizationIds,
			long[] roleIds, long[] userGroupIds, boolean sendEmail,
			String homePhone, String mobilePhone, String address1,
			String address2, String city, String state, String zipCode,
			String securityQuestion, String securityAnswer,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEntryLocalService.addUserEntry(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, homePhone,
			mobilePhone, address1, address2, city, state, zipCode,
			securityQuestion, securityAnswer, serviceContext);
	}

	/**
	 * Adds the user entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEntry the user entry
	 * @return the user entry that was added
	 */
	@Override
	public com.liferay.registration.model.UserEntry addUserEntry(
		com.liferay.registration.model.UserEntry userEntry) {

		return _userEntryLocalService.addUserEntry(userEntry);
	}

	/**
	 * Creates a new user entry with the primary key. Does not add the user entry to the database.
	 *
	 * @param userEntryId the primary key for the new user entry
	 * @return the new user entry
	 */
	@Override
	public com.liferay.registration.model.UserEntry createUserEntry(
		long userEntryId) {

		return _userEntryLocalService.createUserEntry(userEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEntryId the primary key of the user entry
	 * @return the user entry that was removed
	 * @throws PortalException if a user entry with the primary key could not be found
	 */
	@Override
	public com.liferay.registration.model.UserEntry deleteUserEntry(
			long userEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEntryLocalService.deleteUserEntry(userEntryId);
	}

	/**
	 * Deletes the user entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEntry the user entry
	 * @return the user entry that was removed
	 */
	@Override
	public com.liferay.registration.model.UserEntry deleteUserEntry(
		com.liferay.registration.model.UserEntry userEntry) {

		return _userEntryLocalService.deleteUserEntry(userEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.registration.model.impl.UserEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.registration.model.impl.UserEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _userEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.registration.model.UserEntry fetchUserEntry(
		long userEntryId) {

		return _userEntryLocalService.fetchUserEntry(userEntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the user entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.registration.model.impl.UserEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @return the range of user entries
	 */
	@Override
	public java.util.List<com.liferay.registration.model.UserEntry>
		getUserEntries(int start, int end) {

		return _userEntryLocalService.getUserEntries(start, end);
	}

	/**
	 * Returns the number of user entries.
	 *
	 * @return the number of user entries
	 */
	@Override
	public int getUserEntriesCount() {
		return _userEntryLocalService.getUserEntriesCount();
	}

	/**
	 * Returns the user entry with the primary key.
	 *
	 * @param userEntryId the primary key of the user entry
	 * @return the user entry
	 * @throws PortalException if a user entry with the primary key could not be found
	 */
	@Override
	public com.liferay.registration.model.UserEntry getUserEntry(
			long userEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEntryLocalService.getUserEntry(userEntryId);
	}

	/**
	 * Updates the user entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEntry the user entry
	 * @return the user entry that was updated
	 */
	@Override
	public com.liferay.registration.model.UserEntry updateUserEntry(
		com.liferay.registration.model.UserEntry userEntry) {

		return _userEntryLocalService.updateUserEntry(userEntry);
	}

	@Override
	public UserEntryLocalService getWrappedService() {
		return _userEntryLocalService;
	}

	@Override
	public void setWrappedService(UserEntryLocalService userEntryLocalService) {
		_userEntryLocalService = userEntryLocalService;
	}

	private UserEntryLocalService _userEntryLocalService;

}