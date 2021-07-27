
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${updateResult}

<p>
<b>${adminPage.a_name}님의 회원정보입니다.</b>
<p> 

<table>

<tr> 
<td>이름: </td>
<td>${adminPage.a_name}</td>
</tr>

<tr> 
<td>아이디: </td>
<td>${adminPage.a_id}</td>
</tr>

<tr> 
<td>비밀번호: </td>
<td>${adminPage.a_pw}</td>
</tr>



<tr> 
<td>생년월일</td>
<td>${adminPage.a_birth}</td>
</tr>



<tr> 
<td><input type ="button" value="관리자페이지로 이동" onclick="location.href='AdminHC'"></td>
</tr>





</table>




</body>
</html>
