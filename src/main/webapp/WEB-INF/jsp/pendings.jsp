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

    <title>Pendings..</title>
	
    <jsp:include page="common/css.jsp"></jsp:include>
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
          <div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                      <h4><i class="fa fa-angle-right" style="color: green;"></i> Pending Installations:</h4>
                          <section id="unseen">
                            <table class="table table-bordered table-striped table-condensed" style="font-size: 15px;" id="welcomeResults">
                              <thead>
                              <tr>
                                  <th>#SNO</th>
                                  <th>CNAME</th>
                                  <th>PHONE</th>
                                  <th>QUATATION</th>
                                  <th>TECHNICIAN</th>
                                  <th>INSTALLATION DATE</th>
                                  <th>STATUS</th>
                                    <th>NOTE</th>  
                                  <th>ACTION</th>                               
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
<script src="<%=request.getContextPath() %>/assets/js/pending.js"></script>

  </body>
</html>

