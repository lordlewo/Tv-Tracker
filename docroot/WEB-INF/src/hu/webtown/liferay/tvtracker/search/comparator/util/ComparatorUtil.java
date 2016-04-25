package hu.webtown.liferay.tvtracker.search.comparator.util;

import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.tvtracker.search.comparator.EpisodeAirDateComparator;
import hu.webtown.liferay.tvtracker.search.comparator.EpisodeTitleComparator;
import hu.webtown.liferay.tvtracker.search.comparator.TvShowPremierYearComparator;
import hu.webtown.liferay.tvtracker.search.comparator.TvShowTitleComparator;

public class ComparatorUtil {
	
	public static OrderByComparator getTvShowOrderByComparator(String orderByCol, String orderByType){
		
		boolean orderByAsc= false;
		
		if(orderByType.equalsIgnoreCase("asc")){
			
			orderByAsc = true;
		
		}
		

		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equalsIgnoreCase("title")){
			
			orderByComparator = new TvShowTitleComparator(orderByAsc);
		
		} else if (orderByCol.equalsIgnoreCase("premierYear")) {
			
			orderByComparator = new TvShowPremierYearComparator(orderByAsc);
			
		}
		
		
		return orderByComparator;
	}
	
	
	public static OrderByComparator getEpisodeOrderByComparator(String orderByCol, String orderByType){
		
		boolean orderByAsc= false;
		
		if(orderByType.equalsIgnoreCase("asc")){
			
			orderByAsc = true;
		
		}
		

		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equalsIgnoreCase("title")){
			
			orderByComparator = new EpisodeTitleComparator(orderByAsc);
		
		} else if (orderByCol.equalsIgnoreCase("airDate")) {
			
			orderByComparator = new EpisodeAirDateComparator(orderByAsc);
			
		}
		
		
		return orderByComparator;
	}
}
