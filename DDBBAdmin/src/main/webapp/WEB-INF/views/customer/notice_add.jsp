<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	    	if (!document.getElementById("noticeTitle").value) {
	    		alert("공지사항 제목을 입력하세요.");
	    		document.getElementById("noticeTitle").focus();  
	    		return false;
	    	}
	    	else if (!document.getElementById("noticeContent").value) {
	    		alert("공지사항 내용을 입력하세요.");
	    		document.getElementById("noticeContent").focus();
	    		return false;
	    	}
	    	
			// 제목 길이 체크 (5 ~ 50자)
		    if (document.getElementById("noticeTitle").value.length < 5 || document.getElementById("noticeTitle").value.length >= 50) {
		        alert("제목을 5 ~ 50자까지 입력해주세요.")
		        document.getElementById("noticeTitle").focus()
		        return false;
		    }
			// 내용 길이 체크 (5 ~ 500자)
		    else if (document.getElementById("noticeContent").value.length < 5 || document.getElementById("noticeContent").value.length >= 500) {
		        alert("내용을 5 ~ 500자까지 입력해주세요.")
		        document.getElementById("noticeContent").focus()
		        return false;
		    }
	    }
    </script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	
	<div class="container customer notice">
		<h1>공지사항 등록</h1>
		<form action="notice_add_fin" method="POST" onsubmit="return chkValue()">
			<div class="input-wrap">
				<span>제목</span><input type="text" name="noticeTitle" id="noticeTitle" class="input large"><br> 
				<span>내용</span><textarea name="noticeContent" id="noticeContent" cols="30" rows="10"></textarea>
			</div>
			<div class="btn-wrap">
				<input type="submit" name="" class="btn mid" value="등록"> 
				<input type="button" name="" class="btn mid" value="취소" onclick="history.back()">
			</div>
		</form>
	</div>
</body>
</html>