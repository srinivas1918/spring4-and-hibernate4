package com.macsof.dao;

import java.util.List;

import com.macsof.domain.Complaint;
import com.macsof.ui.CustomerInstallDetails;

public interface ComplaintDao extends AbstracDao<Complaint, Integer >{

	List<CustomerInstallDetails> getComplaintDetails(String status, int from);

	int findComplaintStatus(int cusId, String status);

	
}
