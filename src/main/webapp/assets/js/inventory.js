$("#in").addClass("active");
$('#cat').on('change', function() {
if(this.value.length!=0){
 var url=context+"/Inventroy/"+this.value;
 load(url);
}else{
	$('#history >tbody').html('');
}
});

function load(url){
	
	var response=makeAjax(url);
	console.log(response);
	prepareStockInfo(response);
}

function makeAjax(url){
	var data=null;
	$.ajax({
		url: url,
		type: "GET",
		async:false,
		success:function(response){
			data=response;
		},
		error:function(){
			alert("some error occured please contact your admin");
		}
		
		});
	return data;
}

function prepareStockInfo(response){
	$('#history >tbody').html('');
	
	$.each(response, function(index,data){
		var newRow="<tr><td>"+(index+1)+"</td><td><a href='javascript:void(0)' onclick='viewStock("+data.itemId+")'>"+data.itemName+"</a></td><td>"+data.updatedOn+"</td><td>"+calculateStock(data.sleft, data.weight)+" Bottles & "+calculateReminder(data.sleft, data.weight)+"Ml</td><td>"+data.weight+"</td></tr>";
		$('#history >tbody').append(newRow);	
	});
	 
	
	
}

function viewStock(itemId){
	
	
	$("#viewStockModel").modal('show');
	var url=context+"/viewStock/"+itemId;
	var response=makeAjax(url);
	prepareTable(response);
	
}

function prepareTable(response){
	$('#viewTable >tbody').html('');
	$.each(response, function(index, data){
		var tr="<tr><td>"+data.item.itemName+"</td><td>"+data.item.itemWight+"</td><td>"+data.updatedOn+"</td><td>"+calculateStock(data.stockQty, data.item.itemWight)+" Bottles & "+calculateReminder(data.stockQty, data.item.itemWight)+
				"Ml</td><td>"+calculateStock(data.stockLeft, data.item.itemWight)+" Bottles & "+calculateReminder(data.stockLeft, data.item.itemWight)+"Ml</td></tr>";
		$('#viewTable >tbody').append(tr);
	});
}

function calculateStock(stock, weight){
	return (stock/weight).toFixed(0);
}

function calculateReminder(stock,weight){
	return (stock%weight).toFixed(0);
}