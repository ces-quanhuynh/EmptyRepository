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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IssueArticleLocalService}.
 *
 * @author quanhuynhces
 * @see IssueArticleLocalService
 * @generated
 */
public class IssueArticleLocalServiceWrapper
	implements IssueArticleLocalService,
			   ServiceWrapper<IssueArticleLocalService> {

	public IssueArticleLocalServiceWrapper(
		IssueArticleLocalService issueArticleLocalService) {

		_issueArticleLocalService = issueArticleLocalService;
	}

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
	@Override
	public com.liferay.newsletter.model.IssueArticle addIssueArticle(
		com.liferay.newsletter.model.IssueArticle issueArticle) {

		return _issueArticleLocalService.addIssueArticle(issueArticle);
	}

	/**
	 * Creates a new issue article with the primary key. Does not add the issue article to the database.
	 *
	 * @param issueArticleId the primary key for the new issue article
	 * @return the new issue article
	 */
	@Override
	public com.liferay.newsletter.model.IssueArticle createIssueArticle(
		long issueArticleId) {

		return _issueArticleLocalService.createIssueArticle(issueArticleId);
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
	@Override
	public com.liferay.newsletter.model.IssueArticle deleteIssueArticle(
		com.liferay.newsletter.model.IssueArticle issueArticle) {

		return _issueArticleLocalService.deleteIssueArticle(issueArticle);
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
	@Override
	public com.liferay.newsletter.model.IssueArticle deleteIssueArticle(
			long issueArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _issueArticleLocalService.deleteIssueArticle(issueArticleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _issueArticleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _issueArticleLocalService.dynamicQuery();
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

		return _issueArticleLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _issueArticleLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _issueArticleLocalService.dynamicQuery(
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

		return _issueArticleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _issueArticleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.newsletter.model.IssueArticle fetchIssueArticle(
		long issueArticleId) {

		return _issueArticleLocalService.fetchIssueArticle(issueArticleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _issueArticleLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.newsletter.model.IssueArticle>
			getAllIssueArticles(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _issueArticleLocalService.getAllIssueArticles(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _issueArticleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the issue article with the primary key.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article
	 * @throws PortalException if a issue article with the primary key could not be found
	 */
	@Override
	public com.liferay.newsletter.model.IssueArticle getIssueArticle(
			long issueArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _issueArticleLocalService.getIssueArticle(issueArticleId);
	}

	@Override
	public com.liferay.newsletter.model.IssueArticle getIssueArticle(
			long groupId, String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _issueArticleLocalService.getIssueArticle(groupId, articleId);
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
	@Override
	public java.util.List<com.liferay.newsletter.model.IssueArticle>
		getIssueArticles(int start, int end) {

		return _issueArticleLocalService.getIssueArticles(start, end);
	}

	/**
	 * Returns the number of issue articles.
	 *
	 * @return the number of issue articles
	 */
	@Override
	public int getIssueArticlesCount() {
		return _issueArticleLocalService.getIssueArticlesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _issueArticleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _issueArticleLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int haveIssueArticle(
		com.liferay.journal.model.JournalArticle journalArticle,
		java.util.List<com.liferay.journal.model.JournalArticle>
			journalArticles) {

		return _issueArticleLocalService.haveIssueArticle(
			journalArticle, journalArticles);
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
	@Override
	public com.liferay.newsletter.model.IssueArticle updateIssueArticle(
		com.liferay.newsletter.model.IssueArticle issueArticle) {

		return _issueArticleLocalService.updateIssueArticle(issueArticle);
	}

	@Override
	public IssueArticleLocalService getWrappedService() {
		return _issueArticleLocalService;
	}

	@Override
	public void setWrappedService(
		IssueArticleLocalService issueArticleLocalService) {

		_issueArticleLocalService = issueArticleLocalService;
	}

	private IssueArticleLocalService _issueArticleLocalService;

}