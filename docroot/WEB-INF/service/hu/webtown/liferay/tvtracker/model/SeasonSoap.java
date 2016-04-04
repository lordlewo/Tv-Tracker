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
 * This class is used by SOAP remote services, specifically {@link hu.webtown.liferay.tvtracker.service.http.SeasonServiceSoap}.
 *
 * @author czeni
 * @see hu.webtown.liferay.tvtracker.service.http.SeasonServiceSoap
 * @generated
 */
public class SeasonSoap implements Serializable {
	public static SeasonSoap toSoapModel(Season model) {
		SeasonSoap soapModel = new SeasonSoap();

		soapModel.setSeasonId(model.getSeasonId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setPremierDate(model.getPremierDate());
		soapModel.setSeasonNumber(model.getSeasonNumber());
		soapModel.setDescription(model.getDescription());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setImageUuid(model.getImageUuid());
		soapModel.setImageTitle(model.getImageTitle());
		soapModel.setImageVersion(model.getImageVersion());
		soapModel.setTvShowId(model.getTvShowId());

		return soapModel;
	}

	public static SeasonSoap[] toSoapModels(Season[] models) {
		SeasonSoap[] soapModels = new SeasonSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SeasonSoap[][] toSoapModels(Season[][] models) {
		SeasonSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SeasonSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SeasonSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SeasonSoap[] toSoapModels(List<Season> models) {
		List<SeasonSoap> soapModels = new ArrayList<SeasonSoap>(models.size());

		for (Season model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SeasonSoap[soapModels.size()]);
	}

	public SeasonSoap() {
	}

	public long getPrimaryKey() {
		return _seasonId;
	}

	public void setPrimaryKey(long pk) {
		setSeasonId(pk);
	}

	public long getSeasonId() {
		return _seasonId;
	}

	public void setSeasonId(long seasonId) {
		_seasonId = seasonId;
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

	public Date getPremierDate() {
		return _premierDate;
	}

	public void setPremierDate(Date premierDate) {
		_premierDate = premierDate;
	}

	public int getSeasonNumber() {
		return _seasonNumber;
	}

	public void setSeasonNumber(int seasonNumber) {
		_seasonNumber = seasonNumber;
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

	public long getTvShowId() {
		return _tvShowId;
	}

	public void setTvShowId(long tvShowId) {
		_tvShowId = tvShowId;
	}

	private long _seasonId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}