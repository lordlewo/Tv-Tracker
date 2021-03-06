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

import hu.webtown.liferay.tvtracker.EpisodeAirDateException;
import hu.webtown.liferay.tvtracker.EpisodeDescriptionException;
import hu.webtown.liferay.tvtracker.EpisodeImageException;
import hu.webtown.liferay.tvtracker.EpisodeNumberException;
import hu.webtown.liferay.tvtracker.EpisodeTitleException;
import hu.webtown.liferay.tvtracker.SeasonImageException;
import hu.webtown.liferay.tvtracker.TvShowImageException;
import hu.webtown.liferay.tvtracker.model.Episode;
import hu.webtown.liferay.tvtracker.service.base.EpisodeLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the episode local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.tvtracker.service.EpisodeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.tvtracker.service.base.EpisodeLocalServiceBaseImpl
 * @see hu.webtown.liferay.tvtracker.service.EpisodeLocalServiceUtil
 */
public class EpisodeLocalServiceImpl extends EpisodeLocalServiceBaseImpl {
	
	public List<Episode> getEpisodes(ServiceContext serviceContext) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		// using of the finder method
		
		return episodePersistence.findByGroupId(groupId);
	}
	
	public List<Episode> getEpisodes(long seasonId, ServiceContext serviceContext) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		// using of the finder method
		
		return episodePersistence.findByG_S(groupId, seasonId);
	}
	
	public List<Episode> getEpisodes(ServiceContext serviceContext, int start, int end) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		// using of the finder method
		
		return episodePersistence.findByGroupId(groupId, start, end);
	}
	
	public List<Episode> getEpisodes(long seasonId, ServiceContext serviceContext, int start, int end) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		// using of the finder method
		
		return episodePersistence.findByG_S(groupId, seasonId, start, end);
	}
	
	public List<Episode> getEpisodes(ServiceContext serviceContext, OrderByComparator orderByComparator) throws SystemException {
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		
		return getEpisodes(serviceContext, start, end, orderByComparator);
		
	}
	
	public List<Episode> getEpisodes(long seasonId, ServiceContext serviceContext, OrderByComparator orderByComparator) throws SystemException {
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		
		return getEpisodes(seasonId, serviceContext, start, end, orderByComparator);
		
	}
	
	public List<Episode> getEpisodes(ServiceContext serviceContext, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		// using of the finder method
		
		return episodePersistence.findByGroupId(groupId, start, end, orderByComparator);
		
	}
	
	public List<Episode> getEpisodes(long seasonId, ServiceContext serviceContext, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		// using of the finder method
		
		return episodePersistence.findByG_S(groupId, seasonId, start, end, orderByComparator);
		
	}
	
	public int getEpisodesCount(ServiceContext serviceContext) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		// using of the appropriate method generated by service builder
		
		return episodePersistence.countByGroupId(groupId);
	}
	
	public int getEpisodesCount(long seasonId, ServiceContext serviceContext) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		// using of the appropriate method generated by service builder
		
		return episodePersistence.countByG_S(groupId, seasonId);
	}
	
	public Episode addEpisode(long seasonId, String title, Date airDate, int episodeNumber, String description, String imageUrl, String imageUuid, String imageTitle, String imageVersion, ServiceContext serviceContext) throws PortalException, SystemException {
		
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
		
		validate(title, airDate, episodeNumber, description, imageUrl, imageUuid, imageTitle, imageVersion);
		
		// create new entity instance and fill up with the prepared parameters
		
		long episodeId = counterLocalService.increment(Episode.class.getName());
		Episode episode = createEpisode(episodeId);
		
		episode.setCompanyId(companyId);
		episode.setGroupId(groupId);
		episode.setUserId(userId);
		episode.setUserUuid(uuid);
		episode.setUserName(userName);
		episode.setCreateDate(createDate);
		episode.setModifiedDate(modifiedDate);
		episode.setExpandoBridgeAttributes(serviceContext);
		
		episode.setSeasonId(seasonId);
		
		episode.setTitle(title);
		episode.setAirDate(airDate);
		episode.setEpisodeNumber(episodeNumber);
		episode.setDescription(description);
		episode.setImageUrl(imageUrl);
		episode.setImageUuid(imageUuid);
		episode.setImageTitle(imageTitle);
		episode.setImageVersion(imageVersion);
		
		
		// persist the properly created instance
		
		addEpisode(episode);
		
		
		// prepare some parameters for permission/resource adding
		
		String className = Episode.class.getName();
		boolean portletActions = false;
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = true;
		
		// permission/resource adding
		
		resourceLocalService.addResources(companyId, groupId, userId, className, episodeId, portletActions, addGroupPermissions, addGuestPermissions);
		
		
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
				className, episodeId, uuid, classTypeId, 
				assetCategoryIds, assetTagNames, visible, 
				startDate, endDate, expirationDate, mimeType, 
				assetTitle, assetDescription, assetSummary, assetUrl, assetLayoutUuId, 
				height, width, priority, sync);
		
	
		long entryId = assetEntry.getEntryId();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		int typeId = AssetLinkConstants.TYPE_RELATED;
		
		assetLinkLocalService.updateLinks(userId, entryId, assetLinkEntryIds, typeId);

		
		// search/indexing
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Episode.class);
		
		indexer.reindex(episode);
		
		
		return episode;
	}
	
	public Episode updateEpisode(long seasonId, long episodeId, String title, Date airDate, int episodeNumber, String description, String imageUrl, String imageUuid, String imageTitle, String imageVersion, ServiceContext serviceContext) throws PortalException, SystemException {
		
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
		
		validate(title, airDate, episodeNumber, description, imageUrl, imageUuid, imageTitle, imageVersion);
		
		
		// get the editable entity instance and fill up with the prepared newly parameters
		
		Episode episode = getEpisode(episodeId);
		
		episode.setCompanyId(companyId);
		episode.setGroupId(groupId);
		episode.setUserId(userId);
		episode.setUserUuid(uuid);
		episode.setUserName(userName);
		episode.setCreateDate(createDate);
		episode.setModifiedDate(modifiedDate);
		episode.setExpandoBridgeAttributes(serviceContext);
		
		episode.setSeasonId(seasonId);
		
		episode.setTitle(title);
		episode.setAirDate(airDate);
		episode.setEpisodeNumber(episodeNumber);
		episode.setDescription(description);
		episode.setImageUrl(imageUrl);
		episode.setImageUuid(imageUuid);
		episode.setImageTitle(imageTitle);
		episode.setImageVersion(imageVersion);
		
		
		// persist the updated entity instance
		
		updateEpisode(episode);
		
		
		// prepare some parameters for permission/resource updating
		
		String className = Episode.class.getName();
		String[] groupPermissions = serviceContext.getGroupPermissions();
		String[] guestPermissions = serviceContext.getGuestPermissions();
		
		// permission/resource updating

		resourceLocalService.updateResources(companyId, groupId, className, userId, groupPermissions, guestPermissions);
		
		
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
				className, episodeId, uuid, classTypeId, 
				assetCategoryIds, assetTagNames, visible, 
				startDate, endDate, expirationDate, mimeType, 
				assetTitle, assetDescription, assetSummary, assetUrl, assetLayoutUuId, 
				height, width, priority, sync);
		
	
		long entryId = assetEntry.getEntryId();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		int typeId = AssetLinkConstants.TYPE_RELATED;
		
		assetLinkLocalService.updateLinks(userId, entryId, assetLinkEntryIds, typeId);
		

		// search/indexing
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Episode.class);
		
		indexer.reindex(episode);
		
		
		return episode;
	}
	
	public Episode deleteEpisode(long episodeId, ServiceContext serviceContext) throws PortalException, SystemException {
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		
		
		// retrieve the deletable entity instance from the database
		
		Episode episode = getEpisode(episodeId);

		
		// prepare some parameters for permission/resource deleting
		
		String className = Episode.class.getName();
		
		// permission/resource deleting
		
		resourceLocalService.deleteResource(companyId, className, ResourceConstants.SCOPE_INDIVIDUAL, episodeId);
		
		
		// asset deleting
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(className, episodeId);
		
		long entryId = assetEntry.getEntryId();
		
		assetLinkLocalService.deleteLinks(entryId);
		
		assetEntryLocalService.deleteEntry(assetEntry);
		
		
		// search/indexing
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Episode.class);
		
		indexer.reindex(episode);
		
		
		// delete the entity instance
		
		deleteEpisode(episode);
		
		
		return episode;
	}
	
	/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	protected void validate(String title, Date airDate, int episodeNumber, String description, String imageUrl, String imageUuid, String imageTitle, String imageVersion) throws PortalException {
		
		// checking if the paramaters are acceptable
		
		if(Validator.isNull(title)){
			
			throw new EpisodeTitleException("The episode's title is mandatory!");
		}
		
		if(Validator.isNull(airDate)){
			
			throw new EpisodeAirDateException("The episode's air date is mandatory!");
		}
		
		if(episodeNumber < 1){
			
			throw new EpisodeNumberException("The episode's number must be a positive integer number!");
		}
		
		if(Validator.isNull(description)){
			
			throw new EpisodeDescriptionException("The episode's description is mandatory!");
		}
		
		if(imageUrl == null || imageUuid == null || imageTitle == null || imageVersion == null){
			
			throw new EpisodeImageException("The episode's image musn't be null!");
		}
		
	}
}