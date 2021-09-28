<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵</title>
    <script src="resources/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
    	var totalCost = 0;
    	var oderProName = "";
	    function oderProName(e){
	    	oderProName = e.innerText;
			location.href="product_con?oderProName="+e.innerText;
	    }
    </script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

    <c:set var="orderTotalCost" value="0" />
    
    <div class="content-wrap">
        <div class="content-title">
            <h2>주문 정보 상세</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
                    <span>마이페이지</span> > <span>주문 조회</span> > <span>주문 정보 상세</span>
                </p>
            </div>
        </div>
        <div class="product-wrap">
            <div class="board-wrap buy-list-con">
                <div class="buy-list-tit">
                    <p>주문번호 : <span>${param.proReviewOrderNum }</span></p>
                    <p>주문일자 : <span>${orderList[0].orderDate }</span></p>
                </div>
                <table>
                    <tr>
                        <th>이미지</th>
                        <th>정보</th>
                        <th>판매가</th>
                        <th>수량</th>
                        <th>합계</th>
                        <th>리뷰</th>
                    </tr>
                    <c:forEach var="list" items="${orderList }">
	                    <tr>
	                        <td><a href="#">
	                            <img alt="빵이름" src="resources/images/product/temp.png">
	                        </a></td>
	                        <td><a href="product_con?proName=${list.orderProName }" name="oderProName" onclick="proName(this)">${list.orderProName }</a></td>
	                        <td><span>${list.orderProPrice }</span> 원</td>
	                        <td><span>${list.orderProAccount }</span> 개</td>
	                        <td><span>${list.orderProPrice * list.orderProAccount }</span> 원</td>
			                <c:set var="orderTotalCost" value="${orderTotalCost + list.orderProPrice * list.orderProAccount }" />
	                        <td> 
		                        <c:choose>
 		                        	<%-- 등록된 리뷰가 없을 때 --%>
		                        	<c:when test="${list.orderReviewContent == 0 }">
			                            <a href="review_write?proReviewOrderNum=${param.proReviewOrderNum }&proReviewProName=${list.orderProName }" class="btn small">작성하기</a>                
		                        	</c:when>
		                        	<%-- 등록된 리뷰가 있을 때 --%>
		                        	<c:otherwise>
		                            	<a href="review_update?proReviewOrderNum=${param.proReviewOrderNum }&proReviewProName=${list.orderProName }" class="btn small blue">수정하기</a>                
		                            	<a href="review_delete?proReviewOrderNum=${param.proReviewOrderNum }&proReviewProName=${list.orderProName }" class="btn small red">삭제하기</a>  
		                        	</c:otherwise>
		                        </c:choose>
	                        </td>
	                    </tr>   
                    </c:forEach>
                </table>
                <div class="cart-price">
                    <p>총합계 : <span class="totalCost">${orderTotalCost }</span>원</p>
                </div>
          	  </div>
        </div>
        <div class="product-wrap">
            <div class="board-wrap buy-list-con cart-total">
				<table>
					<tr>
						<th>총상품금액</th>
						<th>배송비</th>
						<th>결제완료금액</th>
					</tr>
					<tr>
						<td><span>${orderTotalCost }</span> 원</td>
						<td>2500 원</td>
						<td><span>${orderTotalCost + 2500 }</span> 원</td>
					</tr>
				</table>
				<div class="cart-btn">
					<p class="btn large ">
                        <a href="buy_list">목록보기</a>
                    </p>
				</div>
        	</div>
        </div>
    </div>
    
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
    
</body>
</html>