<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵 관리자 페이지</title>
    <script src="resources/js/jquery-3.5.1.min.js"></script>
    <script src="resources/js/jquery-1.12.1-ui.js"></script>
    <script src="resources/js/default.js"></script>
</head>
<body>
    	<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

    <div class="container user member">
        <h1>사용자 회원 정보</h1>
        <div class="input-wrap">
            <span>아이디</span>
            <p>${userDTO.getUserId() }</p>
            <span>이름</span>
            <p>${userDTO.getUserName() }</p>
            <span>비밀번호</span>
            <p>${userDTO.getUserPwd() }</p>
            <span>이메일</span>
            <p>${userDTO.getUserEmail() }</p>
            <span>핸드폰</span>
            <p>${userDTO.getUserPhone() }</p>
            <span>주소</span>
            <p>${userDTO.getUserPhone() }</p>
            <span>가입일</span>
            <p>${userDTO.getUserJoinDate() }</p>
        </div>
        <div class="btn-wrap">
            <input type="button" onclick="history.back()" class="btn mid" value="목록">
        </div>
    </div>
</body>
</html>