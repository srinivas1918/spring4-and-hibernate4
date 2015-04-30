$("#reg").addClass("active");

function showEditForm(){
	window.location.href=context+"/RegEdit";
}

function newRegForm(){
	window.location.href=context+"/New";
}
function showItems(catid){
	
	var type=$("#type").val();
	var url=context+"/getItems/"+catid;
	prepareItems(url,type);
}


function prepareItems(url){
	$("#itemsRootDiv").html('');
	$.ajax({
		url: url,
		type: "GET",
		async:false,
		success:function(response){
			$.each(response, function(index,data){
			
				var boxDiv=document.createElement("div");
				boxDiv.setAttribute("class", "col-md-3 col-sm-4 col-xs-6 myBox");
				
				var dummyDiv=document.createElement("div");
				dummyDiv.setAttribute("class", "dummy");
				
				boxDiv.appendChild(dummyDiv);
				
				var aTag=document.createElement("a");
				aTag.setAttribute("href", "javascript:void(0)");
				aTag.setAttribute("class", "thumbnail purple");
				aTag.setAttribute("onclick", 'showModel('+data.id+')');
				var text = document.createTextNode(data.itemName); 
				aTag.appendChild(text);
				boxDiv.appendChild(aTag);
				
					/*var div= "<div class='col-md-3 col-sm-4 col-xs-6 myBox' >"+
			        			"<div class='dummy'></div>"+
			        			"<a href='javascript:void(0);' class='thumbnail purple' onclick='return callUnits("+JSON.stringify(data)+");'>"
			        			+data.itemName+"</a>'</div>";*/
				
					$("#itemsRootDiv").append(boxDiv);
					
			});			
		},
		error:function(error){
			alert("some problem occured please contact admin");
			return false;
		}
		
	});	
}
function showModel(itemId){
	window.location.href=context+"/edit/"+itemId;
	//$("#view").click(function(){ viewStock(itemId); });
	/*$("#update").click(function(){ updateStock(itemId);alert("afasdf"); });*/
}

function viewMap(id){
	
	$("#myModal2").modal('show');
	
}

$("#addStock").click(function(){
	var unit=$("#qty").val();
	if(unit.length==0){
		return false;
		$("#addStock").focus();
	}
 var url=context+"/saveUnit/"+unit;
 makeAjax(url);
 callUnits($("#itemId").val());
 $("#myModal2").modal('hide');
 callUnits(id);
});

function callUnits(itemId){
	var url=context+"/getUnitItemUnits/"+itemId;
	var response=makeAjax(url);
	loadUnits(response);
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
function loadUnits(response){
	$('#unitsTable>tbody').html('');
	//console.log(response);
	$.each(response, function(index,data){
		
	var tr=	'<tr>'+
 		'<td style="display: none;">'+data.weigthId +'</td>'+
 		'<td>'+data.weigth+' </td>';
	var td;
	if(data.weigthId==data.unitWeightid){
		td='<td><input type="checkbox" checked="checked" value='+data.weigthId+' name="weightid" ></td></tr>';
	}else{
		td='<td><input type="checkbox" name="weightid" ></td></tr>';
	}
	//console.log(tr+td);
 		$('#unitsTable >tbody').append(tr+td);
 	   	
		
	});
}


$("#edit").click(function(){
	if(checkValidations()){
    var favorite = [];
    $.each($("input[name='weightid']:checked"), function(){            
        //favorite.push($(this).val());
    	favorite.push($(this).parent().prev().prev().text());
    });
    
   
	var obj={
		itemId:$("#itemId").val(),
		weight:$("#weight").val(),
		bprice:$("#bprice").val(),
		rprice:$("#rprice").val(),
		weightid:favorite
		
	};
	console.log(obj);
	var url=context+"/editItem";
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
