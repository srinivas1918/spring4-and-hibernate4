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

    <title>welcome..</title>
	
    <jsp:include page="common/css.jsp"></jsp:include>
     <link href="<%=request.getContextPath() %>/assets/css/datepicker.css" rel="stylesheet">
    <style type="text/css">
     .table tbody tr:hover td, .table tbody tr:hover th {
   		 background-color: #eeeeea;
		}
		td.bill:hover{
		cursor: pointer;
		color: white;
		
		}
		 .table tbody tr:hover td.bill:hover{
			background-color: #FFA500;
		}
      </style>
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
          <div class="row col-md-12">
           <div class="col-md-6" >
			<div class="form-group">
			     <div class="col-sm-5">          
         <input id="demo1" name="followup" type="text" class=" form-control datepicker" autocomplete="off" data-date-format="yyyy-mm-dd" />
      </div>
    		
    		
      			<div class="col-sm-5">          
         <input id="demo2" name="followup" type="text" class=" form-control datepicker" autocomplete="off" data-date-format="yyyy-mm-dd" />
      </div>
    		
    		<div class="col-sm-2">
		        <input type="button" id="go" name="search" value="Search" class="btn btn-primary">
		        </div>
		                        
            </div>
			<!--  <div class="col-md-5">
				<span style="color: green;font-size: 25px;">  Sale Amount :	<span id="amt">${amt}</span></span>
			</div> -->
         </div>
          </div>
          <div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                      <h4><i class="fa fa-angle-right"></i> Reports : <span id="p" style="color: red;margin-left: 5%;"></span>
                      										<span id="c" style="color:green; margin-left: 5%;"></span>
                      								<span id="r" style="color:blue; margin-left: 2%;"></span></h4>
                          <section id="unseen">
                            <table class="table table-bordered table-striped table-condensed" style="font-size: 15px;" id="welcomeResults">
                              <thead>
                              <tr>
                                  <th>#SNO</th>
                                  <th>CNAME</th>
                                  <th>PHONE</th>
                                  <th>ENQUIRY FOR</th>
                                  <th>QUATATION</th>
                                  <th>STATUS</th>
                                  <th>FOLLOW UP DATE</th>
                                  <th>CLOSED</th>
                              </tr>
                              </thead>
                              <tbody>
                             	
                              
                              </tbody>
                          </table>
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
	 
<div class="modal fade" id="myModal"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"  >
  <div class="modal-dialog " id="customerDetails" style="width: 53%;">
   
</div>
</div>

    <!-- js placed at the end of the document so the pages load faster -->
   
<jsp:include page="common/script.jsp"></jsp:include>
<script src="<%=request.getContextPath() %>/assets/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	$('.datepicker').datepicker();
	
	
	});
	</script>
<script src="<%=request.getContextPath() %>/assets/js/reports.js"></script>

  </body>
</html>

