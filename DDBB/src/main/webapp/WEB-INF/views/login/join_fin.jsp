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
	<jsp:include page="/WEB-INF/views/layout/header.jsp"/>
    <div class="content-wrap">
		<div class="content-title">
			<h2>회원가입</h2>
			<div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
                    <span>로그인</span> > <span>회원가입</span>
                </p>
            </div> 
        </div>
        <div class="join_fin">
            <img src="resources/images/login/join_complete.png">
            <h3>회원가입을 축하드립니다!</h3>
            <a href="login" class="btn large">로그인</a>
            <a href="index" class="btn large">메 인</a>
        </div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
	
</body>
</html>