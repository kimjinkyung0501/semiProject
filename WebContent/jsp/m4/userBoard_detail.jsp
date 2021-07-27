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
<script type="text/javascript">
function loginCheck()	{
	
	
	alert('로그인 후 이용가능합니다!');

	return false;	


}
function logIn(id) {
	if (id == null) {
		alert('먼저 로그인을 해주세요');
		return false;
	} 

}
function updateComent(num, n){
	let ok = confirm('수정하시겠습니까?');
	
	if(ok){
		location.href = "CommentUpdateController?num="+num + "&no="+n;
	}
	
}
</script>
<link rel="stylesheet" href="css/board.css"> 
</head>
<body>
<div id="board">
<h1>자유 게시판</h1>
	<table id="boardMain" >
		<tr align="center">
		 
			<th width="70%">제목</th> 
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
			<td colspan="10" style="border: none;">
			${dt.ub_content }
			</td>
		</tr>
	<c:if test="${dt.ub_file != null}">
		<tr align="left">
			<td colspan="10" style="border:none;" ><img style="width: 500px; height: 500px;" src="img/${dt.ub_file }"></td>
		</tr>
		</c:if>
	</table>
	<table  style="width: 80%;	margin: 0 auto;
text-align: right;margin-bottom: 100px;">
		<tr>
			<td>
				<c:if test="${dt.ub_id eq sessionScope.accountInfo.a_id || sessionScope.accountInfo.a_id eq 'admin'}">
				<button onclick="location.href='ReviewUpdateController?no=${dt.ub_no}'">수정</button>
				<button onclick="reviewDel('${dt.ub_no}');">삭제</button>
				</c:if>
				<button onclick="location.href='M4C'">목록으로</button>
			</td>
		</tr>
	</table>
	
	<table style="margin-left: auto;margin-right: auto; width: 80%;">
		<tr>
		<td colspan="2"style="border-bottom: 4px solid rgb(162,187,145);font-size: 25px;"><b>댓글</b></td>
		</tr>
	<c:forEach var="comment" items="${comments}">
		<!-- 댓글 목록 -->
	
		<tr>
			<td colspan="2">
				<b>${comment.co_id}	</b>
			</td>
		</tr>
		<tr>	
			<td >
				
				${comment.co_cotent}
					<!--댓글 내용 부분 -->
				
			</td>
			<td align="right">
			<c:if test="${comment.co_id eq sessionScope.accountInfo.a_id || sessionScope.accountInfo.a_id eq 'admin'}">
				<button onclick="updateComent(${comment.co_num}, ${dt.ub_no });">수정</button>
				<button onclick="delComent(${comment.co_num}, ${dt.ub_no });">삭제</button>
				</c:if>
			</td>
		</tr>
		<tr>	
			<td colspan="2" style="border-bottom: 2px solid rgb(162,187,145)">
			${comment.co_date}
			</td>
			
		</tr>	
		
		</c:forEach>
	</table>
		
		<table style="margin: 0 auto;
	margin-top: 40px;
	margin-bottom:50px;">
		<tr>
			<td align="center"><a href="CpageController?no=${param.no  }&p=1">[맨처음]</a>

				<c:forEach var="p" begin="1" end="${pageCount }">
					<a href="CpageController?no=${param.no  }&p=${p }">[${p }]</a>
				</c:forEach> <a href="CpageController?no=${param.no  }&p=${pageCount }">[맨끝]</a></td>
		</tr>
	</table>
			<form action="ReviewDetailController" method="Post">
		<table style="margin-left: auto;margin-right: auto; margin-bottom: 200px;">
			<!-- 여기 input에 게시판 넘버랑 아이디 불러올 거 -->
			<tr>
			<td>
			<input type="hidden" name="no" value="${param.no }">
			<input type="hidden" name="co_board" value="${param.no }">
			<input type="hidden" name="co_id" value="${sessionScope.accountInfo.a_id}">
			</td>
			<td>
				
				<textarea name="co_content" rows="4" cols="70"></textarea>		
				
			</td>
			<td>
					<c:choose>
					<c:when test="${sessionScope.accountInfo == null}">
					<input style="color: white; background-color:rgb(162,187,145) " type="button" value="댓글등록" onclick="logIn(${sessionScope.accountInfo.a_id})">
					</c:when>
					<c:when test="${sessionScope.accountInfo != null}">
					<button>댓글등록</button>
					</c:when>
					</c:choose>
			</td>
	</table>
			</form>
	
	
	</div>
	
	<footer>

</footer>
</body>
</html>