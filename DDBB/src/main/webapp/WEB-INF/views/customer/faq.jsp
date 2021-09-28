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
                <p> <span>고객센터</span> > <span>자주하는 질문</span>                 </p>
            </div>
        </div>
        
        <div class="list-layout">
            <!-- 자주하는 질문 탭메뉴 [s] -->
            <div class="tab-menu">
                <ul>
                    <li class="active"><a href="faq">자주하는 질문</a></li>
                    <li><a href="question">1:1 문의</a></li>
                    <li><a href="notice">공지사항</a></li>
                    <li><a href="event">이벤트</a></li>
                </ul>
                <div class="tab-title">
                    <h3>자주하는 질문</h3>
                </div>
            </div>
            <!-- 자주하는 질문 탭메뉴 [e] -->
            
            <!-- 자주하는 질문 [s] -->
            <div class="faq-wrap">
                <ul>
				<c:choose>
				<%-- 검색 결과가 있는 경우 --%>
					<c:when test="${fn:length(faqAllList) != 0 }">
	                	<c:forEach var="list" items="${faqAllList }">
	                	<li>
	                		<p>${list.cusFaqTitle }<span class="faq-arrow"></span></p>
	                		<p>${list.cusFaqContent }</p>
	                	</li>
						</c:forEach>
					</c:when>
					<%-- 검색 결과가 없는 경우 --%>
					 <c:otherwise>
					 	<li>
					 		<div class="product-txt"> <p class="title">등록된 자주하는 질문이 없습니다.</p> </div>
					 	</li>
					 </c:otherwise>
				</c:choose>
                </ul>
            </div>
            <!-- 자주하는 질문 [e] -->
            
            <!-- 검색 [s] -->
            <div class="con-search-wrap">
                <div class="con-search">
                    <form action="faq">
                        <div class="select-wrap">
                            <select name="faqOption" id="faqOption">
                                <option value="${null }">검색</option>
                                <option value="1" <c:if test="${param.faqOption == '1' }">selected</c:if>>제목</option>
                                <option value="2" <c:if test="${param.faqOption == '2' }">selected</c:if>>내용</option>
                                <option value="3" <c:if test="${param.faqOption == '3' }">selected</c:if>>제목 + 내용</option>
                            </select>
                        </div>
                        <input type="text" name="faqSearch" value="${param.faqSearch }" placeholder="검색 단어">
                        <img class="right" src="resources/images/header/search.png">
                        <input type="submit" value="검색">
                    </form>
                </div>
            </div>
            <!-- 검색 [e] -->
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>