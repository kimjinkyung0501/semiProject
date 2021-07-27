function delectMessage(n, a) {


	if (a == 1) {
		let ok = confirm('정말 삭제 합니까?');

		if (ok) { location.href = 'RMessageDelCon?no=' + n; }
	} else if (a == 2) {

		let ok = confirm('정말 삭제 합니까?');

		if (ok) { location.href = 'SMessageDelCon?no=' + n; }
	}else if(a==3){
		
		let ok = confirm('정말 삭제 합니까?');

		if (ok) { location.href = 'MessageSearchDel?no=' + n; }
	} 

}

//function When(n, a)


function ttt(){
	
	let fromDate = document.getElementById("aa");
	let endDate = document.getElementById("bb");
	alert(fromDate.value);	
	alert(endDate.value);	
	
	
	location.href = 'SearchByDate?fromDate='
	 + fromDate.value +'&endDate='+endDate.value;
}
	
	
