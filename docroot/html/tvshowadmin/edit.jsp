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
		
		<aui:row style="margin-bottom: 100px;"> 
			<aui:field-wrapper label="Cover" >
				<aui:col span="1">

					<liferay-portlet:renderURL var="selectURL" portletName="<%= PortletKeys.DYNAMIC_DATA_MAPPING %>" windowState="<%= LiferayWindowState.POP_UP.toString() %>" >
						<portlet:param name="struts_action" value="/dynamic_data_mapping/select_document_library"/>
					</liferay-portlet:renderURL>
					
					<aui:button name="selectButton" value="Select" icon=" icon-folder-open" />


					<aui:script use="aui-base,liferay-util-window,aui-io-plugin-deprecated,aui-dialog-iframe-deprecated">
						
						A.one('#<portlet:namespace/>selectButton').on('click', onClick);
						
						var popup = null;
						
						function onClick(event){
							
				    		popup = Liferay.Util.Window.getWindow(
									{
					                    dialog: {
					                        centered: true,
					                        constrain2view: true,
					                        modal: true,
					                        resizable: true,
					                        width: 950
				                    	}
					                });
				    		popup.plug(A.Plugin.DialogIframe,
				                    {
					                    autoLoad: true,
					                    iframeCssClass: 'dialog-iframe',
					                    uri:'<%= selectURL.toString() %>'
				                    });
			                popup.render();
				    		
			            	popup.show();
				            popup.titleNode.html("Select Cover");
					    }
						
						_166_selectDocumentLibrary = function(url, id, groupId, fileName, version){
							
							document.getElementById("<portlet:namespace/>imageUrl").value = url;
							document.getElementById("<portlet:namespace/>imageUuid").value = id;
							document.getElementById("<portlet:namespace/>imageTitle").value = fileName;
							document.getElementById("<portlet:namespace/>imageVersion").value = version;
							document.getElementById("<portlet:namespace/>img").src = url+"&imageThumbnail=1";
							
							popup.hide();
							//alert(url + "\n" + id + "\n" + groupId + "\n" + fileName + "\n" + version);
	                       }  
					</aui:script>
				
				</aui:col>
				<aui:col span="2">
					<aui:input name="imageTitle" type="text" readonly="true" label=""/>
				</aui:col>
				<aui:col span="6">
					<%
						String imageSrc = (tvShow != null) ? tvShow.getImageUrl() + "&imageThumbnail=1" : StringPool.BLANK;
					%>
					
					<img id="<portlet:namespace/>img" src="<%= imageSrc%>" />
					
				</aui:col>
			</aui:field-wrapper>
		</aui:row>
		
		<aui:row>
			<aui:col span="12">	
				<aui:fieldset >
					<aui:input name="title" title="Title" label="Title"></aui:input>
					
					<aui:input name="premierDate" title="Premier Date" label="Premier Date"></aui:input>
					
					<aui:input name="description" title="Description" label="Description" type="textarea" style="width: 400px; height: 100px;"></aui:input>
				</aui:fieldset>
			</aui:col>	
		</aui:row>
	</aui:form>
		

</aui:container>