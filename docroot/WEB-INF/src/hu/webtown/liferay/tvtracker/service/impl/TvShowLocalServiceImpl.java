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

import hu.webtown.liferay.tvtracker.NoSuchTvShowException;
import hu.webtown.liferay.tvtracker.TvShowDescriptionException;
import hu.webtown.liferay.tvtracker.TvShowImageException;
import hu.webtown.liferay.tvtracker.TvShowPremierDateException;
import hu.webtown.liferay.tvtracker.TvShowTitleException;
import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.service.base.TvShowLocalServiceBaseImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * The implementation of the tv show local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.tvtracker.service.TvShowLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author czeni
 * @see hu.webtown.liferay.tvtracker.service.base.TvShowLocalServiceBaseImpl
 * @see hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil
 */
public class TvShowLocalServiceImpl extends TvShowLocalServiceBaseImpl {
	
	public TvShow getTvShow(long tvShowId, ServiceContext serviceContext) throws SystemException, NoSuchTvShowException{
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		Locale currentLocale = serviceContext.getLocale();
		TimeZone currentTimeZone = serviceContext.getTimeZone();
		
		// using of the finder method to retrive the requested entity instance
		
		TvShow tvShow = tvShowPersistence.findByG_T(tvShowId, groupId);
		
		
		// producing and setting the necessary custom properties
		
		Calendar calendar = null;
		
		if(currentLocale != null && currentTimeZone != null){
		
			calendar = Calendar.getInstance(currentTimeZone, currentLocale);
			
		} else if(currentLocale != null){
			
			calendar = Calendar.getInstance(currentLocale);
			
		} else if (currentTimeZone != null){
			
			calendar = Calendar.getInstance(currentTimeZone);
			
		} else {
			
			calendar = Calendar.getInstance();
			
		}
		
		
		// getting the premier year from the premier date
		
		Date premierDate = tvShow.getPremierDate();
		calendar.setTime(premierDate);
		
		int premierYear = calendar.get(Calendar.YEAR);
		tvShow.setPremierYear(premierYear);
		
		calendar.clear();
		
		
		// getting the tvShow's season count
		
		int seasonCount = seasonLocalService.getSeasonsCount(tvShowId, serviceContext);
		
		tvShow.setSeasonCount(seasonCount);
		
		
		return tvShow;
	}
	
	
	public List<TvShow> getTvShows(ServiceContext serviceContext) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		Locale currentLocale = serviceContext.getLocale();
		TimeZone currentTimeZone = serviceContext.getTimeZone();
		
		// using of the finder method to retrive the requested entity instances
		
		List<TvShow> tvShows = tvShowPersistence.findByGroupId(groupId);
		
		
		// producing and setting the necessary custom properties
		
		Calendar calendar = null;
		
