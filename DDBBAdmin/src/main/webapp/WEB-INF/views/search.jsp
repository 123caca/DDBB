<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵 관리자 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<%-- 검색  --%>
	<div class="container user admin_list">
		<h1>검색 결과</h1>
		
		<div class="con-top">
			<form action="search">
				<div class="search">
					<input type="text" class="input small" name="search"> 
					<img src="resources/images/header/search.png"> 
					<input type="submit" class="cursor" value="검색">
				</div>
			</form>
		</div>
		<p class="search-result">
			"<span>${param.search }</span>" 에 대한 검색 결과 총 <span>${productSearchListTotal + customerFaqSearchListTotal + customerQuestionSearchListTotal + customerNoticeSearchListTotal + customerEventSearchListTotal}</span>건
			입니다.
		</p>
		
		<div>
			<%-- 상품 검색 결과 [s] --%>
			<div class="search-top">
				<p>
					상품 ( <span>${ productSearchListTotal }</span> ) 개
				</p>
				<a href="product?paging=1&proSort=&proCategory=proName&proSearch=${param.search }" class="more-btn right">MORE+</a>
			</div>
			<div class="search-list">
				<ul>
					<c:forEach var="list" items="${productSearchList }">
						<li><a href="product_update?proName=${list.proName }">
							<p class="search-tit">
								[ <span class="result"> ${list.getProName() } </span> ]
							</p>
						</a></li>
					</c:forEach>
				</ul>
			</div>
			<%-- 상품 검색 결과 [e] --%>
			
			<%-- 자주하는 질문 검색 결과 [s] --%>
			<div class="search-top">
				<p>
					자주하는 질문 ( <span>${customerFaqSearchListTotal }</span> ) 개
				</p>
				<a href="faq?paging=1&faqOption=3&faqSearch=${param.search }" class="more-btn right">MORE+</a>
			</div>
			<div class="search-list">
				<ul>
					<c:forEach var="list" items="${customerFaqSearchList }">
						<li><a href="faq_update?cusFaqTitle=${list.cusFaqTitle }">
							<p class="search-tit">
								[ <span class="result"> ${list.getCusFaqTitle() } </span> ]
							</p>
							<p class="search-con">
								<span class="result">${list.getCusFaqContent() }</span>
							</p>
						</a></li>
					</c:forEach>
				</ul>
			</div>
			<%-- 자주하는 질문 검색 결과 [e] --%>
			
			<%-- 1:1 문의 검색 결과 [s] --%>
			<div class="search-top">
				<p>
					1:1 문의 ( <span>${customerQuestionSearchListTotal }</span> ) 개
				</p>
				<a href="question?paging=1&questionOption=5&questionSearch=${param.search }" class="more-btn right">MORE+</a>
			</div>
			<div class="search-list">
				<ul>
					<c:forEach var="list" items="${customerQuestionSearchList }">
						<li><a href="question_answer?cusQuestionNum=${list.getCusQuestionNum()}">
							<p class="search-tit">
								[ <span class="result"> ${list.getCusQuestionTitle() } </span> ]
							</p>
							<p class="search-con">
								<span class="result">${list.getCusQuestionContent() }</span>
							</p>
						</a></li>
					</c:forEach>
				</ul>
			</div>
			<%-- 1:1 문의 검색 결과 [e] --%>
			
			<%-- 공지사항 검색 결과 [s] --%>
			<div class="search-top">
				<p>
					공지사항 ( <span>${customerNoticeSearchListTotal }</span> ) 개
				</p>
				<a href="notice?paging=1&noticeOption=3&noticeSearch=${param.search }" class="more-btn right">MORE+</a>
			</div>
			<div class="search-list">
				<ul>
					<c:forEach var="list" items="${customerNoticeSearchList }">
						<li><a href="notice_update?cusNoticeNum=${list.cusNoticeNum}">
							<p class="search-tit">
								[ <span class="result"> ${list.getCusNoticeTitle() } </span> ]
							</p>
							<p class="search-con">
								<span class="result">${list.getCusNoticeContent() }</span>
							</p>
						</a></li>
					</c:forEach>
				</ul>
			</div>
			<%-- 공지사항 검색 결과 [e] --%>
			
			<%-- 이벤트 검색 결과 [s] --%>
			<div class="search-top">
				<p>
					이벤트 ( <span>${customerEventSearchListTotal }</span> ) 개
				</p>
				<a href="event?paging=1&eventOption=1&eventSearch=${param.search }" class="more-btn right">MORE+</a>
			</div>
			<div class="search-list">
				<ul>
					<c:forEach var="list" items="${customerEventSearchList }">
						<li><a href="event_update?cuseventnum=${list.cuseventnum}">
							<p class="search-tit">
								[ <span class="result"> ${list.getCusEventTitle() } </span> ]
							</p>
						</a></li>
					</c:forEach>
				</ul>
			</div>
			<%-- 이벤트 검색 결과 [e] --%>
		</div>
	</div>
</body>
</html>