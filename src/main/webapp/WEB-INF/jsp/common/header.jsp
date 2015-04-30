<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  <script type="text/javascript">
		var context="<%=request.getContextPath() %>";
    </script>
<header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="<%=request.getContextPath() %>/welcome" class="logo"><b>Aragon Technologies</b></a>
            <!--logo end-->
                      
            <div class="top-menu"> 
            	<ul class="nav pull-right top-menu" style="margin-top: -7px;">
                    <li><a class="logout" href="login.html">Logout</a></li>
            	</ul>
            </div>
        </header>