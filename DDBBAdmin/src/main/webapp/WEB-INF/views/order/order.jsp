<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵 관리자 페이지</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	
	<div class="container order">
		<h1>주문 / 배송</h1>
		
		<div class="table-wrap">
			<div class="con-top">
				<p>주문 / 배송 수 ( <span>${orderSimpleCount }</span> ) 개</p>
				<form action="order">
					<div class="select-wrap">
						<select name="orderCategory" id="orderCategory">
							<option value="${null }">검색</option>
							<option value="orderProNumber" <c:if test="${param.orderCategory == 'orderProNumber'}">selected</c:if>>주문번호</option>
							<option value="orderUserId" <c:if test="${param.orderCategory == 'orderUserId'}">selected</c:if>>아이디</option>
							<option value="orderUserName" <c:if test="${param.orderCategory == 'orderUserName'}">selected</c:if>>주문자</option>
							<option value="orderProName" <c:if test="${param.orderCategory == 'orderProName'}">selected</c:if>>제품명</option>
						</select>
					</div>
					<div class="search">
						<input type="text" class="input small" name="orderSearch" value="${param.orderSearch }"> 
						<img src="resources/images/header/search.png"> 
						<input type="submit" class="cursor" value="검색">
					</div>
				</form>
			</div>
			<table>
				<tr>
					<th>주문번호</th>
					<th>아이디</th>
					<th>주문자</th>
					<th>상품</th>
					<th>금액</th>
					<th>상태</th>
				</tr>
               	<c:choose>
               		<%-- 검색 결과가 있는 경우 --%>
              		<c:when test="${fn:length(orderSimpleList) != 0 }">
		                <c:forEach items="${orderSimpleList }" var="list">
						<tr>
							<td><a href="order_con?orderProNumber=${list.orderProNumber }&orderUserId=${list.orderUserId }">${list.orderProNumber }</a></td>
							<td>${list.orderUserId }</td>
							<td>${list.orderUserName }</td>
							<td><a href="order_con?orderProNumber=${list.orderProNumber }&orderUserId=${list.orderUserId }">${list.orderProName }</a></td>
							<td>${list.orderSimTotalCost }</td>
							<td>
							<c:choose>
								<c:when test="${list.orderTracking == 0 }">입금대기</c:when>
								<c:when test="${list.orderTracking == 1 }">출고전</c:when>
								<c:when test="${list.orderTracking == 2 }">배송중</c:when>
								<c:when test="${list.orderTracking == 3 }">배송완료</c:when>
							</c:choose>
							</td>
						</tr>
		                </c:forEach>
               		</c:when>
                	<%-- 검색 결과가 없는 경우 --%>
                   	<c:otherwise>
						<tr>
							<td colspan="6">주문 대기중인 상품이 없습니다.</td>
						</tr>
                   	</c:otherwise>
                </c:choose>
			</table>
		</div>
		<div class="paging-wrap">
			<span class="prev">-</span>
				<c:forEach var="i" begin="0" end="${(orderCount - 1) / 10 }">
					<a href="order?paging=${i+1 }&orderCategory=${param.orderCategory }&orderSearch=${param.orderSearch }">${i+1 }</a>
				</c:forEach>
			<span class="next">-</span>
		</div>
	</div>
</body>
</html>