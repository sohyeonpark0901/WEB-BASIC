<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>회원가입page</title>
	<link rel="stylesheet" href="${root}/css/member/joinStyle.css?ver=1">
	<script type="text/javascript" src="${root}/javascript/member/register.js"></script>
</head>
<body>
	<jsp:include page="../../../index.jsp"/>
	<br /><br />

	<form id="joinform" name="joinform" action="${root}/member/registerOk.do" method="post" 
		onsubmit="return createFrom(this)">

		<h4 style="text-align: center;">회원가입(*필수입력사항입니다.)</h4>
		<div class="menu" style="border-bottom-width: 0px;">


		<div id="id">아이디</div>
			<span>* 
				<input type="text" class="checkInfo" name="id" size="12" /> 
				<button type="button" onclick="idCheck(joinform, '${root}')">아이디 중복</button>
			</span>
		</div>

		<div class="menu " style="border-bottom-width: 0px;">
			<div id="id">비밀번호</div>
			<span>* <input type="password" class="checkInfo" name="password" size="12" />
			</span>
		</div>

		<div class="menu " style="border-bottom-width: 0px;">
			<div id="id">비밀번호확인</div>
			<span>* <input type="password" class="checkInfo" name="passwordCheck" size="12" />
			</span>
		</div>

		<div class="menu " style="border-bottom-width: 0px;">
			<div id="id">이름</div>
			<span>* <input type="text" class="checkInfo" name="name" size="12" />
			</span>
		</div>

		<div class="menu " style="border-bottom-width: 0px;">
			<div id="id">주민번호</div>
			<span>* 
				<input type="text" class="checkInfo" name="jumin1" size="6" /> 
				<span>-</span> 
				<input type="text" class="checkInfo" name="jumin2" size="7" />
			</span>
		</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id" style="margin-left: 10px,">이메일</div>
			<span> 
				<input type="email" name="email" size="25" />
			</span>
		</div>


		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">우편번호</div>
			<span> 
				<input type="text" name="zipcode" size="30" /> 
				<button type="button" >우편번호검색</button>
			</span>
		</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">주소</div>
			<span> <input type="text" name="address" size="50" />
			</span>
		</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">직업</div>
			<span> 
			<select name="job">
					<option>직업을 선택하세요.</option>
					<option value=' '>무직</option>
					<option value='programmer'>프로그래머</option>
					<option value='designer'>디자이너</option>
			</select>
			</span>
		</div>


		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">메일수신</div>
			<span> <input type="radio" id="yes" name="mailing" value="yes" />
				<label for="yes">yes</label> <input type="radio" id="no"
				name="mailing" value="no" /> <label for="no">no</label>
			</span>
		</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">관심분야</div>
			<span> 
				<input type="checkbox" size="12" name="interest" value="경제"/> 
				<label for="경제" >경제</label> 
				<input type="checkbox" size="12" name="interest" value="IT"/> 
				<label for="IT" >IT</label>
				<input type="checkbox" size="12" name="interest" value="음악"/>
				<label for="음악" >음악</label> 
				<input type="checkbox" size="12" name="interest" value="미술"/> 
				<label for="미술" >미술</label>
				<input type="hidden" name="resultInterest"/>
			</span>	
		</div>

		<div class="menu" style="text-align: center;">
			<span> 
				<input type="submit" value="가입" />
			 	<input type="reset" value="취소" />
			</span>
		</div>
	</form>
</body>
</html>