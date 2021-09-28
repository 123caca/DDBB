<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵</title>
<script type="text/javascript">
	// 로그인 확인 ( 아이디, 비밀번호 )
	if("${ userLogin }"!=""){
	alert("${ userLogin }");
	}
</script>
<style>
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<div class="content-wrap login">
		<div class="content-title">
			<h2>로그인</h2>
			<div class="page-location">
				<img src="resources/images/common/home.jpg" alt="집 아이콘">
				<p>
					<span>로그인</span>
				</p>
			</div>
		</div>
		<div class="input-wrap login-form">
			<div class="input-content">
				<!--  데이터 입력 칸 출력 ( 아이디, 비밀번호 )  -->
				<form action="user_login" method="post">
					<p>
						<span>아이디</span> <input type="text" class="grande" name="id">
					</p>
					<p>
						<span>비밀번호</span> <input type="password" class="grande" name="pwd">
					</p>
					<p class="id-remember">
						<label><input type="checkbox" name="autologin" value="chkok">자동로그인</label>
					</p>
					<p>
						<input type="submit" class="btn large" value="로그인">
						<a href="join_agree"><input type="button" class="btn large curser"	value="회원가입"></a>
					</p>
					<p>
						<a href="find_id">아이디 찾기</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="find_pw">비밀번호 찾기</a>
					</p>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>