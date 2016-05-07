package hu.webtown.liferay.tvtracker.portlet.admin;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.webtown.liferay.tvtracker.model.Episode;
import hu.webtown.liferay.tvtracker.service.EpisodeLocalServiceUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class EpisodeAdminPortlet
 */
public class EpisodeAdminPortlet extends MVCPortlet {
 
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
	
	public void addEpisode(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(EpisodeAdminPortlet.class.getName(), actionRequest);
			
			Calendar calendar = getCal(serviceContext);
			
			int airDateDay = ParamUtil.getInteger(actionRequest, "airDateDay");
			int airDateMonth = ParamUtil.getInteger(actionRequest, "airDateMonth");
			int airDateYear = ParamUtil.getInteger(actionRequest, "airDateYear");
			
			int airDateMinute = ParamUtil.getInteger(actionRequest, "airDateMinute"); 
			int airDateHour = ParamUtil.getInteger(actionRequest, "airDateHour");
			int airDateAmPm = ParamUtil.getInteger(actionRequest, "airDateAmPm");
			
			calendar.set(airDateYear, airDateMonth, airDateDay, airDateHour, airDateMinute);
			calendar.set(Calendar.AM_PM, airDateAmPm);
			
			Date airDate = calendar.getTime();
			String title = ParamUtil.getString(actionRequest, "title");
			int episodeNumber = ParamUtil.getInteger(actionRequest, "episodeNumber");
			String description = ParamUtil.getString(actionRequest, "description");
			
			String imageUrl = ParamUtil.getString(actionRequest, "imageUrl");
			String imageUuid = ParamUtil.getString(actionRequest, "imageUuid");
			String imageTitle = ParamUtil.getString(actionRequest, "imageTitle");
			String imageVersion = ParamUtil.getString(actionRequest, "imageVersion");
			
			long seasonId = ParamUtil.getLong(actionRequest, "seasonId");
		
			
			/* add episode */
			Episode createdEpisode = EpisodeLocalServiceUtil.addEpisode(
				seasonId, title, airDate, episodeNumber, description, 
				imageUrl, imageUuid, imageTitle, imageVersion, serviceContext
			);
			
			
			long episodeId = createdEpisode.getEpisodeId();
			
			// logging
			if (_logger.isDebugEnabled()) {
				_logger.debug("Episode: (id: " + episodeId + ", title: " + title + ") creating was successful!");
			}
				
			// feedback
			SessionMessages.add(actionRequest, "add-episode-successful");
				
			// nav
			actionResponse.setRenderParameter("mvcPath", "/html/episodeadmin/view.jsp");
			
		} catch (PortalException | SystemException e) {
			
			// logging
			if (_logger.isErrorEnabled()){
				_logger.error("Problem occurred in EpisodeAdminPortlet#addEpisode method!", e);
			}
			
			// feedback
			SessionErrors.add(actionRequest, "add-episode-unsuccessful");
			
			// nav
			actionResponse.setRenderParameter("mvcPath", "/html/episodeadmin/edit.jsp");
		}
		
	}
	
	public void updateEpisode(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(EpisodeAdminPortlet.class.getName(), actionRequest);
		
			Calendar calendar = getCal(serviceContext);
			
			int airDateDay = ParamUtil.getInteger(actionRequest, "airDateDay");
			int airDateMonth = ParamUtil.getInteger(actionRequest, "airDateMonth");
			int airDateYear = ParamUtil.getInteger(actionRequest, "airDateYear");
			
			int airDateMinute = ParamUtil.getInteger(actionRequest, "airDateMinute"); 
			int airDateHour = ParamUtil.getInteger(actionRequest, "airDateHour");
			int airDateAmPm = ParamUtil.getInteger(actionRequest, "airDateAmPm");
			
			calendar.set(airDateYear, airDateMonth, airDateDay, airDateHour, airDateMinute);
			calendar.set(Calendar.AM_PM, airDateAmPm);
			
			Date airDate = calendar.getTime();
			String title = ParamUtil.getString(actionRequest, "title");
			int episodeNumber = ParamUtil.getInteger(actionRequest, "episodeNumber");
			String description = ParamUtil.getString(actionRequest, "description");
			
			String imageUrl = ParamUtil.getString(actionRequest, "imageUrl");
			String imageUuid = ParamUtil.getString(actionRequest, "imageUuid");
			String imageTitle = ParamUtil.getString(actionRequest, "imageTitle");
			String imageVersion = ParamUtil.getString(actionRequest, "imageVersion");
			
			long episodeId = ParamUtil.getLong(actionRequest, "episodeId");
			long seasonId = ParamUtil.getLong(actionRequest, "seasonId");
			
			
			/* edit episode */
			EpisodeLocalServiceUtil.updateEpisode(
					seasonId, episodeId, title, airDate, episodeNumber, description, 
					imageUrl, imageUuid, imageTitle, imageVersion, serviceContext);
			
			
			// logging
			if (_logger.isDebugEnabled()) {
				_logger.debug("Episode: (id: " + episodeId + ", title: " + title + ") updating was successful!");
			}
			
			// feedback
			SessionMessages.add(actionRequest, "update-episode-successful");
			
			// nav
			actionResponse.setRenderParameter("mvcPath", "/html/episodeadmin/view.jsp");
			
		} catch (PortalException | SystemException e) {
			
			// logging
			if (_logger.isErrorEnabled()) {
				_logger.error("Problem occurred in EpisodeAdminPortlet#updateEpisode method!", e);
			}
			
			// feedback
			SessionErrors.add(actionRequest, "update-episode-unsuccessful");
			
			// nav
			actionResponse.setRenderParameter("mvcPath", "/html/episodeadmin/edit.jsp");
		}	
	}
	
	public void deleteEpisode(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(EpisodeAdminPortlet.class.getName(), actionRequest);
			
			long episodeId = ParamUtil.getLong(actionRequest, "episodeId");
		
			
			/* delete episode */
			EpisodeLocalServiceUtil.deleteEpisode(episodeId, serviceContext);
			
			
			// logging
			if (_logger.isDebugEnabled()) {
				_logger.debug("Episode: (id: " + episodeId + ") deleting was successful!");
			}
			
			// feedback
			SessionMessages.add(actionRequest, "delete-episode-successful");
			
			// nav
			actionResponse.setRenderParameter("mvcPath", "/html/episodeadmin/view.jsp");
			
		} catch (PortalException | SystemException e) {
			
			// logging
			if (_logger.isErrorEnabled()){
				_logger.error("Problem occurred in EpisodeAdminPortlet#deleteEpisode method!", e);
			}

			// feedback
			SessionErrors.add(actionRequest, "delete-episode-unsuccessful");
			
			// nav
			actionResponse.setRenderParameter("mvcPath", "/html/episodeadmin/veiw.jsp");
		}
	}
}
