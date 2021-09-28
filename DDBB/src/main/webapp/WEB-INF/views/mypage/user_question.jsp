<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

	<div class="content-wrap wish">
		<div class="content-title">
			<h2>나의 질문 및 답변</h2>
			<div class="page-location">
				<img src="resources/images/common/home.jpg" alt="집 아이콘">
				<p>
					<span>마이페이지</span> > <span>나의 질문 및 답변</span>
				</p>
			</div>
		</div>
		
		<div class="list-layout">
			<!-- 1:1문의 내용 [s] -->
			<div class="board-wrap">
			<div class="select-wrap">
				1:1 문의 ( <span>${questionCount }</span> ) 건 
			</div> 
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>답변상태</th>
					</tr>
					<c:choose>
					<%-- 검색 결과가 있는 경우 --%>
						<c:when test="${fn:length(questionAllList) !=0 }">
							<c:forEach var="list" items="${questionAllList }">
								<tr>
									<td>${list.cusQuestionNum }</td>
									<td><a href="my_question_con?cusQuestionNum=${list.cusQuestionNum}"> ${list.cusQuestionTitle } </a></td>
									<td>${list.cusQuestionUserName }</td>
									<td>${list.cusQuestionDate }</td>
									<td>
									<c:choose>
										<c:when test="${list.cusQuestionAnswer == null }"> <p class="btn small red">답변대기중</p> </c:when>
										<c:otherwise> <p class="btn small">답변완료</p> </c:otherwise>
									</c:choose>
									</td>
								</tr>
							</c:forEach>
						</c:when>
					<%-- 검색 결과가 없는 경우 --%>
						<c:otherwise>
							<tr>
								<td colspan="5">해당 게시글이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>					
				</table>
				<!-- 1:1문의 내용 [e] -->
				
				<div class="page-wrap">
					<span class="prev">-</span>
						<ul class="page">
							<li>
								<c:forEach var="i" begin="0" end="${(questionCount - 1) / 5 }">
									<a href="user_question?paging1=${i+1 }">${i+1 }</a>
								</c:forEach>
							</li>
						</ul>
					<span class="prev">-</span>
				</div>
			</div>	
		</div>
		

		<!-- 상품 Q&A 내용 [s] -->
		<div class="board-wrap">
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
							<td><a href="my_product_qna_con?proQnaNum=${list.proQnaNum }&proQnaProName=${productDetailList.proName }"> ${list.proQnaTitle }</a></td>
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
						<a href="user_question?paging2=${i+1 }&pagingReview=${param.pagingReview }&proName=${param.proName }&proSort=${param.proSort }#tab03">${i+1 }</a>
					</c:forEach>  
				<span class="next">-</span>
			</div>
		</div>
		<!-- 상품 Q&A 내용 [e] -->
		
		
		
		
		
		
		
<!--         <div class="list-layout"> -->
<!--             1:1문의 내용 -->
<!--             <div class="board-wrap notice-table"> -->
<!--                 <p style="line-height: 50px;">1:1 문의 내역</p> -->
<!--                 <table> -->
<!--                     <tr> -->
<!--                         <th>번호</th> -->
<!--                         <th>제목</th> -->
<!--                         <th>작성자</th> -->
<!--                         <th>날짜</th> -->
<!--                         <th>답변상태</th> -->
<!--                     </tr> -->
<!--                     <tr> -->
<!--                         <td>1</td> -->
<!--                         <td><a href="#"> -->
<!--                             안녕 -->
<!--                         </a></td> -->
<!--                         <td>20.06.09</td> -->
<!--                         <td> -->
<!--                             <p class="btn small red"> -->
<!--                                 답변대기중 -->
<!--                             </p>                  -->
<!--                         </td> -->
<!--                     </tr>             -->
<!--                     <tr> -->
<!--                         <td>1</td> -->
<!--                         <td><a href="#"> -->
<!--                             안녕 -->
<!--                         </a></td> -->
<!--                         <td>20.06.09</td> -->
<!--                         <td>                -->
<!--                             <p class="btn small"> -->
<!--                                 답변완료 -->
<!--                             </p>        -->
<!--                         </td> -->
<!--                     </tr>             -->
<!--                     <tr> -->
<!--                         <td>1</td> -->
<!--                         <td><a href="#"> -->
<!--                             안녕 -->
<!--                         </a></td> -->
<!--                         <td>20.06.09</td> -->
<!--                         <td>                -->
<!--                             <p class="btn small"> -->
<!--                                 답변완료 -->
<!--                             </p>        -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                 </table> -->
<!--                 <div class="page-wrap"> -->
<!--                     <ul class="page"> -->
<!--                         <li><a href="#">◀</a></li> -->
<!--                         <li><a href="#">1</a></li> -->
<!--                         <li><a href="#">2</a></li> -->
<!--                         <li><a href="#">3</a></li> -->
<!--                         <li><a href="#">4</a></li> -->
<!--                         <li><a href="#">5</a></li> -->
<!--                         <li><a href="#">▶</a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--             </div> -->
<!--             1:1문의 내용 -->
            
<!--             상품 Q&A 내용 -->
<!--             <div class="board-wrap notice-table"> -->
<!--                 <p style="line-height: 50px;">상품 Q&A 내역</p> -->
<!--                 <table> -->
<!--                     <tr> -->
<!--                         <th>번호</th> -->
<!--                         <th>제목</th> -->
<!--                         <th>날짜</th> -->
<!--                         <th>답변상태</th> -->
<!--                     </tr> -->
<!--                     <tr> -->
<!--                         <td>1</td> -->
<!--                         <td><a href="#"> -->
<!--                             안녕 -->
<!--                         </a></td> -->
<!--                         <td>20.06.09</td> -->
<!--                         <td> -->
<!--                             <p class="btn small red"> -->
<!--                                 답변대기중 -->
<!--                             </p>                  -->
<!--                         </td> -->
<!--                     </tr>             -->
<!--                     <tr> -->
<!--                         <td>1</td> -->
<!--                         <td><a href="#"> -->
<!--                             안녕 -->
<!--                         </a></td> -->
<!--                         <td>20.06.09</td> -->
<!--                         <td>                -->
<!--                             <p class="btn small"> -->
<!--                                 답변완료 -->
<!--                             </p>        -->
<!--                         </td> -->
<!--                     </tr>             -->
<!--                     <tr> -->
<!--                         <td>1</td> -->
<!--                         <td><a href="#"> -->
<!--                             안녕 -->
<!--                         </a></td> -->
<!--                         <td>20.06.09</td> -->
<!--                         <td>                -->
<!--                             <p class="btn small"> -->
<!--                                 답변완료 -->
<!--                             </p>        -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                 </table> -->
<!--                 <div class="page-wrap"> -->
<!--                     <ul class="page"> -->
<!--                         <li><a href="#">◀</a></li> -->
<!--                         <li><a href="#">1</a></li> -->
<!--                         <li><a href="#">2</a></li> -->
<!--                         <li><a href="#">3</a></li> -->
<!--                         <li><a href="#">4</a></li> -->
<!--                         <li><a href="#">5</a></li> -->
<!--                         <li><a href="#">▶</a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--             </div> -->
<!--             상품 Q&A 내용 -->
<!--         </div> -->
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
	
</body>
</html>