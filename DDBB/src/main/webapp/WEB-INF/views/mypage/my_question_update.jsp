<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뛰뛰빵빵</title>
 <script type="text/javascript">
    function chkValidate() {
    	if (document.getElementById("question_title").value == '') {
    		alert("제목을 입력해주세요.");
    		document.getElementById("question_title").focus();
    		return false;
    	}else if (document.getElementById("question_content").value =='') {
    		alert("내용을 입력해주세요.");
    		document.getElementById("question_content").focus();
    		return false;
    	}
    	// 제목 길이 체크(50자 까지 허용)
        if (document.question_update_info.question_title.value.length>50||document.question_update_info.question_title.value.length<5) {
            alert("제목을 5~50자까지 입력해주세요.")
            document.question_update_info.question_title.focus()
            return false;
        }
     	// 내용 길이 체크(500자 까지 허용)
        if (document.question_update_info.question_content.value.length>500||document.question_update_info.question_content.value.length<5) {
            alert("내용을 5~500자까지 입력해주세요.")
            document.question_update_info.question_content.focus()
            return false;
        }
    }
    </script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
    <div class="content-wrap customer">

        <div class="content-title">
            <h2>1:1 문의 수정</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
                    <span>고객센터</span> > <span>1:1 문의 수정</span>
                </p>
            </div>
        </div>
        
        <div class="content">
            <div class="question">
                <form action="my_question_update_fin" method="post" onsubmit="return chkValidate()" name="question_update_info">
                <input type="hidden" name="cusQuestionNum" value="${param.cusQuestionNum }">
                
                    <div class="question-con">
                        <table>
                            <tr>
                                <td>제 목</td>
                                <td>
                                    <input class="user_question_title" type="text" name="question_title" id="question_title" value="${cusQuestionNum.cusQuestionTitle }">
                                </td>
                            </tr>
                            <tr>
                                <td style="vertical-align : top">내 용</td>
                                <td>
                                    <textarea class="user_question" name="question_content" id="question_content">${cusQuestionNum.cusQuestionContent }</textarea>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="question-btn">
                        <input type="submit" class="btn large" value="수 정">
                        <input type="button" class="btn large curser" value="취 소" onclick="history.back()">
                    </div>
                </form>
            </div>
            <!-- 마이페이지 [e] -->
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>