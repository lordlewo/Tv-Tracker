<%@page import="com.liferay.portal.model.ModelHintsUtil"%>
<%@page import="com.liferay.portal.model.ModelHintsConstants"%>
<%@ include file="/html/init.jsp" %>

<liferay-ui:success key="add-tvshow-successful" 			 	message="TvShow creating was successful!"/>
<liferay-ui:success key="add-tvshow-with-season-successful"  	message="TvShow creating with season was successful!"/>
<liferay-ui:success key="add-tvshow-with-seasons-successful" 	message="TvShow creating with seasons was successful!"/>

<liferay-ui:error key="add-tvshow-unsuccessful" 			 	message="TvShow creating was unsuccessful!"/>
<liferay-ui:error key="add-tvshow-with-season-unsuccessful"  	message="TvShow creating with season was unsuccessful!"/>
<liferay-ui:error key="add-tvshow-with-seasons-unsuccessful" 	message="TvShow creating with seasons was unsuccessful!"/>

<liferay-ui:error key="update-tvshow-unsuccessful" 			 	message="TvShow editing was unsuccessful!"/>
<liferay-ui:error key="update-tvshow-with-season-unsuccessful"  message="TvShow editing with season was unsuccessful!"/>
<liferay-ui:error key="update-tvshow-with-seasons-unsuccessful" message="TvShow editing with seasons was unsuccessful!"/>


<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	
	long tvShowId = ParamUtil.getLong(renderRequest, "tvShowId");
	String action = ParamUtil.getString(renderRequest, "action");
	
	//model hints
	
	String tvShowModel = TvShow.class.getName();
	int tvShowTitleMaxLength = Integer.parseInt(ModelHintsUtil.getHints(tvShowModel, "title").get("max-length"));
	int tvShowDescriptionMaxLength = Integer.parseInt(ModelHintsUtil.getHints(tvShowModel, "description").get("max-length"));

	
	String actionUrlName = null;
	String headerName = null;
	
	TvShow tvShow = null;
	List<Season> seasons = null;
	
	if (action.equalsIgnoreCase("update")){
	
		tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);
		seasons = SeasonLocalServiceUtil.getSeasons(tvShowId, serviceContext);
		
		actionUrlName = "updateTvShow";
		headerName = "Edit TvShow: " + tvShow.getTitle();
		
	} else {
		
		tvShow = null;
		seasons = new ArrayList<Season>();
		
		actionUrlName = "addTvShow";
		headerName = "Add New TvShow";
	}
	
%>

<script type="text/javascript">

	/******************* Counter Clojure *****************************/
	
	var idx = (function () {
		
		var _counter = 0;
		
		function get(){
			return _counter;
		}
		
		function set(val){
			_counter = val;
		}
		
		function incr(){
			_counter++;
		}
		
		function getAndIncr(){
			return _counter++;
		}
		
		function incrAndGet(){
			return ++_counter;
		}
	
		function counterUtil(){
			
			var idx = {};
			
			idx.get = get;
			idx.set = set;
			idx.incr = incr;
			idx.getAndIncr = getAndIncr;
			idx.incrAndGet = incrAndGet;
			
			return idx;
		}
	
		return counterUtil;
	})()();
	
	var fvUtil = (function () {
		
		var _fv = null;
		
		function get(){
			return _fv;
		}
		
		function set(fv){
			_fv = fv;
		}
		
		function init(){
			
			var fvUtil = {};
			
			fvUtil.get = get;
			fvUtil.set = set;
			
			return fvUtil;
		}
		
		return init;
		
	})()();
	
</script>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/tvshowadmin/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="<%= actionUrlName %>" var="add_edit_actionURL"/>

