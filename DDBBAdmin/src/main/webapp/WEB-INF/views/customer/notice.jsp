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
<title>뛰뛰빵빵 관리자 페이지</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/default.js"></script>
    <script type="text/javascript">
	<%-- 삭제 확인  --%>
	function selectChk() {
		var array=document.getElementsByName("chBox");
		for(var i=0; i<array.length;i++){
			if(array[i].checked){
				if(confirm("삭제하시겠습니까?")){
					return true;
				}
				return false;
			}
		}
		alert("삭제 할 항목이 없습니다.");
		return false;
	}
    </script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

	<div class="container customer notice">
		<h1>공지사항</h1>
		
		<div class="table-wrap">
			<div class="con-top btn2">
				<p> 게시글 수 ( <span><fmt:formatNumber value="${noticeCount }" /></span> ) 개 </p>
				<%-- 검색 [s] --%>
				<form action="notice" method="POST">
					<div class="select-wrap">
						<select name="noticeOption" id="noticeOption">
							<option value="${null }">검색</option>
							<option value="1" <c:if test="${param.noticeOption == '1' }">selected</c:if>>제목</option>
							<option value="2" <c:if test="${param.noticeOption == '2' }">selected</c:if>>내용</option>
							<option value="3" <c:if test="${param.noticeOption == '3' }">selected</c:if>>제목 + 내용</option>
						</select>
					</div>
					<div class="search">
						<input type="text" class="input small" name="noticeSearch" value="${param.noticeSearch }" placeholder="검색단어"> 
						<img src="resources/images/header/search.png"> 
						<input type="submit" class="cursor" value="검색">
					</div>
				</form>
				<%-- 검색 [e] --%>
			</div>
			
			<%-- 삭제 [s] --%>
			<form action="notice_delete" method="POST" onsubmit="return selectChk()">
				<div class="btn-wrap">
					<input type="button" class="btn small h_small" value="추가" onclick="location.href='notice_add'">
					<input type="submit" class="btn small h_small" value="삭제">
				</div>
				<table>
					<tr>
						<th><input type="checkbox" name="allCheck" id="allCheck"></th>
						<th>글번호</th>
						<th>제목</th>
						<th>작성일</th>
					</tr>
					<c:choose>
						<%-- 검색 결과가 있는 경우 --%>
						<c:when test="${fn:length(noticeAllList) !=0 }">
							<%-- 리스트 출력 [s] --%>
							<c:forEach var="list" items="${noticeAllList }">
								<tr>
									<td><input type="checkbox" name="chBox" class="chBox" id="${list.cusNoticeNum }" value="${list.cusNoticeNum }"></td>
									<td>${list.cusNoticeNum }</td>
									<td><a href="notice_update?cusNoticeNum=${list.cusNoticeNum}">${list.cusNoticeTitle }</a></td>
									<td>${list.cusNoticeDate }</td>
								</tr>
							</c:forEach>
							<%-- 리스트 출력 [e] --%>
						</c:when>
						<%-- 검색 결과가 없는 경우 --%>
						<c:otherwise>
							<tr>
								<td colspan="6">현재 등록된 공지사항이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</form>
			<%-- 삭제 [e] --%>
		</div>
		<div class="paging-wrap">
			<span class="prev">-</span>
			<c:forEach var="i" begin="0" end="${(noticeCount - 1) / 10 }">
				<a href="notice?paging=${i+1 }&noticeOption=${param.noticeOption }&noticeSearch=${param.noticeSearch }">${i+1 }</a>
			</c:forEach>
			<span class="next">-</span>
		</div>
	</div>
</body>
</html>