package com.macsof.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.macsof.constants.Constants;
import com.macsof.dao.InstallationDao;
import com.macsof.domain.Installation;
import com.macsof.ui.CustomerInstallDetails;
import com.macsof.ui.InstallDetails;

@Repository
public class InstallationDaoImpl extends AbstractDaoImpl<Installation, Integer> implements InstallationDao{

	public InstallationDaoImpl() {
		super(Installation.class);
		// TODO Auto-generated constructor stub
	}

	public List<CustomerInstallDetails> getInstallationDetails(int installationId) {
		// TODO Auto-generated method stub
		Query qry=getCurrentSession().createSQLQuery("SELECT i.`INSTALLATION_ID` AS installId,c.`CNAME` AS cname,c.`PHONE` AS phone," +
				"c.`ENQ_CODE` AS enqId,i.`TECHNICIAN` AS name,i.`INSTALLATION_DATE` AS date,i.`STATUS` AS status,c.`ADDRESS` AS address,i.`NOTE` AS note FROM customer c" +
				" JOIN  installation i ON i.`CUSTOMER_ID`=c.`CUSTOMER_ID` WHERE i.`INSTALLATION_ID`=:installationId");
		qry.setParameter("installationId", installationId);
		return (List<CustomerInstallDetails>) excuteQuery(qry, CustomerInstallDetails.class);
	}

	public List<CustomerInstallDetails> getPendingInstalls(int from, String status) {
		Query qry=getCurrentSession().createSQLQuery("SELECT i.`CUSTOMER_ID` AS cusId,i.`INSTALLATION_ID` AS installId,c.`CNAME` AS cname,c.`PHONE` AS phone," +
				"c.`ENQ_CODE` AS enqId,i.`TECHNICIAN` AS name,i.`INSTALLATION_DATE` AS date,i.`STATUS` AS status,c.`ADDRESS` AS address,i.`NOTE` AS note  FROM installation i join  customer c  on i.CUSTOMER_ID=c.CUSTOMER_ID" +
				" where i.STATUS=:status order by i.`INSTALLATION_DATE` asc");
		qry.setFirstResult(from*Constants.RESULTS_PER_PAGE);
		qry.setMaxResults(Constants.RESULTS_PER_PAGE);
		qry.setParameter("status", status);
		return (List<CustomerInstallDetails>) excuteQuery(qry, CustomerInstallDetails.class);
	}

}
