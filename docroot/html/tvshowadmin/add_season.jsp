<%@ include file="/html/init.jsp"  %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

	long tvShowId = ParamUtil.getLong(request, WebKeys.TVSHOW_ID, 0);
	long seasonId = ParamUtil.getLong(request, WebKeys.SEASON_ID, 0);
	String action = ParamUtil.getString(request, "action");
	
	TvShow tvShow = null;
	Season season = null;
	
	if (action.equalsIgnoreCase("update")) {
		
		if (tvShowId > 0) {
			tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);
		}
		
		if (seasonId > 0) {
			season = SeasonLocalServiceUtil.getSeason(seasonId, serviceContext);
		}
		
	} else {
		tvShow = null;
		season = null;
	}
%>

<aui:row style="padding-top: 20px;">

	<aui:model-context model="<%= Season.class %>" bean="<%= season %>" />
	
	<aui:input name="seasonId" type="hidden" cssClass=""/>

	<aui:col span="3">
		<aui:row>
			<%
				String blankImageUrl = renderResponse.encodeURL(renderRequest.getContextPath() + "/img/no-image.png");
			%>
			<img id="<portlet:namespace/>img" src="<%= blankImageUrl %>" />
		</aui:row>
		
		<aui:row>
			<aui:input name="imageTitle" type="text" readOnly="true" label="Image" title="Image" > 
				<aui:validator name="required" errorMessage="Please select the tv show's cover." />
			</aui:input>
			<aui:button cssClass="seasonCover" name="selectSeasonImageButton" value="Select" icon=" icon-folder-open"/>
		</aui:row>
		
		<%-- hidden inputs --%>
		<aui:input name="imageUrl" type="hidden"></aui:input>
		<aui:input name="imageUuid" type="hidden"></aui:input>
		<aui:input name="imageVersion" type="hidden"></aui:input>
		
	</aui:col>
		
	<aui:col span="3">
		<aui:row>
			<div id="counterContainer">
				<aui:input name="title" type="text" title="Season Title" label="Season Title">
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
		
		<div id="hiddenDateFieldsWrapper">
			<%-- hidden inputs --%>
			<aui:input name="premierDateDay" type="hidden" cssClass=""/>
			<aui:input name="premierDateMonth" type="hidden" cssClass=""/>
			<aui:input name="premierDateYear" type="hidden" cssClass=""/>
		</div>
		
	</aui:col>
		
	<aui:col span="4">
		<aui:row>
			<div id="counterContainer">
				<aui:input name="description" title="Seson Description" label="Season Description" type="textarea" style="width: 350px; height: 150px;">
					<aui:validator name="required" errorMessage="Please enter the season's description." />
					<p><span id="descriptioncCounter"></span> character(s) remaining</p>
				</aui:input>
			</div>
		</aui:row>
	</aui:col>
</aui:row>

