package hu.webtown.liferay.tvtracker.search.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.tvtracker.model.TvShow;

public class TvShowPremierYearComparator extends OrderByComparator{

	private static final long serialVersionUID = -592596501605091999L;
	

	public static final String ORDER_BY_ASC = "TvShow.premierDate ASC";
	
	public static final String ORDER_BY_DESC = "TvShow.premierDate DESC";
	
	public static final String[] ORDER_BY_FIELDS = {"premierDate"};

	
	private boolean _ascending;
	
	public TvShowPremierYearComparator() {
		this(true);
	}

	public TvShowPremierYearComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		
		TvShow tvShow1 = (TvShow) obj1;
		TvShow tvShow2 = (TvShow) obj2;
		
		int tvShowPremierYear1 = tvShow1.getPremierYear();
		int tvShowPremierYear2 = tvShow2.getPremierYear();
		
		int value = 0;
		
		if(tvShowPremierYear1 > tvShowPremierYear2){
			
			value = 1;
			
		} else if (tvShowPremierYear1 < tvShowPremierYear2){
			
			value = -1;
			
		}
		
		return _ascending ? value : -value;
	}
	
	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}
	
	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

}
