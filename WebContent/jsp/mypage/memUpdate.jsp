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
<h1>정보 수정하기</h1>
<form action="MemUpdate?ex_id=${sessionScope.accountInfo.a_id}&ex_pw=${sessionScope.accountInfo.a_pw}&ex_name=${sessionScope.accountInfo.a_name}&ex_birth=${sessionScope.accountInfo.a_birth}" method="post">

<table id="myPage">

<tr>
<td>${sessionScope.accountInfo.a_name}님의 정보</td>
</tr>

<tr>
<td>기존 등록된 이름 : ${sessionScope.accountInfo.a_name}</td>
</tr>
<tr>
<td><input name= "nameUP" placeholder="공란은 기존정보가 유지됨"> </td>
</tr>
<tr>
<td>기존 등록된 ID : ${sessionScope.accountInfo.a_id}</td>
</tr>
<tr>
<td><input name ="idUP"placeholder="공란은 기존정보가 유지됨" ></td>
</tr>

<tr>
<td>기존 등록된 PW : ${sessionScope.accountInfo.a_pw}</td>
</tr>
<tr>
<td><input name="pwUP"placeholder="공란은 기존정보가 유지됨" ></td>
</tr>

<tr>
<td>기존 등록된 생년월일 : ${sessionScope.accountInfo.a_birth}</td>
</tr>
<tr>
<td><input name="birthUP"placeholder="공란은 기존정보가 유지됨" ></td>
</tr>

<tr>

<td><button>수정완료</button>  </td>
</tr>


</table>
</form>
</div>
<footer>

</footer>
</body>
</html>