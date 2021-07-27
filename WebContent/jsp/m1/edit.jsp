<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css" >
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
	<h1>수정 페이지</h1>
	<form action="NoticeEditController?num=${param.num }" method="post"
		enctype="multipart/form-data">
		<table id="boardMain" style="margin-bottom: 200px;"border="1">
			<tr>
				<td align="center" style="background-color: rgb(162,187,145);
	color: white;">제목</td>
				<td colspan="3"><input style="width: 80%" name="subject"  value="${boards.b_subject }">
				</td>
			</tr>
			<tr>
				<td align="center" style="background-color: rgb(162,187,145);
	color: white;">본문</td>
				<td colspan="3"><textarea style="height:200px;width: 80%;" rows="" cols="" name="content">${boards.b_content}</textarea>
				</td>
			</tr>

			<tr>
				<td align="center" style="background-color: rgb(162,187,145);
	color: white;">첨부파일</td>
				<td colspan="3"><img src="img/${boards.b_file}" width="100px;">
					<input type="hidden" name="file2" value="${boards.b_file}">
					<input type="file" name="file"></td>
			</tr>
			
			<tr>
				<td style="background-color: rgb(162,187,145);
	color: white;"></td>
				<td colspan="2" style="text-align: right;"><button>확인</button></td>
			</tr>
		</table>
	</form>
	</div>
	<footer>
	
	</footer>
</body>
</html>