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
            <h2>상품평 쓰기</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
                    <span>마이페이지</span> > <span>상품평 쓰기</span>
                </p>
            </div>
        </div>
 
        <!-- list [s] -->
        <div class="rewrite">
            <form action="review_write_fn" method="post" enctype="multipart/form-data">
            	<input type="hidden" name="proReviewOrderNum" value=${param.proReviewOrderNum } />
            	<input type="hidden" name="proReviewProName" value=${param.proReviewProName } />
                <table>
                    <tr>
                        <td>별점</td>
                        <td>
                            <label><input type="radio" name="proReviewScore" value="1"><img src="resources/images/mypage/star_rate_01.png" alt="1점"></label>
                            <label><input type="radio" name="proReviewScore" value="2"><img src="resources/images/mypage/star_rate_02.png" alt="2점"></label>
                            <label><input type="radio" name="proReviewScore" value="3"><img src="resources/images/mypage/star_rate_03.png" alt="3점"></label>
                            <label><input type="radio" name="proReviewScore" value="4"><img src="resources/images/mypage/star_rate_04.png" alt="4점"></label>
                            <label><input type="radio" name="proReviewScore" value="5"><img src="resources/images/mypage/star_rate_05.png" alt="5점"></label>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align : top">내용</td>
                        <td><textarea class="review" name="proReviewContent"></textarea></td>
                    </tr>
                    <tr>
                        <td>첨부파일</td>
                        <td><input type="file" name="proReviewImg"></td>
                        <p class="img-notice">※ 파일 확장자는 png, jpg, gif만 가능합니다.</p>
                    </tr>
                </table>
                <button type="submit" class="btn large">저 장</button>
                <input type="button" onclick="history.back()" class="btn large curser" value="취 소">
                
            </form>
        </div>
        <!-- list [e] -->
    </div>
    
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
    
</body>
</html>