<aui:script use="aui-base,aui-char-counter,aui-node">
	
	var index = idx.get(); // get current id
	
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
	
	function modifyTagAttr(id, attr, newAttrValue, index, containerId){
		
		// init some var
		
		var namespace = '<portlet:namespace />';
		
		var _tagSelectorById = '#' + namespace + id;
		
		var _newAttrValue = namespace + newAttrValue + index;
		
		var _containerId = containerId || 'season-fields';
		
		var _containerSelectorById = '#' + _containerId;
		
		
		// modifying
		
		A.one(_containerSelectorById).one(_tagSelectorById).attr(attr, _newAttrValue);
	}
	
	/**************************** season id ***************************************/
	
	modifyTagAttr('seasonId', 'name', 'seasonId', index);
	modifyTagAttr('seasonId', 'id', 'seasonId', index);
	
	/**************************** season image ************************************/
	
	// new attr values
	var newSeasonImageTitle = '<portlet:namespace />seasonImageTitle' + index;
	var newSeasonImageUrl = '<portlet:namespace />seasonImageUrl' + index;
	var newSeasonImageUuid = '<portlet:namespace />seasonImageUuid' + index;
	var newSeasonImageVersion = '<portlet:namespace />seasonImageVersion' + index;
	
	// refactoring the attrs of inputs
	A.one('#season-fields').one('#<portlet:namespace />imageTitle').attr('name', newSeasonImageTitle);
	A.one('#season-fields').one('#<portlet:namespace />imageTitle').attr('id', newSeasonImageTitle);
	
	A.one('#season-fields').one('#<portlet:namespace />imageUrl').attr('name', newSeasonImageUrl);
	A.one('#season-fields').one('#<portlet:namespace />imageUrl').attr('id', newSeasonImageUrl);
	
	A.one('#season-fields').one('#<portlet:namespace />imageUuid').attr('name', newSeasonImageUuid);
	A.one('#season-fields').one('#<portlet:namespace />imageUuid').attr('id', newSeasonImageUuid);
	
	A.one('#season-fields').one('#<portlet:namespace />imageVersion').attr('name', newSeasonImageVersion);
	A.one('#season-fields').one('#<portlet:namespace />imageVersion').attr('id', newSeasonImageVersion);
	
	
	/**************************** season title ************************************/
	
	// new attr value
	var newSeasonTitle = '<portlet:namespace />seasonTitle' + index;
	
	// refactoring the attrs of input
	A.one('#season-fields').one('#<portlet:namespace />title').attr('name', newSeasonTitle);
	A.one('#season-fields').one('#<portlet:namespace />title').attr('id', newSeasonTitle);
	
	
	/**************************** season number **********************************/
	
	// new attr value
	var newSeasonNumber = '<portlet:namespace />seasonNumber' + index;
	
	// refactoring the attrs of input
	A.one('#season-fields').one('#<portlet:namespace />seasonNumber').attr('name', newSeasonNumber);
	A.one('#season-fields').one('#<portlet:namespace />seasonNumber').attr('id', newSeasonNumber);
	
	
	/**************************** season description ******************************/
	
	// new attr value
	var newSeasonDescription = '<portlet:namespace />seasonDescription' + index;
	
	// refactoring the attrs of input
	A.one('#season-fields').one('#<portlet:namespace />description').attr('name', newSeasonDescription);
	A.one('#season-fields').one('#<portlet:namespace />description').attr('id', newSeasonDescription);
	
	
	/* --------------------------- char counters ------------------------------- */
	
							// title char counter //
							
	var newSeasonTitleCounter = '<portlet:namespace />titlecCounter' + index;
	
	// refactoring the attrs of remaining's <span> 
	A.one('#season-fields').one('#titlecCounter').attr('id', newSeasonTitleCounter);
	
	// attach cc to the counter <span>-s
	createCharCounterr('#' + newSeasonTitleCounter, '#' + newSeasonTitle, 75);
	
	
							// description char counter //
							
	var newSeasonDescriptioncounter = '<portlet:namespace />descriptioncCounter' + index;
	
	// refactoring the attrs of remaining's <span> 
	A.one('#season-fields').one('#descriptioncCounter').attr('id', newSeasonDescriptioncounter);
	
	// attach cc to the counter <span>-s
	createCharCounterr('#' + newSeasonDescriptioncounter, '#' + newSeasonDescription, 500);
	
	
	/**************************** season date ************************************/
	
	//date fields wrapper
	
	var newHiddenDateFieldsWrapper = 'hiddenDateFieldsWrapper' + index;
	var dateFieldsWrapper = A.one('#hiddenDateFieldsWrapper');
	dateFieldsWrapper.attr('id', newHiddenDateFieldsWrapper);
	
	// season premier date hidden inputs refactor
	var newPremierDateDay = '<portlet:namespace />seasonPremierDateDay' + index;
	var newPremierDateMonth = '<portlet:namespace />seasonPremierDateMonth' + index;
	var newPremierDateYear = '<portlet:namespace />seasonPremierDateYear' + index;
	
	dateFieldsWrapper.one('#<portlet:namespace />premierDateDay').attr('name', newPremierDateDay);
	dateFieldsWrapper.one('#<portlet:namespace />premierDateDay').attr('id', newPremierDateDay);
	
	dateFieldsWrapper.one('#<portlet:namespace />premierDateMonth').attr('name', newPremierDateMonth);
	dateFieldsWrapper.one('#<portlet:namespace />premierDateMonth').attr('id', newPremierDateMonth);
	
	dateFieldsWrapper.one('#<portlet:namespace />premierDateYear').attr('name', newPremierDateYear);
	dateFieldsWrapper.one('#<portlet:namespace />premierDateYear').attr('id', newPremierDateYear);

	
	// wrapper class refactor
	var wrapperSelector = 'wrapperSelector';
	var newSeasonPremierDateWrapper = 'seasonPremierDateWrapper' + index;
	
	A.one('#season-fields').one('.seasonPremierDateWrapper').addClass(wrapperSelector);
	A.one('#season-fields').one('.seasonPremierDateWrapper').replaceClass('seasonPremierDateWrapper', newSeasonPremierDateWrapper);
	
	/*-************************** modify input tags *****************************-*/
	
	idx.inc(); // increment current id
	
</aui:script>