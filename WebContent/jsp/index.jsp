<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function logOut(){
	
	let ok = confirm('정말 로그아웃 합니까?');
	
	if(ok){
	location.href="LogOut";
	}
	}
function myPageCheck()	{
	
	
		alert('로그인 후 이용가능합니다!');
		
	
	
}

</script>
<script type="text/javascript" src="js/check.js"></script>
<script type = "text/javascript" src="js/valid.js"></script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/home.css">

</head>
<body>

<header>
<nav>

<a href="HC"><img alt="" src="img/2TEAM.png" style="width: 80px; height: 70px;float: left;
margin-left: 10px;" > </a>

<ul>
<li><a href="M1C">공지사항</a></li>
<li><a href="M2C">지역 맛집</a></li>
<li><a href="M3C">추천 메뉴</a> </li>
<li> <a href="M4C">자유게시판</a></li>
<li><a href="PaintGame" onclick="return logIn(${sessionScope.accountInfo.a_id});">캐치마인드</a></li>
<c:choose>
<c:when test="${sessionScope.accountInfo == null}">
<li> <a onclick="myPageCheck()">마이페이지</a></li>
<li>
<a href="LogJoin">로그인</a>
</li>
</c:when>
<c:when test="${sessionScope.accountInfo != null && sessionScope.accountInfo.a_id == 'admin'}">
<li> <a href="AdminHC">관리자페이지</a></li>
<li> <a href="MyPage">마이페이지</a></li>
<li><a onclick="window.open('MessageHC?id=${sessionScope.accountInfo.a_id}', 'Message', 'width =800px height=350px', true);">Message</a></li>
<li style="color: #81c147;">${sessionScope.accountInfo.a_id}님 
<a onclick="logOut()">로그아웃</a>
</c:when>
<c:when test="${sessionScope.accountInfo != null}">
<li> <a href="MyPage">마이페이지</a></li>
<li><a onclick="window.open('MessageHC?id=${sessionScope.accountInfo.a_id}', 'Message', 'width =800px height=350px', true);">Message</a></li>
<li style="color: #81c147;">${sessionScope.accountInfo.a_id}님 
<a onclick="logOut()">로그아웃</a>
</li>
</c:when>
</c:choose>
</ul>
</nav>

</header>


<div style="width: 100%;position: absolute; top: 0;">
		 <jsp:include page="${contentPage }"></jsp:include> 
		
		</div>





</body>
</html>