package com.macsof.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macsof.constants.Constants;
import com.macsof.service.CustomerEnqService;
import com.macsof.ui.WelcomResult;

@Controller
public class ReportsAction {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportsAction.class);
	@Autowired
	private CustomerEnqService customerEnqService;
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@RequestMapping(value="/reports/{from}/{to}/{pageNo}")
	@ResponseBody
	public List<WelcomResult> getReports(@PathVariable String from, @PathVariable String to, @PathVariable int pageNo) throws ParseException{
		 List<WelcomResult> welcomResults=customerEnqService.getReports(dateFormat.parse(from),dateFormat.parse(to), pageNo);
		LOGGER.debug("Total records found ("+welcomResults.size()+") from "+from+" to "+to);
		 return welcomResults;
	}
	
	@RequestMapping(value="/countReports/{from}/{to}/{status}", method=RequestMethod.GET)
	@ResponseBody
	public String getPendingResultCount(@PathVariable int status,@PathVariable String from, @PathVariable String to) throws ParseException{
		Object count=customerEnqService.getCountOfReports(status,dateFormat.parse(from),dateFormat.parse(to));
		LOGGER.debug("IN count :Total records found ("+count+") from "+from+" to "+to);
		return count.toString();
	}
	
	@RequestMapping(value="/reports")
	public String reports(){
		return Constants.REPORTS_PAGE;
	}
}
