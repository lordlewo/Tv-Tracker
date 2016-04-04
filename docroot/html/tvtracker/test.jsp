<%@ include file="/html/init.jsp" %>

<h3>Testing:</h3>
<br> 

<portlet:actionURL name="testAddTvShow" var="testAddTvShowURL"/>
<portlet:actionURL name="testUpdateTvShow" var="testUpdateTvShowURL"/>
<portlet:actionURL name="testDeleteTvShow" var="testDeleteTvShowURL"/>

Add TvShow:
<aui:button name="addTvShowButton" value="Add TvShow" onClick="<%= testAddTvShowURL %>" />
<br>
Update TvShow:
<aui:button name="updateTvShowButton" value="Update TvShow" onClick="<%= testUpdateTvShowURL %>" />
<br>
Delete TvShow:
<aui:button name="deleteTvShowButton" value="Delete TvShow" onClick="<%= testDeleteTvShowURL %>" />

<br>
<br>

<portlet:actionURL name="testAddSeason" var="testAddSeasonURL"/>
<portlet:actionURL name="testUpdateSeason" var="testUpdateSeasonURL"/>
<portlet:actionURL name="testDeleteSeason" var="testDeleteSeasonURL"/>

Add Season:
<aui:button name="addSeasonButton" value="Add Season" onClick="<%= testAddSeasonURL %>" />
<br>
Update Season:
<aui:button name="updateSeasonButton" value="Update Season" onClick="<%= testUpdateSeasonURL %>" />
<br>
Delete  Season:
<aui:button name="deleteSeasonButton" value="Delete Season" onClick="<%= testDeleteSeasonURL %>" />
