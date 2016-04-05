<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="hu.webtown.liferay.tvtracker.util.ActionKeys" %>
<%@ page import="hu.webtown.liferay.tvtracker.util.WebKeys" %>
<%@ page import="hu.webtown.liferay.tvtracker.util.PortletKeys" %>

<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>

<%@page import="hu.webtown.liferay.tvtracker.model.TvShow"%>
<%@page import="hu.webtown.liferay.tvtracker.model.Season"%>
<%@page import="hu.webtown.liferay.tvtracker.model.Episode"%>

<%@page import="hu.webtown.liferay.tvtracker.service.TvShowLocalServiceUtil"%>
<%@page import="hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil"%>
<%@page import="hu.webtown.liferay.tvtracker.service.EpisodeLocalServiceUtil"%>

<%@ page import="hu.webtown.liferay.tvtracker.service.permission.TvTrackerModelPermission" %>
<%@ page import="hu.webtown.liferay.tvtracker.service.permission.TvShowPermission" %>
<%@ page import="hu.webtown.liferay.tvtracker.service.permission.SeasonPermission" %>
<%@ page import="hu.webtown.liferay.tvtracker.service.permission.EpisodePermission" %>

<%@ page import="java.util.*" %>

<portlet:defineObjects />
<theme:defineObjects />