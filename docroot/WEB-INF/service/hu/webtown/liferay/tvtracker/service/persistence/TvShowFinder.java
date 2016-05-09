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

/**
 * @author czeni
 */
public interface TvShowFinder {
	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByPremierYear(
		int premierYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByPremierYear(
		int premierYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByG_P(
		long groupId, int premierYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<hu.webtown.liferay.tvtracker.model.TvShow> findByG_P(
		long groupId, int premierYear)
		throws com.liferay.portal.kernel.exception.SystemException;
}