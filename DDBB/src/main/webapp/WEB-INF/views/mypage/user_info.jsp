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
	<div class="content-wrap mypage">
		<div class="content-title">
			<h2>회원 정보 관리</h2>
			<div class="page-location">
				<img src="resources/images/common/home.jpg" alt="집 아이콘">
				<p>
					<span>마이페이지</span> > <span>회원 정보 관리</span>
				</p>
			</div>
		</div>
		<div class="content">
			<table class="user_info">
				<tr>
					<td>
						<div class="line">
							<a href="user_modify_chk"> <img src="resources/images/mypage/user_modify.png" alt="회원 정보 수정 아이콘">
								<p>회원 정보 수정</p>
							</a>
						</div>
					</td>
					<td>
						<div>
							<a href="user_delete"> <img src="resources/images/mypage/user_delete.png" alt="회원 탈퇴 아이콘">
								<p>회원 탈퇴</p>
							</a>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>