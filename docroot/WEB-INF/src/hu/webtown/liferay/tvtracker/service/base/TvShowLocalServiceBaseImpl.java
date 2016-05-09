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

package hu.webtown.liferay.tvtracker.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetLinkPersistence;

import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.service.TvShowLocalService;
import hu.webtown.liferay.tvtracker.service.persistence.EpisodePersistence;
import hu.webtown.liferay.tvtracker.service.persistence.SeasonPersistence;
import hu.webtown.liferay.tvtracker.service.persistence.TvShowFinder;
import hu.webtown.liferay.tvtracker.service.persistence.TvShowPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the tv show local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link hu.webtown.liferay.tvtracker.service.impl.TvShowLocalServiceImpl}.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.tvtracker.service.impl.TvShowLocalServiceImpl
 * @see hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil
 * @generated
 */
public abstract class TvShowLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements TvShowLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil} to access the tv show local service.
	 */

	/**
	 * Adds the tv show to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tvShow the tv show
	 * @return the tv show that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TvShow addTvShow(TvShow tvShow) throws SystemException {
		tvShow.setNew(true);

		return tvShowPersistence.update(tvShow);
	}

	/**
	 * Creates a new tv show with the primary key. Does not add the tv show to the database.
	 *
	 * @param tvShowId the primary key for the new tv show
	 * @return the new tv show
	 */
	@Override
	public TvShow createTvShow(long tvShowId) {
		return tvShowPersistence.create(tvShowId);
	}

	/**
	 * Deletes the tv show with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tvShowId the primary key of the tv show
	 * @return the tv show that was removed
	 * @throws PortalException if a tv show with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TvShow deleteTvShow(long tvShowId)
		throws PortalException, SystemException {
		return tvShowPersistence.remove(tvShowId);
	}

	/**
	 * Deletes the tv show from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tvShow the tv show
	 * @return the tv show that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TvShow deleteTvShow(TvShow tvShow) throws SystemException {
		return tvShowPersistence.remove(tvShow);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TvShow.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return tvShowPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return tvShowPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return tvShowPersistence.findWithDynamicQuery(dynamicQuery, start, end,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return tvShowPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return tvShowPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public TvShow fetchTvShow(long tvShowId) throws SystemException {
		return tvShowPersistence.fetchByPrimaryKey(tvShowId);
	}

	/**
	 * Returns the tv show with the primary key.
	 *
	 * @param tvShowId the primary key of the tv show
	 * @return the tv show
	 * @throws PortalException if a tv show with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TvShow getTvShow(long tvShowId)
		throws PortalException, SystemException {
		return tvShowPersistence.findByPrimaryKey(tvShowId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return tvShowPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<TvShow> getTvShows(int start, int end)
		throws SystemException {
		return tvShowPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of tv shows.
	 *
	 * @return the number of tv shows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getTvShowsCount() throws SystemException {
		return tvShowPersistence.countAll();
	}

	/**
	 * Updates the tv show in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tvShow the tv show
	 * @return the tv show that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TvShow updateTvShow(TvShow tvShow) throws SystemException {
		return tvShowPersistence.update(tvShow);
	}

	/**
	 * Returns the episode local service.
	 *
	 * @return the episode local service
	 */
	public hu.webtown.liferay.tvtracker.service.EpisodeLocalService getEpisodeLocalService() {
		return episodeLocalService;
	}

	/**
	 * Sets the episode local service.
	 *
	 * @param episodeLocalService the episode local service
	 */
	public void setEpisodeLocalService(
		hu.webtown.liferay.tvtracker.service.EpisodeLocalService episodeLocalService) {
		this.episodeLocalService = episodeLocalService;
	}

	/**
	 * Returns the episode remote service.
	 *
	 * @return the episode remote service
	 */
	public hu.webtown.liferay.tvtracker.service.EpisodeService getEpisodeService() {
		return episodeService;
	}

	/**
	 * Sets the episode remote service.
	 *
	 * @param episodeService the episode remote service
	 */
	public void setEpisodeService(
		hu.webtown.liferay.tvtracker.service.EpisodeService episodeService) {
		this.episodeService = episodeService;
	}

	/**
	 * Returns the episode persistence.
	 *
	 * @return the episode persistence
	 */
	public EpisodePersistence getEpisodePersistence() {
		return episodePersistence;
	}

	/**
	 * Sets the episode persistence.
	 *
	 * @param episodePersistence the episode persistence
	 */
	public void setEpisodePersistence(EpisodePersistence episodePersistence) {
		this.episodePersistence = episodePersistence;
	}

	/**
	 * Returns the season local service.
	 *
	 * @return the season local service
	 */
	public hu.webtown.liferay.tvtracker.service.SeasonLocalService getSeasonLocalService() {
		return seasonLocalService;
	}

	/**
	 * Sets the season local service.
	 *
	 * @param seasonLocalService the season local service
	 */
	public void setSeasonLocalService(
		hu.webtown.liferay.tvtracker.service.SeasonLocalService seasonLocalService) {
		this.seasonLocalService = seasonLocalService;
	}

	/**
	 * Returns the season remote service.
	 *
	 * @return the season remote service
	 */
	public hu.webtown.liferay.tvtracker.service.SeasonService getSeasonService() {
		return seasonService;
	}

	/**
	 * Sets the season remote service.
	 *
	 * @param seasonService the season remote service
	 */
	public void setSeasonService(
		hu.webtown.liferay.tvtracker.service.SeasonService seasonService) {
		this.seasonService = seasonService;
	}

	/**
	 * Returns the season persistence.
	 *
	 * @return the season persistence
	 */
	public SeasonPersistence getSeasonPersistence() {
		return seasonPersistence;
	}

	/**
	 * Sets the season persistence.
	 *
	 * @param seasonPersistence the season persistence
	 */
	public void setSeasonPersistence(SeasonPersistence seasonPersistence) {
		this.seasonPersistence = seasonPersistence;
	}

	/**
	 * Returns the tv show local service.
	 *
	 * @return the tv show local service
	 */
	public hu.webtown.liferay.tvtracker.service.TvShowLocalService getTvShowLocalService() {
		return tvShowLocalService;
	}

	/**
	 * Sets the tv show local service.
	 *
	 * @param tvShowLocalService the tv show local service
	 */
	public void setTvShowLocalService(
		hu.webtown.liferay.tvtracker.service.TvShowLocalService tvShowLocalService) {
		this.tvShowLocalService = tvShowLocalService;
	}

	/**
	 * Returns the tv show remote service.
	 *
	 * @return the tv show remote service
	 */
	public hu.webtown.liferay.tvtracker.service.TvShowService getTvShowService() {
		return tvShowService;
	}

	/**
	 * Sets the tv show remote service.
	 *
	 * @param tvShowService the tv show remote service
	 */
	public void setTvShowService(
		hu.webtown.liferay.tvtracker.service.TvShowService tvShowService) {
		this.tvShowService = tvShowService;
	}

	/**
	 * Returns the tv show persistence.
	 *
	 * @return the tv show persistence
	 */
	public TvShowPersistence getTvShowPersistence() {
		return tvShowPersistence;
	}

	/**
	 * Sets the tv show persistence.
	 *
	 * @param tvShowPersistence the tv show persistence
	 */
	public void setTvShowPersistence(TvShowPersistence tvShowPersistence) {
		this.tvShowPersistence = tvShowPersistence;
	}

	/**
	 * Returns the tv show finder.
	 *
	 * @return the tv show finder
	 */
	public TvShowFinder getTvShowFinder() {
		return tvShowFinder;
	}

	/**
	 * Sets the tv show finder.
	 *
	 * @param tvShowFinder the tv show finder
	 */
	public void setTvShowFinder(TvShowFinder tvShowFinder) {
		this.tvShowFinder = tvShowFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(
		com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
		this.assetEntryService = assetEntryService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.portlet.asset.service.AssetLinkLocalService getAssetLinkLocalService() {
		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService) {
		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {
		this.assetLinkPersistence = assetLinkPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("hu.webtown.liferay.tvtracker.model.TvShow",
			tvShowLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"hu.webtown.liferay.tvtracker.model.TvShow");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TvShow.class;
	}

	protected String getModelClassName() {
		return TvShow.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tvShowPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = hu.webtown.liferay.tvtracker.service.EpisodeLocalService.class)
	protected hu.webtown.liferay.tvtracker.service.EpisodeLocalService episodeLocalService;
	@BeanReference(type = hu.webtown.liferay.tvtracker.service.EpisodeService.class)
	protected hu.webtown.liferay.tvtracker.service.EpisodeService episodeService;
	@BeanReference(type = EpisodePersistence.class)
	protected EpisodePersistence episodePersistence;
	@BeanReference(type = hu.webtown.liferay.tvtracker.service.SeasonLocalService.class)
	protected hu.webtown.liferay.tvtracker.service.SeasonLocalService seasonLocalService;
	@BeanReference(type = hu.webtown.liferay.tvtracker.service.SeasonService.class)
	protected hu.webtown.liferay.tvtracker.service.SeasonService seasonService;
	@BeanReference(type = SeasonPersistence.class)
	protected SeasonPersistence seasonPersistence;
	@BeanReference(type = hu.webtown.liferay.tvtracker.service.TvShowLocalService.class)
	protected hu.webtown.liferay.tvtracker.service.TvShowLocalService tvShowLocalService;
	@BeanReference(type = hu.webtown.liferay.tvtracker.service.TvShowService.class)
	protected hu.webtown.liferay.tvtracker.service.TvShowService tvShowService;
	@BeanReference(type = TvShowPersistence.class)
	protected TvShowPersistence tvShowPersistence;
	@BeanReference(type = TvShowFinder.class)
	protected TvShowFinder tvShowFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
	protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
	protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetLinkLocalService.class)
	protected com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService;
	@BeanReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TvShowLocalServiceClpInvoker _clpInvoker = new TvShowLocalServiceClpInvoker();
}