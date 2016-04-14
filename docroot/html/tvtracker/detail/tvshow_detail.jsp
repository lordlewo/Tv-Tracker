<%@ include file="/html/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

	long tvShowId = ParamUtil.getLong(renderRequest, WebKeys.TVSHOW_ID);
	TvShow tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);

	
	// tab selection logic
	
	int selectedTab = ParamUtil.getInteger(renderRequest, "selected_tab", 0);
	
	boolean tabVisibility = true;
	String detailsCssClass = "active";
	String seasonsCssClass = StringPool.BLANK;
	
	if(selectedTab == 0){
		tabVisibility = true;
		detailsCssClass = "active";
		seasonsCssClass = StringPool.BLANK;
	} else {
		tabVisibility = false;
		detailsCssClass = StringPool.BLANK;
		seasonsCssClass = "active";
	}
	
	
	// asset categories
	
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(TvShow.class.getName(), tvShowId);
	List<AssetCategory> categories = assetEntry.getCategories();
	
	StringBuilder stringBuilder = new StringBuilder();
	
	if(categories != null && !categories.isEmpty()){
		stringBuilder.append(categories.get(0).getName());
		
		for(int i = 1; i < categories.size(); i++){
			
			stringBuilder.append(StringPool.COMMA_AND_SPACE);
			stringBuilder.append(categories.get(i).getName());
		}
	}
	
	if(stringBuilder.toString().isEmpty()){
		stringBuilder.append(StringPool.DASH);
	}
	
	
	//breadcrumb
	
	String currentURL = PortalUtil.getCurrentURL(request);
	PortalUtil.addPortletBreadcrumbEntry(request, tvShow.getTitle(), currentURL);
	PortalUtil.setPageSubtitle(tvShow.getTitle(), request);
    PortalUtil.setPageDescription(tvShow.getTitle(), request);

%>

<aui:container>

	<c:if test="<%= TvShowPermission.contains(permissionChecker, tvShowId, ActionKeys.VIEW) %>">
		
		<aui:row cssClass="tvShowHeaderRow" >
		
			<portlet:renderURL var="viewURL">
	        	<portlet:param name="mvcPath" value="/html/tvtracker/view.jsp"></portlet:param>
			</portlet:renderURL>
		
			<%-- 			<liferay-ui:header backURL="<%= viewURL %>" title="<%= tvShow.getTitle() %>"/> --%>
			<h1> 
				<a href="<%= viewURL %>" class="icon-arrow-left" style="text-decoration: none;" ></a> &nbsp;
				<%= tvShow.getTitle() %> &nbsp; 
				(<%= tvShow.getPremierYear() %>) 
			</h1>
		</aui:row>
		
		<aui:row>
			<aui:col span="<%= (selectedTab == 0 ? 6 : 4) %>">
				<aui:row >
					<img src="<%= tvShow.getImageUrl() %>" id="tvShowImage" />
				</aui:row>
			</aui:col>
			
			<aui:col span="<%= (selectedTab == 0 ? 6 : 8) %>">
			
			    <portlet:renderURL var="detailsTabURL">
			        <portlet:param name="mvcPath" value="/html/tvtracker/detail/tvshow_detail.jsp" />
			        <portlet:param name="<%= WebKeys.TVSHOW_ID %>" value="<%=String.valueOf(tvShowId)%>" />
			        <portlet:param name="selected_tab" value="0" />
			    </portlet:renderURL>
  			    <portlet:renderURL var="seasonsTabURL">
			        <portlet:param name="mvcPath" value="/html/tvtracker/detail/tvshow_detail.jsp" />
			        <portlet:param name="<%= WebKeys.TVSHOW_ID %>" value="<%=String.valueOf(tvShowId)%>" />
			        <portlet:param name="selected_tab" value="1" />
			    </portlet:renderURL>
			
				<aui:nav cssClass="nav-tabs">			
					<aui:nav-item cssClass="<%= detailsCssClass %>" label="Details" href="<%= detailsTabURL %>"/>			
					<aui:nav-item cssClass="<%= seasonsCssClass %>" label="Seasons" href="<%= seasonsTabURL %>" />
				</aui:nav>
				
				<c:if test="<%= tabVisibility %>">
					<div class="tvShowDetailsTab">
						<aui:row cssClass="tvShowDetailsTabRow">
							<aui:col span="3"/>
							<aui:col span="8" cssClass="tvShowDetailsRowTitle">
								<h3> <%= tvShow.getTitle() %> </h3>
							</aui:col>
							<aui:col span="1"/>
						</aui:row>
						
						<aui:row cssClass="tvShowDetailsTabRow">
							<aui:col span="3">
								<strong>Premier Date:</strong>
							</aui:col>
							<aui:col span="8" cssClass="tvShowDetailsRowText">
								<fmt:formatDate value="<%= tvShow.getPremierDate() %>" type="date" pattern="MMM dd, yyyy"/>
							</aui:col>
						</aui:row>
						
						<aui:row cssClass="tvShowDetailsTabRow">
							<aui:col span="3">
								<strong>Genres:</strong>
							</aui:col>
							<aui:col span="8" cssClass="tvShowDetailsRowText">
								<%= stringBuilder.toString() %>
							</aui:col>
						</aui:row>
						
						<aui:row cssClass="tvShowDetailsTabRow">
							<aui:col span="3">
								<strong>Number of Seasons:</strong>
							</aui:col>
							<aui:col span="8" cssClass="tvShowDetailsRowText">
								<%= tvShow.getSeasonCount() %>
							</aui:col>
						</aui:row>
						
						<aui:row cssClass="tvShowDetailsTabRow">
							<aui:col span="3">
								<strong>Description:</strong>
							</aui:col>
							<aui:col span="8" cssClass="tvShowDetailsRowText tvShowDeatilsRowTextDetails">
								<%= tvShow.getDescription() %>
							</aui:col>
						</aui:row>
					</div>
				</c:if>
				
				<c:if test="<%= !tabVisibility %>">
					<div class="tvShowSeasonsTab">
						
						<liferay-util:include page="/html/tvtracker/detail/tvshow_detail_seasons_tab.jsp" servletContext="<%= application %>" >
							<liferay-util:param name="<%= renderResponse.getNamespace() + WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId) %>" />
						</liferay-util:include>
						
					</div>
				</c:if>
	
			</aui:col>
		</aui:row>
	
	</c:if>
	
	<c:if test="<%= !TvShowPermission.contains(permissionChecker, tvShowId, ActionKeys.VIEW) %>">
		You must have the appropriate permission for view the tv show!
	</c:if>
	
</aui:container>