<%@ include file="/html/init.jsp" %>

<%
	ResultRow resultRow = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	Episode episode = (Episode) resultRow.getObject();
	long episodeId = episode.getEpisodeId();
%>

<liferay-ui:icon-menu>
	
	
	<c:if test="<%= EpisodePermission.contains(permissionChecker, episodeId, ActionKeys.UPDATE) %>" >
	
		<portlet:renderURL var="updateEpisodeURL">
			<portlet:param name="<%= WebKeys.EPISODE_ID %>" value="<%= String.valueOf(episodeId) %>" />
			<portlet:param name="action" value="update"/>
			<portlet:param name="mvcPath" value="/html/episodeadmin/edit.jsp"/>
		</portlet:renderURL>
				
		<liferay-ui:icon image="edit" message="Edit" url="<%= updateEpisodeURL %>" />
		
	</c:if>
	
	
	<c:if test="<%= EpisodePermission.contains(permissionChecker, episodeId, ActionKeys.PERMISSIONS) %>" >
	
		<liferay-security:permissionsURL 
					modelResource="<%= Episode.class.getName() %>" 
					modelResourceDescription="<%= episode.getTitle() %>" 
					resourcePrimKey="<%= String.valueOf(episodeId) %>" 
					var="permissionsURL"/>
					
		<liferay-ui:icon image="permissions" message="Permission" url="<%= permissionsURL %>" />
		
	</c:if>
	
	
	<c:if test="<%= EpisodePermission.contains(permissionChecker, episodeId, ActionKeys.DELETE) %>" >
	
		<portlet:actionURL name="deleteEpisode"	var="episodeDeleteURL">
			<portlet:param name="<%= WebKeys.EPISODE_ID %>" value="<%= String.valueOf(episodeId) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete message="Delete" url="<%= episodeDeleteURL %>" />
		
	</c:if>


</liferay-ui:icon-menu>