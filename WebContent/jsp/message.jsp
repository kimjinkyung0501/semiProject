<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/message.css">
</head>
<body>
<c:choose>
<c:when test="${empty sessionScope.accountInfo}">
<b>로그인 먼저해주세요!</b>
</c:when>
<c:when test="${not empty sessionScope.accountInfo}">

<b>${sessionScope.accountInfo.a_name}님 안녕하세요!</b> <br>

	<table style="border: 10px">
		<tr>
			<td>
			<input style="background-color: rgb(162,187,145);color: white;" type="button" value="쪽지 보내기" 
			onclick ="location.href='SendMessage'">
			</td>
		
			<td><input  style="background-color: rgb(162,187,145);color: white;" type="button" value="보낸 메시지" 
			onclick ="location.href='SentMessage?id=${sessionScope.accountInfo.a_id}'">
  </td>
			<td><input style="background-color: rgb(162,187,145);color: white;" type="button" value="받은 메시지" 
			onclick ="location.href='ReceivedMessage?id=${sessionScope.accountInfo.a_id}'">
  </td>
			<td><input style="background-color: rgb(162,187,145);color: white;" type="button" value="불편&신고" 
			onclick ="location.href='Reporting'">
			</td>
	<td>
	<input style="background-color: rgb(162,187,145);color: white;" type="button" value="쪽지검색" 
			onclick ="location.href='MessageSearch'">
         	
		</td>
		</tr>
		
	</table>

</c:when>
</c:choose>

<div>

		 <jsp:include page="${messageContentPage}"></jsp:include> 
		
		</div>




</body>
</html>