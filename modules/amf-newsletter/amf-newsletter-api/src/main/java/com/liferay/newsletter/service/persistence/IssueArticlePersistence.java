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

import com.liferay.newsletter.exception.NoSuchIssueArticleException;
import com.liferay.newsletter.model.IssueArticle;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the issue article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author quanhuynhces
 * @see IssueArticleUtil
 * @generated
 */
@ProviderType
public interface IssueArticlePersistence extends BasePersistence<IssueArticle> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IssueArticleUtil} to access the issue article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the issue articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching issue articles
	 */
	public java.util.List<IssueArticle> findByUuid(String uuid);

	/**
	 * Returns a range of all the issue articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issue articles
	 * @param end the upper bound of the range of issue articles (not inclusive)
	 * @return the range of matching issue articles
	 */
	public java.util.List<IssueArticle> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the issue articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issue articles
	 * @param end the upper bound of the range of issue articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching issue articles
	 */
	public java.util.List<IssueArticle> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IssueArticle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the issue articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issue articles
	 * @param end the upper bound of the range of issue articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching issue articles
	 */
	public java.util.List<IssueArticle> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IssueArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue article
	 * @throws NoSuchIssueArticleException if a matching issue article could not be found
	 */
	public IssueArticle findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IssueArticle>
				orderByComparator)
		throws NoSuchIssueArticleException;

	/**
	 * Returns the first issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue article, or <code>null</code> if a matching issue article could not be found
	 */
	public IssueArticle fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<IssueArticle>
			orderByComparator);

	/**
	 * Returns the last issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue article
	 * @throws NoSuchIssueArticleException if a matching issue article could not be found
	 */
	public IssueArticle findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IssueArticle>
				orderByComparator)
		throws NoSuchIssueArticleException;

	/**
	 * Returns the last issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue article, or <code>null</code> if a matching issue article could not be found
	 */
	public IssueArticle fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<IssueArticle>
			orderByComparator);

	/**
	 * Returns the issue articles before and after the current issue article in the ordered set where uuid = &#63;.
	 *
	 * @param issueArticleId the primary key of the current issue article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next issue article
	 * @throws NoSuchIssueArticleException if a issue article with the primary key could not be found
	 */
	public IssueArticle[] findByUuid_PrevAndNext(
			long issueArticleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IssueArticle>
				orderByComparator)
		throws NoSuchIssueArticleException;

	/**
	 * Removes all the issue articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of issue articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching issue articles
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the issue article in the entity cache if it is enabled.
	 *
	 * @param issueArticle the issue article
	 */
	public void cacheResult(IssueArticle issueArticle);

	/**
	 * Caches the issue articles in the entity cache if it is enabled.
	 *
	 * @param issueArticles the issue articles
	 */
	public void cacheResult(java.util.List<IssueArticle> issueArticles);

	/**
	 * Creates a new issue article with the primary key. Does not add the issue article to the database.
	 *
	 * @param issueArticleId the primary key for the new issue article
	 * @return the new issue article
	 */
	public IssueArticle create(long issueArticleId);

	/**
	 * Removes the issue article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article that was removed
	 * @throws NoSuchIssueArticleException if a issue article with the primary key could not be found
	 */
	public IssueArticle remove(long issueArticleId)
		throws NoSuchIssueArticleException;

	public IssueArticle updateImpl(IssueArticle issueArticle);

	/**
	 * Returns the issue article with the primary key or throws a <code>NoSuchIssueArticleException</code> if it could not be found.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article
	 * @throws NoSuchIssueArticleException if a issue article with the primary key could not be found
	 */
	public IssueArticle findByPrimaryKey(long issueArticleId)
		throws NoSuchIssueArticleException;

	/**
	 * Returns the issue article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article, or <code>null</code> if a issue article with the primary key could not be found
	 */
	public IssueArticle fetchByPrimaryKey(long issueArticleId);

	/**
	 * Returns all the issue articles.
	 *
	 * @return the issue articles
	 */
	public java.util.List<IssueArticle> findAll();

	/**
	 * Returns a range of all the issue articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issue articles
	 * @param end the upper bound of the range of issue articles (not inclusive)
	 * @return the range of issue articles
	 */
	public java.util.List<IssueArticle> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the issue articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issue articles
	 * @param end the upper bound of the range of issue articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of issue articles
	 */
	public java.util.List<IssueArticle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IssueArticle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the issue articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issue articles
	 * @param end the upper bound of the range of issue articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of issue articles
	 */
	public java.util.List<IssueArticle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IssueArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the issue articles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of issue articles.
	 *
	 * @return the number of issue articles
	 */
	public int countAll();

}