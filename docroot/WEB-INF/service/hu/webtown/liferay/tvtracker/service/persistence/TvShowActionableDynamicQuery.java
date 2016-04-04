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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil;

/**
 * @author czeni
 * @generated
 */
public abstract class TvShowActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public TvShowActionableDynamicQuery() throws SystemException {
		setBaseLocalService(TvShowLocalServiceUtil.getService());
		setClass(TvShow.class);

		setClassLoader(hu.webtown.liferay.tvtracker.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("tvShowId");
	}
}