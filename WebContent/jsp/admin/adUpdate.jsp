<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css"> 
</head>
<body>

<div id="login" style="position: absolute; top: 150px;left:12%;width: 80%"">


<form action="AdminUpdate?ex_id=${account.a_id}&ex_pw=${account.a_pw}&ex_name=${account.a_name}&ex_birth=${account.a_birth}" method="post">

<table id="loginForm">
<tr>
<td><h3>관리자 권한으로 수정</h3></td>
</tr>
<tr>
<td style="height: 20px;"></td>
</tr>
<tr>
<td>기존 이름: ${account.a_name }  </td>
</tr>

<tr>
<td><input name="adName" placeholder="공란은 기존정보가 유지됨"> </td>
</tr>

<tr>
<td>기존 ID: ${account.a_id }  </td>
</tr>

<tr>
<td><input name="adId" placeholder="공란은 기존정보가 유지됨"> </td>
</tr>

<tr>
<td>기존 PW: ${account.a_pw }  </td>
</tr>

<tr>
<td><input name="adPw" placeholder="공란은 기존정보가 유지됨"> </td>
</tr>

<tr>
<td>기존 생년월일: ${account.a_birth }  </td>
</tr>

<tr>
<td><input name="adBirth" placeholder="공란은 기존정보가 유지됨"> </td>
</tr>




<tr> 
<td> <button > 수정</button> </td>
</tr>


</table>
</form>


</div>
<footer style="position: absolute; top: 800px;">

</footer>
</body>
</html>