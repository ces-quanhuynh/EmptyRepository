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

import com.liferay.newsletter.model.IssueArticle;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the issue article service. This utility wraps <code>com.liferay.newsletter.service.persistence.impl.IssueArticlePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author quanhuynhces
 * @see IssueArticlePersistence
 * @generated
 */
public class IssueArticleUtil {

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
	public static void clearCache(IssueArticle issueArticle) {
		getPersistence().clearCache(issueArticle);
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
	public static Map<Serializable, IssueArticle> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<IssueArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IssueArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IssueArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<IssueArticle> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static IssueArticle update(IssueArticle issueArticle) {
		return getPersistence().update(issueArticle);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static IssueArticle update(
		IssueArticle issueArticle, ServiceContext serviceContext) {

		return getPersistence().update(issueArticle, serviceContext);
	}

	/**
	 * Returns all the issue articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching issue articles
	 */
	public static List<IssueArticle> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<IssueArticle> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<IssueArticle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IssueArticle> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<IssueArticle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IssueArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue article
	 * @throws NoSuchIssueArticleException if a matching issue article could not be found
	 */
	public static IssueArticle findByUuid_First(
			String uuid, OrderByComparator<IssueArticle> orderByComparator)
		throws com.liferay.newsletter.exception.NoSuchIssueArticleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue article, or <code>null</code> if a matching issue article could not be found
	 */
	public static IssueArticle fetchByUuid_First(
		String uuid, OrderByComparator<IssueArticle> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue article
	 * @throws NoSuchIssueArticleException if a matching issue article could not be found
	 */
	public static IssueArticle findByUuid_Last(
			String uuid, OrderByComparator<IssueArticle> orderByComparator)
		throws com.liferay.newsletter.exception.NoSuchIssueArticleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue article, or <code>null</code> if a matching issue article could not be found
	 */
	public static IssueArticle fetchByUuid_Last(
		String uuid, OrderByComparator<IssueArticle> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the issue articles before and after the current issue article in the ordered set where uuid = &#63;.
	 *
	 * @param issueArticleId the primary key of the current issue article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next issue article
	 * @throws NoSuchIssueArticleException if a issue article with the primary key could not be found
	 */
	public static IssueArticle[] findByUuid_PrevAndNext(
			long issueArticleId, String uuid,
			OrderByComparator<IssueArticle> orderByComparator)
		throws com.liferay.newsletter.exception.NoSuchIssueArticleException {

		return getPersistence().findByUuid_PrevAndNext(
			issueArticleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the issue articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of issue articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching issue articles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the issue article in the entity cache if it is enabled.
	 *
	 * @param issueArticle the issue article
	 */
	public static void cacheResult(IssueArticle issueArticle) {
		getPersistence().cacheResult(issueArticle);
	}

	/**
	 * Caches the issue articles in the entity cache if it is enabled.
	 *
	 * @param issueArticles the issue articles
	 */
	public static void cacheResult(List<IssueArticle> issueArticles) {
		getPersistence().cacheResult(issueArticles);
	}

	/**
	 * Creates a new issue article with the primary key. Does not add the issue article to the database.
	 *
	 * @param issueArticleId the primary key for the new issue article
	 * @return the new issue article
	 */
	public static IssueArticle create(long issueArticleId) {
		return getPersistence().create(issueArticleId);
	}

	/**
	 * Removes the issue article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article that was removed
	 * @throws NoSuchIssueArticleException if a issue article with the primary key could not be found
	 */
	public static IssueArticle remove(long issueArticleId)
		throws com.liferay.newsletter.exception.NoSuchIssueArticleException {

		return getPersistence().remove(issueArticleId);
	}

	public static IssueArticle updateImpl(IssueArticle issueArticle) {
		return getPersistence().updateImpl(issueArticle);
	}

	/**
	 * Returns the issue article with the primary key or throws a <code>NoSuchIssueArticleException</code> if it could not be found.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article
	 * @throws NoSuchIssueArticleException if a issue article with the primary key could not be found
	 */
	public static IssueArticle findByPrimaryKey(long issueArticleId)
		throws com.liferay.newsletter.exception.NoSuchIssueArticleException {

		return getPersistence().findByPrimaryKey(issueArticleId);
	}

	/**
	 * Returns the issue article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article, or <code>null</code> if a issue article with the primary key could not be found
	 */
	public static IssueArticle fetchByPrimaryKey(long issueArticleId) {
		return getPersistence().fetchByPrimaryKey(issueArticleId);
	}

	/**
	 * Returns all the issue articles.
	 *
	 * @return the issue articles
	 */
	public static List<IssueArticle> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<IssueArticle> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<IssueArticle> findAll(
		int start, int end, OrderByComparator<IssueArticle> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<IssueArticle> findAll(
		int start, int end, OrderByComparator<IssueArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the issue articles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of issue articles.
	 *
	 * @return the number of issue articles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IssueArticlePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<IssueArticlePersistence, IssueArticlePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(IssueArticlePersistence.class);

		ServiceTracker<IssueArticlePersistence, IssueArticlePersistence>
			serviceTracker =
				new ServiceTracker
					<IssueArticlePersistence, IssueArticlePersistence>(
						bundle.getBundleContext(),
						IssueArticlePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}