var pageCounter=0;
var maxReached=0;
var cname=null;
var phone=null;
var searchUrl=null;
$(document).ready(function(){
	//load table data
	$("#text").text("DashBoard:");
	$("#button").html('');
	var url=context+"/getEnqResults/0/1";
	loadTableData(url);
	$(window).scroll(bindScroll);
	
	$("#go").click(function(){
		$("#text").text("Search Results:");
		$("#button").html("<a href='"+context+"/welcome' class='btn btn-primary' >Back</a>");
		searchUrl=context+"/";
		pageCounter=0;
		maxReached=0;
		$('#welcomeResults >tbody').empty();
		$('#welcomeResults >thead').empty();
		getData(cname, phone, pageCounter);
	});
});

function getData(cname, phone, pageCounter){
	
	 cname=$("#name").val();
	 phone=$("#phone").val();
	 var tr="<tr><th>#SNO</th><th>CNAME</th><th>PHONE</th><th>ENQUIRY FOR</th><th>QUATATION</th><th>DEMO</th><th>STATUS</th><th>DATE</th><th>NOTE</th><th>ACTION</th></tr>";
 	$('#welcomeResults >thead').html(tr);
	 
	if(cname.length==0 && phone.length==0){
		$("#name").focus();
		alert("Name or Phone requried");
		return false;
	}
	 if(cname.length!=0 && phone.length==0){
		 searchUrl=searchUrl+"searchEnqCname/"+cname+"/";
	 }
	 
	 else if(phone.length!=0 && cname.length==0){
		 searchUrl=searchUrl+"searchEnqPhone/"+phone+"/";
	 }else{
		 searchUrl=searchUrl+"searchEnq/"+cname+"/"+phone+"/"; 
	 }
	 
	
	loadSearchTableData(searchUrl+pageCounter);
}
function loadSearchTableData(searchUrl){
	var response=makeAjax(searchUrl);
	//console.log(searchUrl);
	//console.log(response);
	prepareSearchTableRow(response);
}

function loadTableData(url,status){
	var response=makeAjax(url);
	
	prepareTableRow(response,status);
}
function makeAjax(url){
	var responseData=null;
	$.ajax({
		url: url,
		type: "GET",
		async:false,
		success:function(response){
			responseData=response;
						
		},
		error:function(error){
			alert("some problem occured please contact provider");
			return false;
		}
		
	});
	return responseData;
}

function prepareTableRow(response,status){
	var rowCount = $('#welcomeResults >tbody >tr').length;
	//console.log(response);
	var demoFlag=null;;
	var noteText=null;
	$.each(response, function(index,data){
		if(data.demo=='1')
		demoFlag='yes';
		else 
			demoFlag='no';
		if(data.note.length>20){
			noteText=data.note.substr(0,20)+"<b>..</b>";
		}else{
			noteText=data.note;
		}
			
			
		
	var tr="<tr ><td>"+(index+rowCount+1)+"</td><td onclick='showDetails("+data.customerId+")' class='bill'>"+data.cname+"</td><td onclick='showDetails("+data.customerId+")' class='bill'>"+data.phone+"</td>" +
			"<th>"+data.enqFor+"</th><td>"+data.enqCode+"</td><td>"+demoFlag+"</td><td style='color: green;'><b>"+data.followUp+"</b></td>" +
					"<td>"+noteText+"</td>";
			//console.log(tr);
		if(status=='2' || status=='3'){
			tr=tr+"</tr>";
		}else{
			
			tr=tr+"<td><input type='button' value='Reschedule' class='btn btn-primary' onclick='reschedule("+data.customerId+")'></td></tr>";
		}
			$('#welcomeResults >tbody').append(tr);
	});
}

