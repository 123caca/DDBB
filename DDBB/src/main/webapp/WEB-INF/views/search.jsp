<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

    <div class="content-wrap search">
        <div class="content-title">
            <h2>검색 결과</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
                    <span>검색</span>
                </p>
            </div>
        </div>
        <div class="search-all">
            <div class="search-layout">
                <form action="search">
                    <input type="text" name="search" value="${param.search }">
                    <img class="right" src="resources/images/header/search.png">
                    <input type="submit" value="검색">
               </form>
            </div>
            <p class="search-result">
                "<span>${param.search }</span>" 에 대한 검색 결과 총 <span>${productSearchListTotal + customerFaqSearchListTotal + customerQuestionSearchListTotal + customerNoticeSearchListTotal + customerEventSearchListTotal}</span>건 입니다.
            </p>
        </div>
        <div class="product-wrap">
            <div class="product-top">
                <p>상품 (<span>${ productSearchListTotal }</span>)</p>
                <a href="product?proCategory=모든빵&proSort=0" class="more-btn right">MORE+</a>
            </div>
            <div class="search-list">
                <ul>
                	<c:forEach var="list" items="${productSearchList }">
                    <li><a href="product_con?proName=${list.getProName() }">
                        <p class="search-tit">[ <span class="result"> ${list.getProName() } </span> ]</p>
                    </a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="product-wrap">
            <div class="product-top">
                <p>자주하는 질문 (<span>${customerFaqSearchListTotal }</span>)</p>
                <a href="faq?faqOption=3&faqSearch=${param.search }" class="more-btn right">MORE+</a>
            </div>
            <div class="search-list">
            	<ul>
                	<c:forEach var="list" items="${customerFaqSearchList }">
                    <li><a href="faq?faqOption=3&faqSearch=${param.search }">
                        <p class="search-tit">[ <span class="result"> ${list.getCusFaqTitle() } </span> ]</p>
                    	<p class="search-con">${list.getCusFaqContent() }</span></p>
                    </a></li>
                    </c:forEach>
                </ul>
                
            </div>
        </div>
        <div class="product-wrap">
            <div class="product-top">
                <p>1:1 문의 (<span>${customerQuestionSearchListTotal }</span>)</p>
                <a href="question?paging=1&questionOption=3&questionSearch=${param.search }" class="more-btn right">MORE+</a>
            </div>
            <div class="search-list">
                <ul>
                	<c:forEach var="list" items="${customerQuestionSearchList }">
                    <li><a href="question_con?cusQuestionNum=${list.cusQuestionNum}">
                        <p class="search-tit">[ <span class="result"> ${list.getCusQuestionTitle() } </span> ]</p>
                        <p class="search-con">${list.getCusQuestionContent() }</span></p>
                    </a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="product-wrap">
            <div class="product-top">
                <p>공지사항 (<span>${customerNoticeSearchListTotal }</span>)</p>
                <a href="notice?paging=1&noticeOption=3&noticeSearch=${param.search }" class="more-btn right">MORE+</a>
            </div>
            <div class="search-list">
               <ul>
                	<c:forEach var="list" items="${customerNoticeSearchList }">
                    <li><a href="notice_con?cusNoticeNum=${list.cusNoticeNum }">
                        <p class="search-tit">[ <span class="result"> ${list.getCusNoticeTitle() } </span> ]</p>
                        <p class="search-con">${list.getCusNoticeContent() }</span></p>
                    </a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="product-wrap">
            <div class="product-top">
                <p>이벤트 (<span>${customerEventSearchListTotal }</span>)</p>
                <a href="event?paging=1&eventOption=1&eventSearch=${param.search }" class="more-btn right">MORE+</a>
            </div>
            <div class="search-list">
                <ul>
                	<c:forEach var="list" items="${customerEventSearchList }">
                    <li><a href="event_con?cuseventnum=${list.cuseventnum }">
                        <p class="search-tit">[ <span class="result"> ${list.getCusEventTitle() } </span> ]</p>
                    </a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    
</body>
</html>