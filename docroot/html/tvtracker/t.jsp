<%@ include file="/html/init.jsp" %>
<div>
	<aui:input name="firstName" label="First Name" />
	
	<aui:input name="lastName" label="Last Name" />
	
	<aui:select name="gender" label="Gender">
		<aui:option value="male" label="Male"></aui:option>
		<aui:option value="female" label="Female"></aui:option>
	</aui:select>
</div>

<aui:script use="aui-base">
	
	A.all('input').each(function(currentNode, index, nodeList) {
		currentNode.focus();
	});

</aui:script>