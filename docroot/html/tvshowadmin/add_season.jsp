<%@page import="com.liferay.portal.model.ModelHintsUtil"%>
<%@ include file="/html/init.jsp"  %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

	// model hints
	String SeasonModel = Season.class.getName();
	int seasonTitleMaxLength = Integer.parseInt(ModelHintsUtil.getHints(SeasonModel, "title").get("max-length"));
	int seasonDescriptionMaxLength = Integer.parseInt(ModelHintsUtil.getHints(SeasonModel, "description").get("max-length"));

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

<aui:row cssClass="tvShowAdminAddSeasonRow">

	<aui:model-context model="<%= Season.class %>" bean="<%= season %>" />
	
	<aui:input name="seasonId" type="hidden" cssClass=""/>

	<aui:col span="3">
		<aui:row>
			<%
				String blankImageUrl = renderResponse.encodeURL(renderRequest.getContextPath() + "/img/no-image.png");

				String seasonCover = (action.equalsIgnoreCase("update") && season != null) ? season.getImageUrl() : blankImageUrl;
			%>
			<img id="<portlet:namespace/>img" src="<%= seasonCover %>" class="tvShowAdminAddSeasonCoverImage"/>
		</aui:row>
		
		<aui:row>
			<div id="<portlet:namespace/>seasonImageWrapper">
				<aui:input name="imageTitle" type="text" readOnly="true" label="Image" title="Image" />
				
				<aui:button cssClass="seasonCover" name="selectSeasonImageButton" value="Select" icon="icon-folder-open"/>
				
				<%-- hidden inputs --%>
				<div id="<portlet:namespace/>hiddenSeasonImageFieldsWrapper">
					<aui:input name="imageTitle"   type="hidden" cssClass=""/>
					<aui:input name="imageUrl"     type="hidden" cssClass=""/>
					<aui:input name="imageUuid"    type="hidden" cssClass=""/>
					<aui:input name="imageVersion" type="hidden" cssClass=""/>
				</div>
			</div>
		</aui:row>	
	</aui:col>
		
	<aui:col span="3">
		<aui:row>
			<div id="<portlet:namespace/>seasonTitleWrapper">
					
				<aui:input name="title" type="text" title="Season Title" label="Season Title">
					<p><span id="<portlet:namespace/>titleCounter"></span> character(s) remaining</p>
				</aui:input>
				
				<%-- hidden input --%>
				<div id="<portlet:namespace/>hiddenSeasonTitleWrapper">
					<aui:input name="seasonTitle" type="hidden" cssClass=""/>
				</div>
			</div>
		</aui:row>
		
		<aui:row>
			<div id="<portlet:namespace/>seasonNumberWrapper">
				<aui:input name="seasonNumber" title="Season Number" label="Season Number" model="<%= Season.class %>" />
				
				<%-- hidden input --%>
				<div id="<portlet:namespace/>hiddenSeasonNumberWrapper">
					<aui:input name="seasonNumber" type="hidden" cssClass=""/>
				</div>
			</div>
		</aui:row>
	
		<aui:row>
			<div id="<portlet:namespace/>seasonPremierDateWrapper">
				<aui:input name="premierDate" title="Season Premier Date" label="Season Premier Date" model="<%= Season.class %>" />
				
				<%-- hidden inputs --%>
				<div id="<portlet:namespace/>hiddenSeasonPremierDateFieldsWrapper">
					<aui:input name="seasonPremierDateDay" type="hidden" cssClass=""/>
					<aui:input name="seasonPremierDateMonth" type="hidden" cssClass=""/>
					<aui:input name="seasonPremierDateYear" type="hidden" cssClass=""/>
				</div>
			</div>
		</aui:row>
	</aui:col>
		
	<aui:col span="4">
		<aui:row>
			<div id="<portlet:namespace/>seasonDescriptionWrapper">
				<aui:input name="description" title="Season Description" label="Season Description" type="textarea" cssClass="tvShowAdminAddSeasonDescriptionTextArea" >
					<p><span id="<portlet:namespace/>descriptionCounter"></span> character(s) remaining</p>
				</aui:input>
				
				<%-- hidden input --%>
				<div id="<portlet:namespace/>hiddenSeasonDescriptionWrapper">
					<aui:input name="seasonDescription" type="hidden" cssClass=""/>
				</div>
			</div>
		</aui:row>
	</aui:col>
</aui:row>

