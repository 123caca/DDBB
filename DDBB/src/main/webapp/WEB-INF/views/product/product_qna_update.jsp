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
<script type="text/javascript">
	// 데이터 유효성 검사
	function proQnaUpdateChk(){
		// 미입력 확인
		if(!document.getElementById("proQnaTitle").value){
            alert("제목을 입력하세요.");
            document.getElementById("proQnaTitle").focus();
            return false;
        }else if(!document.getElementById("proQnaContent").value){
            alert("내용을 입력하세요.");
            document.getElementById("proQnaContent").focus();
            return false;
        }
		// 제목 길이 체크(50자 까지 허용)
        if (document.proQnaUpdate_info.proQnaTitle.value.length>50||document.proQnaUpdate_info.proQnaTitle.value.length<5) {
            alert("제목을 5~50자까지 입력해주세요.")
            document.proQnaUpdate_info.proQnaTitle.focus()
            return false;
        }
     	// 내용 길이 체크(500자 까지 허용)
        if (document.proQnaUpdate_info.proQnaContent.value.length>500||document.proQnaUpdate_info.proQnaContent.value.length<5) {
            alert("내용을 5~500자까지 입력해주세요.")
            document.proQnaUpdate_info.proQnaContent.focus()
            return false;
        }
     	
	}
</script>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
    <div class="content-wrap customer">
        <div class="content-title">
            <h2>상품 문의 수정</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
					<span>메뉴</span> > <span>상품</span> > <span>상품 QnA 수정</span>
                </p>
            </div>
        </div>
        <div class="content">
            <div class="question answer reply">
                <form action="product_qna_update_fn" method="POST" name="proQnaUpdate_info" onsubmit="return proQnaUpdateChk()">
                    <input type="hidden" name="proQnaNum" value="${productQnaModify.proQnaNum }">
                    <input type="hidden" name="proQnaProName" value="${productQnaModify.proQnaProName }">
                    <div class="question-con">
                        <table class="content-answer">
	                        <tr>
	                            <th>작성자</th>
	                            <td>
	                                <p>${productQnaModify.proQnaUserName }</p>
	                                <input type="hidden" name="proQnaUserName" value="${productQnaModify.proQnaUserName }">
	                            </td>
	                            <th>작성일</th>
	                            <td>
	                                <p>${productQnaModify.proQnaDate }</p>
	                            </td>
	                        </tr>
                            <tr>
                                <td>제 목</td>
                                <td colspan="3">
                                    <input class="user_question_title" type="text" id="proQnaTitle" name="proQnaTitle" value="${productQnaModify.proQnaTitle }">
                                </td>
                            </tr>
                            <tr>
                                <td style="vertical-align : top">내 용</td>
                                <td colspan="3" class="min-height">
                                    <textarea class="user_question" id="proQnaContent" name="proQnaContent">${productQnaModify.proQnaContent }</textarea>  
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="question-btn">
                        <input type="submit" class="btn large" value="저 장">
                        <input type="button" class="btn large" value="취 소" onclick="history.back()">
                    </div>
                </form>
            </div>
        </div>
    </div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>