$("#in").addClass("active");
var pageCounter=0;
var maxReached=0;
$(document).ready(function(){
	//load table data
	
	var url=context+"/pendings/0/1";
	loadTableData(url);
	$(window).scroll(bindScroll);
});

function bindScroll(){
	   if($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
	       $(window).unbind('scroll');
	       loadMore();
	   }
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
	var demoFlag=null;;
	var noteText=null;
	var addr=null;
	$.each(response, function(index,data){
		if(data.status=='1')
		demoFlag='<b style="color:green">Pending</b> ';
		else 
			demoFlag='no';
		if(data.name==null){
			data.name="-";
		}
		if(data.note==null){
			data.note="";
		}
		
		if(data.note.length>40){
			noteText=data.note.substr(0,40)+"<b>..</b>";
		}else{
			noteText=data.note;
		}
		/*if(data.address.length>20){
			addr=data.note.substr(0,20)+"<b>..</b>";
		}else{
			addr=data.note;
		}*/	
			
		
	var tr="<tr ><td>"+(index+rowCount+1)+"</td><td onclick='showDetails("+data.cusId+")' class='bill'>"+data.cname+"</td><td onclick='showDetails("+data.cusId+")' class='bill'>"+data.phone+"</td>" +
			"<td>"+data.enqId+"</td><td>"+data.name+"</td><td style='color:green'><b>"+data.date+"</b></td><td>"+demoFlag+"</td><td>"+noteText+"</td>"+ 
					"<td><input type='button' value='Reschedule' class='btn btn-primary' onclick='reschedule("+data.installId+")'></td></tr>";
		
			$('#welcomeResults >tbody').append(tr);
	});
}
function loadMore(){
	if(maxReached==0){ //not reached
    	pageCounter++;
    	//alert(pageCounter);
    	//var resultType=$('#resultsStatus option:selected').val();
    	var response=makeAjax(context+"/pendings/"+pageCounter+"/1");
    	//alert("dfad"+response.length);
    	if(response.length==0){
    		maxReached=1; //max Reached;
    	}
    	prepareTableRow(response);
    	//$(window).scrollTo(100, 0);
    	}
	 $(window).bind('scroll', bindScroll);
}

function showDetails(cusId){
	var url=context+"/getCustomerDetails/"+cusId;
	var details=makeAjax(url);
	$("#customerDetails").html(details);
	$("#myModal").modal('show');
}

function reschedule(cusId){
	//alert("clicke re");
	window.location.href=context+"/installation/"+cusId;
}