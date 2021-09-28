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

    <div class="content-wrap">
        <div class="content-title">
            <h2>상품평 수정</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
                    <span>마이페이지</span> > <span>상품평 수정</span>
                </p>
            </div>
        </div>
 
        <!-- list [s] -->
        <div class="rewrite">
            <form action="my_review_update_fn" method="post" enctype="multipart/form-data">
            	<input type="hidden" name="proReviewOrderNum" value=${param.proReviewOrderNum } />
            	<input type="hidden" name="proReviewProName" value=${param.proReviewProName } />
                <table>
                    <tr>
                        <td>별점</td>
                        <td>
                            <label><input type="radio" name="proReviewScore" value="1" <c:if test="${productReviewModify.proReviewScore == '1'}">checked</c:if>><img src="resources/images/mypage/star_rate_01.png" alt="1점"></label>
                            <label><input type="radio" name="proReviewScore" value="2" <c:if test="${productReviewModify.proReviewScore == '2'}">checked</c:if>><img src="resources/images/mypage/star_rate_02.png" alt="2점"></label>
                            <label><input type="radio" name="proReviewScore" value="3" <c:if test="${productReviewModify.proReviewScore == '3'}">checked</c:if>><img src="resources/images/mypage/star_rate_03.png" alt="3점"></label>
                            <label><input type="radio" name="proReviewScore" value="4" <c:if test="${productReviewModify.proReviewScore == '4'}">checked</c:if>><img src="resources/images/mypage/star_rate_04.png" alt="4점"></label>
                            <label><input type="radio" name="proReviewScore" value="5" <c:if test="${productReviewModify.proReviewScore == '5'}">checked</c:if>><img src="resources/images/mypage/star_rate_05.png" alt="5점"></label>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align : top">내용</td>
                        <td><textarea class="review" name="proReviewContent">${productReviewModify.proReviewContent }</textarea></td>
                    </tr>
                    <tr>
                        <td>첨부파일</td>
                        <td><input type="file" name="proReviewImg"></td>
                        <p class="img-notice">※ 파일 확장자는 png, jpg, gif만 가능합니다.</p>
                    </tr>
                </table>
                <button type="submit" class="btn large">상품평 수정</button>
            </form>
        </div>
        <!-- list [e] -->
    </div>
    
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
    
</body>
</html>