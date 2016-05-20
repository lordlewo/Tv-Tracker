<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/html/init.jsp" %>

<%!
	private static Log _log = LogFactoryUtil.getLog("tv tracker ajjaj");
%>

	<liferay-portlet:renderURL var="navigateToTestURL">
		<liferay-portlet:param name="mvcPath" value="/html/tvtracker/test.jsp"/>
	</liferay-portlet:renderURL>
	
	Go to <strong>test.jsp</strong>:
	<aui:button name="testButton" value="test.jsp" onClick="<%= navigateToTestURL %>"/>
	<br/><br/>
	

<% 

	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

	String orderByCol = ParamUtil.getString(request, "orderByCol", "title");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	
	OrderByComparator orderByComparator = ComparatorUtil.getTvShowOrderByComparator(orderByCol, orderByType);
	
	
	// search
	
	String keywords = ParamUtil.getString(renderRequest, "keywords");

	// language.properties messages 
	
	String emptyMsg = LanguageUtil.get(pageContext, "tvtracker.searchcontainer.emptyresultmessage");
	
	String coverMsg = LanguageUtil.get(pageContext, "tvtracker.searchcontainer.cover");
	String titleMsg = LanguageUtil.get(pageContext, "tvtracker.searchcontainer.title");
	String premierYearMsg = LanguageUtil.get(pageContext, "tvtracker.searchcontainer.premieryear");
	String seasonsMsg = LanguageUtil.get(pageContext, "tvtracker.searchcontainer.seasons");
	String detailsMsg = LanguageUtil.get(pageContext, "tvtracker.searchcontainer.details");
%>

<liferay-ui:search-container 
			delta="10" 
			emptyResultsMessage="<%= emptyMsg %>" 
			orderByCol="<%= orderByCol %>" 
			orderByType="<%= orderByType %>" 
			orderByComparator="<%= orderByComparator %>" >
			
	<liferay-ui:search-form page="/html/tvtracker/search_form.jsp" searchContainer="<%= searchContainer %>" servletContext="<%= application %>" showAddButton="true"/>

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
	
		<liferay-ui:search-container-row className="hu.webtown.liferay.tvtracker.model.TvShow" modelVar="tvShow" keyProperty="tvShowId" escapedModel="true">
			
			<%-- tvshow image --%>
			
			<liferay-ui:search-container-column-jsp path="/html/tvtracker/cover.jsp" name="<%= coverMsg %>"/>
			
			
			<%-- tvshow title --%>
			
			<liferay-ui:search-container-column-text property="title" orderable="true" orderableProperty="title" name="<%= titleMsg %>"/>
			
			
			<%-- tvshow premier year --%>
			
			<liferay-ui:search-container-column-text property="premierYear" orderable="true" orderableProperty="premierYear" name="<%= premierYearMsg %>"/>
			
			
			<%-- season count --%>
			
			<liferay-ui:search-container-column-text name="Seasons" > 
				<%
					long currentTvShowId = tvShow.getTvShowId();
					int seasonsCount = SeasonLocalServiceUtil.getSeasonsCount(currentTvShowId, serviceContext);
					
					out.print(HtmlUtil.escape(String.valueOf(seasonsCount)));
				%>
			</liferay-ui:search-container-column-text>
			
			
			<%-- navigation to the tvshow details page --%>
			
			<portlet:renderURL var="detailsURL">
				<portlet:param name="mvcPath" value="/html/tvtracker/detail/tvshow_detail.jsp"/>
				<portlet:param name="<%= WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShow.getTvShowId()) %>"/>
				<%-- (value = 0) -> tvshow.details tab selected | (value != 0) -> tvshow.seasons tab selected --%>
				<portlet:param name="selected_tab_tvshow" value="0" />
			</portlet:renderURL>
			
			<liferay-ui:search-container-column-text name="<%= detailsMsg %>">
				<div style="text-align: center;"><h1><aui:a href="<%= detailsURL %>" cssClass="icon-arrow-right" style="text-decoration: none;" /></h1></div>		
			</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>