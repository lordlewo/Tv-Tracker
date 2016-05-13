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
			for (Episode episode: permissionCheckedEpisodes){
		%>
			<aui:row cssClass="seasonEpisodesTabRow">
				<aui:col span="6" cssClass="seasonEpisodesTabRowImage">
					<c:choose>
						<c:when test="<%= !episode.getImageUrl().isEmpty() %>">
							<img src="<%= episode.getImageUrl() %>" />
						</c:when>
						<c:when test="<%= !season.getImageUrl().isEmpty() %>">
							<img src="<%= season.getImageUrl() %>" />
						</c:when>
						<c:otherwise>
							<img src="<%= tvShow.getImageUrl() %>" />
						</c:otherwise>
					</c:choose>
				</aui:col>
				<aui:col span="6" >
					<aui:row cssClass="seasonEpisodesTabRowTitle">
						<aui:col span="11" >
							<h5> <%= HtmlUtil.escape(episode.getTitle()) %> </h5> 
						</aui:col>
					</aui:row>
					
					<aui:row cssClass="seasonEpisodesTabRowText">
						<aui:col span="3">
							Air Date:
						</aui:col>
						<aui:col span="9">
							<fmt:formatDate value="<%= episode.getAirDate() %>" type="date" pattern="MMM dd, yyyy"/>
						</aui:col>
					</aui:row>
					
					<aui:row cssClass="seasonEpisodesTabRowText">
						<aui:col span="3">
							Episode:
						</aui:col>
						<aui:col span="9">
							<%= HtmlUtil.escape(String.valueOf(season.getSeasonNumber()))%>x<fmt:formatNumber value="<%=HtmlUtil.escape(String.valueOf(episode.getEpisodeNumber()))%>" type="number" minIntegerDigits="2"/>  
						</aui:col>
					</aui:row>
					
					<aui:row cssClass="seasonEpisodesTabRowDescription">
						<aui:col span="11" cssClass="seasonEpisodesTabRowDescriptionText">
							<%= HtmlUtil.escape(episode.getDescription()) %>
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