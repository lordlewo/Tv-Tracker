<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="hu.webtown.liferay.tvtracker.NoSuchTvShowException"%>
<%@ include file="/html/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	
	String action = ParamUtil.getString(renderRequest, "action");
	long tvShowId = ParamUtil.getLong(renderRequest, WebKeys.TVSHOW_ID);
	
	String actionUrlName = null;
	String headerName = null;
	TvShow tvShow = null;
	
	if (action.equalsIgnoreCase("update")){
	
		tvShow = TvShowLocalServiceUtil.getTvShow(tvShowId, serviceContext);
		actionUrlName = "updateTvShow";
		headerName = "Edit TvShow: " + tvShow.getTitle();
		
	} else{
		
		tvShow = null;
		actionUrlName = "addTvShow";
		headerName = "Add New TvShow";
	}
	
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/tvshowadmin/view.jsp"/>
</portlet:renderURL>

<liferay-portlet:renderURL var="selectTvShowURL" portletName="<%= PortletKeys.DYNAMIC_DATA_MAPPING %>" windowState="<%= LiferayWindowState.POP_UP.toString() %>" portletMode="<%= PortletMode.VIEW.toString() %>">
	<portlet:param name="struts_action" value="/dynamic_data_mapping/select_document_library"/>
</liferay-portlet:renderURL>

<portlet:actionURL name="<%= actionUrlName %>" var="add_edit_actionURL"/>


<aui:container>
	<aui:form name="editform" action="<%= add_edit_actionURL %>" method="post">
		
		<%-- form bean --%>
		<aui:model-context bean="<%= tvShow %>" model="<%= TvShow.class %>"/>
		
		<%-- hidden fields --%>
		
		<aui:input name="tvShowId" type="hidden"></aui:input>
		<aui:input name="imageUrl" type="hidden"></aui:input>
		<aui:input name="imageUuid" type="hidden"></aui:input>
		<aui:input name="imageVersion" type="hidden"></aui:input>
		
		
		<%-- admin page content --%>
		<aui:row>
			<aui:col span="12">
				<liferay-ui:header backURL="<%= viewURL %>" title="<%= headerName %>"/>
			</aui:col>
		</aui:row>
		
		<aui:row style="margin: 30px 20px 0px 20px; height: 200px; max-height: 200px;"> 
			<aui:field-wrapper label="Cover">
			
				<aui:col span="3" >
					<%
						String imageSrc = (tvShow != null) ? tvShow.getImageUrl() : renderResponse.encodeURL(renderRequest.getContextPath()+"/img/no-image.png");
					%>
					
					<img id="<portlet:namespace/>img" src="<%= imageSrc%>" height="200" style="max-height: 200px;"/>
					
				</aui:col>
				<aui:col span="5">
					
					<aui:input name="imageTitle" type="text" readonly="true" label="Image" title="Image"> 
						<aui:validator name="required" errorMessage="Please select the tv show's cover." />
					</aui:input> 
					<br/>
					<aui:button name="selectButton" value="Select" icon=" icon-folder-open"/>

				</aui:col>
			</aui:field-wrapper>
		</aui:row>
		
		<aui:row>
			<aui:col span="12">

				<div style="margin-bottom: 30px; margin-top: 30px;">
					<liferay-ui:asset-categories-error />
					<liferay-ui:panel defaultState="open" extended="false" id="tvShowCategorizationPanel" persistState="true" title="Categorization">
						<aui:input name="categories" type="assetCategories" />
					</liferay-ui:panel>
				</div>

				<aui:fieldset >
					<aui:input name="title" title="Title" label="Title">
						<aui:validator name="required" errorMessage="Please enter the tv show's name."/>
						<div id="counterContainer">
							<p>
								<span id="titleCounter"></span> character(s) remaining
							</p>
						</div>
					</aui:input>
					
					<aui:input name="premierDate" title="Premier Date" label="Premier Date" >
						<aui:validator name="required" errorMessage="Please enter the tv show's premier date" />
					</aui:input>
					
					<aui:input name="description" title="Description" label="Description" max="500" type="textarea" style="width: 600px; height: 200px;">
						<aui:validator name="required" errorMessage="Please enter the tvshow's description" />
						<div id="counterContainer">
							<p>
								<span id="descriptionCounter"></span> character(s) remaining
							</p>
						</div>
					</aui:input>
				</aui:fieldset>
				
				<aui:script use="aui-char-counter">

			    	var titleCounter = new A.CharCounter(
						{
					        counter: '#titleCounter',
					        input: '#<portlet:namespace />title',
					        maxLength: 75
				      	}
				    );
			    	
			    	var descriptionCounter = new A.CharCounter(
						{
					        counter: '#descriptionCounter',
					        input: '#<portlet:namespace />description',
					        maxLength: 500
				      	}
				    );

				</aui:script>
			</aui:col>	
		</aui:row>
		
		<aui:row>
			<div id="season-fields">
				<div class="lfr-form-row lfr-form-row-inline">
					<div class="row-fields">
						<aui:col span="4">
							<aui:row>
								<%
									String seasonCoverBlank = renderResponse.encodeURL(renderRequest.getContextPath() + "/img/no-image.png");
								%>
								<img id="<portlet:namespace/>img" src="<%= seasonCoverBlank %>" height="100" style="max-height: 100px;">
							</aui:row>
							<aui:row>
								<aui:input name="imageTitle" type="text" readOnly="true" label="Image" title="Image"> 
									<aui:validator name="required" errorMessage="Please select the tv show's cover." />
								</aui:input>
								
								<aui:button cssClass="seasonCover" name="selectSeasonImageButton" value="Select" icon=" icon-folder-open"/>
							</aui:row>
						</aui:col>
					</div>
				</div>
			</div>
			
			<liferay-portlet:renderURL var="selectSeasonURL" portletName="<%= PortletKeys.DYNAMIC_DATA_MAPPING %>" windowState="<%= LiferayWindowState.POP_UP.toString() %>" portletMode="<%= PortletMode.VIEW.toString() %>">
				<portlet:param name="struts_action" value="/dynamic_data_mapping/select_document_library"/>
			</liferay-portlet:renderURL>
			
			<aui:script use="node-base,liferay-auto-fields,aui-base,liferay-util-window,aui-io-plugin-deprecated,aui-dialog-iframe-deprecated">
				
				//tv show cover selector
				
				var popup1 = null;
				var witchPopUp = false; // false = tv show ; true = season ;
				
				A.one('#<portlet:namespace/>selectButton').on('click', tvShowSelect);
				function tvShowSelect(event){
					
					witchPopUp = false;
					
		    		popup1 = Liferay.Util.Window.getWindow(
						{
		                    dialog: {
		                        centered: true,
		                        constrain2view: true,
		                        modal: true,
		                        resizable: true,
		                        width: 950
	                    	}
		                }
					);
		    		
		    		popup1.plug(A.Plugin.DialogIframe,
	                    {
		                    autoLoad: true,
		                    iframeCssClass: 'dialog-iframe',
		                    uri:'<%= selectTvShowURL.toString() %>'
	                    }
		    		);
		    		
	                popup1.render();
		    		
	            	popup1.show();
		            popup1.titleNode.html("Select Cover");
			    }
			

				/****************************************************************************/
			
	
				// create autofield JS Object
				var autoFields = new Liferay.AutoFields(
					{
						contentBox: '#season-fields',
						fieldIndexes: '<portlet:namespace />rowIndexes',
						sortable: true,
						sortableHandle: '.row-fields'
					}
				);
				autoFields.render();
				
				
				// some variable reference for the callback method _166_selectDocumentLibrary
				var popup2 = null;
				var seasonCoverInput = null;
				var seasonCoverImage = null;
				
				
				// attach onclicklistener to the 'select' buttons, for the purpose of the image searching in the Document and Media Library
				var contentBox = A.one('#season-fields');
				
				contentBox.delegate('click', seasonSelect, '.seasonCover');
				function seasonSelect(event){
					
					witchPopUp = true;
					
					seasonCoverInput = event.currentTarget.ancestor().one('input');
					seasonCoverImage = event.currentTarget.ancestor().ancestor().one('img');
					
					//var seasonImageInputName = event.currentTarget.ancestor().one('input').attr('name');
	
					
					popup2 = Liferay.Util.Window.getWindow(
						{
		                    dialog: {
		                        centered: true,
		                        constrain2view: true,
		                        modal: true,
		                        resizable: true,
		                        width: 950
		                   	}
		                }
					);
					
		    		popup2.plug(A.Plugin.DialogIframe,
		                {
			                autoLoad: true,
			                iframeCssClass: 'dialog-iframe',
			                uri:'<%= selectSeasonURL.toString() %>'
		                }
		    		);
		    		
		            popup2.render();
		    		
		        	popup2.show();
		            popup2.titleNode.html("Select Cover");
				}
				
				// in case of add-row action, the original autofieldrow will be cloned (there will be two entirely same row with same values), 
				//so the original row must be reinitalized (that will be the new row, in the user opinion) 
