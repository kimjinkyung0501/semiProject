<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css"> 
</head>
<body>
<div id="board" style="margin-bottom: 200px;">
<h1>상세화면</h1>
<table id="boardMain">
<tr>
<th>지역</th>
<th>가게명</th>
<th>등록날짜</th>
</tr>
<tr>
<td> ${shop.f_place} </td>
<td> ${shop.f_name} </td>
<td> <fmt:formatDate value="${shop.date}" type="both"
						dateStyle="short" timeStyle="short" /> </td>
</tr>
<tr>
<td colspan="3" align="center"> <img src="img/${shop.f_img}" style="width: 500px;height: 500px;"> </td>
</tr>
<tr>
<td colspan="3"> ${shop.f_text} </td>
</tr>
</table>
<c:if test="${sessionScope.accountInfo.a_id == 'admin'}">
<div align="right" style="margin-right: 110px;">
 <button onclick="location.href='UpdateShop?f_no=${shop.f_no}'">수정</button> 
<button onclick="return toDelete('${shop.f_no}','${place_name}');">삭제</button>
</div>
</c:if>

</div>
<footer>

</footer>

</body>
</html>