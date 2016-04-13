<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="searchURL">
	<liferay-portlet:param name="mvcPath" value="/html/tvtracker/view.jsp"/>
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="form">
	
	<liferay-portlet:renderURLParams varImpl="searchURL"/>
	
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input name="keywords" type="text" title="Search TvShows" inlineField="true" label="Searching TvShows: " inlineLabel="left" />
		
			<aui:button type="submit" value="search" />
		</span>
	</div>

</aui:form>