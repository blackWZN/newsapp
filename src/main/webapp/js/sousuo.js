$(function(){
	sousuo();
})
function sousuo(){
	var p=$("#sousuo").val();
	console.log(p)
	$("#bt").on('click',function(){
		$("#jilu").append(p);
	})
}
