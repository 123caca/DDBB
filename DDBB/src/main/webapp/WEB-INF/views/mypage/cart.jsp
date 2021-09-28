<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/default.js"></script>
<script type="text/javascript">
	
	function chk(){
		var size = 0; 		// 선택된 항목들의 갯수
		var total = 0;		// 선택된 항목들의 가격 합산
		$(".cartcolumn").find(":checkBox").each(function(){
			if ($(this).is(":checked")) {
				size++;
				total += Number($(this).next().text());
			}
		});
		if (size == 0) {
			alert("선택된 상품이 없습니다.");
			return false;
		} else {
			$("#size").val(size);
			$("#orderSimSelectCost").val(total);
		}
	}
	
	// 개별 삭제
	function one_deleteF(proName){
		var result = confirm("삭제하시겠습니까?");
		if(result){
			location.href="cart_delete?proName="+proName;
		}
	}
	
	// 전체 주문
	function all_orderF(){
		var array=document.getElementsByName("chBox");
		
		if(array.length==0){
			alert("주문 할 항목이 없습니다.");
			return false;
		} else{
			if(confirm("전체 주문하시겠습니까?")){
				for(var i = 0; i<array.length;i++){
					array[i].checked = true;
				}
			}
		}
	}
</script>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	
    <div class="content-wrap">
        <div class="content-title">
            <h2>장바구니</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
                    <span>마이페이지</span> > <span>장바구니</span>
                </p>
            </div>
        </div>
        <form action="buy" onsubmit="return chk()">
        <div class="product-wrap">
            <div class="board-wrap cartcolumn">
                <table>
                    <tr>
                        <th><input type="checkbox" name="allCheck" id="allCheck"></th>
                        <th>이미지</th>
                        <th>정보</th>
                        <th>판매가</th>
                        <th>수량</th>
                        <th>합계</th>
                        <th>삭제</th>
                    </tr>
                    <c:choose>
                    	<c:when test="${fn:length(cart) != 0 }">
	                        <c:set var="orderSimTotalCost" value="0" />
		                    <c:forEach var="list" items="${cart }" varStatus="status">
			                    <tr>
			                        <td>
			                        	<input type="checkbox" name="chBox" class="chBox" value="${list.proName }">
			                        	<span style="display: none;">${list.proPrice * list.addAccount }</span>
		                        	</td>
			                        <td><a href="product_con?proName=${list.proName }"><img alt="빵이름" src="${list.proImg }"></a></td>
			                        <td><a href="product_con?proName=${list.proName }">${list.proName }</a></td>
			                        <td><span>${list.proPrice }</span> 원</td>
			                        <td><span>${list.addAccount }</span></td>
			                        <td><span>${list.proPrice * list.addAccount }</span> 원</td>
			                        <c:set var="orderSimTotalCost" value="${orderSimTotalCost + list.proPrice * list.addAccount }" />
			                        <td> 
			                        	<input type="button" class="btn small" value="삭 제" onclick="one_deleteF('${list.proName}')">
			                        </td>
			                    </tr>        
		                    </c:forEach>
                    	</c:when>
                    	<c:otherwise>
                    		<tr>
                    			<td colspan="7">장바구니에 목록이 없습니다.</td>
                    		</tr>
                    	</c:otherwise>
                    </c:choose>
                </table>
                <div class="cart-price">
                	<c:choose>
                		<c:when test="${orderSimTotalCost != null }">
		                    <p>총합계 : <span>${orderSimTotalCost }</span>원</p>
                		</c:when>
                		<c:otherwise>
		                    <p>총합계 : <span>0</span>원</p>
                		</c:otherwise>
                	</c:choose>
                </div>
         	</div>
        </div>
        <div class="product-wrap">
            <div class="board-wrap cart-total">
				<table>
					<tr>
						<th>총상품금액</th>
						<th>배송비</th>
						<th>결제예정금액</th>
					</tr>
                	<c:choose>
                		<c:when test="${orderSimTotalCost != null }">
							<tr>	
								<td><span>${orderSimTotalCost }</span>원
								<input type="hidden" name="orderSimSelectCost" id="orderSimSelectCost"/>
								<input type="hidden" name="size" id="size"/>
								</td>
								<td>2500원</td>
								<td><span>${orderSimTotalCost + 2500 }</span>원</td>
							</tr>
                		</c:when>
                		<c:otherwise>	
							<tr>	
								<td><span>0</span>원</td> 
								<td>2500원</td>
								<td><span>2500</span>원</td>
							</tr>
                		</c:otherwise>
                	</c:choose>
				</table>
				<div class="cart-btn">
	                <input type="submit" class="btn large" value="전체상품주문" onclick="all_orderF()">
	                <input type="submit" class="btn large" value="선택상품주문">
				</div>
        	</div>
        </div>
        </form>
    </div>
	
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
	
</body>
</html>