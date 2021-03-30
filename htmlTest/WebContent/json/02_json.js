/**
 * 
 */

var xhr = null;
var arr = new Array();

function toServer() {
	
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest;
	}else{
		//익스프로러 구버전에서 사용(5~6)
		xhr = new ActiveXObject("Microsoft.XMLHTTP")
	}
	alert(xhr.readyState);
	//서버로 보낼 요청의 형식을 설정 합니다.
	//전달방식, URL 주소, 동기여부
	xhr.open("GET","02_json.txt",true)
	
	//서버로 전달
	//GET방식
	xhr.send()
	//POST방식
	//xhr.send(queryString)
	
	//readyState 값이 변할때 마다 호출되는 속성
	xhr.onreadystatechange = process;
	
}

function process(){
		if(xhr.readyState==4 && xhr.status==200){
			arr.push(xhr.responseText);
			alert(arr[0]);
			
			//응답받은 02_json.txt의 데이터를 json 형식으로 변환
			var obj = JSON.parse(xhr.responseText);
			
			//화면에 위치한 div의 정보를 가져온다.
			var disp = document.getElementById("disp");
			
			//새롭게 만들어질 div를 생성한다.
			var divName = document.createElement("div");
			divName.innerHTML = obj.name;
			
			var divAge = document.createElement("div");
			divAge.innerHTML = obj.age;
			
			disp.appendChild(divName);
			disp.appendChild(divAge);
			debugger;
			for(var i=0;i<obj.cars.length;i++){
				var ul = document.createElement("ul");
				var li = document.createElement("li");
				li.innerHTML = obj.cars[i].name;
				ul.appendChild(li);
				for(var j=0;j<obj.cars[i].model.length;j++){
					var li=document.createElement("li");
					li.innerHTML = obj.cars[i].model[j];
					ul.appendChild(li);
				}
				disp.append(ul);
			}
		}
		
	}