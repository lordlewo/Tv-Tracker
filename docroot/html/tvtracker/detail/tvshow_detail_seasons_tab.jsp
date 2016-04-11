<%@ include file="/html/init.jsp" %>

<% 
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

	long tvShowId = ParamUtil.getLong(request, renderResponse.getNamespace() + WebKeys.TVSHOW_ID);
	TvShow tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);
	
	
	List<Season> seasons = SeasonLocalServiceUtil.getSeasons(tvShowId, serviceContext);
	
	
	List<Season> permissionCheckedSeasons = new ArrayList<Season>();
	
	// permisssion checking in scriplet
	
	for(Season season : seasons){
		
		long seasonId = season.getSeasonId();
		
		if(SeasonPermission.contains(permissionChecker, seasonId, ActionKeys.VIEW)){
			
			permissionCheckedSeasons.add(season);
		}
	}
	
%>


<aui:container>
	
	<aui:row style="padding: 10px;">
		<aui:col span="4">
			<h5 style="text-align: center;">Cover</h5>
		</aui:col>
		<aui:col span="3">
			<h5 style="text-align: center;">Title</h5>
		</aui:col>
		<aui:col span="3">
			<h5 style="text-align: center;">Episodes</h5>
		</aui:col>
	</aui:row>

	<c:if test="<%= !permissionCheckedSeasons.isEmpty() %>">
		<% 
			for(Season season: permissionCheckedSeasons){
		%>
			<aui:row style="padding: 10px; border-top: 2px solid #cacaca">
				<aui:col span="4">
					<div style="padding: 10px;">
						<c:choose>
							<c:when test="<%= !season.getImageUrl().isEmpty() %>">
								<img src="<%= season.getImageUrl() %>" style="width: 50;" />
							</c:when>
							<c:otherwise>
								<img src="<%= tvShow.getImageUrl() %>" style="width: 50;" />
							</c:otherwise>
						</c:choose>
					</div>
				</aui:col>
				<aui:col span="3" >
					<div style="text-align: center; margin-top: 20px;">
						<%= season.getTitle() %>
					</div>
				</aui:col>
				<aui:col span="3">
					<div style="text-align: center; margin-top: 20px;">
						<%= season.getEpisodeCount() %>
					</div>
				</aui:col>
				<aui:col span="2">
				
					<%-- navigation to the season details page --%>

					<portlet:renderURL var="detailsURL">
						<portlet:param name="mvcPath" value="/html/tvtracker/detail/season_detail.jsp"/>
						<portlet:param name="<%= WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId) %>"/>
						<portlet:param name="<%= WebKeys.SEASON_ID %>" value="<%= String.valueOf(season.getSeasonId()) %>"/>
						<%-- (value = 0) -> season.details tab selected | (value != 0) -> season.episodes tab selected --%>
						<portlet:param name="selected_tab" value="0" />
					</portlet:renderURL>
				
					<div style="text-align: center; margin-top: 20px;">
						<aui:button icon="icon-arrow-right" href="<%= detailsURL %>"/>
					</div>
				</aui:col>
			</aui:row>
		<% 
			}
		%>
	</c:if>
	
	<c:if test="<%= permissionCheckedSeasons.isEmpty() && !seasons.isEmpty() %>">
		You must have the appropriate permission for view the episodes!
	</c:if>
	
</aui:container>