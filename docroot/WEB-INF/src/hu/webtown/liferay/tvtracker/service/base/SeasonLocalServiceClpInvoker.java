/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package hu.webtown.liferay.tvtracker.service.base;

import hu.webtown.liferay.tvtracker.service.SeasonLocalServiceUtil;

import java.util.Arrays;

/**
 * @author czeni
 * @generated
 */
public class SeasonLocalServiceClpInvoker {
	public SeasonLocalServiceClpInvoker() {
		_methodName0 = "addSeason";

		_methodParameterTypes0 = new String[] {
				"hu.webtown.liferay.tvtracker.model.Season"
			};

		_methodName1 = "createSeason";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSeason";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSeason";

		_methodParameterTypes3 = new String[] {
				"hu.webtown.liferay.tvtracker.model.Season"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchSeason";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSeason";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSeasons";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSeasonsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSeason";

		_methodParameterTypes15 = new String[] {
				"hu.webtown.liferay.tvtracker.model.Season"
			};

		_methodName58 = "getBeanIdentifier";

		_methodParameterTypes58 = new String[] {  };

		_methodName59 = "setBeanIdentifier";

		_methodParameterTypes59 = new String[] { "java.lang.String" };

		_methodName64 = "getSeason";

		_methodParameterTypes64 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName65 = "getSeasons";

		_methodParameterTypes65 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName66 = "getSeasons";

		_methodParameterTypes66 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName67 = "getSeasons";

		_methodParameterTypes67 = new String[] {
				"com.liferay.portal.service.ServiceContext", "int", "int"
			};

		_methodName68 = "getSeasons";

		_methodParameterTypes68 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext", "int",
				"int"
			};

		_methodName69 = "getSeasons";

		_methodParameterTypes69 = new String[] {
				"com.liferay.portal.service.ServiceContext",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName70 = "getSeasons";

		_methodParameterTypes70 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName71 = "getSeasons";

		_methodParameterTypes71 = new String[] {
				"com.liferay.portal.service.ServiceContext", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName72 = "getSeasons";

		_methodParameterTypes72 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName73 = "getSeasonsCount";

		_methodParameterTypes73 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName74 = "getSeasonsCount";

		_methodParameterTypes74 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName75 = "addSeason";

		_methodParameterTypes75 = new String[] {
				"long", "java.lang.String", "java.util.Date", "int",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName76 = "updateSeason";

		_methodParameterTypes76 = new String[] {
				"long", "long", "java.lang.String", "java.util.Date", "int",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName77 = "deleteSeason";

		_methodParameterTypes77 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SeasonLocalServiceUtil.addSeason((hu.webtown.liferay.tvtracker.model.Season)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SeasonLocalServiceUtil.createSeason(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SeasonLocalServiceUtil.deleteSeason(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SeasonLocalServiceUtil.deleteSeason((hu.webtown.liferay.tvtracker.model.Season)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SeasonLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SeasonLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SeasonLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SeasonLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SeasonLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SeasonLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SeasonLocalServiceUtil.fetchSeason(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeason(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SeasonLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasons(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasonsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SeasonLocalServiceUtil.updateSeason((hu.webtown.liferay.tvtracker.model.Season)arguments[0]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SeasonLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			SeasonLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeason(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasons((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasons(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasons((com.liferay.portal.service.ServiceContext)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasons(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasons((com.liferay.portal.service.ServiceContext)arguments[0],
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[1]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasons(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1],
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasons((com.liferay.portal.service.ServiceContext)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasons(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasonsCount((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return SeasonLocalServiceUtil.getSeasonsCount(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return SeasonLocalServiceUtil.addSeason(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				((Integer)arguments[3]).intValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8],
				(com.liferay.portal.service.ServiceContext)arguments[9]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return SeasonLocalServiceUtil.updateSeason(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Integer)arguments[4]).intValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(com.liferay.portal.service.ServiceContext)arguments[10]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return SeasonLocalServiceUtil.deleteSeason(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
}