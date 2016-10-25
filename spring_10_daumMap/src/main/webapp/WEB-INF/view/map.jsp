<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- 다음 api키 : 08f3b6e376777934e056ecca8fbcdf89 -->
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=08f3b6e376777934e056ecca8fbcdf89"></script>
<style type="text/css">
.map_wrap{
height:800px;
}

</style>
</head>
<body>
	<div class="map_wrap">
		<div id="map" style="width: 500px; height: 100%; position: relative; overflow: hidden;">
		</div>
	</div>
	
	<script src="js/map.js"></script>
</body>
</html>