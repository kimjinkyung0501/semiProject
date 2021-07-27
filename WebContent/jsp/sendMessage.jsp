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

<form action="SendMessage?id=${sessionScope.accountInfo.a_id}" method="post">

<table>

<tr>
<td>보낸 사람 <input name = "fromId" value="${sessionScope.accountInfo.a_id}">
 </td>
</tr>

<tr>
<td>받는 사람 <input name = "toId">
 </td>
</tr>


<tr>
<td>내용<input  style="text-align:left;  width:300px; height:200px; "
 name = "text" type="text">
 </td>
</tr>

<tr>
<td> <button style="background-color: rgb(162,187,145);color: white;">쪽지 보내기</button>
 </td>
</tr>



</table>
</form>






</body>
</html>