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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import hu.webtown.liferay.tvtracker.model.TvShow;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TvShow in entity cache.
 *
 * @author czeni
 * @see TvShow
 * @generated
 */
public class TvShowCacheModel implements CacheModel<TvShow>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{tvShowId=");
		sb.append(tvShowId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", premierDate=");
		sb.append(premierDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append(", imageUuid=");
		sb.append(imageUuid);
		sb.append(", imageTitle=");
		sb.append(imageTitle);
		sb.append(", imageVersion=");
		sb.append(imageVersion);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TvShow toEntityModel() {
		TvShowImpl tvShowImpl = new TvShowImpl();

		tvShowImpl.setTvShowId(tvShowId);
		tvShowImpl.setGroupId(groupId);
		tvShowImpl.setCompanyId(companyId);
		tvShowImpl.setUserId(userId);

		if (userName == null) {
			tvShowImpl.setUserName(StringPool.BLANK);
		}
		else {
			tvShowImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tvShowImpl.setCreateDate(null);
		}
		else {
			tvShowImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tvShowImpl.setModifiedDate(null);
		}
		else {
			tvShowImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			tvShowImpl.setTitle(StringPool.BLANK);
		}
		else {
			tvShowImpl.setTitle(title);
		}

		if (premierDate == Long.MIN_VALUE) {
			tvShowImpl.setPremierDate(null);
		}
		else {
			tvShowImpl.setPremierDate(new Date(premierDate));
		}

		if (description == null) {
			tvShowImpl.setDescription(StringPool.BLANK);
		}
		else {
			tvShowImpl.setDescription(description);
		}

		if (imageUrl == null) {
			tvShowImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			tvShowImpl.setImageUrl(imageUrl);
		}

		if (imageUuid == null) {
			tvShowImpl.setImageUuid(StringPool.BLANK);
		}
		else {
			tvShowImpl.setImageUuid(imageUuid);
		}

		if (imageTitle == null) {
			tvShowImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			tvShowImpl.setImageTitle(imageTitle);
		}

		if (imageVersion == null) {
			tvShowImpl.setImageVersion(StringPool.BLANK);
		}
		else {
			tvShowImpl.setImageVersion(imageVersion);
		}

		tvShowImpl.resetOriginalValues();

		return tvShowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tvShowId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		premierDate = objectInput.readLong();
		description = objectInput.readUTF();
		imageUrl = objectInput.readUTF();
		imageUuid = objectInput.readUTF();
		imageTitle = objectInput.readUTF();
		imageVersion = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tvShowId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(premierDate);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (imageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}

		if (imageUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageUuid);
		}

		if (imageTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageTitle);
		}

		if (imageVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageVersion);
		}
	}

	public long tvShowId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public long premierDate;
	public String description;
	public String imageUrl;
	public String imageUuid;
	public String imageTitle;
	public String imageVersion;
}