<aui:script use="aui-base,aui-char-counter,liferay-form,aui-node">
	
	var index = idx.get(); // get current id
	
	/*********************** validation: char counter creator function ***************/
	
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
		var _index = (index == undefined) ? '' : index; 
		
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
	
	var newSeasonName = modifyTagAttr('seasonId', 'name', 'seasonId', index);
	
	var newSeasonId   = modifyTagAttr('seasonId', 'id'  , 'seasonId', index);
	
	/**************************** season image ************************************/
	
	// season image wrapper
	var seasonImageWrapperId = modifyTagAttr('seasonImageWrapper', 'id', 'seasonImageWrapper', index);
	
	// season image title
	var visibleSeasonImageTitleName = modifyTagAttr('imageTitle', 'name', 'visibleSeasonImageTitle', index, seasonImageWrapperId);
	var visibleSeasonImageTitleId   = modifyTagAttr('imageTitle', 'id'  , 'visibleSeasonImageTitle', index, seasonImageWrapperId);
	
	// hidden season image fields wrapper
	var hiddenSeasonImageFieldsWrapperId = modifyTagAttr('hiddenSeasonImageFieldsWrapper', 'id', 'hiddenSeasonImageFieldsWrapper', index, seasonImageWrapperId);
	
	// hidden season image fields
 	var seasonImageTitleName   = modifyTagAttr('imageTitle'  , 'name', 'seasonImageTitle'  , index, hiddenSeasonImageFieldsWrapperId);
 	var seasonImageUrlName     = modifyTagAttr('imageUrl'    , 'name', 'seasonImageUrl'    , index, hiddenSeasonImageFieldsWrapperId);
 	var seasonImageUuidName    = modifyTagAttr('imageUuid'   , 'name', 'seasonImageUuid'   , index, hiddenSeasonImageFieldsWrapperId);
 	var seasonImageVersionName = modifyTagAttr('imageVersion', 'name', 'seasonImageVersion', index, hiddenSeasonImageFieldsWrapperId);
	var seasonImageTitleId     = modifyTagAttr('imageTitle'  , 'id'  , 'seasonImageTitle'  , index, hiddenSeasonImageFieldsWrapperId);
	var seasonImageUrlId       = modifyTagAttr('imageUrl'    , 'id'  , 'seasonImageUrl'    , index, hiddenSeasonImageFieldsWrapperId);
	var seasonImageUuidId      = modifyTagAttr('imageUuid'   , 'id'  , 'seasonImageUuid'   , index, hiddenSeasonImageFieldsWrapperId);
	var seasonImageVersionId   = modifyTagAttr('imageVersion', 'id'  , 'seasonImageVersion', index, hiddenSeasonImageFieldsWrapperId);
	
	/**************************** season title ************************************/
	
	// season title wrapper
	var seasonTitleWrapperId = modifyTagAttr('seasonTitleWrapper', 'id', 'seasonTitleWrapper', index);
	
	// season title
	var visibleSeasonTitleName = modifyTagAttr('title', 'name', 'visibleSeasonTitle', index, seasonTitleWrapperId);
	var visibleSeasonTitleId   = modifyTagAttr('title', 'id'  , 'visibleSeasonTitle', index, seasonTitleWrapperId);
	
	// season title label
	var visibleSeasonTitleLabel = A.one('#' + seasonTitleWrapperId).one('label').attr('for', visibleSeasonTitleId);
	
	// hidden season title wrapper
	var hiddenSeasonTitleWrapperId = modifyTagAttr('hiddenSeasonTitleWrapper', 'id', 'hiddenSeasonTitleWrapper', index, seasonTitleWrapperId);
	
	// hidden season title
	var seasonTitleName = modifyTagAttr('seasonTitle', 'name', 'seasonTitle', index, hiddenSeasonTitleWrapperId);
	var seasonTitleId   = modifyTagAttr('seasonTitle', 'id'  , 'seasonTitle', index, hiddenSeasonTitleWrapperId);
	
	/**************************** season number **********************************/
	
	// season number wrapper
	var seasonNumberWrapperId = modifyTagAttr('seasonNumberWrapper', 'id', 'seasonNumberWrapper', index);
	
	// season number
	var visibleSeasonNumberName = modifyTagAttr('seasonNumber', 'name', 'visibleSeasonNumber', index, seasonNumberWrapperId);
	var visibleSeasonNumberId   = modifyTagAttr('seasonNumber', 'id'  , 'visibleSeasonNumber', index, seasonNumberWrapperId);
	
	// hidden season number wrapper
	var hiddenSeasonNumberWrapperId = modifyTagAttr('hiddenSeasonNumberWrapper', 'id', 'hiddenSeasonNumberWrapper', index, seasonNumberWrapperId);
	
	// hidden season number
	var seasonNumberName = modifyTagAttr('seasonNumber', 'name', 'seasonNumber', index, hiddenSeasonNumberWrapperId);
	var seasonNumberId   = modifyTagAttr('seasonNumber', 'id'  , 'seasonNumber', index, hiddenSeasonNumberWrapperId);
	
	/**************************** season premier date *****************************/
	
	// season premier date wrapper (for the 'original' fields)
	
	var seasonPremierDateWrapperId = modifyTagAttr('seasonPremierDateWrapper', 'id', 'seasonPremierDateWrapper', index);
	
	// season premier date
	// -//-
	
	// hidden season premier date fields wrapper (for the 'own/custom' fields)
	
	var hiddenSeasonPremierDateFieldsWrapperId = modifyTagAttr('hiddenSeasonPremierDateFieldsWrapper', 'id', 'hiddenSeasonPremierDateFieldsWrapper', index, seasonPremierDateWrapperId);
	
	// hidden season premier date fields ('own/custom')
	
 	var seasonPremierDateDayName   = modifyTagAttr('seasonPremierDateDay'  , 'name', 'seasonPremierDateDay'  , index, hiddenSeasonPremierDateFieldsWrapperId);
 	var seasonPremierDateMonthName = modifyTagAttr('seasonPremierDateMonth', 'name', 'seasonPremierDateMonth', index, hiddenSeasonPremierDateFieldsWrapperId);
 	var seasonPremierDateYearName  = modifyTagAttr('seasonPremierDateYear' , 'name', 'seasonPremierDateYear' , index, hiddenSeasonPremierDateFieldsWrapperId);

	var seasonPremierDateDayId     = modifyTagAttr('seasonPremierDateDay'  , 'id'  , 'seasonPremierDateDay'  , index, hiddenSeasonPremierDateFieldsWrapperId);
	var seasonPremierDateMonthId   = modifyTagAttr('seasonPremierDateMonth', 'id'  , 'seasonPremierDateMonth', index, hiddenSeasonPremierDateFieldsWrapperId);
	var seasonPremierDateYearId    = modifyTagAttr('seasonPremierDateYear' , 'id'  , 'seasonPremierDateYear' , index, hiddenSeasonPremierDateFieldsWrapperId);

	/**************************** season description ******************************/
	
	// season description wrapper
	var seasonDescriptionWrapperId = modifyTagAttr('seasonDescriptionWrapper', 'id', 'seasonDescriptionWrapper', index);
	
	// season description
	var visibleSeasonDescriptionName = modifyTagAttr('description', 'name', 'visibleSeasonDescription', index, seasonDescriptionWrapperId);
	var visibleSeasonDescriptionId   = modifyTagAttr('description', 'id'  , 'visibleSeasonDescription', index, seasonDescriptionWrapperId);
	
	// hidden season description wrapper
	var hiddenSeasonDescriptionWrapperId = modifyTagAttr('hiddenSeasonDescriptionWrapper', 'id', 'hiddenSeasonDescriptionWrapper', index, seasonDescriptionWrapperId);
	
	// hidden season description
	var seasonDescriptionName = modifyTagAttr('seasonDescription', 'name', 'seasonDescription', index, hiddenSeasonDescriptionWrapperId);
	var seasonDescriptionId   = modifyTagAttr('seasonDescription', 'id'  , 'seasonDescription', index, hiddenSeasonDescriptionWrapperId);
	
	/*-************************** modify input tags *****************************-*/
	
	/* --------------------------- char counters ------------------------------- */
	
							// title char counter //
							
	var seasonTitleCounterId = modifyTagAttr('titleCounter', 'id', 'seasonTitleCounter', index);
	
	// attach cc to the counter <span>-s
	createCharCounterr(seasonTitleCounterId, visibleSeasonTitleId, <%= seasonTitleMaxLength %>);
	
	
							// description char counter //
							
	var seasonDescriptionCounterId = modifyTagAttr('descriptionCounter', 'id', 'seasonDescriptionCounter', index);
	
	// attach cc to the counter <span>-s
	createCharCounterr(seasonDescriptionCounterId, visibleSeasonDescriptionId,  <%= seasonDescriptionMaxLength %>);
	
	
	
	/*-----------------------------------*/
	idx.incr(); // increment current id
	
</aui:script>