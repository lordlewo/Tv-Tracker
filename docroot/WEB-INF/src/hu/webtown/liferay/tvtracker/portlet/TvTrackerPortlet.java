package hu.webtown.liferay.tvtracker.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil;
import hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil;
import hu.webtown.liferay.tvtracker.util.WebKeys;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

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
			
			
		} catch (Exception e) {
			
			_logger.error("render method", e);
			
			throw new PortletException(e);
		}
		
		super.render(renderRequest, renderResponse);
	}
	
	
/****************************************************************************************************************************/
/****************************************************************************************************************************/	


	// TvShow
	
	public void testAddTvShow(ActionRequest actionRequest, ActionResponse actionResponse){
			
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(TvShow.class.getName(), actionRequest);
			
			
			String title = "Game of Thrones";
			Calendar cal = Calendar.getInstance();
			cal.set(2011, 4, 18);
			String description = "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and the icy horrors beyond.";
			String imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";
			
			TvShowLocalServiceUtil.addTvShow(title, cal.getTime(), description, imageUrl, "test", "test", "test", serviceContext);
			
			
			
			title = "Mr Robot";
			cal.set(2015, 6, 24);
			description = "The show follows Elliot, who is a cyber-security tech by day and vigilante hacker by night. He has used his hacking skills for justice and to protect those he cares about, but has problems connecting to people in the real world due to social anxiety. He strongly believes that the world is being ruled by the 1% of the 1% and, that using money and debt, they have enslaved mankind and he wishes desperately to change this. He is recruited by the head of a highly secret hacking group to take down the";
			imageUrl = "http://localhost:8080/documents/20181/20823/mrrobot.jpg/6f9ea41a-5e30-46be-922f-e2f50a049ffb?t=1459427851000";
			
			TvShowLocalServiceUtil.addTvShow(title, cal.getTime(), description, imageUrl, "test", "test", "test", serviceContext);
			
			
			
			title = "Sherlock";
			cal.set(2010, 7, 25);
			description = "Sherlock is a British television crime drama that presents a contemporary adaptation of Sir Arthur Conan Doyle's Sherlock Holmes detective stories. Created by Steven Moffat and Mark Gatiss, it stars Benedict Cumberbatch as Sherlock Holmes and Martin Freeman as Doctor John Watson.";
			imageUrl = "http://localhost:8080/documents/20181/20823/sherlock.jpg/01f58bd1-37d9-4555-b4f2-da50f3276023?t=1459427851000";
			
			TvShowLocalServiceUtil.addTvShow(title, cal.getTime(), description, imageUrl, "test", "test", "test", serviceContext);
			
			
		} catch (PortalException e) {

			_logger.error("testAddTvShow method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testAddTvShow method", e);
		}
		
	}
	
	public void testUpdateTvShow(ActionRequest actionRequest, ActionResponse actionResponse){
		
	}
	
	public void testDeleteTvShow(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
				
			List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(serviceContext);
			
			for (TvShow tvShow : tvShows) {
				
				long tvShowId = tvShow.getTvShowId();
				
				TvShowLocalServiceUtil.deleteTvShow(tvShowId, serviceContext);
				
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
				
				List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(serviceContext);
				
				long tvshowId = tvShows.get(0).getTvShowId();
				String title = "Season 1";
				Calendar cal = Calendar.getInstance();
				cal.set(2011, 4, 18);
				int seasonNumber = 1;
				String description = "The first season of the epic fantasy television drama series Game of Thrones premiered on HBO on April 17, 2011, and concluded on June 19, 2011, airing on Sunday at 9:00 pm in the United States. It consisted of 10 episodes, each running approximately 55 minutes in length. Game of Thrones is based on the novel A Game of Thrones, the first entry in A Song of Ice and Fire series by George R. R. Martin. The story takes place in a fictional world, primarily upon a continent called Westeros. The noble";
				String imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

				
				tvshowId = tvShows.get(0).getTvShowId();
				title = "Season 2";
				cal.set(2012, 4, 2);
				seasonNumber = 2;
				description = "The second season of the epic fantasy drama television series Game of Thrones premiered in the United States on HBO on April 1, 2012, and concluded on June 3, 2012. Like the first season, it consists of ten episodes. It mostly covers the events of A Clash of Kings, the second book of the A Song of Ice and Fire novels by George R. R. Martin, of which the series is an adaptation.";
				imageUrl = "http://localhost:8080/documents//20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

				
				tvshowId = tvShows.get(1).getTvShowId();
				title = "Season 1";
				cal.set(2015, 6, 25);
				seasonNumber = 1;
				description = "The show follows Elliot, who is a cyber-security tech by day and vigilante hacker by night. He has used his hacking skills for justice and to protect those he cares about, but has problems connecting to people in the real world due to social anxiety. He strongly believes that the world is being ruled by the 1% of the 1% and, that using money and debt, they have enslaved mankind and he wishes desperately to change this. He is recruited by the head of a highly secret hacking group to take down the";
				imageUrl = "http://localhost:8080/documents/20181/20823/mrrobot.jpg/6f9ea41a-5e30-46be-922f-e2f50a049ffb?t=1459427851000";
				
				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

				
				tvshowId = tvShows.get(1).getTvShowId();
				title = "Season 2";
				cal.set(2015, 6, 25);
				seasonNumber = 2;
				description = "The show follows Elliot, who is a cyber-security tech by day and vigilante hacker by night. He has used his hacking skills for justice and to protect those he cares about, but has problems connecting to people in the real world due to social anxiety. He strongly believes that the world is being ruled by the 1% of the 1% and, that using money and debt, they have enslaved mankind and he wishes desperately to change this. He is recruited by the head of a highly secret hacking group to take down the";
				imageUrl = "http://localhost:8080/documents/20181/20823/mrrobot.jpg/6f9ea41a-5e30-46be-922f-e2f50a049ffb?t=1459427851000";
				
				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

				
				tvshowId = tvShows.get(2).getTvShowId();
				title = "Season 1";
				cal.set(2010, 7, 25);
				seasonNumber = 1;
				description = "Sherlock is a British television crime drama that presents a contemporary adaptation of Sir Arthur Conan Doyle's Sherlock Holmes detective stories. Created by Steven Moffat and Mark Gatiss, it stars Benedict Cumberbatch as Sherlock Holmes and Martin Freeman as Doctor John Watson.";
				imageUrl = "http://localhost:8080/documents/20181/20823/sherlock.jpg/01f58bd1-37d9-4555-b4f2-da50f3276023?t=1459427851000";
				
				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

				
				tvshowId = tvShows.get(2).getTvShowId();
				title = "Season 2";
				cal.set(2012, 1, 1);
				seasonNumber = 1;
				description = "Sherlock is a British television crime drama that presents a contemporary adaptation of Sir Arthur Conan Doyle's Sherlock Holmes detective stories. Created by Steven Moffat and Mark Gatiss, it stars Benedict Cumberbatch as Sherlock Holmes and Martin Freeman as Doctor John Watson.";
				imageUrl = "http://localhost:8080/documents/20181/20823/sherlock.jpg/01f58bd1-37d9-4555-b4f2-da50f3276023?t=1459427851000";
				
				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

			}
			
			
			
		} catch (PortalException e) {

			_logger.error("testAddSeason method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testAddSeason method", e);
		}
		
	}
	
	public void testUpdateSeason(ActionRequest actionRequest, ActionResponse actionResponse){
		
		
	}
	
	public void testDeleteSeason(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(serviceContext);
			
			for (TvShow tvShow : tvShows) {
				
				long tvShowId = tvShow.getTvShowId();
				
				List<Season> seasons = SeasonLocalServiceUtil.getSeasons(tvShowId, serviceContext);
				
				for (Season season : seasons) {
					
					long seasonId = season.getSeasonId();
					
					SeasonLocalServiceUtil.deleteSeason(seasonId, serviceContext);
					
				}
				
			}
			
			List<Season> sl = SeasonLocalServiceUtil.getSeasons(-1, -1);
			
			for (Season season : sl) {
				SeasonLocalServiceUtil.deleteSeason(season);
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
