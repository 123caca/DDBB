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

	<div class="container">
		<h1>주문 / 배송 상세페이지</h1>
		<form action="order_update" method="POST">
			<input type="hidden" name="orderProNumber" value="${param.orderProNumber }">
			<div class="input-wrap">
				<span>주문번호</span>
				<p>${param.orderProNumber }</p>
				<span>주문자</span>
				<p>${param.orderUserId }</p>
				<span>핸드폰</span>
				<p>${orderUser.userPhone }</p>
				<span>이메일</span>
				<p>${orderUser.userEmail }</p>  
				<span>주소</span>
				<p>
					${orderUser.userAddress }
				</p>
				<span>상품</span>
				<p>
					<c:forEach var="list" items="${orderList }">
						${list.orderProName }<br>
					</c:forEach>
				</p>
				<span>배송상태</span>
				<p><label><input type="checkbox" name="orderTracking" value="chk">출고 완료</label></p>
			</div>
			<div class="btn-wrap">
                <input type="submit" class="btn mid" value="저장">
                <input type="button" class="btn mid" value="취소" onclick="history.back()">
			</div>
		</form>
	</div>
</body>
</html>