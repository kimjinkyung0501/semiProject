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





<a href="HC"><img alt="" src="img/2TEAM.png"  style="margin-left: 43%;margin-top: 100px"></a>


<form action="Login" method="post">
<table id="loginForm">


<tr>
<td>
<input name="id" placeholder="아이디"> </td>
</tr>

<tr>
<td>
<input name="pw"placeholder="비밀번호" type="password">
</td>
</tr>

<tr>
<td>
<button>로그인</button>
</td>
</tr>
<tr>
<td>
<input id="regb" type="button" value="회원가입" onclick="location.href='Join'">
</td>
</tr>


</table>




</form>

</body>
</html>