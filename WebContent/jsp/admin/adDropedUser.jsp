<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="position: absolute;top: 150px;left:10%;width: 80%" >
<c:forEach var="r" items="${reasones}">

		<table>

			<tr>
				<td>id</td>
				<td>${r.r_id}</td>
			</tr>

			<tr>
				<td>사유</td>
				<td>${r.r_text }</td>
			</tr>

			<tr>
				<td>생년월일</td>
				<td>${r.r_date }</td>
			</tr>

		</table>

		<hr>
	</c:forEach>

<table style="margin-left: auto;margin-right: auto; margin-bottom: 200px;margin-top: 70px;">

		<tr>
			<td  align="center">
			<a href="DropedUserPageController?page=1">맨처음</a>
		<c:forEach var="p" begin="1" end ="${pageCount}">
		 <a href ="DropedUserPageController?page=${p}">${p}</a>         
		</c:forEach>
			<a href="DropedUserPageController?page=${pageCount }">맨마지막</a>	
			</td>
		</tr>


	</table>
</div>
<footer style="position: absolute; top: 800px;">

</footer>
</body>
</html>