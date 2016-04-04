/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package hu.webtown.liferay.tvtracker.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import hu.webtown.liferay.tvtracker.NoSuchSeasonException;
import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.model.impl.SeasonImpl;
import hu.webtown.liferay.tvtracker.model.impl.SeasonModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the season service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see SeasonPersistence
 * @see SeasonUtil
 * @generated
 */
public class SeasonPersistenceImpl extends BasePersistenceImpl<Season>
	implements SeasonPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SeasonUtil} to access the season persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SeasonImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, SeasonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_T",
			new String[] { Long.class.getName(), Long.class.getName() },
			SeasonModelImpl.GROUPID_COLUMN_BITMASK |
			SeasonModelImpl.TVSHOWID_COLUMN_BITMASK |
			SeasonModelImpl.SEASONNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_T = new FinderPath(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_T",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the seasons where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @return the matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> findByG_T(long groupId, long tvShowId)
		throws SystemException {
		return findByG_T(groupId, tvShowId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the seasons where groupId = &#63; and tvShowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @param start the lower bound of the range of seasons
	 * @param end the upper bound of the range of seasons (not inclusive)
	 * @return the range of matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> findByG_T(long groupId, long tvShowId, int start,
		int end) throws SystemException {
		return findByG_T(groupId, tvShowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the seasons where groupId = &#63; and tvShowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @param start the lower bound of the range of seasons
	 * @param end the upper bound of the range of seasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> findByG_T(long groupId, long tvShowId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] { groupId, tvShowId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] {
					groupId, tvShowId,
					
					start, end, orderByComparator
				};
		}

		List<Season> list = (List<Season>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Season season : list) {
				if ((groupId != season.getGroupId()) ||
						(tvShowId != season.getTvShowId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SEASON_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SeasonModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(tvShowId);

				if (!pagination) {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Season>(list);
				}
				else {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first season in the ordered set where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching season
	 * @throws hu.webtown.liferay.tvtracker.NoSuchSeasonException if a matching season could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season findByG_T_First(long groupId, long tvShowId,
		OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByG_T_First(groupId, tvShowId, orderByComparator);

		if (season != null) {
			return season;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", tvShowId=");
		msg.append(tvShowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeasonException(msg.toString());
	}

	/**
	 * Returns the first season in the ordered set where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching season, or <code>null</code> if a matching season could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByG_T_First(long groupId, long tvShowId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Season> list = findByG_T(groupId, tvShowId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last season in the ordered set where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching season
	 * @throws hu.webtown.liferay.tvtracker.NoSuchSeasonException if a matching season could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season findByG_T_Last(long groupId, long tvShowId,
		OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByG_T_Last(groupId, tvShowId, orderByComparator);

		if (season != null) {
			return season;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", tvShowId=");
		msg.append(tvShowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeasonException(msg.toString());
	}

	/**
	 * Returns the last season in the ordered set where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching season, or <code>null</code> if a matching season could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByG_T_Last(long groupId, long tvShowId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_T(groupId, tvShowId);

		if (count == 0) {
			return null;
		}

		List<Season> list = findByG_T(groupId, tvShowId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the seasons before and after the current season in the ordered set where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param seasonId the primary key of the current season
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next season
	 * @throws hu.webtown.liferay.tvtracker.NoSuchSeasonException if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season[] findByG_T_PrevAndNext(long seasonId, long groupId,
		long tvShowId, OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		Season season = findByPrimaryKey(seasonId);

		Session session = null;

		try {
			session = openSession();

			Season[] array = new SeasonImpl[3];

			array[0] = getByG_T_PrevAndNext(session, season, groupId, tvShowId,
					orderByComparator, true);

			array[1] = season;

			array[2] = getByG_T_PrevAndNext(session, season, groupId, tvShowId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Season getByG_T_PrevAndNext(Session session, Season season,
		long groupId, long tvShowId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEASON_WHERE);

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SeasonModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(tvShowId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(season);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Season> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the seasons that the user has permission to view where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @return the matching seasons that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> filterFindByG_T(long groupId, long tvShowId)
		throws SystemException {
		return filterFindByG_T(groupId, tvShowId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the seasons that the user has permission to view where groupId = &#63; and tvShowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @param start the lower bound of the range of seasons
	 * @param end the upper bound of the range of seasons (not inclusive)
	 * @return the range of matching seasons that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> filterFindByG_T(long groupId, long tvShowId, int start,
		int end) throws SystemException {
		return filterFindByG_T(groupId, tvShowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the seasons that the user has permissions to view where groupId = &#63; and tvShowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @param start the lower bound of the range of seasons
	 * @param end the upper bound of the range of seasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching seasons that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> filterFindByG_T(long groupId, long tvShowId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_T(groupId, tvShowId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SEASON_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SEASON_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SEASON_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SeasonModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SeasonModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Season.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SeasonImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SeasonImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(tvShowId);

			return (List<Season>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the seasons before and after the current season in the ordered set of seasons that the user has permission to view where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param seasonId the primary key of the current season
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next season
	 * @throws hu.webtown.liferay.tvtracker.NoSuchSeasonException if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season[] filterFindByG_T_PrevAndNext(long seasonId, long groupId,
		long tvShowId, OrderByComparator orderByComparator)
		throws NoSuchSeasonException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_T_PrevAndNext(seasonId, groupId, tvShowId,
				orderByComparator);
		}

		Season season = findByPrimaryKey(seasonId);

		Session session = null;

		try {
			session = openSession();

			Season[] array = new SeasonImpl[3];

			array[0] = filterGetByG_T_PrevAndNext(session, season, groupId,
					tvShowId, orderByComparator, true);

			array[1] = season;

			array[2] = filterGetByG_T_PrevAndNext(session, season, groupId,
					tvShowId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Season filterGetByG_T_PrevAndNext(Session session, Season season,
		long groupId, long tvShowId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SEASON_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SEASON_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SEASON_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SeasonModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SeasonModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Season.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, SeasonImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, SeasonImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(tvShowId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(season);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Season> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the seasons where groupId = &#63; and tvShowId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_T(long groupId, long tvShowId)
		throws SystemException {
		for (Season season : findByG_T(groupId, tvShowId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(season);
		}
	}

	/**
	 * Returns the number of seasons where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @return the number of matching seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_T(long groupId, long tvShowId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_T;

		Object[] finderArgs = new Object[] { groupId, tvShowId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEASON_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(tvShowId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of seasons that the user has permission to view where groupId = &#63; and tvShowId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tvShowId the tv show ID
	 * @return the number of matching seasons that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_T(long groupId, long tvShowId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_T(groupId, tvShowId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_SEASON_WHERE);

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_TVSHOWID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Season.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(tvShowId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_T_GROUPID_2 = "season.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_T_TVSHOWID_2 = "season.tvShowId = ?";

	public SeasonPersistenceImpl() {
		setModelClass(Season.class);
	}

	/**
	 * Caches the season in the entity cache if it is enabled.
	 *
	 * @param season the season
	 */
	@Override
	public void cacheResult(Season season) {
		EntityCacheUtil.putResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonImpl.class, season.getPrimaryKey(), season);

		season.resetOriginalValues();
	}

	/**
	 * Caches the seasons in the entity cache if it is enabled.
	 *
	 * @param seasons the seasons
	 */
	@Override
	public void cacheResult(List<Season> seasons) {
		for (Season season : seasons) {
			if (EntityCacheUtil.getResult(
						SeasonModelImpl.ENTITY_CACHE_ENABLED, SeasonImpl.class,
						season.getPrimaryKey()) == null) {
				cacheResult(season);
			}
			else {
				season.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all seasons.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SeasonImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SeasonImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the season.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Season season) {
		EntityCacheUtil.removeResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonImpl.class, season.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Season> seasons) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Season season : seasons) {
			EntityCacheUtil.removeResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
				SeasonImpl.class, season.getPrimaryKey());
		}
	}

	/**
	 * Creates a new season with the primary key. Does not add the season to the database.
	 *
	 * @param seasonId the primary key for the new season
	 * @return the new season
	 */
	@Override
	public Season create(long seasonId) {
		Season season = new SeasonImpl();

		season.setNew(true);
		season.setPrimaryKey(seasonId);

		return season;
	}

	/**
	 * Removes the season with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param seasonId the primary key of the season
	 * @return the season that was removed
	 * @throws hu.webtown.liferay.tvtracker.NoSuchSeasonException if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season remove(long seasonId)
		throws NoSuchSeasonException, SystemException {
		return remove((Serializable)seasonId);
	}

	/**
	 * Removes the season with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the season
	 * @return the season that was removed
	 * @throws hu.webtown.liferay.tvtracker.NoSuchSeasonException if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season remove(Serializable primaryKey)
		throws NoSuchSeasonException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Season season = (Season)session.get(SeasonImpl.class, primaryKey);

			if (season == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSeasonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(season);
		}
		catch (NoSuchSeasonException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Season removeImpl(Season season) throws SystemException {
		season = toUnwrappedModel(season);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(season)) {
				season = (Season)session.get(SeasonImpl.class,
						season.getPrimaryKeyObj());
			}

			if (season != null) {
				session.delete(season);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (season != null) {
			clearCache(season);
		}

		return season;
	}

	@Override
	public Season updateImpl(hu.webtown.liferay.tvtracker.model.Season season)
		throws SystemException {
		season = toUnwrappedModel(season);

		boolean isNew = season.isNew();

		SeasonModelImpl seasonModelImpl = (SeasonModelImpl)season;

		Session session = null;

		try {
			session = openSession();

			if (season.isNew()) {
				session.save(season);

				season.setNew(false);
			}
			else {
				session.merge(season);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SeasonModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((seasonModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						seasonModelImpl.getOriginalGroupId(),
						seasonModelImpl.getOriginalTvShowId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);

				args = new Object[] {
						seasonModelImpl.getGroupId(),
						seasonModelImpl.getTvShowId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);
			}
		}

		EntityCacheUtil.putResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
			SeasonImpl.class, season.getPrimaryKey(), season);

		return season;
	}

	protected Season toUnwrappedModel(Season season) {
		if (season instanceof SeasonImpl) {
			return season;
		}

		SeasonImpl seasonImpl = new SeasonImpl();

		seasonImpl.setNew(season.isNew());
		seasonImpl.setPrimaryKey(season.getPrimaryKey());

		seasonImpl.setSeasonId(season.getSeasonId());
		seasonImpl.setGroupId(season.getGroupId());
		seasonImpl.setCompanyId(season.getCompanyId());
		seasonImpl.setUserId(season.getUserId());
		seasonImpl.setUserName(season.getUserName());
		seasonImpl.setCreateDate(season.getCreateDate());
		seasonImpl.setModifiedDate(season.getModifiedDate());
		seasonImpl.setTitle(season.getTitle());
		seasonImpl.setPremierDate(season.getPremierDate());
		seasonImpl.setSeasonNumber(season.getSeasonNumber());
		seasonImpl.setDescription(season.getDescription());
		seasonImpl.setImageUrl(season.getImageUrl());
		seasonImpl.setImageUuid(season.getImageUuid());
		seasonImpl.setImageTitle(season.getImageTitle());
		seasonImpl.setImageVersion(season.getImageVersion());
		seasonImpl.setTvShowId(season.getTvShowId());

		return seasonImpl;
	}

	/**
	 * Returns the season with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the season
	 * @return the season
	 * @throws hu.webtown.liferay.tvtracker.NoSuchSeasonException if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSeasonException, SystemException {
		Season season = fetchByPrimaryKey(primaryKey);

		if (season == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSeasonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return season;
	}

	/**
	 * Returns the season with the primary key or throws a {@link hu.webtown.liferay.tvtracker.NoSuchSeasonException} if it could not be found.
	 *
	 * @param seasonId the primary key of the season
	 * @return the season
	 * @throws hu.webtown.liferay.tvtracker.NoSuchSeasonException if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season findByPrimaryKey(long seasonId)
		throws NoSuchSeasonException, SystemException {
		return findByPrimaryKey((Serializable)seasonId);
	}

	/**
	 * Returns the season with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the season
	 * @return the season, or <code>null</code> if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Season season = (Season)EntityCacheUtil.getResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
				SeasonImpl.class, primaryKey);

		if (season == _nullSeason) {
			return null;
		}

		if (season == null) {
			Session session = null;

			try {
				session = openSession();

				season = (Season)session.get(SeasonImpl.class, primaryKey);

				if (season != null) {
					cacheResult(season);
				}
				else {
					EntityCacheUtil.putResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
						SeasonImpl.class, primaryKey, _nullSeason);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SeasonModelImpl.ENTITY_CACHE_ENABLED,
					SeasonImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return season;
	}

	/**
	 * Returns the season with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param seasonId the primary key of the season
	 * @return the season, or <code>null</code> if a season with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Season fetchByPrimaryKey(long seasonId) throws SystemException {
		return fetchByPrimaryKey((Serializable)seasonId);
	}

	/**
	 * Returns all the seasons.
	 *
	 * @return the seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the seasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of seasons
	 * @param end the upper bound of the range of seasons (not inclusive)
	 * @return the range of seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the seasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of seasons
	 * @param end the upper bound of the range of seasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Season> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Season> list = (List<Season>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEASON);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEASON;

				if (pagination) {
					sql = sql.concat(SeasonModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Season>(list);
				}
				else {
					list = (List<Season>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the seasons from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Season season : findAll()) {
			remove(season);
		}
	}

	/**
	 * Returns the number of seasons.
	 *
	 * @return the number of seasons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEASON);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the season persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.webtown.liferay.tvtracker.model.Season")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Season>> listenersList = new ArrayList<ModelListener<Season>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Season>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SeasonImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEASON = "SELECT season FROM Season season";
	private static final String _SQL_SELECT_SEASON_WHERE = "SELECT season FROM Season season WHERE ";
	private static final String _SQL_COUNT_SEASON = "SELECT COUNT(season) FROM Season season";
	private static final String _SQL_COUNT_SEASON_WHERE = "SELECT COUNT(season) FROM Season season WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "season.seasonId";
	private static final String _FILTER_SQL_SELECT_SEASON_WHERE = "SELECT DISTINCT {season.*} FROM TvT_Season season WHERE ";
	private static final String _FILTER_SQL_SELECT_SEASON_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {TvT_Season.*} FROM (SELECT DISTINCT season.seasonId FROM TvT_Season season WHERE ";
	private static final String _FILTER_SQL_SELECT_SEASON_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN TvT_Season ON TEMP_TABLE.seasonId = TvT_Season.seasonId";
	private static final String _FILTER_SQL_COUNT_SEASON_WHERE = "SELECT COUNT(DISTINCT season.seasonId) AS COUNT_VALUE FROM TvT_Season season WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "season";
	private static final String _FILTER_ENTITY_TABLE = "TvT_Season";
	private static final String _ORDER_BY_ENTITY_ALIAS = "season.";
	private static final String _ORDER_BY_ENTITY_TABLE = "TvT_Season.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Season exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Season exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SeasonPersistenceImpl.class);
	private static Season _nullSeason = new SeasonImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Season> toCacheModel() {
				return _nullSeasonCacheModel;
			}
		};

	private static CacheModel<Season> _nullSeasonCacheModel = new CacheModel<Season>() {
			@Override
			public Season toEntityModel() {
				return _nullSeason;
			}
		};
}