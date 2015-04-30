$("#st").addClass("active");
var pageCounter=0;
var maxReached=0;
$(document).ready(function(){
	//load table data
	
	var url=context+"/getComplaintDetails/0/1";
	loadTableData(url);
	$(window).scroll(bindScroll);
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
	console.log(status);
	var noteText=null;
	var nameText=null;
	$.each(response, function(index,data){
		if(data.note==null){
			data.note="-";
		}
		
		if(data.name==null){
			data.name="-";
		}
		if(data.note.length>20){
			noteText=data.note.substr(0,20)+"<b>..</b>";
		}else{
			noteText=data.note;
		}
		if(data.name.length>20){
			nameText=data.name.substr(0,20)+"<b>..</b>";
		}else{
			nameText=data.name;
		}	
			
		
	var tr="<tr ><td>"+(index+rowCount+1)+"</td><td onclick='showDetails("+data.cusId+")' class='bill'>"+data.cname+"</td><td onclick='showDetails("+data.cusId+")' class='bill'>"+data.phone+"</td>" +
			"<td>"+data.enqFor+"</td><td>"+data.enqId+"</td><td>"+data.name+"</td><td>"+noteText+"</td>";
			console.log(status);
		if(status=='3'){
			tr=tr+"<td style='color: green;'><b>"+data.cDate+"</b></td></tr>";
		}else if(status=='2'){
			
			tr=tr+"<td style='color: green;'><b>"+data.date+"</b></td><td><input type='button' value='Edit' class='btn btn-success' onclick='repair("+data.installId+")'></td></tr>";
		}else{
			tr=tr+"<td style='color: green;'><b>"+data.date+"</b></td><td><input type='button' value='Assign' class='btn btn-primary' onclick='repair("+data.installId+")'></td></tr>";
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
    	var url=context+"/getComplaintDetails/0/1";
    	$('#welcomeResults >tbody').empty();
    	$('#welcomeResults >thead').empty();
    	var tr="<tr><th>#SNO</th><th>CNAME</th><th>PHONE</th><th>ENQUIRY FOR</th><th>QUATATION</th><th>TECHNICIAN</th><th>SPARES REQUIRED</th><th>DATE ON RECEIVED</th><th>ACTION</th></tr>";
    	$('#welcomeResults >thead').html(tr);
    	loadTableData(url,1);
    }
    else if(valueSelected=='2'){
    	maxReached=0;
    	pageCounter=0;
    	var url=context+"/getComplaintDetails/0/2";
    	$('#welcomeResults >tbody').empty();
    	$('#welcomeResults >thead').empty();
    	var tr="<tr><th>#SNO</th><th>CNAME</th><th>PHONE</th><th>ENQUIRY FOR</th><th>QUATATION</th><th>TECHNICIAN</th><th>SPARES REQUIRED</th><th>DATE ON RECEIVED</th><th>ACTION</th></tr>";
    	$('#welcomeResults >thead').html(tr);
    	loadTableData(url,2);
    	
    }else{
    	maxReached=0;
    	pageCounter=0;
    	var url=context+"/getComplaintDetails/0/3";
    	$('#welcomeResults >tbody').empty();
    	$('#welcomeResults >thead').empty();
    	var tr="<tr><th>#SNO</th><th>CNAME</th><th>PHONE</th><th>ENQUIRY FOR</th><th>QUATATION</th><th>TECHNICIAN</th><th>SPARES REQUIRED</th><th>DATE ON CLOSED</th></tr>";
    	$('#welcomeResults >thead').html(tr);
    	loadTableData(url,3);
    }
});

function editComplaint(complaintId){
	
}
function showDetails(cusId){
	var url=context+"/getComplaintHistory/"+cusId;
	var details=makeAjax(url);
	$("#customerDetails").html(details);
	$("#myModal").modal('show');
}

function repair(complaintId){
	//alert("clicke re");
	window.location.href=context+"/repair/"+complaintId;
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
 	var resultType=$('#resultsStatus option:selected').val();
 	var response=makeAjax(context+"/getComplaintDetails/"+pageCounter+"/"+resultType);
 	//alert("dfad"+response.length);
 	if(response.length==0){
 		maxReached=1; //max Reached;
 	}
 	prepareTableRow(response);
 	//$(window).scrollTo(100, 0);
 	}
	 $(window).bind('scroll', bindScroll);
}