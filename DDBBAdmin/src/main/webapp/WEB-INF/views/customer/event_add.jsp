<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	    	if (!document.getElementById("eventTitle").value) {
	    		alert("이벤트 제목을 입력하세요.");
	    		document.getElementById("eventTitle").focus();  
	    		return false;
	    	}
	    	else if(!document.getElementById("eventStartDate").value) {
	    		alert("이벤트 시작일을 입력하세요.");
	    		document.getElementById("eventStartDate").focus();
	    		return false;
	    	}
	    	else if (!document.getElementById("eventEndDate").value) {
	    		alert("이벤트 종료일을 입력하세요.");
	    		document.getElementById("eventEndDate").focus();
	    		return false;
	    	}
	    	else if(!document.getElementById("eventThumbnailImg").value) {
	    		alert("썸네일 이미지를 업로드하세요.");
	    		document.getElementById("eventThumbnailImg").focus();
	    		return false;
	    	}
	    	else if (!document.getElementById("eventContentImg").value) {
	    		alert("본문 이미지를 업로드하세요.");
	    		document.getElementById("eventContentImg").focus();
	    		return false;
	    	} else if (document.getElementById("eventStartDate").value > document.getElementById("eventEndDate").value) {
	    		alert("이벤트 날짜를 다시 확인 해 주세요. ");
	    		document.getElementById("eventStartDate").focus();
	    		return false;
	    	}
	    	
			// 제목 길이 체크 (5 ~ 50자)
		    if (document.getElementById("eventTitle").value.length < 5 || document.getElementById("eventTitle").value.length >= 50) {
		        alert("제목을 5 ~ 50자까지 입력해주세요.")
		        document.getElementById("eventTitle").focus()
		        return false;
		    }
	    }
    </script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

    <div class="container banner">
        <h1>이벤트 등록</h1>
        <form action="event_add_fin" method="POST" enctype="multipart/form-data" onsubmit="return chkValue()">
            <div class="input-wrap">
                <span>제목</span>
                <input type="text" id="eventTitle" name="cusEventTitle" class="input large"><br>
                <span>기간</span>
                <input class="input small" id="eventStartDate" name="cusEventStartDate" type="date">
                 ~ 
                <input class="input small" id="eventEndDate" name="cusEventEndDate" type="date"><br>
                <span>썸네일</span>
                <input type="file" accept=".png,.jpg,.gif" id="eventThumbnailImg" name="cusEventThumbnailImg" class="input large input-file"><br>
                <p class="img-notice">※ a파일 확장자는 png, jpg, gif만 가능합니다.</p>
                <span>본문이미지</span>
                <input type="file" accept=".png,.jpg,.gif" id="eventContentImg"name="cusEventContentsImg" class="input large input-file"><br>
                <p class="img-notice">※ a파일 확장자는 png, jpg, gif만 가능합니다.</p>
            </div>
            <div class="btn-wrap">
                <input type="submit" class="btn mid" value="등록">
                <input type="button" onclick="history.back()" class="btn mid" value="취소">
            </div>
        </form>
    </div>
</body>
</html>