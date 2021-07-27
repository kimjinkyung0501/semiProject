<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function regComment(result) {
	let c_input = document.formName.comment.value;
	let a_input = document.formName.answer.value;
	console.log(result);

	if (c_input == "" || a_input == "") {
		alert('내용을 입력해주세요');
		return false;
	}
	if(result=="yes"){
		alert('이미 정답이 있습니다.');
		return false;
	}
	else if(result=="no"){
		return true; 
	}
		return true;
}

</script>
<link rel="stylesheet" href="css/catch.css">
</head>

<body>
<div id="catch">
	<form action="RegComment?p=1&p_no=${param.p_no}" method="post"
		name="formName">
		<table>
			<tr>
				<td><input type="hidden" name="ans" value="${p.p_ans}">
				</td>
				<td><input type="hidden" name="p_no" value="${p.p_id}">
				</td>
			</tr>
		</table>


		<table>
			<tr>
				<td><input type="hidden" name="u_id"
					value="${sessionScope.accountInfo.a_id}"></td>
			</tr>
		</table>

<h1>캐치마인드</h1>
		<table id="catchMain2" border="1">

			<tr>
				<th width="55%">제목</th>
				<th width="15%">ID</th>
				<th width="15%">Hint</th>
				<th width="15%">작성일</th>
			</tr>
			<tr>
			<td>${p.p_title}</td>
			<td>${p.p_id}</td>
			<td>${p.p_hint}</td>
			<td>${p.p_date}</td>
			
			</tr>
			<tr>
				<td colspan="4"><img src="img/${p.p_img }"></td>
			</tr>
			</table>
			<table id="catchMain3">
			<tr>
			<th width="10%">ID</th>
			<th width="35%">코멘트</th>
			<th width="35%">정답</th>
			<th width="20">작성일</th>			
			</tr>
			<c:forEach var="m" items="${comments}">
				<tr>

					<c:set var="ans" value="${p.p_ans}" />
					<c:choose>
						<c:when test="${m.c_ans eq ans}">
							<td>★${m.c_id}★</td>
						</c:when>
						<c:otherwise>
							<td>${m.c_id}</td>
						</c:otherwise>
					</c:choose>

					<td style="text-align: center;">${m.c_txt}</td>
					<td style="text-align: center;">${m.c_ans}</td>
					<td style="text-align: center;">${m.c_date}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2" width="45%" style="border-top:1px solid rgb(162,187,145); "><input type="text" style="width: 95%"
					name="comment" placeholder="코멘트"></td>
				<td width="45%" style="border-top:1px solid rgb(162,187,145); "><input type="text" style="width: 95%" name="answer"
					placeholder="정답 적기"></td>
				<td colspan="1" width="10%" style="border-top:1px solid rgb(162,187,145); ">
					<button id="submit" type="submit"
						onclick="return regComment('${result}');">등록</button>
				
				<c:set var="c" value="${sessionScope.accountInfo.a_id}"/>
				<c:set var="u" value="${p.p_id}"/>
				<c:if test="${c eq 'admin' or c eq u}">
				
					<button type="button" onclick="deleteContents('${param.p_no}');">삭제</button>
				</c:if>
				</td>

			</tr>
		</table>
	</form>
	<table style="padding-top: 10px;" id="paging">
		<tr>
			<td><a href="CommentPageController?p=1&p_no=${param.p_no}">맨처음</a>
				<c:forEach var="p" begin="1" end="${pageCount}">
					<a href="CommentPageController?p=${p}&p_no=${param.p_no}">[${p}]</a>
				</c:forEach> <a href="CommentPageController?p=${pageCount}&p_no=${param.p_no}">마지막</a>
			</td>
		</tr>
	</table>
	</div>
	<footer>
	
	</footer>
</body>
</html>