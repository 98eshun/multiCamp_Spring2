<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원검색</title>
	<style>
	table, td {
		border: 2px solid gray;
		border-collapse: collapse;
	}
	
	td {
		padding: 20px;
	}
	
	td.value {
		width: 200px;
	}
	</style>
</head>

<body>
	
	<h2>회원검색</h2>
	<hr>
	
	<form action="findProcess" method="post">
	<fieldset>	
		<legend>로그인</legend>
		<label for="email">이메일</label>
		<input type="email" name="email" id="email" required="required" /> /
		<input type="submit" value="검색" />
	</fieldset>
	</form>
	
	<hr/>
	
	<table>
		<tr>
			<td>이메일</td><td class="value">${member.email}</td>		
		</tr>
		<tr>
			<td>이름</td><td class="value">${member.name)}</td>		
		</tr>
		<tr>
			<td>등록일자</td><td class="value">${member.registerDateTime.toLocalDate()}</td>		
		</tr>
	</table>
	
	<p><font color="red">${erMsg}</font></p>
</body>
</html>