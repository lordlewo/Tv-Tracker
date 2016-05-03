<%@ include file="/html/init.jsp"  %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	long groupId = serviceContext.getScopeGroupId();
	

	// initialize the service container	
	
	String orderByCol = ParamUtil.getString(request, "orderByCol", "title");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	
	OrderByComparator orderByComparator = ComparatorUtil.getEpisodeOrderByComparator(orderByCol, orderByType);

	// get episodes count
	
	int totalCount = EpisodeLocalServiceUtil.getEpisodesCount(serviceContext);
	
	
	// search /// TODO
	
	String keywords = ParamUtil.getString(renderRequest, "keywords");
%>

<aui:container cssClass="episodeAdmin">
		
	<aui:row>
		<aui:col span="12">
			<liferay-ui:search-container
				delta="10" 
				emptyResultsMessage="There aren't any Episodes!" 
				orderByCol="<%= orderByCol %>" 
				orderByType="<%= orderByType %>" 
				orderByComparator="<%= orderByComparator %>" 
				total="<%= totalCount %>" > 
	 			
				<liferay-ui:search-form 
							page="/html/episodeadmin/search_form.jsp" 
							searchContainer="<%= searchContainer %>" 
							servletContext="<%= application %>" />
		
				<liferay-ui:search-container-results>
					<%
						List<Episode> episodes = EpisodeLocalServiceUtil.getEpisodes(
								serviceContext, 
								searchContainer.getStart(), 
								searchContainer.getEnd(), 
								orderByComparator);
					
						//results.addAll(episodes);
						searchContainer.setResults(episodes);
					%>
				</liferay-ui:search-container-results>
			
				<liferay-ui:search-container-row 
							className="hu.webtown.liferay.tvtracker.model.Episode" 
							keyProperty="episodeId" 
							modelVar="episode" 
							indexVar="idx" >
					
					<liferay-ui:search-container-column-text 
								cssClass="searchContainerColumnClass" 
								property="title" 
								orderable="true" 
								orderableProperty="title" />
								
					<liferay-ui:search-container-column-text 
								cssClass="searchContainerColumnClass" 
								property="episodeNumber" 
								 />
					
					<liferay-ui:search-container-column-text 
								cssClass="searchContainerColumnClass" 
								name="AirDate" 
								orderable="true" 
								orderableProperty="airDate" >
						<fmt:formatDate value="<%= episode.getAirDate() %>" type="date" pattern="MMM dd, yyyy"/>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text 
								cssClass="searchContainerColumnClass !important" 
								name="Modifier" 
								property="userName" />
					
					<liferay-ui:search-container-column-text 
								cssClass="searchContainerColumnClass" 
								name="Last Modified">
						<fmt:formatDate value="<%= episode.getModifiedDate() %>" type="date" pattern="MMM dd, yyyy" />
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-jsp 
								cssClass="searchContainerColumnClass" 
								path="/html/episodeadmin/actions.jsp" />
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator/>
				
			</liferay-ui:search-container>
		</aui:col>
	</aui:row>
</aui:container>
