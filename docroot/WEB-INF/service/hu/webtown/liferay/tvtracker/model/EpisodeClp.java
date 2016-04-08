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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import hu.webtown.liferay.tvtracker.service.ClpSerializer;
import hu.webtown.liferay.tvtracker.service.EpisodeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czeni
 */
public class EpisodeClp extends BaseModelImpl<Episode> implements Episode {
	public EpisodeClp() {
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
	public long getPrimaryKey() {
		return _episodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEpisodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _episodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("episodeNumber", getEpisodeNumber());
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

		Integer episodeNumber = (Integer)attributes.get("episodeNumber");

		if (episodeNumber != null) {
			setEpisodeNumber(episodeNumber);
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

	@Override
	public long getEpisodeId() {
		return _episodeId;
	}

	@Override
	public void setEpisodeId(long episodeId) {
		_episodeId = episodeId;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeId", long.class);

				method.invoke(_episodeRemoteModel, episodeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_episodeRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_episodeRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_episodeRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_episodeRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_episodeRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_episodeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_episodeRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAirDate() {
		return _airDate;
	}

	@Override
	public void setAirDate(Date airDate) {
		_airDate = airDate;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setAirDate", Date.class);

				method.invoke(_episodeRemoteModel, airDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEpisodeNumber() {
		return _episodeNumber;
	}

	@Override
	public void setEpisodeNumber(int episodeNumber) {
		_episodeNumber = episodeNumber;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEpisodeNumber", int.class);

				method.invoke(_episodeRemoteModel, episodeNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_episodeRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageUrl() {
		return _imageUrl;
	}

	@Override
	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUrl", String.class);

				method.invoke(_episodeRemoteModel, imageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageUuid() {
		return _imageUuid;
	}

	@Override
	public void setImageUuid(String imageUuid) {
		_imageUuid = imageUuid;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUuid", String.class);

				method.invoke(_episodeRemoteModel, imageUuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageTitle() {
		return _imageTitle;
	}

	@Override
	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setImageTitle", String.class);

				method.invoke(_episodeRemoteModel, imageTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageVersion() {
		return _imageVersion;
	}

	@Override
	public void setImageVersion(String imageVersion) {
		_imageVersion = imageVersion;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setImageVersion", String.class);

				method.invoke(_episodeRemoteModel, imageVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSeasonId() {
		return _seasonId;
	}

	@Override
	public void setSeasonId(long seasonId) {
		_seasonId = seasonId;

		if (_episodeRemoteModel != null) {
			try {
				Class<?> clazz = _episodeRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonId", long.class);

				method.invoke(_episodeRemoteModel, seasonId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEpisodeRemoteModel() {
		return _episodeRemoteModel;
	}

	public void setEpisodeRemoteModel(BaseModel<?> episodeRemoteModel) {
		_episodeRemoteModel = episodeRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _episodeRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_episodeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EpisodeLocalServiceUtil.addEpisode(this);
		}
		else {
			EpisodeLocalServiceUtil.updateEpisode(this);
		}
	}

	@Override
	public Episode toEscapedModel() {
		return (Episode)ProxyUtil.newProxyInstance(Episode.class.getClassLoader(),
			new Class[] { Episode.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EpisodeClp clone = new EpisodeClp();

		clone.setEpisodeId(getEpisodeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setAirDate(getAirDate());
		clone.setEpisodeNumber(getEpisodeNumber());
		clone.setDescription(getDescription());
		clone.setImageUrl(getImageUrl());
		clone.setImageUuid(getImageUuid());
		clone.setImageTitle(getImageTitle());
		clone.setImageVersion(getImageVersion());
		clone.setSeasonId(getSeasonId());

		return clone;
	}

	@Override
	public int compareTo(Episode episode) {
		int value = 0;

		value = DateUtil.compareTo(getAirDate(), episode.getAirDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EpisodeClp)) {
			return false;
		}

		EpisodeClp episode = (EpisodeClp)obj;

		long primaryKey = episode.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{episodeId=");
		sb.append(getEpisodeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", airDate=");
		sb.append(getAirDate());
		sb.append(", episodeNumber=");
		sb.append(getEpisodeNumber());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", imageUrl=");
		sb.append(getImageUrl());
		sb.append(", imageUuid=");
		sb.append(getImageUuid());
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", imageVersion=");
		sb.append(getImageVersion());
		sb.append(", seasonId=");
		sb.append(getSeasonId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("hu.webtown.liferay.tvtracker.model.Episode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>episodeId</column-name><column-value><![CDATA[");
		sb.append(getEpisodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>airDate</column-name><column-value><![CDATA[");
		sb.append(getAirDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>episodeNumber</column-name><column-value><![CDATA[");
		sb.append(getEpisodeNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUuid</column-name><column-value><![CDATA[");
		sb.append(getImageUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageTitle</column-name><column-value><![CDATA[");
		sb.append(getImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageVersion</column-name><column-value><![CDATA[");
		sb.append(getImageVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonId</column-name><column-value><![CDATA[");
		sb.append(getSeasonId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _episodeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private Date _airDate;
	private int _episodeNumber;
	private String _description;
	private String _imageUrl;
	private String _imageUuid;
	private String _imageTitle;
	private String _imageVersion;
	private long _seasonId;
	private BaseModel<?> _episodeRemoteModel;
	private Class<?> _clpSerializerClass = hu.webtown.liferay.tvtracker.service.ClpSerializer.class;
}