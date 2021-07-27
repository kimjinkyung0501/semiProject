<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/myPage.css">
</head>
<body>
<div id="myPage">

<h1>MyPage</h1>


<h2><b>${sessionScope.accountInfo.a_name}님 안녕하세요!
${sessionScope.accountInfo.a_name}님의 회원정보입니다.</b></h2>
<table id="myPageForm">

<tr> 
<td>이름: </td>
<td>${sessionScope.accountInfo.a_name}</td>
</tr>

<tr> 
<td>아이디: </td>
<td>${sessionScope.accountInfo.a_id}</td>
</tr>

<tr> 
<td>비밀번호: </td>
<td>${sessionScope.accountInfo.a_pw}</td>
</tr>



<tr> 
<td>생년월일</td>
<td>${sessionScope.accountInfo.a_birth}</td>
</tr>


<tr> 
<td colspan="2"><input id="myinb" type="button" value="정보수정" onclick="location.href='MemUpdate'"></td>
</tr>
<tr> 
<td colspan="2"><input id="myinb" type="button" value="탈퇴" onclick="location.href='DropOut'"></td>
</tr>




</table>


</div>

<footer>


</footer>









</body>
</html>