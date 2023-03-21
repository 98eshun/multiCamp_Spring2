<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 비밀번호 변경</title>
	<style>
	label{
		display : inline-block;
		width : 150px;
	}
	</style>
	
	<!-- <script src="/mySpringWeb/res/script/changePasswd.js" charset="UTF-8"></script> -->
	<script src="<c:url value="/mySpringWeb/res/script/changePasswd.js"/>" charset="UTF-8"/></script>
</head>

<body>

	<h1>회원 비밀번호 변경</h1>
	<hr>
	
	<h3>비밀번호 변경</h3>	
	<form action="changePwd" method="POST">
		<fieldset>
			
			<label for = "email">이메일 : </label> <p>${auth.email}</p>
						
			<label for = "password">현재 비밀번호 : </label>
			<input type="password" name = "password" id = "password" required/><br/>
			
			<label for = "newpasswd">변경 비밀번호 : </label>
			<input type="password" name = "newpasswd" id = "newpasswd" required/><br/>
		
			<label for = "confirmPassword">변경 비밀번호 확인 : </label>
			<input type="password" id = "confirmPassword" required/><br/>	
			<!-- name 속성이 없으면 서버로 파라미터를 넘길 수 없다. 따라서 confirmPassword는 서버로
			넘어가지 않는다. 비밀번호와 비밀번호 확인 검사를 자바스크립트에서 확인하기 위해 -->
		
			<input type="submit" value="비밀번호 변경" />
		</fieldset>
	</form>


	<p><font color="red">${changeErrMsg}</font></p>	
</body>
</html>