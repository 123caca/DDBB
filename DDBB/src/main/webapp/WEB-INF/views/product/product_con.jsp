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
       // 정렬
       function proSort(){
          var sortWord = document.getElementById("sort").value;
         location.href="product_con?&paging=${param.paging }&pagingReview=${param.pagingReview}&proName=${param.proName}&proSort="+sortWord+"#tab02";
       }
       // 상품 리뷰 상세 정보
        $(function(){
           $(".review_toggle").click(function(){
              $(".review_toggle").css('-webkit-line-clamp','3');
              $(this).css('-webkit-line-clamp','initial');
           });
        });
    </script>
</head>
<body>
   
   <jsp:include page="/WEB-INF/views/layout/header.jsp" />
   
   <div class="content-wrap product">
        <div class="content-title">
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
               <span>상품</span> > <span>${param.proName }</span>
                </p>
            </div>
        </div>

      <div class="list-layout">
         <!-- 제품상세 이미지 [s] -->
         <div class="product-title">
            <div class="product-detail-img">
               <img src="${productDetailList.proImg }" alt="큰 이미지">
            </div>
            <form action="buy" style="float: right;">
               <div class="product-detail-con">
                  <h3>${productDetailList.proName }</h3>
                  <div class="product-detail-txt">
                     <p>가격 : <span>${productDetailList.proPrice }</span>원</p>
                     <p>수량 : <span id="selectCount">수량</span></p>
                     <div class="product-num">
                        <p class="countDown"><img alt="down" src="resources/images/common/arrow.png"></p>
                        <p class="countUp"><img alt="up" src="resources/images/common/arrow.png"></p>
                     </div>
                     <p class="product-total-cost">총 금액 : <span id="totalCost">금액</span>원</p>
                     <input type="hidden" name="orderSimSelectCost" id="orderSimSelectCost" value="${productDetailList.proPrice  }"/>
                     <input type="hidden" name="size" id="size" value="1"/>
                     <input type="hidden" name="proName" id="proName" value="${param.proName }"/>
                     <div class="product-detail-btn">
                        <button type="button" class="btn large wish_list"><img alt="찜하기" src="resources/images/common/wish_list.jpg"> </button>
                        <button type="button" class="btn large cart"><img alt="장바구니" src="resources/images/common/cart.jpg"/> </button>
                        <button type="submit" class="btn large">구매하기</button>
                     </div>
                  </div>
               </div>
            </form>
         </div>
         <!-- 제품상세 이미지 [e] -->

         <!-- 제품상세 탭메뉴 -->
         <div class="tab-menu sel" id="tab01">
            <ul>
               <li class="active"><a href="#tab01">제품상세</a></li>
               <li><a href="#tab02">상품평</a></li>
               <li><a href="#tab03">상품 Q&A</a></li>
               <li><a href="#tab04">배송안내</a></li>
            </ul>
            <div class="tab-title"></div>
         </div>

         <!-- 제품상세 내용 [s] -->
         <div class="product-detail">
            <img alt="상세내용" src="${productDetailList.proContentImg }">
         </div>
         <!-- 제품상세 내용 [e] -->

         <!-- 상품평 탭메뉴 -->
         <div class="tab-menu sel" id="tab02">
            <ul>
               <li><a href="#tab01">제품상세</a></li>
               <li class="active"><a href="#tab02">상품평</a></li>
               <li><a href="#tab03">상품 Q&A</a></li>
               <li><a href="#tab04">배송안내</a></li>
            </ul>
            <div class="tab-title"></div>
         </div>

         <!-- 상품평 내용 [s] -->
         <div class="board-wrap product-review">
            <div class="select-wrap">
               상품평 ( <span>${productReviewCount }</span> ) 건 
               <select name="proSort" id="sort" class="sort-review" onChange="proSort()">
                  <option value="${null }">정렬순서</option>
                  <option value="1" <c:if test="${param.proSort == '1'}">selected</c:if>>별점 높은순</option>
                  <option value="2" <c:if test="${param.proSort == '2'}">selected</c:if>>별점 낮은순</option>
                  <option value="3" <c:if test="${param.proSort == '3'}">selected</c:if>>최신순</option>
               </select>
            </div>
            <table>
               <tr>
                  <th>별점</th>
                  <th>이미지</th>
                  <th>내용</th>
                  <th>작성자</th>
                  <th>작성일</th>
               </tr>
                   <c:choose>
                      <%-- 상품리뷰가 있는 경우 --%>
                        <c:when test="${fn:length(productReviewList) != 0 }">
                     <c:forEach items="${productReviewList }" var="list">
                     <tr>
                        <c:choose>
                           <c:when test="${list.proReviewScore == 1 }"><td><span>★</span></td></c:when>
                           <c:when test="${list.proReviewScore == 2 }"><td><span>★★</span></td></c:when>
                           <c:when test="${list.proReviewScore == 3 }"><td><span>★★★</span></td></c:when>
                           <c:when test="${list.proReviewScore == 4 }"><td><span>★★★★</span></td></c:when>
                           <c:when test="${list.proReviewScore == 5 }"><td><span>★★★★★</span></td></c:when>
                        </c:choose>
                        <td><img alt="리뷰이미지" src="${list.proReviewImg }" /></td>
                        <td><p class="review_toggle">${list.proReviewContent }</p></td>
                        <td>${list.proReviewUserName }</td>
                        <td>${list.proReviewDate }</td>
                     </tr>
                     </c:forEach>
                        </c:when>
                      <%-- 상품리뷰가 없는 경우 --%>
                         <c:otherwise>
                            <tr>
                               <td colspan="5">해당 상품의 리뷰 내역이 없습니다.</td>
                            </tr>
                         </c:otherwise>
                   </c:choose>
            </table>
            <div class="page-wrap">
               <span class="prev">-</span>
                  <c:forEach var="i" begin="0" end="${(productReviewCount - 1) / 5 }">
                     <a href="product_con?paging=${param.paging }&pagingReview=${i+1 }&proName=${param.proName }&proSort=${param.proSort }#tab02">${i+1 }</a>
                  </c:forEach>  
               <span class="next">-</span>
            </div>
         </div>
         <!-- 상품평 내용 [e] -->

         <!-- 상품 Q&A 탭메뉴 -->
         <div class="tab-menu sel" id="tab03">
            <ul>
               <li><a href="#tab01">제품상세</a></li>
               <li><a href="#tab02">상품평</a></li>
               <li class="active"><a href="#tab03">상품 Q&A</a></li>
               <li><a href="#tab04">배송안내</a></li>
            </ul>
            <div class="tab-title"></div>
         </div>

         <!-- 상품 Q&A 내용 [s] -->
         <div class="board-wrap product-qna">
            <div class="select-wrap">
               상품 Q&A ( <span>${productQnaCount }</span> ) 건 
            </div> 
            <table>
               <tr>
                  <th>작성자</th>
                  <th>제목</th>
                  <th>날짜</th>
                  <th>답변상태</th>
               </tr>
                   <c:choose>
                      <%-- 상품 QnA가 있는 경우 --%>
                        <c:when test="${fn:length(productQnaList) != 0 }">
                     <c:forEach items="${productQnaList }" var="list">
                     <tr>
                        <td>${list.proQnaUserName }</td>
                        <td><a href="product_qna_con?proQnaNum=${list.proQnaNum }&proQnaProName=${productDetailList.proName }"> ${list.proQnaTitle }</a></td>
                        <td>${list.proQnaDate }</td>
                        <td>
                        <c:choose>
                           <c:when test="${list.proQnaAnswer == null }">
                              <p class="btn small red">답변대기중</p>
                           </c:when>
                           <c:otherwise>
                              <p class="btn small">답변완료</p>
                           </c:otherwise>
                        </c:choose>
                        </td>
                     </tr>
                     </c:forEach>
                        </c:when>
                      <%-- 상품 QnA가 없는 경우 --%>
                         <c:otherwise>
                            <tr>
                               <td colspan="5">해당 상품의 질문 내역이 없습니다.</td>
                            </tr>
                         </c:otherwise>
                   </c:choose>
            </table>
            <div class="page-wrap">
               <span class="prev">-</span>
                  <c:forEach var="i" begin="0" end="${(productQnaCount - 1) / 5 }">
                     <a href="product_con?paging=${i+1 }&pagingReview=${param.pagingReview }&proName=${param.proName }&proSort=${param.proSort }#tab03">${i+1 }</a>
                  </c:forEach>  
               <span class="next">-</span>
               <div class="right">
                  <p class="btn large">
                     <a href="product_qna_write?proQnaProName=${productDetailList.proName }">상품문의</a>
                  </p>
               </div>
            </div>
         </div>
         <!-- 상품 Q&A 내용 [e] -->

         <!-- 배송안내 탭메뉴 -->
         <div class="tab-menu sel" id="tab04">
            <ul>
               <li><a href="#tab01">제품상세</a></li>
               <li><a href="#tab02">상품평</a></li>
               <li><a href="#tab03">상품 Q&A</a></li>
               <li class="active"><a href="#tab04">배송안내</a></li>
            </ul>
            <div class="tab-title"></div>
         </div>

         <!-- 배송안내 [s] -->
         <div class="product-detail">
            <img alt="상세내용" src="resources/images/product/temp.png">
         </div>
         <!-- 배송안내 [e] -->
      </div>
   </div>
   
   <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
   
   
   <script type="text/javascript">
      $(function(){
         var selectCount = 1;
          var account = selectCount;
         var price = ${productDetailList.proPrice };
         var totalCost = price * selectCount;
         document.getElementById("selectCount").innerHTML = selectCount;
         document.getElementById("totalCost").innerHTML = totalCost;
      
         $(".countDown").click(function(){
            if (selectCount > 1)
               selectCount--;
            account = selectCount;
            totalCost = price * selectCount;
            document.getElementById("selectCount").innerHTML = selectCount;
            document.getElementById("totalCost").innerHTML = totalCost;
            document.getElementById("orderSimSelectCost").value = totalCost;
         });
         $(".countUp").click(function(){
            selectCount++;
            account = selectCount;
            totalCost = price * selectCount;
            document.getElementById("selectCount").innerHTML = selectCount;
            document.getElementById("totalCost").innerHTML = totalCost;
            document.getElementById("orderSimSelectCost").value = totalCost;
         });

         $(".cart").click(function(){
             var result1 = confirm("장바구니에 해당 상품을 추가하시겠습니까?");
             if (result1) {
                if (${user == null}) {      // 로그인이 안 되어있는 경우
                   alert("로그인이 필요합니다.");
                   location.href="login";
                } else {
                   var result2 = confirm("장바구니로 이동하시겠습니까?");
                  if (result2)
                     location.href="cart_add?proName=${productDetailList.proName}&proPrice="+price+"&proImg=${productDetailList.proImg}&addAccount="+account+"&history=1";
                  else
                     location.href="cart_add?proName=${productDetailList.proName}&proPrice="+price+"&proImg=${productDetailList.proImg}&addAccount="+account+"&history=0";
                }
             }
               
         });

         $(".wish_list").click(function(){
             var result1 = confirm("찜목록에 해당 상품을 추가하시겠습니까?");
             if (result1) {
                if (${user == null}) {      // 로그인이 안 되어있는 경우
                   alert("로그인이 필요합니다.");
                   location.href="login";
                } else {
                   var result2 = confirm("찜목록으로 이동하시겠습니까?");
                  if (result2)
                     location.href="wish_list_add?proName=${productDetailList.proName}&proPrice="+price+"&proImg=${productDetailList.proImg}&history=1";
                  else
                     location.href="wish_list_add?proName=${productDetailList.proName}&proPrice="+price+"&proImg=${productDetailList.proImg}&history=0";
                }
             }
         });
      });

   </script>
   
</body>
</html>