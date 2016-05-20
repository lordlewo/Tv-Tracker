package hu.webtown.liferay.tvtracker.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.service.permission.SeasonPermission;
import hu.webtown.liferay.tvtracker.util.ActionKeys;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SeasonAssetRenderer extends BaseAssetRenderer {
	
	private static Log _logger = LogFactoryUtil.getLog(SeasonAssetRenderer.class);
	
	private Season _season;
	
	public SeasonAssetRenderer(Season season){
		this._season = season;
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {

		long seasonId = _season.getSeasonId();
		
		boolean contains = false;
		
		try {
			
			SeasonPermission.contains(permissionChecker, seasonId, ActionKeys.UPDATE);
			
		} catch (PortalException | SystemException e) {
			_logger.error(e.getLocalizedMessage());
		}
		
		return contains;
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		
		long seasonId =  _season.getSeasonId();
		
		boolean contains = false;
		
		try {
			
			SeasonPermission.contains(permissionChecker, seasonId, ActionKeys.VIEW);
			
		} catch (PortalException | SystemException e) {
			_logger.error(e.getLocalizedMessage());
		}
		
		return contains;
	}
	
	@Override
	public String getClassName() {
		return Season.class.getName();
	}

	@Override
	public long getClassPK() {
		return _season.getSeasonId();
	}

	@Override
	public long getGroupId() {
		return _season.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _season.getDescription();
	}

	@Override
	public String getTitle(Locale locale) {
		return _season.getTitle();
	}

	@Override
	public long getUserId() {
		return _season.getUserId();
	}

	@Override
	public String getUserName() {
		return _season.getUserName();
	}

	@Override
	public String getUuid() {
		String uuid = "";
		
		try {
			uuid +=_season.getUserUuid();
		} catch (SystemException e) {
			_logger.error(e.getLocalizedMessage());
		}
		
		return uuid;
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		
		if (template.equalsIgnoreCase(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("season", _season);
			
			return "/html/tvshowadmin/" + template + ".jsp";
		} else {
			
			return null;
		}
	}
	
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {	
		return themeDisplay.getURLPortal() + "/tv-tracker-portlet/img/season-icon.png";
	}

}
