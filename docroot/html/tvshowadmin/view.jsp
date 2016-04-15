<%@ include file="/html/init.jsp"  %>

<%

	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	long groupId = serviceContext.getScopeGroupId();
	

	// initialize the service container	
	
	String orderByCol = ParamUtil.getString(request, "orderByCol", "title");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	
	OrderByComparator orderByComparator = ComparatorUtil.getTvShowOrderByComparator(orderByCol, orderByType);
	
	
	// get tvshows
	
	int totalCount = TvShowLocalServiceUtil.getTvShowsCount(serviceContext);
	List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(serviceContext, orderByComparator);
	
	tvShows = ListUtil.copy(tvShows);
	Collections.sort(tvShows, orderByComparator);
	
	
	// search
	
	String keywords = ParamUtil.getString(renderRequest, "keywords");
	
%>

<aui:container>
	<aui:row>
		<aui:col span="12">
			<liferay-portlet:renderURL varImpl="searchURL">
				<liferay-portlet:param name="mvcPath" value="/html/tvshowadmin/view.jsp"/>
			</liferay-portlet:renderURL>
		
			<aui:form action="<%= searchURL %>" method="get" name="form">
				<liferay-portlet:renderURLParams varImpl="searchURL"/>
				
				<div class="search-form">
					<span class="aui-search-bar">
						<aui:input name="keywords" type="text" inlineField="true" label="Searching for TvShows:"  style="width: 300px;"/>
					
						<aui:button icon="icon-search" type="submit" value="search" />
					</span>
				</div>
			</aui:form>
		</aui:col>
	</aui:row>
	
	<c:if test="<%= TvTrackerModelPermission.contains(permissionChecker, groupId, ActionKeys.ADD_TVSHOW) %>">
		<aui:row>
			<aui:col span="12">
				<portlet:renderURL var="addTvShowURL">
					<portlet:param name="method" value="add"/>
					<portlet:param name="mvcPath" value="/html/tvshowadmin/edit.jsp"/>
				</portlet:renderURL>
				
				<aui:button-row>
					<aui:button icon="icon-plus" value="Add TvShow" href="<%= addTvShowURL %>" />
				</aui:button-row>
			</aui:col>
		</aui:row>
	</c:if>
	
	<aui:row>
		<aui:col span="12">
			<liferay-ui:search-container 
				delta="10" 
				emptyResultsMessage="There aren't any TvShow!" 
				orderByCol="<%= orderByCol %>" 
				orderByType="<%= orderByType %>" 
				orderByComparator="<%= orderByComparator %>" 
				total="<%= totalCount %>" > 
	 
		
				<liferay-ui:search-container-results results="<%= tvShows %>" />
			
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
								name="PremierDate" 
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

