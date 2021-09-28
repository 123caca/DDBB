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
	
	<div class="container banner">
        <h1>슬라이드 배너</h1>
        
        <div class="table-wrap">
 	       <div class="con-top btn2">
 	           <p>슬라이드 배너 ( <span><fmt:formatNumber value="${bannerCount }" /></span> )개</p>
            </div>
            	<form action="banner_delete" method="post" onsubmit="return selectChk()">
 		 	    	<div class="btn-wrap btn2">
	             		<input type="button" class="btn small h_small" value="추가" onclick="location.href='banner_add'">
    	       			<input type="submit" class="btn small h_small" value="삭제">
    	       		</div>
					<table>
      			      	<tr>
       			     		<th><input type="checkbox" name="allCheck" id="allCheck"></th>
            		   	    <th>제목</th>
 		              	    <th>노출순서</th>
						</tr>
            		    <c:choose>
        		        	<%-- 슬라이드 배너가 있는 경우 --%>
                     <c:when test="${fn:length(bannerList) !=0 }">
                     <c:forEach var="list" items="${bannerList }">
                               <tr>
                                   <td><input type="checkbox" class="chBox" name="chBox" id="${list.mainBannerNum }" value="${list.mainBannerNum }"></td>
                                <td> <a href="banner_update?mainBannerNum=${list.mainBannerNum }">${list.mainBannerTitle }</a>  </td>
                              <td>${list.mainBannerSort }</td>
                             </tr>
                         </c:forEach>
                         </c:when>
          			      	<%-- 슬라이드 배너가 있는 경우 --%>
       			         	<c:otherwise>
                				<tr>
               			 			<td colspan="4">현재 등록된 슬라이드 배너가 없습니다.</td>
                				</tr>
                			</c:otherwise>
               			 </c:choose>
           			 </table>
            	</form>
       		</div>
       	</div>
</body>
</html>