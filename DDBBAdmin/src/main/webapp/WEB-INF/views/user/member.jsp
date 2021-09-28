<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵 관리자 페이지</title>
<script type="text/javascript">
	
<%-- 정렬  --%>
	function userSort() {
		var sort = document.getElementById("sort").value;
		location.href = "member?sort="
				+ sort
				+ "&paging=${param.paging }&search=${param.search }&searchContent=${param.searchContent}";
	}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

	<div class="container user">
		<h1>사용자 회원 정보</h1>
		<div class="table-wrap">
			<div class="con-top">
				<div class="select-wrap sort">
				<%-- 정렬  --%>
					<select id="sort" onChange="userSort()">
						<option value=${null }>정렬순서</option>
						<option value="userName"
							<c:if test="${param.sort == 'userName'}">selected</c:if>>이름</option>
						<option value="userId"
							<c:if test="${param.sort == 'userId'}">selected</c:if>>아이디</option>
					</select>
				</div>
				<p>
					회원 수 (<span>${userListTotal }</span>)명
				</p>
				<%-- 검색  --%>
				<form action="member">
					<div class="select-wrap">
						<select name="search" id="search">
							<option value=${null }>검색</option>
							<option value="userName"
								<c:if test="${param.search == 'userName'}">selected</c:if>>이름</option>
							<option value="userId"
								<c:if test="${param.search == 'userId'}">selected</c:if>>아이디</option>
						</select>
					</div>
					<div class="search">
						<input type="text" class="input small" name="searchContent"
							value="${param.searchContent}"> <img
							src="resources/images/header/search.png"> <input
							type="submit" class="cursor" value="검색">
					</div>
				</form>
			</div>
			<table>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>연락처</th>
				</tr>
				<%-- 사용자 리스트 출력  --%>
				<c:choose>
					<c:when test="${fn:length(userList) != 0 }">
						<c:forEach items="${userList }" var="list">
							<tr>
								<td><a href="member_con?userId=${list.getUserId()}">${list.getUserId() }</a></td>
								<td><a href="member_con?userId=${list.getUserId()}">${list.getUserName() }</a></td>
								<td>${list.getUserPhone() }</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="3">검색 결과가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		<%-- 페이징  --%>
		<div class="paging-wrap">
			<span>-</span>
			<c:forEach var="i" begin="0" end="${(userListTotal-1) / 10 }">
				<a href="member?paging=${i+1 }&search=${param.search }&sort=${param.sort}&searchContent=${param.searchContent}">${i+1 }</a>
			</c:forEach>
			<span>-</span>
		</div>
	</div>
</body>
</html>