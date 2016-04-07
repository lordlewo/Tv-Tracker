<%@ include file="/html/init.jsp" %>

<% 
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

	long tvShowId = ParamUtil.getLong(request, renderResponse.getNamespace() + WebKeys.TVSHOW_ID);
	List<Season> seasons = SeasonLocalServiceUtil.getSeasons(tvShowId, serviceContext);
	
%>


<aui:container>
	
	<aui:row>
		<aui:col span="3">
			<h5 style="text-align: center;">Cover</h5>
		</aui:col>
		<aui:col span="3">
			<h5 style="text-align: center;">Season Title</h5>
		</aui:col>
		<aui:col span="3">
			<h5 style="text-align: center;">Episodes Number</h5>
		</aui:col>
	</aui:row>

	<% 
		for(Season season: seasons){
	%>
	<aui:row>
		<aui:col span="3">
			<div style="padding: 10px;">
				<img src="<%= season.getImageUrl() %>" style="width: 50;" />
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
	</aui:row>
	<% 
		}
	%>
</aui:container>