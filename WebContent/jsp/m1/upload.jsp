<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h1>글쓰기</h1>
	<form
		action="NoticeUploadController"
		method="post"
		enctype="multipart/form-data">
	
		<table id="boardMain" style="margin-bottom: 200px;" border="1">
			<tr>
				<td align="center" style="background-color: rgb(162,187,145);
	color: white;">제목</td>
				<td><input style="width: 100%" name="subject" id="subject" size="60"/></td>
			</tr>
			<tr>
				<td align="center" style="background-color: rgb(162,187,145);
	color: white;">본문</td>
				<td>
					<textarea style="width: 100%; height: 200px;" rows="5" cols="60" name="content" id="content"></textarea>	
				</td>
			</tr>
			<tr>
				<td align="center"  style="background-color: rgb(162,187,145);
	color: white;" >첨부파일</td>
				<td>
					<input type="file" name="file">
				
				</td>
			</tr>
			<tr>
				<td style="background-color: rgb(162,187,145);
	color: white;"></td>
				<td  style="text-align: right;"><button>등록</button> 
				<input type="hidden" name="id" value="${sessionScope.accountInfo.a_id}"> 
				</td>
			</tr>
		</table>
	</form>
	</div>
	<footer>
	
	</footer>
</body>
</html>