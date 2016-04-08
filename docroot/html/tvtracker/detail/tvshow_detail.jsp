<%@ include file="/html/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

	long tvShowId = ParamUtil.getLong(renderRequest, WebKeys.TVSHOW_ID);
	TvShow tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);

	
	// tab selection logic
	
	int selectedTab = ParamUtil.getInteger(renderRequest, "selected_tab");
	
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
		
		<aui:row style="margin-bottom: 20px; border-bottom: 2px solid #ccc;">
		
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
			<aui:col span="6">
				<aui:row >
					<img src="<%= tvShow.getImageUrl() %>" style="border-radius: 25px; border:2px solid #ccc; padding:2px; background:#eee;" />
				</aui:row>
			</aui:col>
			
			<aui:col span="6">
			
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
					<div style="border-radius: 0px 0px 25px 25px; border:2px solid #ccc; padding: 20px; background:#eee; margin: 10px 0px;">
						<aui:row style="padding-left: 10px; padding-top: 10px;">
							<aui:col span="3"/>
							<aui:col span="8" style="margin-bottom: 10px; border-bottom: 2px solid #ccc;">
								<h3> <%= tvShow.getTitle() %> </h3>
							</aui:col>
							<aui:col span="1"/>
						</aui:row>
						
						<aui:row style="padding-left: 10px; padding-top: 10px;">
							<aui:col span="3">
								<strong>Premier Date:</strong>
							</aui:col>
							<aui:col span="9" style="padding-left: 5px">
								<fmt:formatDate value="<%= tvShow.getPremierDate() %>" type="date" pattern="MMM dd, yyyy"/>
							</aui:col>
						</aui:row>
						
						<aui:row style="padding-left: 10px; padding-top: 10px;">
							<aui:col span="3">
								<strong>Genres:</strong>
							</aui:col>
							<aui:col span="6" style="padding-left: 5px">
								<%= stringBuilder.toString() %>
							</aui:col>
						</aui:row>
						
						<aui:row style="padding-left: 10px; padding-top: 10px;">
							<aui:col span="3">
								<strong>Number of Seasons:</strong>
							</aui:col>
							<aui:col span="9" style="padding-left: 5px">
								<%= tvShow.getSeasonCount() %>
							</aui:col>
						</aui:row>
						
						<aui:row style="padding-left: 10px; padding-top: 10px;">
							<aui:col span="3">
								<strong>Description:</strong>
							</aui:col>
							<aui:col span="8" style="padding-left: 5px; padding-right: 10px; text-align: justify;">
								<%= tvShow.getDescription() %>
							</aui:col>
						</aui:row>
					</div>
				</c:if>
				
				<c:if test="<%= !tabVisibility %>">
					<div style="border-radius: 0px 0px 25px 25px; border:2px solid #ccc; padding:10px 10px 20px 20px; background:#eee; margin: 10px 0px;">
						
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