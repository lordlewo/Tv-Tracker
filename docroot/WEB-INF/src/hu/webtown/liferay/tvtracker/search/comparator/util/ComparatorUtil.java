package hu.webtown.liferay.tvtracker.search.comparator.util;

import com.liferay.portal.kernel.util.OrderByComparator;

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
	
}
