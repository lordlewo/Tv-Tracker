<%@ include file="/html/init.jsp" %>

<%
	ResultRow resultRow = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	TvShow tvShow = (TvShow) resultRow.getObject();
	long tvShowId = tvShow.getTvShowId();
%>

<liferay-ui:icon-menu>
	
	<c:if test="<%= TvShowPermission.contains(permissionChecker, tvShowId, ActionKeys.UPDATE) %>" >
		<portlet:renderURL var="tvShowEditURL">
			<portlet:param name="<%= WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId) %>" />
			<portlet:param name="method" value="edit"/>
			<portlet:param name="mvcPath" value="/html/tvshowadmin/edit.jsp"/>
		</portlet:renderURL>
				
		<liferay-ui:icon image="edit" message="Edit" url="<%= tvShowEditURL %>" />
	</c:if>
	
	<c:if test="<%= TvShowPermission.contains(permissionChecker, tvShowId, ActionKeys.PERMISSIONS) %>" >
		<liferay-security:permissionsURL 
					modelResource="<%= TvShow.class.getName() %>" 
					modelResourceDescription="<%= tvShow.getTitle() %>" 
					resourcePrimKey="<%= String.valueOf(tvShowId) %>" 
					var="permissionsURL"/>
					
		<liferay-ui:icon image="permissions" message="Permission" url="<%= permissionsURL %>" />
	</c:if>
	
	<c:if test="<%= TvShowPermission.contains(permissionChecker, tvShowId, ActionKeys.DELETE) %>" >
		<portlet:actionURL name="deleteTvShow"	var="tvShowDeleteURL">
			<portlet:param name="tvShowId" value="<%= String.valueOf(tvShowId) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete message="Delete" url="<%= tvShowDeleteURL %>" />
	</c:if>

</liferay-ui:icon-menu>