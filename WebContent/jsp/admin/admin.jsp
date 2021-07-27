<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type = "text/javascript" src="js/admin.js"></script>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
<div style="position: absolute;top: 150px;left:10%;width: 80%" >
<form action="DropedUser">
<button style="width: 100px;height:50px;background-color: rgb(162,187,145);color: white;">탈퇴 명단&사유 </button>
</form>

		<form action="SearchUser">
					<table style="width:100%; ">
						<tr>
						<td align="center">
						<select name="searchWay">
						<option  value="byId" name="byId" >ID</option>
						<option value="byName" name="byName">Name</option>
						</select>
					
							<input name="search" >
								<button style="width:50px; background-color:rgb(162,187,145);color: white;">검색</button>
							</td>
						</tr>
					</table>

				</form> 






	<c:forEach var="a" items="${accounts}">

		<table >

			<tr>
				<td>id</td>
				<td>${a.a_id}</td>
			</tr>

			<tr>
				<td>pw</td>
				<td>${a.a_pw }</td>
			</tr>

			<tr>
				<td>이름</td>
				<td>${a.a_name }</td>
			</tr>

			<tr>
				<td>생년월일</td>
				<td>${a.a_birth }</td>
			</tr>
			<tr>
				<td> <input type="button"  value="회원정보 수정" onclick="location.href='AdminUpdate?id=${a.a_id}'"style="background-color:rgb(162,187,145);color: white;"></td>
			</tr>
			<tr>
				<td><input type="button"  value="계정 삭제" onclick="adDropOut('${a.a_id}','${a.a_pw}');" style="background-color:rgb(162,187,145);color: white;"> </td>
			</tr>

		</table>
	<hr style="background-color: rgb(162,187,145)">
		
	</c:forEach>


	<table style="margin-left: auto;margin-right: auto;margin-top: 50px;">

		<tr>
			<td  align="center">
			<a href="AdminPageController?page=1">맨처음</a>
		<c:forEach var="p" begin="1" end ="${pageCount}">
		 <a href ="AdminPageController?page=${p}">${p}</a>         
		</c:forEach>
			<a href="AdminPageController?page=${pageCount }">맨마지막</a>	
			</td>
		</tr>


	</table>

</div>
<footer style="position: absolute; top:800px;">

</footer>
</body>
</html>