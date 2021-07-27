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


<div style="position: absolute; left: 10%; top: 100px; text-align: center;">
	<img  src="img/seoul.jpeg" style="width: 350px; height: 250px;opacity: 0.85" onclick="goController();">
	<div id="div1" style="left: 75px; width: 200px; bottom: 110px; font-size: 35px; font-weight: bold; position: absolute; background-color: rgba(21, 3, 34, 0.1);
	color: white">
	서울
	</div>
</div>

<div style="position: absolute; left: 33%; top: 100px; margin-left: 100px;text-align: center;">
	<img  src="img/busan.jpeg" style="width: 350px; height: 250px;opacity: 0.85" onclick="goController2();">
	<div id="div2" style="left: 75px; width: 200px;bottom: 110px; font-size: 35px; font-weight: bold; position: absolute; background-color: rgba(21, 3, 34, 0.1);
	color: white">
	부산
	</div>
</div>

<div style="position: absolute; left: 63%; top: 100px; margin-left: 100px;text-align: center;">
	<img  src="img/daegu.jpeg" style="width: 350px; height: 250px;opacity: 0.85" onclick="goController3();">
	<div id="div3" style="left: 75px; width: 200px;bottom: 110px; font-size: 35px; font-weight: bold; position: absolute; background-color: rgba(21, 3, 34, 0.1);
	color: white">
	대구
	</div>
</div>

<div style="position: absolute; left: 10%; top: 500px;text-align: center;">
	<img  src="img/sokcho.jpeg" style="width: 350px; height: 250px;opacity: 0.85" onclick="goController4();">
	<div id="div4" style="left: 75px; width: 200px;bottom: 110px; font-size: 35px; font-weight: bold; position: absolute; background-color: rgba(21, 3, 34, 0.1);
	color: white">
	속초
	</div>
</div>

<div style="position: absolute; left: 33%; top: 500px; margin-left: 100px;text-align: center;">
	<img  src="img/wonju.jpeg" style="width: 350px; height: 250px; opacity: 0.85" onclick="goController5();">
	<div id="div5" style="left: 75px; width: 200px;bottom: 110px; font-size: 35px; font-weight: bold; position: absolute; background-color: rgba(21, 3, 34, 0.1);
	color: white;">
	원주
	</div>
</div>

<div style="position: absolute; left: 63%; top: 500px; margin-left: 100px;text-align: center;">
	<img  src="img/gyeongju.jpeg" style="width: 350px; height: 250px;opacity: 0.85" onclick="goController6();">
	<div id="div6" style="left: 75px; width: 200px;bottom: 110px; font-size: 35px; font-weight: bold; position: absolute; background-color: rgba(21, 3, 34, 0.1);
	color: white">
	경주
	</div>
</div>
<c:if test="${sessionScope.accountInfo.a_id eq 'admin' }">
<div class="footerDiv" style="position:absolute; top: 800px; right:80px;; width: 100px;">
<button onclick="location.href='RegShop'" style="width: 100%;height: 50px;background-color: rgb(162,187,145);color: white;">등록</button>
</div>
</c:if>
<footer style="position:absolute; top: 900px;  ">

</footer>
</body>
</html>