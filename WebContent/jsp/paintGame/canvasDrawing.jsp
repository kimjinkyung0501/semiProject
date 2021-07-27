<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles2.css"/>
</head>
<body>
<script src="js/paintJs/jscolor.js"></script>
<canvas id="jsCanvas" class="canvas"></canvas>
<div class="controls" style="margin-bottom: 200px;">
	<div class="controls_range">
	<input type="range"
		name=""
 		id="jsRange"
 		min="0.1"
		max="10.0"
		value="5.0"
		step="0.1"
/>
</div>
<div class="controls_btns">
<button id="jsMode">배경색</button>
<form action="RegGame">
<button id="jsSave">그림 저장 및 글쓰러 가기</button>
</form>
<button id="jsErase">지우개</button>
</div>
		<div class="controls__colors" id="colors">
		<div class="controls__color jsColor"
		style="background-color: #2c2c2c"
		></div>
		<div
          class="controls__color jsColor"
          style="background-color: white;"
        ></div>
        <div
          class="controls__color jsColor"
          style="background-color: red;"
        ></div>
        <div
          class="controls__color jsColor"
          style="background-color: orange;"
        ></div>
        <div
          class="controls__color jsColor"
          style="background-color: yellow;"
        ></div>
        <div
          class="controls__color jsColor"
          style="background-color: green;"
        ></div>
        <div
          class="controls__color jsColor"
          style="background-color: blue;"
        ></div>
        <div
          class="controls__color jsColor"
          style="background-color: indigo;"
        ></div>
        <div
          class="controls__color jsColor"
          style="background-color: violet;"
        ></div>
        <input class="jscolor" id="palette" value="" />
</div>
</div>
<script src="js/paintJs/app.js"></script>
<footer>

</footer>
</body>
</html>