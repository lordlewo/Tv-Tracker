package hu.webtown.liferay.tvtracker.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil;
import hu.webtown.liferay.tvtracker.service.permission.SeasonPermission;

public class SeasonAssetRendererFactory extends BaseAssetRendererFactory{

	private static final String CLASS_NAME = Season.class.getName();
	private static final String TYPE = "season";
	private static final boolean _LINKABLE = true;
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type) throws PortalException, SystemException {

		Season season = SeasonLocalServiceUtil.getSeason(classPK);
		
		return new SeasonAssetRenderer(season);
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
		return SeasonPermission.contains(permissionChecker, classPK, actionId);
	}

}
