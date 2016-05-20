package hu.webtown.liferay.tvtracker.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.service.permission.TvShowPermission;
import hu.webtown.liferay.tvtracker.util.ActionKeys;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class TvShowAssetRenderer extends BaseAssetRenderer {

	private static Log _logger = LogFactoryUtil.getLog(TvShowAssetRenderer.class);
	
	private TvShow _tvShow;
	
	public TvShowAssetRenderer(TvShow tvShow){
		this._tvShow = tvShow;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {

		long tvShowId = _tvShow.getTvShowId();
		
		boolean contains = false;
		
		try {
			
			TvShowPermission.contains(permissionChecker, tvShowId, ActionKeys.UPDATE);
			
		} catch (PortalException | SystemException e) {
			_logger.error(e.getLocalizedMessage());
		}
		
		return contains;
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		
		long tvShowId = _tvShow.getTvShowId();
		
		boolean contains = false;
		
		try {
			
			TvShowPermission.contains(permissionChecker, tvShowId, ActionKeys.VIEW);
			
		} catch (PortalException | SystemException e) {
			_logger.error(e.getLocalizedMessage());
		}
		
		return contains;
	}
	
	@Override
	public String getClassName() {
		return TvShow.class.getName();
	}

	@Override
	public long getClassPK() {
		return _tvShow.getTvShowId();
	}

	@Override
	public long getGroupId() {
		return _tvShow.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _tvShow.getDescription();
	}

	@Override
	public String getTitle(Locale locale) {
		return _tvShow.getTitle();
	}

	@Override
	public long getUserId() {
		return _tvShow.getUserId();
	}

	@Override
	public String getUserName() {
		return _tvShow.getUserName();
	}

	@Override
	public String getUuid() {
		String uuid = "";
		
		try {
			uuid +=_tvShow.getUserUuid();
		} catch (SystemException e) {
			_logger.error(e.getLocalizedMessage());
		}
		
		return uuid;
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		
		if (template.equalsIgnoreCase(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("tvShow", _tvShow);
			
			return "/html/tvshowadmin/" + template + ".jsp";
		} else {
			
			return null;
		}
		
	}
	
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getURLPortal() + "/tv-tracker-portlet/img/tvshow-icon.png";
	}

}
