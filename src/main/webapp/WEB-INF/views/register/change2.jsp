<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 변경 결과</title>
</head>

<body>
	<h1>비밀번호 변경 결과</h1>
	<hr>
	
	<h3>변경된 회원 정보</h3>	
	
	<form:form action="change2" modelAttribute="formData" id="registerForm">
		<fieldset>
			<legend>회원 정보</legend>
			
			<label for = "email">이메일 : </label>	 <!-- required 는 boolean 속성, 반드시 값을 입력해야한다. -->
			<form:input type="email" path="email" required = "required"/><br/>
			
			<label for = "password">현재 비밀번호 : </label>
			<form:password path="password" required = "required"/><br/>
			
			<label for = "confirmPassword">신규 비밀번호 :  </label>
			<form:password path="confirmPassword" required = "required"/><br/>
		
			<input type="submit" value="비밀번호 변경" />
		</fieldset>
	</form:form>
</body>
</html>