/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package hu.webtown.liferay.tvtracker.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author czeni
 */
public class TvShowFinderUtil {
	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByPremierYear(
		int premierYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByPremierYear(premierYear, start, end);
	}

	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByPremierYear(
		int premierYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByPremierYear(premierYear);
	}

	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByG_P(
		long groupId, int premierYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_P(groupId, premierYear, start, end);
	}

	public static java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByG_P(
		long groupId, int premierYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_P(groupId, premierYear);
	}

	public static TvShowFinder getFinder() {
		if (_finder == null) {
			_finder = (TvShowFinder)PortletBeanLocatorUtil.locate(hu.webtown.liferay.tvtracker.service.ClpSerializer.getServletContextName(),
					TvShowFinder.class.getName());

			ReferenceRegistry.registerReference(TvShowFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TvShowFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TvShowFinderUtil.class, "_finder");
	}

	private static TvShowFinder _finder;
}