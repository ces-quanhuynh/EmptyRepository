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

package com.liferay.registration.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.registration.model.UserEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the user entry service. This utility wraps <code>com.liferay.registration.service.persistence.impl.UserEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author quanhuynh
 * @see UserEntryPersistence
 * @generated
 */
public class UserEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserEntry userEntry) {
		getPersistence().clearCache(userEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UserEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserEntry update(UserEntry userEntry) {
		return getPersistence().update(userEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserEntry update(
		UserEntry userEntry, ServiceContext serviceContext) {

		return getPersistence().update(userEntry, serviceContext);
	}

	/**
	 * Returns all the user entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user entries
	 */
	public static List<UserEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @return the range of matching user entries
	 */
	public static List<UserEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user entries
	 */
	public static List<UserEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user entries
	 */
	public static List<UserEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user entry
	 * @throws NoSuchUserEntryException if a matching user entry could not be found
	 */
	public static UserEntry findByUuid_First(
			String uuid, OrderByComparator<UserEntry> orderByComparator)
		throws com.liferay.registration.exception.NoSuchUserEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user entry, or <code>null</code> if a matching user entry could not be found
	 */
	public static UserEntry fetchByUuid_First(
		String uuid, OrderByComparator<UserEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user entry
	 * @throws NoSuchUserEntryException if a matching user entry could not be found
	 */
	public static UserEntry findByUuid_Last(
			String uuid, OrderByComparator<UserEntry> orderByComparator)
		throws com.liferay.registration.exception.NoSuchUserEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user entry, or <code>null</code> if a matching user entry could not be found
	 */
	public static UserEntry fetchByUuid_Last(
		String uuid, OrderByComparator<UserEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user entries before and after the current user entry in the ordered set where uuid = &#63;.
	 *
	 * @param userEntryId the primary key of the current user entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user entry
	 * @throws NoSuchUserEntryException if a user entry with the primary key could not be found
	 */
	public static UserEntry[] findByUuid_PrevAndNext(
			long userEntryId, String uuid,
			OrderByComparator<UserEntry> orderByComparator)
		throws com.liferay.registration.exception.NoSuchUserEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			userEntryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the user entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the user entry in the entity cache if it is enabled.
	 *
	 * @param userEntry the user entry
	 */
	public static void cacheResult(UserEntry userEntry) {
		getPersistence().cacheResult(userEntry);
	}

	/**
	 * Caches the user entries in the entity cache if it is enabled.
	 *
	 * @param userEntries the user entries
	 */
	public static void cacheResult(List<UserEntry> userEntries) {
		getPersistence().cacheResult(userEntries);
	}

	/**
	 * Creates a new user entry with the primary key. Does not add the user entry to the database.
	 *
	 * @param userEntryId the primary key for the new user entry
	 * @return the new user entry
	 */
	public static UserEntry create(long userEntryId) {
		return getPersistence().create(userEntryId);
	}

	/**
	 * Removes the user entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userEntryId the primary key of the user entry
	 * @return the user entry that was removed
	 * @throws NoSuchUserEntryException if a user entry with the primary key could not be found
	 */
	public static UserEntry remove(long userEntryId)
		throws com.liferay.registration.exception.NoSuchUserEntryException {

		return getPersistence().remove(userEntryId);
	}

	public static UserEntry updateImpl(UserEntry userEntry) {
		return getPersistence().updateImpl(userEntry);
	}

	/**
	 * Returns the user entry with the primary key or throws a <code>NoSuchUserEntryException</code> if it could not be found.
	 *
	 * @param userEntryId the primary key of the user entry
	 * @return the user entry
	 * @throws NoSuchUserEntryException if a user entry with the primary key could not be found
	 */
	public static UserEntry findByPrimaryKey(long userEntryId)
		throws com.liferay.registration.exception.NoSuchUserEntryException {

		return getPersistence().findByPrimaryKey(userEntryId);
	}

	/**
	 * Returns the user entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userEntryId the primary key of the user entry
	 * @return the user entry, or <code>null</code> if a user entry with the primary key could not be found
	 */
	public static UserEntry fetchByPrimaryKey(long userEntryId) {
		return getPersistence().fetchByPrimaryKey(userEntryId);
	}

	/**
	 * Returns all the user entries.
	 *
	 * @return the user entries
	 */
	public static List<UserEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @return the range of user entries
	 */
	public static List<UserEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user entries
	 */
	public static List<UserEntry> findAll(
		int start, int end, OrderByComparator<UserEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user entries
	 */
	public static List<UserEntry> findAll(
		int start, int end, OrderByComparator<UserEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user entries.
	 *
	 * @return the number of user entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserEntryPersistence, UserEntryPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserEntryPersistence.class);

		ServiceTracker<UserEntryPersistence, UserEntryPersistence>
			serviceTracker =
				new ServiceTracker<UserEntryPersistence, UserEntryPersistence>(
					bundle.getBundleContext(), UserEntryPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}