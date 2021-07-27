<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
<div style="width: 80%; margin-left: auto;margin-right: auto;" >
<h1 style=" margin-top: 100px;padding-left: 5%;">오늘 추천 메뉴</h1>

<h1 style="text-align: center;margin-top: 20px;">${food.name }</h1>
<img style="width: 300px; height: 250px; margin-left: 40%; border-radius: 20%" src="img/${food.img }">
<div style="margin-left:45.5%;">
<button id="button" style="font-size:15px;  width: 100px;height: 50px; margin-left:3%; margin-top: 30px;"
onclick="location.href='RecoC'">다시하기</button>
</div>
</div>
</body>
</html>