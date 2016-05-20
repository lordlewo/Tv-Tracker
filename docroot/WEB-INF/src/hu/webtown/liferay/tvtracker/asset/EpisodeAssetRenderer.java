package hu.webtown.liferay.tvtracker.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

import hu.webtown.liferay.tvtracker.model.Episode;
import hu.webtown.liferay.tvtracker.service.permission.EpisodePermission;
import hu.webtown.liferay.tvtracker.util.ActionKeys;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class EpisodeAssetRenderer extends BaseAssetRenderer {
	
	private static Log _logger = LogFactoryUtil.getLog(EpisodeAssetRenderer.class);
	
	private Episode _episode;
	
	public EpisodeAssetRenderer(Episode episode){
		this._episode = episode;
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {

		long episodeId = _episode.getEpisodeId();
		
		boolean contains = false;
		
		try {
			
			EpisodePermission.contains(permissionChecker, episodeId, ActionKeys.UPDATE);
			
		} catch (PortalException | SystemException e) {
			_logger.error(e.getLocalizedMessage());
		}
		
		return contains;
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		
		long episodeId = _episode.getEpisodeId();
		
		boolean contains = false;
		
		try {
			
			EpisodePermission.contains(permissionChecker, episodeId, ActionKeys.VIEW);
			
		} catch (PortalException | SystemException e) {
			_logger.error(e.getLocalizedMessage());
		}
		
		return contains;
	}
	
	@Override
	public String getClassName() {
		return Episode.class.getName();
	}

	@Override
	public long getClassPK() {
		return _episode.getEpisodeId();
	}

	@Override
	public long getGroupId() {
		return _episode.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _episode.getDescription();
	}

	@Override
	public String getTitle(Locale locale) {
		return _episode.getTitle();
	}

	@Override
	public long getUserId() {
		return _episode.getUserId();
	}

	@Override
	public String getUserName() {
		return _episode.getUserName();
	}

	@Override
	public String getUuid() {
		String uuid = "";
		
		try {
			uuid +=_episode.getUserUuid();
		} catch (SystemException e) {
			_logger.error(e.getLocalizedMessage());
		}
		
		return uuid;
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		if (template.equalsIgnoreCase(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("episode", _episode);
			
			return "/html/episodeadmin/" + template + ".jsp";
		} else {
			
			return null;
		}
	}
	
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getURLPortal() + "/tv-tracker-portlet/img/episode-icon.png";
	}

}
