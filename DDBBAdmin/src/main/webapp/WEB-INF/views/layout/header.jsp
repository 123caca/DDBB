<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵 관리자 페이지</title>
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/common.css">
<link rel="stylesheet" href="resources/css/header.css">
<link rel="stylesheet" href="resources/css/default.css">
</head>
<body>
	<div class="header">
		<c:if test="${adminuser==null }">
			<div class="header-nav">
				<ul class="header-menu">
					<li>
						<p>로그인</p>
						<ul class="header-sub-menu">
							<li><a href="login">로그인</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</c:if>
		<c:if test="${adminuser!=null }">
			<div class="header-nav">
				<div class="search">
					<form action="search">
						<input type="text" class="input small" name="search" style="width: 128px;"> 
						<img src="resources/images/header/search.png"> 
						<input type="submit" class="cursor" value="검색">
					</form>
				</div>
				<ul class="header-menu">
					<li>
						<p>메인</p>
						<ul class="header-sub-menu">
							<li><a href="index">메인</a></li>
							<c:if test="${adminuser.getAdminUserBanner() == 1 }">
								<li><a href="banner">슬라이드 배너</a></li>
							</c:if>
						</ul>
					</li>
					<li>
						<p>회원관리</p>
						<ul class="header-sub-menu">
							<li><a href="member">사용자 회원 정보</a></li>
							<c:if test="${adminuser.getAdminUserMaster() == 1 }">
								<li><a href="admin">관리자 회원 관리</a></li>
							</c:if>
						</ul>
					</li>
					<c:if test="${adminuser.getAdminUserCustomer() == 1 }">
					<li>
						<p>고객센터</p>
						<ul class="header-sub-menu">
							<li><a href="faq">자주하는 문의</a></li>
							<li><a href="question">1:1 문의</a></li>
							<li><a href="notice">공지사항</a></li>
							<li><a href="event">이벤트</a></li>
						</ul>
					</li>
					</c:if>
					<c:if test="${adminuser.getAdminUserProduct() == 1 }">
						<li>
							<p>상품</p>
							<ul class="header-sub-menu">
								<li><a href="product">상품 목록</a></li>
								<li><a href="product_qna">상품 Q&A</a></li>
							</ul>
						</li>
					</c:if>
					<c:if test="${adminuser.getAdminUserOrder() == 1 }">
						<li>
							<p>주문 / 배송</p>
							<ul class="header-sub-menu">
								<li><a href="order">주문 조회</a></li>
							</ul>
						</li>
					</c:if>
					<li>
						<p>
							<a href="logout">로그아웃</a>
						</p>
					</li>
				</ul>
			</div>
		</c:if>
	</div>
</body>
</html>