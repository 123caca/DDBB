<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	    function proSort(){
	    	var sortWord = document.getElementById("sort").value;
			location.href="product?proSort="+sortWord+"&paging=${param.paging }&proCategory=${param.proCategory }&proSearch=${param.proSearch}";
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

	<div class="container product list">
    	<h1>상품 목록</h1>
        
        <%-- 상품 리스트 출력 --%>
        <div class="table-wrap">
	    	<div class="con-top btn2">
	        	<div class="select-wrap sort">
	                <select name="sort" id="sort" onChange="proSort()">
	                    <option value="${null }">정렬순서</option>
	                    <option value="1" <c:if test="${param.proSort == '1'}">selected</c:if>>판매량 순</option>
	                    <option value="2" <c:if test="${param.proSort == '2'}">selected</c:if>>가나다 순</option>
	                    <option value="3" <c:if test="${param.proSort == '3'}">selected</c:if>>낮은 가격순</option>
	                    <option value="4" <c:if test="${param.proSort == '4'}">selected</c:if>>높은 가격순</option>
	                </select>
	            </div>
	            <p>모든 상품 수 ( <span>${productCount }</span> ) 개</p>
				<%-- 검색 [s] --%>
	            <form action="product">
	                <div class="select-wrap">
	                    <select name="proCategory" id="proCategory">
	                    	<option value="${null }">검색</option>
	                        <option value="proName" <c:if test="${param.proCategory == 'proName'}">selected</c:if>>제품명</option>
	                        <option value="proPrice" <c:if test="${param.proCategory == 'proPrice'}">selected</c:if>>가격</option>
	                        <option value="proCategory" <c:if test="${param.proCategory == 'proCategory'}">selected</c:if>>카테고리</option>
	                    </select>
	                </div>
	                <div class="search">
	                    <input type="text" class="input small" name="proSearch" value="${param.proSearch }">
	                    <img src="resources/images/header/search.png">
	                    <input type="submit" class="cursor" value="검색">
	                </div>
	            </form>
				<%-- 검색 [e] --%>
	        </div>
			
			<%-- 삭제 [s] --%>
        	<form action="product_delete" method="POST" onsubmit="return selectChk()">
	            <div class="btn-wrap">
	                <input type="button" class="btn small h_small cursor" value="추가" onclick="location.href='product_add'">
	                <input type="submit" class="btn small h_small cursor" value="삭제">
	            </div>
	            <table>
	                <tr>
	                    <th><input type="checkbox" name="allCheck" id="allCheck"></th>
	                    <th>카테고리</th>
	                    <th>제품명</th>
	                    <th>가격</th>
	                    <th>판매량</th>
	               	</tr>
	               	<c:choose>
	               		<%-- 검색 결과가 있는 경우 --%>
	              		<c:when test="${fn:length(productList) != 0 }">
							<%-- 리스트 출력 [s] --%>
			                <c:forEach items="${productList }" var="list">
			                <tr>
			                    <td><input type="checkbox" name="chBox" class="chBox" id="${list.proName }" value="${list.proName }"></td>
			                    <td>${list.proCategory }</td>
			                    <td>
			                        <a href="product_update?proName=${list.proName }">${list.proName }</a>
			                    </td>
			                    <td>${list.proPrice } 원</td>
			                    <td>${list.proSales }</td>
			                </tr>
			                </c:forEach>
							<%-- 리스트 출력 [e] --%>
	               		</c:when>
	                	<%-- 검색 결과가 없는 경우 --%>
	                   	<c:otherwise>
							<tr>
								<td colspan="5">현재 등록된 상품이 없습니다.</td>
							</tr>
	                   	</c:otherwise>
	                </c:choose>
	            </table>
            </form>
			<%-- 삭제 [e] --%>
        </div>
        
		<div class="paging-wrap">
			<span class="prev">-</span>
				<c:forEach var="i" begin="0" end="${(productCount - 1) / 10 }">
					<a href="product?paging=${i+1 }&proSort=${param.proSort}&proCategory=${param.proCategory }&proSearch=${param.proSearch }">${i+1 }</a>
				</c:forEach>
			<span class="next">-</span>
		</div>
    </div>
    
</body>
</html>