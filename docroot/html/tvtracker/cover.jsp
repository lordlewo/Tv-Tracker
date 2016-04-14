<%@page import="com.liferay.portal.model.BaseModel"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/init.jsp" %>

<%
	ResultRow resultRow = (ResultRow) renderRequest.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	TvShow tvShow = (TvShow) resultRow.getObject();
	
%>

<aui:container>
	<aui:row align="center">
		<img src="<%= tvShow.getImageUrl() %>" width="300"/>
	</aui:row>
</aui:container>