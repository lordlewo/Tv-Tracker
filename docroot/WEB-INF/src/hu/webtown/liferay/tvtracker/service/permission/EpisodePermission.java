package hu.webtown.liferay.tvtracker.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.tvtracker.model.Episode;
import hu.webtown.liferay.tvtracker.service.EpisodeLocalServiceUtil;

public class EpisodePermission {
	
	public static final String RESOURCE_NAME = Episode.class.getName();
	
	public static void check(PermissionChecker permissionChecker, long episodeId, String actionId) throws PortalException, SystemException{
		
		// using the helper method for checking the permissions
		
		boolean hasPermission = EpisodePermission.contains(permissionChecker, episodeId, actionId);
		
		if(!hasPermission){
			
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long episodeId, String actionId) throws PortalException, SystemException{
		
		// retrieve the appropriate entity instance from the database
		
		Episode episode = EpisodeLocalServiceUtil.getEpisode(episodeId);
		
		
		// unbox and prepare some nessesery parameters
		
		long groupId = episode.getGroupId();
		
		
		// decide, if exist the apropriate permission for the action against the particular entity instance
		
		boolean hasPermission = permissionChecker.hasPermission(groupId, EpisodePermission.RESOURCE_NAME, episodeId, actionId);
		
		
		return hasPermission;
	}

}
