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

package com.liferay.newsletter.service.persistence;

import com.liferay.newsletter.exception.NoSuchIssueException;
import com.liferay.newsletter.model.Issue;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the issue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author quanhuynhces
 * @see IssueUtil
 * @generated
 */
@ProviderType
public interface IssuePersistence extends BasePersistence<Issue> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IssueUtil} to access the issue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching issues
	 */
	public java.util.List<Issue> findByUuid(String uuid);

	/**
	 * Returns a range of all the issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @return the range of matching issues
	 */
	public java.util.List<Issue> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching issues
	 */
	public java.util.List<Issue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issue>
			orderByComparator);

	/**
	 * Returns an ordered range of all the issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching issues
	 */
	public java.util.List<Issue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue
	 * @throws NoSuchIssueException if a matching issue could not be found
	 */
	public Issue findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Issue>
				orderByComparator)
		throws NoSuchIssueException;

	/**
	 * Returns the first issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue, or <code>null</code> if a matching issue could not be found
	 */
	public Issue fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Issue>
			orderByComparator);

	/**
	 * Returns the last issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue
	 * @throws NoSuchIssueException if a matching issue could not be found
	 */
	public Issue findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Issue>
				orderByComparator)
		throws NoSuchIssueException;

	/**
	 * Returns the last issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue, or <code>null</code> if a matching issue could not be found
	 */
	public Issue fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Issue>
			orderByComparator);

	/**
	 * Returns the issues before and after the current issue in the ordered set where uuid = &#63;.
	 *
	 * @param issueId the primary key of the current issue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next issue
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	public Issue[] findByUuid_PrevAndNext(
			long issueId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Issue>
				orderByComparator)
		throws NoSuchIssueException;

	/**
	 * Removes all the issues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching issues
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the issue in the entity cache if it is enabled.
	 *
	 * @param issue the issue
	 */
	public void cacheResult(Issue issue);

	/**
	 * Caches the issues in the entity cache if it is enabled.
	 *
	 * @param issues the issues
	 */
	public void cacheResult(java.util.List<Issue> issues);

	/**
	 * Creates a new issue with the primary key. Does not add the issue to the database.
	 *
	 * @param issueId the primary key for the new issue
	 * @return the new issue
	 */
	public Issue create(long issueId);

	/**
	 * Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue that was removed
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	public Issue remove(long issueId) throws NoSuchIssueException;

	public Issue updateImpl(Issue issue);

	/**
	 * Returns the issue with the primary key or throws a <code>NoSuchIssueException</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	public Issue findByPrimaryKey(long issueId) throws NoSuchIssueException;

	/**
	 * Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue, or <code>null</code> if a issue with the primary key could not be found
	 */
	public Issue fetchByPrimaryKey(long issueId);

	/**
	 * Returns all the issues.
	 *
	 * @return the issues
	 */
	public java.util.List<Issue> findAll();

	/**
	 * Returns a range of all the issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @return the range of issues
	 */
	public java.util.List<Issue> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of issues
	 */
	public java.util.List<Issue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issue>
			orderByComparator);

	/**
	 * Returns an ordered range of all the issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of issues
	 */
	public java.util.List<Issue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the issues from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of issues.
	 *
	 * @return the number of issues
	 */
	public int countAll();

}