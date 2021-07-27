<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css">
<link rel="stylesheet" href="css/notice.css">
</head>
<body>
<div id="board">
<table id="siteMenu" style="width:60%; margin: 0 auto;">
<tr>
<td class="siteMenu_n" align="center"> <a href="M1C">공지사항</a> </td>
<td class="siteMenu_n" align="center"> <a href="TOSController">이용약관</a> </td>
<td class="siteMenu_n" align="center"> <a href="OPController">운영정책</a> </td>
</tr>
</table>
	<h1>공지사항</h1>
	<form action="NoticeSearchController" ">
		<table id="search">
			<tr>
				<td><select  id="select" name="type">
						<option value="all">전체</option>
						<option value="title">제목</option>
						<option value="text">본문</option>
				</select></td>

				<td align="center"><input name="txt"></td>
				<td>
					<button>검색</button>
					</td>
					<c:if test="${accountInfo.a_id eq'admin'}">
					<td>
		<input id="edit" type="button" value="글쓰기" onclick="location.href='NoticeUploadController'">
				</td>
		</c:if>
			</tr>
		</table>
	</form>
	
	
	<table id="boardMain"">


		<!--공지사항 리스트 -->
		<tr>
			
			<th style="width: 70%">제목</th>
			<th style="width: 15%">작성자</th>
			<th style="width: 15%">작성일</th>
		</tr>
		<c:forEach var="b" items="${boards }">
			<tr>
			
				<td><a href="NoticeViewController?num=${b.b_num}">
						${b.b_subject}</a></td>
				<td>${b.b_id} </td>
				<td><fmt:formatDate value="${b.b_date}"
		type="date" dateStyle="long"/></td>
			</tr>
		</c:forEach>
	</table>





	<!-- 검색  -->



	<!-- 페이징 -->
	<table id="paging">
		<tr>
			<td align="center"><a href="NoticePageController?p=1">[맨처음]</a>

				<c:forEach var="p" begin="1" end="${pageCount }">
					<a href="NoticePageController?p=${p }">[${p }]</a>
				</c:forEach> <a href="NoticePageController?p=${pageCount }">[맨끝]</a></td>
		</tr>
	</table>

</div>
<footer>

</footer>
</body>
</html>