<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>login.jsp</title>
</head>

<body>

	<h1>회원 로그인</h1>
	<hr />
	
	<form method="POST" action="loginProcess">
	<fieldset>	
		<legend>로그인</legend>
		<label for="email">이메일</label>
		<input type="email" name="email" id="email" required="required" /> /
		<label for="password">password</label>
		<input type="password" name="password" id="password" required="required" />
		<input type="submit" value="login" />
	</fieldset>
	</form>
	
	<p><font color="red">${loginFailMsg}</font></p>

</body>
</html>
