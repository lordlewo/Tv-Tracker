package hu.webtown.liferay.tvtracker.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil;
import hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil;
import hu.webtown.liferay.tvtracker.util.WebKeys;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class TvTrackerPortlet
 */
public class TvTrackerPortlet extends MVCPortlet {
	
	private static Log _logger = LogFactoryUtil.getLog(TvTrackerPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(TvShow.class.getName(), renderRequest);
			
			List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(serviceContext);
			
			renderRequest.setAttribute(WebKeys.TVSHOWS_PUBLIC_LIST, tvShows);
			
			
		} catch (Exception e) {
			
			_logger.error("render method", e);
			
			throw new PortletException(e);
		}
		
		super.render(renderRequest, renderResponse);
	}
	
	
/****************************************************************************************************************************/
/****************************************************************************************************************************/	
	
	
	private static AtomicLong tvShowCounter = new AtomicLong(1000000l);
	private static AtomicLong seasonCounter = new AtomicLong(1000000l);
	private static AtomicLong episodeCounter = new AtomicLong(1000000l);

	// TvShow
	
	public void testAddTvShow(ActionRequest actionRequest, ActionResponse actionResponse){
			
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(TvShow.class.getName(), actionRequest);
			
			long countId = tvShowCounter.getAndIncrement();
			TvShowLocalServiceUtil.addTvShow("test" + String.valueOf(countId), new Date(), 
					"test", "test", "test", "test", "test", serviceContext);
			
		} catch (PortalException e) {

			_logger.error("testAddTvShow method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testAddTvShow method", e);
		}
		
	}
	
	public void testUpdateTvShow(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			int tvShowsCount = TvShowLocalServiceUtil.getTvShowsCount(serviceContext);
			if(tvShowsCount > 0){
				
				TvShow lastTvShow = TvShowLocalServiceUtil.getTvShows(serviceContext).get(0);
				
				long countId = tvShowCounter.getAndIncrement();
				TvShowLocalServiceUtil.updateTvShow(lastTvShow.getTvShowId(), "test" + String.valueOf(countId), new Date(), 
						"test", "test", "test", "test", "test", serviceContext);
			}
			
		} catch (PortalException e) {

			_logger.error("testUpdateTvShow method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testUpdateTvShow method", e);
		}
		
	}
	
	public void testDeleteTvShow(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			int tvShowsCount = TvShowLocalServiceUtil.getTvShowsCount(serviceContext);
			if(tvShowsCount > 0){
				
				TvShow lastTvShow = TvShowLocalServiceUtil.getTvShows(serviceContext).get(0);
				
				TvShowLocalServiceUtil.deleteTvShow(lastTvShow.getTvShowId(), serviceContext);
			}
			
		} catch (PortalException e) {

			_logger.error("testDeleteTvShow method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testDeleteTvShow method", e);
		}
		
	}
	
	// Season
	
	public void testAddSeason(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
		
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			int tvShowsCount = TvShowLocalServiceUtil.getTvShowsCount(serviceContext);		
			if(tvShowsCount > 0){
				
				TvShow lastTvShow = TvShowLocalServiceUtil.getTvShows(serviceContext).get(0);
				
				long countId = seasonCounter.getAndIncrement();
				SeasonLocalServiceUtil.addSeason(lastTvShow.getTvShowId(), "test" + String.valueOf(countId), 
						new Date(), 1, "test", "test", "test", "test", "test", serviceContext);

			}
			
			
		} catch (PortalException e) {

			_logger.error("testAddSeason method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testAddSeason method", e);
		}
		
	}
	
	public void testUpdateSeason(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			int tvShowsCount = TvShowLocalServiceUtil.getTvShowsCount(serviceContext);		
			if(tvShowsCount > 0){
				
				TvShow lastTvShow = TvShowLocalServiceUtil.getTvShows(serviceContext).get(0);
				
				int seasonsCount = SeasonLocalServiceUtil.getSeasonsCount(lastTvShow.getTvShowId(), serviceContext);
				if(seasonsCount > 0){
					
					Season lastSeason = SeasonLocalServiceUtil.getSeasons(lastTvShow.getTvShowId(), serviceContext).get(0);
					
					long countId = seasonCounter.getAndIncrement();
					SeasonLocalServiceUtil.updateSeason(lastTvShow.getTvShowId(), lastSeason.getSeasonId(), 
							"test" + String.valueOf(countId), new Date(), 1,"test", "test", "test", "test", "test", serviceContext);
					
				}
			}
			
			
		} catch (PortalException e) {

			_logger.error("testUpdateSeason method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testUpdateSeason method", e);
		}
		
	}
	
	public void testDeleteSeason(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			int tvShowsCount = TvShowLocalServiceUtil.getTvShowsCount(serviceContext);		
			if(tvShowsCount > 0){
				
				TvShow lastTvShow = TvShowLocalServiceUtil.getTvShows(serviceContext).get(0);
				
				int seasonsCount = SeasonLocalServiceUtil.getSeasonsCount(lastTvShow.getTvShowId(), serviceContext);
				if(seasonsCount > 0){
					
					Season lastSeason = SeasonLocalServiceUtil.getSeasons(lastTvShow.getTvShowId(), serviceContext).get(0);
					
					SeasonLocalServiceUtil.deleteSeason(lastSeason.getSeasonId());
					
				}
			}
			
			
		} catch (PortalException e) {

			_logger.error("testDeleteSeason method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testDeleteSeason method", e);
		}
		
	}
	
	// episode
	
	public void testAddEpisode(ActionRequest actionRequest, ActionResponse actionResponse){
		
	}
	
	public void testUpdateEpisode(ActionRequest actionRequest, ActionResponse actionResponse){
		
	}
	
	public void testDeleteEpisode(ActionRequest actionRequest, ActionResponse actionResponse){
		
	}

}
