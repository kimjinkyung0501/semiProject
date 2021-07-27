<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css">
</head>
<body>

<div id="board" style="margin-bottom: 200px;">
<h1>등록 페이지</h1>
<form action="RegShop" method="post" enctype="multipart/form-data">
<table id="boardMain" border="1">
<tr>
<th> 가게 이름 </th>
<td> <input style="width: 100%;height: 100%;" type="text" name="shopName"> </td>
</tr>
<tr>
<th> 가게 위치 </th>
<td> <input style="width: 100%;height: 100%;" type="text" name="shopPlace"> </td>
</tr>
<tr>
<th> 음식 사진 </th>
<td> <input type="file" name="shopFood"> </td>
</tr>
<tr>
<th> 가게 설명 </th>

<td> <input type="text" name="shopInfo" style="width: 100%; height: 300px"> </td>
</tr>
<tr>
<td colspan="2" align="right"> <button>등록</button> </td>
</tr>
</table>
</form>
</div>
<footer>

</footer>
</body>
</html>