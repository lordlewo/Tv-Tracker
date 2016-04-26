<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>


<%@ page import="hu.webtown.liferay.tvtracker.util.ActionKeys" %>
<%@ page import="hu.webtown.liferay.tvtracker.util.WebKeys" %>
<%@ page import="hu.webtown.liferay.tvtracker.util.PortletKeys" %>

<%@ page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@ page import="com.liferay.portal.service.ServiceContext"%>

<%@ page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@ page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@ page import="com.liferay.portlet.asset.model.AssetTag" %>
<%@ page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.asset.service.AssetTagLocalServiceUtil" %>


<%@ page import="hu.webtown.liferay.tvtracker.model.TvShow"%>
<%@ page import="hu.webtown.liferay.tvtracker.model.Season"%>
<%@ page import="hu.webtown.liferay.tvtracker.model.Episode"%>

<%@ page import="hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil"%>
<%@ page import="hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil"%>
<%@ page import="hu.webtown.liferay.tvtracker.service.EpisodeLocalServiceUtil"%>

<%@ page import="hu.webtown.liferay.tvtracker.service.permission.TvTrackerModelPermission" %>
<%@ page import="hu.webtown.liferay.tvtracker.service.permission.TvShowPermission" %>
<%@ page import="hu.webtown.liferay.tvtracker.service.permission.SeasonPermission" %>
<%@ page import="hu.webtown.liferay.tvtracker.service.permission.EpisodePermission" %>

<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>

<%@page import="hu.webtown.liferay.tvtracker.search.comparator.TvShowTitleComparator"%>
<%@page import="hu.webtown.liferay.tvtracker.search.comparator.TvShowPremierYearComparator"%>
<%@page import="hu.webtown.liferay.tvtracker.search.comparator.EpisodeTitleComparator"%>
<%@page import="hu.webtown.liferay.tvtracker.search.comparator.EpisodeAirDateComparator"%>
<%@ page import="hu.webtown.liferay.tvtracker.search.comparator.util.ComparatorUtil" %>


<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>

<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>

<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>

<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@ page import="java.util.*" %>

<portlet:defineObjects />
<theme:defineObjects />