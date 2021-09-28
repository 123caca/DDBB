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
				<p> <span>고객센터</span> > <span>1:1 문의</span> </p>
			</div>
		</div>
		
		<div class="list-layout">
			<!-- 1:1문의 탭메뉴 [s] -->
			<div class="tab-menu">
				<ul>
					<li><a href="faq">자주하는 질문</a></li>
					<li class="active"><a href="question">1:1 문의</a></li>
					<li><a href="notice">공지사항</a></li>
					<li><a href="event">이벤트</a></li>
				</ul>
				<div class="tab-title">
					<h3>1:1 문의</h3>
				</div>
			</div>
			<!-- 1:1문의 탭메뉴 [e] -->
		
			<!-- 1:1문의 내용 [s] -->
			<div class="board-wrap">
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>답변상태</th>
					</tr>
					<c:choose>
					<%-- 검색 결과가 있는 경우 --%>
						<c:when test="${fn:length(questionAllList) !=0 }">
							<c:forEach var="list" items="${questionAllList }">
								<tr>
									<td>${list.cusQuestionNum }</td>
									<td><a href="question_con?cusQuestionNum=${list.cusQuestionNum}"> ${list.cusQuestionTitle } </a></td>
									<td>${list.cusQuestionUserName }</td>
									<td>${list.cusQuestionDate }</td>
									<td>
									<c:choose>
										<c:when test="${list.cusQuestionAnswer == null }"> <p class="btn small red">답변대기중</p> </c:when>
										<c:otherwise> <p class="btn small">답변완료</p> </c:otherwise>
									</c:choose>
									</td>
								</tr>
							</c:forEach>
						</c:when>
					<%-- 검색 결과가 없는 경우 --%>
						<c:otherwise>
							<tr>
								<td colspan="5">해당 게시글이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>					
				</table>
				<!-- 1:1문의 내용 [e] -->
				
				<div class="page-wrap">
					<ul class="page">
						<li>
							<c:forEach var="i" begin="0" end="${(questionCount - 1) / 10 }">
								<a href="question?paging=${i+1 }&questionOption=${param.questionOption }&questionSearch=${param.questionSearch }">${i+1 }</a>
							</c:forEach>
						</li>
					</ul>
					<div class="right">
					<c:if test="${ user!=null }">
						<a href="question_write" class="btn large">문의하기</a>
					</c:if>
					</div>
				</div>
			</div>	

			<!-- 검색 [s] -->
			<div class="con-search-wrap">
				<div class="con-search">
					<form action="question">
						<div class="select-wrap">
							<select name="questionOption" id="questionOption" >
								<option value="${null }">검색</option>
								<option value="1" <c:if test="${param.questionOption == '1'}">selected</c:if>>제목</option>
								<option value="2" <c:if test="${param.questionOption == '2'}">selected</c:if>>내용</option>
								<option value="3" <c:if test="${param.questionOption == '3'}">selected</c:if>>제목 + 내용</option>
							</select>
						</div>
							<input type="text" name="questionSearch" value="${param.questionSearch }" placeholder="검색 단어"> 
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