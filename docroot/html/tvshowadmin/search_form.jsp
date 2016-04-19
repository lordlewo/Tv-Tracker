<%@ include file="/html/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	long groupId = serviceContext.getScopeGroupId();
	
%>


<liferay-portlet:renderURL varImpl="searchURL">
	<liferay-portlet:param name="mvcPath" value="/html/tvshowadmin/view.jsp"/> 
</liferay-portlet:renderURL>


<aui:form action="<%= searchURL %>" method="get" name="form">

	<liferay-portlet:renderURLParams varImpl="searchURL"/>

	<aui:row>
		<aui:col span="12">

			<div class="search-form">
				<span class="aui-search-bar">
					<aui:input name="keywords" type="text" title="Search TvShows" inlineField="true" label="" />
				
					<aui:button icon="icon-search" type="submit" value="search" />
				</span>
			</div>

		</aui:col>
	</aui:row>
	
</aui:form>


<c:if test="<%= TvTrackerModelPermission.contains(permissionChecker, groupId, ActionKeys.ADD_TVSHOW) %>">
	<aui:row>
		<aui:col span="12">
		
			<portlet:renderURL var="addTvShowURL">
				<portlet:param name="action" value="add"/>
				<portlet:param name="mvcPath" value="/html/tvshowadmin/edit.jsp"/>
			</portlet:renderURL>
			
			<aui:button-row>
				<aui:button icon="icon-plus" value="Add TvShow" href="<%= addTvShowURL %>" />
			</aui:button-row>
			
		</aui:col>
	</aui:row>
</c:if>