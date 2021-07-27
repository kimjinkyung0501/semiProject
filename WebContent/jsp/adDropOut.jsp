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




<form action="../AdDropOut" method="get">

<table>

<tr><td> ${param.id}를 삭제합니까?</td> </tr>
<tr><td> <input name="id" value="${param.id}" type="hidden" > </td> </tr>
<tr><td> <input name="pw" value="${param.pw}" type="hidden"> </td> </tr>
<tr><td> <button >삭제</button></td> </tr>
</table>



</form>
</body>
</html>