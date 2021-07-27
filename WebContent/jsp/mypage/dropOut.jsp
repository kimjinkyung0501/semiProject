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
<div id="loginForm" style="margin-bottom: 200px;">

<form action="UserDropOut">


<table>

<tr>
<td><h3>탈퇴 요청서 </h3></td>
</tr>
<tr style="height: 30px;">
</tr>
<tr>
<td colspan="2"><h4>본인확인</h4></td>
</tr>
<tr>

<td> ID<input name ="id"> 

PW<input name ="pw"> </td>
</tr>
<tr style="height: 30px;">
</tr>
<tr >
<td  ><h4>탈퇴 사유</h4>  <br>
<input name="reasone" type="text"  style="width:300px; height:200px; text-align:left;  padding-top:5px;" > </td>
</tr>



<tr>

<td><button > 탈퇴 확인</button> </td>

</tr>
</table>





</form>

</div>
<footer>

</footer>


</body>
</html>