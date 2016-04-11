<%@ include file="/html/init.jsp" %>

<% 
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

	long tvShowId = ParamUtil.getLong(request, renderResponse.getNamespace() + WebKeys.TVSHOW_ID);
	long seasonId = ParamUtil.getLong(request, renderResponse.getNamespace() + WebKeys.SEASON_ID);
	
	TvShow tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);
	Season season = SeasonLocalServiceUtil.getSeason(seasonId, serviceContext);

	
	List<Episode> episodes = EpisodeLocalServiceUtil.getEpisodes(seasonId, serviceContext);
	
	
	List<Episode> permissionCheckedEpisodes = new ArrayList<Episode>();
	
	// permisssion checking in scriplet
	
	for(Episode episode : episodes){
		
		long episodeId = episode.getEpisodeId();
		
		if(EpisodePermission.contains(permissionChecker, episodeId, ActionKeys.VIEW)){
			
			permissionCheckedEpisodes.add(episode);
		}
	}
	
%>


<aui:container>

	<c:if test="<%= !permissionCheckedEpisodes.isEmpty() %>">
		<% 
			for(Episode episode: permissionCheckedEpisodes){
		%>
			<aui:row style="padding: 10px; border-bottom: 2px solid #cacaca">
				<aui:col span="6">
					<div style="padding: 10px;">
						
						<c:choose>
							<c:when test="<%= !episode.getImageUrl().isEmpty() %>">
								<img src="<%= episode.getImageUrl() %>" style="width: 50;" />
							</c:when>
							<c:when test="<%= !season.getImageUrl().isEmpty() %>">
								<img src="<%= season.getImageUrl() %>" style="width: 50;" />
							</c:when>
							<c:otherwise>
								<img src="<%= tvShow.getImageUrl() %>" style="width: 50;" />
							</c:otherwise>
						</c:choose>
					</div>
				</aui:col>
				<aui:col span="6" >
					<aui:row style="padding-left: 10px; padding-top: 10px;">
						<aui:col span="11" style="margin-bottom: 10px; border-bottom: 2px solid #ccc;">
							<h5> <%= episode.getTitle() %> </h5>
						</aui:col>
					</aui:row>
					
					<aui:row style="padding-left: 20px;">
						<aui:col span="3">
							Air Date:
						</aui:col>
						<aui:col span="9">
							<fmt:formatDate value="<%= episode.getAirDate() %>" type="date" pattern="MMM dd, yyyy"/>
						</aui:col>
					</aui:row>
					
					<aui:row style="padding-left: 20px;">
						<aui:col span="3">
							Episode:
						</aui:col>
						<aui:col span="9">
							<%=season.getSeasonNumber()%>x<fmt:formatNumber value="<%=episode.getEpisodeNumber()%>" type="number" minIntegerDigits="2"/>  
						</aui:col>
					</aui:row>
					
					<aui:row style="padding-left: 10px;">
						<aui:col span="11" style="border-top: 2px solid #ccc; padding-top: 10px; padding-left: 10px; padding-right: 10px; text-align: justify;">
							<%= episode.getDescription() %>
						</aui:col>
					</aui:row>
					
					
				</aui:col>
			</aui:row>
		<% 
			}
		%>
	</c:if>
	
	<c:if test="<%= permissionCheckedEpisodes.isEmpty() && !episodes.isEmpty() %>">
		You must have the appropriate permission for view the episodes!
	</c:if>
	
</aui:container>