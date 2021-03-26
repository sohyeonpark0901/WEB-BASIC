<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kakaoMap</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=436dc181173a72fa9ba73437577300a6"></script>
</head>
<body>
	<div><h3>카카오 지도</h3></div>
	<div id="map" style="width:500px; height:400px;"></div>
	<script type="text/javascript">
		var container = document.getElementById('map');
		//지도를 생성할 변수를 만들자!
		var options = {
				center: new kakao.maps.LatLng(33.450701,126.570667), //지도의 중심 좌표
				level: 3 //지도의 확대,축소 정도
		}
		
		var map = new kakao.maps.Map(container,options);
		
		
	</script>
</body>
</html>