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
    	// 정렬
    	function proSort(){
	    	var proCategory = '${param.proCategory }';
	    	var sortWord = document.getElementById("sort").value;
			location.href="user_review?paging=${param.paging }&proSort="+sortWord;
	    }
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

	<div class="content-wrap mypage product">
        <div class="content-title">
            <h2>내 상품평</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
					<span>마이페이지</span> > <span>내 상품평</span>
                </p>
            </div>
        </div>

			<!-- 상품평 내용  -->
            <div class="select-wrap">
				상품평 ( <span>${productReviewCount }</span> ) 건 
				<select name="sort" id="sort" class="sort-review" class="sort-review" onChange="proSort()">
						<option value="${null }">정렬순서</option>
						<option value="1" <c:if test="${param.proSort == '1'}">selected</c:if>>별점 높은순</option>
						<option value="2" <c:if test="${param.proSort == '2'}">selected</c:if>>별점 낮은순</option>
						<option value="3" <c:if test="${param.proSort == '3'}">selected</c:if>>최신순</option>
                </select>
			</div>
			<div class="board-wrap product-review" style="padding: 0;">
				<table>
					<tr>
						<th>별점</th>
						<th>상품명</th>
						<th>이미지</th>
						<th>내용</th>
						<th>작성자</th>
						<th>작성일</th>
						<th></th>
					</tr>
	                <c:choose>
	                	<%-- 상품리뷰가 있는 경우 --%>
	               		<c:when test="${fn:length(productReviewList) != 0 }">
							<c:forEach items="${productReviewList }" var="list">
							<tr>
								<c:choose>
									<c:when test="${list.proReviewScore == 1 }"><td><span>★</span></td></c:when>
									<c:when test="${list.proReviewScore == 2 }"><td><span>★★</span></td></c:when>
									<c:when test="${list.proReviewScore == 3 }"><td><span>★★★</span></td></c:when>
									<c:when test="${list.proReviewScore == 4 }"><td><span>★★★★</span></td></c:when>
									<c:when test="${list.proReviewScore == 5 }"><td><span>★★★★★</span></td></c:when>
								</c:choose>
								<td>${list.proReviewProName }</td>
								<td><img alt="리뷰이미지" src="${list.proReviewImg }" /></td>
								<td><p class="review_toggle">${list.proReviewContent }</p></td>
								<td>${list.proReviewUserName }</td>
								<td>${list.proReviewDate }</td>
								<td>
									<a href="my_review_update?proReviewOrderNum=${list.proReviewOrderNum }&proReviewProName=${list.proReviewProName }" class="btn small">수정하기</a>
									<a href="my_review_delete?proReviewOrderNum=${list.proReviewOrderNum }&proReviewProName=${list.proReviewProName }" class="btn small red">삭제하기</a>
								</td>  
							</tr>
							</c:forEach>
	               		</c:when>
	                	<%-- 상품리뷰가 없는 경우 --%>
	                   	<c:otherwise>
	                   		<tr>
	                   			<td colspan="6">해당 상품의 리뷰 내역이 없습니다.</td>
	                   		</tr>
	                   	</c:otherwise>
	                </c:choose>
				</table>
				<div class="page-wrap">
					<span class="prev">-</span>
						<c:forEach var="i" begin="0" end="${(productReviewCount - 1) / 5 }">
							<a href="user_review?paging=${i+1 }&proSort=${param.proSort }">${i+1 }</a>
						</c:forEach>
					<span class="next">-</span>
				</div>
			</div>
		</div>
    
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
    
</body>
</html>