<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion" style="top: 10px;">
              
                  <li class="mt" >
                      <a href="javascript:void(0)"  style="padding:8px; font-size: 15px;" id="reports" onclick="gotoNewEnq();">
                          <i class="fa fa-dashboard"></i>
                          <span >New Enquiry</span>
                      </a>
                  </li>
				<!-- <li class="mt" >
                      <a href="javascript:void(0)"  style="padding:8px; font-size: 15px;" onclick="gotoInstallations()" id="in">
                          <i class="fa fa-dashboard"></i>
                          <span>Installations</span>
                      </a>
                  </li> -->
				<li class="mt" >
                      <a href="javascript:void(0)"  style="padding:8px; font-size: 15px;" onclick="showComplaints()" id="st">
                          <i class="fa fa-dashboard"></i>
                          <span>Complaints</span>
                      </a>
                  </li>
                  <li class="mt" >
                      <a href="javascript:void(0)"  style="padding:8px; font-size: 15px;" onclick="gotoReports()" id="re">
                          <i class="fa fa-dashboard"></i>
                          <span>Reports</span>
                      </a>
                  </li>
               
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      
    