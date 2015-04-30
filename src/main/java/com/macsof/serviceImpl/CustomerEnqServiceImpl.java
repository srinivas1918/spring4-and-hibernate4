package com.macsof.serviceImpl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macsof.dao.ComplaintDao;
import com.macsof.dao.CustomerEnqDao;
import com.macsof.dao.InstallationDao;
import com.macsof.dao.TrackingDao;
import com.macsof.domain.Complaint;
import com.macsof.domain.Customer;
import com.macsof.domain.Installation;
import com.macsof.domain.Tracking;
import com.macsof.service.CustomerEnqService;
import com.macsof.ui.CustomerInstallDetails;
import com.macsof.ui.SearchResults;
import com.macsof.ui.WelcomResult;

@Service
public class CustomerEnqServiceImpl implements CustomerEnqService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomerEnqServiceImpl.class);

	@Autowired
	private CustomerEnqDao customerEnqDao;

	@Autowired
	private TrackingDao trackingDao;

	@Autowired
	private InstallationDao installationDao;

	@Autowired
	private ComplaintDao complaintDao;

	public void saveTracking(Tracking tracking) {
		trackingDao.saveOrupdate(tracking);
	}

	public List<WelcomResult> getWelcomeResult(int from, String status) {
		return trackingDao.getWelcomeResult(from, status);
	}

	public Customer getCustomer(int cusId) {
		return customerEnqDao.get(cusId);
	}

	public List<CustomerInstallDetails> getInstallationDetails(
			int installationId) {
		return installationDao.getInstallationDetails(installationId);
	}

	public void saveInstallationInfo(Installation installation) {
		installationDao.saveOrupdate(installation);
	}

	public List<CustomerInstallDetails> getPendingInstalls(int from,
			String status) {
		return installationDao.getPendingInstalls(from, status);

	}

	public Installation getInstallation(int installId) {

		return installationDao.get(installId);
	}

	public void updateInstallation(Installation installation) {
		installationDao.saveOrupdate(installation);
	}

	public List<SearchResults> getSearchResults(String cname, String phone,
			int from) {
		return customerEnqDao.getSearchResults(cname, phone, from);
	}

	public List<Complaint> getComplaintHistory(int cusId) {
		return customerEnqDao.getComplaintHistory(cusId);
	}

	public void saveComplaint(Complaint complaint) {
		complaintDao.saveOrupdate(complaint);
	}

	public List<CustomerInstallDetails> getComplaintDetails(String status,
			int from) {
		
		return complaintDao.getComplaintDetails(status, from);
	}

	public Complaint getComplaint(int complaintId) {
		return complaintDao.get(complaintId);
	}

	public int findComplaintStatus(int cusId, String status) {
		return complaintDao.findComplaintStatus(cusId, status);
	}

	public List<WelcomResult> getEnqSearchResults(String cname, String phone,
			int from) {
		return customerEnqDao.getEnqSearchResults(cname, phone,
				 from);
	}

	public List<WelcomResult> getReports(Date from, Date to, int pageNo) {
		return customerEnqDao.getReports(from,to,pageNo);
	}

	public Object getCountOfReports(int status,Date from, Date to) {
		
		return customerEnqDao.getCountOfReports(status,from,to);
	}

}
