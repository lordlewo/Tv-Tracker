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

package hu.webtown.liferay.tvtracker.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the TvShow service. Represents a row in the &quot;TvT_TvShow&quot; database table, with each column mapped to a property of this class.
 *
 * @author czeni
 * @see TvShowModel
 * @see hu.webtown.liferay.tvtracker.model.impl.TvShowImpl
 * @see hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl
 * @generated
 */
public interface TvShow extends TvShowModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link hu.webtown.liferay.tvtracker.model.impl.TvShowImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public int getPremierYear();

	public void setPremierYear(int premierYear);

	public int getSeasonCount();

	public void setSeasonCount(int seasonCount);
}