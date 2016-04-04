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
 * This class is a wrapper for {@link Episode}.
 * </p>
 *
 * @author czeni
 * @see Episode
 * @generated
 */
public class EpisodeWrapper implements Episode, ModelWrapper<Episode> {
	public EpisodeWrapper(Episode episode) {
		_episode = episode;
	}

	@Override
	public Class<?> getModelClass() {
		return Episode.class;
	}

	@Override
	public String getModelClassName() {
		return Episode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("episodeId", getEpisodeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("airDate", getAirDate());
		attributes.put("description", getDescription());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("imageUuid", getImageUuid());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageVersion", getImageVersion());
		attributes.put("seasonId", getSeasonId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long episodeId = (Long)attributes.get("episodeId");

		if (episodeId != null) {
			setEpisodeId(episodeId);
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

		Date airDate = (Date)attributes.get("airDate");

		if (airDate != null) {
			setAirDate(airDate);
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

		Long seasonId = (Long)attributes.get("seasonId");

		if (seasonId != null) {
			setSeasonId(seasonId);
		}
	}

	/**
	* Returns the primary key of this episode.
	*
	* @return the primary key of this episode
	*/
	@Override
	public long getPrimaryKey() {
		return _episode.getPrimaryKey();
	}

	/**
	* Sets the primary key of this episode.
	*
	* @param primaryKey the primary key of this episode
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_episode.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the episode ID of this episode.
	*
	* @return the episode ID of this episode
	*/
	@Override
	public long getEpisodeId() {
		return _episode.getEpisodeId();
	}

	/**
	* Sets the episode ID of this episode.
	*
	* @param episodeId the episode ID of this episode
	*/
	@Override
	public void setEpisodeId(long episodeId) {
		_episode.setEpisodeId(episodeId);
	}

	/**
	* Returns the group ID of this episode.
	*
	* @return the group ID of this episode
	*/
	@Override
	public long getGroupId() {
		return _episode.getGroupId();
	}

	/**
	* Sets the group ID of this episode.
	*
	* @param groupId the group ID of this episode
	*/
	@Override
	public void setGroupId(long groupId) {
		_episode.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this episode.
	*
	* @return the company ID of this episode
	*/
	@Override
	public long getCompanyId() {
		return _episode.getCompanyId();
	}

	/**
	* Sets the company ID of this episode.
	*
	* @param companyId the company ID of this episode
	*/
	@Override
	public void setCompanyId(long companyId) {
		_episode.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this episode.
	*
	* @return the user ID of this episode
	*/
	@Override
	public long getUserId() {
		return _episode.getUserId();
	}

	/**
	* Sets the user ID of this episode.
	*
	* @param userId the user ID of this episode
	*/
	@Override
	public void setUserId(long userId) {
		_episode.setUserId(userId);
	}

	/**
	* Returns the user uuid of this episode.
	*
	* @return the user uuid of this episode
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _episode.getUserUuid();
	}

	/**
	* Sets the user uuid of this episode.
	*
	* @param userUuid the user uuid of this episode
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_episode.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this episode.
	*
	* @return the user name of this episode
	*/
	@Override
	public java.lang.String getUserName() {
		return _episode.getUserName();
	}

	/**
	* Sets the user name of this episode.
	*
	* @param userName the user name of this episode
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_episode.setUserName(userName);
	}

	/**
	* Returns the create date of this episode.
	*
	* @return the create date of this episode
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _episode.getCreateDate();
	}

	/**
	* Sets the create date of this episode.
	*
	* @param createDate the create date of this episode
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_episode.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this episode.
	*
	* @return the modified date of this episode
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _episode.getModifiedDate();
	}

	/**
	* Sets the modified date of this episode.
	*
	* @param modifiedDate the modified date of this episode
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_episode.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this episode.
	*
	* @return the title of this episode
	*/
	@Override
	public java.lang.String getTitle() {
		return _episode.getTitle();
	}

	/**
	* Sets the title of this episode.
	*
	* @param title the title of this episode
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_episode.setTitle(title);
	}

	/**
	* Returns the air date of this episode.
	*
	* @return the air date of this episode
	*/
	@Override
	public java.util.Date getAirDate() {
		return _episode.getAirDate();
	}

	/**
	* Sets the air date of this episode.
	*
	* @param airDate the air date of this episode
	*/
	@Override
	public void setAirDate(java.util.Date airDate) {
		_episode.setAirDate(airDate);
	}

	/**
	* Returns the description of this episode.
	*
	* @return the description of this episode
	*/
	@Override
	public java.lang.String getDescription() {
		return _episode.getDescription();
	}

	/**
	* Sets the description of this episode.
	*
	* @param description the description of this episode
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_episode.setDescription(description);
	}

	/**
	* Returns the image url of this episode.
	*
	* @return the image url of this episode
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _episode.getImageUrl();
	}

	/**
	* Sets the image url of this episode.
	*
	* @param imageUrl the image url of this episode
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_episode.setImageUrl(imageUrl);
	}

	/**
	* Returns the image uuid of this episode.
	*
	* @return the image uuid of this episode
	*/
	@Override
	public java.lang.String getImageUuid() {
		return _episode.getImageUuid();
	}

	/**
	* Sets the image uuid of this episode.
	*
	* @param imageUuid the image uuid of this episode
	*/
	@Override
	public void setImageUuid(java.lang.String imageUuid) {
		_episode.setImageUuid(imageUuid);
	}

	/**
	* Returns the image title of this episode.
	*
	* @return the image title of this episode
	*/
	@Override
	public java.lang.String getImageTitle() {
		return _episode.getImageTitle();
	}

	/**
	* Sets the image title of this episode.
	*
	* @param imageTitle the image title of this episode
	*/
	@Override
	public void setImageTitle(java.lang.String imageTitle) {
		_episode.setImageTitle(imageTitle);
	}

	/**
	* Returns the image version of this episode.
	*
	* @return the image version of this episode
	*/
	@Override
	public java.lang.String getImageVersion() {
		return _episode.getImageVersion();
	}

	/**
	* Sets the image version of this episode.
	*
	* @param imageVersion the image version of this episode
	*/
	@Override
	public void setImageVersion(java.lang.String imageVersion) {
		_episode.setImageVersion(imageVersion);
	}

	/**
	* Returns the season ID of this episode.
	*
	* @return the season ID of this episode
	*/
	@Override
	public long getSeasonId() {
		return _episode.getSeasonId();
	}

	/**
	* Sets the season ID of this episode.
	*
	* @param seasonId the season ID of this episode
	*/
	@Override
	public void setSeasonId(long seasonId) {
		_episode.setSeasonId(seasonId);
	}

	@Override
	public boolean isNew() {
		return _episode.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_episode.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _episode.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_episode.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _episode.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _episode.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_episode.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _episode.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_episode.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_episode.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_episode.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EpisodeWrapper((Episode)_episode.clone());
	}

	@Override
	public int compareTo(hu.webtown.liferay.tvtracker.model.Episode episode) {
		return _episode.compareTo(episode);
	}

	@Override
	public int hashCode() {
		return _episode.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.webtown.liferay.tvtracker.model.Episode> toCacheModel() {
		return _episode.toCacheModel();
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Episode toEscapedModel() {
		return new EpisodeWrapper(_episode.toEscapedModel());
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.Episode toUnescapedModel() {
		return new EpisodeWrapper(_episode.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _episode.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _episode.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_episode.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EpisodeWrapper)) {
			return false;
		}

		EpisodeWrapper episodeWrapper = (EpisodeWrapper)obj;

		if (Validator.equals(_episode, episodeWrapper._episode)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Episode getWrappedEpisode() {
		return _episode;
	}

	@Override
	public Episode getWrappedModel() {
		return _episode;
	}

	@Override
	public void resetOriginalValues() {
		_episode.resetOriginalValues();
	}

	private Episode _episode;
}