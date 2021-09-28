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
	    	if (!document.getElementById("mainBannerTitle").value) {
	    		alert("슬라이드 배너 제목을 입력하세요.");
	    		document.getElementById("mainBannerTitle").focus();  
	    		return false;
	    	}
	    	else if (!document.getElementById("mainBannerImg").value) {
	    		alert("슬라이드 배너 이미지를 등록하세요.");
	    		document.getElementById("mainBannerImg").focus();
	    		return false;
	    	}
	    	else if (!document.getElementById("mainBannerSort").value) {
	    		alert("슬라이드 배너 노출 순서를 입력하세요.");
	    		document.getElementById("mainBannerSort").focus();
	    		return false;
	    	}
	    	
	    	// 슬라이드 배너 제목 길이 체크 (5 ~ 50자)
	        if (document.getElementById("mainBannerTitle").value.length < 5 || document.getElementById("mainBannerTitle").value.length >= 50) {
	            alert("슬라이드 배너 제목을 5 ~ 50자까지 입력해주세요.")
	            document.getElementById("mainBannerTitle").focus()
	            return false;
	        }
	    	// 링크 길이 체크 (100자 이내)
	        else if (document.getElementById("mainBannerLink").value.length >= 100) {
	            alert("링크를 100자 이내로 입력해주세요.")
	            document.getElementById("mainBannerLink").focus()
	            return false;
	        }
	    }
    </script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	
	<div class="container banner">
        <h1>슬라이드 배너 등록</h1>
        <form action="banner_add_fin" method="POST" onsubmit="return chkValue()" enctype="multipart/form-data">
            <div class="input-wrap">
                <span>제목</span><input type="text" name="mainBannerTitle" id="mainBannerTitle" class="input large"><br>
                <span>이미지</span><input type="file" accept=".png,.jpg,.gif" name="mainBannerImg" id="mainBannerImg" class="input large input-file"><br>
                <p class="img-notice">※ 파일 확장자는 png, jpg, gif만 가능합니다.</p>
                <span>링크</span><input type="text" name="mainBannerLink" class="input large"><br>
                <span>노출순서</span><input type="text" name="mainBannerSort" id="mainBannerSort" class="input s_mid">
            </div>
            <div class="btn-wrap">
                <input type="submit" class="btn mid" value="등록">
                <input type="button" class="btn mid" value="취소" onclick="history.back()">
            </div>
        </form>
    </div>
</body>
</html>