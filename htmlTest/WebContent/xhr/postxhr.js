/**
 * 
 */

var xhr = null;
var arr = new Array();

function toServer(){
	/*debugger;*/
	//Form 테그 하위 테그까지 다 불러옴
	var msg = document.getElementById("createForm").msg.value;
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest;
	}else {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//method=get 방식
	//xhr.open("GET","데이터!",true);
	//xhr.send();
	
	//method=post 방식
	xhr.open("POST","command.jsp",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("msg="+msg);
	xhr.onreadystatechange=process;
	
	
}

function process(){
	if(xhr.readyState==4 && xhr.status==200){
		var disp = document.getElementById("disp");
		disp.innerText = xhr.responseText;
	}
}