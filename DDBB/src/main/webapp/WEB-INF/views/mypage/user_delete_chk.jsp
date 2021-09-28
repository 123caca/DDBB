<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<div class="content-wrap user_delete_chk">
		<div class="content-title">
			<h2>회원탈퇴</h2>
			<div class="page-location">
				<img src="resources/images/common/home.jpg" alt="집 아이콘">
				<p>
					<span>마이페이지</span> > <span>회원탈퇴</span>
				</p>
			</div>
		</div>
		<div class="input-wrap delete_con">
			<div class="input-content">
				<h3>정말 회원을 탈퇴하시겠습니까?</h3>
				<input type="button" onclick="location.href='user_info'" class="btn large curser" value="취소">
				<input type="button" class="btn large curser" value="탈퇴" onclick="location.href='user_delete_result'"> 
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>