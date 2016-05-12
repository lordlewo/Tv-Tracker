<%@ include file="/html/init.jsp"  %>

<liferay-ui:success key="add-tvshow-successful" 			 	message="TvShow creating was successful!"/>
<liferay-ui:success key="add-tvshow-with-season-successful"  	message="TvShow creating with season was successful!"/>
<liferay-ui:success key="add-tvshow-with-seasons-successful" 	message="TvShow creating with seasons was successful!"/>
<liferay-ui:error   key="add-tvshow-unsuccessful" 			 	message="TvShow creating was unsuccessful!"/>
<liferay-ui:error   key="add-tvshow-with-season-unsuccessful"  	message="TvShow creating with season was unsuccessful!"/>
<liferay-ui:error   key="add-tvshow-with-seasons-unsuccessful" 	message="TvShow creating with seasons was unsuccessful!"/>

<liferay-ui:success key="update-tvshow-successful" 			 	  message="TvShow editing was successful!"/>
<liferay-ui:success key="update-tvshow-with-season-successful"    message="TvShow editing with season was successful!"/>
<liferay-ui:success key="update-tvshow-with-seasons-successful"   message="TvShow editing with seasons was successful!"/>
<liferay-ui:error   key="update-tvshow-unsuccessful" 			  message="TvShow editing was unsuccessful!"/>
<liferay-ui:error   key="update-tvshow-with-season-unsuccessful"  message="TvShow editing with season was unsuccessful!"/>
<liferay-ui:error   key="update-tvshow-with-seasons-unsuccessful" message="TvShow editing with seasons was unsuccessful!"/>

<liferay-ui:success key="create-season-successful" 			    message="Season creating was successful!"/>
<liferay-ui:success key="create-seasons-successful" 			message="Seasons creating was successful!"/>
<liferay-ui:success key="delete-season-successful" 			    message="Season removing was successful!"/>
<liferay-ui:success key="delete-seasons-successful" 			message="Seasons removing was successful!"/>

<liferay-ui:success key="delete-tvshow-successful" 			      message="TvShow removing was successful!"/>
<liferay-ui:success key="delete-tvshow-with-season-successful"    message="TvShow removing with season was successful!"/>
<liferay-ui:success key="delete-tvshow-with-seasons-successful"   message="TvShow removing with seasons was successful!"/>
<liferay-ui:error   key="delete-tvshow-unsuccessful" 			  message="TvShow removing was unsuccessful!"/>
<liferay-ui:error   key="delete-tvshow-with-season-unsuccessful"  message="TvShow removing with season was unsuccessful!"/>
<liferay-ui:error   key="delete-tvshow-with-seasons-unsuccessful" message="TvShow removing with seasons was unsuccessful!"/>

<%!
	private static Log _log = LogFactoryUtil.getLog("tv show admin ajjaj");
%>

<%

	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	long groupId = serviceContext.getScopeGroupId();
	

	// initialize the service container	
	
	String orderByCol = ParamUtil.getString(request, "orderByCol", "title");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	
	OrderByComparator orderByComparator = ComparatorUtil.getTvShowOrderByComparator(orderByCol, orderByType);

	// search 
	
	String keywords = ParamUtil.getString(renderRequest, "keywords");
	
%>

<aui:container cssClass="tvShowAdmin">
		
	<aui:row>
		<aui:col span="12">
			<liferay-ui:search-container 
				delta="10" 
				emptyResultsMessage="There aren't any TvShow!" 
				orderByCol="<%= orderByCol %>" 
				orderByType="<%= orderByType %>" 
				orderByComparator="<%= orderByComparator %>" > 
	 
				<liferay-ui:search-form page="/html/tvshowadmin/search_form.jsp" searchContainer="<%= searchContainer %>" servletContext="<%= application %>" />
		
				<liferay-ui:search-container-results>
					<%
						if(keywords == null || keywords.isEmpty()){
							
							List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(serviceContext, searchContainer.getOrderByComparator());
							
							// permisssion checking 
							
							for(TvShow tvShow : tvShows){
								
								long tvShowId = tvShow.getTvShowId();
								
								if(TvShowPermission.contains(permissionChecker, tvShowId, ActionKeys.VIEW)){
									
									((List<TvShow>) results).add(tvShow);
									
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
			
					        List<TvShow> tvShows = new ArrayList<TvShow>();
					        
					        for (int i = 0; i < hits.getDocs().length; i++) {
				                Document doc = hits.doc(i);
			
				                long tvShowId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			
				                TvShow tvShow = null;
			
				                try {
				                	tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId);
				                } catch (PortalException pe) {
				                        _log.error(pe.getLocalizedMessage());
				                } catch (SystemException se) {
				                        _log.error(se.getLocalizedMessage());
				                }
			
				                tvShows.add(tvShow);
				        	}
							
					        pageContext.setAttribute("results", tvShows);
							searchContainer.setTotal(tvShows.size());
					        
						}
					%>
				</liferay-ui:search-container-results>
			
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

