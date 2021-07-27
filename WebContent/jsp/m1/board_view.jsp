<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/Notice.js"></script>
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

<table  id="boardMain" >
	<tr>
		<th colspan="2" width="70%" align="center" style="border: 3px solid rgb(162,187,145);">제목</th>
		<th colspan="2" width="15%" align="center" style="border: 3px solid rgb(162,187,145);">작성일</th>
		<th align="center" width="15%" style="border: 3px solid rgb(162,187,145);">작성자:</th>
	</tr>
	<tr>
	<td colspan="2" width="50%" align="center">${boards.b_subject }</td>
	<td colspan="2" width="25%" align="center"><fmt:formatDate value="${boards.b_date}"
		type="both" dateStyle="short" timeStyle="short"/></td>
	<td  align="center" width="25%">${boards.b_id }</td>
	</tr>
	<tr align="left" style="font-size: 20px;">
		<td colspan="8" style="border: none;">${boards.b_content}</td>
		</tr>
	<c:if test="${boards.b_file != null }">
	<tr align="left">
		<td colspan="8" style="border:none;">
         <img id="file" src="img/${boards.b_file }"style="width: 500px;height: 500px;">
         </td>
         </tr>
         </c:if>
         </table>
         
         <table style="width: 80%;	margin: 0 auto;
text-align: right;margin-bottom: 200px;">
	<tr style="border-top: none;">
		<td colspan="8" style="text-align: right;">
			<c:if test="${accountInfo.a_id == 'admin'}">
 			<button onclick="location.href='NoticeEditController?num=${param.num }'">수정</button>
 			<button onclick="NoticeDel('${boards.b_num}');">삭제</button>
 			</c:if>
 			 <button onclick="location.href='M1C'">목록으로</button></td>
	</tr>
</table>
</div>
<footer>


</footer>
</body>
</html>