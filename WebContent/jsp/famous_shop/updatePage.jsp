<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css">
</head>
<body>
<div id="board" style="margin-bottom: 200px;">
<form name="formName" action="UpdateShop?f_no=${shop.f_no}" method="post" enctype="multipart/form-data">
<table id="boardMain" border="1">
<tr>
</tr>
<tr>
<th>지역</th>
<td style="height: 50px"><input name="place" type="text" placeholder="${shop.f_place}" style="width: 100%; height: 100%;"></td>
</tr>
<tr>
<th>가게명</th>
<td style="height: 50px"> <input name="name" type="text" placeholder="${shop.f_name}"style="width: 100%; height: 100%;"></td>
</tr>
<tr>
<th>사진</th>
<td style="height: 50px"> <input name="img" type="file"> </td>
</tr>
<tr>
<th>내용</th>
<td style="height: 200px"> <input name="text" style="width: 100%; height: 100%;" type="text" placeholder="${shop.f_text}"></td>
</tr>
<tr>
<th style="height: 20%"></th>
<td align="right"> <button onclick="return updateShop();">수정</button> </td>
</tr>
</table>
</form>
</div>
<footer>

</footer>
</body>
</html>