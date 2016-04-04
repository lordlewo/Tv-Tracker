package hu.webtown.liferay.tvtracker.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.tvtracker.model.TvShow;

public class TvTrackerModelPermission {
	
	public static final String RESOURCE_NAME = TvShow.class.getPackage().getName();
	
	public static void check(PermissionChecker permissionChecker, long groupId, String actionId) throws PortalException {
		
		// using the helper method for checking the permissions
		
		boolean hasPermisson = TvTrackerModelPermission.contains(permissionChecker, groupId, actionId);
		
		if (!hasPermisson) {
			
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		// decide, if exist the apropriate permission against the action 
		
		boolean hasPermission = permissionChecker.hasPermission(groupId, TvTrackerModelPermission.RESOURCE_NAME, groupId, actionId);
		
		
		return hasPermission;
	}
}
