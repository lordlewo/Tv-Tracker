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
 * This class is used by SOAP remote services, specifically {@link hu.webtown.liferay.tvtracker.service.http.TvShowServiceSoap}.
 *
 * @author czeni
 * @see hu.webtown.liferay.tvtracker.service.http.TvShowServiceSoap
 * @generated
 */
public class TvShowSoap implements Serializable {
	public static TvShowSoap toSoapModel(TvShow model) {
		TvShowSoap soapModel = new TvShowSoap();

		soapModel.setTvShowId(model.getTvShowId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setPremierDate(model.getPremierDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setImageUuid(model.getImageUuid());
		soapModel.setImageTitle(model.getImageTitle());
		soapModel.setImageVersion(model.getImageVersion());

		return soapModel;
	}

	public static TvShowSoap[] toSoapModels(TvShow[] models) {
		TvShowSoap[] soapModels = new TvShowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TvShowSoap[][] toSoapModels(TvShow[][] models) {
		TvShowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TvShowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TvShowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TvShowSoap[] toSoapModels(List<TvShow> models) {
		List<TvShowSoap> soapModels = new ArrayList<TvShowSoap>(models.size());

		for (TvShow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TvShowSoap[soapModels.size()]);
	}

	public TvShowSoap() {
	}

	public long getPrimaryKey() {
		return _tvShowId;
	}

	public void setPrimaryKey(long pk) {
		setTvShowId(pk);
	}

	public long getTvShowId() {
		return _tvShowId;
	}

	public void setTvShowId(long tvShowId) {
		_tvShowId = tvShowId;
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

	private long _tvShowId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private Date _premierDate;
	private String _description;
	private String _imageUrl;
	private String _imageUuid;
	private String _imageTitle;
	private String _imageVersion;
}