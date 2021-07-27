<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/userBoard.js"></script>
<link rel="stylesheet" href="css/board.css">
</head>
<body>
<div id="board">
<h1>수정하기</h1>
<form action="ReviewUpdateController" method="post" enctype="multipart/form-data">
	<table id="boardMain" border="1" style="margin-bottom: 200px;">
		<tr align="center">
			
			<td width="5%" style="background-color: rgb(162,187,145);
	color: white;">제목</td>
			<td width="40%" style="background-color: rgb(162,187,145);
	color: white;"><input style="width: 100%;" name="title" value="${dt.ub_title }"></td>
			
			<td width="5%;" style="background-color: rgb(162,187,145);
	color: white;">작성자</td>
			<td width="10%;"style="background-color: rgb(162,187,145);
	color: white;">${dt.ub_id }</td>
			
			<td width="5%;" style="background-color: rgb(162,187,145);
	color: white;">작성일</td>
			<td width="10%;"style="background-color: rgb(162,187,145);
	color: white;">${dt.ub_date }</td>
			
			<td width="5%;" style="background-color: rgb(162,187,145);
	color: white;">조회수</td>
			<td width="10%;" style="background-color: rgb(162,187,145);
	color: white;">${dt.ub_count }</td>
		</tr>
		<tr>
			<td colspan="10"><textarea rows="" cols=" " style="width: 100%;height: 200px;" name="content" >${dt.ub_content }</textarea></td>
		</tr>
		<tr>
			<td colspan="10"><img style="width: 200px; height: 150px;" src="img/${dt.ub_file }">
			<input type="hidden" value="${dt.ub_file}" name="file22">
			<input type="file" name="file">
			</td>
		</tr>
		<tr>
			<td colspan="10" style="text-align: right;">
				<input name="no" value="${param.no }" type="hidden">
		
				<button>수정 완료</button>
			</td>
		</tr>
	</table>
</form>
</div>
<footer>

</footer>
</body>
</html>