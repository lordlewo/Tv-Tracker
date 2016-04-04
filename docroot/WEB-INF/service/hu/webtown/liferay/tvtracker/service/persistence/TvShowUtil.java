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

import hu.webtown.liferay.tvtracker.model.TvShow;

import java.util.List;

/**
 * The persistence utility for the tv show service. This utility wraps {@link TvShowPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author czeni
 * @see TvShowPersistence
 * @see TvShowPersistenceImpl
 * @generated
 */
public class TvShowUtil {
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
	public static void clearCache(TvShow tvShow) {
		getPersistence().clearCache(tvShow);
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
	public static List<TvShow> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TvShow> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TvShow> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TvShow update(TvShow tvShow) throws SystemException {
		return getPersistence().update(tvShow);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TvShow update(TvShow tvShow, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tvShow, serviceContext);
	}

	/**
	* Returns all the tv shows where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the tv shows where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @return the range of matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the tv shows where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first tv show in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tv show
	* @throws hu.webtown.liferay.tvtracker.NoSuchTvShowException if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchTvShowException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first tv show in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tv show, or <code>null</code> if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last tv show in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tv show
	* @throws hu.webtown.liferay.tvtracker.NoSuchTvShowException if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchTvShowException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last tv show in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tv show, or <code>null</code> if a matching tv show could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the tv shows before and after the current tv show in the ordered set where groupId = &#63;.
	*
	* @param tvShowId the primary key of the current tv show
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tv show
	* @throws hu.webtown.liferay.tvtracker.NoSuchTvShowException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow[] findByGroupId_PrevAndNext(
		long tvShowId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchTvShowException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(tvShowId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the tv shows that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tv shows that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the tv shows that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @return the range of matching tv shows that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the tv shows that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tv shows that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the tv shows before and after the current tv show in the ordered set of tv shows that the user has permission to view where groupId = &#63;.
	*
	* @param tvShowId the primary key of the current tv show
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tv show
	* @throws hu.webtown.liferay.tvtracker.NoSuchTvShowException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow[] filterFindByGroupId_PrevAndNext(
		long tvShowId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchTvShowException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(tvShowId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the tv shows where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of tv shows where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tv shows
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of tv shows that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tv shows that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Caches the tv show in the entity cache if it is enabled.
	*
	* @param tvShow the tv show
	*/
	public static void cacheResult(
		hu.webtown.liferay.tvtracker.model.TvShow tvShow) {
		getPersistence().cacheResult(tvShow);
	}

	/**
	* Caches the tv shows in the entity cache if it is enabled.
	*
	* @param tvShows the tv shows
	*/
	public static void cacheResult(
		java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> tvShows) {
		getPersistence().cacheResult(tvShows);
	}

	/**
	* Creates a new tv show with the primary key. Does not add the tv show to the database.
	*
	* @param tvShowId the primary key for the new tv show
	* @return the new tv show
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow create(
		long tvShowId) {
		return getPersistence().create(tvShowId);
	}

	/**
	* Removes the tv show with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show that was removed
	* @throws hu.webtown.liferay.tvtracker.NoSuchTvShowException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow remove(
		long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchTvShowException {
		return getPersistence().remove(tvShowId);
	}

	public static hu.webtown.liferay.tvtracker.model.TvShow updateImpl(
		hu.webtown.liferay.tvtracker.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tvShow);
	}

	/**
	* Returns the tv show with the primary key or throws a {@link hu.webtown.liferay.tvtracker.NoSuchTvShowException} if it could not be found.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show
	* @throws hu.webtown.liferay.tvtracker.NoSuchTvShowException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow findByPrimaryKey(
		long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchTvShowException {
		return getPersistence().findByPrimaryKey(tvShowId);
	}

	/**
	* Returns the tv show with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show, or <code>null</code> if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow fetchByPrimaryKey(
		long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tvShowId);
	}

	/**
	* Returns all the tv shows.
	*
	* @return the tv shows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tv shows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @return the range of tv shows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tv shows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tv shows
	* @param end the upper bound of the range of tv shows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tv shows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tv shows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tv shows.
	*
	* @return the number of tv shows
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TvShowPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TvShowPersistence)PortletBeanLocatorUtil.locate(hu.webtown.liferay.tvtracker.service.ClpSerializer.getServletContextName(),
					TvShowPersistence.class.getName());

			ReferenceRegistry.registerReference(TvShowUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TvShowPersistence persistence) {
	}

	private static TvShowPersistence _persistence;
}