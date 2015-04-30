package com.macsof.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macsof.service.CustomerEnqService;
import com.macsof.ui.SearchResults;
import com.macsof.ui.WelcomResult;

@Controller
public class SearchEnqAction {

	@Autowired
	private CustomerEnqService customerEnqService;
	
	@RequestMapping(value="/searchEnq/{cname}/{phone}/{from}")
	@ResponseBody
	public List<WelcomResult> getSearchResults(@PathVariable String cname, @PathVariable String phone,@PathVariable int from){
		return  customerEnqService.getEnqSearchResults(cname, phone, from);
	}
	
	@RequestMapping(value="/searchEnqCname/{cname}/{from}")
	@ResponseBody
	public List<WelcomResult> getSearchUsingCname(@PathVariable String cname, @PathVariable int from){
		return  customerEnqService.getEnqSearchResults(cname, "", from);
	}
	
	@RequestMapping(value="/searchEnqPhone/{phone}/{from}")
	@ResponseBody
	public List<WelcomResult> getSearchUsingPhone(@PathVariable String phone,@PathVariable int from){
		return  customerEnqService.getEnqSearchResults("", phone, from);
	}
	
}
