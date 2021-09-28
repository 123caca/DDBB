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
	    }
    </script>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

    <div class="container">
        <h1>상품 수정</h1>
        
		<%-- form [s] --%>
        <form action="product_update_fn" method="POST" onsubmit="return checkValue()" onsubmit="return checkValue()" enctype="multipart/form-data">
        	<input type="hidden" name="proName" id="proName" class="input small" value="${productModify.proName }">
        	
			<%-- 입력 [s] --%>
            <div class="input-wrap">
                <span>제품명</span>${productModify.proName }<br>
            	<span>카테고리</span><!--
            	--><div class="select-wrap">
					<select name="proCategory" id="proCategory" class="input small">
						<option value="">카테고리 선택</option>
						<option value="1" <c:if test="${productModify.proCategory == '식빵 · 식사용빵'}">selected</c:if>>식빵 · 식사용빵</option>
						<option value="2" <c:if test="${productModify.proCategory == '간식용빵'}">selected</c:if>>간식용빵</option>
						<option value="3" <c:if test="${productModify.proCategory == '조리빵'}">selected</c:if>>조리빵</option>
						<option value="4" <c:if test="${productModify.proCategory == '샌드위치'}">selected</c:if>>샌드위치</option>
						<option value="5" <c:if test="${productModify.proCategory == '케이크'}">selected</c:if>>케이크</option>
					</select>
				</div><br>
                <span>가격</span><input type="text" name="proPrice" id="proPrice" class="input small" value="${productModify.proPrice }"> 원<br>
                <span>상품이미지</span><input type="file" accept=".png,.jpg,.gif" name="proImg" id="proImg" class="input large input-file"><br>
                <p class="img-notice">※ 파일 확장자는 png, jpg, gif만 가능합니다.</p>
                <span>본문이미지</span><input type="file" accept=".png,.jpg,.gif" name="proContentImg" id="proContentImg" class="input large input-file"><br>
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