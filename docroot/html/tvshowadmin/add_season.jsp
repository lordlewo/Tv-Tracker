<%@ include file="/html/init.jsp"  %>

<%
	String tv = ParamUtil.getString(request, WebKeys.TVSHOW_ID);
%>
<aui:col span="3">
	<aui:row>
		<%
			String blankImageUrl = renderResponse.encodeURL(renderRequest.getContextPath() + "/img/no-image.png");
		%>
		<img id="<portlet:namespace/>img" src="<%= blankImageUrl %>" height="100" style="max-height: 100px;">
	</aui:row>
	
	<aui:row>
		<aui:input name="imageTitle" type="text" readOnly="true" label="Image" title="Image"> 
			<aui:validator name="required" errorMessage="Please select the tv show's cover." />
		</aui:input>
		<aui:button cssClass="seasonCover" name="selectSeasonImageButton" value="Select" icon=" icon-folder-open"/>
	</aui:row>
</aui:col>
	
<aui:col span="3">
	<aui:row>
		<div id="counterContainer">
			<aui:input name="seasonTitle" type="text" title="Season Title" label="Season Title">
				<aui:validator name="required" errorMessage="Please enter the season's name."/>
				<p><span id="titlecCounter"></span> character(s) remaining</p>
			</aui:input>
		</div>
	</aui:row>

	<aui:row>
		<aui:input name="premierDate" title="Season Premier Date" label="Season Premier Date" model="<%= Season.class %>">
			<aui:validator name="required" errorMessage="Please enter the season's premier date."/>
			<aui:validator name="date" errorMessage="Please enter the tv show's premier date in correct form (dd/mm/yy)."/>
		</aui:input>
	</aui:row>
</aui:col>
	
<aui:col span="4">
	<aui:row>
		<div id="counterContainer">
			<aui:input name="seasonDescription" title="Seson Description" label="Season Description" type="textarea" style="width: 350px; height: 150px;">
				<aui:validator name="required" errorMessage="Please enter the season's description." />
				<p><span id="descriptioncCounter"></span> character(s) remaining</p>
			</aui:input>
		</div>
	</aui:row>
</aui:col>

<aui:script use="aui-base,aui-char-counter">
	
	/*********************** validation char counter ****************************/
	
	function createCharCounterr(cc_counter, cc_input, cc_maxlength){
		
		var ccConfig = {
			counter: cc_counter,
			input: cc_input,
			maxLength: cc_maxlength
		};
		
		return new A.CharCounter(ccConfig);
	}
	
	/******************** modify input tags' 'name' attribute*********************/
	
	var id = getIdx();
	
	
	// new attr values
	var newSeasonTitleId = '<portlet:namespace />seasonTitle' + id;
	var newSeasonDescriptionId = '<portlet:namespace />seasonDescription' + id;
	
	
	var newSeasonTitleCounterId = '<portlet:namespace />titlecCounter' + id;
	var newSeasonDescriptioncounterId = '<portlet:namespace />descriptioncCounter' + id;
	
	
	
	// refactoring the attrs of inputs
	A.one('#<portlet:namespace />seasonTitle').attr('name', newSeasonTitleId);
	A.one('#<portlet:namespace />seasonDescription').attr('name', newSeasonDescriptionId);
	
	A.one('#<portlet:namespace />seasonTitle').attr('id', newSeasonTitleId);
	A.one('#<portlet:namespace />seasonDescription').attr('id', newSeasonDescriptionId);
	
	
	
	// refactoring the attrs of remaining's <span> 
	A.one('#titlecCounter').attr('id', newSeasonTitleCounterId);
	A.one('#descriptioncCounter').attr('id', newSeasonDescriptioncounterId);
	
	
	
	// attach cc to the counter <span>-s
	createCharCounterr('#' + newSeasonTitleCounterId, '#' + newSeasonTitleId, 75);
	createCharCounterr('#' + newSeasonDescriptioncounterId, '#' + newSeasonDescriptionId, 500);
	
</aui:script>