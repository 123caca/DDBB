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
	<div class="content-wrap login">
		<div class="content-title">
			<h2>아이디 찾기</h2>
			<div class="page-location">
				<img src="/resources/images/common/home.jpg" alt="집 아이콘">
				<p>
					<span>로그인</span> > <span>아이디 찾기</span>
				</p>
			</div>
		</div>
        <div class="search-id">
       		<c:if test="${userDTO !=null }">
           		<p>회원님의 아이디는 '<span>${userDTO.userId }</span>' 입니다.</p>
            	<a href="login" class="btn large">로그인</a>
            	<a href="find_pw" class="btn large">비밀번호 찾기</a>
            </c:if>
            <c:if test="${userDTO ==null }">
            	<p>회원님의 아이디가 없습니다.</p>
            	<a href="login" class="btn large">로그인</a>
            	<a href="javascript:history.back()" class="btn large">이 전</a>
            </c:if>
        </div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</body>
</html>