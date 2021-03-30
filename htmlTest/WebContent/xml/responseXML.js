/**
 * 
 */

function startRequest() {
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest;
	}else{
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	alert(xhr.readyState);
	xhr.open("GET","response.xml",true);
	xhr.send();
	xhr.onreadystatechange = process;
	
	
	
}

function process(){
	if(xhr.readyState==4 && xhr.status==200){
		if(xhr.readyState==4 && xhr.status==200){
			var xmlDoc = xhr.responseXML;
			
			var studentList = xmlDoc.getElementsByTagName("student")
			
			var disp = document.getElementById("disp");
			
			for(var i=0;i<studentList.length;i++){
				var student = studentList[i];
				var subElement = student.children;
				debugger;
				var div = document.createElement("div");
				for(var j=0; j<subElement.length;j++){
					
					var span = document.createElement("span");
					//childNode[0]인 이유
					span.innerHTML = subElement[j].childNodes[0].nodeValue +"&nbsp";
					
					div.appendChild(span);
					
				}  
				disp.appendChild(div);
			}
		}
		
	}
}