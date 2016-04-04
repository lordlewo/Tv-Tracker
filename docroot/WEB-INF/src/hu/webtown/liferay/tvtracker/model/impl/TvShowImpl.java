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

package hu.webtown.liferay.tvtracker.model.impl;

/**
 * The extended model implementation for the TvShow service. Represents a row in the &quot;TvT_TvShow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.webtown.liferay.tvtracker.model.TvShow} interface.
 * </p>
 *
 * @author czeni
 */
public class TvShowImpl extends TvShowBaseImpl {

	private int _premierYear;
	private int _seasonCount;
	
	public TvShowImpl() {}

	public int getPremierYear() {
		return _premierYear;
	}

	public void setPremierYear(int premierYear) {
		this._premierYear = premierYear;
	}

	public int getSeasonCount() {
		return _seasonCount;
	}

	public void setSeasonCount(int seasonCount) {
		this._seasonCount = seasonCount;
	}

	

	

}