<%@ include file="/html/init.jsp"  %>

<liferay-ui:success key="add-episode-successful" message="Episode creating was successful!"/>

<liferay-ui:success key="update-episode-successful" message="Episode editing was successful!"/>

<liferay-ui:success key="delete-episode-successful" message="Episode removing was successful!"/>

<liferay-ui:error key="delete-episode-unsuccessful" message="Episode removing was unsuccessful!"/>

<%!
	private static Log _log = LogFactoryUtil.getLog("episode admin ajjaj");
%>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	long groupId = serviceContext.getScopeGroupId();
	

	// initialize the service container	
	
	String orderByCol = ParamUtil.getString(request, "orderByCol", "title");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	
	OrderByComparator orderByComparator = ComparatorUtil.getEpisodeOrderByComparator(orderByCol, orderByType);
	
	// search
	
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
				orderByComparator="<%= orderByComparator %>" > 
	 			
				<liferay-ui:search-form 
							page="/html/episodeadmin/search_form.jsp" 
							searchContainer="<%= searchContainer %>" 
							servletContext="<%= application %>" />
		
				<liferay-ui:search-container-results>
					<%
						if(keywords == null || keywords.isEmpty()){
							
							List<Episode> episodes = EpisodeLocalServiceUtil.getEpisodes(serviceContext, searchContainer.getOrderByComparator());
							
							// permisssion checking 
							
							for(Episode episode : episodes){
								
								long episodeId = episode.getEpisodeId();
								
								if(EpisodePermission.contains(permissionChecker, episodeId, ActionKeys.VIEW)){
									
									((List<Episode>) results).add(episode);
									
								}
							}
						
							pageContext.setAttribute("results", ListUtil.subList(results, searchContainer.getStart(), searchContainer.getEnd()));
							searchContainer.setTotal(results.size());
							
						} else {
							
							SearchContext searchContext = SearchContextFactory.getInstance(request);
							searchContext.setKeywords(keywords);
					        searchContext.setAttribute("paginationType", "more");
					        searchContext.setStart(searchContainer.getStart());
					        searchContext.setEnd(searchContainer.getEnd());
							
					        Indexer indexer = IndexerRegistryUtil.getIndexer(TvShow.class);
					        
					        Hits hits = indexer.search(searchContext); 
			
					        List<Episode> episodes = new ArrayList<Episode>();
					        
					        for (int i = 0; i < hits.getDocs().length; i++) {
				                Document doc = hits.doc(i);
			
				                long episodeId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			
				                Episode episode = null;
			
				                try {
				                	episode = EpisodeLocalServiceUtil.getEpisode(episodeId);
				                } catch (PortalException pe) {
				                        _log.error(pe.getLocalizedMessage());
				                } catch (SystemException se) {
				                        _log.error(se.getLocalizedMessage());
				                }
			
				                episodes.add(episode);
				        	}
							
					        pageContext.setAttribute("results", episodes);
							searchContainer.setTotal(episodes.size());
					        
						}
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
