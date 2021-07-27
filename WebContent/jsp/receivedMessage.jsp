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

			<c:forEach var="m" items="${messages}">
				<table style="padding-top: 0">
					<tr>
						<td>받은 쪽지</td>
					</tr>
					<tr>
						<td>보낸사람 : ${m.m_fromId }</td>
					</tr>
					<tr>
						<td>내용 : ${m.m_text }</td>
					</tr>
					<tr>
						<td>날자 :${m.m_date }</td>
					</tr>
					<tr>
						<td><a href="Reply?from=${m.m_fromId}">답장하기</a></td>
					</tr><tr><td>
<input type="button" value="삭제" onclick="delectMessage(${m.m_messageNo},1)">
</td> </tr>
				</table>
				<hr>
			</c:forEach>

	



	<table>

		<tr>
			<td align="center"><a href="ReceivedMessagePageC?p=1&id=${sessionScope.accountInfo.a_id}">맨처음</a> 
			<c:forEach var="p" begin="1" end="${pageCount}">
					<a href="ReceivedMessagePageC?p=${p}&id=${sessionScope.accountInfo.a_id}">${p}</a>
				</c:forEach>
				 <a href="ReceivedMessagePageC?p=${pageCount }&id=${sessionScope.accountInfo.a_id}">맨마지막</a></td>
		</tr>


	</table>






</body>
</html>