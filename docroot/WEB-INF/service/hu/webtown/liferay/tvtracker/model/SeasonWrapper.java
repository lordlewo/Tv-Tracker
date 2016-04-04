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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Season}.
 * </p>
 *
 * @author czeni
 * @see Season
 * @generated
 */
public class SeasonWrapper implements Season, ModelWrapper<Season> {
	public SeasonWrapper(Season season) {
		_season = season;
	}

	@Override
	public Class<?> getModelClass() {
		return Season.class;
	}

	@Override
	public String getModelClassName() {
		return Season.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("seasonId", getSeasonId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("premierDate", getPremierDate());
		attributes.put("seasonNumber", getSeasonNumber());
		attributes.put("description", getDescription());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("imageUuid", getImageUuid());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageVersion", getImageVersion());
		attributes.put("tvShowId", getTvShowId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long seasonId = (Long)attributes.get("seasonId");

		if (seasonId != null) {
			setSeasonId(seasonId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Date premierDate = (Date)attributes.get("premierDate");

		if (premierDate != null) {
			setPremierDate(premierDate);
		}

		Integer seasonNumber = (Integer)attributes.get("seasonNumber");

		if (seasonNumber != null) {
			setSeasonNumber(seasonNumber);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		String imageUuid = (String)attributes.get("imageUuid");

		if (imageUuid != null) {
			setImageUuid(imageUuid);
		}

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		String imageVersion = (String)attributes.get("imageVersion");

		if (imageVersion != null) {
			setImageVersion(imageVersion);
		}

		Long tvShowId = (Long)attributes.get("tvShowId");

		if (tvShowId != null) {
			setTvShowId(tvShowId);
		}
	}

	/**
	* Returns the primary key of this season.
	*
	* @return the primary key of this season
	*/
	@Override
	public long getPrimaryKey() {
		return _season.getPrimaryKey();
	}

	/**
	* Sets the primary key of this season.
	*
	* @param primaryKey the primary key of this season
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_season.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the season ID of this season.
	*
	* @return the season ID of this season
	*/
	@Override
	public long getSeasonId() {
		return _season.getSeasonId();
	}

	/**
	* Sets the season ID of this season.
	*
	* @param seasonId the season ID of this season
	*/
	@Override
	public void setSeasonId(long seasonId) {
		_season.setSeasonId(seasonId);
	}

	/**
	* Returns the group ID of this season.
	*
	* @return the group ID of this season
	*/
	@Override
	public long getGroupId() {
		return _season.getGroupId();
	}

	/**
	* Sets the group ID of this season.
	*
	* @param groupId the group ID of this season
	*/
	@Override
	public void setGroupId(long groupId) {
		_season.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this season.
	*
	* @return the company ID of this season
	*/
	@Override
	public long getCompanyId() {
		return _season.getCompanyId();
	}

	/**
	* Sets the company ID of this season.
	*
	* @param companyId the company ID of this season
	*/
	@Override
	public void setCompanyId(long companyId) {
		_season.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this season.
	*
	* @return the user ID of this season
	*/
	@Override
	public long getUserId() {
		return _season.getUserId();
	}

	/**
	* Sets the user ID of this season.
	*
	* @param userId the user ID of this season
	*/
	@Override
	public void setUserId(long userId) {
		_season.setUserId(userId);
	}

	/**
	* Returns the user uuid of this season.
	*
	* @return the user uuid of this season
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _season.getUserUuid();
	}

	/**
	* Sets the user uuid of this season.
	*
	* @param userUuid the user uuid of this season
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_season.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this season.
	*
	* @return the user name of this season
	*/
	@Override
	public java.lang.String getUserName() {
		return _season.getUserName();
	}

	/**
	* Sets the user name of this season.
	*
	* @param userName the user name of this season
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_season.setUserName(userName);
	}

	/**
	* Returns the create date of this season.
	*
	* @return the create date of this season
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _season.getCreateDate();
	}

	/**
	* Sets the create date of this season.
	*
	* @param createDate the create date of this season
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_season.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this season.
	*
	* @return the modified date of this season
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _season.getModifiedDate();
	}

	/**
	* Sets the modified date of this season.
	*
	* @param modifiedDate the modified date of this season
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_season.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this season.
	*
	* @return the title of this season
	*/
	@Override
	public java.lang.String getTitle() {
		return _season.getTitle();
	}

	/**
	* Sets the title of this season.
	*
	* @param title the title of this season
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_season.setTitle(title);
	}

	/**
	* Returns the premier date of this season.
	*
	* @return the premier date of this season
	*/
	@Override
	public java.util.Date getPremierDate() {
		return _season.getPremierDate();
	}

	/**
	* Sets the premier date of this season.
	*
	* @param premierDate the premier date of this season
	*/
	@Override
	public void setPremierDate(java.util.Date premierDate) {
		_season.setPremierDate(premierDate);
	}

	/**
	* Returns the season number of this season.
	*
	* @return the season number of this season
	*/
	@Override
	public int getSeasonNumber() {
		return _season.getSeasonNumber();
	}

	/**
	* Sets the season number of this season.
	*
	* @param seasonNumber the season number of this season
	*/
	@Override
	public void setSeasonNumber(int seasonNumber) {
		_season.setSeasonNumber(seasonNumber);
	}

	/**
	* Returns the description of this season.
	*
	* @return the description of this season
	*/
	@Override
	public java.lang.String getDescription() {
		return _season.getDescription();
	}

	/**
	* Sets the description of this season.
	*
	* @param description the description of this season
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_season.setDescription(description);
	}

	/**
	* Returns the image url of this season.
	*
	* @return the image url of this season
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _season.getImageUrl();
	}

	/**
	* Sets the image url of this season.
	*
	* @param imageUrl the image url of this season
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_season.setImageUrl(imageUrl);
	}

	/**
	* Returns the image uuid of this season.
	*
	* @return the image uuid of this season
	*/
	@Override
	public java.lang.String getImageUuid() {
		return _season.getImageUuid();
	}

	/**
	* Sets the image uuid of this season.
	*
	* @param imageUuid the image uuid of this season
	*/
	@Override
	public void setImageUuid(java.lang.String imageUuid) {
		_season.setImageUuid(imageUuid);
	}

	/**
	* Returns the image title of this season.
	*
	* @return the image title of this season
	*/
	@Override
	public java.lang.String getImageTitle() {
		return _season.getImageTitle();
	}

	/**
	* Sets the image title of this season.
	*
	* @param imageTitle the image title of this season
	*/
	@Override
	public void setImageTitle(java.lang.String imageTitle) {
		_season.setImageTitle(imageTitle);
	}

	/**
	* Returns the image version of this season.
	*
	* @return the image version of this season
	*/
	@Override
	public java.lang.String getImageVersion() {
		return _season.getImageVersion();
	}

	/**
	* Sets the image version of this season.
	*
	* @param imageVersion the image version of this season
	*/
	@Override
	public void setImageVersion(java.lang.String imageVersion) {
		_season.setImageVersion(imageVersion);
	}

	/**
	* Returns the tv show ID of this season.
	*
	* @return the tv show ID of this season
	*/
	@Override
	public long getTvShowId() {
		return _season.getTvShowId();
	}

	/**
	* Sets the tv show ID of this season.
	*
	* @param tvShowId the tv show ID of this season
	*/
	@Override
	public void setTvShowId(long tvShowId) {
		_season.setTvShowId(tvShowId);
	}

	@Override
	public boolean isNew() {
		return _season.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_season.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _season.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_season.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _season.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _season.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_season.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _season.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_season.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_season.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_season.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SeasonWrapper((Season)_season.clone());
	}

	@Override
	public int compareTo(hu.webtown.liferay.tvtracker.model.Season season) {
		return _season.compareTo(season);
	}

	@Override
	public int hashCode() {
		return _season.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.webtown.liferay.tvtracker.model.Season> toCacheModel() {
		return _season.toCacheModel();
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Season toEscapedModel() {
		return new SeasonWrapper(_season.toEscapedModel());
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Season toUnescapedModel() {
		return new SeasonWrapper(_season.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _season.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _season.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_season.persist();
	}

	@Override
	public int getEpisodeCount() {
		return _season.getEpisodeCount();
	}

	@Override
	public void setEpisodeCount(int episodeCount) {
		_season.setEpisodeCount(episodeCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SeasonWrapper)) {
			return false;
		}

		SeasonWrapper seasonWrapper = (SeasonWrapper)obj;

		if (Validator.equals(_season, seasonWrapper._season)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Season getWrappedSeason() {
		return _season;
	}

	@Override
	public Season getWrappedModel() {
		return _season;
	}

	@Override
	public void resetOriginalValues() {
		_season.resetOriginalValues();
	}

	private Season _season;
}