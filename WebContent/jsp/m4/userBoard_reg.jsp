<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css">
</head>
<body>
	<div id="board">
	<h1>글쓰기</h1>
	<form action="UserRegController" method="post"
		enctype="multipart/form-data">


					<table border="1" id="boardMain">
						<tr>
							<td align="center" style="background-color: rgb(162,187,145);
	color: white;">제목</td>
							<td><input name="title" style="width: 100%; "></td>
						</tr>
						<tr>
							<td align="center" style="background-color: rgb(162,187,145);
	color: white;">내용</td>
							<td><textarea name="content" style="width: 100%; height: 200px;" cols="0" rows="0"></textarea></td>
						</tr>
						<tr>
							<td align="center" style="background-color: rgb(162,187,145);
	color: white;">사진첨부</td>
							<td><input type="file" name="file">
								<input type="hidden" name="id" value="${sessionScope.accountInfo.a_id}"> </td>
						</tr>
					</table>
			
		<table  style="width: 80%;	margin: 0 auto;
text-align: right;margin-bottom: 200px;">
			<tr >
				<td><button>등록</button>
				<input onclick="location.href='M4C'" type="button" value="취소" style="background-color: rgb(162,187,145);
	color: white;
	width: 60px;">
			</tr>
		</table>
	</form>
</div>
<footer>
</footer>
</body>
</html>