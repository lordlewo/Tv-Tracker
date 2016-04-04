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
 * This class is a wrapper for {@link TvShow}.
 * </p>
 *
 * @author czeni
 * @see TvShow
 * @generated
 */
public class TvShowWrapper implements TvShow, ModelWrapper<TvShow> {
	public TvShowWrapper(TvShow tvShow) {
		_tvShow = tvShow;
	}

	@Override
	public Class<?> getModelClass() {
		return TvShow.class;
	}

	@Override
	public String getModelClassName() {
		return TvShow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tvShowId", getTvShowId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("premierDate", getPremierDate());
		attributes.put("description", getDescription());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("imageUuid", getImageUuid());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageVersion", getImageVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tvShowId = (Long)attributes.get("tvShowId");

		if (tvShowId != null) {
			setTvShowId(tvShowId);
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
	}

	/**
	* Returns the primary key of this tv show.
	*
	* @return the primary key of this tv show
	*/
	@Override
	public long getPrimaryKey() {
		return _tvShow.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tv show.
	*
	* @param primaryKey the primary key of this tv show
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tvShow.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tv show ID of this tv show.
	*
	* @return the tv show ID of this tv show
	*/
	@Override
	public long getTvShowId() {
		return _tvShow.getTvShowId();
	}

	/**
	* Sets the tv show ID of this tv show.
	*
	* @param tvShowId the tv show ID of this tv show
	*/
	@Override
	public void setTvShowId(long tvShowId) {
		_tvShow.setTvShowId(tvShowId);
	}

	/**
	* Returns the group ID of this tv show.
	*
	* @return the group ID of this tv show
	*/
	@Override
	public long getGroupId() {
		return _tvShow.getGroupId();
	}

	/**
	* Sets the group ID of this tv show.
	*
	* @param groupId the group ID of this tv show
	*/
	@Override
	public void setGroupId(long groupId) {
		_tvShow.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this tv show.
	*
	* @return the company ID of this tv show
	*/
	@Override
	public long getCompanyId() {
		return _tvShow.getCompanyId();
	}

	/**
	* Sets the company ID of this tv show.
	*
	* @param companyId the company ID of this tv show
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tvShow.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this tv show.
	*
	* @return the user ID of this tv show
	*/
	@Override
	public long getUserId() {
		return _tvShow.getUserId();
	}

	/**
	* Sets the user ID of this tv show.
	*
	* @param userId the user ID of this tv show
	*/
	@Override
	public void setUserId(long userId) {
		_tvShow.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tv show.
	*
	* @return the user uuid of this tv show
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tvShow.getUserUuid();
	}

	/**
	* Sets the user uuid of this tv show.
	*
	* @param userUuid the user uuid of this tv show
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tvShow.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this tv show.
	*
	* @return the user name of this tv show
	*/
	@Override
	public java.lang.String getUserName() {
		return _tvShow.getUserName();
	}

	/**
	* Sets the user name of this tv show.
	*
	* @param userName the user name of this tv show
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tvShow.setUserName(userName);
	}

	/**
	* Returns the create date of this tv show.
	*
	* @return the create date of this tv show
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tvShow.getCreateDate();
	}

	/**
	* Sets the create date of this tv show.
	*
	* @param createDate the create date of this tv show
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tvShow.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this tv show.
	*
	* @return the modified date of this tv show
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tvShow.getModifiedDate();
	}

	/**
	* Sets the modified date of this tv show.
	*
	* @param modifiedDate the modified date of this tv show
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tvShow.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this tv show.
	*
	* @return the title of this tv show
	*/
	@Override
	public java.lang.String getTitle() {
		return _tvShow.getTitle();
	}

	/**
	* Sets the title of this tv show.
	*
	* @param title the title of this tv show
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_tvShow.setTitle(title);
	}

	/**
	* Returns the premier date of this tv show.
	*
	* @return the premier date of this tv show
	*/
	@Override
	public java.util.Date getPremierDate() {
		return _tvShow.getPremierDate();
	}

	/**
	* Sets the premier date of this tv show.
	*
	* @param premierDate the premier date of this tv show
	*/
	@Override
	public void setPremierDate(java.util.Date premierDate) {
		_tvShow.setPremierDate(premierDate);
	}

	/**
	* Returns the description of this tv show.
	*
	* @return the description of this tv show
	*/
	@Override
	public java.lang.String getDescription() {
		return _tvShow.getDescription();
	}

	/**
	* Sets the description of this tv show.
	*
	* @param description the description of this tv show
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_tvShow.setDescription(description);
	}

	/**
	* Returns the image url of this tv show.
	*
	* @return the image url of this tv show
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _tvShow.getImageUrl();
	}

	/**
	* Sets the image url of this tv show.
	*
	* @param imageUrl the image url of this tv show
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_tvShow.setImageUrl(imageUrl);
	}

	/**
	* Returns the image uuid of this tv show.
	*
	* @return the image uuid of this tv show
	*/
	@Override
	public java.lang.String getImageUuid() {
		return _tvShow.getImageUuid();
	}

	/**
	* Sets the image uuid of this tv show.
	*
	* @param imageUuid the image uuid of this tv show
	*/
	@Override
	public void setImageUuid(java.lang.String imageUuid) {
		_tvShow.setImageUuid(imageUuid);
	}

	/**
	* Returns the image title of this tv show.
	*
	* @return the image title of this tv show
	*/
	@Override
	public java.lang.String getImageTitle() {
		return _tvShow.getImageTitle();
	}

	/**
	* Sets the image title of this tv show.
	*
	* @param imageTitle the image title of this tv show
	*/
	@Override
	public void setImageTitle(java.lang.String imageTitle) {
		_tvShow.setImageTitle(imageTitle);
	}

	/**
	* Returns the image version of this tv show.
	*
	* @return the image version of this tv show
	*/
	@Override
	public java.lang.String getImageVersion() {
		return _tvShow.getImageVersion();
	}

	/**
	* Sets the image version of this tv show.
	*
	* @param imageVersion the image version of this tv show
	*/
	@Override
	public void setImageVersion(java.lang.String imageVersion) {
		_tvShow.setImageVersion(imageVersion);
	}

	@Override
	public boolean isNew() {
		return _tvShow.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tvShow.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tvShow.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tvShow.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tvShow.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tvShow.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tvShow.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tvShow.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tvShow.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tvShow.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tvShow.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TvShowWrapper((TvShow)_tvShow.clone());
	}

	@Override
	public int compareTo(hu.webtown.liferay.tvtracker.model.TvShow tvShow) {
		return _tvShow.compareTo(tvShow);
	}

	@Override
	public int hashCode() {
		return _tvShow.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.webtown.liferay.tvtracker.model.TvShow> toCacheModel() {
		return _tvShow.toCacheModel();
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow toEscapedModel() {
		return new TvShowWrapper(_tvShow.toEscapedModel());
	}

	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow toUnescapedModel() {
		return new TvShowWrapper(_tvShow.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tvShow.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tvShow.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tvShow.persist();
	}

	@Override
	public int getPremierYear() {
		return _tvShow.getPremierYear();
	}

	@Override
	public void setPremierYear(int premierYear) {
		_tvShow.setPremierYear(premierYear);
	}

	@Override
	public int getSeasonCount() {
		return _tvShow.getSeasonCount();
	}

	@Override
	public void setSeasonCount(int seasonCount) {
		_tvShow.setSeasonCount(seasonCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TvShowWrapper)) {
			return false;
		}

		TvShowWrapper tvShowWrapper = (TvShowWrapper)obj;

		if (Validator.equals(_tvShow, tvShowWrapper._tvShow)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TvShow getWrappedTvShow() {
		return _tvShow;
	}

	@Override
	public TvShow getWrappedModel() {
		return _tvShow;
	}

	@Override
	public void resetOriginalValues() {
		_tvShow.resetOriginalValues();
	}

	private TvShow _tvShow;
}