package hu.webtown.liferay.tvtracker.portlet.admin;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class TvShowAdminPortlet
 */
public class TvShowAdminPortlet extends MVCPortlet {
	
	private static Log _logger = LogFactoryUtil.getLog(TvShowAdminPortlet.class);
	
	
	
	public void addTvShow(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		int i = 0;
		i++;
	}
	
	public void updateTvShow(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
			
	}
	
	public void deleteTvShow(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		
	}

}
