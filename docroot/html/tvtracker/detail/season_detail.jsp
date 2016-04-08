<%@ include file="/html/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

	long tvShowId = ParamUtil.getLong(renderRequest, WebKeys.TVSHOW_ID);
	long seasonId = ParamUtil.getLong(renderRequest, WebKeys.SEASON_ID);
	
	TvShow tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);
	Season season = SeasonLocalServiceUtil.getSeason(seasonId, serviceContext);

	
	// tab selection logic
	
	int selectedTab = ParamUtil.getInteger(renderRequest, "selected_tab");
	
	boolean tabVisibility = true;
	String detailsCssClass = "active";
	String episodesCssClass = StringPool.BLANK;
	
	if(selectedTab == 0){
		tabVisibility = true;
		detailsCssClass = "active";
		episodesCssClass = StringPool.BLANK;
	} else {
		tabVisibility = false;
		detailsCssClass = StringPool.BLANK;
		episodesCssClass = "active";
	}
	
	
	// breadcrumb
	
	String currentURL = PortalUtil.getCurrentCompleteURL(request);
	PortalUtil.addPortletBreadcrumbEntry(request, tvShow.getTitle() + StringPool.SPACE + StringPool.FORWARD_SLASH + StringPool.SPACE + season.getTitle(), currentURL);
	PortalUtil.setPageSubtitle(season.getTitle(), request);
    PortalUtil.setPageDescription(season.getTitle(), request);

%>

<aui:container>

	<c:if test="<%= SeasonPermission.contains(permissionChecker, seasonId, ActionKeys.VIEW) %>">
		
		<aui:row style="margin-bottom: 20px; border-bottom: 2px solid #ccc;">
		
			<portlet:renderURL var="tvshowURL">
	        	<portlet:param name="mvcPath" value="/html/tvtracker/detail/tvshow_detail.jsp"/>
	        	<portlet:param name="<%= WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId) %>"/>
				<%-- (value = 0) -> details tab selected | (value != 0) -> seasons tab selected --%>
				<portlet:param name="selected_tab" value="0" />
			</portlet:renderURL>
		
			<%-- 			<liferay-ui:header backURL="<%= viewURL %>" title="<%= tvShow.getTitle() %>"/> --%>
			<h1> 
				<a href="<%= tvshowURL %>" class="icon-arrow-left" style="text-decoration: none;" ></a> &nbsp;
				<%= season.getTitle() %> 
			</h1>
		</aui:row>
		
		<aui:row>
			<aui:col span="3">
				<aui:row >
					<img src="<%= season.getImageUrl() %>" style="border-radius: 25px; border:2px solid #ccc; padding:2px; background:#eee;" />
				</aui:row>
			</aui:col>
			
			<aui:col span="9">
			
			    <portlet:renderURL var="detailsTabURL">
			        <portlet:param name="mvcPath" value="/html/tvtracker/detail/season_detail.jsp" />
			        <portlet:param name="<%= WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId)%>" />
			        <portlet:param name="<%= WebKeys.SEASON_ID %>" value="<%= String.valueOf(seasonId) %>"/>
			        <portlet:param name="selected_tab" value="0" />
			    </portlet:renderURL>
  			    <portlet:renderURL var="episodesTabURL">
			        <portlet:param name="mvcPath" value="/html/tvtracker/detail/season_detail.jsp" />
			        <portlet:param name="<%= WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId)%>" />
			        <portlet:param name="<%= WebKeys.SEASON_ID %>" value="<%= String.valueOf(seasonId) %>"/>
			        <portlet:param name="selected_tab" value="1" />
			    </portlet:renderURL>
			
				<aui:nav cssClass="nav-tabs">			
					<aui:nav-item cssClass="<%= detailsCssClass %>" label="Details" href="<%= detailsTabURL %>"/>			
					<aui:nav-item cssClass="<%= episodesCssClass %>" label="Episodes" href="<%= episodesTabURL %>" />
				</aui:nav>
				
				<c:if test="<%= tabVisibility %>">
					<div style="border-radius: 0px 0px 25px 25px; border:2px solid #ccc; padding: 20px; background:#eee; margin: 10px 0px;">
						<aui:row style="padding-left: 10px; padding-top: 10px;">
							<aui:col span="3"/>
							<aui:col span="8" style="margin-bottom: 10px; border-bottom: 2px solid #ccc;">
								<h3> <%= season.getTitle() %> </h3>
							</aui:col>
							<aui:col span="1"/>
						</aui:row>
						
						<aui:row style="padding-left: 10px; padding-top: 10px;">
							<aui:col span="3">
								<strong>Premier Date:</strong>
							</aui:col>
							<aui:col span="9" style="padding-left: 5px">
								<fmt:formatDate value="<%= season.getPremierDate() %>" type="date" pattern="MMM dd, yyyy"/>
							</aui:col>
						</aui:row>
						
						<aui:row style="padding-left: 10px; padding-top: 10px;">
							<aui:col span="3">
								<strong>Number of Episodes:</strong>
							</aui:col>
							<aui:col span="9" style="padding-left: 5px">
								<%= season.getEpisodeCount() %>
							</aui:col>
						</aui:row>
						
						<aui:row style="padding-left: 10px; padding-top: 10px;">
							<aui:col span="3">
								<strong>Description:</strong>
							</aui:col>
							<aui:col span="8" style="padding-left: 5px; padding-right: 10px; text-align: justify;">
								<%= season.getDescription() %>
							</aui:col>
						</aui:row>
					</div>
				</c:if>
				
				<c:if test="<%= !tabVisibility %>">
					<div style="border-radius: 0px 0px 25px 25px; border:2px solid #ccc; padding:10px 10px 20px 20px; background:#eee; margin: 10px 0px;">
						
						<liferay-util:include page="/html/tvtracker/detail/season_detail_episodes_tab.jsp" servletContext="<%= application %>" >
							<liferay-util:param name="<%= renderResponse.getNamespace() + WebKeys.SEASON_ID %>" value="<%= String.valueOf(seasonId) %>" />
						</liferay-util:include>
						
					</div>
				</c:if>
	
			</aui:col>
		</aui:row>
	
	</c:if>
	
	<c:if test="<%= !SeasonPermission.contains(permissionChecker, seasonId, ActionKeys.VIEW) %>">
		You must have the appropriate permission for view the season!
	</c:if>
	
</aui:container>