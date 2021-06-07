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

package com.liferay.newsletter.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for IssueArticle. This utility wraps
 * <code>com.liferay.newsletter.service.impl.IssueArticleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author quanhuynhces
 * @see IssueArticleLocalService
 * @generated
 */
public class IssueArticleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.newsletter.service.impl.IssueArticleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the issue article to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IssueArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param issueArticle the issue article
	 * @return the issue article that was added
	 */
	public static com.liferay.newsletter.model.IssueArticle addIssueArticle(
		com.liferay.newsletter.model.IssueArticle issueArticle) {

		return getService().addIssueArticle(issueArticle);
	}

	/**
	 * Creates a new issue article with the primary key. Does not add the issue article to the database.
	 *
	 * @param issueArticleId the primary key for the new issue article
	 * @return the new issue article
	 */
	public static com.liferay.newsletter.model.IssueArticle createIssueArticle(
		long issueArticleId) {

		return getService().createIssueArticle(issueArticleId);
	}

	/**
	 * Deletes the issue article from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IssueArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param issueArticle the issue article
	 * @return the issue article that was removed
	 */
	public static com.liferay.newsletter.model.IssueArticle deleteIssueArticle(
		com.liferay.newsletter.model.IssueArticle issueArticle) {

		return getService().deleteIssueArticle(issueArticle);
	}

	/**
	 * Deletes the issue article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IssueArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article that was removed
	 * @throws PortalException if a issue article with the primary key could not be found
	 */
	public static com.liferay.newsletter.model.IssueArticle deleteIssueArticle(
			long issueArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteIssueArticle(issueArticleId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.newsletter.model.impl.IssueArticleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.newsletter.model.impl.IssueArticleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.newsletter.model.IssueArticle fetchIssueArticle(
		long issueArticleId) {

		return getService().fetchIssueArticle(issueArticleId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.newsletter.model.IssueArticle>
			getAllIssueArticles(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return getService().getAllIssueArticles(groupId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the issue article with the primary key.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article
	 * @throws PortalException if a issue article with the primary key could not be found
	 */
	public static com.liferay.newsletter.model.IssueArticle getIssueArticle(
			long issueArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getIssueArticle(issueArticleId);
	}

	public static com.liferay.newsletter.model.IssueArticle getIssueArticle(
			long groupId, String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return getService().getIssueArticle(groupId, articleId);
	}

	/**
	 * Returns a range of all the issue articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.newsletter.model.impl.IssueArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issue articles
	 * @param end the upper bound of the range of issue articles (not inclusive)
	 * @return the range of issue articles
	 */
	public static java.util.List<com.liferay.newsletter.model.IssueArticle>
		getIssueArticles(int start, int end) {

		return getService().getIssueArticles(start, end);
	}

	/**
	 * Returns the number of issue articles.
	 *
	 * @return the number of issue articles
	 */
	public static int getIssueArticlesCount() {
		return getService().getIssueArticlesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int haveIssueArticle(
		com.liferay.journal.model.JournalArticle journalArticle,
		java.util.List<com.liferay.journal.model.JournalArticle>
			journalArticles) {

		return getService().haveIssueArticle(journalArticle, journalArticles);
	}

	/**
	 * Updates the issue article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IssueArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param issueArticle the issue article
	 * @return the issue article that was updated
	 */
	public static com.liferay.newsletter.model.IssueArticle updateIssueArticle(
		com.liferay.newsletter.model.IssueArticle issueArticle) {

		return getService().updateIssueArticle(issueArticle);
	}

	public static IssueArticleLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<IssueArticleLocalService, IssueArticleLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(IssueArticleLocalService.class);

		ServiceTracker<IssueArticleLocalService, IssueArticleLocalService>
			serviceTracker =
				new ServiceTracker
					<IssueArticleLocalService, IssueArticleLocalService>(
						bundle.getBundleContext(),
						IssueArticleLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}