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

import hu.webtown.liferay.tvtracker.NoSuchEpisodeException;
import hu.webtown.liferay.tvtracker.model.Episode;
import hu.webtown.liferay.tvtracker.model.impl.EpisodeImpl;
import hu.webtown.liferay.tvtracker.model.impl.EpisodeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the episode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see EpisodePersistence
 * @see EpisodeUtil
 * @generated
 */
public class EpisodePersistenceImpl extends BasePersistenceImpl<Episode>
	implements EpisodePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EpisodeUtil} to access the episode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EpisodeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
			EpisodeModelImpl.FINDER_CACHE_ENABLED, EpisodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
			EpisodeModelImpl.FINDER_CACHE_ENABLED, EpisodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
			EpisodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
			EpisodeModelImpl.FINDER_CACHE_ENABLED, EpisodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
			EpisodeModelImpl.FINDER_CACHE_ENABLED, EpisodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] { Long.class.getName(), Long.class.getName() },
			EpisodeModelImpl.GROUPID_COLUMN_BITMASK |
			EpisodeModelImpl.SEASONID_COLUMN_BITMASK |
			EpisodeModelImpl.AIRDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
			EpisodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the episodes where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @return the matching episodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Episode> findByG_S(long groupId, long seasonId)
		throws SystemException {
		return findByG_S(groupId, seasonId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the episodes where groupId = &#63; and seasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @param start the lower bound of the range of episodes
	 * @param end the upper bound of the range of episodes (not inclusive)
	 * @return the range of matching episodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Episode> findByG_S(long groupId, long seasonId, int start,
		int end) throws SystemException {
		return findByG_S(groupId, seasonId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the episodes where groupId = &#63; and seasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @param start the lower bound of the range of episodes
	 * @param end the upper bound of the range of episodes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching episodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Episode> findByG_S(long groupId, long seasonId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] { groupId, seasonId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] {
					groupId, seasonId,
					
					start, end, orderByComparator
				};
		}

		List<Episode> list = (List<Episode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Episode episode : list) {
				if ((groupId != episode.getGroupId()) ||
						(seasonId != episode.getSeasonId())) {
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

			query.append(_SQL_SELECT_EPISODE_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_SEASONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EpisodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(seasonId);

				if (!pagination) {
					list = (List<Episode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Episode>(list);
				}
				else {
					list = (List<Episode>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching episode
	 * @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a matching episode could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode findByG_S_First(long groupId, long seasonId,
		OrderByComparator orderByComparator)
		throws NoSuchEpisodeException, SystemException {
		Episode episode = fetchByG_S_First(groupId, seasonId, orderByComparator);

		if (episode != null) {
			return episode;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", seasonId=");
		msg.append(seasonId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEpisodeException(msg.toString());
	}

	/**
	 * Returns the first episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching episode, or <code>null</code> if a matching episode could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode fetchByG_S_First(long groupId, long seasonId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Episode> list = findByG_S(groupId, seasonId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching episode
	 * @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a matching episode could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode findByG_S_Last(long groupId, long seasonId,
		OrderByComparator orderByComparator)
		throws NoSuchEpisodeException, SystemException {
		Episode episode = fetchByG_S_Last(groupId, seasonId, orderByComparator);

		if (episode != null) {
			return episode;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", seasonId=");
		msg.append(seasonId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEpisodeException(msg.toString());
	}

	/**
	 * Returns the last episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching episode, or <code>null</code> if a matching episode could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode fetchByG_S_Last(long groupId, long seasonId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_S(groupId, seasonId);

		if (count == 0) {
			return null;
		}

		List<Episode> list = findByG_S(groupId, seasonId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the episodes before and after the current episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param episodeId the primary key of the current episode
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next episode
	 * @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a episode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode[] findByG_S_PrevAndNext(long episodeId, long groupId,
		long seasonId, OrderByComparator orderByComparator)
		throws NoSuchEpisodeException, SystemException {
		Episode episode = findByPrimaryKey(episodeId);

		Session session = null;

		try {
			session = openSession();

			Episode[] array = new EpisodeImpl[3];

			array[0] = getByG_S_PrevAndNext(session, episode, groupId,
					seasonId, orderByComparator, true);

			array[1] = episode;

			array[2] = getByG_S_PrevAndNext(session, episode, groupId,
					seasonId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Episode getByG_S_PrevAndNext(Session session, Episode episode,
		long groupId, long seasonId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EPISODE_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_SEASONID_2);

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
			query.append(EpisodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(seasonId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(episode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Episode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @return the matching episodes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Episode> filterFindByG_S(long groupId, long seasonId)
		throws SystemException {
		return filterFindByG_S(groupId, seasonId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @param start the lower bound of the range of episodes
	 * @param end the upper bound of the range of episodes (not inclusive)
	 * @return the range of matching episodes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Episode> filterFindByG_S(long groupId, long seasonId,
		int start, int end) throws SystemException {
		return filterFindByG_S(groupId, seasonId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the episodes that the user has permissions to view where groupId = &#63; and seasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @param start the lower bound of the range of episodes
	 * @param end the upper bound of the range of episodes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching episodes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Episode> filterFindByG_S(long groupId, long seasonId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, seasonId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_EPISODE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EPISODE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_SEASONID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EPISODE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EpisodeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EpisodeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Episode.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, EpisodeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, EpisodeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(seasonId);

			return (List<Episode>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the episodes before and after the current episode in the ordered set of episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param episodeId the primary key of the current episode
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next episode
	 * @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a episode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode[] filterFindByG_S_PrevAndNext(long episodeId, long groupId,
		long seasonId, OrderByComparator orderByComparator)
		throws NoSuchEpisodeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(episodeId, groupId, seasonId,
				orderByComparator);
		}

		Episode episode = findByPrimaryKey(episodeId);

		Session session = null;

		try {
			session = openSession();

			Episode[] array = new EpisodeImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(session, episode, groupId,
					seasonId, orderByComparator, true);

			array[1] = episode;

			array[2] = filterGetByG_S_PrevAndNext(session, episode, groupId,
					seasonId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Episode filterGetByG_S_PrevAndNext(Session session,
		Episode episode, long groupId, long seasonId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EPISODE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EPISODE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_SEASONID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EPISODE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EpisodeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EpisodeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Episode.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, EpisodeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, EpisodeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(seasonId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(episode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Episode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the episodes where groupId = &#63; and seasonId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_S(long groupId, long seasonId)
		throws SystemException {
		for (Episode episode : findByG_S(groupId, seasonId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(episode);
		}
	}

	/**
	 * Returns the number of episodes where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @return the number of matching episodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_S(long groupId, long seasonId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

		Object[] finderArgs = new Object[] { groupId, seasonId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EPISODE_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_SEASONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(seasonId);

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
	 * Returns the number of episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param seasonId the season ID
	 * @return the number of matching episodes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_S(long groupId, long seasonId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, seasonId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_EPISODE_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_SEASONID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Episode.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(seasonId);

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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "episode.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_SEASONID_2 = "episode.seasonId = ?";

	public EpisodePersistenceImpl() {
		setModelClass(Episode.class);
	}

	/**
	 * Caches the episode in the entity cache if it is enabled.
	 *
	 * @param episode the episode
	 */
	@Override
	public void cacheResult(Episode episode) {
		EntityCacheUtil.putResult(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
			EpisodeImpl.class, episode.getPrimaryKey(), episode);

		episode.resetOriginalValues();
	}

	/**
	 * Caches the episodes in the entity cache if it is enabled.
	 *
	 * @param episodes the episodes
	 */
	@Override
	public void cacheResult(List<Episode> episodes) {
		for (Episode episode : episodes) {
			if (EntityCacheUtil.getResult(
						EpisodeModelImpl.ENTITY_CACHE_ENABLED,
						EpisodeImpl.class, episode.getPrimaryKey()) == null) {
				cacheResult(episode);
			}
			else {
				episode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all episodes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EpisodeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EpisodeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the episode.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Episode episode) {
		EntityCacheUtil.removeResult(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
			EpisodeImpl.class, episode.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Episode> episodes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Episode episode : episodes) {
			EntityCacheUtil.removeResult(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
				EpisodeImpl.class, episode.getPrimaryKey());
		}
	}

	/**
	 * Creates a new episode with the primary key. Does not add the episode to the database.
	 *
	 * @param episodeId the primary key for the new episode
	 * @return the new episode
	 */
	@Override
	public Episode create(long episodeId) {
		Episode episode = new EpisodeImpl();

		episode.setNew(true);
		episode.setPrimaryKey(episodeId);

		return episode;
	}

	/**
	 * Removes the episode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param episodeId the primary key of the episode
	 * @return the episode that was removed
	 * @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a episode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode remove(long episodeId)
		throws NoSuchEpisodeException, SystemException {
		return remove((Serializable)episodeId);
	}

	/**
	 * Removes the episode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the episode
	 * @return the episode that was removed
	 * @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a episode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode remove(Serializable primaryKey)
		throws NoSuchEpisodeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Episode episode = (Episode)session.get(EpisodeImpl.class, primaryKey);

			if (episode == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEpisodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(episode);
		}
		catch (NoSuchEpisodeException nsee) {
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
	protected Episode removeImpl(Episode episode) throws SystemException {
		episode = toUnwrappedModel(episode);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(episode)) {
				episode = (Episode)session.get(EpisodeImpl.class,
						episode.getPrimaryKeyObj());
			}

			if (episode != null) {
				session.delete(episode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (episode != null) {
			clearCache(episode);
		}

		return episode;
	}

	@Override
	public Episode updateImpl(
		hu.webtown.liferay.tvtracker.model.Episode episode)
		throws SystemException {
		episode = toUnwrappedModel(episode);

		boolean isNew = episode.isNew();

		EpisodeModelImpl episodeModelImpl = (EpisodeModelImpl)episode;

		Session session = null;

		try {
			session = openSession();

			if (episode.isNew()) {
				session.save(episode);

				episode.setNew(false);
			}
			else {
				session.merge(episode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EpisodeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((episodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						episodeModelImpl.getOriginalGroupId(),
						episodeModelImpl.getOriginalSeasonId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);

				args = new Object[] {
						episodeModelImpl.getGroupId(),
						episodeModelImpl.getSeasonId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);
			}
		}

		EntityCacheUtil.putResult(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
			EpisodeImpl.class, episode.getPrimaryKey(), episode);

		return episode;
	}

	protected Episode toUnwrappedModel(Episode episode) {
		if (episode instanceof EpisodeImpl) {
			return episode;
		}

		EpisodeImpl episodeImpl = new EpisodeImpl();

		episodeImpl.setNew(episode.isNew());
		episodeImpl.setPrimaryKey(episode.getPrimaryKey());

		episodeImpl.setEpisodeId(episode.getEpisodeId());
		episodeImpl.setGroupId(episode.getGroupId());
		episodeImpl.setCompanyId(episode.getCompanyId());
		episodeImpl.setUserId(episode.getUserId());
		episodeImpl.setUserName(episode.getUserName());
		episodeImpl.setCreateDate(episode.getCreateDate());
		episodeImpl.setModifiedDate(episode.getModifiedDate());
		episodeImpl.setTitle(episode.getTitle());
		episodeImpl.setAirDate(episode.getAirDate());
		episodeImpl.setEpisodeNumber(episode.getEpisodeNumber());
		episodeImpl.setDescription(episode.getDescription());
		episodeImpl.setImageUrl(episode.getImageUrl());
		episodeImpl.setImageUuid(episode.getImageUuid());
		episodeImpl.setImageTitle(episode.getImageTitle());
		episodeImpl.setImageVersion(episode.getImageVersion());
		episodeImpl.setSeasonId(episode.getSeasonId());

		return episodeImpl;
	}

	/**
	 * Returns the episode with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the episode
	 * @return the episode
	 * @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a episode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEpisodeException, SystemException {
		Episode episode = fetchByPrimaryKey(primaryKey);

		if (episode == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEpisodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return episode;
	}

	/**
	 * Returns the episode with the primary key or throws a {@link hu.webtown.liferay.tvtracker.NoSuchEpisodeException} if it could not be found.
	 *
	 * @param episodeId the primary key of the episode
	 * @return the episode
	 * @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a episode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode findByPrimaryKey(long episodeId)
		throws NoSuchEpisodeException, SystemException {
		return findByPrimaryKey((Serializable)episodeId);
	}

	/**
	 * Returns the episode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the episode
	 * @return the episode, or <code>null</code> if a episode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Episode episode = (Episode)EntityCacheUtil.getResult(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
				EpisodeImpl.class, primaryKey);

		if (episode == _nullEpisode) {
			return null;
		}

		if (episode == null) {
			Session session = null;

			try {
				session = openSession();

				episode = (Episode)session.get(EpisodeImpl.class, primaryKey);

				if (episode != null) {
					cacheResult(episode);
				}
				else {
					EntityCacheUtil.putResult(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
						EpisodeImpl.class, primaryKey, _nullEpisode);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EpisodeModelImpl.ENTITY_CACHE_ENABLED,
					EpisodeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return episode;
	}

	/**
	 * Returns the episode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param episodeId the primary key of the episode
	 * @return the episode, or <code>null</code> if a episode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Episode fetchByPrimaryKey(long episodeId) throws SystemException {
		return fetchByPrimaryKey((Serializable)episodeId);
	}

	/**
	 * Returns all the episodes.
	 *
	 * @return the episodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Episode> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the episodes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of episodes
	 * @param end the upper bound of the range of episodes (not inclusive)
	 * @return the range of episodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Episode> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the episodes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of episodes
	 * @param end the upper bound of the range of episodes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of episodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Episode> findAll(int start, int end,
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

		List<Episode> list = (List<Episode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EPISODE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EPISODE;

				if (pagination) {
					sql = sql.concat(EpisodeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Episode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Episode>(list);
				}
				else {
					list = (List<Episode>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the episodes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Episode episode : findAll()) {
			remove(episode);
		}
	}

	/**
	 * Returns the number of episodes.
	 *
	 * @return the number of episodes
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

				Query q = session.createQuery(_SQL_COUNT_EPISODE);

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
	 * Initializes the episode persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.webtown.liferay.tvtracker.model.Episode")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Episode>> listenersList = new ArrayList<ModelListener<Episode>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Episode>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EpisodeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EPISODE = "SELECT episode FROM Episode episode";
	private static final String _SQL_SELECT_EPISODE_WHERE = "SELECT episode FROM Episode episode WHERE ";
	private static final String _SQL_COUNT_EPISODE = "SELECT COUNT(episode) FROM Episode episode";
	private static final String _SQL_COUNT_EPISODE_WHERE = "SELECT COUNT(episode) FROM Episode episode WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "episode.episodeId";
	private static final String _FILTER_SQL_SELECT_EPISODE_WHERE = "SELECT DISTINCT {episode.*} FROM TvT_Episode episode WHERE ";
	private static final String _FILTER_SQL_SELECT_EPISODE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {TvT_Episode.*} FROM (SELECT DISTINCT episode.episodeId FROM TvT_Episode episode WHERE ";
	private static final String _FILTER_SQL_SELECT_EPISODE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN TvT_Episode ON TEMP_TABLE.episodeId = TvT_Episode.episodeId";
	private static final String _FILTER_SQL_COUNT_EPISODE_WHERE = "SELECT COUNT(DISTINCT episode.episodeId) AS COUNT_VALUE FROM TvT_Episode episode WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "episode";
	private static final String _FILTER_ENTITY_TABLE = "TvT_Episode";
	private static final String _ORDER_BY_ENTITY_ALIAS = "episode.";
	private static final String _ORDER_BY_ENTITY_TABLE = "TvT_Episode.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Episode exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Episode exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EpisodePersistenceImpl.class);
	private static Episode _nullEpisode = new EpisodeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Episode> toCacheModel() {
				return _nullEpisodeCacheModel;
			}
		};

	private static CacheModel<Episode> _nullEpisodeCacheModel = new CacheModel<Episode>() {
			@Override
			public Episode toEntityModel() {
				return _nullEpisode;
			}
		};
}