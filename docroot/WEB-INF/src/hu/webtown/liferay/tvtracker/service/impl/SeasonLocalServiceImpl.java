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

package hu.webtown.liferay.tvtracker.service.impl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import hu.webtown.liferay.tvtracker.NoSuchSeasonException;
import hu.webtown.liferay.tvtracker.SeasonDescriptionException;
import hu.webtown.liferay.tvtracker.SeasonImageException;
import hu.webtown.liferay.tvtracker.SeasonNumberException;
import hu.webtown.liferay.tvtracker.SeasonPremierDateException;
import hu.webtown.liferay.tvtracker.SeasonTitleException;
import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.service.base.SeasonLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the season local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.tvtracker.service.SeasonLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.tvtracker.service.base.SeasonLocalServiceBaseImpl
 * @see hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil
 */
public class SeasonLocalServiceImpl extends SeasonLocalServiceBaseImpl {
	
	public Season getSeason(long seasonId, ServiceContext serviceContext) throws SystemException, NoSuchSeasonException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		
		// using of the finder method to retrive the requested entity instances
		
		Season season = seasonPersistence.findByG_S(groupId, seasonId);
		
		
		// getting the season's episode count
		
		int episodeCount = episodeLocalService.getEpisodesCount(seasonId, serviceContext);
		season.setEpisodeCount(episodeCount);
		
		
		return season;
	}
	
	public List<Season> getSeasons(ServiceContext serviceContext) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		
		// using of the finder method to retrive the requested entity instances
		
		List<Season> seasons = seasonPersistence.findByGroupId(groupId);
		
		
		// producing and setting the necessary custom properties
		
		for (Season season : seasons) {
			
			// getting the season's episode count
			
			long seasonId = season.getSeasonId();
			
			int episodeCount = episodeLocalService.getEpisodesCount(seasonId, serviceContext);
			season.setEpisodeCount(episodeCount);
		}
		
		
		return seasons;
	}
	
	public List<Season> getSeasons(long tvShowId, ServiceContext serviceContext) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		
		// using of the finder method to retrive the requested entity instances
		
		List<Season> seasons = seasonPersistence.findByG_T(groupId, tvShowId);
		
		
		// producing and setting the necessary custom properties
		
		for (Season season : seasons) {
			
			// getting the season's episode count
			
			long seasonId = season.getSeasonId();
			
			int episodeCount = episodeLocalService.getEpisodesCount(seasonId, serviceContext);
			season.setEpisodeCount(episodeCount);
		}
		
		
		return seasons;
	}
	
	public List<Season> getSeasons(ServiceContext serviceContext, int start, int end) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		
		// using of the finder method to retrive the requested entity instances
		
		List<Season> seasons = seasonPersistence.findByGroupId(groupId, start, end);
		
		
		// producing and setting the necessary custom properties
		
		for (Season season : seasons) {
			
			// getting the season's episode count
			
			long seasonId = season.getSeasonId();
			
			int episodeCount = episodeLocalService.getEpisodesCount(seasonId, serviceContext);
			season.setEpisodeCount(episodeCount);
		}
		
		
		return seasons;
	}
	
	public List<Season> getSeasons(long tvShowId, ServiceContext serviceContext, int start, int end) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		
		// using of the finder method to retrive the requested entity instances
		
		List<Season> seasons = seasonPersistence.findByG_T(groupId, tvShowId, start, end);
		
		
		// producing and setting the necessary custom properties
		
		for (Season season : seasons) {
			
			// getting the season's episode count
			
			long seasonId = season.getSeasonId();
			
			int episodeCount = episodeLocalService.getEpisodesCount(seasonId, serviceContext);
			season.setEpisodeCount(episodeCount);
		}
		
		
		return seasons;
	}
	
	public List<Season> getSeasons(ServiceContext serviceContext, OrderByComparator orderByComparator) throws SystemException {
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		
		return getSeasons(serviceContext, start, end, orderByComparator);
		
	}
	
	public List<Season> getSeasons(long tvShowId, ServiceContext serviceContext, OrderByComparator orderByComparator) throws SystemException {
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		
		return getSeasons(tvShowId, serviceContext, start, end, orderByComparator);
		
	}
	
	public List<Season> getSeasons(ServiceContext serviceContext, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		
		// using of the finder method to retrive the requested entity instances
		
		List<Season> seasons = seasonPersistence.findByGroupId(groupId, start, end, orderByComparator);
		
		
		// producing and setting the necessary custom properties
		
		for (Season season : seasons) {
			
			// getting the season's episode count
			
			long seasonId = season.getSeasonId();
			
			int episodeCount = episodeLocalService.getEpisodesCount(seasonId, serviceContext);
			season.setEpisodeCount(episodeCount);
		}
		
		
		return seasons;
		
	}
	
	public List<Season> getSeasons(long tvShowId, ServiceContext serviceContext, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		
		// using of the finder method to retrive the requested entity instances
		
		List<Season> seasons = seasonPersistence.findByG_T(groupId, tvShowId, start, end, orderByComparator);
		
		
		// producing and setting the necessary custom properties
		
		for (Season season : seasons) {
			
			// getting the season's episode count
			
			long seasonId = season.getSeasonId();
			
			int episodeCount = episodeLocalService.getEpisodesCount(seasonId, serviceContext);
			season.setEpisodeCount(episodeCount);
		}
		
		
		return seasons;
		
	}
	
	public int getSeasonsCount(ServiceContext serviceContext) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		// using of the appropriate method generated by service builder
		
		return seasonPersistence.countByGroupId(groupId);
	}
	
	public int getSeasonsCount(long tvShowId, ServiceContext serviceContext) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		// using of the appropriate method generated by service builder
		
		return seasonPersistence.countByG_T(groupId, tvShowId);
	}
	
	public Season addSeason(long tvShowId, String title, Date premierDate, int seasonNumber, String description, String imageUrl, String imageUuid, String imageTitle, String imageVersion, ServiceContext serviceContext) throws PortalException, SystemException {
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		String uuid = serviceContext.getUuid();
		
		User user = userPersistence.fetchByPrimaryKey(userId);
		String userName = user.getFullName();
		
		Date now = new Date();
		Date createDate = serviceContext.getCreateDate(now);
		Date modifiedDate = serviceContext.getModifiedDate(now);
		
		
		// check the validity of the input parameters
		
		validate(title, premierDate, seasonNumber, description, imageUrl, imageUuid, imageTitle, imageVersion);
		
		
		// create new entity instance and fill up with the prepared parameters
		
		long seasonId = counterLocalService.increment(Season.class.getName());
		Season season = createSeason(seasonId);
		
		season.setCompanyId(companyId);
		season.setGroupId(groupId);
		season.setUserId(userId);
		season.setUserUuid(uuid);
		season.setUserName(userName);
		season.setCreateDate(createDate);
		season.setModifiedDate(modifiedDate);
		season.setExpandoBridgeAttributes(serviceContext);
		
		season.setTvShowId(tvShowId);
		
		season.setTitle(title);
		season.setPremierDate(premierDate);
		season.setSeasonNumber(seasonNumber);
		season.setDescription(description);
		season.setImageUrl(imageUrl);
		season.setImageUuid(imageUuid);
		season.setImageTitle(imageTitle);
		season.setImageVersion(imageVersion);
		
		
		// persist the properly created instance
		
		addSeason(season);
		
		
		// prepare some parameters for permission/resource adding
		
		String className = Season.class.getName();
		boolean portletActions = false;
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = true;
		
		// permission/resource adding
		
		resourceLocalService.addResources(companyId, groupId, userId, className, seasonId, portletActions, addGroupPermissions, addGuestPermissions);

		
		// prepare some params for the asset config
		
		long classTypeId = 0;
		long[] assetCategoryIds = serviceContext.getAssetCategoryIds();
		String[] assetTagNames = serviceContext.getAssetTagNames();
		boolean visible = true;
		Date startDate = null, endDate = null, expirationDate = null;
		String mimeType = ContentTypes.TEXT_HTML;
		String assetTitle = title, assetDescription = null, assetSummary = null, assetUrl = null, assetLayoutUuId = null;
		int height = 0, width = 0;
		Integer priority = null;
		boolean sync = false;
		
		// asset creating
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
				userId, groupId, createDate, modifiedDate, 
				className, seasonId, uuid, classTypeId, 
				assetCategoryIds, assetTagNames, visible, 
				startDate, endDate, expirationDate, mimeType, 
				assetTitle, assetDescription, assetSummary, assetUrl, assetLayoutUuId, 
				height, width, priority, sync);
		
	
		long entryId = assetEntry.getEntryId();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		int typeId = AssetLinkConstants.TYPE_RELATED;
		
		assetLinkLocalService.updateLinks(userId, entryId, assetLinkEntryIds, typeId);
		
		
		// search/indexing
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Season.class);
		
		indexer.reindex(season);
		
		
		return season;
	}
	
	public Season updateSeason(long tvShowId, long seasonId, String title, Date premierDate, int seasonNumber, String description, String imageUrl, String imageUuid, String imageTitle, String imageVersion, ServiceContext serviceContext) throws PortalException, SystemException {
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		String uuid = serviceContext.getUuid();
		
		User user = userPersistence.fetchByPrimaryKey(userId);
		String userName = user.getFullName();
		
		Date now = new Date();
		Date createDate = serviceContext.getCreateDate(now);
		Date modifiedDate = serviceContext.getModifiedDate(now);
		
		// check the validity of the input parameters
		
		validate(title, premierDate, seasonNumber, description, imageUrl, imageUuid, imageTitle, imageVersion);
		
		
		// get the editable entity instance and fill up with the prepared newly parameters
		
		Season season = getSeason(seasonId);
		
		season.setCompanyId(companyId);
		season.setGroupId(groupId);
		season.setUserId(userId);
		season.setUserUuid(uuid);
		season.setUserName(userName);
		season.setCreateDate(createDate);
		season.setModifiedDate(modifiedDate);
		season.setExpandoBridgeAttributes(serviceContext);
		
		season.setTvShowId(tvShowId);
		
		season.setTitle(title);
		season.setPremierDate(premierDate);
		season.setSeasonNumber(seasonNumber);
		season.setDescription(description);
		season.setImageUrl(imageUrl);
		season.setImageUuid(imageUuid);
		season.setImageTitle(imageTitle);
		season.setImageVersion(imageVersion);
		
		
		// persist the updated entity instance
		
		updateSeason(season);
		
		
		// prepare some parameters for permission/resource updating
		
		String className = Season.class.getName();
		String[] groupPermissions = serviceContext.getGroupPermissions();
		String[] guestPermissions = serviceContext.getGuestPermissions();
		
		// permission/resource updating
		
		resourceLocalService.updateResources(companyId, groupId, className, seasonId, groupPermissions, guestPermissions);
		
		
		// prepare some params for the asset config

		long classTypeId = 0;
		long[] assetCategoryIds = serviceContext.getAssetCategoryIds();
		String[] assetTagNames = serviceContext.getAssetTagNames();
		boolean visible = true;
		Date startDate = null, endDate = null, expirationDate = null;
		String mimeType = ContentTypes.TEXT_HTML;
		String assetTitle = title, assetDescription = null, assetSummary = null, assetUrl = null, assetLayoutUuId = null;
		int height = 0, width = 0;
		Integer priority = null;
		boolean sync = false;
		
		// asset updating
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
				userId, groupId, createDate, modifiedDate, 
				className, seasonId, uuid, classTypeId, 
				assetCategoryIds, assetTagNames, visible, 
				startDate, endDate, expirationDate, mimeType, 
				assetTitle, assetDescription, assetSummary, assetUrl, assetLayoutUuId, 
				height, width, priority, sync);
		
	
		long entryId = assetEntry.getEntryId();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		int typeId = AssetLinkConstants.TYPE_RELATED;
		
		assetLinkLocalService.updateLinks(userId, entryId, assetLinkEntryIds, typeId);

		
		// search/indexing
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Season.class);
		
		indexer.reindex(season);
		
		
		return season;
	}
	
	public Season deleteSeason(long seasonId, ServiceContext serviceContext) throws PortalException, SystemException {
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		
		
		// retrieve the deletable entity instance from the database
		
		Season season = getSeason(seasonId);
		
		
		// prepare some parameters for permission/resource deleting
		
		String className = Season.class.getName();
		
		// permission/resource deleting
		
		resourceLocalService.deleteResource(companyId, className, ResourceConstants.SCOPE_INDIVIDUAL, seasonId);
		
		
		// asset deleting
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(className, seasonId);
		
		long entryId = assetEntry.getEntryId();
		
		assetLinkLocalService.deleteLinks(entryId);
		
		assetEntryLocalService.deleteEntry(assetEntry);
		
		
		// search/indexing
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Season.class);
		
		indexer.reindex(season);
		
		
		// delete the entity instance
		
		deleteSeason(season);
		
		
		return season;
	}
	
	/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	protected void validate(String title, Date premierDate, int seasonNumber, String description, String imageUrl, String imageUuid, String imageTitle, String imageVersion) throws PortalException {
		
		if(Validator.isNull(title)){
			
			throw new SeasonTitleException("The season's title is mandatory!");
		}
		
		if(Validator.isNull(premierDate)){
			
			throw new SeasonPremierDateException("The season's premier date is mandatory!");
		}
		
		if(seasonNumber < 1){
			
			throw new SeasonNumberException("The season's number must be a positive integer number!");
		}
		
		if(Validator.isNull(description)){
			
			throw new SeasonDescriptionException("The season's description is mandatory!");
		}
		
		if(imageUrl == null || imageUuid == null || imageTitle == null || imageVersion == null){
			
			throw new SeasonImageException("The episode's image musn't be null!");
		}
		
	}
}