<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	
	<div class="container customer faq">
		<h1>자주하는 질문</h1>
		
		<div class="table-wrap">
			<div class="con-top btn2">
				<p> 게시글 수 ( <span> <fmt:formatNumber value="${faqCount }"/></span> ) 개 </p>
				<%-- 검색 [s] --%>
				<form action="faq" method="POST">
					<div class="select-wrap">
						<select name="faqOption" id="faqOption">
							<option value="${null }">검색</option>
							<option value="1" <c:if test="${param.faqOption == '1' }">selected</c:if>>제목</option>
							<option value="2" <c:if test="${param.faqOption == '2' }">selected</c:if>>내용</option>
							<option value="3" <c:if test="${param.faqOption == '3' }">selected</c:if>>제목 + 내용</option>
						</select>
					</div>
					<div class="search">
						<input type="text" class="input small" name="faqSearch" value="${param.faqSearch }" placeholder="검색단어"> 
						<img src="resources/images/header/search.png"> 
						<input type="submit" class="cursor" value="검색">
					</div>
				</form>
				<%-- 검색 [e] --%>
			</div>
			
			<%-- 삭제 [s] --%>
			<form action="faq_delete" method="POST" onsubmit="return selectChk()">
				<div class="btn-wrap">
					<input type="button" class="btn small h_small" value="추가" onclick="location.href='faq_add'">
					<input type="submit" class="btn small h_small" value="삭제" >
				</div>
				<table>
					<tr>
						<th><input type="checkbox" name="allCheck" id="allCheck"></th>
						<th>제목</th>
					</tr>
					<c:choose>
						<%-- 검색 결과가 있는 경우 --%>
						<c:when test="${fn:length(faqAllList) !=0 }">
							<%-- 리스트 출력 [s] --%>
							<c:forEach var="list" items="${faqAllList}">
								<tr>
									<td><input type="checkbox" name="chBox" class="chBox" id="${list.cusFaqNum }" value="${list.cusFaqNum }"> </td>
									<td><a href="faq_update?cusFaqNum=${list.cusFaqNum }">${list.cusFaqTitle }</a></td>
								</tr>
							</c:forEach>
							<%-- 리스트 출력 [e] --%>
						</c:when>
						<%-- 검색 결과가 없는 경우 --%>
						<c:otherwise>
							<tr>
								<td colspan="2">현재 등록된 자주하는질문이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</form>
			<%-- 삭제 [e] --%>
		</div>
	</div>
</body>
</html>