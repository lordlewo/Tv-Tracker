<%@ include file="/html/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

	long tvShowId = ParamUtil.getLong(renderRequest, WebKeys.TVSHOW_ID);
	long seasonId = ParamUtil.getLong(renderRequest, WebKeys.SEASON_ID);
	
	TvShow tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);
	Season season = SeasonLocalServiceUtil.getSeason(seasonId, serviceContext);

	
	// tab selection logic
	
	int selectedTab = ParamUtil.getInteger(renderRequest, "selected_tab", 0);
	
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
		
		<aui:row cssClass="seasonHeaderRow">
		
			<portlet:renderURL var="tvshowURL">
	        	<portlet:param name="mvcPath" value="/html/tvtracker/detail/tvshow_detail.jsp"/>
	        	<portlet:param name="<%= WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId) %>"/>
				<%-- (value = 0) -> tvshow.details tab selected | (value != 0) -> tvshow.seasons tab selected --%>
				<portlet:param name="selected_tab" value="1" />
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
					<c:choose>
						<c:when test="<%= !season.getImageUrl().isEmpty() %>">
							<img src="<%= season.getImageUrl() %>" id="seasonImage" />
						</c:when>
						<c:otherwise>
							<img src="<%= tvShow.getImageUrl() %>" id="seasonImage" />
						</c:otherwise>
					</c:choose>
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
					<div class="seasonDetailsTab">
						<aui:row cssClass="seasonDetailsTabRow">
							<aui:col span="3"/>
							<aui:col span="8" cssClass="seasonDetailsRowTitle">
								<h3> <%= season.getTitle() %> </h3>
							</aui:col>
							<aui:col span="1"/>
						</aui:row>
						
						<aui:row cssClass="seasonDetailsTabRow">
							<aui:col span="3">
								<strong>Premier Date:</strong>
							</aui:col>
							<aui:col span="8" cssClass="seasonDetailsRowText">
								<fmt:formatDate value="<%= season.getPremierDate() %>" type="date" pattern="MMM dd, yyyy"/>
							</aui:col>
						</aui:row>
						
						<aui:row cssClass="seasonDetailsTabRow">
							<aui:col span="3">
								<strong>Number of Episodes:</strong>
							</aui:col>
							<aui:col span="8" cssClass="seasonDetailsRowText">
								<%= season.getEpisodeCount() %>
							</aui:col>
						</aui:row>
						
						<aui:row cssClass="seasonDetailsTabRow">
							<aui:col span="3">
								<strong>Description:</strong>
							</aui:col>
							<aui:col span="8" cssClass="seasonDetailsRowText seasonDetailsRowTextDetails">
								<%= season.getDescription() %>
							</aui:col>
						</aui:row>
					</div>
				</c:if>
				
				<c:if test="<%= !tabVisibility %>">
					<div class="seasonEpisodesTab">
						
						<liferay-util:include page="/html/tvtracker/detail/season_detail_episodes_tab.jsp" servletContext="<%= application %>" >
							<liferay-util:param name="<%= renderResponse.getNamespace() + WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId) %>" />
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