package hu.webtown.liferay.tvtracker.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.webtown.liferay.tvtracker.model.Episode;
import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.service.EpisodeLocalServiceUtil;
import hu.webtown.liferay.tvtracker.service.SeasonLocalService;
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
			
			/*long tvShowId = ParamUtil.getLong(renderRequest, WebKeys.TVSHOW_ID);
			
			renderRequest.setAttribute(WebKeys.TVSHOW_ID, tvShowId);*/
			
			
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
			description = "The show follows Elliot, who is a cyber-security tech by day and vigilante hacker by night. He has used his hacking skills for justice and to protect those he cares about, but has problems connecting to people in the real world due to social anxiety. He strongly believes that the world is being ruled by the 1% of the 1% and, that using money and debt, they have enslaved mankind and he wishes desperately to change this. He is recruited by the head of a highly secret hacking group to take down the corporation he is being paid to protect with the hope of erasing 70% of all the debt in the world. He has had delusions in the past and sees a therapist who tries to help him and takes medication for it, but in the end he is unsure what is real and what is not, and so are we as we experience everything from his perspective.";
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
				String description = "The first season of the epic fantasy television drama series Game of Thrones premiered on HBO on April 17, 2011, and concluded on June 19, 2011, airing on Sunday at 9:00 pm in the United States. It consisted of 10 episodes, each running approximately 55 minutes in length. Game of Thrones is based on the novel A Game of Thrones, the first entry in A Song of Ice and Fire series by George R. R. Martin. The story takes place in a fictional world, primarily upon a continent called Westeros. The noble House Stark, led by Lord Eddard \"Ned\" Stark is drawn into schemes against King Robert Baratheon when the Hand of the King Jon Arryn dies mysteriously.";
				String imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

				
				tvshowId = tvShows.get(0).getTvShowId();
				title = "Season 2";
				cal.set(2012, 4, 2);
				seasonNumber = 2;
				description = "The second season of the epic fantasy drama television series Game of Thrones premiered in the United States on HBO on April 1, 2012, and concluded on June 3, 2012. Like the first season, it consists of ten episodes. It mostly covers the events of A Clash of Kings, the second book of the A Song of Ice and Fire novels by George R. R. Martin, of which the series is an adaptation.";
				imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

				
				tvshowId = tvShows.get(0).getTvShowId();
				title = "Season 3";
				cal.set(2013, 4, 1);
				seasonNumber = 3;
				description = "The third season of the epic fantasy drama television series Game of Thrones premiered on March 31, 2013 on HBO. HBO renewed the series for a third season on April 10, 2012, nine days after the second season's premiere. Production began in July 2012. Like the other seasons, the third season consists of ten episodes. It is based roughly on the first half of A Storm of Swords of which the series is an adaptation.";
				imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

				
				tvshowId = tvShows.get(0).getTvShowId();
				title = "Season 4";
				cal.set(2014, 4, 7);
				seasonNumber = 4;
				description = "The War of the Five Kings is drawing to a close, but new intrigues and plots are in motion, and the surviving factions must contend with enemies not only outside their ranks, but within.";	
				imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

				
				tvshowId = tvShows.get(0).getTvShowId();
				title = "Season 5";
				cal.set(2015, 4, 13);
				seasonNumber = 5;
				description = "The War of the Five Kings, once thought to be drawing to a close, is instead entering a new and more chaotic phase. Westeros is on the brink of collapse, and many are seizing what they can while the realm implodes, like a corpse making a feast for crows.";
				imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

				SeasonLocalServiceUtil.addSeason(tvshowId, title , cal.getTime(), seasonNumber, description, imageUrl, "test", "test", "test", serviceContext);

				
				tvshowId = tvShows.get(0).getTvShowId();
				title = "Season 6";
				cal.set(2016, 4, 25);
				seasonNumber = 6;
				description = "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and the icy horrors beyond.";
				imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

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


		} catch (PortalException e) {

			_logger.error("testDeleteSeason method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testDeleteSeason method", e);
		}
		
	}
	
	// episode
	
	public void testAddEpisode(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(TvShow.class.getName(), actionRequest);
			
			int tvShowsCount = TvShowLocalServiceUtil.getTvShowsCount(serviceContext);
			
			if(tvShowsCount > 0){
				
				List<TvShow> tvshows = TvShowLocalServiceUtil.getTvShows(serviceContext);
				
				TvShow got = tvshows.get(0);
				long tvShowId = got.getTvShowId();
				
				int seasonCount = SeasonLocalServiceUtil.getSeasonsCount(tvShowId, serviceContext);
				
				if(seasonCount > 0){
					
					List<Season> seasons = SeasonLocalServiceUtil.getSeasons(tvShowId, serviceContext);
					
					long seasonId = seasons.get(0).getSeasonId();
					String title = "Winter Is Coming";
					Calendar cal = Calendar.getInstance();
					cal.set(2011, 4, 18);
					int episodeNumber = 1;
					String description = "Ned Stark, Lord of Winterfell learns that his mentor, Jon Arryn, has died and that King Robert is on his way north to offer Ned Arryn’s position as the King’s Hand. Across the Narrow Sea in Pentos, Viserys Targaryen plans to wed his sister Daenerys to the nomadic Dothraki warrior leader, Khal Drogo to forge an alliance to take the throne.";
					String imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

					EpisodeLocalServiceUtil.addEpisode(seasonId, title, cal.getTime(), episodeNumber, description, imageUrl, "test", "test", "test", serviceContext);
					
					
					seasonId = seasons.get(0).getSeasonId();
					title = "The Kingsroad";
					cal = Calendar.getInstance();
					cal.set(2011, 4, 25);
					episodeNumber = 2;
					description = "Having agreed to become the King’s Hand, Ned leaves Winterfell with daughters Sansa and Arya, while Catelyn stays behind in Winterfell. Jon Snow heads north to join the brotherhood of the Night’s Watch. Tyrion decides to forego the trip south with his family, instead joining Jon in the entourage heading to the Wall. Viserys bides his time in hopes of winning back the throne, while Daenerys focuses her attention on learning how to please her new husband, Drogo.";
					imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

					EpisodeLocalServiceUtil.addEpisode(seasonId, title, cal.getTime(), episodeNumber, description, imageUrl, "test", "test", "test", serviceContext);
					
					
					seasonId = seasons.get(0).getSeasonId();
					title = "Lord Snow";
					cal = Calendar.getInstance();
					cal.set(2011, 5, 2);
					episodeNumber = 3;
					description = "Arriving at King’s Landing, Ned is shocked to learn of the Crown’s profligacy from his new advisors. At Castle Black, Jon Snow impresses Tyrion at the expense of greener recruits. Suspecting the Lannisters had a hand in Bran’s fall, Catelyn covertly follows her husband to King’s Landing, where she is intercepted by Petyr Baelish, a.k.a. “Littlefinger,” a shrewd longtime ally and brothel owner. Cersei and Jaime ponder the implications of Bran’s recovery; Arya studies swordsmanship. On the road to Vaes Dothrak, Daenerys finds herself at odds with Viserys.";
					imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

					EpisodeLocalServiceUtil.addEpisode(seasonId, title, cal.getTime(), episodeNumber, description, imageUrl, "test", "test", "test", serviceContext);
					
					
					seasonId = seasons.get(0).getSeasonId();
					title = "Cripples, Bastards, and Broken Things";
					cal = Calendar.getInstance();
					cal.set(2011, 5, 9);
					episodeNumber = 4;
					description = "Ned looks for clues to the death of his predecessor, and uncovers one of King Robert’s bastards. Robert and his guests witness a tournament honoring Ned. Jon takes measures to protect Sam from further abuse at Castle Black; a frustrated Viserys clashes with Daenerys in Vaes Dothrak; Sansa imagines her future as a queen, while Arya envisions a far different future. Catelyn rallies her husband’s allies to make a point, while Tyrion finds himself caught in the wrong place at the wrong time.";
					imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

					EpisodeLocalServiceUtil.addEpisode(seasonId, title, cal.getTime(), episodeNumber, description, imageUrl, "test", "test", "test", serviceContext);
					
					
					seasonId = seasons.get(0).getSeasonId();
					title = "The Wolf and the Lion";
					cal = Calendar.getInstance();
					cal.set(2011, 5, 16);
					episodeNumber = 5;
					description = "Incensed over news of Daenerys’ alliance with the Dothrakis, Robert orders a preemptive strike on the Targaryens that drives a wedge in his relationship with Ned. A captive Tyrion helps Catelyn, but receives a cold reception at the Eyrie from her sister, Jon Arryn’s widow Lysa. Sansa is charmed by the dashing Ser Loras Tyrell, a.k.a. the Knight of Flowers. Arya overhears a plot against her father.";
					imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

					EpisodeLocalServiceUtil.addEpisode(seasonId, title, cal.getTime(), episodeNumber, description, imageUrl, "test", "test", "test", serviceContext);
					
					
					seasonId = seasons.get(0).getSeasonId();
					title = "A Golden Crown";
					cal = Calendar.getInstance();
					cal.set(2011, 5,23);
					episodeNumber = 6;
					description = "Reinstated as the Hand, Ned sits for the King while Robert is on a hunt. Ned issues a decree that could have long-term consequences throughout the Seven Kingdoms. At the Eyrie, Tyrion confesses to his \"crimes,\" and demands that Lysa give him a trial by combat. Joffrey apologizes to Sansa. Viserys receives his final payment for Daenerys from Drogo.";
					imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

					EpisodeLocalServiceUtil.addEpisode(seasonId, title, cal.getTime(), episodeNumber, description, imageUrl, "test", "test", "test", serviceContext);
					
					
					seasonId = seasons.get(0).getSeasonId();
					title = "You Win or You Die";
					cal = Calendar.getInstance();
					cal.set(2011, 5, 30);
					episodeNumber = 7;
					description = "Explaining that the future of the Lannisters is at stake, Tywin presses Jaime to “be the man you were meant to be” as they prepare for battle. Ned confronts Cersei about the secrets that killed Jon Arryn. With the fate of the missing Benjen very much on his mind, Jon takes his Night’s Watch vows, though not with the assignment he coveted. After Ser Jorah saves Daenerys from treachery, an enraged Drogo vows to lead the Dothraki where they’ve never gone before. An injured Robert takes pains to ensure an orderly transition at King’s Landing.";
					imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

					EpisodeLocalServiceUtil.addEpisode(seasonId, title, cal.getTime(), episodeNumber, description, imageUrl, "test", "test", "test", serviceContext);
					
					
					seasonId = seasons.get(0).getSeasonId();
					title = "The Pointy End";
					cal = Calendar.getInstance();
					cal.set(2011, 7, 6);
					episodeNumber = 8;
					description = "In the aftermath of Ned's capture, Syrio and Arya face off against Lannister guards, while Cersei manipulates Sansa to her own ends. Robb rallies his father's northern allies against Tywin Lannister and heads south to war. Tyrion forms an uneasy alliance with the hill tribes and reunites with his father. Jon lashes out at Ser Alliser Thorne and battles a mysterious attacker from beyond the Wall. Dany is forced to reconcile her desire to conquer Westeros with Drogo's savagery after the Dothraki raid a peaceful village.";
					imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

					EpisodeLocalServiceUtil.addEpisode(seasonId, title, cal.getTime(), episodeNumber, description, imageUrl, "test", "test", "test", serviceContext);
					
					
					seasonId = seasons.get(0).getSeasonId();
					title = "Baelor";
					cal = Calendar.getInstance();
					cal.set(2011, 6, 13);
					episodeNumber = 9;
					description = "With Sansa's life in danger, Ned makes a fateful decision. Catelyn brokers an unsavory deal with the slippery Walder Frey. Tyrion acquires a mistress and is forced by his father to fight on the front lines. Robb wins his first major victory and captures a prized prisoner. Jon is rewarded for his valor and discovers a dark secret about Maester Aemon. As Drogo's wound festers, Dany defies her bloodrider Qotho and puts her trust in the enslaved witch Mirri Maz Duur.";
					imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

					EpisodeLocalServiceUtil.addEpisode(seasonId, title, cal.getTime(), episodeNumber, description, imageUrl, "test", "test", "test", serviceContext);
					
					
					seasonId = seasons.get(0).getSeasonId();
					title = "Fire and Blood";
					cal = Calendar.getInstance();
					cal.set(2011, 6, 20);
					episodeNumber = 10;
					description = "As tragic news spreads across the Seven Kingdoms, Bran and Rickon share a prophetic dream, Catelyn interrogates Jamie about her son's fall, and Robb's destiny is forever changed. After a surprising decision by his father, Tyrion heads south. Arya assumes a new identity in an attempt to escape King's Landing, and Sansa is terrorized by Joffrey. At the Wall, Jon is forced to choose between the Night's Watch and the family he left behind. Across the sea, Dany pays a terrible price for her love, but finds new hope.";
					imageUrl = "http://localhost:8080/documents/20181/20823/got.jpg/938845ce-438f-43d5-bd5d-60da2c471220?t=1459427850000";

					EpisodeLocalServiceUtil.addEpisode(seasonId, title, cal.getTime(), episodeNumber, description, imageUrl, "test", "test", "test", serviceContext);
					
				}
			}

		} catch (PortalException e) {

			_logger.error("testDeleteEpisode method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testDeleteEpisode method", e);
		}
		
	}
	
	public void testDeleteEpisode(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(serviceContext);
			
			for (TvShow tvShow : tvShows) {
				
				long tvShowId = tvShow.getTvShowId();
				
				List<Season> seasons = SeasonLocalServiceUtil.getSeasons(tvShowId, serviceContext);
				
				for (Season season : seasons) {
					
					long seasonId = season.getSeasonId();
					
					List<Episode> episodes = EpisodeLocalServiceUtil.getEpisodes(seasonId, serviceContext);
					
					for (Episode episode : episodes) {
						
						long episodeId = episode.getEpisodeId();
						
						EpisodeLocalServiceUtil.deleteEpisode(episodeId, serviceContext);
						
					}
					
				}
				
			}

		} catch (PortalException e) {

			_logger.error("testAddEpisode method", e);
			
		} catch (SystemException e) {
			
			_logger.error("testAddEpisode method", e);
		}
		
	}

}
