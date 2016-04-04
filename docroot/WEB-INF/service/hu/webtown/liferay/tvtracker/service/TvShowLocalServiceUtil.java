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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for TvShow. This utility wraps
 * {@link hu.webtown.liferay.tvtracker.service.impl.TvShowLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author czeni
 * @see TvShowLocalService
 * @see hu.webtown.liferay.tvtracker.service.base.TvShowLocalServiceBaseImpl
 * @see hu.webtown.liferay.tvtracker.service.impl.TvShowLocalServiceImpl
 * @generated
 */
public class TvShowLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.webtown.liferay.tvtracker.service.impl.TvShowLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tv show to the database. Also notifies the appropriate model listeners.
	*
	* @param tvShow the tv show
	* @return the tv show that was added
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow addTvShow(
		hu.webtown.liferay.tvtracker.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTvShow(tvShow);
	}

	/**
	* Creates a new tv show with the primary key. Does not add the tv show to the database.
	*
	* @param tvShowId the primary key for the new tv show
	* @return the new tv show
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow createTvShow(
		long tvShowId) {
		return getService().createTvShow(tvShowId);
	}

	/**
	* Deletes the tv show with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show that was removed
	* @throws PortalException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow deleteTvShow(
		long tvShowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTvShow(tvShowId);
	}

	/**
	* Deletes the tv show from the database. Also notifies the appropriate model listeners.
	*
	* @param tvShow the tv show
	* @return the tv show that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow deleteTvShow(
		hu.webtown.liferay.tvtracker.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTvShow(tvShow);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static hu.webtown.liferay.tvtracker.model.TvShow fetchTvShow(
		long tvShowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTvShow(tvShowId);
	}

	/**
	* Returns the tv show with the primary key.
	*
	* @param tvShowId the primary key of the tv show
	* @return the tv show
	* @throws PortalException if a tv show with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow getTvShow(
		long tvShowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTvShow(tvShowId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTvShows(start, end);
	}

	/**
	* Returns the number of tv shows.
	*
	* @return the number of tv shows
	* @throws SystemException if a system exception occurred
	*/
	public static int getTvShowsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTvShowsCount();
	}

	/**
	* Updates the tv show in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tvShow the tv show
	* @return the tv show that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static hu.webtown.liferay.tvtracker.model.TvShow updateTvShow(
		hu.webtown.liferay.tvtracker.model.TvShow tvShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTvShow(tvShow);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTvShows(serviceContext);
	}

	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> getTvShows(
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTvShows(serviceContext, start, end);
	}

	public static int getTvShowsCount(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTvShowsCount(serviceContext);
	}

	public static hu.webtown.liferay.tvtracker.model.TvShow addTvShow(
		java.lang.String title, java.util.Date premierDate,
		java.lang.String description, java.lang.String imageUrl,
		java.lang.String imageUuid, java.lang.String imageTitle,
		java.lang.String imageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTvShow(title, premierDate, description, imageUrl,
			imageUuid, imageTitle, imageVersion, serviceContext);
	}

	public static hu.webtown.liferay.tvtracker.model.TvShow updateTvShow(
		long tvShowId, java.lang.String title, java.util.Date premierDate,
		java.lang.String description, java.lang.String imageUrl,
		java.lang.String imageUuid, java.lang.String imageTitle,
		java.lang.String imageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTvShow(tvShowId, title, premierDate, description,
			imageUrl, imageUuid, imageTitle, imageVersion, serviceContext);
	}

	public static hu.webtown.liferay.tvtracker.model.TvShow deleteTvShow(
		long tvShowId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTvShow(tvShowId, serviceContext);
	}

	public static hu.webtown.liferay.tvtracker.model.TvShow deleteTvShowWithSeasons(
		long tvShowId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTvShowWithSeasons(tvShowId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TvShowLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TvShowLocalService.class.getName());

			if (invokableLocalService instanceof TvShowLocalService) {
				_service = (TvShowLocalService)invokableLocalService;
			}
			else {
				_service = new TvShowLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TvShowLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TvShowLocalService service) {
	}

	private static TvShowLocalService _service;
}