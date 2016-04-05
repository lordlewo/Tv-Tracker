<%@ include file="/html/init.jsp" %>

<%--  

	<portlet:renderURL var="navigateToTestURL">
		<portlet:param name="mvcPath" value="/html/tvtracker/test.jsp"/>
	</portlet:renderURL>
	
	<br/>
	Go to <strong>test.jsp</strong>:
	<aui:button name="testButton" value="test.jsp" onClick="<%= navigateToTestURL %>"/>
	
--%>
<% 

	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	
%>

<h1>Tv Tracker</h1>


<liferay-ui:search-container delta="10" total="<%= TvShowLocalServiceUtil.getTvShowsCount(serviceContext) %>" >

	<liferay-ui:search-container-results>
		<% 
			results = TvShowLocalServiceUtil.getTvShows(serviceContext, searchContainer.getStart(), searchContainer.getEnd());
			pageContext.setAttribute("results", results);
		%>
	</liferay-ui:search-container-results> 
	
		<liferay-ui:search-container-row className="hu.webtown.liferay.tvtracker.model.TvShow" modelVar="tvShow">
			
			<!-- tvshow image -->
			
			<liferay-ui:search-container-column-jsp name="Cover" path="/html/tvtracker/image.jsp"  />
			
			
			<!-- tvshow title -->
			
			<liferay-ui:search-container-column-text property="title" />
			
			
			<!-- tvshow premier year -->
			
			<liferay-ui:search-container-column-text property="premierYear" name="Premier Year" />
			
			
			<!-- season count -->
			
			<liferay-ui:search-container-column-text  name="Season Count" > 
				<%
					long currentTvShowId = tvShow.getTvShowId();
					int seasonsCount = SeasonLocalServiceUtil.getSeasonsCount(currentTvShowId, serviceContext);
					
					out.print(seasonsCount);
				%>
			</liferay-ui:search-container-column-text>
			
			
			<!-- navigation to the tvshow details page -->
			
			<portlet:renderURL var="detailsURL">
				<portlet:param name="mvcPath" value="/html/tvtracker/detail/tvshow_detail.jsp"/>
				<portlet:param name="tvShowId" value="<%= String.valueOf(tvShow.getTvShowId()) %>"/>
			</portlet:renderURL>
			
			<liferay-ui:search-container-column-text name="Details" value=">>>>" href="<%= detailsURL %>" />
			
		</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


