//인풋 태그를 설정
var i1Input = document.joinForm.id;
var i2Input = document.joinForm.name;
var i3Input = document.joinForm.pw;
var i4Input = document.joinForm.pw2;
var i5Input = document.joinForm.birth;
var i6Input = document.getElementById("asd");

function changeResult() {
	

	i6Input.value = 'f';
}
	i1Input.addEventListener("keyup", changeResult);

function call() {

	
	
	
	alert(i6Input.value);
	if (check4(i6Input)) {

		alert('사용 불가능한 아이디이거나 중복검사를 해주세요!');
		return false;
	}


	if (notEquals(i3Input, i4Input)) {
		alert('비밀번호가 서로 다릅니다!');

		i3Input.value = "";
		i4Input.value = "";
		i3Input.focus();

		return false;
	}

	if (isEmpty(i1Input)
		|| lessThan(i1Input, 3)) {
		alert('아이디는 3글자 이상의 알파벳입니다!');

		i1Input.value = "";
		i1Input.focus();

		return false;
	}

	if (isEmpty(i2Input)) {

		alert('이름을 입력해주세요!');

		i2Input.value = "";
		i2Input.focus();

		return false;

	}

	if (isEmpty(i5Input)) {

		alert('생년월일을 선택해주세요!');
		i5Input.value = "";
		i5Input.focus();

		return false;
	}

	if (check4(i6Input)) {

		alert('사용 불가능한 아이디입니다!');
		return false;
	}


	return true;
}




function regPaint(id) {
	if (id == "") {
		alert("로그인을 먼저 해주세요");
		return false;
	} else {
		let ok = confirm("그림을 작성하시겠습니까?");
		if (ok == true) {
			location.href = "RegPaint?a_id=" + id;
			return true;
		} else {
			return false;
		}
	}

}

function logIn(id) {
	if (id == null) {
		alert('먼저 로그인을 해주세요');
		return false;
	} else {
		return true;
	}

}


function regCheck() {
	let title = document.regForm.title;
	let img = document.regForm.img;
	let ans = document.regForm.ans;
	let hint = document.regForm.hint;


	if (isEmpty(title)) {
		title.focus();
		alert("제목을 입력해주세요");
		return false;
	}
	if (isEmpty(img)) {
		img.focus();
		alert("사진을 등록해주세요");
		return false;
	}
	if (isEmpty(ans)) {
		ans.focus();
		alert("정답을 입력해주세요");
		return false;
	}
	if (isEmpty(hint)) {
		hint.focus();
		alert("힌트를 입력해주세요");
		return false;
	}
	return true;
}

function regComment(result) {
	let c_input = document.formName.comment.value;
	let a_input = document.formName.answer.value;
	console.log(result);

	if (c_input == "" || a_input == "") {
		alert('내용을 입력해주세요');
		return false;
	}
	if (result == "yes") {
		alert('이미 정답이 있습니다.');
		return false;
	}
	else if (result == "no") {
		return true;
	}
	return true;
}

function deleteContents(p_no) {
	let ok = confirm('정말 삭제하실껀가요?');
	if (ok == true) {
		location.href = "DeleteController2?p_no=" + p_no;
		return true;
	}
	return false;



}
function updateShop() {
	let name_input = document.formName.name;
	let place_input = document.formName.place;
	let img_input = document.formName.img;
	let text_input = document.formName.text;

	if (isEmpty(name_input)) {
		name_input.focus();
		alert("제목을 입력하세요");
		return false;
	}
	if (isEmpty(place_input)) {
		place_input.focus();
		alert("장소를 입력하세요");
		return false;
	}
	if (isEmpty(img_input)) {
		img_input.focus();
		alert("사진을 넣어주세요");
		return false;
	}
	if (isEmpty(text_input)) {
		text_input.focus();
		alert("내용을 입력하세요");
		return false;
	}
	return true;

	/*지역 맛집 이미지 클릭 시 해당 게시판 이동*/

}
function goController() {
	let element =
		document.getElementById('div1').innerText;

	location.href = "GoGroup?place_name=" + element;
}
function goController2() {
	let element =
		document.getElementById('div2').innerText;

	location.href = "GoGroup?place_name=" + element;
}
function goController3() {
	let element =
		document.getElementById('div3').innerText;

	location.href = "GoGroup?place_name=" + element;
}
function goController4() {
	let element =
		document.getElementById('div4').innerText;

	location.href = "GoGroup?place_name=" + element;
}
function goController5() {
	let element =
		document.getElementById('div5').innerText;

	location.href = "GoGroup?place_name=" + element;
}
function goController6() {
	let element =
		document.getElementById('div6').innerText;

	location.href = "GoGroup?place_name=" + element;
}



/*삭제 컨트롤러로 이동*/

function toDelete(f_no, place_name) {
	let ok = confirm('정말 삭제 하시겠습니까?');
	alert(f_no);
	if (ok == true) {
		location.href = "DeleteController?f_no=" + f_no + "&place_name=" + place_name;
		return true;
	}
	return false;
}

