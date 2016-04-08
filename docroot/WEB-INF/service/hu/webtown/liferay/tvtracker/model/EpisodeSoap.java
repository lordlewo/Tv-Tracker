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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link hu.webtown.liferay.tvtracker.service.http.EpisodeServiceSoap}.
 *
 * @author czeni
 * @see hu.webtown.liferay.tvtracker.service.http.EpisodeServiceSoap
 * @generated
 */
public class EpisodeSoap implements Serializable {
	public static EpisodeSoap toSoapModel(Episode model) {
		EpisodeSoap soapModel = new EpisodeSoap();

		soapModel.setEpisodeId(model.getEpisodeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setAirDate(model.getAirDate());
		soapModel.setEpisodeNumber(model.getEpisodeNumber());
		soapModel.setDescription(model.getDescription());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setImageUuid(model.getImageUuid());
		soapModel.setImageTitle(model.getImageTitle());
		soapModel.setImageVersion(model.getImageVersion());
		soapModel.setSeasonId(model.getSeasonId());

		return soapModel;
	}

	public static EpisodeSoap[] toSoapModels(Episode[] models) {
		EpisodeSoap[] soapModels = new EpisodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EpisodeSoap[][] toSoapModels(Episode[][] models) {
		EpisodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EpisodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EpisodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EpisodeSoap[] toSoapModels(List<Episode> models) {
		List<EpisodeSoap> soapModels = new ArrayList<EpisodeSoap>(models.size());

		for (Episode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EpisodeSoap[soapModels.size()]);
	}

	public EpisodeSoap() {
	}

	public long getPrimaryKey() {
		return _episodeId;
	}

	public void setPrimaryKey(long pk) {
		setEpisodeId(pk);
	}

	public long getEpisodeId() {
		return _episodeId;
	}

	public void setEpisodeId(long episodeId) {
		_episodeId = episodeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public Date getAirDate() {
		return _airDate;
	}

	public void setAirDate(Date airDate) {
		_airDate = airDate;
	}

	public int getEpisodeNumber() {
		return _episodeNumber;
	}

	public void setEpisodeNumber(int episodeNumber) {
		_episodeNumber = episodeNumber;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getImageUuid() {
		return _imageUuid;
	}

	public void setImageUuid(String imageUuid) {
		_imageUuid = imageUuid;
	}

	public String getImageTitle() {
		return _imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
	}

	public String getImageVersion() {
		return _imageVersion;
	}

	public void setImageVersion(String imageVersion) {
		_imageVersion = imageVersion;
	}

	public long getSeasonId() {
		return _seasonId;
	}

	public void setSeasonId(long seasonId) {
		_seasonId = seasonId;
	}

	private long _episodeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}