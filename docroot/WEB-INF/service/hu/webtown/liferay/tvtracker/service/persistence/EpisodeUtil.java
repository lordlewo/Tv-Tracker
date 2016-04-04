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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import hu.webtown.liferay.tvtracker.model.Episode;

import java.util.List;

/**
 * The persistence utility for the episode service. This utility wraps {@link EpisodePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see EpisodePersistence
 * @see EpisodePersistenceImpl
 * @generated
 */
public class EpisodeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Episode episode) {
		getPersistence().clearCache(episode);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Episode> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Episode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Episode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Episode update(Episode episode) throws SystemException {
		return getPersistence().update(episode);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Episode update(Episode episode, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(episode, serviceContext);
	}

	/**
	* Returns all the episodes where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, seasonId);
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
	public static java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findByG_S(
		long groupId, long seasonId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, seasonId, start, end);
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
	public static java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findByG_S(
		long groupId, long seasonId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S(groupId, seasonId, start, end, orderByComparator);
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
	public static hu.webtown.liferay.tvtracker.model.Episode findByG_S_First(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException {
		return getPersistence()
				   .findByG_S_First(groupId, seasonId, orderByComparator);
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
	public static hu.webtown.liferay.tvtracker.model.Episode fetchByG_S_First(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_First(groupId, seasonId, orderByComparator);
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
	public static hu.webtown.liferay.tvtracker.model.Episode findByG_S_Last(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException {
		return getPersistence()
				   .findByG_S_Last(groupId, seasonId, orderByComparator);
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
	public static hu.webtown.liferay.tvtracker.model.Episode fetchByG_S_Last(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_Last(groupId, seasonId, orderByComparator);
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
	public static hu.webtown.liferay.tvtracker.model.Episode[] findByG_S_PrevAndNext(
		long episodeId, long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException {
		return getPersistence()
				   .findByG_S_PrevAndNext(episodeId, groupId, seasonId,
			orderByComparator);
	}

	/**
	* Returns all the episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.Episode> filterFindByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, seasonId);
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
	public static java.util.List<hu.webtown.liferay.tvtracker.model.Episode> filterFindByG_S(
		long groupId, long seasonId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, seasonId, start, end);
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
	public static java.util.List<hu.webtown.liferay.tvtracker.model.Episode> filterFindByG_S(
		long groupId, long seasonId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S(groupId, seasonId, start, end,
			orderByComparator);
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
	public static hu.webtown.liferay.tvtracker.model.Episode[] filterFindByG_S_PrevAndNext(
		long episodeId, long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException {
		return getPersistence()
				   .filterFindByG_S_PrevAndNext(episodeId, groupId, seasonId,
			orderByComparator);
	}

	/**
	* Removes all the episodes where groupId = &#63; and seasonId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S(groupId, seasonId);
	}

	/**
	* Returns the number of episodes where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S(groupId, seasonId);
	}

	/**
	* Returns the number of episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the number of matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_S(groupId, seasonId);
	}

	/**
	* Caches the episode in the entity cache if it is enabled.
	*
	* @param episode the episode
	*/
	public static void cacheResult(
		hu.webtown.liferay.tvtracker.model.Episode episode) {
		getPersistence().cacheResult(episode);
	}

	/**
	* Caches the episodes in the entity cache if it is enabled.
	*
	* @param episodes the episodes
	*/
	public static void cacheResult(
		java.util.List<hu.webtown.liferay.tvtracker.model.Episode> episodes) {
		getPersistence().cacheResult(episodes);
	}

	/**
	* Creates a new episode with the primary key. Does not add the episode to the database.
	*
	* @param episodeId the primary key for the new episode
	* @return the new episode
	*/
	public static hu.webtown.liferay.tvtracker.model.Episode create(
		long episodeId) {
		return getPersistence().create(episodeId);
	}

	/**
	* Removes the episode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param episodeId the primary key of the episode
	* @return the episode that was removed
	* @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.Episode remove(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException {
		return getPersistence().remove(episodeId);
	}

	public static hu.webtown.liferay.tvtracker.model.Episode updateImpl(
		hu.webtown.liferay.tvtracker.model.Episode episode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(episode);
	}

	/**
	* Returns the episode with the primary key or throws a {@link hu.webtown.liferay.tvtracker.NoSuchEpisodeException} if it could not be found.
	*
	* @param episodeId the primary key of the episode
	* @return the episode
	* @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.Episode findByPrimaryKey(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException {
		return getPersistence().findByPrimaryKey(episodeId);
	}

	/**
	* Returns the episode with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param episodeId the primary key of the episode
	* @return the episode, or <code>null</code> if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.Episode fetchByPrimaryKey(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(episodeId);
	}

	/**
	* Returns all the episodes.
	*
	* @return the episodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the episodes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of episodes.
	*
	* @return the number of episodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EpisodePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EpisodePersistence)PortletBeanLocatorUtil.locate(hu.webtown.liferay.tvtracker.service.ClpSerializer.getServletContextName(),
					EpisodePersistence.class.getName());

			ReferenceRegistry.registerReference(EpisodeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EpisodePersistence persistence) {
	}

	private static EpisodePersistence _persistence;
}