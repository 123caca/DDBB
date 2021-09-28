<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵 페이지</title>
    <link rel="stylesheet" href="resources/css/reset.css" />
    <link rel="stylesheet" href="resources/css/common.css" />
    <link rel="stylesheet" href="resources/css/header.css" />
    <link rel="stylesheet" href="resources/css/default.css" />
    <link rel="stylesheet" href="resources/css/mypage.css" />
</head>
<body>
    <div class="header">
        <div class="header-nav right"> 
            <ul>
                <!-- 미 로그인  -->
                <c:if test="${user==null }">
                <li>로그인이 필요합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                <li><a href="login">로그인</a></li>
                <li><a href="join_agree">회원가입</a></li>
                <li><a href="faq">고객센터</a></li>
                </c:if>
                 <c:if test="${user!=null }">
                <!-- 로그인  -->
                <li>${user.getUserName() } 님 환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                <li><a href="logout">로그아웃</a></li>
                <li><a href="mypage">MyPage</a></li>
                <li><a href="wish_list">찜목록</a></li>
                <li><a href="cart">장바구니</a></li>
                <li><a href="faq">고객센터</a></li>
                </c:if>
            </ul>
            <div class="header-search">
                <form action="search">
                    <input type="text" name="search">
                    <img class="right" src="resources/images/header/search.png">
                    <input type="submit" value="검색">
               </form>
            </div>
        </div>
        <div class="header-txt">
            <h1><a><img src="resources/images/main/logo.jpg" alt="로고이미지"/></a></h1>
        </div>
        <div class="header-menu">
            <ul>
                <li><a href="product?proCategory=모든빵&proSort=0">모든 빵</a></li>
                <li><a href="product?proCategory=식빵 · 식사용빵&proSort=0">식빵 · 식사용 빵</a></li>
                <li><a href="product?proCategory=간식용빵&proSort=0">간식용 빵</a></li>
                <li><a href="product?proCategory=조리빵&proSort=0">조리 빵</a></li>
                <li><a href="product?proCategory=샌드위치&proSort=0">샌드위치</a></li>
                <li><a href="product?proCategory=케이크&proSort=0">케이크</a></li>
            </ul>
        </div>
    </div>
</body>
</html>