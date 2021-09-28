<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵</title>
    <link rel="stylesheet" type="text/css" href="resources/slick/slick.css" />
    <link rel="stylesheet" type="text/css" href="resources/slick/slick-theme.css" />

    <script src="resources/js/jquery-3.5.1.min.js" /></script>
    <script src="resources/js/jquery-1.12.1-ui.js" /></script>
    <script src="resources/js/default.js" /></script>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	
    <div class="main-wrap">
        
        <!-- 메인 슬라이드 [s] -->
        <div class="main-slide-wrap">
			<c:forEach var="list" items="${mainBannerList }">
			<div>
                <img src="${list.mainBannerImg  }" alt="메인 슬라이드">
            </div>
            </c:forEach>
        </div>
        <script type="text/javascript" src="..//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="..//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript" src="resources/slick/slick.min.js" /></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('.main-slide-wrap').slick();
            });
        </script>
        <!-- 메인 슬라이드 [e] -->
		
		<!-- 메인 컨텐츠 [s] -->
        <div class="main-con-wrap">
            <div class="main-notice-wrap">
                <div class="main-sns">
                    <a href="https://www.instagram.com/parksiu0823_food/"><img src="resources/images/main/ddbbinsta.jpg" alt="빵스타그램"></a>
                </div>
                <div class="main-notice">
                    <strong>공지사항</strong>
                    <ul>
                    	<c:forEach var="i" begin="0" end="4">
                       		 <li><a href="notice_con?cusNoticeNum=${noticeMainList[i].cusNoticeNum}">${noticeMainList[i].cusNoticeTitle}<span>${noticeMainList[i].cusNoticeDate}</span></a></li>
                    	</c:forEach>
                    </ul>
                </div>
            </div>
            <div class="main-event-wrap">
                <div class="main-tit">
                    <h3><span>이벤트</span></h3>
                </div>
                <ul class="main-event">
                	<c:forEach items="${eventMainList }" var="eventList">
                    <li><a href="event_con?cuseventnum=${eventList.cuseventnum}">
                        <img src="${eventList.cusEventThumbnailImg }" alt="이벤트 이미지">
                        <p>${eventList.cusEventTitle}</p>
                    </a></li>
                	</c:forEach>
                </ul>
            </div>
            <div class="main-best-menu">
                <div class="main-tit">
                    <h3><span>베스트 상품</span></h3>
                </div>
                <ul class="main-best">
                	<c:forEach var="list" begin="0" end="7" items="${productMainList }">
	                    <li><a href="product_con?proName=${list.proName }">
	                        <img src="${list.proImg }" alt="제품 이미지">
	                    </a></li>
                	</c:forEach>
                </ul>
            </div>
        </div>
		<!-- 메인 컨텐츠 [e] -->
    </div>
    
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html> 