		if(currentLocale != null && currentTimeZone != null){
		
			calendar = Calendar.getInstance(currentTimeZone, currentLocale);
			
		} else if(currentLocale != null){
			
			calendar = Calendar.getInstance(currentLocale);
			
		} else if (currentTimeZone != null){
			
			calendar = Calendar.getInstance(currentTimeZone);
			
		} else {
			
			calendar = Calendar.getInstance();
			
		}
		
		
		for (TvShow tvShow : tvShows) {
			
			// getting the premier year from the premier date
			
			Date premierDate = tvShow.getPremierDate();
			calendar.setTime(premierDate);
			
			int premierYear = calendar.get(Calendar.YEAR);
			tvShow.setPremierYear(premierYear);
			
			calendar.clear();
			
			
			// getting the tvShow's season count
			
			long tvShowId = tvShow.getTvShowId();
			
			int seasonCount = seasonLocalService.getSeasonsCount(tvShowId, serviceContext);
			tvShow.setSeasonCount(seasonCount);
		}
		
		
		return tvShows;
	}
	
	public List<TvShow> getTvShows(ServiceContext serviceContext, int start, int end) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		
		// using of the finder method to retrive the requested entity instances
		
		List<TvShow> tvShows = tvShowPersistence.findByGroupId(groupId, start, end);
		
		
		// producing and setting the necessary custom properties
		
		Calendar calendar = Calendar.getInstance();
		
		for (TvShow tvShow : tvShows) {
			
			// getting the premier year from the premier date
			
			Date premierDate = tvShow.getPremierDate();
			calendar.setTime(premierDate);
			
			int premierYear = calendar.get(Calendar.YEAR);
			tvShow.setPremierYear(premierYear);
			
			calendar.clear();
			
			
			// getting the tvShow's season count
			
			long tvShowId = tvShow.getTvShowId();
			
			int seasonCount = seasonLocalService.getSeasonsCount(tvShowId, serviceContext);
			tvShow.setSeasonCount(seasonCount);
		}
		
		
		return tvShows;
	}
	
	public List<TvShow> getTvShows(ServiceContext serviceContext, OrderByComparator orderByComparator) throws SystemException{
		
		int start = QueryUtil.ALL_POS;
		int end = QueryUtil.ALL_POS;
		
		return getTvShows(serviceContext, start, end, orderByComparator);

	}
	
	public List<TvShow> getTvShows(ServiceContext serviceContext, int start, int end, OrderByComparator orderByComparator) throws SystemException{
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		Locale currentLocale = serviceContext.getLocale();
		TimeZone currentTimeZone = serviceContext.getTimeZone();
		
		// using of the finder method to retrive the requested entity instances
		
		List<TvShow> tvShows = tvShowPersistence.findByGroupId(groupId, start, end, orderByComparator);
		
		
		// producing and setting the necessary custom properties
		
		Calendar calendar = null;
		
		if(currentLocale != null && currentTimeZone != null){
		
			calendar = Calendar.getInstance(currentTimeZone, currentLocale);
			
		} else if(currentLocale != null){
			
			calendar = Calendar.getInstance(currentLocale);
			
		} else if (currentTimeZone != null){
			
			calendar = Calendar.getInstance(currentTimeZone);
			
		} else {
			
			calendar = Calendar.getInstance();
			
		}
		
		
		for (TvShow tvShow : tvShows) {
			
			// getting the premier year from the premier date
			
			Date premierDate = tvShow.getPremierDate();
			calendar.setTime(premierDate);
			
			int premierYear = calendar.get(Calendar.YEAR);
			tvShow.setPremierYear(premierYear);
			
			calendar.clear();
			
			
			// getting the tvShow's season count
			
			long tvShowId = tvShow.getTvShowId();
			
			int seasonCount = seasonLocalService.getSeasonsCount(tvShowId, serviceContext);
			tvShow.setSeasonCount(seasonCount);
		}
		
		
		return tvShows;
	}
	
	public int getTvShowsCount(ServiceContext serviceContext) throws SystemException {
		
		// unbox and prepare the necessary parameters
		
		long groupId = serviceContext.getScopeGroupId();
		
		
		// using of the appropriate method generated by service builder
		
		return tvShowPersistence.countByGroupId(groupId);
	}

	public TvShow addTvShow(String title, Date premierDate, String description, String imageUrl, String imageUuid, String imageTitle, String imageVersion, ServiceContext serviceContext) throws PortalException, SystemException {
		
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
		
		validate(title, premierDate, description, imageUrl, imageUuid, imageTitle, imageVersion);
		
		
		// create new entity instance and fill up with the prepared parameters
		
		long tvShowId = counterLocalService.increment(TvShow.class.getName());
		TvShow tvShow = createTvShow(tvShowId);
		
		tvShow.setCompanyId(companyId);
		tvShow.setGroupId(groupId);
		tvShow.setUserId(userId);
		tvShow.setUserUuid(uuid);
		tvShow.setUserName(userName);
		tvShow.setCreateDate(createDate);
		tvShow.setModifiedDate(modifiedDate);
		tvShow.setExpandoBridgeAttributes(serviceContext);
		
		tvShow.setTitle(title);
		tvShow.setPremierDate(premierDate);
		tvShow.setDescription(description);
		tvShow.setImageUrl(imageUrl);
		tvShow.setImageUuid(imageUuid);
		tvShow.setImageTitle(imageTitle);
		tvShow.setImageVersion(imageVersion);
		
		
		// persist the properly created instance
		
		addTvShow(tvShow);
		
		
		// prepare some parameters for permission/resource adding
		
		String className = TvShow.class.getName();
		boolean portletActions = false;
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = true;
		
		// permission/resource adding
		
		resourceLocalService.addResources(companyId, groupId, userId, className, tvShowId, portletActions, addGroupPermissions, addGuestPermissions);
		
		
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
				className, tvShowId, uuid, classTypeId, 
				assetCategoryIds, assetTagNames, visible, 
				startDate, endDate, expirationDate, mimeType, 
				assetTitle, assetDescription, assetSummary, assetUrl, assetLayoutUuId, 
				height, width, priority, sync);
		
	
		long entryId = assetEntry.getEntryId();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		int typeId = AssetLinkConstants.TYPE_RELATED;
		
		assetLinkLocalService.updateLinks(userId, entryId, assetLinkEntryIds, typeId);
		
		
		// search/indexing
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(TvShow.class);
		
		indexer.reindex(tvShow);
		
		
		return tvShow;
	}
	
	public TvShow updateTvShow(long tvShowId, String title, Date premierDate, String description,  String imageUrl, String imageUuid, String imageTitle, String imageVersion, ServiceContext serviceContext) throws PortalException, SystemException {
		
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
		
		validate(title, premierDate, description, imageUrl, imageUuid, imageTitle, imageVersion);
		
		
		// get the editable entity instance and fill up with the prepared newly parameters
		
		TvShow tvShow = getTvShow(tvShowId);
		
		tvShow.setCompanyId(companyId);
		tvShow.setGroupId(groupId);
		tvShow.setUserId(userId);
		tvShow.setUserUuid(uuid);
		tvShow.setUserName(userName);
		tvShow.setCreateDate(createDate);
		tvShow.setModifiedDate(modifiedDate);
		tvShow.setExpandoBridgeAttributes(serviceContext);
		
		tvShow.setTitle(title);
		tvShow.setPremierDate(premierDate);
		tvShow.setDescription(description);
		tvShow.setImageUrl(imageUrl);
		tvShow.setImageUuid(imageUuid);
		tvShow.setImageTitle(imageTitle);
		tvShow.setImageVersion(imageVersion);
	
		
		// persist the updated entity instance
		
		updateTvShow(tvShow);
		
		
		// prepare some parameters for permission/resource updating
		
		String className = TvShow.class.getName();
		String[] groupPermissions = serviceContext.getGroupPermissions();
		String[] guestPermissions = serviceContext.getGuestPermissions();
		
		
		// permission/resource updating

		resourceLocalService.updateResources(companyId, groupId, className, tvShowId, groupPermissions, guestPermissions);
		
		
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
				className, tvShowId, uuid, classTypeId, 
				assetCategoryIds, assetTagNames, visible, 
				startDate, endDate, expirationDate, mimeType, 
				assetTitle, assetDescription, assetSummary, assetUrl, assetLayoutUuId, 
				height, width, priority, sync);
		
	
		long entryId = assetEntry.getEntryId();
		long[] assetLinkEntryIds = serviceContext.getAssetLinkEntryIds();
		int typeId = AssetLinkConstants.TYPE_RELATED;
		
		assetLinkLocalService.updateLinks(userId, entryId, assetLinkEntryIds, typeId);
		
		
		// search/indexing
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(TvShow.class);
		
		indexer.reindex(tvShow);
		
		
		return tvShow;
	}
	
	public TvShow deleteTvShow(long tvShowId, ServiceContext serviceContext) throws PortalException, SystemException {
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		
		
		// retrieve the deletable entity instance from the database
		
		TvShow tvShow = getTvShow(tvShowId);
		
		
		// prepare some parameters for permission/resource deleting
		
		String className = TvShow.class.getName();
		
		// permission/resource deleting
		
		resourceLocalService.deleteResource(companyId, className, ResourceConstants.SCOPE_INDIVIDUAL, tvShowId);
		
		
		// asset deleting
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(className, tvShowId);
		
		long entryId = assetEntry.getEntryId();
		
		assetLinkLocalService.deleteLinks(entryId);
		
		assetEntryLocalService.deleteEntry(assetEntry);
		

		// search/index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(TvShow.class);
		
		indexer.delete(tvShow);
		
		
		// delete the entity instance
		
		deleteTvShow(tvShow);
		
		
		return tvShow;
	}
	
	public TvShow deleteTvShowWithSeasons(long tvShowId, ServiceContext serviceContext) throws PortalException, SystemException {
		
		// unbox and prepare the necessary parameters
		
		long companyId = serviceContext.getCompanyId();
		
		
		// retrieve the deletable entity instances from the database
		
		TvShow tvShow = getTvShow(tvShowId);
		
		List<Season> seasons = seasonLocalService.getSeasons(tvShowId, serviceContext);
		
		for (Season season : seasons) {
			
			long seasonId = season.getSeasonId(); 
			
			seasonLocalService.deleteSeason(seasonId, serviceContext);
		}
		
		
		// prepare some parameters for permission/resource deleting
		
		String className = TvShow.class.getName();
		
		// permission/resource deleting
		
		resourceLocalService.deleteResource(companyId, className, ResourceConstants.SCOPE_INDIVIDUAL, tvShowId);
		
		
		// asset deleting
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(className, tvShowId);
		
		long entryId = assetEntry.getEntryId();
		
		assetLinkLocalService.deleteLinks(entryId);
		
		assetEntryLocalService.deleteEntry(assetEntry);
		
		
		// search/index
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(TvShow.class);
		
		indexer.delete(tvShow);
		
		
		// delete the entity instance
		
		deleteTvShow(tvShow);
		
		
		return tvShow;
	}
	
	/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	protected void validate(String title, Date premierDate, String description, String imageUrl, String imageUuid, String imageTitle, String imageVersion) throws PortalException {
		
		// checking if the paramaters are acceptable
		
		if(Validator.isNull(title)){
			
			throw new TvShowTitleException();
		}
		
		if(Validator.isNull(premierDate)){
			
			throw new TvShowPremierDateException();
		}
		
		if(Validator.isNull(description)){
			
			throw new TvShowDescriptionException();
		}
		
		if(Validator.isNull(imageUrl) || !Validator.isUri(imageUrl)){
			
			//throw new TvShowImageException();
		}
		
		if(Validator.isNull(imageUuid)){
			
			throw new TvShowImageException();
		}
		
		if(Validator.isNull(imageTitle)){
			
			throw new TvShowImageException();
		}
		
		if(Validator.isNull(imageVersion)){
			
			throw new TvShowImageException();
		}
		
	}
}