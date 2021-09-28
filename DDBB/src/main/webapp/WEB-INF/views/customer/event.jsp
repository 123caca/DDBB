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
     <title>뛰뛰빵빵</title>
      <script src="resources/js/jquery-3.5.1.min.js"></script>
    <script src="resources/js/jquery-1.12.1-ui.js"></script>
    <script src="resources/js/default.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<div class="content-wrap">

		<div class="content-title">
			<h2>고객센터</h2>
			<div class="page-location">
				<img src="resources/images/common/home.jpg" alt="집 아이콘">
				<p>
					<span>고객센터</span> > <span>이벤트</span>
				</p>
			</div>
		</div>

		<div class="list-layout">
			<!-- 이벤트 탭메뉴 [s] -->
			<div class="tab-menu">
				<ul>
					<li><a href="faq">자주하는 질문</a></li>
					<li><a href="question">1:1 문의</a></li>
					<li><a href="notice">공지사항</a></li>
					<li class="active"><a href="event">이벤트</a></li>
				</ul>
				<div class="tab-title">
					<h3>이벤트</h3>
				</div>
			</div>
			<!-- 이벤트 탭메뉴 [e] -->

			<!-- 이벤트 내용 [s] -->
			<div class="product-wrap">
				<div class="product-top">
					<p>전체 ( <span><fmt:formatNumber value="${eventCount }" /></span> ) </p>
				</div>
				<div class="product-list">
					<ul class="product">
					<c:choose>
					<%-- 검색 결과가 있는 경우 --%>
						<c:when test="${fn:length(eventAllList) !=0 }">
							<c:forEach var="list" items="${eventAllList }">
								<li>
									<a href="event_con?cuseventnum=${list.cuseventnum }">
									<div class="product-img"> <img src="${list.cusEventThumbnailImg }" alt="이벤트 이미지"> </div>
									<div class="product-txt"> 
										<p class="title">${list.cusEventTitle }</p>
										<p class="title">${list.getCusEventstartdate() } ~ ${list.getCusEventenddate() }</p> 
									</div>
									</a>
								</li>
							</c:forEach>
						</c:when>
							<%-- 검색 결과가 없는 경우 --%>
							 <c:otherwise>
							 	<li>
							 		<div class="product-txt"> <p class="title">해당하는 이벤트가 없습니다.</p> </div>
							 	</li>
							 </c:otherwise>
					</c:choose>
					</ul>
					<div class="page-wrap">
						<ul class="page">
							 <c:forEach var="i" begin="0" end="${(eventCount - 1) / 10 }"><li>
								<a href="event?paging=${i+1 }&eventOption=${param.eventOption }&eventSearch=${param.eventSearch }">${i+1 }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<!-- 이벤트 내용 [e] -->

			<!-- 검색 [s] -->
			<div class="con-search-wrap">
				<div class="con-search">
					<form action="event">
						<div class="select-wrap">
							<select name="eventOption" id="eventOption">
								<option value="${null }"">검색</option>
								<option value="1"<c:if test="${param.eventOption == '1' }">selected</c:if>>제목</option>
							</select>
						</div>
						<input type="text" name="eventSearch" value="${param.eventSearch }" placeholder="검색 단어"> <img
							class="right" src="resources/images/header/search.png"> <input
							type="submit" value="검색" >
					</form>
				</div>
			</div>
			<!-- 검색 [e] -->
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>