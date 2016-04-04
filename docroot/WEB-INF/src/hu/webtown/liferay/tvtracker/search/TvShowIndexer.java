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

import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil;
import hu.webtown.liferay.tvtracker.service.permission.TvShowPermission;
import hu.webtown.liferay.tvtracker.service.persistence.TvShowActionableDynamicQuery;
import hu.webtown.liferay.tvtracker.util.ActionKeys;
import hu.webtown.liferay.tvtracker.util.PortletKeys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

public class TvShowIndexer extends BaseIndexer {
	
	// declare the class names and the portlet identifier for the consistent using everywhere
	
	private static final String[] CLASS_NAMES = { TvShow.class.getName()};
	
	private static final String PORTLET_ID = PortletKeys.TVSHOW_ADMIN;

	
	public TvShowIndexer() {
		
		// enable filtering by permission and scope
		
		boolean permissionAware = true;
		
		this.setPermissionAware(permissionAware);
	}
	
	@Override
	public String[] getClassNames() {
		
		return TvShowIndexer.CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		
		return TvShowIndexer.PORTLET_ID;
	}
	
	@Override
	protected String getPortletId(SearchContext searchContext) {
		
		return TvShowIndexer.PORTLET_ID;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, String actionId) throws Exception {
		
		String view_actionId = ActionKeys.VIEW;
		
		
		// check if owning the necessary permission (VIEW) 
		
		boolean hasPermission = TvShowPermission.contains(permissionChecker, entryClassPK, view_actionId);
		
		
		return hasPermission;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		
		// prepare and unbox the necessary params
		
		TvShow tvShow = (TvShow) obj;
		
		long companyId = tvShow.getCompanyId();
		long tvShowId = tvShow.getTvShowId();
		
		
		// delete the document corresponding to the 'obj' entity
		
		deleteDocument(companyId, tvShowId);
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		
		// prepare some parameter for the document that will be indexed
		
		TvShow tvShow = (TvShow) obj;
		
		long scopeGroupId = tvShow.getGroupId();
		long groupId = getSiteGroupId(scopeGroupId);
		Date createDate = tvShow.getCreateDate(); 
		Date modifiedDate = tvShow.getModifiedDate();
		
		String title = tvShow.getTitle();
		Date premierDate = tvShow.getPremierDate();
		long premierYear = tvShow.getPremierYear();
		String description = tvShow.getDescription();
		
		
		// create the correspondig document to the entity, and fill up with the earlier produced params
		
		Document document = getBaseModelDocument(TvShowIndexer.PORTLET_ID, tvShow);
		
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		
		document.addDate(Field.CREATE_DATE, createDate);
		document.addDate(Field.MODIFIED_DATE, modifiedDate);
		
		document.addText(Field.TITLE, title);
		document.addDate("premierDate", premierDate);
		document.addNumber(Field.DESCRIPTION, premierYear);
		document.addText(Field.CONTENT, description);
		
		
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) throws Exception {
		
		// prepare and unbox the necessary params
		
		int maxContentLength = 200;
		
		
		// create summary
		
		Summary summary = createSummary(document);
		
		summary.setMaxContentLength(maxContentLength);
		
		
		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		
		// prepare and unbox the necessary params
		
		TvShow tvShow = (TvShow) obj;
		
		String searchEngineId = getSearchEngineId();
		long companyId = tvShow.getCompanyId();
		boolean commitImmediately = true;
		
		
		// get the corresponding document
		
		Document document = getDocument(tvShow);
		
		
		// update the index
		
		SearchEngineUtil.updateDocument(searchEngineId, companyId, document, commitImmediately);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		
		// prepare and unbox the necessary params
		
		TvShow tvShow = TvShowLocalServiceUtil.getTvShow(classPK);
		
		
		// call the prev method
		
		doReindex(tvShow);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		
		// prepare and unbox the necessary params
		
		long companyId = GetterUtil.getLong(ids[0]);
		
		
		// call the logic
		
		reindexTvShowEntries(companyId);
	}
	
	protected void reindexTvShowEntries(long companyId) throws SystemException, PortalException {
		
		// prepare and unbox the necessary params
		
		String searchEngineId = getSearchEngineId();
		boolean commitImmediately = true;
		final List<Document> documents = new ArrayList<Document>();
		
		
		// get the entities from the database and get the corresponding 'document' objects 
		
		ActionableDynamicQuery actionableDynamicQuery = new TvShowActionableDynamicQuery() {
			
			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				
				TvShow tvShow = (TvShow) object;
				
				Document document = getDocument(tvShow);
				
				documents.add(document);
			}
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		
		actionableDynamicQuery.performActions();
		
		
		// update the index
		
		SearchEngineUtil.updateDocuments(searchEngineId, companyId, documents, commitImmediately);
	}
}
