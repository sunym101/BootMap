<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
/>
<title>${pageTitle!"线路查询"}</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body, button, input, select, textarea {
	font: 12px/16px Verdana, Helvetica, Arial, sans-serif;
}

#info {
	margin-top: 10px;
}

#container {
	min-width: 600px;
	min-height: 767px;
}
</style>
<script charset="utf-8" src="https://map.qq.com/api/js?v=2.exp&key=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77"></script>
<script>
	<#assign json="${stationData}"?eval />
	var arrPos = new Array();
	var arrLable = new Array();
	
	function getStationData(){
		var i = 0;
		<#list json as item>		
			var lat = ${item.lat?string("#.00000000")};
			var lng = ${item.lng?string("#.00000000")};				
			arrPos[i] = new qq.maps.LatLng(lat, lng);			
			arrLable[i] = "${item.stationNo}:${item.stationName}";
			i++;			
		</#list>	
	}

	function init(){
		getStationData();
		
		var mid = Math.floor(arrPos.length / 2);
		var map = new qq.maps.Map(document.getElementById('container'),{
			center: arrPos[mid],
			zoom: 14
		});
		    
		for (var i = 0; i < arrPos.length; i++) {		
			(function(n) {
				var marker = new qq.maps.Marker({
					position : arrPos[n],
					map : map
				});
	
				var label = new qq.maps.Label({
					position : arrPos[n],
					map : map,
					content : arrLable[n]
				});
			})(i);
		}
	}
</script>
</head>
<body onload="init()">
	<div id="msg">
		<table border="1" width="60%">
			<tr>
				<td width="4%" align="center">线路编号</td>
				<td width="10%" align="center">线路名称</td>
				<td width="4%" align="center">车站序号</td>
				<td width="20%" align="center">车站名称</td>
				<td width="10%" align="center">纬度</td>
				<td width="10%" align="center">经度</td>
			</tr>
			<#list json as item>
			<tr>
				<td align="center">${item.routeCode}</td>
				<td align="center">${routeName}</td>
				<td align="center">${item.stationNo}</td>
				<td align="left">${item.stationName}</td>
				<td align="center">${item.lat?string("#.00000000")}</td>
				<td align="center">${item.lng?string("#.00000000")}</td>
			</tr>
			</#list>
		</table>
	</div>

	<div id="container"></div>
</body>
</html>