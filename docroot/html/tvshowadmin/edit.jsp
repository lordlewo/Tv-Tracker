<%@page import="hu.webtown.liferay.tvtracker.NoSuchTvShowException"%>
<%@ include file="/html/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

	long tvShowId = ParamUtil.getLong(renderRequest, WebKeys.TVSHOW_ID);
	String method = ParamUtil.getString(renderRequest, "method");
	
	TvShow tvShow = null;
	
	if(method.equalsIgnoreCase("add")){
		
		tvShow = null;
		
	} else if (method.equalsIgnoreCase("edit")) {
		
		tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);
		
	}
	
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/tvshowadmin/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="editURL">
	<portlet:param name="method" value="<%= method %>"/>
</portlet:actionURL>

<aui:form name="editform" action="<%= viewURL %>" method="POST">
	<aui:container>
		<aui:row>
			<aui:col>
			
			</aui:col>	
		</aui:row>
	</aui:container>
</aui:form>