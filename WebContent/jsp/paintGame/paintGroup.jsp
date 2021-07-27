<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function regPaint(id) {
	if (id == "") {
		alert("로그인을 먼저 해주세요");
		return false;
	} else {
		let ok = confirm("그림을 작성하시겠습니까?");
		if (ok == true) {
			location.href = "RegPaint?a_id=" + id;
			return true;
		} else {
			return false;
		}
	}

}
</script>
<link rel="stylesheet" href="css/catch.css">
</head>
<body>
<div id="catch">
<h1>캐치마인드</h1>
	<table id="catchMain">
		<tr>
			<th width="700">제목</th>
			<th width="150">등록ID</th>
			<th width="150">등록시간</th>
		</tr>
		<c:forEach var="p" items="${prints}">
			<tr>
				<td onclick="location.href='PrintGroupDetail?p_no=${p.p_no}'">${p.p_title}</td>
				<td>${p.p_id}</td>
				<td><fmt:formatDate value="${p.p_date}" type="both"
						dateStyle="short" timeStyle="short" /></td>
			</tr>
		</c:forEach>
	</table>
		<table style=" margin-right: auto;margin-left: auto;">
			<tr>
				<td> <button onclick="return regPaint('${user_session.a_id}');">그림 등록하러 가기</button> </td>
			</tr>
		</table>
	<table style="padding-top: 10px;" id="paging">
		<tr>
			<td><a href="PrintPageController?p=1">맨처음</a> <c:forEach var="p"
					begin="1" end="${pageCount}">
					<a href="PrintPageController?p=${p}">[${p}]</a>
				</c:forEach> <a href="PrintPageController?p=${pageCount}">마지막</a></td>
		</tr>
	</table>
</div>
<footer>

</footer>

</body>
</html>