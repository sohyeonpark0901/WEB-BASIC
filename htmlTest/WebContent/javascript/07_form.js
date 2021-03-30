function checkForm(obj){
	if(obj.irum.value==""){
		alert("이름을 입력하세요")
		obj.irum.focus();
		return false;
	}
	if(obj.irum.value.length != 3){
		alert("이름을 정확히 입력하세요.");
		obj.irum.focus();
		return false;
	}
	if(obj.siteURL.value==""){
		alert("이동할 사이트를 선택하세요")
		obj.siteURL.focus();
		return false;
	}
	else{
		document.getElementById("url").setAttribute("action",obj.siteURL.value);
	}
	var flag=false;
	for(var i=0;i<obj.fruit.length;i++){
		if(obj.fruit[i].checked==true){
			flag=true;
		}
	}
	if(flag==false){
		alert("좋아하는 과일을 하나 선택하세요")
		obj.fruit[0].focus();
		return false;
	}
	
	
}

