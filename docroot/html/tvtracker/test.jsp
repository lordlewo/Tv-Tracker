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

<portlet:actionURL name="testAuto" var="testAutoURL"/>
 
<aui:form name="fm" method="POST" action="<%=testAutoURL%>" >

	<div id="member-fields">
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields" style="display: flex;">
				<aui:input name="firstName" label="First Name" />
				<aui:input name="lastName" label="Last Name" />
				<aui:select name="gender" label="Gender">
					<aui:option value="male" label="Male"></aui:option>
					<aui:option value="female" label="Female"></aui:option>
				</aui:select>
			</div>
		</div>
	</div>
	
	<aui:button type="submit"/>

</aui:form>

<aui:script use="liferay-auto-fields">
 
	new Liferay.AutoFields(
		{
			contentBox: '#member-fields',
			fieldIndexes: '<portlet:namespace />rowIndexes',
			sortable: true,
			sortableHandle: '.row-fields',
		}
	).render();

</aui:script>
