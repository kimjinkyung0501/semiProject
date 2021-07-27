<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
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

</script>
<link rel="stylesheet" href="css/catch.css"> 
</head>
<body>
<div id="catch" style="margin-bottom: 200px;">
<h1>캐치마인드</h1>
<form name="regForm" action="RegPaint" method="post" enctype="multipart/form-data">
<table id="catchMain" border="1">
<tr>
<td  style="background-color: rgb(162,187,145);
	color: white;"> 게시글 제목 </td>
<td> <input name="title" type="text" style="width: 100%;"> 
<input type="hidden" name="u_id" value="${sessionScope.accountInfo.a_id}"> </td>
</tr>
<tr>
<td  style="background-color: rgb(162,187,145);
	color: white;"> 그림 등록 </td>
<td> <input name="img" type="file"> </td>
</tr>
<tr>
<td  style="background-color: rgb(162,187,145);
	color: white;">  정답 </td>
<td> <input name="ans" type="text" style="width: 100%;"> </td>
</tr>
<tr>
<td  style="background-color: rgb(162,187,145);
	color: white;"> 힌트 작성 </td>
<td> <input name="hint" type="text" style="width: 100%;"> </td>
</tr>
<tr>
<td  style="background-color: rgb(162,187,145);
	color: white;"></td>
<td> <button onclick="return regCheck('${p.p_ans}')" style="width: 20%; float: right;" >등록하기</button> </td>
</tr>
</table>
</form>
</div>
<footer>

</footer>
</body>
</html>