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

    <title>new install..</title>
	
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
                     <h4><i class="fa fa-angle-right"></i> Installations Details:</h4>
                          <section id="unseen">
                           

<div class="container">
  <form class="form-horizontal" role="form" method="POST" action="<%=request.getContextPath() %>/saveInstallInfo/${customer.installId}" id="installForm">
    <div class="form-group">
      <label class="control-label col-sm-2 " for="phone">CNAME:</label>
      <div class="col-sm-5">
        <input type="text" class="form-control " id="name" name="cname" placeholder="Enter Name" maxlength="12" value="${customer.cname }" readonly="readonly">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2 " for="phone">Phone:</label>
      <div class="col-sm-5">
        <input type="text" class="form-control " id="name" name="phone" placeholder="Enter Name" maxlength="12" value="${customer.phone }" readonly="readonly">
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2">Address:</label>
      <div class="col-sm-5">          
         <textarea class="form-control" rows="5" id="address" name="address" placeholder="Enter Address" readonly="readonly">${customer.address }</textarea>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2 " for="phone">Quatation:</label>
      <div class="col-sm-5">
        <input type="text" class="form-control " id="name" name="quatation" placeholder="Enter Name" maxlength="12" value="${customer.enqId }" readonly="readonly">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2 " for="phone">Technican Name:</label>
      <div class="col-sm-5">
        <input type="text" class="form-control " id="name" name="name" placeholder="Enter Name" maxlength="12" value="${customer.name }">
      </div>
    </div>
   
    <div class="form-group" id="fpd">
      <label class="control-label col-sm-2"> Installation Date:<span style="color:red;">*</span></label>
      <div class="col-sm-5">          
         <input id="demo1" name="followup" type="text" class=" form-control datepicker" autocomplete="off" data-date-format="yyyy-mm-dd" value="${customer.date }"/>
      </div>
    </div>
    
    <div class="form-group">  
    	<label class="control-label col-sm-2">Status:</label>            
      <div class="col-sm-5">
           <select style="height: 25px; width: 50%;" name="status">
               		<option value="1" <c:if test="${customer.status eq '1' }">selected="selected" </c:if>  >Pending</option>
               		<option value="2" <c:if test="${customer.status eq '2' }">selected="selected" </c:if>>Installed</option>
               		
               </select> 
        
      </div>
    </div>
  
    
    <div class="form-group">  
    	<label class="control-label col-sm-2">Note</label>            
      <div class="col-sm-5">
        
          <textarea class="form-control" rows="5" id="note" name="note" placeholder="Enter Note">${customer.note }</textarea>
        
      </div>
    </div>
    
    <div class="form-group">
 
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-success" onclick="validate()">save</button>
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
		
	$('.datepicker').datepicker();
	
	});
	</script>
	<script src="<%=request.getContextPath() %>/assets/js/installation.js"></script>
  </body>
</html>

