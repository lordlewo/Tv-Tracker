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

import com.liferay.portal.service.persistence.BasePersistence;

import hu.webtown.liferay.tvtracker.model.Episode;

/**
 * The persistence interface for the episode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see EpisodePersistenceImpl
 * @see EpisodeUtil
 * @generated
 */
public interface EpisodePersistence extends BasePersistence<Episode> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EpisodeUtil} to access the episode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the episodes where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findByG_S(
		long groupId, long seasonId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findByG_S(
		long groupId, long seasonId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.webtown.liferay.tvtracker.model.Episode findByG_S_First(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException;

	/**
	* Returns the first episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.tvtracker.model.Episode fetchByG_S_First(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.webtown.liferay.tvtracker.model.Episode findByG_S_Last(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException;

	/**
	* Returns the last episode in the ordered set where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching episode, or <code>null</code> if a matching episode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.tvtracker.model.Episode fetchByG_S_Last(
		long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.webtown.liferay.tvtracker.model.Episode[] findByG_S_PrevAndNext(
		long episodeId, long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException;

	/**
	* Returns all the episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> filterFindByG_S(
		long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> filterFindByG_S(
		long groupId, long seasonId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> filterFindByG_S(
		long groupId, long seasonId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.webtown.liferay.tvtracker.model.Episode[] filterFindByG_S_PrevAndNext(
		long episodeId, long groupId, long seasonId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException;

	/**
	* Removes all the episodes where groupId = &#63; and seasonId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the number of matching episodes
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes that the user has permission to view where groupId = &#63; and seasonId = &#63;.
	*
	* @param groupId the group ID
	* @param seasonId the season ID
	* @return the number of matching episodes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_S(long groupId, long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the episode in the entity cache if it is enabled.
	*
	* @param episode the episode
	*/
	public void cacheResult(hu.webtown.liferay.tvtracker.model.Episode episode);

	/**
	* Caches the episodes in the entity cache if it is enabled.
	*
	* @param episodes the episodes
	*/
	public void cacheResult(
		java.util.List<hu.webtown.liferay.tvtracker.model.Episode> episodes);

	/**
	* Creates a new episode with the primary key. Does not add the episode to the database.
	*
	* @param episodeId the primary key for the new episode
	* @return the new episode
	*/
	public hu.webtown.liferay.tvtracker.model.Episode create(long episodeId);

	/**
	* Removes the episode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param episodeId the primary key of the episode
	* @return the episode that was removed
	* @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.tvtracker.model.Episode remove(long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException;

	public hu.webtown.liferay.tvtracker.model.Episode updateImpl(
		hu.webtown.liferay.tvtracker.model.Episode episode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the episode with the primary key or throws a {@link hu.webtown.liferay.tvtracker.NoSuchEpisodeException} if it could not be found.
	*
	* @param episodeId the primary key of the episode
	* @return the episode
	* @throws hu.webtown.liferay.tvtracker.NoSuchEpisodeException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.tvtracker.model.Episode findByPrimaryKey(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchEpisodeException;

	/**
	* Returns the episode with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param episodeId the primary key of the episode
	* @return the episode, or <code>null</code> if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.webtown.liferay.tvtracker.model.Episode fetchByPrimaryKey(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the episodes.
	*
	* @return the episodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the episodes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of episodes.
	*
	* @return the number of episodes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}