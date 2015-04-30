function checkValidations(){
	//alert("afd");
	
	var weight=$("#weight").val();
	var bprice=$("#bprice").val();
	var rprice=$("#rprice").val();
	
	
	
	if(weight.length==0){
		alert("weight is required");
		$("#weight").focus();
		return false;
	}
	if(bprice.length==0){
		alert("bar price required");
		$("#bprice").focus();
		return false;
	}
	if(rprice.length==0){
		alert("rest price required");
		$("#rprice").focus();
		return false;
	}
	
	return true;
	
}
$("#weight").on("keyup",function (event) {  
	
	 var valid =/^\d{0,11}?$/.test(this.value),
   val = this.value;

if(!valid){
   console.log("Invalid input!");
   this.value = val.substring(0, val.length - 1);
}
	
  // $("#newUnit").val(($(this).val()*(json.itemCost)).toFixed(2));
});

$("#bprice").on("keyup",function (event) {  
	
	 var valid =/^\d{0,11}?$/.test(this.value),
  val = this.value;

if(!valid){
  console.log("Invalid input!");
  this.value = val.substring(0, val.length - 1);
}
	
 // $("#newUnit").val(($(this).val()*(json.itemCost)).toFixed(2));
});

$("#rprice").on("keyup",function (event) {  
	
	 var valid =/^\d{0,11}?$/.test(this.value),
  val = this.value;

if(!valid){
  console.log("Invalid input!");
  this.value = val.substring(0, val.length - 1);
}
	
 // $("#newUnit").val(($(this).val()*(json.itemCost)).toFixed(2));
});

$("#stock").on("keyup",function (event) {  
	
	 var valid =/^\d{0,11}?$/.test(this.value),
 val = this.value;

if(!valid){
 console.log("Invalid input!");
 this.value = val.substring(0, val.length - 1);
}
	
// $("#newUnit").val(($(this).val()*(json.itemCost)).toFixed(2));
});

$('.table>tbody> tr').live('click',function(event) {
	
    if (event.target.type !== 'checkbox') {
        $(':checkbox', this).trigger('click');
    }
});