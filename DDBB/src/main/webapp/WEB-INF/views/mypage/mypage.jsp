<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <h2>마이페이지</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
                    <span>마이페이지</span>
                </p>
            </div>
        </div>
        
        <div class="content">
            <!-- 마이페이지 [s] -->
            <table class="mypage-list">
                <tr>
                    <td>
                        <div class="line"><a href="user_info">
                            <img src="resources/images/mypage/user_info.jpg" alt="회원정보관리 아이콘"> <br>
                            <p>회원 정보 관리</p>
                        </a></div>
                    </td>
                    <td>
                        <div class="line"><a href="cart">
                            <img src="resources/images/mypage/cart.jpg" alt="장바구니 아이콘"> <br>
                            <p>장바구니</p>
                        </a></div>
                    </td>
                    <td>
                        <div class="line"><a href="wish_list">
                            <img src="resources/images/mypage/wish_list.jpg" alt="나의 찜목록 아이콘"> <br>
                            <p>나의 찜목록</p>
                        </a></div>
                   </td>
                </tr>
                <tr>
                    <td>
                        <div class="line"><a href="buy_list">
                            <img src="resources/images/mypage/buy_list.jpg" alt="주문조회 아이콘"> <br>
                            <p>주문 조회</p>
                        </a></div>
                    </td>
                    <td>
                        <div class="line"><a href="user_question">
                            <img src="resources/images/mypage/user_question.jpg" alt="나의 질문과 답변 아이콘"> <br>
                            <p>나의 질문과 답변</p>
                        </a></div>
                    </td>
                    <td>
                        <div class="line"><a href="user_review">
                            <img src="resources/images/mypage/user_review.jpg" alt="내가 쓴 상품평 아이콘"> <br>
                            <p>내가 쓴 상품평</p>
                        </a></div>
                    </td>
                </tr>
            </table>
            <!-- 마이페이지 [e] -->
        </div>
    </div>
    
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
    
</body>
</html>