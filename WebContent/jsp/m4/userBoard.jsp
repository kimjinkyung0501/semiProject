<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function logincheck()	{
	

		alert('로그인 후 이용가능합니다!');
		
	
	
}


</script>
<link rel="stylesheet" href="css/board.css"> 
</head>
<body>
<div id="board">

	<h1>자유 게시판</h1>

	<table id="boardMain">
		<tr align="center">
			<th width="500">제목</th>
			<th width="120">작성자</th>
			<th width="100">작성일</th>
			<th width="100">조회수</th>
		</tr>

		<c:forEach var="r" items="${reviews }">
			<tr>
				<td onclick="location.href='ReviewDetailController?no=${r.ub_no }'"> ${r.ub_title } </td>
				<td onclick="location.href='ReviewDetailController?no=${r.ub_no }'"> ${r.ub_id } </td>
				<td onclick="location.href='ReviewDetailController?no=${r.ub_no }'"><fmt:formatDate value="${r.ub_date}" type="date"/></td>
				<td>${r.ub_count }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<form action="UserBoardSearchController">
		<table id="search2">
			<tr>
				<td><select id="select2" name="type">
						<option value="all">전체</option>
						<option value="title">제목</option>
						<option value="text">본문</option>
				</select></td>

				<td align="center"><input name="txt"></td>
				<td align="left">
					<button>검색</button>
					</td>
					<td>
		<c:choose>
		<c:when test="${sessionScope.accountInfo.a_id == null}">
		<input id="edit" type="button" value="글쓰기" onclick="logincheck()">
		</c:when>
		<c:when test="${sessionScope.accountInfo.a_id != null}">
		<input id="edit" type="button" value="글쓰기" onclick="location.href='UserRegController'">
	    </c:when>
		</c:choose>
				</td>
			</tr>
		</table>
	</form>
	
	
	
	
	
	
	
<table id="paging">
		<tr>
			<td align="center"><a href="UserBoardPageController?p=1">[맨처음]</a>

				<c:forEach var="p" begin="1" end="${pageCount }">
					<a href="UserBoardPageController?p=${p }">[${p }]</a>
				</c:forEach> <a href="UserBoardPageController?p=${pageCount }">[맨끝]</a></td>
		</tr>
	</table>
</div>
<footer>

</footer>
</body>
</html>