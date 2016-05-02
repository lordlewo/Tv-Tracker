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
			
			<%-- hidden inputs --%>
			<aui:input name="imageUrl" type="hidden" cssClass=""></aui:input>
			<aui:input name="imageUuid" type="hidden" cssClass=""></aui:input>
			<aui:input name="imageVersion" type="hidden" cssClass=""></aui:input>
		</aui:row>	
	</aui:col>
		
	<aui:col span="3">
		<aui:row>
			<div id="counterContainer">
				<aui:input name="title" type="text" title="Season Title" label="Season Title">
					<aui:validator name="required" errorMessage="Please enter the season's name."/>
					<p><span id="<portlet:namespace/>titleCounter"></span> character(s) remaining</p>
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
			<div id="<portlet:namespace/>seasonPremierDateWrapper">
				<aui:input name="premierDate" title="Season Premier Date" label="Season Premier Date" model="<%= Season.class %>">
					<aui:validator name="required" errorMessage="Please enter the season's premier date."/>
					<aui:validator name="date" errorMessage="Please enter the season's premier date in correct form (dd/mm/yy)."/>
				</aui:input>
				
				<div id="<portlet:namespace/>hiddenSeasonPremierDateFieldsWrapper">
					<%-- hidden inputs --%>
					<aui:input name="premierDateDay" type="hidden" cssClass=""/>
					<aui:input name="premierDateMonth" type="hidden" cssClass=""/>
					<aui:input name="premierDateYear" type="hidden" cssClass=""/>
				</div>
			</div>
		</aui:row>
	</aui:col>
		
	<aui:col span="4">
		<aui:row>
			<div id="counterContainer">
				<aui:input name="description" title="Seson Description" label="Season Description" type="textarea" style="width: 350px; height: 150px;">
					<aui:validator name="required" errorMessage="Please enter the season's description." />
					<p><span id="<portlet:namespace/>descriptionCounter"></span> character(s) remaining</p>
				</aui:input>
			</div>
		</aui:row>
	</aui:col>
</aui:row>

<aui:script use="aui-base,aui-char-counter,aui-node">
	
	var index = idx.get(); // get current id
	
	/*********************** validation char counter ****************************/
	
	function createCharCounterr(counterId, inputId, _maxLength){
		
		_counterId = '#' + counterId;
		_inputId = '#' + inputId;
		
		var ccConfig = {
			counter: _counterId,
			input: _inputId,
			maxLength: _maxLength
		};
		
		return new A.CharCounter(ccConfig);
	}
	
	/*-************************** modify input tags *****************************-*/
	
	function modifyTagAttr(tagId, attrName, newAttrValue, index, wrapperId){
		
		// init some var
		
		var namespace = '<portlet:namespace />';
		var _index = (index == undefined) ? "" : index; 
		
		var _tagSelectorById = '#' + namespace + tagId;
		var _newAttrValue = namespace + newAttrValue + _index;
		
		var _wrapperId = wrapperId || 'season-fields';
		var _wrapperSelectorById = '#' + _wrapperId;
		
		
		// modifying
		
		A.one(_wrapperSelectorById).one(_tagSelectorById).attr(attrName, _newAttrValue);
		
		
		// return the new attr value
		
		return _newAttrValue;
	}
	
	/**************************** season id ***************************************/
	
	modifyTagAttr('seasonId', 'name', 'seasonId', index);
	
	var newSeasonId = modifyTagAttr('seasonId', 'id', 'seasonId', index);
	
	/**************************** season image ************************************/
	
	modifyTagAttr('imageTitle'  , 'name', 'seasonImageTitle'  , index);
	modifyTagAttr('imageUrl'    , 'name', 'seasonImageUrl'    , index);
	modifyTagAttr('imageUuid'   , 'name', 'seasonImageUuid'   , index);
	modifyTagAttr('imageVersion', 'name', 'seasonImageVersion', index);
	
	var newSeasonImageTitleId   = modifyTagAttr('imageTitle'  , 'id'  , 'seasonImageTitle'  , index);
	var newSeasonImageUrlId     = modifyTagAttr('imageUrl'    , 'id'  , 'seasonImageUrl'    , index);
	var newSeasonImageUuidId    = modifyTagAttr('imageUuid'   , 'id'  , 'seasonImageUuid'   , index);
	var newSeasonImageVersionId = modifyTagAttr('imageVersion', 'id'  , 'seasonImageVersion', index);
	
	/**************************** season title ************************************/
	
	modifyTagAttr('title', 'name', 'seasonTitle', index);
	
	var newSeasonTitleId = modifyTagAttr('title', 'id', 'seasonTitle', index);
	
	/**************************** season number **********************************/
	
	modifyTagAttr('seasonNumber', 'name', 'seasonNumber', index);
	
	var newSeasonNumberId = modifyTagAttr('seasonNumber', 'id', 'seasonNumber', index);
	
	/**************************** season description ******************************/
	
	modifyTagAttr('description', 'name', 'seasonDescription', index);
	
	var newSeasonDescriptionId = modifyTagAttr('description', 'id', 'seasonDescription', index);
	
	/**************************** season date ************************************/
	
	// 'original' season premier date fields wrapper
	
	var newSeasonPremierDateWrapperId = modifyTagAttr('seasonPremierDateWrapper', 'id', 'seasonPremierDateWrapper', index);
	
	// 'own/custom' hidden season premier date fields wrapper
	
	var newHiddenSeasonPremierDateFieldsWrapperId = modifyTagAttr('hiddenSeasonPremierDateFieldsWrapper', 'id', 'hiddenSeasonPremierDateFieldsWrapper', index);
	
	// 'own/custom' hidden season premier date inputs refactor
	
	modifyTagAttr('premierDateDay'  , 'name', 'seasonPremierDateDay'  , index, newHiddenSeasonPremierDateFieldsWrapperId);
	modifyTagAttr('premierDateMonth', 'name', 'seasonPremierDateMonth', index, newHiddenSeasonPremierDateFieldsWrapperId);
	modifyTagAttr('premierDateYear' , 'name', 'seasonPremierDateYear' , index, newHiddenSeasonPremierDateFieldsWrapperId);
	
	var newSeasonPremierDateDayId   = modifyTagAttr('premierDateDay'  , 'id', 'seasonPremierDateDay'  , index, newHiddenSeasonPremierDateFieldsWrapperId);
	var newSeasonPremierDateMonthId = modifyTagAttr('premierDateMonth', 'id', 'seasonPremierDateMonth', index, newHiddenSeasonPremierDateFieldsWrapperId);
	var newSeasonPremierDateYearId  = modifyTagAttr('premierDateYear' , 'id', 'seasonPremierDateYear' , index, newHiddenSeasonPremierDateFieldsWrapperId);

	
	/* --------------------------- char counters ------------------------------- */
	
							// title char counter //
							
	var newSeasonTitleCounterId = modifyTagAttr('titleCounter', 'id', 'seasonTitleCounter', index);
	
	// attach cc to the counter <span>-s
	createCharCounterr(newSeasonTitleCounterId, newSeasonTitleId, 75);
	
	
							// description char counter //
							
	var newSeasonDescriptionCounterId = modifyTagAttr('descriptionCounter', 'id', 'seasonDescriptionCounter', index);
	
	// attach cc to the counter <span>-s
	createCharCounterr(newSeasonDescriptionCounterId, newSeasonDescriptionId, 500);
	
	
	/*-************************** modify input tags *****************************-*/
	
	idx.inc(); // increment current id
	
</aui:script>