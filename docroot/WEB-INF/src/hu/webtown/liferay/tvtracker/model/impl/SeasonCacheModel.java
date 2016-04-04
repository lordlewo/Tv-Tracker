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

import hu.webtown.liferay.tvtracker.model.Season;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Season in entity cache.
 *
 * @author czeni
 * @see Season
 * @generated
 */
public class SeasonCacheModel implements CacheModel<Season>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{seasonId=");
		sb.append(seasonId);
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
		sb.append(", seasonNumber=");
		sb.append(seasonNumber);
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
		sb.append(", tvShowId=");
		sb.append(tvShowId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Season toEntityModel() {
		SeasonImpl seasonImpl = new SeasonImpl();

		seasonImpl.setSeasonId(seasonId);
		seasonImpl.setGroupId(groupId);
		seasonImpl.setCompanyId(companyId);
		seasonImpl.setUserId(userId);

		if (userName == null) {
			seasonImpl.setUserName(StringPool.BLANK);
		}
		else {
			seasonImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			seasonImpl.setCreateDate(null);
		}
		else {
			seasonImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			seasonImpl.setModifiedDate(null);
		}
		else {
			seasonImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			seasonImpl.setTitle(StringPool.BLANK);
		}
		else {
			seasonImpl.setTitle(title);
		}

		if (premierDate == Long.MIN_VALUE) {
			seasonImpl.setPremierDate(null);
		}
		else {
			seasonImpl.setPremierDate(new Date(premierDate));
		}

		seasonImpl.setSeasonNumber(seasonNumber);

		if (description == null) {
			seasonImpl.setDescription(StringPool.BLANK);
		}
		else {
			seasonImpl.setDescription(description);
		}

		if (imageUrl == null) {
			seasonImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			seasonImpl.setImageUrl(imageUrl);
		}

		if (imageUuid == null) {
			seasonImpl.setImageUuid(StringPool.BLANK);
		}
		else {
			seasonImpl.setImageUuid(imageUuid);
		}

		if (imageTitle == null) {
			seasonImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			seasonImpl.setImageTitle(imageTitle);
		}

		if (imageVersion == null) {
			seasonImpl.setImageVersion(StringPool.BLANK);
		}
		else {
			seasonImpl.setImageVersion(imageVersion);
		}

		seasonImpl.setTvShowId(tvShowId);

		seasonImpl.resetOriginalValues();

		return seasonImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		seasonId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		premierDate = objectInput.readLong();
		seasonNumber = objectInput.readInt();
		description = objectInput.readUTF();
		imageUrl = objectInput.readUTF();
		imageUuid = objectInput.readUTF();
		imageTitle = objectInput.readUTF();
		imageVersion = objectInput.readUTF();
		tvShowId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(seasonId);
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
		objectOutput.writeInt(seasonNumber);

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

		objectOutput.writeLong(tvShowId);
	}

	public long seasonId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public long premierDate;
	public int seasonNumber;
	public String description;
	public String imageUrl;
	public String imageUuid;
	public String imageTitle;
	public String imageVersion;
	public long tvShowId;
}