function reviewDel(n){
	let ok = confirm('삭제하시겠습니까?');
	
	if(ok){
		location.href = 'ReviewDelController?no=' +n;
	}
	
}

function updateComent(num, n){
	let ok = confirm('수정하시겠습니까?');
	
	if(ok){
		location.href = "CommentUpdateController?num="+num + "&no="+n;
	}
	
}