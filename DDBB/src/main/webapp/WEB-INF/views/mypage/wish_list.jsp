<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/default.js"></script>

<script type="text/javascript">
<%-- 삭제 확인  --%>
function delete_selectChk() {
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
function wish_list_alldeleteF(){
	var array=document.getElementsByName("chBox");
	
	if(array.length==0){
		alert("삭제 할 항목이 없습니다.");
		return false;
	} else {
		if(confirm("삭제하시겠습니까?")){
			location.href='wish_list_alldelete';
		}
	}
}
</script>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	
	<div class="content-wrap wish">
		<div class="content-title">
			<h2>찜 목록</h2>
			<div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
				<p>
					<span>마이페이지</span> > <span>찜 목록</span>
				</p>
			</div>
		</div>
		<div class="product-wrap">
			<div class="board-wrap wish-board">
			<form action="wish_list_delete_chkbox" onsubmit="return delete_selectChk()">
				<table>
					<tr>
               		    <th><input type="checkbox" name="allCheck" id="allCheck"></th>
						<th>이미지</th>
						<th>정보</th>
						<th>판매가</th>
						<th>삭제여부</th>
					</tr>
					<c:choose>
						<c:when test="${fn:length(wishList) != 0 }">
		                    <c:forEach var="list" items="${wishList }">
			                    <tr>
			                        <td><input type="checkbox" name="chBox" class="chBox" value="${list.proName }"></td>
			                        <td><a href="product_con?proName=${list.proName }"><img alt="빵이름" src="${list.proImg }"></a></td>
			                        <td><a href="product_con?proName=${list.proName }">${list.proName }</a></td>
			                        <td><span>${list.proPrice }</span> 원</td>
			                        <td> 
			                            <button type="button" class="btn small" onclick="location.href='wish_list_delete?proName=${list.proName}'">삭 제</button>                
			                        </td>
			                    </tr>      
	                 	   </c:forEach>    
						</c:when>
						<c:otherwise>
                   		<tr>
                   			<td colspan="5">찜목록에 목록이 없습니다.</td>
                   		</tr>
						</c:otherwise>
					</c:choose>
				</table>
				<div class="wish-btn">
					<input type="button" onclick="wish_list_alldeleteF()" class="btn large cursor" value="전체상품삭제">
					<input type="submit" class="btn large cursor" value="선택상품삭제">
				</div>
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>