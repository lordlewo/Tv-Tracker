create table TvT_Episode (
	episodeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	airDate DATE null,
	episodeNumber INTEGER,
	description VARCHAR(1000) null,
	imageUrl VARCHAR(1000) null,
	imageUuid VARCHAR(75) null,
	imageTitle VARCHAR(75) null,
	imageVersion VARCHAR(75) null,
	seasonId LONG
);

create table TvT_Season (
	seasonId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	premierDate DATE null,
	seasonNumber INTEGER,
	description VARCHAR(1000) null,
	imageUrl VARCHAR(1000) null,
	imageUuid VARCHAR(75) null,
	imageTitle VARCHAR(75) null,
	imageVersion VARCHAR(75) null,
	tvShowId LONG
);

create table TvT_TvShow (
	tvShowId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	premierDate DATE null,
	description VARCHAR(1000) null,
	imageUrl VARCHAR(1000) null,
	imageUuid VARCHAR(75) null,
	imageTitle VARCHAR(75) null,
	imageVersion VARCHAR(75) null
);