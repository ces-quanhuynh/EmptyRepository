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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.registration.exception.NoSuchUserEntryException;
import com.liferay.registration.model.UserEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author quanhuynh
 * @see UserEntryUtil
 * @generated
 */
@ProviderType
public interface UserEntryPersistence extends BasePersistence<UserEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserEntryUtil} to access the user entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user entries
	 */
	public java.util.List<UserEntry> findByUuid(String uuid);

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
	public java.util.List<UserEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<UserEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEntry>
			orderByComparator);

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
	public java.util.List<UserEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user entry
	 * @throws NoSuchUserEntryException if a matching user entry could not be found
	 */
	public UserEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserEntry>
				orderByComparator)
		throws NoSuchUserEntryException;

	/**
	 * Returns the first user entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user entry, or <code>null</code> if a matching user entry could not be found
	 */
	public UserEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserEntry>
			orderByComparator);

	/**
	 * Returns the last user entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user entry
	 * @throws NoSuchUserEntryException if a matching user entry could not be found
	 */
	public UserEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserEntry>
				orderByComparator)
		throws NoSuchUserEntryException;

	/**
	 * Returns the last user entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user entry, or <code>null</code> if a matching user entry could not be found
	 */
	public UserEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserEntry>
			orderByComparator);

	/**
	 * Returns the user entries before and after the current user entry in the ordered set where uuid = &#63;.
	 *
	 * @param userEntryId the primary key of the current user entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user entry
	 * @throws NoSuchUserEntryException if a user entry with the primary key could not be found
	 */
	public UserEntry[] findByUuid_PrevAndNext(
			long userEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserEntry>
				orderByComparator)
		throws NoSuchUserEntryException;

	/**
	 * Removes all the user entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the user entry in the entity cache if it is enabled.
	 *
	 * @param userEntry the user entry
	 */
	public void cacheResult(UserEntry userEntry);

	/**
	 * Caches the user entries in the entity cache if it is enabled.
	 *
	 * @param userEntries the user entries
	 */
	public void cacheResult(java.util.List<UserEntry> userEntries);

	/**
	 * Creates a new user entry with the primary key. Does not add the user entry to the database.
	 *
	 * @param userEntryId the primary key for the new user entry
	 * @return the new user entry
	 */
	public UserEntry create(long userEntryId);

	/**
	 * Removes the user entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userEntryId the primary key of the user entry
	 * @return the user entry that was removed
	 * @throws NoSuchUserEntryException if a user entry with the primary key could not be found
	 */
	public UserEntry remove(long userEntryId) throws NoSuchUserEntryException;

	public UserEntry updateImpl(UserEntry userEntry);

	/**
	 * Returns the user entry with the primary key or throws a <code>NoSuchUserEntryException</code> if it could not be found.
	 *
	 * @param userEntryId the primary key of the user entry
	 * @return the user entry
	 * @throws NoSuchUserEntryException if a user entry with the primary key could not be found
	 */
	public UserEntry findByPrimaryKey(long userEntryId)
		throws NoSuchUserEntryException;

	/**
	 * Returns the user entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userEntryId the primary key of the user entry
	 * @return the user entry, or <code>null</code> if a user entry with the primary key could not be found
	 */
	public UserEntry fetchByPrimaryKey(long userEntryId);

	/**
	 * Returns all the user entries.
	 *
	 * @return the user entries
	 */
	public java.util.List<UserEntry> findAll();

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
	public java.util.List<UserEntry> findAll(int start, int end);

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
	public java.util.List<UserEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEntry>
			orderByComparator);

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
	public java.util.List<UserEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user entries.
	 *
	 * @return the number of user entries
	 */
	public int countAll();

}