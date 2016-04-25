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

package hu.webtown.liferay.tvtracker.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SeasonLocalService}.
 *
 * @author czeni
 * @see SeasonLocalService
 * @generated
 */
public class SeasonLocalServiceWrapper implements SeasonLocalService,
	ServiceWrapper<SeasonLocalService> {
	public SeasonLocalServiceWrapper(SeasonLocalService seasonLocalService) {
		_seasonLocalService = seasonLocalService;
	}

	/**
	* Adds the season to the database. Also notifies the appropriate model listeners.
	*
	* @param season the season
	* @return the season that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Season addSeason(
		hu.webtown.liferay.tvtracker.model.Season season)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.addSeason(season);
	}

	/**
	* Creates a new season with the primary key. Does not add the season to the database.
	*
	* @param seasonId the primary key for the new season
	* @return the new season
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Season createSeason(long seasonId) {
		return _seasonLocalService.createSeason(seasonId);
	}

	/**
	* Deletes the season with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param seasonId the primary key of the season
	* @return the season that was removed
	* @throws PortalException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Season deleteSeason(long seasonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.deleteSeason(seasonId);
	}

	/**
	* Deletes the season from the database. Also notifies the appropriate model listeners.
	*
	* @param season the season
	* @return the season that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Season deleteSeason(
		hu.webtown.liferay.tvtracker.model.Season season)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.deleteSeason(season);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _seasonLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.SeasonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Season fetchSeason(long seasonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.fetchSeason(seasonId);
	}

	/**
	* Returns the season with the primary key.
	*
	* @param seasonId the primary key of the season
	* @return the season
	* @throws PortalException if a season with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Season getSeason(long seasonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeason(seasonId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<hu.webtown.liferay.tvtracker.model.Season> getSeasons(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasons(start, end);
	}

	/**
	* Returns the number of seasons.
	*
	* @return the number of seasons
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSeasonsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasonsCount();
	}

	/**
	* Updates the season in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param season the season
	* @return the season that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Season updateSeason(
		hu.webtown.liferay.tvtracker.model.Season season)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.updateSeason(season);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _seasonLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_seasonLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _seasonLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Season getSeason(long seasonId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchSeasonException {
		return _seasonLocalService.getSeason(seasonId, serviceContext);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Season> getSeasons(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasons(serviceContext);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Season> getSeasons(
		long tvShowId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasons(tvShowId, serviceContext);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Season> getSeasons(
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasons(serviceContext, start, end);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Season> getSeasons(
		long tvShowId,
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasons(tvShowId, serviceContext, start,
			end);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Season> getSeasons(
		com.liferay.portal.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasons(serviceContext, orderByComparator);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Season> getSeasons(
		long tvShowId,
		com.liferay.portal.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasons(tvShowId, serviceContext,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Season> getSeasons(
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasons(serviceContext, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Season> getSeasons(
		long tvShowId,
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasons(tvShowId, serviceContext, start,
			end, orderByComparator);
	}

	@Override
	public int getSeasonsCount(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasonsCount(serviceContext);
	}

	@Override
	public int getSeasonsCount(long tvShowId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.getSeasonsCount(tvShowId, serviceContext);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Season addSeason(long tvShowId,
		java.lang.String title, java.util.Date premierDate, int seasonNumber,
		java.lang.String description, java.lang.String imageUrl,
		java.lang.String imageUuid, java.lang.String imageTitle,
		java.lang.String imageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.addSeason(tvShowId, title, premierDate,
			seasonNumber, description, imageUrl, imageUuid, imageTitle,
			imageVersion, serviceContext);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Season updateSeason(
		long tvShowId, long seasonId, java.lang.String title,
		java.util.Date premierDate, int seasonNumber,
		java.lang.String description, java.lang.String imageUrl,
		java.lang.String imageUuid, java.lang.String imageTitle,
		java.lang.String imageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.updateSeason(tvShowId, seasonId, title,
			premierDate, seasonNumber, description, imageUrl, imageUuid,
			imageTitle, imageVersion, serviceContext);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Season deleteSeason(
		long seasonId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seasonLocalService.deleteSeason(seasonId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SeasonLocalService getWrappedSeasonLocalService() {
		return _seasonLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSeasonLocalService(
		SeasonLocalService seasonLocalService) {
		_seasonLocalService = seasonLocalService;
	}

	@Override
	public SeasonLocalService getWrappedService() {
		return _seasonLocalService;
	}

	@Override
	public void setWrappedService(SeasonLocalService seasonLocalService) {
		_seasonLocalService = seasonLocalService;
	}

	private SeasonLocalService _seasonLocalService;
}