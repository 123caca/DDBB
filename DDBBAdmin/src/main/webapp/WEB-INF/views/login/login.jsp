<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵 관리자 페이지</title>
</head>
<script type="text/javascript">
if("${ adminUserLogin }"!=""){
alert("${ adminUserLogin }");
}
</script>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<div class="container login">
		<h1>로그인</h1>
		<form action="adminuser_login" method="POST">
			<div class="input-wrap">
				<span>아이디</span><input type="text" name="id" id="id"><br>
				<span>비밀번호</span><input type="password" name="pwd" id="pwd">
			</div>
			<div class="btn-wrap">
				<input type="submit" class="btn mid" value="로그인">
			</div>
		</form>
	</div>
</body>
</html>