<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인 화면</title>
</head>

<body>
	
	<h2>메인 화면</h2>
	<hr/>
	
	<ol>
		<li><a href="<c:url value='/register/step1' />">회원가입</a></li>
		<li><a href="<c:url value='/member/login' />">로그인</a></li>
		<li><a href="<c:url value='/member/changePasswd' />">비밀번호 변경</a></li>
		<li><a href="<c:url value='/member/findMember' />">회원 검색</a></li>
		<li><a href="<c:url value='/member/list' />">전체 회원 검색</a></li>
		<li><a href="<c:url value='/member/logout' />">로그아웃</a></li>
	</ol>
	
</body>
</html>

