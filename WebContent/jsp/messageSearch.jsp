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




<form action="MessageSearch?id=${sessionScope.accountInfo.a_id}" method="post">
					<table >
						<tr>
						<td><h3> ${sr}</h3></td>
						</tr>
						<tr>
						<td><select name="searchWay">
						<option  value="whoSent">받은 쪽지</option>
						<option value="whoGot" >보낸 쪽지</option>
						</select></td>
							<td align="center"><input name="searchId" placeholder="기간검색시 사용불가">
						
								<button style="background-color: rgb(162,187,145);color: white;">검색</button>
							</td>
						</tr>
					</table>

				</form> 

<input type="date" value="기간으로 검색" id="aa">
<input type="date" value="기간으로 검색" id="bb">
<button onclick="ttt();">기간으로 검색</button>

<c:choose>

<c:when test="${way eq 'whoSent' }">
<c:forEach var="m" items="${messages}">
<table>

<tr> <td>받은 쪽지 </td> </tr>
<tr> <td>id : ${m.m_toId }</td> </tr>
<tr> <td>내용 : ${m.m_text }</td> </tr>
<tr> <td>날자 :${m.m_date } </td> </tr>
<tr><td>
<input type="button"  value="삭제" onclick="delectMessage('${m.m_messageNo}',3);">
</td> </tr>
</table>
<hr>
</c:forEach>
</c:when>


<c:when test="${way eq 'whoGot' }">

<c:forEach var="m" items="${messages}">
<table>

<tr> <td>보낸 쪽지 </td> </tr>
<tr> <td>id : ${m.m_toId }</td> </tr>
<tr> <td>내용 : ${m.m_text }</td> </tr>
<tr> <td>날자 :${m.m_date } </td> </tr>
<tr><td>
<input type="button"  value="삭제" onclick="delectMessage('${m.m_messageNo}',3);">
</td> </tr>
</table>
<hr>
</c:forEach>
</c:when>

<c:when test="${way eq 'date'}">

<c:forEach var="m" items="${messages}">
<table>

<tr> <td>보낸 쪽지 </td> </tr>
<tr> <td>id : ${m.m_toId }</td> </tr>
<tr> <td>내용 : ${m.m_text }</td> </tr>
<tr> <td>날자 :${m.m_date } </td> </tr>
<tr><td>
<input type="button"  value="삭제" onclick="delectMessage('${m.m_messageNo}',3);">
</td> </tr>

</table>
<hr>
</c:forEach>
</c:when>




</c:choose>



<script type = "text/javascript" src="js/message.js"></script>

</body>
</html>