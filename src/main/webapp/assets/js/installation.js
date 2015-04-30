$("#in").addClass("active");


function validate(){
	var demo1=$('#demo1').val();

	if(demo1.length==0){
		$('#demo1').focus();
		alert("Please specify installation date");
		return false;
	}
	$("#installForm").submit();
}