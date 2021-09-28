<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/jquery-1.12.1-ui.js"></script>
<script src="resources/js/default.js"></script>
</head>
<script type="text/javascript">
	function my_question_delete_chk(){
		var result = confirm("삭제하시겠습니까?");	
		if(result){
			location.href='my_question_del?cusQuestionNum=${cusQuestionNum.cusQuestionNum }';
		}
	}
</script>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

	<div class="content-wrap customer">
		<div class="content-title">
			<h2>1:1 문의</h2>
			<div class="page-location">
				<img src="resources/images/common/home.jpg" alt="집 아이콘">
				<p>
					<span>고객센터</span> > <span>1:1 문의</span>
				</p>
			</div>
		</div>

		<div class="content">
			<!-- 문의하기 [s] -->
			<div class="question answer reply">
				<div class="question-con">
				<input type="hidden" name="cusQuestionNum" value="${param.cusQuestionNum }">
					<table class="content-answer">
						<tr>
							<th>작성자</th>
							<td>
								<p>${cusQuestionNum.cusQuestionUserName }</p>
							</td>
							<th>작성일</th>
							<td>
								<p>${cusQuestionNum.cusQuestionDate }</p>
							</td>
						</tr>
						<tr>
							<th>제 목</th>
							<td colspan="3">
								<p>${cusQuestionNum.cusQuestionTitle }</p>
							</td>
						</tr>
						<tr>
							<th>내 용</th>
							<td colspan="3">
								<p>${cusQuestionNum.cusQuestionContent }</p>
							</td>
						</tr>
						<tr class="active">
							<th>답 변</th>
							<td colspan="3">
								<p id="questionAnswer">${cusQuestionNum.cusQuestionAnswer }</p>
							</td>
						</tr>
					</table>
				</div>
				<div class="question-btn">
				<c:if test="${user.getUserId()==cusQuestionNum.cusQuestionUserId }">
					<input type="button" value="삭 제" onclick="my_question_delete_chk()" class="btn large ">
					<a href="my_question_update?cusQuestionNum=${cusQuestionNum.cusQuestionNum }" class="btn large " >수 정</a>
				</c:if>	
					<input type="button" class="btn large " value="목 록" onclick="history.back()">
				</div>
			</div>
			<!-- 문의하기 [e] -->
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>