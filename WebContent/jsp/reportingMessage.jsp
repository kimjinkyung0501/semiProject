<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<td>받는 사람 <input name = "toId" value="admin">
 </td>
</tr>


<tr>
<td>내용<input style="text-align:left;  width:300px; height:200px;"
 name = "text" type="text" value="신고내용을 작성 후, 꼭 ' ~~를(을) 신고합니다'를 꼭 넣어주세요 ">
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