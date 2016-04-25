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
 * Provides a wrapper for {@link EpisodeLocalService}.
 *
 * @author czeni
 * @see EpisodeLocalService
 * @generated
 */
public class EpisodeLocalServiceWrapper implements EpisodeLocalService,
	ServiceWrapper<EpisodeLocalService> {
	public EpisodeLocalServiceWrapper(EpisodeLocalService episodeLocalService) {
		_episodeLocalService = episodeLocalService;
	}

	/**
	* Adds the episode to the database. Also notifies the appropriate model listeners.
	*
	* @param episode the episode
	* @return the episode that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Episode addEpisode(
		hu.webtown.liferay.tvtracker.model.Episode episode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.addEpisode(episode);
	}

	/**
	* Creates a new episode with the primary key. Does not add the episode to the database.
	*
	* @param episodeId the primary key for the new episode
	* @return the new episode
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Episode createEpisode(
		long episodeId) {
		return _episodeLocalService.createEpisode(episodeId);
	}

	/**
	* Deletes the episode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param episodeId the primary key of the episode
	* @return the episode that was removed
	* @throws PortalException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Episode deleteEpisode(
		long episodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.deleteEpisode(episodeId);
	}

	/**
	* Deletes the episode from the database. Also notifies the appropriate model listeners.
	*
	* @param episode the episode
	* @return the episode that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Episode deleteEpisode(
		hu.webtown.liferay.tvtracker.model.Episode episode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.deleteEpisode(episode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _episodeLocalService.dynamicQuery();
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
		return _episodeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _episodeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.webtown.liferay.tvtracker.model.impl.EpisodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _episodeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _episodeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _episodeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Episode fetchEpisode(
		long episodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.fetchEpisode(episodeId);
	}

	/**
	* Returns the episode with the primary key.
	*
	* @param episodeId the primary key of the episode
	* @return the episode
	* @throws PortalException if a episode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Episode getEpisode(long episodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisode(episodeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> getEpisodes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodes(start, end);
	}

	/**
	* Returns the number of episodes.
	*
	* @return the number of episodes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEpisodesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodesCount();
	}

	/**
	* Updates the episode in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param episode the episode
	* @return the episode that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.webtown.liferay.tvtracker.model.Episode updateEpisode(
		hu.webtown.liferay.tvtracker.model.Episode episode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.updateEpisode(episode);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _episodeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_episodeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _episodeLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> getEpisodes(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodes(serviceContext);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> getEpisodes(
		long seasonId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodes(seasonId, serviceContext);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> getEpisodes(
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodes(serviceContext, start, end);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> getEpisodes(
		long seasonId,
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodes(seasonId, serviceContext,
			start, end);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> getEpisodes(
		com.liferay.portal.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodes(serviceContext,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> getEpisodes(
		long seasonId,
		com.liferay.portal.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodes(seasonId, serviceContext,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> getEpisodes(
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodes(serviceContext, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.webtown.liferay.tvtracker.model.Episode> getEpisodes(
		long seasonId,
		com.liferay.portal.service.ServiceContext serviceContext, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodes(seasonId, serviceContext,
			start, end, orderByComparator);
	}

	@Override
	public int getEpisodesCount(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodesCount(serviceContext);
	}

	@Override
	public int getEpisodesCount(long seasonId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.getEpisodesCount(seasonId, serviceContext);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Episode addEpisode(
		long seasonId, java.lang.String title, java.util.Date airDate,
		int episodeNumber, java.lang.String description,
		java.lang.String imageUrl, java.lang.String imageUuid,
		java.lang.String imageTitle, java.lang.String imageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.addEpisode(seasonId, title, airDate,
			episodeNumber, description, imageUrl, imageUuid, imageTitle,
			imageVersion, serviceContext);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Episode updateEpisode(
		long seasonId, long episodeId, java.lang.String title,
		java.util.Date airDate, int episodeNumber,
		java.lang.String description, java.lang.String imageUrl,
		java.lang.String imageUuid, java.lang.String imageTitle,
		java.lang.String imageVersion,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.updateEpisode(seasonId, episodeId, title,
			airDate, episodeNumber, description, imageUrl, imageUuid,
			imageTitle, imageVersion, serviceContext);
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Episode deleteEpisode(
		long episodeId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _episodeLocalService.deleteEpisode(episodeId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EpisodeLocalService getWrappedEpisodeLocalService() {
		return _episodeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEpisodeLocalService(
		EpisodeLocalService episodeLocalService) {
		_episodeLocalService = episodeLocalService;
	}

	@Override
	public EpisodeLocalService getWrappedService() {
		return _episodeLocalService;
	}

	@Override
	public void setWrappedService(EpisodeLocalService episodeLocalService) {
		_episodeLocalService = episodeLocalService;
	}

	private EpisodeLocalService _episodeLocalService;
}