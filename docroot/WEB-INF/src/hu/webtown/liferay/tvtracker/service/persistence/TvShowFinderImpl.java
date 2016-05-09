package hu.webtown.liferay.tvtracker.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import hu.webtown.liferay.tvtracker.model.TvShow;
import hu.webtown.liferay.tvtracker.model.impl.TvShowImpl;

import java.util.List;

public class TvShowFinderImpl extends BasePersistenceImpl<TvShow> implements TvShowFinder{

	public static final String FIND_BY_PREMIERYEAR = TvShowFinder.class.getName() + ".findByPremierYear";
	public static final String FIND_BY_G_P = TvShowFinder.class.getName() + ".findByG_P";
	
	
	public List<TvShow> findByPremierYear(int premierYear, int start, int end) throws SystemException{
		
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = CustomSQLUtil.get(TvShowFinderImpl.FIND_BY_PREMIERYEAR);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.setCacheable(false);
			q.addEntity("TvT_TvShow", TvShowImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(premierYear);
			
			return (List<TvShow>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return null;
	}
	
	public List<TvShow> findByPremierYear(int premierYear) throws SystemException{
		return findByPremierYear(premierYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	public List<TvShow> findByG_P(long groupId, int premierYear, int start, int end) throws SystemException {
		
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = CustomSQLUtil.get(TvShowFinderImpl.FIND_BY_G_P);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.setCacheable(false);
			q.addEntity("TvT_TvShow", TvShowImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(premierYear);
			
			return (List<TvShow>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return null;
	}
	
	public List<TvShow> findByG_P(long groupId, int premierYear) throws SystemException{
		return findByG_P(groupId, premierYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
}
