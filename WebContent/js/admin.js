
function adDropOut(id, pw){
	
	let ok = confirm('정말 삭제 합니까?');
	
	if(ok){
		
	url="jsp/adDropOut.jsp?id=" + id+'&pw='+pw;
		window.open(url,"post","width =400, height=250");
}}