package hu.webtown.liferay.tvtracker.search;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.permission.PermissionChecker;

import hu.webtown.liferay.tvtracker.model.Episode;
import hu.webtown.liferay.tvtracker.service.EpisodeLocalServiceUtil;
import hu.webtown.liferay.tvtracker.service.permission.SeasonPermission;
import hu.webtown.liferay.tvtracker.service.persistence.EpisodeActionableDynamicQuery;
import hu.webtown.liferay.tvtracker.util.ActionKeys;
import hu.webtown.liferay.tvtracker.util.PortletKeys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

public class EpisodeIndexer extends BaseIndexer {

	// declare the class names and the portlet identifier for the consistent using everywhere
	
	private static final String[] CLASS_NAMES = { Episode.class.getName() };
	
	private static final String PORTLET_ID = PortletKeys.EPISODE_ADMIN;
	
	
	public EpisodeIndexer() {
		
		// enable filtering by permission and scope
		
		boolean permissionAware = true;
		
		this.setPermissionAware(permissionAware);
	}
	
	@Override
	public String[] getClassNames() {
		
		return EpisodeIndexer.CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		
		return EpisodeIndexer.PORTLET_ID;
	}
	
	@Override
	protected String getPortletId(SearchContext searchContext) {
		
		return EpisodeIndexer.PORTLET_ID;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, String actionId) throws Exception {
		
		String view_actionId = ActionKeys.VIEW;
		
		
		// check if owning the necessary permission (VIEW) 

		boolean hasPermission = SeasonPermission.contains(permissionChecker, entryClassPK, view_actionId);
		
		
		return hasPermission;
		
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		
		// prepare and unbox the necessary params
		
		Episode episode = (Episode) obj;
		
		long companyId = episode.getCompanyId();
		long episodeId = episode.getEpisodeId();
		

		// delete the document corresponding to the 'obj' entity
		
		deleteDocument(companyId, episodeId);
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		
		// prepare some parameter for the document that will be indexed
		
		Episode episode = (Episode) obj;
		
		long scopeGroupId = episode.getGroupId();
		long groupId = getSiteGroupId(scopeGroupId);
		Date createDate = episode.getCreateDate();
		Date modifiedDate = episode.getModifiedDate();
		
		String title = episode.getTitle();
		Date airDate = episode.getAirDate();
		String description = episode.getDescription();
		

		// create the correspondig document to the entity, and fill up with the earlier produced params
		
		Document document = getBaseModelDocument(EpisodeIndexer.PORTLET_ID, episode);
		
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		
		document.addDate(Field.CREATE_DATE, createDate);
		document.addDate(Field.MODIFIED_DATE, modifiedDate);
		
		document.addText(Field.TITLE, title);
		document.addDate(Field.DESCRIPTION, airDate);
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
		
		Episode episode = (Episode) obj;
		
		String searchEngineId = getSearchEngineId();
		long companyId = episode.getCompanyId();
		boolean commitImmediately = true;
		
		// get the corresponding document
		
		Document document = getDocument(episode);
		
		
		// update the index
		
		SearchEngineUtil.updateDocument(searchEngineId, companyId, document, commitImmediately);
		
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		
		// prepare and unbox the necessary params
		
		Episode episode = EpisodeLocalServiceUtil.getEpisode(classPK);
		
		
		// call the prev method
		
		doReindex(episode);
		
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		
		// prepare and unbox the necessary params
		
		long companyId = GetterUtil.getLong(ids[0]);
		
		
		// call the logic
		
		reindexEpisodeEntries(companyId);
	}
	
	protected void reindexEpisodeEntries(long companyId) throws SystemException, PortalException {
		
		// prepare and unbox the necessary params
		
		String searchEngineId = getSearchEngineId();
		boolean commitImmediately = true;
		final List<Document> documents = new ArrayList<Document>();
		
		
		// get the entities from the database and get the corresponding 'document' objects 
		
		ActionableDynamicQuery actionableDynamicQuery = new EpisodeActionableDynamicQuery() {
			
			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				
				Episode episode = (Episode) object;
				
				Document document = getDocument(episode);
				
				documents.add(document);
			}
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		
		actionableDynamicQuery.performActions();
		
		
		SearchEngineUtil.updateDocuments(searchEngineId, companyId, documents, commitImmediately);
	}
	
	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext) throws Exception {
		super.postProcessSearchQuery(searchQuery, searchContext);
		
		
	}
}
