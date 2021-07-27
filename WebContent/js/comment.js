function delComent(num, n){
	let ok = confirm('삭제하시겠습니까?');
	
	if(ok){
		location.href = "CommentDelController?num="+num + "&no="+n;
	}
	
}

