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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TvShow service. Represents a row in the &quot;TvT_TvShow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link hu.webtown.liferay.tvtracker.model.impl.TvShowImpl}.
 * </p>
 *
 * @author czeni
 * @see TvShow
 * @see hu.webtown.liferay.tvtracker.model.impl.TvShowImpl
 * @see hu.webtown.liferay.tvtracker.model.impl.TvShowModelImpl
 * @generated
 */
public interface TvShowModel extends BaseModel<TvShow>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tv show model instance should use the {@link TvShow} interface instead.
	 */

	/**
	 * Returns the primary key of this tv show.
	 *
	 * @return the primary key of this tv show
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tv show.
	 *
	 * @param primaryKey the primary key of this tv show
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the tv show ID of this tv show.
	 *
	 * @return the tv show ID of this tv show
	 */
	public long getTvShowId();

	/**
	 * Sets the tv show ID of this tv show.
	 *
	 * @param tvShowId the tv show ID of this tv show
	 */
	public void setTvShowId(long tvShowId);

	/**
	 * Returns the group ID of this tv show.
	 *
	 * @return the group ID of this tv show
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this tv show.
	 *
	 * @param groupId the group ID of this tv show
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this tv show.
	 *
	 * @return the company ID of this tv show
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this tv show.
	 *
	 * @param companyId the company ID of this tv show
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this tv show.
	 *
	 * @return the user ID of this tv show
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this tv show.
	 *
	 * @param userId the user ID of this tv show
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this tv show.
	 *
	 * @return the user uuid of this tv show
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this tv show.
	 *
	 * @param userUuid the user uuid of this tv show
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this tv show.
	 *
	 * @return the user name of this tv show
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this tv show.
	 *
	 * @param userName the user name of this tv show
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this tv show.
	 *
	 * @return the create date of this tv show
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this tv show.
	 *
	 * @param createDate the create date of this tv show
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this tv show.
	 *
	 * @return the modified date of this tv show
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this tv show.
	 *
	 * @param modifiedDate the modified date of this tv show
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this tv show.
	 *
	 * @return the title of this tv show
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this tv show.
	 *
	 * @param title the title of this tv show
	 */
	public void setTitle(String title);

	/**
	 * Returns the premier date of this tv show.
	 *
	 * @return the premier date of this tv show
	 */
	public Date getPremierDate();

	/**
	 * Sets the premier date of this tv show.
	 *
	 * @param premierDate the premier date of this tv show
	 */
	public void setPremierDate(Date premierDate);

	/**
	 * Returns the description of this tv show.
	 *
	 * @return the description of this tv show
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this tv show.
	 *
	 * @param description the description of this tv show
	 */
	public void setDescription(String description);

	/**
	 * Returns the image url of this tv show.
	 *
	 * @return the image url of this tv show
	 */
	@AutoEscape
	public String getImageUrl();

	/**
	 * Sets the image url of this tv show.
	 *
	 * @param imageUrl the image url of this tv show
	 */
	public void setImageUrl(String imageUrl);

	/**
	 * Returns the image uuid of this tv show.
	 *
	 * @return the image uuid of this tv show
	 */
	@AutoEscape
	public String getImageUuid();

	/**
	 * Sets the image uuid of this tv show.
	 *
	 * @param imageUuid the image uuid of this tv show
	 */
	public void setImageUuid(String imageUuid);

	/**
	 * Returns the image title of this tv show.
	 *
	 * @return the image title of this tv show
	 */
	@AutoEscape
	public String getImageTitle();

	/**
	 * Sets the image title of this tv show.
	 *
	 * @param imageTitle the image title of this tv show
	 */
	public void setImageTitle(String imageTitle);

	/**
	 * Returns the image version of this tv show.
	 *
	 * @return the image version of this tv show
	 */
	@AutoEscape
	public String getImageVersion();

	/**
	 * Sets the image version of this tv show.
	 *
	 * @param imageVersion the image version of this tv show
	 */
	public void setImageVersion(String imageVersion);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(hu.webtown.liferay.tvtracker.model.TvShow tvShow);

	@Override
	public int hashCode();

	@Override
	public CacheModel<hu.webtown.liferay.tvtracker.model.TvShow> toCacheModel();

	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow toEscapedModel();

	@Override
	public hu.webtown.liferay.tvtracker.model.TvShow toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}