function sendUserName(){
	var userName = $("#userName").val();
	var url = "http://90.89.7.235:8081/getViewerCount?boxname=textBox&username="+userName
	$.get(url, function( data ) {
	  $("#textBox").text(data);
	});
	var url = "http://90.89.7.235:8081/getViewerCount?boxname=textBox2&username="+userName
	$.get(url, function( data ) {
	  $("#textBox2").text(data);
	});
	var url = "http://90.89.7.235:8081/getViewerCount?boxname=textBox3&username="+userName
	$.get(url, function( data ) {
	  $("#textBox3").text(data);
	});
}
