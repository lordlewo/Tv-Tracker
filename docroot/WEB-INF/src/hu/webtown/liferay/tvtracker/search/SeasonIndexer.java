package hu.webtown.liferay.tvtracker.search;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.tvtracker.model.Season;
import hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil;
import hu.webtown.liferay.tvtracker.service.permission.SeasonPermission;
import hu.webtown.liferay.tvtracker.service.persistence.SeasonActionableDynamicQuery;
import hu.webtown.liferay.tvtracker.util.ActionKeys;
import hu.webtown.liferay.tvtracker.util.PortletKeys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

public class SeasonIndexer extends BaseIndexer{

	// declare the class names and the portlet identifier for the consistent using everywhere
	
	private static final String[] CLASS_NAMES = { Season.class.getName()};
	
	private static final String PORTLET_ID = PortletKeys.TVSHOW_ADMIN;
	
	
	public SeasonIndexer() {
		
		// enable filtering by permission and scope
		
		boolean permissionAware = true;
		
		this.setPermissionAware(permissionAware);
	}
	
	@Override
	public String[] getClassNames() {
		
		return SeasonIndexer.CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		
		return SeasonIndexer.PORTLET_ID;
	}
	
	@Override
	protected String getPortletId(SearchContext searchContext) {
		
		return SeasonIndexer.PORTLET_ID;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, String actionId) throws Exception {
		
		String view_actionId = ActionKeys.VIEW;
		
		
		// check if owning the nessesery permission (VIEW) 
		
		boolean hasPermission = SeasonPermission.contains(permissionChecker, entryClassPK, view_actionId);
		
		
		return hasPermission;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		
		// prepare and unbox the nessesery params
		
		Season season = (Season) obj;
		
		long companyId = season.getCompanyId();
		long seasonId = season.getSeasonId();
		

		// delete the document corresponding to the 'obj' entity
		
		deleteDocument(companyId, seasonId);
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		
		// prepare some parameter for the document that will be indexed
		
		Season season = (Season) obj;
		
		long scopeGroupId = season.getGroupId();
		long groupId = getSiteGroupId(scopeGroupId);
		Date createDate = season.getCreateDate();
		Date modifiedDate = season.getModifiedDate();
		
		String title = season.getTitle();
		Date premierDate = season.getPremierDate();
		String description = season.getDescription();
		
		
		// create the correspondig document to the entity, and fill up with the earlier produced params
		
		Document document = getBaseModelDocument(SeasonIndexer.PORTLET_ID, season);
		
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		
		document.addDate(Field.CREATE_DATE, createDate);
		document.addDate(Field.MODIFIED_DATE, modifiedDate);
		
		document.addText(Field.TITLE, title);
		document.addDate(Field.DESCRIPTION, premierDate);
		document.addText(Field.CONTENT, description);
	
		
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) throws Exception {

		// prepare and unbox the nessesery params
		
		int maxContentLength = 200;
		
		
		// create summary
		
		Summary summary = createSummary(document);
		
		summary.setMaxContentLength(maxContentLength);
		
		
		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		
		// prepare and unbox the nessesery params
		
		Season season = (Season) obj;
		
		String searchEngineId = getSearchEngineId();
		long companyId = season.getCompanyId();
		boolean commitImmediately = true;
		
		// get the corresponding document
		
		Document document = getDocument(season);
		
		
		// update the index
		
		SearchEngineUtil.updateDocument(searchEngineId, companyId, document, commitImmediately);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		
		// prepare and unbox the nessesery params
		
		Season season = SeasonLocalServiceUtil.getSeason(classPK);
		
		
		// call the prev method
		
		doReindex(season);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		
		// prepare and unbox the nessesery params
		
		long companyId = GetterUtil.getLong(ids[0]);
		
		
		// call the logic
		
		reindexSeasonEntries(companyId);
	}
	
	protected void reindexSeasonEntries(long companyId) throws SystemException, PortalException {
		
		// prepare and unbox the nessesery params
		
		String searchEngineId = getSearchEngineId();
		boolean commitImmediately = true;
		final List<Document> documents = new ArrayList<Document>();
		
		
		// get the entities from the database and get the corresponding 'document' objects 
		
		ActionableDynamicQuery actionableDynamicQuery = new SeasonActionableDynamicQuery() {
			
			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				
				Season season = (Season) object;
				
				Document document = getDocument(season);
				
				documents.add(document);
			}
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		
		actionableDynamicQuery.performActions();
		
		
		// update the index
		
		SearchEngineUtil.updateDocuments(searchEngineId, companyId, documents, commitImmediately);
	}

}
