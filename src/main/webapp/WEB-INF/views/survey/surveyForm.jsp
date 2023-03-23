<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>설문조사</title>
</head>

<body>
	
	<h2>설문조사</h2>
	<hr/>
	<form method="POST">
	
	<fieldset>
	<legend>설문</legend>
	<p>
		1. 당신의 역할은 무엇입니까?<br/>
		<label for ="responses01">서버 개발자</label>
		<input type="radio" name="responses[0]" id="responses01" value="서버"/>
		<label for ="responses02">프론트 개발자</label>
		<input type="radio" name="responses[0]" id="responses01" value="프론트"/>
		<label for ="responses03">풀스택 개발자</label>
		<input type="radio" name="responses[0]" id="responses01" value="풀스택"/>
	
	</p>
	
	<p>
		2. 많이 사용하는 개발 도구는 무엇입니까?<br/>
		<label for ="responses11">Eclipse</label>
		<input type="radio" name="responses[1]" id="responses11" value="Eclipse"/>
		<label for ="responses12">intellij</label>
		<input type="radio" name="responses[1]" id="responses11" value="intellij"/>
		<label for ="responses13">Sublime</label>
		<input type="radio" name="responses[1]" id="responses11" value="Sublime"/>
	
	</p>
	
	<p>
		<label for ="responses2">3. 하고 싶은 말을 적어주세요</label>
		<input type="text" name="responses[2]"/>
	</p>
	</fieldset>
	
	<fieldset>
	<legend>응답자 정보</legend>
		<label for ="responses21">응답자 위치</label>
		<input type="text" name="responses[2]" id="responses21"/>
		<label for ="responses22">응답자 나이</label>
		<input type="number" name="responses[2]" id="responses22"/>
		
	</fieldset>
	<input type="submit" value="제출">

	</form>
</body>
</html>