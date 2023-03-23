<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>설문 응답 결과</title>
</head>

<body>
	
	<h2> 설문 응답 결과</h2>
	<hr/>
	
	<p>응답</p>
	

	<h5>1번 문항 : ${list[0]}</h5>

	<h5>2번 문항 : ${list[1]}</h5>

	<h5>3번 문항 : ${list[2]}</h5>
	
	<!--
	<c:forEach var = "response" items = "${ansData.responses}" varStatus = "status">
		<li>${status.count}번 문항 : ${response}</li>		// 이런식으로도 가능
	</c:forEach>
	-->

	<p>응답자 정보</p>
	
	<h5>응답자 위치 : ${res.getLocation}</h5>
	<h5>응답자 나이 :${res.getAge}</h5>
</body>
</html>