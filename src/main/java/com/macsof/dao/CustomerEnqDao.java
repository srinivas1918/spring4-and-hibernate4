package com.macsof.dao;

import java.util.Date;
import java.util.List;

import com.macsof.domain.Complaint;
import com.macsof.domain.Customer;
import com.macsof.ui.SearchResults;
import com.macsof.ui.WelcomResult;

public interface CustomerEnqDao extends AbstracDao<Customer, Integer> {

	List<SearchResults> getSearchResults(String cname, String phone,int from);

	List<Complaint> getComplaintHistory(int cusId);

	List<WelcomResult> getEnqSearchResults(String cname, String phone, int from);

	List<WelcomResult> getReports(Date from, Date to, int pageNo);

	Object getCountOfReports(int status, Date from, Date to);

	
}