function prepareSearchTableRow(response){
	var rowCount = $('#welcomeResults >tbody >tr').length;
	//console.log("==========");
	//console.log(response);
	var demoFlag=null;
	var statusFlag=null;
	var noteText=null;
	$.each(response, function(index,data){
		if(data.demo=='1')
		demoFlag='yes';
		else 
			demoFlag='no';
		if(data.note.length>20){
			noteText=data.note.substr(0,20)+"<b>..</b>";
		}else{
			noteText=data.note;
		}
		
		if(data.status=='1'){
			statusFlag="<b style='color:red;'>Pending</b>";
		}
		if(data.status=='2'){
			statusFlag="<b style='color:green;'>Closed</b>";
		}
		if(data.status=='3'){
			statusFlag="<b style='color:blue;'>Rejected</b>";
		}
			
			
		
	var tr="<tr ><td>"+(index+rowCount+1)+"</td><td onclick='showDetails("+data.customerId+")' class='bill'>"+data.cname+"</td><td onclick='showDetails("+data.customerId+")' class='bill'>"+data.phone+"</td>" +
			"<th>"+data.enqFor+"</th><td>"+data.enqCode+"</td><td>"+demoFlag+"</td></td><td>"+statusFlag+"</td><td style='color: green;'><b>"+data.followUp+"</b></td>" +
					"<td>"+noteText;
			//console.log(tr);
		if(data.status=='2'){
			tr=tr+"<td>--</td></tr>";
		}else if(data.status=='3'){
			tr=tr+"<td>--</td></tr>";
		}		
		else{
			
			tr=tr+"<td><input type='button' value='Reschedule' class='btn btn-primary' onclick='reschedule("+data.customerId+")'></td></tr>";
		}
			$('#welcomeResults >tbody').append(tr);
	});
}
$('select').on('change', function (e) {
    var optionSelected = $("option:selected", this);
    var valueSelected = this.value;
    
    if(valueSelected=='1'){
    	maxReached=0;
    	pageCounter=0;
    	searchUrl=null;
    	var url=context+"/getEnqResults/0/1";
    	$('#welcomeResults >tbody').empty();
    	$('#welcomeResults >thead').empty();
    	var tr="<tr><th>#SNO</th><th>CNAME</th><th>PHONE</th><th>ENQUIRY FOR</th><th>QUATATION</th><th>DEMO</th><th>FOLLOW UP DATE</th><th>NOTE</th><th>ACTION</th></tr>";
    	$('#welcomeResults >thead').html(tr);
    	loadTableData(url,1);
    }
    else if(valueSelected=='2'){
    	searchUrl=null;
    	maxReached=0;
    	pageCounter=0;
    	var url=context+"/getEnqResults/0/2";
    	$('#welcomeResults >tbody').empty();
    	$('#welcomeResults >thead').empty();
    	var tr="<tr><th>#SNO</th><th>CNAME</th><th>PHONE</th><th>ENQUIRY FOR</th><th>QUATATION</th><th>DEMO</th><th>CLOSED DATE</th><th>NOTE</th></tr>";
    	$('#welcomeResults >thead').html(tr);
    	loadTableData(url,2);
    	
    }else{
    	searchUrl=null;
    	maxReached=0;
    	pageCounter=0;
    	var url=context+"/getEnqResults/0/3";
    	$('#welcomeResults >tbody').empty();
    	$('#welcomeResults >thead').empty();
    	var tr="<tr><th>#SNO</th><th>CNAME</th><th>PHONE</th><th>ENQUIRY FOR</th><th>QUATATION</th><th>DEMO</th><th>REJECTED DATE</th><th>NOTE</th></tr>";
    	$('#welcomeResults >thead').html(tr);
    	loadTableData(url,3);
    }
});

function showDetails(cusId){
	var url=context+"/getCustomerDetails/"+cusId;
	var details=makeAjax(url);
	$("#customerDetails").html(details);
	$("#myModal").modal('show');
}

function reschedule(cusId){
	//alert("clicke re");
	window.location.href=context+"/reschedule/"+cusId;
}

function bindScroll(){
	   if($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
	       $(window).unbind('scroll');
	       loadMore();
	   }
	}

function loadMore(){
	if(maxReached==0){ //not reached
    	pageCounter++;
    	//alert(pageCounter);
    	
    	if(searchUrl==null){
    	var resultType=$('#resultsStatus option:selected').val();
    	var response=makeAjax(context+"/getEnqResults/"+pageCounter+"/"+resultType);
    	//alert("dfad"+response.length);
    	if(response.length==0){
    		maxReached=1; //max Reached;
    	}
    	prepareTableRow(response);
    	//$(window).scrollTo(100, 0);
    	}else{
    		console.log("load More :"+searchUrl+"/"+pageCounter);
    		var response=makeAjax(searchUrl+pageCounter);
        	//alert("dfad"+response.length);
        	if(response.length==0){
        		maxReached=1; //max Reached;
        	}
        	prepareSearchTableRow(response);
    	}
    	
	}
	
	 $(window).bind('scroll', bindScroll);
}

