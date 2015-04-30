 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <div class="modal-content" >
    
    
    		
    	
    	<div class="row mt " style="padding-top: 7px; font-size: 19px; margin-left: 8px;  margin-right: 5px; " >
    	 <B style="color: green;">Customer Details :</B>
    	 <table class="table table-bordered table-striped table-condensed" style="font-size: 15px;" >
    	 	<thead>
    	 		<tr>
    	 						  <th>CNAME</th>
                                  <th>PHONE</th>
                                  <th >ADDRESS</th>
                                  <th>DEMO</th>
                                  <th>ENQUIRY FOR</th>
                                  <th>QUATION</th>
                                  <th>DATE OF CONSULT</th>
                                  
               </tr>
              
    	 	</thead>
    	 	<tbody >
    	 		<tr>
    	 			<td>${customer.cname }</td>
    	 			<td>${customer.phone }</td>
    	 			<td>${customer.address }</td>
    	 			<td><c:choose>
    	 				<c:when test="${customer.demo eq '1' }">Yes</c:when>
    	 				<c:otherwise>No</c:otherwise>
    	 			</c:choose>
    	 			</td>
    	 			<td>${customer.enqFor }</td>
    	 			<td>${customer.enqCode }</td>
    	 			<td style='color: green;'><b>${customer.date }</b></td>
    	 		</tr>
 				 		
    	 	</tbody>
    	 </table>
    	  <B style="color: green;">	Complaint History:</B>
    	  
    	 <table class="table table-bordered table-striped table-condensed" style="font-size: 15px;" >
    	 	<thead>
    	 		<tr>
    	 						  <TH>#SNO</TH>
    	 						  <TH>TECHNICIAN</TH>
    	 						  <th>COMPLAINT DATE</th>
                                  <th>PARTS REPLACED</th>
                                  <th >STATUS</th>
                                  
               </tr>
              
    	 	</thead>
    	 	<tbody >
    	 	<c:forEach var="complaint" items="${complaints }" varStatus="counter">
    	 		<tr>
    	 			<td>${counter.count }</td>
    	 			<td>${complaint.technician }</td>
    	 			<td style="color: green"><b>${complaint.complaintDate }</b></td>
    	 			<td>${complaint.replaceParts }</td>
    	 			<td>
    	 						<c:if test="${complaint.status eq '1'}">
    	 						<b style="color:red; ">
    	 							Received</b>
    	 						</c:if>
    	 						<c:if test="${complaint.status eq '2'}">
    	 						<b style="color:red; ">
    	 							Assigned</b>
    	 						</c:if>
    	 						<c:if test="${complaint.status eq '3'}">
    	 						<b style="color:green; ">
    	 							Closed
    	 							</b>
    	 						</c:if>
    	 						</td>
    	 		</tr>
 				
    	 	</c:forEach>
    	 		 		
    	 	</tbody>
    	 </table>
    	 
    	</div>
    	
    	
    	<hr style="margin-top: 5px;margin-bottom: 10px;">
    	
    	
    	
  </div>