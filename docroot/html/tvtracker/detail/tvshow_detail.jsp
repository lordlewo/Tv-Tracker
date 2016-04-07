<%@ include file="/html/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

	long tvShowId = ParamUtil.getLong(renderRequest, WebKeys.TVSHOW_ID);
	TvShow tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);
	
	
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
		seasonsCssClass = "active";
		detailsCssClass = StringPool.BLANK;
	}

%>

<aui:container>
	<aui:row>
		<aui:col span="6"> 
			<img src="<%= tvShow.getImageUrl() %>" style="border-radius: 25px; border:2px solid #ccc; padding:2px; background:#eee;" />
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
				<div style="border-radius: 0px 0px 25px 25px; border:2px solid #ccc; padding:10px 10px 20px 20px; background:#eee; margin: 10px 0px;">
					<aui:row>
						<h2> <u> <%= tvShow.getTitle() %> </u> &nbsp; (<%= tvShow.getPremierYear() %>) </h2>
					</aui:row>
					<aui:row style="padding-left: 10px">
						<aui:col span="3">
							<strong>Premier date:</strong>
						</aui:col>
						<aui:col span="9" style="padding-left: 5px">
							<fmt:formatDate value="<%= tvShow.getPremierDate() %>" type="date" pattern="MMM dd, yyyy"/>
						</aui:col>
					</aui:row>
					<aui:row style="padding-left: 10px">
						<aui:col span="3">
							<strong>Description:</strong>
						</aui:col>
						<aui:col span="6" style="padding-left: 5px">
							<%= tvShow.getDescription() %>
						</aui:col>
					</aui:row>
				</div>
			</c:if>
			
			<c:if test="<%= !tabVisibility %>">
				<div style="border-radius: 0px 0px 25px 25px; border:2px solid #ccc; padding:10px 10px 20px 20px; background:#eee; margin: 10px 0px;">
					
					<liferay-util:include page="/html/tvtracker/detail/tvshow_detail_season_item.jsp" servletContext="<%= application %>" >
						<liferay-util:param name="<%= renderResponse.getNamespace() + WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId) %>" />
					</liferay-util:include>
					
				</div>
			</c:if>

		</aui:col>
	</aui:row>
</aui:container>