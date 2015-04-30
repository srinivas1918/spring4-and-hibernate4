$("#st").addClass("active");
var pageCounter=0;
var maxReached=0;
var cname=null;
var phone=null;
var url=null;
$(document).ready(function(){
	$(window).scroll(bindScroll);
	$("#go").click(function(){
		url=context+"/";
		pageCounter=0;
		$('#welcomeResults >tbody').empty();
		getData(cname, phone, pageCounter);
	});
});

function getData(cname, phone, pageCounter){
	
	 cname=$("#name").val();
	 phone=$("#phone").val();
	if(cname.length==0 && phone.length==0){
		$("#name").focus();
		alert("Name or Phone requried");
		return false;
	}
	 if(cname.length!=0 && phone.length==0){
		 url=url+"searchCname/"+cname+"/";
	 }
	 
	 else if(phone.length!=0 && cname.length==0){
		 url=url+"searchPhone/"+phone+"/";
	 }else{
		 url=url+"search/"+cname+"/"+phone+"/"; 
	 }
	 
	
	loadTableData(url+pageCounter);
}

function loadTableData(url){
	var response=makeAjax(url);
	//console.log(response);
	prepareTableRow(response);
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
	
	$.each(response, function(index,data){
		
	var tr="<tr ><td>"+(index+rowCount+1)+"</td><td onclick='showDetails("+data.cusId+")' class='bill'>"+data.cname+"</td><td onclick='showDetails("+data.cusId+")' class='bill'>"+data.phone+"</td>" +
			"<td>"+data.enqFor+"</td><td>"+data.enqCode+"</td><td style='color: green;'><b>"+data.closedDate+"</b></td>"+
			"<td><input type='button' value='Accept' class='btn btn-success' onclick='complaint("+data.cusId+")'></td></tr>";
					
			$('#welcomeResults >tbody').append(tr);
	});
}

function bindScroll(){
	   if($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
	       $(window).unbind('scroll');
	       loadMore();
	   }
	}

function loadMore(){
	if(maxReached==0 && url!=null){ //not reached
 	pageCounter++;
 	//alert(pageCounter);
 	
 	var response=makeAjax(url+pageCounter);
 	if(response.length==0){
 		maxReached=1; //max Reached;
 	}
 	prepareTableRow(response);
 	//$(window).scrollTo(100, 0);
 	}
	 $(window).bind('scroll', bindScroll);
}

function showDetails(cusId){
	var url=context+"/getComplaintHistory/"+cusId;
	var details=makeAjax(url);
	$("#customerDetails").html(details);
	$("#myModal").modal('show');
}

function complaint(cusId){
	var url=context+"/acceptComplaint/"+cusId+"/1";
	var response=makeAjax(url);
	//alert(response);
	if(response=='ok'){
		window.location.href=context+"/allComplaints";//1 is recieved.
	}else{
		alert("We can`t accept the complaint because, This complaint is already accepted");
	}
	
}