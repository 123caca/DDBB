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
	    	if (!document.getElementById("faqTitle").value) {
	    		alert("자주 하는 질문 제목을 입력하세요.");
	    		document.getElementById("faqTitle").focus();  
	    		return false;
	    	}
	    	else if (!document.getElementById("faqContent").value) {
	    		alert("자주 하는 질문 내용을 입력하세요.");
	    		document.getElementById("faqContent").focus();
	    		return false;
	    	}
	    	
			// 제목 길이 체크 (5 ~ 50자)
		    if (document.getElementById("faqTitle").value.length < 5 || document.getElementById("faqTitle").value.length >= 50) {
		        alert("제목을 5 ~ 50자까지 입력해주세요.")
		        document.getElementById("faqTitle").focus()
		        return false;
		    }
			// 내용 길이 체크 (5 ~ 500자)
		    else if (document.getElementById("faqContent").value.length < 5 || document.getElementById("faqContent").value.length >= 500) {
		    	alert("내용을 5 ~ 500자까지 입력해주세요.")
		        document.getElementById("faqContent").focus()
		        return false;
		    }
	    }
    </script>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
    <div class="container customer faq">
        <h1>자주하는 질문 수정</h1>
        <form action="faq_update_fin" method="POST" onsubmit="return chkValue()">
        <input type="hidden" name="cusFaqNum" value="${param.cusFaqNum }">
            <div class="input-wrap">
                <span>제목</span><input type="text" name="cusFaqTitle" class="input large" value="${cusFaqDetail.getCusFaqTitle() }"><br>
                <span>내용</span><textarea name="cusFaqContent" cols="30" rows="10">${cusFaqDetail.getCusFaqContent() }</textarea>
            </div>
            <div class="btn-wrap">
                <input type="submit" class="btn mid" value="저장">
                <input type="button" class="btn mid" value="취소" onclick="history.back()">
            </div>
        </form>
    </div>
</body>
</html>