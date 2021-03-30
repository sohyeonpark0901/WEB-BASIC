/**
 * 
 */

var xhr = null;
var arr = new Array();


function toServer(){
	debugger;
	//request 생성
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest;
		
	}else{
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	
	//데이터 읽어오기
	//open 함수를 사용하여 request 객체를 open을 통해 초기화 한 후 데이터를 로드
	xhr.open("GET","01_json.txt",true);
	//해당 데이터를 보내기
	xhr.send();
	//받은 데이터를 가공하여 사용자에게 전달
	//결과에 따라 가공된 데이터를 받아 들이는 과정
	xhr.onreadystatechange = resultProcess;
}
	
function resultProcess(){
	debugger;
	//readyState는  속성이 존재함
	/**
		0 - 요청을 만들었지만 open을 통해 초기화 하지 않은 상태
		1 - 객체를 만들고 초기화 했지만 send를 통해 요청하기 전
		2 - send를 사용해 요청하고 난 직후
		3 - 데이터가 일부 도착
		4 - 모든 데이터 도착
	 */
	/*
		readyState가 4라고 하더라도 데이터가 제대로 로드된것인지
		알수가 없슴.
		요청URL에서 에러가 난경우 http status code를 참조해서 판단해야한다.
		100대 처리중
		200대 성공
		300대 redirect (페이지 이동)
		400대 클라이언트 오류(사용자측) -> Bad Request
		500대 서버오류 ->Internal Server Error
	*/
	if(xhr.readyState==4 && xhr.status==200){
		// 상태가 정상이기에 화면 생성
		var obj = JSON.parse(xhr.responseText);
		
		var disp = document.getElementById("disp");
		var ul = document.createElement("ul");
		var liNode1 = document.createElement("li");
		liNode1.innerHTML = obj.name;
		var liNode2 = document.createElement("li");
		liNode2.innerHTML = obj.age;
		var liNode3 = document.createElement("li");
		liNode3.innerHTML = obj.height;
		
		ul.appendChild(liNode1);
		ul.appendChild(liNode2);
		ul.appendChild(liNode3);
		disp.appendChild(ul);
		
		
	}
	
}