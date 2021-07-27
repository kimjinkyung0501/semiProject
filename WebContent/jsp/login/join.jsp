<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
</head>

<script type="text/javascript">
function idCheck(id){
	if(id ==""){
	
		alert("아이디를 먼저 입력하세요");
		document.form.id.focus();
	 }else{
		url="IdCheck?id=" + id;
      	 location.href=url;
	}
}



</script>
<body>

<a href="HC"><img alt="" src="img/2TEAM.png" style="margin-left: 43%;margin-top: 100px"> </a>


<form action="LogJoin" name="joinForm" method="post" onsubmit="return call();">

<table id="joinForm">
<tr>
<td>아이디 <input type="button" id="check"
 value = "중복확인" onclick="idCheck(this.form.id.value)">
  
 </td>
</tr>
<tr>
<td><input name="id" value="${id }" required id="inputId" > 
 &nbsp;${id }&nbsp;
 <input type="hidden" value="${result}" id="asd">
<c:choose>
<c:when test="${check eq false}">
사용가능한 아이디 입니다!

</c:when>
<c:when test="${check eq true}">
이미 사용하고 있는 아이디 입니다!

 </c:when>

</c:choose>

 </td>
</tr>

<tr>
<td>비밀번호</td>
</tr>
<tr>
<td><input type="password" name="pw" > </td>
</tr>

<tr>
<td>비밀번호 재확인</td>
</tr>
<tr>
<td><input name="pw2" type="password"  placeholder="위의 비밀번호와 똑같이 입력해주세요"> </td>
</tr>


<tr>
<td>이름</td>
</tr>
<tr>
<td><input name="name"> </td>
</tr>



<tr>
<td>생년월일</td>
</tr>
<tr>
<td><input name="birth" type="date"> </td>
</tr>



<tr>
<td><button>가입</button></td>
</tr>




</table>

</form>





</body>
<script type = "text/javascript" src="js/check.js"></script>
<script type = "text/javascript" src="js/JS.js"></script>
<script type = "text/javascript" src="js/valid.js"></script>

</html>