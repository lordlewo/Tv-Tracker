package hu.webtown.liferay.tvtracker.portlet.admin;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil;
import hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class TvShowAdminPortlet
 */
public class TvShowAdminPortlet extends MVCPortlet {
	
	private static Log _logger = LogFactoryUtil.getLog(TvShowAdminPortlet.class);
	
	
	protected Calendar getCal(ServiceContext serviceContext){
		
		Locale locale = serviceContext.getLocale();
		TimeZone timeZone = serviceContext.getTimeZone();
		
		Calendar calendar = null;
		
		if (locale != null && timeZone != null){
		
			calendar = new GregorianCalendar(timeZone, locale);
		
		} else if (locale != null){
			
			calendar = new GregorianCalendar(locale);
		
		} else if (timeZone != null){
			
			calendar = new GregorianCalendar(timeZone);
			
		} else {
			
			calendar = new GregorianCalendar();
			
		}
		
		return calendar;
	}
	
	
	public void addTvShow(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		int[] rowIndexes = {};
		int rowIndex = 0;
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(EpisodeAdminPortlet.class.getName(), actionRequest);
			
			Calendar calendar = getCal(serviceContext);
			
			/*********************************************************************************************/
			/*******/// Tv Show ///***********************************************************************/
			/*********************************************************************************************/
			
			int premierDateDay = ParamUtil.getInteger(actionRequest, "premierDateDay");
			int premierDateMonth = ParamUtil.getInteger(actionRequest, "premierDateMonth");
			int premierDateYear = ParamUtil.getInteger(actionRequest, "premierDateYear");
			
			calendar.set(premierDateYear, premierDateMonth, premierDateDay);
			
			Date tvShowPremierDate = calendar.getTime();
			String tvShowTitle = ParamUtil.getString(actionRequest, "title");
			String tvShowDescription = ParamUtil.getString(actionRequest, "description");
			
			String tvShowImageUrl = ParamUtil.getString(actionRequest, "imageUrl");
			String tvShowImageUuid = ParamUtil.getString(actionRequest, "imageUuid");
			String tvShowImageTitle = ParamUtil.getString(actionRequest, "imageTitle");
			String tvShowImageVersion = ParamUtil.getString(actionRequest, "imageVersion");
			
			/* add tvshow */
			TvShow tvShow = TvShowLocalServiceUtil.addTvShow(
					tvShowTitle, tvShowPremierDate, tvShowDescription, 
					tvShowImageUrl, tvShowImageUuid, tvShowImageTitle, tvShowImageVersion, serviceContext);
			
			long tvShowId = tvShow.getTvShowId();
			
			/*********************************************************************************************/
			/*******/// Seasons ///***********************************************************************/
			/*********************************************************************************************/
			
			rowIndexes = ParamUtil.getIntegerValues(actionRequest, "rowIndexes");
			
			for(rowIndex = 0; rowIndex < rowIndexes.length; rowIndex++){
				
				calendar.clear();
				
				int seasonPremierDateDay = ParamUtil.getInteger(actionRequest, "seasonPremierDateDay" + rowIndex);
				int seasonPremierDateMonth = ParamUtil.getInteger(actionRequest, "seasonPremierDateMonth" + rowIndex);
				int seasonPremierDateYear = ParamUtil.getInteger(actionRequest, "seasonPremierDateYear" + rowIndex);
				
				calendar.set(seasonPremierDateYear, seasonPremierDateMonth, seasonPremierDateDay);
				
				Date seasonPremierDate = calendar.getTime();
				String seasonTitle = ParamUtil.getString(actionRequest, "seasonTitle" + rowIndex);
				int seasonNumber = ParamUtil.getInteger(actionRequest, "seasonNumber" + rowIndex);
				String seasonDescription = ParamUtil.getString(actionRequest, "seasonDescription" + rowIndex);
				
				String seasonImageUrl = ParamUtil.getString(actionRequest, "seasonImageUrl" + rowIndex);
				String seasonImageUuid = ParamUtil.getString(actionRequest, "seasonImageUuid" + rowIndex);
				String seasonImageTitle = ParamUtil.getString(actionRequest, "seasonImageTitle" + rowIndex);
				String seasonImageVersion = ParamUtil.getString(actionRequest, "seasonImageVersion" + rowIndex);
				
				/* add seasons */
				SeasonLocalServiceUtil.addSeason(
						tvShowId, seasonTitle, seasonPremierDate, seasonNumber, seasonDescription, 
						seasonImageUrl, seasonImageUuid, seasonImageTitle, seasonImageVersion, serviceContext);
			}
			
			
			// feedback
			
			if(rowIndexes.length == 0){
				
				SessionMessages.add(actionRequest, "add-tvshow-successful");
				
			} else if (rowIndexes.length == 1) {
				
				SessionMessages.add(actionRequest, "add-tvshow-with-season-successful");
				
			} else {
				
				SessionMessages.add(actionRequest, "add-tvshow-with-seasons-successful");
				
			}
			

		} catch (PortalException | SystemException e) {
			
			_logger.error("TvShowAdminPortlet -> addTvShow method!", e);
			
			
			// feedback
			
			if(rowIndexes.length == 0){
				
				SessionMessages.add(actionRequest, "add-tvshow-unsuccessful");
				
			} else if (rowIndexes.length == 1) {
				
				SessionMessages.add(actionRequest, "add-tvshow-with-season-unsuccessful");
				
			} else {
				
				SessionMessages.add(actionRequest, "add-tvshow-with-seasons-unsuccessful");
				
			}

		}
		
	}
	
	public void updateTvShow(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		int[] rowIndexes = {};
		int rowIndex = 0;
		
		Set<Long> updatedSeasons = Collections.emptySet();
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(EpisodeAdminPortlet.class.getName(), actionRequest);
			
			Calendar calendar = getCal(serviceContext);
			
			/*********************************************************************************************/
			/*******/// Tv Show ///***********************************************************************/
			/*********************************************************************************************/
			
			int premierDateDay = ParamUtil.getInteger(actionRequest, "premierDateDay");
			int premierDateMonth = ParamUtil.getInteger(actionRequest, "premierDateMonth");
			int premierDateYear = ParamUtil.getInteger(actionRequest, "premierDateYear");
			
			calendar.set(premierDateYear, premierDateMonth, premierDateDay);
			
			Date tvShowPremierDate = calendar.getTime();
			String tvShowTitle = ParamUtil.getString(actionRequest, "title");
			String tvShowDescription = ParamUtil.getString(actionRequest, "description");
			
			String tvShowImageUrl = ParamUtil.getString(actionRequest, "imageUrl");
			String tvShowImageUuid = ParamUtil.getString(actionRequest, "imageUuid");
			String tvShowImageTitle = ParamUtil.getString(actionRequest, "imageTitle");
			String tvShowImageVersion = ParamUtil.getString(actionRequest, "imageVersion");
			
			long tvShowId = ParamUtil.getLong(actionRequest, "tvShowId");
			
			/* edit tvshow */
			TvShow tvShow = TvShowLocalServiceUtil.updateTvShow(
					tvShowId, tvShowTitle, tvShowPremierDate, tvShowDescription, 
					tvShowImageUrl, tvShowImageUuid, tvShowImageTitle, tvShowImageVersion, serviceContext);
			
			/*********************************************************************************************/
			/*******/// Seasons ///***********************************************************************/
			/*********************************************************************************************/
			
			List<Season> seasons = SeasonLocalServiceUtil.getSeasons(tvShowId, serviceContext);
			updatedSeasons = new HashSet<Long>();
			
			rowIndexes = ParamUtil.getIntegerValues(actionRequest, "rowIndexes");
			
			for(rowIndex = 0; rowIndex < rowIndexes.length; rowIndex++) {
				
				calendar.clear();
				
				int seasonPremierDateDay = ParamUtil.getInteger(actionRequest, "seasonPremierDateDay" + rowIndex);
				int seasonPremierDateMonth = ParamUtil.getInteger(actionRequest, "seasonPremierDateMonth" + rowIndex);
				int seasonPremierDateYear = ParamUtil.getInteger(actionRequest, "seasonPremierDateYear" + rowIndex);
				
				calendar.set(seasonPremierDateYear, seasonPremierDateMonth, seasonPremierDateDay);
				
				Date seasonPremierDate = calendar.getTime();
				String seasonTitle = ParamUtil.getString(actionRequest, "seasonTitle" + rowIndex);
				int seasonNumber = ParamUtil.getInteger(actionRequest, "seasonNumber" + rowIndex);
				String seasonDescription = ParamUtil.getString(actionRequest, "seasonDescription" + rowIndex);
				
				String seasonImageUrl = ParamUtil.getString(actionRequest, "seasonImageUrl" + rowIndex);
				String seasonImageUuid = ParamUtil.getString(actionRequest, "seasonImageUuid" + rowIndex);
				String seasonImageTitle = ParamUtil.getString(actionRequest, "seasonImageTitle" + rowIndex);
				String seasonImageVersion = ParamUtil.getString(actionRequest, "seasonImageVersion" + rowIndex);
				
				
				long seasonId = ParamUtil.getLong(actionRequest, "seasonId" + rowIndex, 0);
				
				if(seasonId > 0) {
											
					// edit season

					Season _season = SeasonLocalServiceUtil.updateSeason(
							tvShowId, seasonId, seasonTitle, seasonPremierDate, seasonNumber, seasonDescription, 
							seasonImageUrl, seasonImageUuid, seasonImageTitle, seasonImageVersion, serviceContext);
					
					updatedSeasons.add(seasonId);
					
					System.out.println("updated: " + seasonTitle);
						
				} else { 
					
					// add season
				
					SeasonLocalServiceUtil.addSeason(
							tvShowId, seasonTitle, seasonPremierDate, seasonNumber, seasonDescription, 
							seasonImageUrl, seasonImageUuid, seasonImageTitle, seasonImageVersion, serviceContext);
					
					System.out.println("added: " + seasonTitle);
					
				}
			}
			
			for (Season season : seasons) {
				
				long _seasonId = season.getSeasonId();
				
				if(!updatedSeasons.contains(_seasonId)){
					
					SeasonLocalServiceUtil.deleteSeason(_seasonId, serviceContext);
					
					System.out.println("deleted: " + season.getTitle());
				}
				
			}
			
			
			// feedback
			
			if(updatedSeasons.size() == 0){
				
				SessionMessages.add(actionRequest, "update-tvshow-successful");
				
			} else if (updatedSeasons.size() == 1) {
				
				SessionMessages.add(actionRequest, "update-tvshow-with-season-successful");
				
			} else {
				
				SessionMessages.add(actionRequest, "update-tvshow-with-seasons-successful");
				
			}
			
			
		} catch (PortalException | SystemException e) {
			
			_logger.error("TvShowAdminPortlet -> updateTvShow method!", e);
			
			
			// feedback
			
			if(updatedSeasons.size() == 0){
				
				SessionMessages.add(actionRequest, "update-tvshow-unsuccessful");
				
			} else if (updatedSeasons.size() == 1) {
				
				SessionMessages.add(actionRequest, "update-tvshow-with-season-unsuccessful");
				
			} else {
				
				SessionMessages.add(actionRequest, "update-tvshow-with-seasons-unsuccessful");
				
			}
			
		}
		
	}
	
	public void deleteTvShow(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		int seasonCount = 0;
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(EpisodeAdminPortlet.class.getName(), actionRequest);
			
			long tvShowId = ParamUtil.getLong(actionRequest, "tvShowId");
			
			seasonCount = SeasonLocalServiceUtil.getSeasonsCount(tvShowId, serviceContext);
			
			
			/* delete tvshow with seasons */
			TvShowLocalServiceUtil.deleteTvShowWithSeasons(tvShowId, serviceContext);
			
			
			// feedback
			
			if(seasonCount == 0){
				
				SessionMessages.add(actionRequest, "delete-tvshow-successful");
				
			} else if (seasonCount == 1) {
				
				SessionMessages.add(actionRequest, "delete-tvshow-with-season-successful");
				
			} else {
				
				SessionMessages.add(actionRequest, "delete-tvshow-with-seasons-successful");
				
			}

			
		} catch (PortalException | SystemException e) {
			
			_logger.error("TvShowAdminPortlet -> deleteTvShow method!", e);
			
			
			// feedback
			
			if(seasonCount == 0){
				
				SessionMessages.add(actionRequest, "delete-tvshow-unsuccessful");
				
			} else if (seasonCount == 1) {
				
				SessionMessages.add(actionRequest, "delete-tvshow-with-season-unsuccessful");
				
			} else {
				
				SessionMessages.add(actionRequest, "delete-tvshow-with-seasons-unsuccessful");
				
			}
			
		}
		
	}

}
