package com.macsof.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.macsof.action.WelcomeAction;
import com.macsof.constants.Constants;
import com.macsof.dao.ComplaintDao;
import com.macsof.domain.Complaint;
import com.macsof.ui.CustomerInstallDetails;

@Repository
public class ComplaintDaoImpl extends AbstractDaoImpl<Complaint, Integer> implements ComplaintDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintDaoImpl.class);
	public ComplaintDaoImpl() {
		super(Complaint.class);
	}

	public List<CustomerInstallDetails> getComplaintDetails(String status,
			int from) {
		String sql="select c1.CNAME as cname, c1.PHONE as phone, c1.`ENQUIRY_FOR` AS enqFor,c1.ENQ_CODE as enqId, c2.COMPLAINT_ID as installId,"+ 
					"c2.TECHNICIAN as name, c2.REPLACE_PARTS as note,c2.COMPLAINT_DATE as date,c2.CLOSED_DATE as cDate, c2.CUSTOMER_ID as cusId"+ 
					" from customer c1 join complaint c2 ON c1.CUSTOMER_ID = c2.CUSTOMER_ID where c2.STATUS = :status order by c2.COMPLAINT_DATE asc,c2.CLOSED_DATE desc ";	
		
		Query qry=getCurrentSession().createSQLQuery(sql);
		LOGGER.debug("STATUS :"+status);
		qry.setParameter("status", status);
		qry.setFirstResult(from*Constants.RESULTS_PER_PAGE);
		qry.setMaxResults(Constants.RESULTS_PER_PAGE);
		
		return (List<CustomerInstallDetails>) excuteQuery(qry, CustomerInstallDetails.class);
	}

	public int findComplaintStatus(int cusId, String status) {
		Query qry=getCurrentSession().createQuery("select count(*) from Complaint c where c.customerId=:cusId and (c.status=:status1 or c.status=:status2)");
		qry.setParameter("cusId", cusId);
		qry.setParameter("status1", "1");
		qry.setParameter("status2", "2");
		
		return Integer.parseInt(qry.uniqueResult().toString());
	}

}
