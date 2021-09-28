<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵 관리자 페이지</title>
  	<script src="resources/js/jquery-3.5.1.min.js"></script>
    <script src="resources/js/default.js"></script>
    <script type="text/javascript">
   	 function chkValue() {
    	if (!document.getElementById("answer_content").value) {
    		alert("답변 내용 입력은 필수입니다.");
    		document.getElementById("answer_content").focus();  
    		return false;
    		}
    	}
		// 내용 길이 체크 (5 ~ 500자)
	    if (document.getElementById("answer_content").value.length < 5 || document.getElementById("answer_content").value.length >= 500) {
	        alert("내용을 5 ~ 500자까지 입력해주세요.")
	        document.getElementById("answer_content").focus()
	        return false;
	    }
   	 </script>
</head>

<body>

	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
    
    <div class="container customer answer">
        <h1>1:1 문의 답변</h1>
        <form action="question_answer_fin" onsubmit="return chkValue()">
        <input type="hidden" name="cusQuestionNum" value="${param.cusQuestionNum }">
            <div class="input-wrap">
          	    <span>글번호</span>
                <p>${questionList.cusQuestionNum }</p>
                <br>
                <span>제목</span>
                <p>${questionList.cusQuestionTitle }</p>
                <br>
                <span>작성자</span>
                <p>${questionList.cusQuestionUserName }</p>
                <br>
                <span>내용</span>
                <p>${questionList.cusQuestionContent }</p>
                <br>
                <span>답변</span>
                <textarea name="answer_content" id="answer_content" cols="30" rows="10">${questionList.cusQuestionAnswer }</textarea>
            </div>
            <div class="btn-wrap">
                <input type="submit" class="btn mid" value="저장">
                <input type="button" class="btn mid" value="취소" onclick="history.back()">
            </div>
        </form>
    </div>
</body>
</html>