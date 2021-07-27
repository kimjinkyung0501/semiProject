function idCheck(id){
	if(id ==""){
	
		alert("아이디를 먼저 입력하세요");
		document.form.id.focus();
	 }else{
		url="IdCheck?id=" + id;
      	 location.href=url;
	}
}
function logOut(){
	
	let ok = confirm('정말 로그아웃 합니까?');
	
	if(ok){
	location.href="LogOut";
	}
	}

