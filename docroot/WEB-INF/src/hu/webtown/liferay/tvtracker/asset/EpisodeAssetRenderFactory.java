package hu.webtown.liferay.tvtracker.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

import hu.webtown.liferay.tvtracker.model.Episode;
import hu.webtown.liferay.tvtracker.service.EpisodeLocalServiceUtil;
import hu.webtown.liferay.tvtracker.service.permission.EpisodePermission;

public class EpisodeAssetRenderFactory extends BaseAssetRendererFactory{

	private static final String CLASS_NAME = Episode.class.getName();
	private static final String TYPE = "episode";
	private static final boolean _LINKABLE = true;
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type) throws PortalException, SystemException {
		
		Episode episode = EpisodeLocalServiceUtil.getEpisode(classPK);
		
		return new EpisodeAssetRenderer(episode);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, long classPK, String actionId) throws Exception {
		return EpisodePermission.contains(permissionChecker, classPK, actionId);
	}

}
