function createXHR(){
	
	if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}else {
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
	
}

var xhr = null;
var arr = new Array();

function sendRequest(method,url,params,callback){
	//callback함수
	//파라미터로 함수를 전달해 해당 함수 내부에서 실행되는 함수
	
	var httpMethod = method.toUpperCase();
	var httpUrl = url;
	var httpParams = (params==null||params=="")?null:params;
	
	if(httpMethod=="GET" && httpParams!=null){
		httpUrl += "?"+httpParams;
		
	}
	arr.push(httpMethod + ","+httpUrl + "," +httpParams);
	
	xhr = createXHR();
	xhr.open(httpMethod,httpUrl,true);
	
	//post일수도 있기에 post일때는
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	
	//kakao map api 사용하기 위한 헤더 설정
	debugger;
	xhr.setRequestHeader("Authorization", "KakaoAK 2a5c46b89f4b7a9ae64aab43705d0d87");
	if(httpMethod=="POST"){
		xhr.send(httpParams);	
	} else {	
		xhr.send(null);
	}
	
	xhr.onreadystatechange = callback;
	
	
}
