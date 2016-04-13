package hu.webtown.liferay.tvtracker.search.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

import hu.webtown.liferay.tvtracker.model.TvShow;

public class TvShowTitleComparator extends OrderByComparator {	

	private static final long serialVersionUID = -2488681666841136547L;

	
	public static final String ORDER_BY_ASC = "TvShow.title ASC";
	
	public static final String ORDER_BY_DESC = "TvShow.title DESC";
	
	public static final String[] ORDER_BY_FIELDS = {"title"};
	
	
	private boolean _ascending;
	
	public TvShowTitleComparator() {
		this(true);
	}

	public TvShowTitleComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		
		TvShow tvShow1 = (TvShow) obj1;
		TvShow tvShow2 = (TvShow) obj1;
		
		String tvShowTitle1 = tvShow1.getTitle();
		String tvShowTitle2 = tvShow2.getTitle();
		
		int value = tvShowTitle1.compareToIgnoreCase(tvShowTitle2);
		
		
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
