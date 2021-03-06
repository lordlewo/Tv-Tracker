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
 * Provides a wrapper for {@link TvShowLocalService}.
 *
 * @author czeni
 * @see TvShowLocalService
 * @generated
 */
public class TvShowLocalServiceWrapper implements TvShowLocalService,
	ServiceWrapper<TvShowLocalService> {
	public TvShowLocalServiceWrapper(TvShowLocalService tvShowLocalService) {
		_tvShowLocalService = tvShowLocalService;
	}

	/**
	* Adds the tv show to the database. Also notifies the appropriate model listeners.
	*
	* @param tvShow the tv show
	* @return the tv show that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow addTvShow(
		hu.webtown.liferay.tvtracker.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.addTvShow(tvShow);
	}

	/**
	* Creates a new tv show with the primary key. Does not add the tv show to the database.
	*
	* @param tvShowId the primary key for the new tv show
	* @return the new tv show
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow createTvShow(long tvShowId) {
		return _tvShowLocalService.createTvShow(tvShowId);
	}

	/**
	* Deletes the tv show with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show that was removed
	* @throws PortalException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow deleteTvShow(long tvShowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.deleteTvShow(tvShowId);
	}

	/**
	* Deletes the tv show from the database. Also notifies the appropriate model listeners.
	*
	* @param tvShow the tv show
	* @return the tv show that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow deleteTvShow(
		hu.webtown.liferay.tvtracker.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.deleteTvShow(tvShow);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tvShowLocalService.dynamicQuery();
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
		return _tvShowLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tvShowLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tvShowLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _tvShowLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tvShowLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow fetchTvShow(long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.fetchTvShow(tvShowId);
	}

	/**
	* Returns the tv show with the primary key.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show
	* @throws PortalException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws hu.webtown.liferay.tvtracker.NoSuchTvShowException
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow getTvShow(long tvShowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchTvShowException {
		return _tvShowLocalService.getTvShow(tvShowId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(start, end);
	}

	/**
	* Returns the number of tv shows.
	*
	* @return the number of tv shows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTvShowsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShowsCount();
	}

	/**
	* Updates the tv show in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tvShow the tv show
	* @return the tv show that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow updateTvShow(
		hu.webtown.liferay.tvtracker.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.updateTvShow(tvShow);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tvShowLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tvShowLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tvShowLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow getTvShow(long tvShowId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.webtown.liferay.tvtracker.NoSuchTvShowException {
		return _tvShowLocalService.getTvShow(tvShowId, serviceContext);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(serviceContext);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(serviceContext, start, end);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		com.liferay.portal.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(serviceContext, orderByComparator);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(serviceContext, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		int premierYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(premierYear, start, end);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		com.liferay.portal.service.ServiceContext serviceContext,
		int premierYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(serviceContext, premierYear,
			start, end);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		int premierYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(premierYear);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		com.liferay.portal.service.ServiceContext serviceContext,
		int premierYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShows(serviceContext, premierYear);
	}

	@Override
	public int getTvShowsCount(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.getTvShowsCount(serviceContext);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow addTvShow(
		java.lang.String title, java.util.Date premierDate,
		java.lang.String description, java.lang.String imageUrl,
		java.lang.String imageUuid, java.lang.String imageTitle,
		java.lang.String imageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.addTvShow(title, premierDate, description,
			imageUrl, imageUuid, imageTitle, imageVersion, serviceContext);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow updateTvShow(
		long tvShowId, java.lang.String title, java.util.Date premierDate,
		java.lang.String description, java.lang.String imageUrl,
		java.lang.String imageUuid, java.lang.String imageTitle,
		java.lang.String imageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.updateTvShow(tvShowId, title, premierDate,
			description, imageUrl, imageUuid, imageTitle, imageVersion,
			serviceContext);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow deleteTvShow(
		long tvShowId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.deleteTvShow(tvShowId, serviceContext);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow deleteTvShowWithSeasons(
		long tvShowId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tvShowLocalService.deleteTvShowWithSeasons(tvShowId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TvShowLocalService getWrappedTvShowLocalService() {
		return _tvShowLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTvShowLocalService(
		TvShowLocalService tvShowLocalService) {
		_tvShowLocalService = tvShowLocalService;
	}

	@Override
	public TvShowLocalService getWrappedService() {
		return _tvShowLocalService;
	}

	@Override
	public void setWrappedService(TvShowLocalService tvShowLocalService) {
		_tvShowLocalService = tvShowLocalService;
	}

	private TvShowLocalService _tvShowLocalService;
}