// 				contentBox.delegate('click', dootherthings, '.add-row');
// 				function dootherthings(event) {
					
// 					event.currentTarget.ancestor().ancestor().ancestor().one('img').attr('src','');
					
// 					event.currentTarget.ancestor().ancestor().ancestor().one('input').val('');
	
// 				}
				
				
				
				// hide the popup, and set the appropriate values for the html tags (with js)
				_166_selectDocumentLibrary = function(url, id, groupId, fileName, version){
					if(!witchPopUp){
						A.one("#<portlet:namespace/>imageUrl").val(url);
						A.one("#<portlet:namespace/>imageUuid").val(id);
						A.one("#<portlet:namespace/>imageTitle").val(fileName);
						A.one("#<portlet:namespace/>imageVersion").val(version);
						A.one("#<portlet:namespace/>img").attr("src", url); 
					
						/*document.getElementById("<portlet:namespace/>imageUrl").value = url;
						document.getElementById("<portlet:namespace/>imageUuid").value = id;
						document.getElementById("<portlet:namespace/>imageTitle").value = fileName;
						document.getElementById("<portlet:namespace/>imageVersion").value = version;
						document.getElementById("<portlet:namespace/>img").src = url /*+"&imageThumbnail=1"*/;
					
						popup1.hide();
						//alert(url + "\n" + id + "\n" + groupId + "\n" + fileName + "\n" + version);
					}else{
						seasonCoverInput.val(fileName);
						seasonCoverImage.attr('src', url);
						
						popup2.hide();
					}
		        }
			</aui:script>
		</aui:row>
		
		<aui:row>
			<aui:col span="12">
				<aui:button-row >
					<aui:button name="Save" type="submit" />
					<aui:button name="Cancel" type="cancel" href="<%= viewURL %>" />
				</aui:button-row>
			</aui:col>
		</aui:row>

	</aui:form>
</aui:container>