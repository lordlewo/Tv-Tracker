<%@ include file="/html/init.jsp" %>

This is the <b>Tv Tracker</b> portlet in View mode.

<portlet:renderURL var="navigateToTestURL">
	<portlet:param name="mvcPath" value="/html/tvtracker/test.jsp"/>
</portlet:renderURL>

<br/>
Go to <strong>test.jsp</strong>:
<aui:button name="testButton" value="test.jsp" onClick="<%= navigateToTestURL %>"/>

