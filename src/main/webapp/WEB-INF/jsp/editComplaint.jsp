<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Edit Complaint..</title>
	
    <jsp:include page="common/css.jsp"></jsp:include>
    <link href="<%=request.getContextPath() %>/assets/css/datepicker.css" rel="stylesheet">
    
  </head>

  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <jsp:include page="common/header.jsp"></jsp:include>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <jsp:include page="common/sideBar.jsp"></jsp:include>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper site-min-height" style="padding-right: 0px;">
         
          <div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                      <h4><i class="fa fa-angle-right" style="color: green;"></i> Edit Complaint</h4>
                          <section id="unseen">
                           

<div class="container">
  <form class="form-horizontal" role="form" method="POST" action="<%=request.getContextPath() %>/editRepair/${complaint.complaintId}" id="enqForm">
    
    
     
     
    
    <div class="form-group">  
    	<label class="control-label col-sm-2">STATUS:</label>            
      <div class="col-sm-5">
           <select style="height: 25px; width: 50%;" name="status">
               		<option value="2">Assign</option>
               		<option value="3">Closed</option>
               		
               </select> 
        
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2">TECHNICIAN:<span style="color:red;">*</span></label>
      <div class="col-sm-5">          
        <input type="text" class="form-control" id="name" name="name" placeholder="Enter Technician" maxlength="25" required="required" value="${complaint.technician} ">
      </div>
    </div>
    
    <div class="form-group">  
    	<label class="control-label col-sm-2">SPARES </label>            
      <div class="col-sm-5">
        
          <textarea class="form-control" rows="5" id="note" name="note" placeholder="Enter Spares replaced">${complaint.replaceParts }</textarea>
        
      </div>
    </div>
    
    <div class="form-group">
 
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-success" onclick="validate()">update</button>
        <label class="control-label col-sm-2">NOTE: Fields having <span style="color:red;">*</span> are mandatory </label>       
      </div>
    </div>
  </form>
</div>


                            
                          </section>
                  </div><!-- /content-panel -->
               </div><!-- /col-lg-4 -->			
		  	</div>
          	
	
	
		
		  
		</section><! --/wrapper -->
		
		
				  </section>
	  
	  <!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
     
      <!--footer end-->
  </section>
	
	<!-- bootstap model popup -->
	<!-- bootstap model popup -->


    <!-- js placed at the end of the document so the pages load faster -->
   
<jsp:include page="common/script.jsp"></jsp:include>
<script src="<%=request.getContextPath() %>/assets/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#st").addClass("active");
	$('.datepicker').datepicker();
	
	});
	function validate(){
	var name=$("#name").val();
	if(name.length==0){
		alert("Technician name is required.");
		$("#name").focus();
		return false;
		}
	$("#enqForm").submit();
	}
	</script>
	
  </body>
</html>

