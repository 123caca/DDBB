<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵 관리자 페이지</title>
    <script type="text/javascript">
	    function checkValue() {
	    	if (!document.getElementById("proCategory").value) {
	    		alert("카테고리를 선택하세요.");
	    		document.getElementById("proCategory").focus();  
	    		return false;
	    	}
	    	else if (!document.getElementById("proName").value) {
	    		alert("제품명을 입력하세요.");
	    		document.getElementById("proName").focus();
	    		return false;
	    	}
	    	else if (!document.getElementById("proPrice").value) {
	    		alert("가격을 입력하세요.");
	    		document.getElementById("proPrice").focus();
	    		return false;
	    	} 
	    	else if (!document.getElementById("proImg").value) {
	    		alert("상품이미지를 첨부하세요");
	    		document.getElementById("proImg").focus();
	    		return false;
	    	}
	    	else if (!document.getElementById("proContentImg").value) {
	    		alert("본문이미지를 첨부하세요");
	    		document.getElementById("proContentImg").focus();
	    		return false;
	    	}
	    	
	    	// 가격 문자 & 숫자 확인
			for (i = 0; i < document.getElementById("proPrice").value.length; i++) {
		        ch = document.getElementById("proPrice").value.charAt(i)
		        if (!(ch >= '0' && ch <= '9')) {
		    		alert("상품 가격은 숫자만 가능합니다.");
		    		document.getElementById("proPrice").value = "";
		    		document.getElementById("proPrice").focus();
		    		return false;
		        }
		    }
			
			// 제품명 체크 (2 ~ 20자)
		    if (document.getElementById("proName").value.length < 2 || document.getElementById("adminUserName").value.length >= 20) {
		        alert("제품명을 2 ~ 20자까지 입력해주세요.")
		        document.getElementById("proName").focus()
		        return false;
		    }
	    }
    </script>
</head>
<body>
		
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	
    <div class="container">
        <h1>상품 등록</h1>
        
		<%-- form [s] --%>
        <form action="product_add_fn" method="POST" onsubmit="return checkValue()" enctype="multipart/form-data">
        
			<%-- 입력 [s] --%>
            <div class="input-wrap">
            	<span>카테고리</span><!--
            	--><div class="select-wrap">
					<select name="proCategory" id="proCategory" class="input small">
						<option value="">카테고리 선택</option>
						<option value="1">식사용빵 · 식빵</option>
						<option value="2">간식용 빵</option>
						<option value="3">조리빵</option>
						<option value="4">샌드위치</option>
						<option value="5">케이크</option>
					</select>
				</div><br>
                <span>제품명</span><input type="text" name="proName" id="proName" class="input small"><br>
                <span>가격</span><input type="text" name="proPrice" id="proPrice" class="input small"> 원<br>
                <span>상품이미지</span><input type="file" accept=".png,.jpg,.gif" name="proImg" id="proImg" class="input large input-file"><br>
                <p class="img-notice">※ 파일 확장자는 png, jpg, gif만 가능합니다.</p>
                <span>본문이미지</span><input type="file" accept=".png,.jpg,.gif" name="proContentImg" id="proContentImg" class="input large input-file">
                <p class="img-notice">※ 파일 확장자는 png, jpg, gif만 가능합니다.</p>
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