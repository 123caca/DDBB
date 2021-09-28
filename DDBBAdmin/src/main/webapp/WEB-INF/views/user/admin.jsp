<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵 관리자 페이지</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/default.js"></script>
<script type="text/javascript">
	<%-- 정렬  --%>
	function adminUserSort() {
		var sort = document.getElementById("sort").value;
		location.href = "admin?sort="
				+ sort
				+ "&paging=${param.paging }&search=${param.search }&searchContent=${param.searchContent}";
	}
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

	<div class="container user admin_list">
		<h1>직원 목록</h1>
		<div class="table-wrap">
			<div class="con-top btn2">
				<div class="select-wrap sort">
				<%-- 관리자 정렬  --%>
					<select id="sort" onChange="adminUserSort()">
						<option value=${null }>정렬순서</option>
						<option value="adminUserNum"
							<c:if test="${param.sort == 'adminUserNum'}">selected</c:if>>사번</option>
						<option value="adminUserName"
							<c:if test="${param.sort == 'adminUserName'}">selected</c:if>>이름</option>
						<option value="adminUserId"
							<c:if test="${param.sort == 'adminUserId'}">selected</c:if>>아이디</option>
						<option value="adminUserBanner"
							<c:if test="${param.sort == 'adminUserBanner'}">selected</c:if>>상품등록</option>
						<option value="adminUserCustomer"
							<c:if test="${param.sort == 'adminUserCustomer'}">selected</c:if>>문의답변</option>
						<option value="adminUserProduct"
							<c:if test="${param.sort == 'adminUserProduct'}">selected</c:if>>이벤트</option>
						<option value="adminUserOrder"
							<c:if test="${param.sort == 'adminUserOrder'}">selected</c:if>>주문/배송</option>
					</select>
				</div>
				<p>
					직원 수 ( <span>${adminUserListTotal }</span> ) 명
				</p>
				<%-- 관리자 검색  --%>
				<form action="admin">
					<div class="select-wrap">
						<select name="search" id="search">
							<option value=${null }>검색</option>
							<option value="adminUserNum"
								<c:if test="${param.search == 'adminUserNum'}">selected</c:if>>사번</option>
							<option value="adminUserName"
								<c:if test="${param.search == 'adminUserName'}">selected</c:if>>이름</option>
							<option value="adminUserId"
								<c:if test="${param.search == 'adminUserId'}">selected</c:if>>아이디</option>
						</select>
					</div>
					<div class="search">
						<input type="text" class="input small" name="searchContent" value="${param.searchContent}"> 
						<img src="resources/images/header/search.png"> 
						<input type="submit" class="cursor" value="검색">
					</div>
				</form>
			</div>
			<%-- 관리자 삭제  --%>
			<form action="admin_delete" onsubmit="return selectChk()">
				<div class="btn-wrap">
					<input type="button" onclick="location.href='join'" class="btn small h_small" value="추가"> 
					<input type="submit" class="btn small h_small" value="삭제">
				</div>
				<table>
					<tr>
						<th><input type="checkbox" name="" id="allCheck"></th>
						<th>사번</th>
						<th>아이디</th>
						<th>이름</th>
						<th>비밀번호</th>
						<th>배너</th>
						<th>고객센터</th>
						<th>상품등록</th>
						<th>주문/배송</th>
					</tr>
					<%-- 리스트 출력  --%>
					<c:choose>
						<c:when test="${fn:length(adminUserList) != 0 }">
							<c:forEach items="${adminUserList }" var="list">
								<tr>
									<td><input type="checkbox" name="chBox" class="chBox" value="${list.getAdminUserId() }"></td>
									<td>${list.getAdminUserNum() }</td>
									<td><a href="admin_update?adminuserId=${list.getAdminUserId()}">${list.getAdminUserId() }</a></td>
									<td><a href="admin_update?adminuserId=${list.getAdminUserId()}">${list.getAdminUserName() }</a></td>
									<td>${list.getAdminUserPwd() }</td>
									<td>${list.getAdminUserBanner()==1?'O':'X' }</td>
									<td>${list.getAdminUserCustomer()==1?'O':'X' }</td>
									<td>${list.getAdminUserProduct()==1?'O':'X' }</td>
									<td>${list.getAdminUserOrder()==1?'O':'X' }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="9">검색 결과가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</form>
		</div>
		<%-- 페이징  --%>
		<div class="paging-wrap">
			<span>-</span>
			<c:forEach var="i" begin="0" end="${(adminUserListTotal-1) / 10 }">
				<a href="admin?paging=${i+1 }&search=${param.search }&sort=${param.sort}&searchContent=${param.searchContent}">${i+1 }</a>
			</c:forEach>
			<span>-</span>
		</div>
	</div>
</body>
</html>