<%@ include file="/html/init.jsp" %>

<h3>Testing:</h3>
<br> 

<portlet:actionURL name="testAddTvShow" var="testAddTvShowURL"/>
<portlet:actionURL name="testDeleteTvShow" var="testDeleteTvShowURL"/>

Add TvShows:
<aui:button name="addTvShowButton" value="Add TvShows" onClick="<%= testAddTvShowURL %>" />
<br>
<br>
Delete TvShows:
<aui:button name="deleteTvShowButton" value="Delete TvShows" onClick="<%= testDeleteTvShowURL %>" />

<br>
<br>

<portlet:actionURL name="testAddSeason" var="testAddSeasonURL"/>
<portlet:actionURL name="testDeleteSeason" var="testDeleteSeasonURL"/>

Add Seasons:
<aui:button name="addSeasonButton" value="Add Seasons" onClick="<%= testAddSeasonURL %>" />
<br>
<br>
Delete Seasons:
<aui:button name="deleteSeasonButton" value="Delete Seasons" onClick="<%= testDeleteSeasonURL %>" />

<br>
<br>

<portlet:actionURL name="testAddEpisode" var="testAddEpisodeURL"/>
<portlet:actionURL name="testDeleteEpisode" var="testDeleteEpisodeURL"/>

Add Episodes:
<aui:button name="addEpisodeButton" value="Add Episodes" onClick="<%= testAddEpisodeURL %>" />
<br>
<br>
Delete Episodes:
<aui:button name="deleteEpisodeButton" value="Delete Episodes" onClick="<%= testDeleteEpisodeURL %>" />
