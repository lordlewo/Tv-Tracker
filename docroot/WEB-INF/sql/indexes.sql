create index IX_D45656 on TvT_Episode (groupId);
create index IX_6301E5A8 on TvT_Episode (groupId, seasonId);

create index IX_2603E3B4 on TvT_Season (groupId);
create index IX_BBDED586 on TvT_Season (groupId, seasonId);
create index IX_94FD7942 on TvT_Season (groupId, tvShowId);

create index IX_1814D478 on TvT_TvShow (groupId);
create index IX_97C84080 on TvT_TvShow (tvShowId);
create index IX_CCBDC42A on TvT_TvShow (tvShowId, groupId);