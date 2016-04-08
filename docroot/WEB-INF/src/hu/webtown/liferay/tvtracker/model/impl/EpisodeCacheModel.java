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

import hu.webtown.liferay.tvtracker.model.Episode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Episode in entity cache.
 *
 * @author czeni
 * @see Episode
 * @generated
 */
public class EpisodeCacheModel implements CacheModel<Episode>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{episodeId=");
		sb.append(episodeId);
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
		sb.append(", airDate=");
		sb.append(airDate);
		sb.append(", episodeNumber=");
		sb.append(episodeNumber);
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
		sb.append(", seasonId=");
		sb.append(seasonId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Episode toEntityModel() {
		EpisodeImpl episodeImpl = new EpisodeImpl();

		episodeImpl.setEpisodeId(episodeId);
		episodeImpl.setGroupId(groupId);
		episodeImpl.setCompanyId(companyId);
		episodeImpl.setUserId(userId);

		if (userName == null) {
			episodeImpl.setUserName(StringPool.BLANK);
		}
		else {
			episodeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			episodeImpl.setCreateDate(null);
		}
		else {
			episodeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			episodeImpl.setModifiedDate(null);
		}
		else {
			episodeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			episodeImpl.setTitle(StringPool.BLANK);
		}
		else {
			episodeImpl.setTitle(title);
		}

		if (airDate == Long.MIN_VALUE) {
			episodeImpl.setAirDate(null);
		}
		else {
			episodeImpl.setAirDate(new Date(airDate));
		}

		episodeImpl.setEpisodeNumber(episodeNumber);

		if (description == null) {
			episodeImpl.setDescription(StringPool.BLANK);
		}
		else {
			episodeImpl.setDescription(description);
		}

		if (imageUrl == null) {
			episodeImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			episodeImpl.setImageUrl(imageUrl);
		}

		if (imageUuid == null) {
			episodeImpl.setImageUuid(StringPool.BLANK);
		}
		else {
			episodeImpl.setImageUuid(imageUuid);
		}

		if (imageTitle == null) {
			episodeImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			episodeImpl.setImageTitle(imageTitle);
		}

		if (imageVersion == null) {
			episodeImpl.setImageVersion(StringPool.BLANK);
		}
		else {
			episodeImpl.setImageVersion(imageVersion);
		}

		episodeImpl.setSeasonId(seasonId);

		episodeImpl.resetOriginalValues();

		return episodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		episodeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		airDate = objectInput.readLong();
		episodeNumber = objectInput.readInt();
		description = objectInput.readUTF();
		imageUrl = objectInput.readUTF();
		imageUuid = objectInput.readUTF();
		imageTitle = objectInput.readUTF();
		imageVersion = objectInput.readUTF();
		seasonId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(episodeId);
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

		objectOutput.writeLong(airDate);
		objectOutput.writeInt(episodeNumber);

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

		objectOutput.writeLong(seasonId);
	}

	public long episodeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public long airDate;
	public int episodeNumber;
	public String description;
	public String imageUrl;
	public String imageUuid;
	public String imageTitle;
	public String imageVersion;
	public long seasonId;
}