function createFrom(obj){
	if(obj.id.value ==""){
		alert("아이디를 반드시 입력하세요.");
		obj.id.focus();
		return false;
	}
	
	if(obj.password.value ==""){
		alert("비밀번호를 반드시 입력하세요.");
		obj.password.focus();
		return false;
	}
	
	if(obj.password.value.length < 7){
		alert("비밀번호는 7글자 이상으로 만들어주세요.");
		obj.password.focus();
		return false;
	}
	
	if(obj.passwordCheck.value ==""){
		alert("비밀번호 확인란에 입력해주세요.");
		obj.passwordCheck.focus();
		return false;
	}
	
	if(obj.password.value != obj.passwordCheck.value){
		alert("입력하신 비밀번호가 같지 않습니다.");
		obj.passwordCheck.focus();
		return false;
	}
	
	if(obj.name.value ==""){
		alert("이름을 반드시 입력하세요.");
		obj.name.focus();
		return false;
	}
	
	if(obj.jumin1.value == "" || obj.jumin2.value == ""){
		alert("주민번호을 반드시 입력하세요.");
		obj.jumin1.focus();
		obj.jumin2.focus();
		return false;
	}
	
	if(obj.jumin1.value.length !=6){
		alert("주민번호 앞자리 6자리입니다.");
		obj.jumin1.focus();
		return false;
	}
		
	if(obj.jumin2.value.length !=7){
		alert("주민번호 뒤자리 7자리입니다.");
		obj.jumin2.focus();
		return false;
	}
	
	if(obj.email.value ==""){
		alert("이메일을 입력하세요.");
		obj.email.focus();
		return false;
	}

	if(obj.zipcode.value ==""){
		alert("우편번호을 입력하세요.");
		obj.zipcode.focus();
		return false;
	}

	if(obj.job.value ==""){
		alert("직업을 선택하세요.");
		obj.job.focus();
		return false;
	}
	
	var check = false;
	for(var i=0;i<obj.mailing.length;i++){
		if(obj.mailing[i].checked==true) check=true;
	}

	if(obj.mailing.value ==""){
		alert("메일수신 여부를 체크해주세요.");
		obj.mailing.focus();
		return false;
	}

	check = false;
	var str="";
	for(var i=0; i<obj.interest.length; i++){
		if(obj.interest[i].checked==true){
			str+=obj.interest[i].value + ",";
		}
		
	}	
	//alert(str);
	obj.resultInterest.value=str;
	
/*	if(check == false){
		alert("관심사를 하나 이상 체크하세요.");
		return false;
	}*/
}
function idCheck(obj, root){
	alert(obj.id.value);
	
	if(obj.id.value ==""){
		alert("아이디를 반드시 입력하세요.");
		obj.id.focus();
		return false;
	}else{
		var url = root + "/member/idCheck.do?id=" + obj.id.value;
		//alert(url);
		window.open(url, "", "width=400, height=200");
	}
}