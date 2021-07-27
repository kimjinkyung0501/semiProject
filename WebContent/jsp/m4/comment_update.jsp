<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/userBoard.js"></script>
<script type="text/javascript" src="js/comment.js"></script>
<link rel="stylesheet" href="css/board.css"> 
</head>
<body>
<div id="board">
<h1>자유 게시판</h1>
	<table id="boardMain" border="1">
		<tr align="center">
			<th width="60%">제목</th> 
			<th width="10%">작성자</th>
			<th width="10%">작성일</th>
			<th width="10%">조회수</th>
		</tr>
		<tr>
		<td>${dt.ub_title }</td>
		<td>${dt.ub_id }</td>
		<td>${dt.ub_date }</td>
		<td>${dt.ub_count }</td>
		</tr>
		<tr align="left">
			<td colspan="10">${dt.ub_content }</td>
		</tr>
	<c:if test="${dt.ub_file != null}">
		<tr align="left">
			<td colspan="10" ><img style="width: 300px; height: 250px;" src="img/${dt.ub_file }"></td>
		</tr>
		</c:if>
	</table>
	</div>
	
		<!-- 댓글 목록 -->
<form action="CommentUpdateController" method="post">
	<table style="margin-left: auto;margin-right: auto; width: 80%;">
	<tr>
	<tr>
		<td colspan="2"style="border-bottom: 4px solid rgb(162,187,145);font-size: 25px;"><b>수정</b></td>
	</tr>
		<tr>
			<td width="500px;" align="center">
				<input name="co_content" value="${com.co_cotent}" style="width:50%;height: 50px;">
				<input name="num" value="${com.co_num }" type="hidden">
				<input name="no" value="${dt.ub_no }" type="hidden">
					<!--댓글 내용 부분 -->
			
				<button>수정 완료</button>
			</td>
		</tr>
		
		
	</table>
</form>
		
		<table style="margin: 0 auto;
	margin-top: 20px;
	margin-bottom:50px;">
		<tr>
			<td align="center"><a href="CpageController?no=${param.no  }&p=1">[맨처음]</a>

				<c:forEach var="p" begin="1" end="${pageCount }">
					<a href="CpageController?no=${param.no  }&p=${p }">[${p }]</a>
				</c:forEach> <a href="CpageController?no=${param.no  }&p=${pageCount }">[맨끝]</a></td>
		</tr>
	</table>

	
	<footer>

</footer>
</body>
</html>