<%@ include file="/html/init.jsp"  %>

<%

	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	long groupId = serviceContext.getScopeGroupId();
	

	// initialize the service container	
	
	String orderByCol = ParamUtil.getString(request, "orderByCol", "title");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	
	OrderByComparator orderByComparator = ComparatorUtil.getTvShowOrderByComparator(orderByCol, orderByType);
	
	
	// get tvshows count
	
	int totalCount = TvShowLocalServiceUtil.getTvShowsCount(serviceContext);
	List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(serviceContext, orderByComparator);
	
	//tvShows = ListUtil.copy(tvShows);
	//Collections.sort(tvShows, orderByComparator);
	
	
	// search /// TODO
	
	String keywords = ParamUtil.getString(renderRequest, "keywords");
	
%>

<aui:container style="margin-right: 20px; margin-left: 20px;">
		
	<aui:row>
		<aui:col span="12">
			<liferay-ui:search-container 
				delta="10" 
				emptyResultsMessage="There aren't any TvShow!" 
				orderByCol="<%= orderByCol %>" 
				orderByType="<%= orderByType %>" 
				orderByComparator="<%= orderByComparator %>" 
				total="<%= totalCount %>" > 
	 
				<liferay-ui:search-form page="/html/tvshowadmin/search_form.jsp" searchContainer="<%= searchContainer %>" servletContext="<%= application %>" />
		
				<liferay-ui:search-container-results results="<%= ListUtil.subList(tvShows, searchContainer.getStart(), searchContainer.getEnd()) %>" />
			
				<liferay-ui:search-container-row 
							className="hu.webtown.liferay.tvtracker.model.TvShow" 
							keyProperty="tvShowId" 
							modelVar="tvShow" 
							indexVar="idx" >
					
					<liferay-ui:search-container-column-text 
								cssClass="searchContainerColumnClass" 
								property="title" 
								orderable="true" 
								orderableProperty="title" />
					
					<liferay-ui:search-container-column-text 
								cssClass="searchContainerColumnClass" 
								name="PremierYear" 
								orderable="true" 
								orderableProperty="premierYear" >
						<fmt:formatDate value="<%= tvShow.getPremierDate() %>" type="date" pattern="yyyy"/>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text 
								cssClass="searchContainerColumnClass" 
								name="Seasons">
						<%
							long currentTvShowId = tvShow.getTvShowId();
							int seasonsCount = SeasonLocalServiceUtil.getSeasonsCount(currentTvShowId, serviceContext);
							
							out.print(seasonsCount);
						%>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text 
								cssClass="searchContainerColumnClass !important" 
								name="Modifier" 
								property="userName" />
					
					<liferay-ui:search-container-column-text 
								cssClass="searchContainerColumnClass" 
								name="Last Modified">
						<fmt:formatDate value="<%= tvShow.getModifiedDate() %>" type="date" pattern="MMM dd, yyyy" />
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-jsp 
								cssClass="searchContainerColumnClass" 
								path="/html/tvshowadmin/actions.jsp" />
					
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator/>
				
			</liferay-ui:search-container>
		</aui:col>
	</aui:row>
</aui:container>

