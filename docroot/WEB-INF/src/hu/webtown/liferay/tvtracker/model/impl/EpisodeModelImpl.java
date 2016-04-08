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
import com.liferay.portal.kernel.util.DateUtil;
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

import hu.webtown.liferay.tvtracker.model.Episode;
import hu.webtown.liferay.tvtracker.model.EpisodeModel;
import hu.webtown.liferay.tvtracker.model.EpisodeSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Episode service. Represents a row in the &quot;TvT_Episode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link hu.webtown.liferay.tvtracker.model.EpisodeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EpisodeImpl}.
 * </p>
 *
 * @author czeni
 * @see EpisodeImpl
 * @see hu.webtown.liferay.tvtracker.model.Episode
 * @see hu.webtown.liferay.tvtracker.model.EpisodeModel
 * @generated
 */
@JSON(strict = true)
public class EpisodeModelImpl extends BaseModelImpl<Episode>
	implements EpisodeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a episode model instance should use the {@link hu.webtown.liferay.tvtracker.model.Episode} interface instead.
	 */
	public static final String TABLE_NAME = "TvT_Episode";
	public static final Object[][] TABLE_COLUMNS = {
			{ "episodeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "airDate", Types.TIMESTAMP },
			{ "episodeNumber", Types.INTEGER },
			{ "description", Types.VARCHAR },
			{ "imageUrl", Types.VARCHAR },
			{ "imageUuid", Types.VARCHAR },
			{ "imageTitle", Types.VARCHAR },
			{ "imageVersion", Types.VARCHAR },
			{ "seasonId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table TvT_Episode (episodeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,airDate DATE null,episodeNumber INTEGER,description VARCHAR(1000) null,imageUrl VARCHAR(1000) null,imageUuid VARCHAR(75) null,imageTitle VARCHAR(75) null,imageVersion VARCHAR(75) null,seasonId LONG)";
	public static final String TABLE_SQL_DROP = "drop table TvT_Episode";
	public static final String ORDER_BY_JPQL = " ORDER BY episode.airDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TvT_Episode.airDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.hu.webtown.liferay.tvtracker.model.Episode"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.hu.webtown.liferay.tvtracker.model.Episode"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.hu.webtown.liferay.tvtracker.model.Episode"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long SEASONID_COLUMN_BITMASK = 2L;
	public static long AIRDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Episode toModel(EpisodeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Episode model = new EpisodeImpl();

		model.setEpisodeId(soapModel.getEpisodeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTitle(soapModel.getTitle());
		model.setAirDate(soapModel.getAirDate());
		model.setEpisodeNumber(soapModel.getEpisodeNumber());
		model.setDescription(soapModel.getDescription());
		model.setImageUrl(soapModel.getImageUrl());
		model.setImageUuid(soapModel.getImageUuid());
		model.setImageTitle(soapModel.getImageTitle());
		model.setImageVersion(soapModel.getImageVersion());
		model.setSeasonId(soapModel.getSeasonId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Episode> toModels(EpisodeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Episode> models = new ArrayList<Episode>(soapModels.length);

		for (EpisodeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.hu.webtown.liferay.tvtracker.model.Episode"));

	public EpisodeModelImpl() {
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

	@JSON
	@Override
	public long getEpisodeId() {
		return _episodeId;
	}

	@Override
	public void setEpisodeId(long episodeId) {
		_episodeId = episodeId;
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
	public Date getAirDate() {
		return _airDate;
	}

	@Override
	public void setAirDate(Date airDate) {
		_columnBitmask = -1L;

		_airDate = airDate;
	}

	@JSON
	@Override
	public int getEpisodeNumber() {
		return _episodeNumber;
	}

	@Override
	public void setEpisodeNumber(int episodeNumber) {
		_episodeNumber = episodeNumber;
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
	public long getSeasonId() {
		return _seasonId;
	}

	@Override
	public void setSeasonId(long seasonId) {
		_columnBitmask |= SEASONID_COLUMN_BITMASK;

		if (!_setOriginalSeasonId) {
			_setOriginalSeasonId = true;

			_originalSeasonId = _seasonId;
		}

		_seasonId = seasonId;
	}

	public long getOriginalSeasonId() {
		return _originalSeasonId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Episode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Episode toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Episode)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EpisodeImpl episodeImpl = new EpisodeImpl();

		episodeImpl.setEpisodeId(getEpisodeId());
		episodeImpl.setGroupId(getGroupId());
		episodeImpl.setCompanyId(getCompanyId());
		episodeImpl.setUserId(getUserId());
		episodeImpl.setUserName(getUserName());
		episodeImpl.setCreateDate(getCreateDate());
		episodeImpl.setModifiedDate(getModifiedDate());
		episodeImpl.setTitle(getTitle());
		episodeImpl.setAirDate(getAirDate());
		episodeImpl.setEpisodeNumber(getEpisodeNumber());
		episodeImpl.setDescription(getDescription());
		episodeImpl.setImageUrl(getImageUrl());
		episodeImpl.setImageUuid(getImageUuid());
		episodeImpl.setImageTitle(getImageTitle());
		episodeImpl.setImageVersion(getImageVersion());
		episodeImpl.setSeasonId(getSeasonId());

		episodeImpl.resetOriginalValues();

		return episodeImpl;
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

		if (!(obj instanceof Episode)) {
			return false;
		}

		Episode episode = (Episode)obj;

		long primaryKey = episode.getPrimaryKey();

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
		EpisodeModelImpl episodeModelImpl = this;

		episodeModelImpl._originalGroupId = episodeModelImpl._groupId;

		episodeModelImpl._setOriginalGroupId = false;

		episodeModelImpl._originalSeasonId = episodeModelImpl._seasonId;

		episodeModelImpl._setOriginalSeasonId = false;

		episodeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Episode> toCacheModel() {
		EpisodeCacheModel episodeCacheModel = new EpisodeCacheModel();

		episodeCacheModel.episodeId = getEpisodeId();

		episodeCacheModel.groupId = getGroupId();

		episodeCacheModel.companyId = getCompanyId();

		episodeCacheModel.userId = getUserId();

		episodeCacheModel.userName = getUserName();

		String userName = episodeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			episodeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			episodeCacheModel.createDate = createDate.getTime();
		}
		else {
			episodeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			episodeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			episodeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		episodeCacheModel.title = getTitle();

		String title = episodeCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			episodeCacheModel.title = null;
		}

		Date airDate = getAirDate();

		if (airDate != null) {
			episodeCacheModel.airDate = airDate.getTime();
		}
		else {
			episodeCacheModel.airDate = Long.MIN_VALUE;
		}

		episodeCacheModel.episodeNumber = getEpisodeNumber();

		episodeCacheModel.description = getDescription();

		String description = episodeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			episodeCacheModel.description = null;
		}

		episodeCacheModel.imageUrl = getImageUrl();

		String imageUrl = episodeCacheModel.imageUrl;

		if ((imageUrl != null) && (imageUrl.length() == 0)) {
			episodeCacheModel.imageUrl = null;
		}

		episodeCacheModel.imageUuid = getImageUuid();

		String imageUuid = episodeCacheModel.imageUuid;

		if ((imageUuid != null) && (imageUuid.length() == 0)) {
			episodeCacheModel.imageUuid = null;
		}

		episodeCacheModel.imageTitle = getImageTitle();

		String imageTitle = episodeCacheModel.imageTitle;

		if ((imageTitle != null) && (imageTitle.length() == 0)) {
			episodeCacheModel.imageTitle = null;
		}

		episodeCacheModel.imageVersion = getImageVersion();

		String imageVersion = episodeCacheModel.imageVersion;

		if ((imageVersion != null) && (imageVersion.length() == 0)) {
			episodeCacheModel.imageVersion = null;
		}

		episodeCacheModel.seasonId = getSeasonId();

		return episodeCacheModel;
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

	private static ClassLoader _classLoader = Episode.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Episode.class
		};
	private long _episodeId;
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
	private Date _airDate;
	private int _episodeNumber;
	private String _description;
	private String _imageUrl;
	private String _imageUuid;
	private String _imageTitle;
	private String _imageVersion;
	private long _seasonId;
	private long _originalSeasonId;
	private boolean _setOriginalSeasonId;
	private long _columnBitmask;
	private Episode _escapedModel;
}