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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import hu.webtown.liferay.tvtracker.service.ClpSerializer;
import hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czeni
 */
public class SeasonClp extends BaseModelImpl<Season> implements Season {
	public SeasonClp() {
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
	public long getPrimaryKey() {
		return _seasonId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSeasonId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _seasonId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSeasonId() {
		return _seasonId;
	}

	@Override
	public void setSeasonId(long seasonId) {
		_seasonId = seasonId;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonId", long.class);

				method.invoke(_seasonRemoteModel, seasonId);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_seasonRemoteModel, groupId);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_seasonRemoteModel, companyId);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_seasonRemoteModel, userId);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_seasonRemoteModel, userName);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_seasonRemoteModel, createDate);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_seasonRemoteModel, modifiedDate);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_seasonRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPremierDate() {
		return _premierDate;
	}

	@Override
	public void setPremierDate(Date premierDate) {
		_premierDate = premierDate;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setPremierDate", Date.class);

				method.invoke(_seasonRemoteModel, premierDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSeasonNumber() {
		return _seasonNumber;
	}

	@Override
	public void setSeasonNumber(int seasonNumber) {
		_seasonNumber = seasonNumber;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setSeasonNumber", int.class);

				method.invoke(_seasonRemoteModel, seasonNumber);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_seasonRemoteModel, description);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUrl", String.class);

				method.invoke(_seasonRemoteModel, imageUrl);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUuid", String.class);

				method.invoke(_seasonRemoteModel, imageUuid);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setImageTitle", String.class);

				method.invoke(_seasonRemoteModel, imageTitle);
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

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setImageVersion", String.class);

				method.invoke(_seasonRemoteModel, imageVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTvShowId() {
		return _tvShowId;
	}

	@Override
	public void setTvShowId(long tvShowId) {
		_tvShowId = tvShowId;

		if (_seasonRemoteModel != null) {
			try {
				Class<?> clazz = _seasonRemoteModel.getClass();

				Method method = clazz.getMethod("setTvShowId", long.class);

				method.invoke(_seasonRemoteModel, tvShowId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setEpisodeCount(int episodeCount) {
		try {
			String methodName = "setEpisodeCount";

			Class<?>[] parameterTypes = new Class<?>[] { int.class };

			Object[] parameterValues = new Object[] { episodeCount };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public int getEpisodeCount() {
		try {
			String methodName = "getEpisodeCount";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSeasonRemoteModel() {
		return _seasonRemoteModel;
	}

	public void setSeasonRemoteModel(BaseModel<?> seasonRemoteModel) {
		_seasonRemoteModel = seasonRemoteModel;
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

		Class<?> remoteModelClass = _seasonRemoteModel.getClass();

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

		Object returnValue = method.invoke(_seasonRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SeasonLocalServiceUtil.addSeason(this);
		}
		else {
			SeasonLocalServiceUtil.updateSeason(this);
		}
	}

	@Override
	public Season toEscapedModel() {
		return (Season)ProxyUtil.newProxyInstance(Season.class.getClassLoader(),
			new Class[] { Season.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SeasonClp clone = new SeasonClp();

		clone.setSeasonId(getSeasonId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setPremierDate(getPremierDate());
		clone.setSeasonNumber(getSeasonNumber());
		clone.setDescription(getDescription());
		clone.setImageUrl(getImageUrl());
		clone.setImageUuid(getImageUuid());
		clone.setImageTitle(getImageTitle());
		clone.setImageVersion(getImageVersion());
		clone.setTvShowId(getTvShowId());

		return clone;
	}

	@Override
	public int compareTo(Season season) {
		int value = 0;

		if (getSeasonNumber() < season.getSeasonNumber()) {
			value = -1;
		}
		else if (getSeasonNumber() > season.getSeasonNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof SeasonClp)) {
			return false;
		}

		SeasonClp season = (SeasonClp)obj;

		long primaryKey = season.getPrimaryKey();

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

		sb.append("{seasonId=");
		sb.append(getSeasonId());
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
		sb.append(", premierDate=");
		sb.append(getPremierDate());
		sb.append(", seasonNumber=");
		sb.append(getSeasonNumber());
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
		sb.append(", tvShowId=");
		sb.append(getTvShowId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("hu.webtown.liferay.tvtracker.model.Season");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>seasonId</column-name><column-value><![CDATA[");
		sb.append(getSeasonId());
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
			"<column><column-name>premierDate</column-name><column-value><![CDATA[");
		sb.append(getPremierDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seasonNumber</column-name><column-value><![CDATA[");
		sb.append(getSeasonNumber());
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
			"<column><column-name>tvShowId</column-name><column-value><![CDATA[");
		sb.append(getTvShowId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _seasonId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private Date _premierDate;
	private int _seasonNumber;
	private String _description;
	private String _imageUrl;
	private String _imageUuid;
	private String _imageTitle;
	private String _imageVersion;
	private long _tvShowId;
	private BaseModel<?> _seasonRemoteModel;
	private Class<?> _clpSerializerClass = hu.webtown.liferay.tvtracker.service.ClpSerializer.class;
}