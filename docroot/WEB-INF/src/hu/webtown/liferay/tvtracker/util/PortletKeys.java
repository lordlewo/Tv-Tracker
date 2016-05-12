package hu.webtown.liferay.tvtracker.util;

public class PortletKeys extends com.liferay.portal.util.PortletKeys {
	
	// non-instanceable: [portlet ID] + _WAR_ + [webapp name, where portlet is placed]
	// instanceable:     [portlet ID] + _WAR_ + [webapp name, where portlet is placed] + _INSTANCE_ + [portlet instance ID]
	
	// "portlet.xml -> portlet-name" + "_WAR_" + "build.xml -> project.name" 
	
	public static final String TV_TRACKER = "tvtracker_WAR_tvtrackerporlet";
	
	public static final String TVSHOW_ADMIN = "tvshowadmin_WAR_tvtrackerporlet";
	
	public static final String EPISODE_ADMIN = "episodeadmin_WAR_tvtrackerporlet";

}
