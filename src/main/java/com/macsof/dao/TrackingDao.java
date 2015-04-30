package com.macsof.dao;

import java.util.List;

import com.macsof.domain.Customer;
import com.macsof.domain.Tracking;
import com.macsof.ui.WelcomResult;

public interface TrackingDao extends AbstracDao<Tracking, Integer>{

	public List<WelcomResult> getWelcomeResult(int from, String status);
	
	
}
