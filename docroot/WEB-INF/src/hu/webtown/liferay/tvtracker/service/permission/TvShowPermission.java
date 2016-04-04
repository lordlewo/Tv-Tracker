package hu.webtown.liferay.tvtracker.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil;

public class TvShowPermission {

	public static final String RESOURCE_NAME = TvShow.class.getName();
	
	public static void check(PermissionChecker permissionChecker, long tvShowId, String actionId) throws PortalException, SystemException {
		
		// using the helper method for checking the permissions
		
		boolean hasPermission = TvShowPermission.contains(permissionChecker, tvShowId, actionId);
		
		if(!hasPermission){
			
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long tvShowId, String actionId) throws PortalException, SystemException {
		
		// retrieve the appropriate entity instance from the database
		
		TvShow tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId);
		
		
		// unbox and prepare some nessesery parameters
		
		long groupId = tvShow.getGroupId();
		
		
		// decide, if exist the apropriate permission for the action against the particular entity instance
		
		boolean hasPermission = permissionChecker.hasPermission(groupId, TvShowPermission.RESOURCE_NAME, tvShowId, actionId);
		
		
		return hasPermission;
	}
}
