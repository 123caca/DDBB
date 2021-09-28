<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵</title>
    <script type="text/javascript">
	    function daySearch(){
	    	var startDay = document.getElementById("startDay").value;
	    	var endDay = document.getElementById("endDay").value;
	    	if (startDay > endDay) {
	    		alert("시작일과 종료일을 다시 입력 해 주세요.");
	    		return false;
	    	} else {
				location.href="buy_list?&paging=${param.paging }&startDay=${param.startDay }&endDay=${param.endDay}";
				return true; 
	    	}
	    }
    </script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

    <div class="content-wrap">
		<div class="input-wrap buy-all">
            <div class="content-title">
                <h2>주문 조회</h2>
                <div class="page-location">
                    <img src="resources/images/common/home.jpg" alt="집 아이콘">
                    <p>
                        <span>마이페이지</span> > <span>주문 조회</span>
                    </p>
                </div>
            </div>
    
            <!-- list [s] -->
            <div class="product-wrap">
                <div class="board-wrap buy-list-info">
                	<form action="buy_list" onsubmit="return daySearch()">
	                    <div class="buy-date">
	                        <span>기간별 주문조회 </span>
	                        <input class="btn small" type="date" name="startDay" id="startDay"> ~ <input class="btn small" type="date" name="endDay" id="endDay">&nbsp;&nbsp;
	                        <button type="submit" class="btn small">조회</button>  
	                    </div>
                    </form>
                    <div class="input-title buy-ptag">
                        <p>주문 정보</p>
                    </div>
                    buy_list.jsp

                    <table>    
                        <tr>
                            <th>주문번호</th>
                            <th>주문 정보</th>
                            <th>구매금액</th>
                            <th>주문일자</th>
                            <th>주문처리상태</th>
                        </tr>
                  <c:choose>
                     <%-- 검색 결과가 있는 경우 --%>
                     <c:when test="${fn:length(orderSimpleList) != 0 }">
                              <c:forEach var="list" items="${orderSimpleList }">
                                 <tr>
                                     <td>${list.orderProNumber }</td>
                                     <td><a href="buy_list_con?proReviewOrderNum=${list.orderProNumber }">${list.orderProName }</a></td>
                                     <td><span>${list.orderSimTotalCost + 2500 }</span>원</td>
                                     <td><span>${list.orderDate }</span></td>
                                     <td>
                                     <c:choose>
                                        <c:when test="${list.orderTracking == 0 }">
                                            <p class="btn small red">입금대기중</p>                  
                                        </c:when>
                                        <c:when test="${list.orderTracking == 1 }">
                                            <p class="btn small red">배송준비중</p>                  
                                        </c:when>
                                        <c:when test="${list.orderTracking == 2 }">
                                            <p class="btn small blue">배송중</p>                  
                                        </c:when>
                                        <c:otherwise>
                                            <p class="btn small">배송완료</p>                  
                                        </c:otherwise>
                                     </c:choose>
                                     </td>
                                 </tr>
                        </c:forEach>
                     </c:when>
							<%-- 검색 결과가 없는 경우 --%>
							 <c:otherwise>
							 	<tr>
							 		<td colspan="6">주문하신 상품이 없습니다.</td>
							 	</tr>
							 </c:otherwise>
						</c:choose>
                    </table>
					<div class="page-wrap">
						<span class="prev">-</span>
							<c:forEach var="i" begin="0" end="${(orderSimpleCount - 1) / 12 }">
								<a href="buy_list?paging=${i+1 }&startDay=${param.startDay }&endDay=${param.endDay }">${i+1 }</a>
							</c:forEach>
						<span class="next">-</span>
					</div>
                </div>
            </div>
            <!-- list [e] -->
        </div>
    </div>
    
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
    
</body>
</html>