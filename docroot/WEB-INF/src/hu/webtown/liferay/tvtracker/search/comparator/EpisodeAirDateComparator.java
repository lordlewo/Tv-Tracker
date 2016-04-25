package hu.webtown.liferay.tvtracker.search.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;

import hu.webtown.liferay.tvtracker.model.Episode;


public class EpisodeAirDateComparator extends OrderByComparator {

	private static final long serialVersionUID = -1984844521142790310L;
	

	public static final String ORDER_BY_ASC = "Episode.airDate ASC";
	
	public static final String ORDER_BY_DESC = "Episode.airDate DESC";
	
	public static final String[] ORDER_BY_FIELDS = {"airDate"};

	
	private boolean _ascending;
	
	public EpisodeAirDateComparator() {
		this(true);
	}

	public EpisodeAirDateComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	
	@Override
	public int compare(Object obj1, Object obj2) {
		
		Episode episode1 = (Episode) obj1;
		Episode episode2 = (Episode) obj2;
		
		Date episode1_AirDate = episode1.getAirDate();
		Date episode2_AirDate = episode2.getAirDate();
		
		int value = 0;
		
		if(episode1_AirDate.after(episode2_AirDate)){
			
			value = 1;
			
		} else if (episode1_AirDate.before(episode2_AirDate)){
			
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
