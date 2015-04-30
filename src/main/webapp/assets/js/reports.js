var pageCounter=0;
var maxReached=0;
var date1=null;
var date2=null;
var url=null;
$(document).ready(function(){
	//load table data
	
	
	$("#go").click(function(){
		$(window).scroll(bindScroll);
		pageCounter=0;
		maxReached=0;
		 date1=$("#demo1").val();
		 date2=$("#demo2").val();
		if(date1.length==0){
			$("#demo1").focus();
			return false;
		}
		if(date2.length==0){
			$("#demo2").focus();
			return false;
		}
		
		var url=context+"/reports/"+date1+"/"+date2+"/"+pageCounter;
		
		$('#welcomeResults >tbody').empty();
		loadTableData(url);
		var pending=makeAjax(context+"/countReports/"+date1+"/"+date2+"/"+'1');
		var closed=makeAjax(context+"/countReports/"+date1+"/"+date2+"/"+'2');
		var rejected=makeAjax(context+"/countReports/"+date1+"/"+date2+"/"+'3');
		
		$("#p").html("Pending("+pending+")");
		$("#c").html("Closed("+closed+")");
		$("#r").html("Rejected("+rejected+")");
	});
	
	
});

function loadTableData(url){
	var response=makeAjax(url);
	//console.log(response);
	prepareTableRow(response);
}
function loadTableData(url,status){
	var response=makeAjax(url);
	//console.log(response);
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
	var noteText=null;
	var statusFlag=null;
	$.each(response, function(index,data){
		if(data.note==null){
			data.note="-";
		}
		
		if(data.note.length>40){
			noteText=data.note.substr(0,40)+"<b>..</b>";
		}else{
			noteText=data.note;
		}
			
		if(data.status=='3'){
			statusFlag="<b style='color: blue;'>Rejected</b>";
		}else if(data.status=='2'){
			statusFlag="<b style='color: green;'>Closed</b>";
		}	else{
			statusFlag="<b style='color: red;'>Pending</b>";
		}
		
	var tr="<tr ><td>"+(index+rowCount+1)+"</td><td onclick='showDetails("+data.customerId+")' class='bill'>"+data.cname+"</td><td onclick='showDetails("+data.customerId+")' class='bill'>"+data.phone+"</td>" +
			"<td>"+data.enqFor+"</td><td>"+data.enqCode+"</td>";
			//console.log(tr);
		if(data.status=='3'){
			tr=tr+"<td>"+statusFlag+"</td><td>--</td><td style='color: blue;'><b>"+data.followUp+"</b></td></tr>";
		}else if(data.status=='2'){
			tr=tr+"<td>"+statusFlag+"</td><td>--</td><td style='color: green;'><b>"+data.followUp+"</b></td></tr>";
		}else{
			tr=tr+"<td>"+statusFlag+"</td><td style='color: red;'><b>"+data.followUp+"</b></td><td>--</td></tr>";
		}
		
			$('#welcomeResults >tbody').append(tr);
	});
}
function showDetails(cusId){
	var url=context+"/getCustomerDetails/"+cusId;
	var details=makeAjax(url);
	$("#customerDetails").html(details);
	$("#myModal").modal('show');
}
function bindScroll(){
	   if($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
	       $(window).unbind('scroll');
	       loadMore();
	   }
	}
function loadMore(){
	//console.log(date1);
	//console.log(date2);
	if(date1==null || date2==null){
		return false;
	}
	if(maxReached==0 ){ //not reached
 	pageCounter++;
 	//alert(pageCounter);
 	var response=makeAjax(context+"/reports/"+date1+"/"+date2+"/"+pageCounter);
 	//alert("dfad"+response.length);
 	if(response.length==0){
 		maxReached=1; //max Reached;
 	}
 	prepareTableRow(response);
 	//$(window).scrollTo(100, 0);
 	}
	 $(window).bind('scroll', bindScroll);
}