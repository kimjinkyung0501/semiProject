function NoticeDel(n){
	let ok = confirm('정말 삭제 하시겠습니까?')
	
	if(ok){
		location.href = 'NoticeDelController?num='+n;
		
		
	}
}