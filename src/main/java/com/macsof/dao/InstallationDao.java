package com.macsof.dao;

import java.util.List;

import com.macsof.domain.Installation;
import com.macsof.ui.CustomerInstallDetails;
import com.macsof.ui.InstallDetails;

public interface InstallationDao extends AbstracDao<Installation, Integer>{

	List<CustomerInstallDetails> getInstallationDetails(int installationId);
	
	public List<CustomerInstallDetails> getPendingInstalls(int from, String status);

}
