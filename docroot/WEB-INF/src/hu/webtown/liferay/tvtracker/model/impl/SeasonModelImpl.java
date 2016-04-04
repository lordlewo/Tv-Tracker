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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.model.SeasonModel;
import hu.webtown.liferay.tvtracker.model.SeasonSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Season service. Represents a row in the &quot;TvT_Season&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link hu.webtown.liferay.tvtracker.model.SeasonModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SeasonImpl}.
 * </p>
 *
 * @author czeni
 * @see SeasonImpl
 * @see hu.webtown.liferay.tvtracker.model.Season
 * @see hu.webtown.liferay.tvtracker.model.SeasonModel
 * @generated
 */
@JSON(strict = true)
public class SeasonModelImpl extends BaseModelImpl<Season>
	implements SeasonModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a season model instance should use the {@link hu.webtown.liferay.tvtracker.model.Season} interface instead.
	 */
	public static final String TABLE_NAME = "TvT_Season";
	public static final Object[][] TABLE_COLUMNS = {
			{ "seasonId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "premierDate", Types.TIMESTAMP },
			{ "seasonNumber", Types.INTEGER },
			{ "description", Types.VARCHAR },
			{ "imageUrl", Types.VARCHAR },
			{ "imageUuid", Types.VARCHAR },
			{ "imageTitle", Types.VARCHAR },
			{ "imageVersion", Types.VARCHAR },
			{ "tvShowId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table TvT_Season (seasonId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,premierDate DATE null,seasonNumber INTEGER,description VARCHAR(500) null,imageUrl VARCHAR(500) null,imageUuid VARCHAR(75) null,imageTitle VARCHAR(75) null,imageVersion VARCHAR(75) null,tvShowId LONG)";
	public static final String TABLE_SQL_DROP = "drop table TvT_Season";
	public static final String ORDER_BY_JPQL = " ORDER BY season.seasonNumber ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TvT_Season.seasonNumber ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.hu.webtown.liferay.tvtracker.model.Season"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.hu.webtown.liferay.tvtracker.model.Season"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.hu.webtown.liferay.tvtracker.model.Season"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long TVSHOWID_COLUMN_BITMASK = 2L;
	public static long SEASONNUMBER_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Season toModel(SeasonSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Season model = new SeasonImpl();

		model.setSeasonId(soapModel.getSeasonId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTitle(soapModel.getTitle());
		model.setPremierDate(soapModel.getPremierDate());
		model.setSeasonNumber(soapModel.getSeasonNumber());
		model.setDescription(soapModel.getDescription());
		model.setImageUrl(soapModel.getImageUrl());
		model.setImageUuid(soapModel.getImageUuid());
		model.setImageTitle(soapModel.getImageTitle());
		model.setImageVersion(soapModel.getImageVersion());
		model.setTvShowId(soapModel.getTvShowId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Season> toModels(SeasonSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Season> models = new ArrayList<Season>(soapModels.length);

		for (SeasonSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.hu.webtown.liferay.tvtracker.model.Season"));

	public SeasonModelImpl() {
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

	@JSON
	@Override
	public long getSeasonId() {
		return _seasonId;
	}

	@Override
	public void setSeasonId(long seasonId) {
		_seasonId = seasonId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public Date getPremierDate() {
		return _premierDate;
	}

	@Override
	public void setPremierDate(Date premierDate) {
		_premierDate = premierDate;
	}

	@JSON
	@Override
	public int getSeasonNumber() {
		return _seasonNumber;
	}

	@Override
	public void setSeasonNumber(int seasonNumber) {
		_columnBitmask = -1L;

		_seasonNumber = seasonNumber;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public String getImageUrl() {
		if (_imageUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageUrl;
		}
	}

	@Override
	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	@JSON
	@Override
	public String getImageUuid() {
		if (_imageUuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageUuid;
		}
	}

	@Override
	public void setImageUuid(String imageUuid) {
		_imageUuid = imageUuid;
	}

	@JSON
	@Override
	public String getImageTitle() {
		if (_imageTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageTitle;
		}
	}

	@Override
	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
	}

	@JSON
	@Override
	public String getImageVersion() {
		if (_imageVersion == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageVersion;
		}
	}

	@Override
	public void setImageVersion(String imageVersion) {
		_imageVersion = imageVersion;
	}

	@JSON
	@Override
	public long getTvShowId() {
		return _tvShowId;
	}

	@Override
	public void setTvShowId(long tvShowId) {
		_columnBitmask |= TVSHOWID_COLUMN_BITMASK;

		if (!_setOriginalTvShowId) {
			_setOriginalTvShowId = true;

			_originalTvShowId = _tvShowId;
		}

		_tvShowId = tvShowId;
	}

	public long getOriginalTvShowId() {
		return _originalTvShowId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Season.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Season toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Season)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SeasonImpl seasonImpl = new SeasonImpl();

		seasonImpl.setSeasonId(getSeasonId());
		seasonImpl.setGroupId(getGroupId());
		seasonImpl.setCompanyId(getCompanyId());
		seasonImpl.setUserId(getUserId());
		seasonImpl.setUserName(getUserName());
		seasonImpl.setCreateDate(getCreateDate());
		seasonImpl.setModifiedDate(getModifiedDate());
		seasonImpl.setTitle(getTitle());
		seasonImpl.setPremierDate(getPremierDate());
		seasonImpl.setSeasonNumber(getSeasonNumber());
		seasonImpl.setDescription(getDescription());
		seasonImpl.setImageUrl(getImageUrl());
		seasonImpl.setImageUuid(getImageUuid());
		seasonImpl.setImageTitle(getImageTitle());
		seasonImpl.setImageVersion(getImageVersion());
		seasonImpl.setTvShowId(getTvShowId());

		seasonImpl.resetOriginalValues();

		return seasonImpl;
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

		if (!(obj instanceof Season)) {
			return false;
		}

		Season season = (Season)obj;

		long primaryKey = season.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SeasonModelImpl seasonModelImpl = this;

		seasonModelImpl._originalGroupId = seasonModelImpl._groupId;

		seasonModelImpl._setOriginalGroupId = false;

		seasonModelImpl._originalTvShowId = seasonModelImpl._tvShowId;

		seasonModelImpl._setOriginalTvShowId = false;

		seasonModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Season> toCacheModel() {
		SeasonCacheModel seasonCacheModel = new SeasonCacheModel();

		seasonCacheModel.seasonId = getSeasonId();

		seasonCacheModel.groupId = getGroupId();

		seasonCacheModel.companyId = getCompanyId();

		seasonCacheModel.userId = getUserId();

		seasonCacheModel.userName = getUserName();

		String userName = seasonCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			seasonCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			seasonCacheModel.createDate = createDate.getTime();
		}
		else {
			seasonCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			seasonCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			seasonCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		seasonCacheModel.title = getTitle();

		String title = seasonCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			seasonCacheModel.title = null;
		}

		Date premierDate = getPremierDate();

		if (premierDate != null) {
			seasonCacheModel.premierDate = premierDate.getTime();
		}
		else {
			seasonCacheModel.premierDate = Long.MIN_VALUE;
		}

		seasonCacheModel.seasonNumber = getSeasonNumber();

		seasonCacheModel.description = getDescription();

		String description = seasonCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			seasonCacheModel.description = null;
		}

		seasonCacheModel.imageUrl = getImageUrl();

		String imageUrl = seasonCacheModel.imageUrl;

		if ((imageUrl != null) && (imageUrl.length() == 0)) {
			seasonCacheModel.imageUrl = null;
		}

		seasonCacheModel.imageUuid = getImageUuid();

		String imageUuid = seasonCacheModel.imageUuid;

		if ((imageUuid != null) && (imageUuid.length() == 0)) {
			seasonCacheModel.imageUuid = null;
		}

		seasonCacheModel.imageTitle = getImageTitle();

		String imageTitle = seasonCacheModel.imageTitle;

		if ((imageTitle != null) && (imageTitle.length() == 0)) {
			seasonCacheModel.imageTitle = null;
		}

		seasonCacheModel.imageVersion = getImageVersion();

		String imageVersion = seasonCacheModel.imageVersion;

		if ((imageVersion != null) && (imageVersion.length() == 0)) {
			seasonCacheModel.imageVersion = null;
		}

		seasonCacheModel.tvShowId = getTvShowId();

		return seasonCacheModel;
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

	private static ClassLoader _classLoader = Season.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Season.class };
	private long _seasonId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
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
	private long _originalTvShowId;
	private boolean _setOriginalTvShowId;
	private long _columnBitmask;
	private Season _escapedModel;
}