package hu.webtown.liferay.tvtracker.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil;

public class SeasonPermission {
	
	public static final String RESOURCE_NAME = Season.class.getName();
	
	public static void check(PermissionChecker permissionChecker, long seasonId, String actionId) throws PortalException, SystemException {
		
		// using the helper method for checking the permissions
		
		boolean hasPermission = SeasonPermission.contains(permissionChecker, seasonId, actionId);
		
		if(!hasPermission){
			
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long seasonId, String actionId) throws PortalException, SystemException {
		
		// retrieve the appropriate entity instance from the database
		
		Season season = SeasonLocalServiceUtil.getSeason(seasonId);
		
		
		// unbox and prepare some nessesery parameters
		
		long groupId = season.getGroupId();
		
		
		// decide, if exist the apropriate permission for the action against the particular entity instance
		
		boolean hasPermission = permissionChecker.hasPermission(groupId, SeasonPermission.RESOURCE_NAME, seasonId, actionId);
		
		
		return hasPermission;
	}
}