<aui:container>
	<aui:form name="editForm" action="<%= add_edit_actionURL %>" method="post">
		
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
	
		<aui:row cssClass="tvShowAdminCoverSelectionRow"> 
			<aui:field-wrapper label="Cover">
				<aui:col span="4" >
					<%
						String blankImageUrl = renderResponse.encodeURL(renderRequest.getContextPath() + "/img/no-image.png");
					
						String tvShowCover = (action.equalsIgnoreCase("update") && tvShow != null) ? tvShow.getImageUrl() : blankImageUrl;
					%>
					<img id="<portlet:namespace/>img" src="<%= tvShowCover %>" />
				</aui:col>
				<aui:col span="5">
					<aui:input name="imageTitle" type="text" readonly="true" label="Image" title="Image" />
					<br/>
					<aui:button name="selectButton" value="Select" icon="icon-folder-open"/>
				</aui:col>
			</aui:field-wrapper>
		</aui:row>
		
		
		<%-- tv show categories, title, premier and description fill --%>
		
		<aui:row cssClass="tvShowAdminRow">
			<aui:col span="11">
				<div class="tvShowAdminAssetCategories">
					<liferay-ui:asset-categories-error />
					<liferay-ui:panel defaultState="open" extended="false" id="tvShowCategorizationPanel" persistState="true" title="Categorization">
						<aui:input name="categories" type="assetCategories" />
					</liferay-ui:panel>
				</div>

				<aui:fieldset>
					<div id="counterContainer">
						<aui:input name="title" type="text" title="Title" label="Title" >
							<p><span id="titleCounter"></span> character(s) remaining</p>
						</aui:input>
					</div>
					
					<aui:input name="premierDate" title="Premier Date" label="Premier Date" />
					
					<div id="counterContainer">
						<aui:input name="description" type="textarea" title="Description" label="Description" cssClass="tvShowAdminDescriptionTextArea" >
							<p><span id="descriptionCounter"></span> character(s) remaining</p>
						</aui:input>
					</div>
				</aui:fieldset>
			</aui:col>	
		</aui:row>
		
		
		<%-- tv show seasons, autofields --%>
		
		<aui:row cssClass="tvShowAdminRow">
			<aui:field-wrapper label="Add Seasons to the Tv Show:">
				<div id="season-fields">
					<c:choose>
						<c:when test='<%= action.equalsIgnoreCase("update") && !seasons.isEmpty() %>'>
							<%
								for(Season season : seasons) {
							%>
								<div class="lfr-form-row lfr-form-row-inline">
									<div class="row-fields">
										<liferay-util:include page="/html/tvshowadmin/add_season.jsp" servletContext="<%= application %>">
											<liferay-util:param name="<%= WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId) %>" />
											<liferay-util:param name="<%= WebKeys.SEASON_ID %>" value="<%= String.valueOf(season.getSeasonId()) %>" />
											<liferay-util:param name="action" value="<%= action %>" />
										</liferay-util:include>
									</div>
								</div>
							<% 
								}
							%>
						</c:when>
						<c:when test='<%= action.equalsIgnoreCase("update") && seasons.isEmpty() %>'>
							<div class="lfr-form-row lfr-form-row-inline">
								<div class="row-fields">
									<liferay-util:include page="/html/tvshowadmin/add_season.jsp" servletContext="<%= application %>">
										<liferay-util:param name="<%= WebKeys.TVSHOW_ID %>" value="<%= String.valueOf(tvShowId) %>" />
										<liferay-util:param name="<%= WebKeys.SEASON_ID %>" value="0" />
										<liferay-util:param name="action" value="<%= action %>" />
									</liferay-util:include>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="lfr-form-row lfr-form-row-inline">
								<div class="row-fields">
									<liferay-util:include page="/html/tvshowadmin/add_season.jsp" servletContext="<%= application %>">
										<liferay-util:param name="action" value="<%= action %>" />
									</liferay-util:include>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</aui:field-wrapper>
		</aui:row>

		
		<%-- submit/cancel buttons --%>
		
		<aui:row cssClass="tvShowAdminRow">
			<aui:col span="12">
				<aui:button-row >
					<aui:button name="Save" type="submit"/>
					<aui:button name="Cancel" type="cancel" href="<%= viewURL %>" />
				</aui:button-row>
			</aui:col>
		</aui:row>
	</aui:form>
	
	
	
	<%-- portlet urls for the popup / autofields --%>
		
	<liferay-portlet:renderURL 
				var="selectCoverURL" 
				portletName="<%= PortletKeys.DYNAMIC_DATA_MAPPING %>" 
				windowState="<%= LiferayWindowState.POP_UP.toString() %>" 
				portletMode="<%= PortletMode.VIEW.toString() %>">
		<portlet:param name="struts_action" value="/dynamic_data_mapping/select_document_library"/>
	</liferay-portlet:renderURL>

	<portlet:renderURL var="addSeasonURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="mvcPath" value="/html/tvshowadmin/add_season.jsp" /> 
	</portlet:renderURL>
	
	<aui:script use="aui-base,liferay-auto-fields,aui-char-counter,aui-form-validator,liferay-util-window,aui-io-plugin-deprecated,aui-dialog-iframe-deprecated">

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

		/************************** TvShow Cover Select ******************************/
		
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
		
		// autofields addrow callback - with this should have to do
		autoFields.on('clone', function(datas){
			
			var guid = datas.guid;
			var originalRow = datas.originalRow;
			var row = datas.row;
			
			var rules = fv.get('rules');
			var key = null;
			
			key = '<portlet:namespace/>visibleSeasonImageTitle' + (guid - 1);
			rules[key] = {
				required : true
			};
			fieldStrings[key] = {
				required : 'Please, select the season cover!'
			}
			
			key = '<portlet:namespace/>visibleSeasonTitle' + (guid - 1);
			rules[key] = {
				required : true
			};
			fieldStrings[key] = {
				required : 'Please, enter the season title!'
			}
			
			key = '<portlet:namespace/>visibleSeasonNumber' + (guid - 1);
			rules[key] = {
				required : true,
				number : true,
				min : 1
			};
			fieldStrings[key] = {
				required : 'Please, enter the season number!',
				number: 'Please, enter a valid number!',
				min: 'Please enter a positive integer number!'
			}
			
			key = '<portlet:namespace/>premierDate';
			rules[key] = {
				required : true
			};
			fieldStrings[key] = {
				required : 'Please, enter the premier date!'
			}
			
			key = '<portlet:namespace/>visibleSeasonDescription' + (guid - 1);
			rules[key] = {
				required : true
			};
			fieldStrings[key] = {
				required : 'Please, enter the season description!'
			}
			
			
			fv.set('rules', rules);
			
			
			fv.validate();
		});
		
		/************************** Season Cover Select ******************************/
		
		// some variable reference from the newly added autofields content for the callback method _166_selectDocumentLibrary
		var seasonCoverImage = null;
		var visibleSeasonImageTitle = null;
		
		var seasonImageTitle = null;
		var seasonImageUrl = null;
		var seasonImageUuid = null;
		var seasonImageVersion = null;
		
		
		// attach clicklistener to the autofield's 'select' buttons, 
		// for the purpose of the image searching in the Document and Media Library
		// while the buttons added dynamically to the DOM, therefore must use the delegate method for the event 'bubbling', to attach the listeners to the newly generated DOM elements
		var contentBox = A.one('#season-fields');
		contentBox.delegate('click', seasonSelect, '.seasonCover');
		function seasonSelect(event){
			
			witchPopUp = true;
			
			
			var wrapper = event.currentTarget.ancestor().ancestor().ancestor();
			seasonCoverImage = wrapper.one('img');
			
			for(var i = 0; i < idx.get(); i++){
				
				var inputFilter = '#<portlet:namespace />visibleSeasonImageTitle' + i;
				
				visibleSeasonImageTitle = wrapper.one(inputFilter);
				
				if(visibleSeasonImageTitle != null){
					
					seasonImageTitle = wrapper.one('#<portlet:namespace />seasonImageTitle' + i);
					seasonImageUrl = wrapper.one('#<portlet:namespace />seasonImageUrl' + i);
					seasonImageUuid = wrapper.one('#<portlet:namespace />seasonImageUuid' + i);
					seasonImageVersion = wrapper.one('#<portlet:namespace />seasonImageVersion' + i);
					
					break;
				}
			}
			
			//seasonImageTitle = event.currentTarget.ancestor().one('input');
			
			seasonCoverSelectPopUp = createLiferayPopUp();
			seasonCoverSelectPopUp.render();
			seasonCoverSelectPopUp.show();
			seasonCoverSelectPopUp.titleNode.html("Select Cover");
		}

		/****************** Callback function for Cover selection *******************/
		
		// set the appropriate values for the html tags (with js) and hide the popup
		// the function name is determined
		_166_selectDocumentLibrary = function(url, id, groupId, fileName, version){
			if(!witchPopUp){
				A.one("#<portlet:namespace/>imageUrl").val(url);
				A.one("#<portlet:namespace/>imageUuid").val(id);
				A.one("#<portlet:namespace/>imageTitle").val(fileName);
				A.one("#<portlet:namespace/>imageVersion").val(version);
				A.one("#<portlet:namespace/>img").attr("src", url); 
			
				tvShowCoverSelectPopUp.hide();

			}else{
				seasonCoverImage.attr('src', url);
				visibleSeasonImageTitle.val(fileName);
				
				seasonImageTitle.val(fileName);
				seasonImageUrl.val(url);
				seasonImageUuid.val(id);
				seasonImageVersion.val(version);
				
				
				seasonCoverSelectPopUp.hide();
			}
        }
		
		/********************* Validation - Char Counter ****************************/
		
		function createCharCounter(cc_counter, cc_input, cc_maxlength){
			
			var ccConfig = {
				counter: cc_counter,
				input: cc_input,
				maxLength: cc_maxlength
			};
			
			return new A.CharCounter(ccConfig);
		}
		
		createCharCounter('#titleCounter', '#<portlet:namespace />title', <%= tvShowTitleMaxLength %>);
		createCharCounter('#descriptionCounter', '#<portlet:namespace />description', <%= tvShowDescriptionMaxLength %>);
		

		/******** Autofields: setting the own hidden season premier date values *****/
	
		// onclick listener to the Save submit button
	 	A.one('#<portlet:namespace />Save').on('click', submitClick);
		
		
	 	function submitClick(){
	 		
	 		// get all rows
	 		var autofieldsRows = A.all('.lfr-form-row');
			
	 		// get rows num
	 		var rowsNum = autofieldsRows.size();
			
	 		// iterate the rows
			for(var i = 0; i < rowsNum; i++){
				
				// get current row in the cycle
				var autofieldsRow = autofieldsRows.item(i);
				
				// if not hided - (hide -> if minus button clicked, the row still in the DOM, but that row already is irrelevant)
				if( !autofieldsRow.hasClass('hide') ){
					
					fillSeasonTitleHiddenFields(autofieldsRow, i);
					fillSeasonNumberHiddenFields(autofieldsRow, i);
					fillSeasonPremierDateHiddenFields(autofieldsRow, i);
					fillSeasonDescriptionHiddenFields(autofieldsRow, i);
					
				}
			}
	 	}
	 	
		function fillSeasonTitleHiddenFields(currentRow, index) {
	 		
	 		// get the title's wrapper from the row
			var wrapperId = '#<portlet:namespace />seasonTitleWrapper' + index;
			var wrapper   = currentRow.one(wrapperId);
			
			if (wrapper != null) {
				// get value from the wrapper
				var visibleSeasonTitle = wrapper.one('#<portlet:namespace />visibleSeasonTitle' + index);
				
				// locate the hidden field
				var seasonTitle = wrapper.one('#<portlet:namespace />seasonTitle' + index);
	
				// set values to the hidden field
				seasonTitle.val(visibleSeasonTitle.val());
			}
	 	}
		
		function fillSeasonNumberHiddenFields(currentRow, index) {
	 		
	 		// get the number's wrapper from the row
			var wrapperId = '#<portlet:namespace/>seasonNumberWrapper' + index;
			var wrapper   = currentRow.one(wrapperId);
			
			if(wrapper != null) {
				// get value from the wrapper
				var visibleSeasonNumber = wrapper.one('#<portlet:namespace />seasonNumber');
				
				// locate the hidden field
				var seasonNumber = wrapper.one('#<portlet:namespace />seasonNumber' + index);

				// set values to the hidden field
				seasonNumber.val(visibleSeasonNumber.val());
			}
	 	}

	 	function fillSeasonPremierDateHiddenFields(currentRow, index) {
	 		
	 		// get the date's wrapper from the row
			var wrapperId = '#<portlet:namespace/>seasonPremierDateWrapper' + index;
			var wrapper   = currentRow.one(wrapperId);

			if(wrapper != null) {
				// get values from the wrapper
				var premierDateDay = wrapper.one('#<portlet:namespace />premierDateDay');
				var premierDateMonth = wrapper.one('#<portlet:namespace />premierDateMonth');
				var premierDateYear = wrapper.one('#<portlet:namespace />premierDateYear');
				
				// locate the hidden fields
				var seasonPremierDateDay = wrapper.one('#<portlet:namespace />seasonPremierDateDay' + index);
				var seasonPremierDateMonth = wrapper.one('#<portlet:namespace />seasonPremierDateMonth' + index);
				var seasonPremierDateYear = wrapper.one('#<portlet:namespace />seasonPremierDateYear' + index);
				
				// set values to the hidden fields
				seasonPremierDateDay.val(premierDateDay.val());
				seasonPremierDateMonth.val(premierDateMonth.val());
				seasonPremierDateYear.val(premierDateYear.val());
			}			
	 	}
		
		function fillSeasonDescriptionHiddenFields(currentRow, index) {
	 		
	 		// get the number's wrapper from the row
			var wrapperId = '#<portlet:namespace/>seasonDescriptionWrapper' + index;
			var wrapper   = currentRow.one(wrapperId);

			if(wrapper != null) {	
			// get value from the wrapper
			var visibleSeasonDescription = wrapper.one('#<portlet:namespace />visibleSeasonDescription' + index);
			
			// locate the hidden field
			var seasonDescription = wrapper.one('#<portlet:namespace />seasonDescription' + index);

			// set values to the hidden field
			seasonDescription.val(visibleSeasonDescription.val());
			}
	 	}

		/************************** Form Validation *********************************/


		if (fvUtil.get() == null){
			
			var fvConfig = {
				boundingBox: '#<portlet:namespace/>editForm'
			}
			
			var fv = new A.FormValidator(fvConfig);
			
			var rules = fv.get('rules');
			var fieldStrings = fv.get('fieldStrings');
			var key = null;
			
			
			// tv show input validation
			key = '<portlet:namespace/>imageTitle';
			rules[key] = {
				required : true
			}
			fieldStrings[key] = {
				required : 'Please, select the tv show cover!'
			}
			
			key = '<portlet:namespace/>title';
			rules[key] = {
				required : true
			}
			fieldStrings[key] = {
				required : 'Please, enter the tv show title!'
			}
			
			key = '<portlet:namespace/>premierDate';
			rules[key] = {
				required : true
			}
			fieldStrings[key] = {
				required : 'Please, enter the premier date!'
			}
			
			key = '<portlet:namespace/>description'
			rules[key] = {
				required : true
			}
			fieldStrings[key] = {
				required : 'Please, enter the tv show description!'
			}
			
			
			// season input validation
			for(var i = 0; i < idx.get(); i++) {
			
				key = '<portlet:namespace/>visibleSeasonImageTitle' + i;
				rules[key] = {
					required : true
				};
				fieldStrings[key] = {
					required : 'Please, select the season cover!'
				}
				
				key = '<portlet:namespace/>visibleSeasonTitle' + i;
				rules[key] = {
					required : true
				};
				fieldStrings[key] = {
					required : 'Please, enter the season title!'
				}
				
				key = '<portlet:namespace/>visibleSeasonNumber' + i;
				rules[key] = {
					required : true,
					number : true,
					min : 1
				};
				fieldStrings[key] = {
					required : 'Please, enter the season number!',
					number: 'Please, enter a valid number!',
					min: 'Please enter a positive integer number!'
				}
				
				key = '<portlet:namespace/>premierDate';
				rules[key] = {
					required : true
				};
				fieldStrings[key] = {
					required : 'Please, enter the premier date!'
				}
				
				key = '<portlet:namespace/>visibleSeasonDescription' + i;
				rules[key] = {
					required : true
				};
				fieldStrings[key] = {
					required : 'Please, enter the season description!'
				}
			
			}	
		
			
			fv.set('rules', rules);
			
			fvUtil.set(fv);
		}
		
		
	</aui:script>
</aui:container>