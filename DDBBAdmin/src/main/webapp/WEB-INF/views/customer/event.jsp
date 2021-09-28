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

	<div class="container customer event">
		<h1>이벤트</h1>
		
		<div class="table-wrap">
			<div class="con-top btn2">
				<p> 게시글 수 ( <span><fmt:formatNumber value="${eventCount }" /></span> ) 개</p>
				<%-- 검색 [s] --%>
				<form action="event" method="POST">
					<div class="select-wrap">
						<select name="eventOption" id="eventOption">
							<option value="">검색</option>
							<option value="1" <c:if test="${param.eventOption == '1'}">selected</c:if>>제목</option>
						</select>
					</div>
					<div class="search">
						<input type="text" class="input small" name="eventSearch" value="${param.eventSearch }" placeholder="검색단어"> 
						<img src="resources/images/header/search.png"> 
						<input type="submit" class="cursor" value="검색">
					</div>
				</form>
				<%-- 검색 [e] --%>
			</div>
			
			<%-- 삭제 [s] --%>
			<form action="event_delete" method="POST" onsubmit="return selectChk()">
				<div class="btn-wrap">
					<input type="button" class="btn small h_small" value="추가" onclick="location.href='event_add'">
					<input type="submit" class="btn small h_small" value="삭제">
				</div>
				<table>
					<tr>
						<th><input type="checkbox" name="allCheck" id="allCheck"></th>
						<th>제목</th>
						<th>이벤트 기간</th>
						<th>작성일</th>
					</tr>
					<c:choose>
						<%-- 검색 결과가 있는 경우 --%>
						<c:when test="${fn:length(eventAllList) != 0 }">
							<%-- 리스트 출력 [s] --%>
							<c:forEach items="${eventAllList }" var="list">
								<tr>
									<td><input type="checkbox" name="chBox" class="chBox" id="${list.cuseventnum}" value="${list.cuseventnum}"></td>
									<td><a href="event_update?cuseventnum=${list.cuseventnum}">${list.cusEventTitle }</a></td>
									<td>${list.cusEventStartDate } ~ ${list.cusEventEndDate }</td>
									<td>${list.cusEventDate }</td>
								</tr>
							</c:forEach>
							<%-- 리스트 출력 [e] --%>
						</c:when>
						<%-- 검색 결과가 없는 경우 --%>
						<c:otherwise>
							<tr>
								<td colspan="5">해당하는 이벤트가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</form>
			<%-- 삭제 [e] --%>
		</div>
		<div class="paging-wrap">
			<span class="prev">-</span>
				<c:forEach var="i" begin="0" end="${(eventCount - 1) / 10 }">
					<a href="event?paging=${i+1 }&eventOption=${param.eventOption }&eventSearch=${param.eventSearch }">${i+1 }</a>
				</c:forEach>
			<span class="next">-</span>
		</div>
	</div>
</body>
</html>