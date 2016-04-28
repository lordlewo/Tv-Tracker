<%@ include file="/html/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	
	long tvShowId = ParamUtil.getLong(renderRequest, WebKeys.TVSHOW_ID);
	String action = ParamUtil.getString(renderRequest, "action");
	
	String actionUrlName = null;
	String headerName = null;
	TvShow tvShow = null;
	
	if (action.equalsIgnoreCase("update")){
	
		tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);
		actionUrlName = "updateTvShow";
		headerName = "Edit TvShow: " + tvShow.getTitle();
		
	} else {
		
		tvShow = null;
		actionUrlName = "addTvShow";
		headerName = "Add New TvShow";
	}
	
%>

<script type="text/javascript">

	/******************* Counter Clojure *****************************/
	
	var idx = (function (){
		
		var _counter = 0;
		
		function get(){
			return _counter;
		}
		
		function inc(){
			_counter++;
		}
	
		function counterUtil(){
			
			var idx = {};
			
			idx.get = get;
			idx.inc = inc;
			
			return idx;
		}
	
		return counterUtil;
	})()();
	
	
</script>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/tvshowadmin/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="<%= actionUrlName %>" var="add_edit_actionURL"/>

<aui:container>
	<aui:form name="editform" action="<%= add_edit_actionURL %>" method="post">
		
		<%-- form bean --%>
		
		<aui:model-context bean="<%= tvShow %>" model="<%= TvShow.class %>"/>
		
		
		<%-- hidden fields --%>
		<c:if test='<%= action.equalsIgnoreCase("update") %>'>
			<aui:input name="tvShowId" type="hidden"></aui:input>
		</c:if>
		
		<aui:input name="imageUrl" type="hidden"></aui:input>
		<aui:input name="imageUuid" type="hidden"></aui:input>
		<aui:input name="imageVersion" type="hidden"></aui:input>
		
		
		<%-- admin page header--%>
		
		<aui:row>
			<aui:col span="12">
				<liferay-ui:header backURL="<%= viewURL %>" title="<%= headerName %>"/>
			</aui:col>
		</aui:row>
		
		
		<%-- tv show cover selection --%>
	
		<aui:row style="margin: 30px 20px 30px 20px;"> 
			<aui:field-wrapper label="Cover">
				<aui:col span="4" >
					<%
						String blankImageUrl = renderResponse.encodeURL(renderRequest.getContextPath() + "/img/no-image.png");
					
						String imageSrc = (tvShow != null) ? tvShow.getImageUrl() : blankImageUrl;
					%>
					<img id="<portlet:namespace/>img" src="<%=imageSrc%>" />
				</aui:col>
				<aui:col span="5">
					<aui:input name="imageTitle" type="text" readonly="true" label="Image" title="Image"> 
						<aui:validator name="required" errorMessage="Please select the tv show's cover." />
					</aui:input> 
					<br/>
					<aui:button name="selectButton" value="Select" icon="icon-folder-open"/>
				</aui:col>
			</aui:field-wrapper>
		</aui:row>
		
		
		<%-- tv show categories, title, premier and description fill --%>
		
		<aui:row style="margin-left: 20px;">
			<aui:col span="12">
				<div style="margin-bottom: 30px;">
					<liferay-ui:asset-categories-error />
					<liferay-ui:panel defaultState="open" extended="false" id="tvShowCategorizationPanel" persistState="true" title="Categorization">
						<aui:input name="categories" type="assetCategories" />
					</liferay-ui:panel>
				</div>

				<aui:fieldset>
					<div id="counterContainer">
						<aui:input name="title" type="text" title="Title" label="Title">
							<aui:validator name="required" errorMessage="Please enter the tv show's name."/>
							<p><span id="titleCounter"></span> character(s) remaining</p>
						</aui:input>
					</div>
					
					<aui:input name="premierDate" title="Premier Date" label="Premier Date" >
						<aui:validator name="required" errorMessage="Please enter the tv show's premier date." />
						<aui:validator name="date" errorMessage="Please enter the tv show's premier date in correct form (dd/mm/yy)." />
					</aui:input>
					
					<div id="counterContainer">
						<aui:input name="description" type="textarea" title="Description" label="Description"  style="width: 600px; height: 200px;">
							<aui:validator name="required" errorMessage="Please enter the tvshow's description." />
							<p><span id="descriptionCounter"></span> character(s) remaining</p>
						</aui:input>
					</div>
				</aui:fieldset>
			</aui:col>	
		</aui:row>
		
		
		<%-- tv show seasons, autofields --%>
		
		<aui:row style="margin-left: 20px;">
			<aui:field-wrapper label="Add Seasons to the Tv Show:">
				<div id="season-fields">
					<div class="lfr-form-row lfr-form-row-inline">
						<div class="row-fields">
							<liferay-util:include page="/html/tvshowadmin/add_season.jsp" servletContext="<%= application %>">
								<liferay-util:param name="<%= WebKeys.TVSHOW_ID %>" value="ize"></liferay-util:param>
							</liferay-util:include>
						</div>
					</div>
				</div>
			</aui:field-wrapper>
		</aui:row>

		
		<%-- submit/cancel buttons --%>
		
		<aui:row style="margin-left: 20px;">
			<aui:col span="12">
				<aui:button-row >
					<aui:button name="Save" type="submit"/>
					<aui:button name="Cancel" type="cancel" href="<%= viewURL %>" />
				</aui:button-row>
			</aui:col>
		</aui:row>
	</aui:form>
	
	
	
	<%-- portlet urls for the popup / autofields --%>
		
	<liferay-portlet:renderURL var="selectCoverURL" portletName="<%= PortletKeys.DYNAMIC_DATA_MAPPING %>" windowState="<%= LiferayWindowState.POP_UP.toString() %>" portletMode="<%= PortletMode.VIEW.toString() %>">
		<portlet:param name="struts_action" value="/dynamic_data_mapping/select_document_library"/>
	</liferay-portlet:renderURL>

	<portlet:renderURL var="addSeasonURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="mvcPath" value="/html/tvshowadmin/add_season.jsp" /> 
	</portlet:renderURL>
	
	<aui:script use="aui-char-counter,liferay-auto-fields,aui-base,liferay-util-window,aui-io-plugin-deprecated,aui-dialog-iframe-deprecated">

		var witchPopUp = null; // false = tv show ; true = season ;
	
		var tvShowCoverSelectPopUp = null;
		var seasonCoverSelectPopUp = null;
	
		// create a popup dialog window for choose cover from the Documents and Media Library 
		function createLiferayPopUp(){
			
			var dialogConfig = {
				centered: true,
                constrain2view: true,
                modal: true,
                resizable: true,
                width: 950
			}
			
			var popupConfig = {
				dialog: dialogConfig
			}
			
			var pluginConfig = {
				autoLoad: true,
                iframeCssClass: 'dialog-iframe',
                uri: '<%= selectCoverURL.toString() %>'
			}
			
			var popup = Liferay.Util.Window.getWindow(popupConfig);
			popup.plug(A.Plugin.DialogIframe, pluginConfig);
			
			return popup;
		}

		/************************** tvShow Cover select ******************************/
		
		A.one('#<portlet:namespace/>selectButton').on('click', tvShowSelect);
		function tvShowSelect(event){
			
			witchPopUp = false;
			
			tvShowCoverSelectPopUp = createLiferayPopUp();
			tvShowCoverSelectPopUp.render();
			tvShowCoverSelectPopUp.show();
			tvShowCoverSelectPopUp.titleNode.html("Select Tv Show Cover");
	    }
	
		/**************************** Autofields ************************************/

		// create autofield JS Object
		var autoFields = new Liferay.AutoFields(
			{
				contentBox: '#season-fields',
				fieldIndexes: '<portlet:namespace />rowIndexes',
				sortable: true,
				sortableHandle: '.row-fields',
				url: '<%= addSeasonURL.toString() %>'
			}
		);
		
		autoFields.render();
		
		/************************** season Cover select ******************************/
		
		// some variable reference from the newly added autofields content for the callback method _166_selectDocumentLibrary
		var seasonCoverInput = null;
		var seasonCoverImage = null;
		
		
		// attach clicklistener to the autofield's 'select' buttons, 
		// for the purpose of the image searching in the Document and Media Library
		// while the buttons added dynamically to the DOM, therefore must use the delegate method for the event 'bubbling', to attach the listeners to the newly generated DOM elements
		var contentBox = A.one('#season-fields');
		contentBox.delegate('click', seasonSelect, '.seasonCover');
		function seasonSelect(event){
			
			witchPopUp = true;
			
			seasonCoverInput = event.currentTarget.ancestor().one('input');
			seasonCoverImage = event.currentTarget.ancestor().ancestor().one('img');
			
			seasonCoverSelectPopUp = createLiferayPopUp();
			seasonCoverSelectPopUp.render();
			seasonCoverSelectPopUp.show();
			seasonCoverSelectPopUp.titleNode.html("Select Cover");
		}

		/****************** Callback function for Cover selection *******************/
		
		// set the appropriate values for the html tags (with js) and hide the popup
		_166_selectDocumentLibrary = function(url, id, groupId, fileName, version){
			if(!witchPopUp){
				A.one("#<portlet:namespace/>imageUrl").val(url);
				A.one("#<portlet:namespace/>imageUuid").val(id);
				A.one("#<portlet:namespace/>imageTitle").val(fileName);
				A.one("#<portlet:namespace/>imageVersion").val(version);
				A.one("#<portlet:namespace/>img").attr("src", url); 
			
				tvShowCoverSelectPopUp.hide();

			}else{
				seasonCoverInput.val(fileName);
				seasonCoverImage.attr('src', url);
				
				seasonCoverSelectPopUp.hide();
			}
        }
		
		/********************* validation - char counter ****************************/
		
		function createCharCounter(cc_counter, cc_input, cc_maxlength){
			
			var ccConfig = {
				counter: cc_counter,
				input: cc_input,
				maxLength: cc_maxlength
			};
			
			return new A.CharCounter(ccConfig);
		}
		
		createCharCounter('#titleCounter', '#<portlet:namespace />title', 75);
		createCharCounter('#descriptionCounter', '#<portlet:namespace />description', 500);
		

		/************************************/
		
		var premierDateWrapper = A.one('.seasonPremierDateWrapper');
		//var premierDateInput = A.one('#<portlet:namespace />premierDate');

	 	A.one('#<portlet:namespace />Save').on('click', submitClick);
	 	function submitClick(){
	 		
	 		var autofieldsRows = A.all('.lfr-form-row');
			var rowsNum = autofieldsRows.size();
			
			for(var i = 0; i < rowsNum; i++){
				
				var autofieldsRow = autofieldsRows.item(i);
				
				if( !autofieldsRow.hasClass('hide') ){
					
					var wrapper = autofieldsRow.one('.wrapperSelector');
					
					for(var j = 0; j < rowsNum; j++){
						
						var wrapperFilter = 'seasonPremierDateWrapper' + j;
						
						if(wrapper.hasClass(wrapperFilter)){
							
							var premierDateDay = wrapper.one('#<portlet:namespace />premierDateDay');
							var premierDateMonth = wrapper.one('#<portlet:namespace />premierDateMonth');
							var premierDateYear = wrapper.one('#<portlet:namespace />premierDateYear');
							
							var newPremierDateDay = autofieldsRow.one('#<portlet:namespace />seasonPremierDateDay' + j);
							var newPremierDateMonth = autofieldsRow.one('#<portlet:namespace />seasonPremierDateMonth' + j);
							var newPremierDateYear = autofieldsRow.one('#<portlet:namespace />seasonPremierDateYear' + j);
							
							newPremierDateDay.val(premierDateDay.val());
							newPremierDateMonth.val(premierDateMonth.val());
							newPremierDateYear.val(premierDateYear.val());
							
							alert(newPremierDateDay.val() + ' ' + newPremierDateMonth.val() + ' ' + newPremierDateYear.val());
							
						}
					}
				}
			}
	 		
	 		/*var wrappers = A.all('.wrapperSelector');
	 		var size = wrappers.size();
	 		
	 		for(var i = 0; i < size; i++){
	 			
	 			var classFilter = '.seasonPremierDateWrapper' + i;
	 			var wrapper = wrappers.filter(classFilter);
	 			
	 			var premierDateDay = wrapper.one('#<portlet:namespace />premierDateDay');
				var premierDateMonth = wrapper.one('#<portlet:namespace />premierDateMonth');
				var premierDateYear = wrapper.one('#<portlet:namespace />premierDateYear');
				
				var newPremierDateDay = wrapper.one('#<portlet:namespace />premierDateDay' + i);
				var newPremierDateMonth = wrapper.one('#<portlet:namespace />premierDateMonth' + i);
				var newPremierDateYear = wrapper.one('#<portlet:namespace />premierDateYear' + i);
				
				newPremierDateDay.val(premierDateDay.val());
				newPremierDateMonth.val(premierDateMonth.val());
				newPremierDateYear.val(premierDateYear.val());
	 			
				alert(premierDateDay.val() + ' ' + premierDateMonth.val() + ' ' + premierDateYear.val());
	 		}*/
	 		
	 		/* var premierDateDay = premierDateWrapper.one('#<portlet:namespace />premierDateDay');
			var premierDateMonth = premierDateWrapper.one('#<portlet:namespace />premierDateMonth');
			var premierDateYear = premierDateWrapper.one('#<portlet:namespace />premierDateYear');
	 		alert(premierDateDay.val() + ' ' + premierDateMonth.val() + ' ' + premierDateYear.val()); */

	 	}
	</aui:script>
</aui:container>