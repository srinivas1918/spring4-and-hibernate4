package com.macsof.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.macsof.constants.Constants;
import com.macsof.domain.Complaint;
import com.macsof.domain.Customer;
import com.macsof.domain.Installation;
import com.macsof.domain.Tracking;
import com.macsof.service.CustomerEnqService;
import com.macsof.ui.CustomerInstallDetails;
import com.macsof.ui.InstallDetails;
import com.macsof.ui.SearchResults;
import com.macsof.ui.WelcomResult;

@Controller
public class WelcomeAction {
	private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeAction.class);
	
	@Autowired
	private CustomerEnqService customerEnqService;
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping(value="/welcome")
	public String welcome(){
		
		return Constants.WELCOME_PAGE;
	}
	
	@RequestMapping(value="/getEnqResults/{from}/{status}")
	@ResponseBody
	public List<WelcomResult> getWelcomResults(@PathVariable int from, @PathVariable String status){
		List<WelcomResult> welcomResults=customerEnqService.getWelcomeResult(from, status);
		LOGGER.debug("SIZE OF PENDING :"+welcomResults.size());
		return welcomResults;
	}
	
	@RequestMapping(value="/newEnq")
	public String newEnq(){
		return Constants.NEWENQ_PAGE;
	}
	@RequestMapping(value="/saveEnq", method=RequestMethod.POST)
	public String saveEnq(@RequestParam String phone, @RequestParam String cname, @RequestParam String address, @RequestParam String quatation, @RequestParam String demo, @RequestParam String followup,@RequestParam String note,@RequestParam String status,@RequestParam String enq) throws ParseException{
		Customer customer=new Customer();
		customer.setCname(cname);
		customer.setPhone(phone);
		customer.setAddress(address);
		customer.setDemo(demo);
		customer.setEnqCode(quatation);
		customer.setDate(new Date());
		customer.setEnqFor(enq);
		
		Tracking tracking=new Tracking();
		tracking.setCustomer(customer);
		tracking.setFollowUpDate(dateFormat.parse(followup));
		tracking.setNote(note);
		tracking.setStatus(status);
		
		customerEnqService.saveTracking(tracking);
		LOGGER.debug("CUSTOMER ID :"+customer.getCustomerId());
		if(Constants.STATUS_CLOSED.equals(status)){
			Installation installation=new Installation();
			installation.setCustomerId(customer.getCustomerId());
			installation.setStatus("2");
			installation.setInstallationDate(dateFormat.parse(followup));
			customerEnqService.saveInstallationInfo(installation);
			
		}
		
		return "redirect:welcome";
	}
	
	@RequestMapping(value="/updateEnq/{cusId}")
	public String updateEnq(@PathVariable int cusId,@RequestParam String status, @RequestParam String followup, @RequestParam String note,@RequestParam String demo,@RequestParam String address,@RequestParam String quatation) throws ParseException{
		Customer cus=customerEnqService.getCustomer(cusId);
		cus.setDemo(demo);
		cus.setAddress(address);
		cus.setEnqCode(quatation);
		Set<Tracking> trSet=cus.getTrackings();
		Tracking tracking=new Tracking();
		tracking.setCustomer(cus);
		tracking.setNote(note);
		tracking.setStatus(status);
		tracking.setFollowUpDate(dateFormat.parse(followup));
		trSet.add(tracking);
		customerEnqService.saveTracking(tracking);
		if(Constants.STATUS_CLOSED.equals(status)){
			Installation installation=new Installation();
			installation.setCustomerId(cusId);
			installation.setStatus("2");
			installation.setInstallationDate(dateFormat.parse(followup));
			customerEnqService.saveInstallationInfo(installation);
		}
		return "redirect:/welcome";
	}
	
	/*@RequestMapping(value="/installation/{installationId}")
	public String installation(@PathVariable int installationId, Model model){
		List<CustomerInstallDetails> installations=customerEnqService.getInstallationDetails(installationId);
		CustomerInstallDetails customerInstallDetails = new CustomerInstallDetails();
		if(installations.size()>0){
			customerInstallDetails=installations.get(0);
		}
		model.addAttribute("customer", customerInstallDetails);
		return Constants.INSTALLATION_PAGE;
	}*/
	
	
	@RequestMapping(value="/getCustomerDetails/{cusId}")
	public String getCustomerDetails(@PathVariable int cusId, Model model){
		Customer customer=customerEnqService.getCustomer(cusId);
		model.addAttribute("customer", customer);
		return Constants.CUSTOMER_DETAILS_PAGE;
	}
	
	@RequestMapping(value="/reschedule/{cusId}")
	public String reschedule(@PathVariable int cusId, Model model){
		Customer cus=customerEnqService.getCustomer(cusId);
		model.addAttribute("cus", cus);
		return Constants.RESCHEDULE_CUSTOMER_PAGE;
	}
	
	
	/*@RequestMapping(value="/saveInstallInfo/{installationId}")
	public String saveInstallInfo(@PathVariable int installationId, @RequestParam String name,@RequestParam String followup,@RequestParam String status,@RequestParam String note ) throws ParseException{
		Installation installation=customerEnqService.getInstallation(installationId);
		LOGGER.debug("followup Date:"+followup);
		installation.setInstallationDate(dateFormat.parse(followup));
		installation.setTechnician(name);
		installation.setNote(note);
		installation.setStatus(status);
		customerEnqService.updateInstallation(installation);
		return "redirect:/pendingDetails";
	}
	*/
	
	/*@RequestMapping(value="/pendings/{from}/{status}")
	@ResponseBody
	public List<CustomerInstallDetails> getPendingInstalls(@PathVariable int from, @PathVariable String status){
		return customerEnqService.getPendingInstalls(from, status);
	}*/
	
	/*@RequestMapping(value="/pendingDetails")
	public String getPendingDetails(){
		return Constants.PENDING_INSTALLATIONS_PAGE;
	}*/
	
	@RequestMapping(value="/search/{cname}/{phone}/{from}")
	@ResponseBody
	public List<SearchResults> getSearchResults(@PathVariable String cname, @PathVariable String phone,@PathVariable int from){
		return  customerEnqService.getSearchResults(cname, phone, from);
	}
	
	@RequestMapping(value="/searchCname/{cname}/{from}")
	@ResponseBody
	public List<SearchResults> getSearchUsingCname(@PathVariable String cname, @PathVariable int from){
		return  customerEnqService.getSearchResults(cname, "", from);
	}
	
	@RequestMapping(value="/searchPhone/{phone}/{from}")
	@ResponseBody
	public List<SearchResults> getSearchUsingPhone(@PathVariable String phone,@PathVariable int from){
		return  customerEnqService.getSearchResults("", phone, from);
	}
	
	@RequestMapping(value="/newComplaint")
	public String newComplaint(){
		return Constants.NEW_COMPLAINT_PAGE;
	}
	
	@RequestMapping(value="/getComplaintHistory/{cusId}")
	public String getComplaintHistory(@PathVariable int cusId, Model model){
		Customer customer=customerEnqService.getCustomer(cusId);
		List<Complaint> complaints=customerEnqService.getComplaintHistory(cusId);
		model.addAttribute("customer", customer);
		model.addAttribute("complaints", complaints);
		return Constants.COMPLAINT_DETAILS_PAGE;
	}
	
	@RequestMapping(value="/acceptComplaint/{cusId}/{status}")
	@ResponseBody
	public String acceptComplaint(@PathVariable int cusId, @PathVariable String status){
		int count=customerEnqService.findComplaintStatus(cusId, status);
		LOGGER.debug("count of status "+count);
		if(count>0){
			return "falied";
		}
		LOGGER.info("Complaint status :"+count);
		Complaint complaint=new Complaint();
		complaint.setComplaintDate(new Date());
		complaint.setCustomerId(cusId);
		complaint.setStatus(status);
		customerEnqService.saveComplaint(complaint);
		LOGGER.debug("Complaint Received for cus :"+cusId);
		return "ok";
	}
	
	@RequestMapping(value="/allComplaints")
	public String allComplaint(){
		//List<CustomerInstallDetails> details=customerEnqService.getComplaintDetails(status, from);
		return Constants.ALL_COMPLAINTS;
	}
	
	@RequestMapping(value="/getComplaintDetails/{from}/{status}")
	@ResponseBody
	public List<CustomerInstallDetails> getComplaintDetails(@PathVariable String status, @PathVariable int from){
		return customerEnqService.getComplaintDetails(status, from);
	}
	
	
	@RequestMapping(value="/repair/{complaintId}")
	public String repair(@PathVariable int complaintId, Model model){
		Complaint complaint= customerEnqService.getComplaint(complaintId);
		model.addAttribute("complaint", complaint);
		return Constants.EDIT_COMPLAINT;
	}
	
	@RequestMapping(value="/editRepair/{complaintId}")
	public String editRepair(@PathVariable int complaintId,@RequestParam String name, @RequestParam String status, @RequestParam String note){
		Complaint complaint= customerEnqService.getComplaint(complaintId);
		if("2".equals(status))
			complaint.setClosedDate(new Date());
		complaint.setReplaceParts(note);
		complaint.setTechnician(name);
		complaint.setStatus(status);
		customerEnqService.saveComplaint(complaint);
		return "redirect:/allComplaints";
	}
}
