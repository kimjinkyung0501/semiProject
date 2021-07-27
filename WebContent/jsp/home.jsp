<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="css/home.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
  <script type="text/javascript">
  $(function(){
    $('.bxslider').bxSlider({
        mode: 'fade',
    captions: true,
   
    });
  });
  
  </script>
</head>
<body>


<main>
<div class= "mainImg">
<img alt="" src="img/back1.jpg" style="width: 100%;">
<form action="SearchShop">
<table id="search" style="position: absolute; top: 300px; left:63%">
<tr>
<td><input name="shop_place" type="text" style="width: 500px;height: 80px;font-size: 25px;"></td>
<td><button style="height: 80px; width: 80px;background-color: rgb(162,187,145);border-color:#5a7e50;color: white;">검색</button></td>
</tr>
</table>
</form>
</div>




<div class="contentbox">
<div class="slidem">
<div class="bxslider" style="z-index: 2;">
<img src="https://post-phinf.pstatic.net/MjAxNzA3MTdfMjM1/MDAxNTAwMjcyNDgzNjY5.jSUKLUfQPm2xtwrYoC5ifo6nqZKa5NLnHCANxZ3880Qg.b7ZA5ZyJKChSJd7Tf7s5k2Ik1tXkRpyafbjxY5FmUzIg.JPEG/0713%EB%A7%9B%EB%82%9C%EC%A0%9C%EC%A3%BC%EB%8F%841440.jpg?type=w1200">
<img src="https://t1.daumcdn.net/cfile/tistory/277FEC3F595C2E9113">
<img src="https://www.paju.go.kr/webcontent/cmsUpload/2021/4/2/656a1f5b-4706-40bd-821e-80acf97c958f.jpg">
</div>
</div>

<div class= "content2">
<div class= "content2_2">
<div class= "contentInfo">
<h3>공지사항</h3>
<hr>
<table id="latest" style=" width: 100%;
	 margin-left: auto;
	 margin-right: auto;
	 margin-top: 30px;
	 ">
<c:forEach begin="0" end="9" var="latest" items="${boards2}"> 
<tr>
<td align="left">
<h4><a href="NoticeViewController?num=${latest.b_num }">${latest.b_date} &nbsp; &nbsp; ${latest.b_subject }</a></h4>
</td>
</tr>
</c:forEach>
</table>
</div>
</div>
<div class="content2_1">
<div class= "contentInfo">
<h3>추천 게시물</h3>
<hr>
<table id="best" style=" width: 100%;
	 margin-left: auto;
	 margin-right: auto;
	 margin-top: 30px;
	 ">
<c:forEach begin="0" end="9" var="best" items="${reviews2}"> 
<tr>
<td align="left">
<h4><a href="ReviewDetailController?no=${best.ub_no }">${best.ub_date}&nbsp; &nbsp;  ${best.ub_title }[${best.ub_count}]</a></h4>
</td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>

<div class= "content3">
<div class= "contentInfo">
<h2>매거진</h2>
</div>
<div id="magazine">
<a href="https://guide.michelin.com/kr/ko"><img src="https://t1.daumcdn.net/cfile/tistory/99DD393F5DCEA6D80D"></a>
</div>
<div id="magazine">
<a href="http://olivem.co.kr/olivemagazine"><img alt="" src="http://olivem.co.kr/wp-content/uploads/2019/05/MEDIAKIT.png"></a>
</div>
<div id="magazine">
<a href="https://www.instagram.com/barndining_official/?hl=ko"><img alt="" src="https://t1.daumcdn.net/cfile/blog/99D4C73E5E09923810"></a>
</div>

</div>


</div>

</main>

<footer>


</footer>

</body>
</html>