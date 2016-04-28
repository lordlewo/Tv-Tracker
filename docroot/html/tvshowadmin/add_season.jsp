<%@ include file="/html/init.jsp"  %>

<%
	String tv = ParamUtil.getString(request, WebKeys.TVSHOW_ID);
%>

<aui:row style="padding-top: 20px;">

	<aui:col span="3">
		<aui:row>
			<%
				String blankImageUrl = renderResponse.encodeURL(renderRequest.getContextPath() + "/img/no-image.png");
			%>
			<img id="<portlet:namespace/>img" src="<%= blankImageUrl %>" />
		</aui:row>
		
		<aui:row>
			<aui:input name="seasonImageTitle" type="text" readOnly="true" label="Image" title="Image"> 
				<aui:validator name="required" errorMessage="Please select the tv show's cover." />
			</aui:input>
			<aui:button cssClass="seasonCover" name="selectSeasonImageButton" value="Select" icon=" icon-folder-open"/>
		</aui:row>
		
		<%-- hidden inputs --%>
		<aui:input name="seasonImageUrl" type="hidden"></aui:input>
		<aui:input name="seasonImageUuid" type="hidden"></aui:input>
		<aui:input name="seasonImageVersion" type="hidden"></aui:input>
		
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
		
		<aui:input name="seasonNumber" title="Season Number" label="Season Number" model="<%= Season.class %>">
			<aui:validator name="required" errorMessage="Please enter the season's number." />
			<aui:validator name="number" errorMessage="Please enter valid season number."/>
			<aui:validator name="min" errorMessage="Please enter a positive number." >
				'1'
			</aui:validator>
		</aui:input>
	
		<aui:row>
			<aui:input cssClass="seasonPremierDateWrapper" name="premierDate" title="Season Premier Date" label="Season Premier Date" model="<%= Season.class %>">
				<aui:validator name="required" errorMessage="Please enter the season's premier date."/>
				<aui:validator name="date" errorMessage="Please enter the season's premier date in correct form (dd/mm/yy)."/>
			</aui:input>
		</aui:row>
		
		<%-- hidden inputs --%>
		<aui:input name="seasonPremierDateDay" type="hidden" cssClass=""/>
		<aui:input name="seasonPremierDateMonth" type="hidden" cssClass=""/>
		<aui:input name="seasonPremierDateYear" type="hidden" cssClass=""/>
		
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
</aui:row>

<aui:script use="aui-base,aui-char-counter,aui-node">
	
	/*********************** validation char counter ****************************/
	
	function createCharCounterr(cc_counter, cc_input, cc_maxlength){
		
		var ccConfig = {
			counter: cc_counter,
			input: cc_input,
			maxLength: cc_maxlength
		};
		
		return new A.CharCounter(ccConfig);
	}
	
	/*-************************** modify input tags *****************************-*/
		
	var id = idx.get(); // get current id
	
	/**************************** season image ************************************/
	
	// new attr values
	var newSeasonImageTitle = '<portlet:namespace />seasonImageTitle' + id;
	var newSeasonImageUrl = '<portlet:namespace />seasonImageUrl' + id;
	var newSeasonImageUuid = '<portlet:namespace />seasonImageUuid' + id;
	var newSeasonImageVersion = '<portlet:namespace />seasonImageVersion' + id;
	
	// refactoring the attrs of inputs
	A.one('#<portlet:namespace />seasonImageTitle').attr('name', newSeasonImageTitle);
	A.one('#<portlet:namespace />seasonImageTitle').attr('id', newSeasonImageTitle);
	
	A.one('#<portlet:namespace />seasonImageUrl').attr('name', newSeasonImageUrl);
	A.one('#<portlet:namespace />seasonImageUrl').attr('id', newSeasonImageUrl);
	
	A.one('#<portlet:namespace />seasonImageUuid').attr('name', newSeasonImageUuid);
	A.one('#<portlet:namespace />seasonImageUuid').attr('id', newSeasonImageUuid);
	
	A.one('#<portlet:namespace />seasonImageVersion').attr('name', newSeasonImageVersion);
	A.one('#<portlet:namespace />seasonImageVersion').attr('id', newSeasonImageVersion);
	
	
	/**************************** season title ************************************/
	
	// new attr values
	var newSeasonTitle = '<portlet:namespace />seasonTitle' + id;
	
	// refactoring the attrs of inputs
	A.one('#<portlet:namespace />seasonTitle').attr('name', newSeasonTitle);
	A.one('#<portlet:namespace />seasonTitle').attr('id', newSeasonTitle);
	
	
	/**************************** season number **********************************/
	
	// new attr values
	var newSeasonNumber = '<portlet:namespace />seasonNumber' + id;
	
	// refactoring the attrs of inputs
	A.one('#<portlet:namespace />seasonNumber').attr('name', newSeasonNumber);
	A.one('#<portlet:namespace />seasonNumber').attr('id', newSeasonNumber);
	
	
	/**************************** season description ******************************/
	
	// new attr values
	var newSeasonDescription = '<portlet:namespace />seasonDescription' + id;
	
	// refactoring the attrs of inputs
	A.one('#<portlet:namespace />seasonDescription').attr('name', newSeasonDescription);
	A.one('#<portlet:namespace />seasonDescription').attr('id', newSeasonDescription);
	
	
	/* --------------------------- char counters ------------------------------- */
	
							// title char counter //
							
	var newSeasonTitleCounter = '<portlet:namespace />titlecCounter' + id;
	
	// refactoring the attrs of remaining's <span> 
	A.one('#titlecCounter').attr('id', newSeasonTitleCounter);
	
	// attach cc to the counter <span>-s
	createCharCounterr('#' + newSeasonTitleCounter, '#' + newSeasonTitle, 75);
	
	
							// description char counter //
							
	var newSeasonDescriptioncounter = '<portlet:namespace />descriptioncCounter' + id;
	
	// refactoring the attrs of remaining's <span> 
	A.one('#descriptioncCounter').attr('id', newSeasonDescriptioncounter);
	
	// attach cc to the counter <span>-s
	createCharCounterr('#' + newSeasonDescriptioncounter, '#' + newSeasonDescription, 500);
	
	
	/**************************** season date ************************************/
	
	// season premier date hidden inputs refactor
	var newPremierDateDay = '<portlet:namespace />seasonPremierDateDay' + id;
	var newPremierDateMonth = '<portlet:namespace />seasonPremierDateMonth' + id;
	var newPremierDateYear = '<portlet:namespace />seasonPremierDateYear' + id;
	
	A.one('#<portlet:namespace />seasonPremierDateDay').attr('name', newPremierDateDay);
	A.one('#<portlet:namespace />seasonPremierDateDay').attr('id', newPremierDateDay);
	
	A.one('#<portlet:namespace />seasonPremierDateMonth').attr('name', newPremierDateMonth);
	A.one('#<portlet:namespace />seasonPremierDateMonth').attr('id', newPremierDateMonth);
	
	A.one('#<portlet:namespace />seasonPremierDateYear').attr('name', newPremierDateYear);
	A.one('#<portlet:namespace />seasonPremierDateYear').attr('id', newPremierDateYear);


	// wrapper class refactor
	var wrapperSelector = 'wrapperSelector';
	var newSeasonPremierDateWrapper = 'seasonPremierDateWrapper' + id;
	
	A.one('.seasonPremierDateWrapper').addClass(wrapperSelector);
	A.one('.seasonPremierDateWrapper').replaceClass('seasonPremierDateWrapper', newSeasonPremierDateWrapper);
	
	/*-************************** modify input tags *****************************-*/
	
	idx.inc(); // increment current id
	
</aui:script>