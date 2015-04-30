function viewMap(){
	$("#myModal").modal('show');
	
}

$("#addStock").click(function(){
	var unit=$("#qty").val();
	if(unit.length==0){
		return false;
		$("#addStock").focus();
	}
 var url=context+"/saveUnit/"+unit;
 var response=makeAjax(url);
 callUnits(response.text);
 $("#myModal").modal('hide');
});
function callUnits(itemId){
	var url=context+"/getWeightsList";
	var response=makeAjax(url);
	loadUnits(response);
}
function loadUnits(response){
	$('#unitsTable>tbody').html('');
	console.log(response);
	$.each(response, function(index,data){
		
	var tr=	'<tr>'+
 		'<td>'+data.wight+' </td>';
	
		td='<td><input type="checkbox" name="weightid" value='+data.id+' ></td></tr>';
	
	//console.log(tr+td);
 		$('#unitsTable >tbody').append(tr+td);
 	   	
		
	});
}
$("#edit").click(function(){
	if(checkValidations()){
	var stock=$("#stock").val();
	if(stock.length==0){
		alert("Stock  required");
		$("#stock").focus();
		return false;
	}
	var bname=$("#itemName").val();
	if(bname.length==0){
		alert("item name required");
		$("#itemName").focus();
		return false;
	}
	var isPrasent=	$.inArray(bname, items);
	//alert(isPrasent);
		if(isPrasent!= -1){
			$("#errorModal").modal('show');
			return false;
		}
		
		 var category=$("#cat option:selected" ).val();
		    if(category.length==0){
		    	alert("select category from drop down");
		    	return false;
		    }	
		    
    var favorite = [];
    $.each($("input[name='weightid']:checked"), function(){            
        //favorite.push($(this).val());
    	favorite.push($(this).val());
    });
    console.log(favorite);
    
   
	var obj={
		itemId:category,
		itemName:$("#itemName").val(),
		weight:$("#weight").val(),
		bprice:$("#bprice").val(),
		rprice:$("#rprice").val(),
		stockAdded:$("#stock").val(),
		weightid:favorite
		
	};
	console.log(obj);
	var url=context+"/newItem";
	submit(url,obj);
	}
});
function submit(url,obj){
	$.ajax({
		url: url,
		type: "POST",
		data: JSON.stringify(obj),
		contentType: 'application/json',
		async:false,
		success:function(response){
			//data=response;
			//alert("New Unit is added to store. your page will be reload")
			alert("Brand added succesfully..");
			window.location.href=context+"/RegEdit";
		},
		error:function(){
			alert("some error occured please contact your admin");
		}
		
		});
}
function makeAjax(url){
	var data=null;
	$.ajax({
		url: url,
		type: "GET",
		async:false,
		success:function(response){
			data=response;
			//alert("New Unit is added to store. your page will be reload")
		},
		error:function(){
			alert("some error occured please contact your admin");
		}
		
		});
	return data;
}

