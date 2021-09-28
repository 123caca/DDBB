<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵 관리자 페이지</title>

</head>
<body>
	
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

	<div class="container">
        <h1>답변 대기 중인 게시글</h1>
        <div class="main">
            <p><a href="question">1:1 문의 : <span> ${questionCount }</span>개</a></p>
            <p><a href="product_qna">상품 문의 : <span> ${productCount }</span>개</a></p>
        </div>
        <h1>배송 대기 중인 상품</h1>
        <div class="main">
            <p><a href="order">배송 : <span> ${orderCount }</span>개</a></p>
        </div>
	</div>
</body>
</html> 