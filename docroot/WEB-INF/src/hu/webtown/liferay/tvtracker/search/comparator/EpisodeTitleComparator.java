package hu.webtown.liferay.tvtracker.search.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.tvtracker.model.Episode;


public class EpisodeTitleComparator extends OrderByComparator {

	private static final long serialVersionUID = -1079424077860590795L;
	

	public static final String ORDER_BY_ASC = "Episode.title ASC";
	
	public static final String ORDER_BY_DESC = "Episode.title DESC";
	
	public static final String[] ORDER_BY_FIELDS = {"title"};
	
	
	private boolean _ascending;

	public EpisodeTitleComparator() {
		this(true);
	}
	
	public EpisodeTitleComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		
		Episode episode1 = (Episode) obj1;
		Episode episode2 = (Episode) obj1;
		
		String episode1_Title = episode1.getTitle();
		String episode2_Title = episode2.getTitle();
		
		int value = episode1_Title.compareToIgnoreCase(episode2_Title);
		
		
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
