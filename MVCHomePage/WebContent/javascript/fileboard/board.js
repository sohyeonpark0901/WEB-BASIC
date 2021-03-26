function boardCheck(obj){
	alert("글작성 클릭");
}


function updFunc(root,boardNumber,pageNumber){
var url = root+"/fileboard/update.do?boardNumber="+boardNumber+"&pageNumber="+pageNumber;
alert("게시글 수정하시겠습니까?");
location.href=url;
}


function delFunc(root,boardNumber,pageNumber){
var url = root+"/fileboard/deleteOk.do?boardNumber="+boardNumber+"&pageNumber="+pageNumber;
alert("게시글 삭제하시겠습니까?");
location.href=url;
}


function replyFunc(root,boardNumber,pageNumber,groupNumber,sequenceNumber,sequenceLevel){
var url = root+"/fileboard/write.do?boardNumber="+boardNumber+"&pageNumber="+pageNumber+"&groupNumber="+groupNumber+"&sequenceNumber="+sequenceNumber+"&sequenceLevel="+sequenceLevel;
alert("게시글 답글다시겠습니까?");
location.href=url;
}