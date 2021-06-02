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

package com.liferay.newsletter.service.persistence.impl;

import com.liferay.newsletter.exception.NoSuchIssueArticleException;
import com.liferay.newsletter.model.IssueArticle;
import com.liferay.newsletter.model.impl.IssueArticleImpl;
import com.liferay.newsletter.model.impl.IssueArticleModelImpl;
import com.liferay.newsletter.service.persistence.IssueArticlePersistence;
import com.liferay.newsletter.service.persistence.impl.constants.NLPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the issue article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author quanhuynhces
 * @generated
 */
@Component(service = IssueArticlePersistence.class)
public class IssueArticlePersistenceImpl
	extends BasePersistenceImpl<IssueArticle>
	implements IssueArticlePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IssueArticleUtil</code> to access the issue article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IssueArticleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the issue articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching issue articles
	 */
	@Override
	public List<IssueArticle> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<IssueArticle> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<IssueArticle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IssueArticle> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<IssueArticle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IssueArticle> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<IssueArticle> list = null;

		if (useFinderCache) {
			list = (List<IssueArticle>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IssueArticle issueArticle : list) {
					if (!uuid.equals(issueArticle.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ISSUEARTICLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IssueArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<IssueArticle>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue article
	 * @throws NoSuchIssueArticleException if a matching issue article could not be found
	 */
	@Override
	public IssueArticle findByUuid_First(
			String uuid, OrderByComparator<IssueArticle> orderByComparator)
		throws NoSuchIssueArticleException {

		IssueArticle issueArticle = fetchByUuid_First(uuid, orderByComparator);

		if (issueArticle != null) {
			return issueArticle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIssueArticleException(sb.toString());
	}

	/**
	 * Returns the first issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue article, or <code>null</code> if a matching issue article could not be found
	 */
	@Override
	public IssueArticle fetchByUuid_First(
		String uuid, OrderByComparator<IssueArticle> orderByComparator) {

		List<IssueArticle> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue article
	 * @throws NoSuchIssueArticleException if a matching issue article could not be found
	 */
	@Override
	public IssueArticle findByUuid_Last(
			String uuid, OrderByComparator<IssueArticle> orderByComparator)
		throws NoSuchIssueArticleException {

		IssueArticle issueArticle = fetchByUuid_Last(uuid, orderByComparator);

		if (issueArticle != null) {
			return issueArticle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIssueArticleException(sb.toString());
	}

	/**
	 * Returns the last issue article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue article, or <code>null</code> if a matching issue article could not be found
	 */
	@Override
	public IssueArticle fetchByUuid_Last(
		String uuid, OrderByComparator<IssueArticle> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<IssueArticle> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IssueArticle[] findByUuid_PrevAndNext(
			long issueArticleId, String uuid,
			OrderByComparator<IssueArticle> orderByComparator)
		throws NoSuchIssueArticleException {

		uuid = Objects.toString(uuid, "");

		IssueArticle issueArticle = findByPrimaryKey(issueArticleId);

		Session session = null;

		try {
			session = openSession();

			IssueArticle[] array = new IssueArticleImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, issueArticle, uuid, orderByComparator, true);

			array[1] = issueArticle;

			array[2] = getByUuid_PrevAndNext(
				session, issueArticle, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IssueArticle getByUuid_PrevAndNext(
		Session session, IssueArticle issueArticle, String uuid,
		OrderByComparator<IssueArticle> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ISSUEARTICLE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(IssueArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(issueArticle)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IssueArticle> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the issue articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (IssueArticle issueArticle :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(issueArticle);
		}
	}

	/**
	 * Returns the number of issue articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching issue articles
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ISSUEARTICLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"issueArticle.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(issueArticle.uuid IS NULL OR issueArticle.uuid = '')";

	public IssueArticlePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("order", "order_");

		setDBColumnNames(dbColumnNames);

		setModelClass(IssueArticle.class);

		setModelImplClass(IssueArticleImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the issue article in the entity cache if it is enabled.
	 *
	 * @param issueArticle the issue article
	 */
	@Override
	public void cacheResult(IssueArticle issueArticle) {
		entityCache.putResult(
			entityCacheEnabled, IssueArticleImpl.class,
			issueArticle.getPrimaryKey(), issueArticle);

		issueArticle.resetOriginalValues();
	}

	/**
	 * Caches the issue articles in the entity cache if it is enabled.
	 *
	 * @param issueArticles the issue articles
	 */
	@Override
	public void cacheResult(List<IssueArticle> issueArticles) {
		for (IssueArticle issueArticle : issueArticles) {
			if (entityCache.getResult(
					entityCacheEnabled, IssueArticleImpl.class,
					issueArticle.getPrimaryKey()) == null) {

				cacheResult(issueArticle);
			}
			else {
				issueArticle.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all issue articles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IssueArticleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the issue article.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IssueArticle issueArticle) {
		entityCache.removeResult(
			entityCacheEnabled, IssueArticleImpl.class,
			issueArticle.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<IssueArticle> issueArticles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (IssueArticle issueArticle : issueArticles) {
			entityCache.removeResult(
				entityCacheEnabled, IssueArticleImpl.class,
				issueArticle.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, IssueArticleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new issue article with the primary key. Does not add the issue article to the database.
	 *
	 * @param issueArticleId the primary key for the new issue article
	 * @return the new issue article
	 */
	@Override
	public IssueArticle create(long issueArticleId) {
		IssueArticle issueArticle = new IssueArticleImpl();

		issueArticle.setNew(true);
		issueArticle.setPrimaryKey(issueArticleId);

		String uuid = PortalUUIDUtil.generate();

		issueArticle.setUuid(uuid);

		return issueArticle;
	}

	/**
	 * Removes the issue article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article that was removed
	 * @throws NoSuchIssueArticleException if a issue article with the primary key could not be found
	 */
	@Override
	public IssueArticle remove(long issueArticleId)
		throws NoSuchIssueArticleException {

		return remove((Serializable)issueArticleId);
	}

	/**
	 * Removes the issue article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the issue article
	 * @return the issue article that was removed
	 * @throws NoSuchIssueArticleException if a issue article with the primary key could not be found
	 */
	@Override
	public IssueArticle remove(Serializable primaryKey)
		throws NoSuchIssueArticleException {

		Session session = null;

		try {
			session = openSession();

			IssueArticle issueArticle = (IssueArticle)session.get(
				IssueArticleImpl.class, primaryKey);

			if (issueArticle == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIssueArticleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(issueArticle);
		}
		catch (NoSuchIssueArticleException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected IssueArticle removeImpl(IssueArticle issueArticle) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(issueArticle)) {
				issueArticle = (IssueArticle)session.get(
					IssueArticleImpl.class, issueArticle.getPrimaryKeyObj());
			}

			if (issueArticle != null) {
				session.delete(issueArticle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (issueArticle != null) {
			clearCache(issueArticle);
		}

		return issueArticle;
	}

	@Override
	public IssueArticle updateImpl(IssueArticle issueArticle) {
		boolean isNew = issueArticle.isNew();

		if (!(issueArticle instanceof IssueArticleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(issueArticle.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					issueArticle);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in issueArticle proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom IssueArticle implementation " +
					issueArticle.getClass());
		}

		IssueArticleModelImpl issueArticleModelImpl =
			(IssueArticleModelImpl)issueArticle;

		if (Validator.isNull(issueArticle.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			issueArticle.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(issueArticle);

				issueArticle.setNew(false);
			}
			else {
				issueArticle = (IssueArticle)session.merge(issueArticle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {issueArticleModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((issueArticleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					issueArticleModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {issueArticleModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, IssueArticleImpl.class,
			issueArticle.getPrimaryKey(), issueArticle, false);

		issueArticle.resetOriginalValues();

		return issueArticle;
	}

	/**
	 * Returns the issue article with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the issue article
	 * @return the issue article
	 * @throws NoSuchIssueArticleException if a issue article with the primary key could not be found
	 */
	@Override
	public IssueArticle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIssueArticleException {

		IssueArticle issueArticle = fetchByPrimaryKey(primaryKey);

		if (issueArticle == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIssueArticleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return issueArticle;
	}

	/**
	 * Returns the issue article with the primary key or throws a <code>NoSuchIssueArticleException</code> if it could not be found.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article
	 * @throws NoSuchIssueArticleException if a issue article with the primary key could not be found
	 */
	@Override
	public IssueArticle findByPrimaryKey(long issueArticleId)
		throws NoSuchIssueArticleException {

		return findByPrimaryKey((Serializable)issueArticleId);
	}

	/**
	 * Returns the issue article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueArticleId the primary key of the issue article
	 * @return the issue article, or <code>null</code> if a issue article with the primary key could not be found
	 */
	@Override
	public IssueArticle fetchByPrimaryKey(long issueArticleId) {
		return fetchByPrimaryKey((Serializable)issueArticleId);
	}

	/**
	 * Returns all the issue articles.
	 *
	 * @return the issue articles
	 */
	@Override
	public List<IssueArticle> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<IssueArticle> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<IssueArticle> findAll(
		int start, int end, OrderByComparator<IssueArticle> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<IssueArticle> findAll(
		int start, int end, OrderByComparator<IssueArticle> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<IssueArticle> list = null;

		if (useFinderCache) {
			list = (List<IssueArticle>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ISSUEARTICLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ISSUEARTICLE;

				sql = sql.concat(IssueArticleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<IssueArticle>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the issue articles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (IssueArticle issueArticle : findAll()) {
			remove(issueArticle);
		}
	}

	/**
	 * Returns the number of issue articles.
	 *
	 * @return the number of issue articles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ISSUEARTICLE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "issueArticleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ISSUEARTICLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IssueArticleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the issue article persistence.
	 */
	@Activate
	public void activate() {
		IssueArticleModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		IssueArticleModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IssueArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IssueArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IssueArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IssueArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			IssueArticleModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(IssueArticleImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = NLPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.newsletter.model.IssueArticle"),
			true);
	}

	@Override
	@Reference(
		target = NLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = NLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ISSUEARTICLE =
		"SELECT issueArticle FROM IssueArticle issueArticle";

	private static final String _SQL_SELECT_ISSUEARTICLE_WHERE =
		"SELECT issueArticle FROM IssueArticle issueArticle WHERE ";

	private static final String _SQL_COUNT_ISSUEARTICLE =
		"SELECT COUNT(issueArticle) FROM IssueArticle issueArticle";

	private static final String _SQL_COUNT_ISSUEARTICLE_WHERE =
		"SELECT COUNT(issueArticle) FROM IssueArticle issueArticle WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "issueArticle.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No IssueArticle exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No IssueArticle exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IssueArticlePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "order"});

}