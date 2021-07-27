<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h1>리스트</h1>
<table  id="boardMain">
<tr>
<th>지역</th>
<th>가게명</th>
<th>등록날짜</th>
</tr>
<c:forEach var="s" items="${shops}">
<tr>
<td> <a href="ShopDetail?f_no=${s.f_no}&place_name=${f_place}">${s.f_place}</a> </td>
<td> <a href="ShopDetail?f_no=${s.f_no}&place_name=${f_place}">${s.f_name}</a> </td>
<td> <a href="ShopDetail?f_no=${s.f_no}&place_name=${f_place}">${s.date}</a> </td>
</tr>
</c:forEach>
</table>
<table id="paging">
		<tr>
			<td align="center"><a href="FamousPageController?p=1">[맨처음]</a>

				<c:forEach var="p" begin="1" end="${pageCount }">
					<a href="FamousPageController?p=${p}">[${p}]</a>
				</c:forEach> <a href="FamousPageController?p=${pageCount}">[맨끝]</a></td>
		</tr>
	</table>
</div>
<footer>
</footer>
</body>
</html>