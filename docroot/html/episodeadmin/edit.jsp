<%@ include file="/html/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
	
	long episodeId = ParamUtil.getLong(renderRequest, WebKeys.EPISODE_ID); // episodeId = 0 if there aren't any episodeId attribute in the reqest
	String action = ParamUtil.getString(renderRequest, "action");

	String actionUrlName = null;
	String headerName = null;
	
	Episode episode = null;
	Season selectedSeason = null;
	long selectedSeasonId = 0;
	
	if (action.equalsIgnoreCase("update")){
	
		episode = EpisodeLocalServiceUtil.getEpisode(episodeId);
		selectedSeasonId = episode.getSeasonId();
		selectedSeason = SeasonLocalServiceUtil.getSeason(selectedSeasonId, serviceContext);
		
		actionUrlName = "updateEpisode";
		headerName = "Edit Episode: " + episode.getTitle();
		
	} else {
		
		episode = null;
		selectedSeasonId = 0;
		selectedSeason = null;
		
		actionUrlName = "addEpisode";
		headerName = "Add New Episode";
	}
	
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/episodeadmin/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="<%= actionUrlName %>" var="add_edit_actionURL" />

<aui:container>
	<aui:form name="editform" action="<%= add_edit_actionURL %>" method="post">
	
		<%-- form bean --%>
		
		<aui:model-context bean="<%= episode %>" model="<%= Episode.class %>"/>
		
		
		<%-- hidden fields --%>
		
		<c:if test='<%= action.equalsIgnoreCase("update") %>'>
			<aui:input name="<%= WebKeys.EPISODE_ID %>" type="hidden" />
		</c:if>

		<aui:input name="imageUrl" type="hidden" />
		<aui:input name="imageUuid" type="hidden" />
		<aui:input name="imageVersion" type="hidden" />
	
	
		<%-- admin page header--%>
		
		<aui:row>
			<aui:col span="12">
				<liferay-ui:header backURL="<%= viewURL %>" title="<%= headerName %>"/>
			</aui:col>
		</aui:row>
	
		
		<%-- Episode cover selection --%>
		
		<aui:row style="margin: 30px 20px 0px 20px;"> 
			<aui:field-wrapper label="Cover">
				<aui:col span="4" >
					<%
						String blankImageUrl = renderResponse.encodeURL(renderRequest.getContextPath() + "/img/no-image.png");
						String imageSrc = (episode != null) ? episode.getImageUrl() : blankImageUrl;
					%>
					<img id="<portlet:namespace/>img" src="<%=imageSrc%>" />
				</aui:col>
				
				<aui:col span="5">
					<aui:input name="imageTitle" type="text" readonly="true" label="Image" title="Image"> 
						<aui:validator name="required" errorMessage="Please select episode's cover." />
					</aui:input> 
					<br/>
					<aui:button name="selectButton" value="Select" icon="icon-folder-open"/>
				</aui:col>
			</aui:field-wrapper>
		</aui:row>
	
		<%-- episode title, airdate, description filling and season choosing--%>
		
		<aui:row>
			<aui:col span="12" style="margin-bottom: 30px; margin-top: 30px; margin-left: 20px;">
				
				<aui:fieldset> 
					<div id="counterContainer">
						<aui:input name="title" type="text" title="Title" label="Title">
							<aui:validator name="required" errorMessage="Please enter the episode's name."/>
							<p><span id="titleCounter"></span> character(s) remaining</p>
						</aui:input>
					</div>
					
					<aui:input name="episodeNumber" title="Episode Number" label="Episode Number" >
						<aui:validator name="required" errorMessage="Please enter the episde's number." />
						<aui:validator name="number" errorMessage="Please enter valid episode number."/>
						<aui:validator name="min" errorMessage="Please enter a positive number." >
							'1'
						</aui:validator>
					</aui:input>
					
					<aui:input name="airDate" title="Air Date" label="Air DateTime">
						<aui:validator name="required" errorMessage="Please enter the episode's air date." />
						<aui:validator name="date" errorMessage="Please enter the episode's air date in correct format (dd/mm/yy)." />
					</aui:input>
					
					<aui:select label="Choose Season" id="seasonChoose" name="seasonId" showEmptyOption="true" required="true" >
					    <%
					    
					    	OrderByComparator orderByComparator = ComparatorUtil.getTvShowOrderByComparator("title", "asc");
					    	List<TvShow> tvShows = TvShowLocalServiceUtil.getTvShows(serviceContext, orderByComparator);
					    	
					    	for(TvShow tvShow : tvShows){
					 			
					    		long tvShowId = tvShow.getTvShowId();
					    		String tvShowTitle = tvShow.getTitle();
					    		
					    		List<Season> seasons = SeasonLocalServiceUtil.getSeasons(tvShowId, serviceContext);
					    		
					    		for(Season season : seasons){
					    			
					    			long seasonId = season.getSeasonId();
					    			String seasonTitle = season.getTitle();
					    			
					    			boolean selected = (seasonId == selectedSeasonId) ? true : false;
									
						    		StringBuffer sbLabel = new StringBuffer();
						    		sbLabel.append(tvShowTitle)
						    			.append(StringPool.SPACE)
						    			.append(StringPool.DASH)
						    			.append(StringPool.SPACE)
						    			.append(seasonTitle);
					    %>
					    
				    		<aui:option value="<%= String.valueOf(seasonId) %>" selected="<%= selected %>">
				    			"<%= sbLabel %>"
				    		</aui:option>
					    
					    <%
					    		}
					    	}
					    %>
					</aui:select>
					
					<div id="counterContainer">
						<aui:input name="description" type="textarea" title="Description" label="Description"  style="width: 600px; height: 200px;">
							<aui:validator name="required" errorMessage="Please enter the tvshow's description." />
							<p><span id="descriptionCounter"></span> character(s) remaining</p>
						</aui:input>
					</div>
				</aui:fieldset>
			</aui:col>	
		</aui:row>
		
		
		<%-- submit/cancel buttons --%>
		
		<aui:row>
			<aui:col span="12" style="margin-left: 20px;">
				<aui:button-row >
					<aui:button name="Save" type="submit" />
					<aui:button name="Cancel" type="cancel" href="<%= viewURL %>" />
				</aui:button-row>
			</aui:col>
		</aui:row>	
	</aui:form>
	
	
	<%-- portlet urls for the popup --%>
	
	<liferay-portlet:renderURL var="selectCoverURL" portletName="<%= PortletKeys.DYNAMIC_DATA_MAPPING %>" windowState="<%= LiferayWindowState.POP_UP.toString() %>" portletMode="<%= PortletMode.VIEW.toString() %>">
		<portlet:param name="struts_action" value="/dynamic_data_mapping/select_document_library"/>
	</liferay-portlet:renderURL>
	
	<aui:script use="aui-base,aui-char-counter,liferay-util-window,aui-io-plugin-deprecated,aui-dialog-iframe-deprecated">
		
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
		
		/************************** Episode Cover select ******************************/
		
		var episodeCoverSelectPopUp = null;
		
		A.one('#<portlet:namespace/>selectButton').on('click', episodeSelect);
		function episodeSelect(event){
			
			episodeCoverSelectPopUp = createLiferayPopUp();
			episodeCoverSelectPopUp.render();
			episodeCoverSelectPopUp.show();
			episodeCoverSelectPopUp.titleNode.html("Select Episode Cover");
	    }
		
		/******************* Callback function for Cover selection ********************/
		
		// set the appropriate values for the html tags (with js) and hide the popup
		_166_selectDocumentLibrary = function(url, id, groupId, fileName, version){
			
			A.one("#<portlet:namespace/>imageUrl").val(url);
			A.one("#<portlet:namespace/>imageUuid").val(id);
			A.one("#<portlet:namespace/>imageTitle").val(fileName);
			A.one("#<portlet:namespace/>imageVersion").val(version);
			A.one("#<portlet:namespace/>img").attr("src", url); 
		
			episodeCoverSelectPopUp.hide();
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
	
	</aui:script>
	
</aui:container>