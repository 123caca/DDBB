<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	
    <div class="content-wrap customer">

        <div class="content-title">
            <h2>상품 문의</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
					<span>메뉴</span> > <span>상품</span> > <span>상품 QnA</span>
                </p>
            </div>
        </div>
        
        <div class="content">
            <!-- 문의하기 [s] -->
            <div class="question answer reply">
                <div class="question-con">
                    <table class="content-answer">
                        <tr>
                            <th>작성자</th>
                            <td>
                                <p>${productQnaDetailList.proQnaUserName }</p>
                            </td>
                            <th>작성일</th>
                            <td>
                                <p>${productQnaDetailList.proQnaDate }</p>
                            </td>
                        </tr>
                        <tr>
                            <th>제 목</th>
                            <td colspan="3">
                                <p>${productQnaDetailList.proQnaTitle }</p>
                            </td>
                        </tr>
                        <tr>
                            <th>내 용</th>
                            <td colspan="3" class="min-height">
                                <p>${productQnaDetailList.proQnaContent }</p>
                            </td>
                        </tr>
                        <c:choose>
                        	<c:when test="${productQnaDetailList.proQnaAnswer != null }">
		                        <tr class="active">
		                            <th>답 변</th>
		                            <td colspan="3" class="min-height">
		                                <p>${productQnaDetailList.proQnaAnswer }</p>
		                            </td>
		                        </tr>
                        	</c:when>
                        </c:choose>
                    </table>
                </div>
                <div class="question-btn">
               		<c:if test="${user.getUserId().equals(productQnaDetailList.proQnaUserId) && productQnaDetailList.proQnaAnswer == null }">
	                    <a href="#" class="btn large" onclick="deleteCon()">삭 제</a>
	                    <a href="my_product_qna_update?proQnaNum=${productQnaDetailList.proQnaNum }" class="btn large">수 정</a>
               		</c:if>
					<input type="button" onclick="history.back()" class="btn large curser" value="목 록">
                </div>
            </div>
            <!-- 문의하기 [e] -->
        </div>
    </div>
	
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
	
	<script type="text/javascript">
	    function deleteCon(){
	    	var proQnaNum = '${productQnaDetailList.proQnaNum }';
	    	var proQnaProName = '${param.proQnaProName }'
	    	var result = confirm("정말 문의글을 삭제하시겠습니까?");
	    	
	    	if(result) 
				location.href="my_product_qna_delete?proQnaNum="+proQnaNum+"&proQnaProName="+proQnaProName;
	    }
	</script>
	
</body>
</html>