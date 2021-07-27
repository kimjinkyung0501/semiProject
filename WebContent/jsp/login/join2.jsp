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
<body>

<a href="HC"><img alt="" src="img/2TEAM.png" style="margin-left: 43%;margin-top: 100px"></a>

<table id="resultForm"  >

<tr>
<td><h2>${a.a_id}(${a.a_name})님</h2></td>
</tr>
<tr>
<td><h2>가입해주셔서 감사합니다!</h2></td>
</tr>
<tr>
<td><input id="loginb" type="button" value="로그인하러 가기" onclick="location.href='LogJoin'"></td>
</tr>
</table>







</body>
</html>