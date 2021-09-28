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

    <div class="container customer answer">
        <h1>상품 Q&A 답변</h1>
        
		<%-- form [s] --%>
        <form action="product_qna_answer_fn" method="POST">
       		<input type="hidden" name="proQnaNum" value="${param.proQnaNum }">
       		
			<%-- 입력 [s] --%>
            <div class="input-wrap">
                <span>제목</span>
                <p>${productQnaAnswer.proQnaTitle }</p>
                <br>
                <span>작성자</span>
                <p>${productQnaAnswer.proQnaUserName }</p>
                <br>
                <span>내용</span>
                <p>${productQnaAnswer.proQnaContent }</p>
                <br>
                <span>답변</span>
                <textarea name="proQnaAnswer" cols="30" rows="10">${productQnaAnswer.proQnaAnswer }</textarea>
            </div>
			<%-- 입력 [e] --%>
            
            <div class="btn-wrap">
                <input type="submit" class="btn mid" value="등록">
                <input type="button" class="btn mid" value="취소" onclick="history.back()">
            </div>
        </form>
		<%-- form [e] --%>
    </div>
</body>
</html>