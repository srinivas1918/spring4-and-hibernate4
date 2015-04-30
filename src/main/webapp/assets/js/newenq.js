$("#reports").addClass("active");
$("#phone").on("keyup",function (event) {  
	
	 var valid =/^\d{0,11}?$/.test(this.value),
   val = this.value;

if(!valid){
   console.log("Invalid input!");
   this.value = val.substring(0, val.length - 1);
}
	
  // $("#newUnit").val(($(this).val()*(json.itemCost)).toFixed(2));
});

function validate(){

	var phone=$("#phone").val();
	
	if(phone.length==0){
		$("#phone").focus();
		alert("Please enter phone");
		return false;
	}
	var cname=$("#cname").val();
	
	if(cname.length==0){
		$("#cname").focus();
		alert("Please enter name");
		return false;
	}
	
	var quatation=$("#enq").val();
	if(quatation.length==0){
		$("#enq").focus();
		alert("Please enter Enquairy");
		return false;
	}
	
	var demo=$('input[name="demo"]:checked').val();

	if(demo==undefined){
		alert("Please specify demo given or not");
		return false;
	}
	
	var demo1=$('#demo1').val();

	if(demo1.length==0){
		$('#demo1').focus();
		alert("Please specify followup date");
		return false;
	}
	$('#enqForm').submit(); 
}

$('select').on('change', function (e) {
    var optionSelected = $("option:selected", this);
    var valueSelected = this.value;
    
    if(valueSelected=='1'){
    	$("#fpd").show();
    	$("#save").text("save");
    	document.getElementById("demo1").value = "";
    }
    else if(valueSelected=='2'){
    	$("#fpd").hide();
    	$("#save").text("Close");
    	var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!

        var yyyy = today.getFullYear();
        if(dd<10){
            dd='0'+dd;
        } 
        if(mm<10){
            mm='0'+mm;
        } 
        var today = yyyy+'-'+mm+'-'+dd;
        document.getElementById("demo1").value = today;
    	
    }else{
    	$("#fpd").hide();
    	$("#save").text("Reject It!");
    	var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!

        var yyyy = today.getFullYear();
        if(dd<10){
            dd='0'+dd;
        } 
        if(mm<10){
            mm='0'+mm;
        } 
        var today = yyyy+'-'+mm+'-'+dd;
        document.getElementById("demo1").value = today;
    }
});