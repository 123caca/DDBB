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
                     <span>고객센터</span> > <span>공지사항</span>
                </p>
            </div>
        </div>
        
        <div class="list-layout">
            <!-- 공지사항 탭메뉴 [s] -->
            <div class="tab-menu">
                <ul>
                    <li><a href="faq">자주하는 질문</a></li>
                    <li><a href="question">1:1 문의</a></li>
                    <li class="active"><a href="notice">공지사항</a></li>
                    <li><a href="event">이벤트</a></li>
                </ul>
                <div class="tab-title">
                    <h3>공지사항</h3>
                </div>
            </div>
            <!-- 공지사항 탭메뉴 [e] -->

            <!-- 공지사항 내용 [s] -->
            <div class="board-wrap notice-table">
                <table>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>날짜</th>
                    </tr>
                    <c:choose>
					<%-- 검색 결과가 있는 경우 --%>
						<c:when test="${fn:length(noticeAllList) !=0 }">
      		              <c:forEach var="list" items="${noticeAllList }">
                      <tr>
                        <td>${list.cusNoticeNum }</td>
                        <td><a href="notice_con?cusNoticeNum=${list.cusNoticeNum }">
                           ${list.cusNoticeTitle }
                        </a></td>
                        <td> ${list.cusNoticeDate }</td>
                    </tr>   
                    </c:forEach>
                    </c:when>
					<%-- 검색 결과가 없는 경우 --%>
							<c:otherwise>
							<tr>
								<td colspan="3">해당 게시글이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>	
                </table>
                <div class="page-wrap">
                    <ul class="page">
                       <c:forEach var="i" begin="0" end="${(noticeCount - 1) / 10 }"><li>
				<a href="notice?paging=${i+1 }&noticeOption=${param.noticeOption }&noticeSearch=${param.noticeSearch }">${i+1 }</a></li>
			</c:forEach>
                    </ul>
                </div>
            </div>
            <!-- 공지사항 내용 [e] -->
            
            <!-- 검색 [s] -->
            <div class="con-search-wrap">
                <div class="con-search">
                    <form action="notice">
                        <div class="select-wrap">
                            <select name="noticeOption" id="noticeOption">
                                <option value="${null }">검색</option>
                                <option value="1"<c:if test="${param.noticeOption == '1' }">selected</c:if>>제목</option>
                                <option value="2"<c:if test="${param.noticeOption == '2' }">selected</c:if>>내용</option>
                                <option value="3"<c:if test="${param.noticeOption == '3' }">selected</c:if>>제목 + 내용</option>
                            </select>
                        </div>
                        <input type="text" name="noticeSearch" value="${param.noticeSearch }" placeholder="검색 단어">
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