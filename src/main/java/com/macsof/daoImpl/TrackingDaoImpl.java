package com.macsof.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.macsof.constants.Constants;
import com.macsof.dao.TrackingDao;
import com.macsof.domain.Customer;
import com.macsof.domain.Tracking;
import com.macsof.ui.WelcomResult;

@Repository
public class TrackingDaoImpl extends AbstractDaoImpl<Tracking, Integer> implements TrackingDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(TrackingDaoImpl.class);
	public TrackingDaoImpl() {
		super(Tracking.class);
	
	}

	public List<WelcomResult> getWelcomeResult(int from, String status) {
		String sql="SELECT c.`CUSTOMER_ID` as customerId,c.`CNAME` as cname ,c.`PHONE` as phone,c.`ENQUIRY_FOR` as enqFor,c.`ENQ_CODE` as enqCode,c.`DEMO` as demo, t3.`FOLLOW_UP_DATE` as followUp,t3.`NOTE` as note FROM `customer` c, (SELECT t1.* FROM `tracking` t1" +
				" JOIN ( SELECT `CUSTOMER`, MAX(`TRACK_ID`) AS MAXDATE  FROM `tracking` GROUP BY `CUSTOMER`) t2 ON T1.`CUSTOMER` = t2.`CUSTOMER` AND t1.`TRACK_ID` = t2.MAXDATE)t3 WHERE c.`CUSTOMER_ID`=t3.`CUSTOMER` AND t3.`STATUS`=:status order by t3.`FOLLOW_UP_DATE` ";
		if(Constants.STATUS_PENDING.equals(status))
			sql=sql+"ASC";
		if(Constants.STATUS_CLOSED.equals(status))
			sql=sql+"DESC";
		
		if(Constants.STATUS_REJECTED.equals(status))
			sql=sql+"DESC";
		
		Query qry=getCurrentSession().createSQLQuery(sql);
		qry.setParameter("status", status);
		qry.setFirstResult(from*Constants.RESULTS_PER_PAGE);
		qry.setMaxResults(Constants.RESULTS_PER_PAGE);
		LOGGER.debug("RESULT TYPE :"+status);
		LOGGER.debug("FORM : "+from*Constants.RESULTS_PER_PAGE);
		LOGGER.debug("Max : "+Constants.RESULTS_PER_PAGE);
		return (List<WelcomResult>) excuteQuery(qry, WelcomResult.class);
		
	}

	

}
