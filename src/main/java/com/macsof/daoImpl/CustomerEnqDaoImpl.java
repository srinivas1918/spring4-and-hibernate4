package com.macsof.daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.macsof.constants.Constants;
import com.macsof.dao.CustomerEnqDao;
import com.macsof.domain.Complaint;
import com.macsof.domain.Customer;
import com.macsof.ui.SearchResults;
import com.macsof.ui.WelcomResult;

@Repository
public class CustomerEnqDaoImpl extends AbstractDaoImpl<Customer, Integer> implements CustomerEnqDao {

	public CustomerEnqDaoImpl() {
		super(Customer.class);
	}

	public List<SearchResults> getSearchResults(String cname, String phone, int from) {
		
		String sql="SELECT c.`CUSTOMER_ID` AS cusId,c.`CNAME` AS cname,c.`PHONE` AS phone,c.`ENQUIRY_FOR` AS enqFor, c.`ENQ_CODE` AS enqCode,t.`FOLLOW_UP_DATE` AS"+ 
					" closedDate  FROM customer c JOIN tracking t ON t.`CUSTOMER`=c.`CUSTOMER_ID` AND t.`STATUS`='2' JOIN installation i ON i.`CUSTOMER_ID`=c.`CUSTOMER_ID` AND "+ 
					"i.`STATUS`='2' WHERE c.`CNAME` LIKE :cname AND phone LIKE :phone order by t.`FOLLOW_UP_DATE` ASC";
		
		Query qry=getCurrentSession().createSQLQuery(sql);
		qry.setParameter("cname", "%"+cname+"%");
		qry.setParameter("phone", "%"+phone+"%");
		qry.setFirstResult(from*Constants.RESULTS_PER_PAGE);
		qry.setMaxResults(Constants.RESULTS_PER_PAGE);
		return (List<SearchResults>) excuteQuery(qry, SearchResults.class);
	}

	public List<Complaint> getComplaintHistory(int cusId) {
		Query qry=getCurrentSession().createQuery("from Complaint c where c.customerId=:cusId");
		qry.setParameter("cusId", cusId);
		return qry.list();
	}

	public List<WelcomResult> getEnqSearchResults(String cname, String phone,
			int from) {
		String sql="SELECT c.`CUSTOMER_ID` as customerId,c.`CNAME` as cname ,c.`PHONE` as phone,c.`ENQUIRY_FOR` AS enqFor,c.`ENQ_CODE` as enqCode,c.`DEMO` as demo, t3.`FOLLOW_UP_DATE` as followUp,t3.`NOTE` as note,t3.`STATUS` AS status FROM `customer` c, (SELECT t1.* FROM `tracking` t1" +
				" JOIN ( SELECT `CUSTOMER`, MAX(`TRACK_ID`) AS MAXDATE  FROM `tracking` GROUP BY `CUSTOMER`) t2 ON T1.`CUSTOMER` = t2.`CUSTOMER` AND t1.`TRACK_ID` = t2.MAXDATE)t3 WHERE c.`CUSTOMER_ID`=t3.`CUSTOMER` AND c.`CNAME` LIKE :cname AND phone LIKE :phone order by t3.`FOLLOW_UP_DATE` ";
		Query qry=getCurrentSession().createSQLQuery(sql);
		qry.setParameter("cname", "%"+cname+"%");
		qry.setParameter("phone", "%"+phone+"%");
		qry.setFirstResult(from*Constants.RESULTS_PER_PAGE);
		qry.setMaxResults(Constants.RESULTS_PER_PAGE);
		return (List<WelcomResult>) excuteQuery(qry, WelcomResult.class);
	}

	public List<WelcomResult> getReports(Date from, Date to, int pageNo) {
		String sql="SELECT c.`CUSTOMER_ID` as customerId,c.`CNAME` as cname ,c.`PHONE` as phone,c.`ENQUIRY_FOR` AS enqFor,c.`ENQ_CODE` as enqCode,c.`DEMO` as demo, t3.`FOLLOW_UP_DATE` as followUp,t3.`NOTE` as note,t3.`STATUS` AS status FROM `customer` c, (SELECT t1.* FROM `tracking` t1" +
				" JOIN ( SELECT `CUSTOMER`, MAX(`TRACK_ID`) AS MAXDATE  FROM `tracking` GROUP BY `CUSTOMER`) t2 ON T1.`CUSTOMER` = t2.`CUSTOMER` AND t1.`TRACK_ID` = t2.MAXDATE)t3 WHERE c.`CUSTOMER_ID`=t3.`CUSTOMER` AND  t3.FOLLOW_UP_DATE between :from and :to  order by t3.`FOLLOW_UP_DATE` ";
		Query qry=getCurrentSession().createSQLQuery(sql);
		qry.setParameter("from", from);
		qry.setParameter("to", to);
		qry.setFirstResult(pageNo*Constants.RESULTS_PER_PAGE);
		qry.setMaxResults(Constants.RESULTS_PER_PAGE);
		return (List<WelcomResult>) excuteQuery(qry, WelcomResult.class);
	}

	public Object getCountOfReports(int status,Date from, Date to) {
		String sql="SELECT count(*) FROM `customer` c, (SELECT t1.* FROM `tracking` t1" +
				" JOIN ( SELECT `CUSTOMER`, MAX(`TRACK_ID`) AS MAXDATE  FROM `tracking` GROUP BY `CUSTOMER`) t2 ON T1.`CUSTOMER` = t2.`CUSTOMER` AND t1.`TRACK_ID` = t2.MAXDATE)t3 WHERE c.`CUSTOMER_ID`=t3.`CUSTOMER` AND t3.`STATUS`=:status AND  t3.FOLLOW_UP_DATE between :from and :to  order by t3.`FOLLOW_UP_DATE` ";
		Query qry=getCurrentSession().createSQLQuery(sql);
		qry.setParameter("status", status);
		qry.setParameter("from", from);
		qry.setParameter("to", to);
		return  qry.uniqueResult();
	}

}
