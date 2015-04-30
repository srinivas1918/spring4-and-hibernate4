package com.macsof.service;

import java.util.Date;
import java.util.List;

import com.macsof.domain.Complaint;
import com.macsof.domain.Customer;
import com.macsof.domain.Installation;
import com.macsof.domain.Tracking;
import com.macsof.ui.CustomerInstallDetails;
import com.macsof.ui.InstallDetails;
import com.macsof.ui.SearchResults;
import com.macsof.ui.WelcomResult;

public interface CustomerEnqService {

	public void saveTracking(Tracking tracking);
	
	public List<WelcomResult> getWelcomeResult(int from, String status);
	
	public Customer getCustomer(int cusId);
	
	public List<CustomerInstallDetails> getInstallationDetails(int cusId);
	
	public void saveInstallationInfo(Installation installation);
	
	public List<CustomerInstallDetails> getPendingInstalls(int from, String status);
	
	public Installation getInstallation(int installId);
	
	public void updateInstallation(Installation installation);
	
	public List<SearchResults> getSearchResults(String cname, String phone,int from);
	
	public List<Complaint> getComplaintHistory(int cusId);

	public void saveComplaint(Complaint complaint);
	
	public List<CustomerInstallDetails> getComplaintDetails(String status, int from);

	public Complaint getComplaint(int complaintId);

	public int findComplaintStatus(int cusId, String status);

	public List<WelcomResult> getEnqSearchResults(String cname, String phone,
			int from);

	public List<WelcomResult> getReports(Date from, Date to, int pageNo);

	public Object getCountOfReports(int status, Date date, Date date2);
	
	
}
