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
<script type="text/javascript">
    	// 정렬
    	function proSort(){
	    	var proCategory = '${param.proCategory }';
	    	var sortWord = document.getElementById("sort").value;
			location.href="product?proSort="+sortWord+"&paging=${param.paging }&proCategory=${param.proCategory }&proSearch=${param.proSearch}";
	    }
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
    <div class="content-wrap">
        <div class="content-title">
        	<c:choose>
        		<%-- 식빵인 경우 식빵·식사용빵 으로 출력 --%>
        		<c:when test="${param.proCategory == '식빵' }">
		            <h2>식빵 · 식사용빵</h2>
        		</c:when>
        		<%-- 그 외에는 카테고리 이름 출력 --%>
        		<c:otherwise>
		            <h2>${param.proCategory }</h2>
        		</c:otherwise>
        	</c:choose>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
					<span>상품</span> > <span>${param.proCategory }</span>
                </p>
            </div>
        </div>
        <div class="product-wrap">
        	<!-- 상품 카테고리 -->
            <div class="product-top">
                <div class="select-wrap right">
                    <select name="sort" id="sort" onChange="proSort()">
	                    <option value="1" <c:if test="${param.proSort == '1'}">selected</c:if>>인기순</option>
	                    <option value="2" <c:if test="${param.proSort == '2'}">selected</c:if>>이름순</option>
	                    <option value="3" <c:if test="${param.proSort == '3'}">selected</c:if>>낮은 가격순</option>
	                    <option value="4" <c:if test="${param.proSort == '4'}">selected</c:if>>높은 가격순</option>
                    </select>
                </div>
                <p>빵 갯수 ( <span>${productCount }</span> )</p>
            </div>
            
            <!-- 상품 리스트 출력 -->
            <div class="product-list">
                <ul class="product">
                <c:choose>
                	<%-- 검색 결과가 있는 경우 --%>
               		<c:when test="${fn:length(productList) != 0 }">
						<c:forEach items="${productList }" var="list">
	                    <li><a href="product_con?proName=${list.proName }">
	                        <div class="product-img">
	                            <img src="${list.proImg }" alt="상품 이미지" />
	                        </div>
	                        <div class="product-txt">
                               <p class="price"><span>${list.proPrice }</span> 원</p>
                               <p class="title">${list.proName } ( ${list.getProReviewTotal() } )</p>
                           </div>
	                    </a></li>
						</c:forEach>
               		</c:when>
                	<%-- 검색 결과가 없는 경우 --%>
                   	<c:otherwise>
                   		<li>해당 상품이 없습니다.</li>
                   	</c:otherwise>
                </c:choose>
                </ul>
				<div class="page-wrap">
					<span class="prev">-</span>
						<c:forEach var="i" begin="0" end="${(productCount - 1) / 12 }">
							<a href="product?paging=${i+1 }&proSort=${param.proSort}&proCategory=${param.proCategory }&proSearch=${param.proSearch }">${i+1 }</a>
						</c:forEach>
					<span class="next">-</span>
				</div>
            </div>
        </div>
    </div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>