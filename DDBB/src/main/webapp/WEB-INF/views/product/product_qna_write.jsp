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
	function proQnaWriteChk(){
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
        if (document.proQnaWrite_info.proQnaTitle.value.length>50||document.proQnaWrite_info.proQnaTitle.value.length<5) {
            alert("제목을 5~50자까지 입력해주세요.")
            document.proQnaWrite_info.proQnaTitle.focus()
            return false;
        }
     	// 내용 길이 체크(500자 까지 허용)
        if (document.proQnaWrite_info.proQnaContent.value.length>500||document.proQnaWrite_info.proQnaContent.value.length<5) {
            alert("내용을 5~500자까지 입력해주세요.")
            document.proQnaWrite_info.proQnaContent.focus()
            return false;
        }
     	
	}
</script>
<body>
	
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	
    <div class="content-wrap customer">

        <div class="content-title">
            <h2>상품 문의</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
					<span>메뉴</span> > <span>상품</span> > <span>상품 QnA 쓰기</span>
                </p>
            </div>
        </div>
        
        <div class="content">
            <div class="question">
                <form action="product_qna_write_fn" name="proQnaWrite_info" method="post" onsubmit="return proQnaWriteChk()">
                	<input type="hidden" name="proQnaProName" value="${param.proQnaProName }">
                    <div class="question-con">
                        <table>
                            <tr>
                                <td>제 목</td>
                                <td>
                                    <input class="user_question_title" type="text" name="proQnaTitle" id="proQnaTitle">
                                </td>
                            </tr>
                            <tr>
                                <td style="vertical-align : top">내 용</td>
                                <td>
                                    <textarea class="user_question" name="proQnaContent" id="proQnaContent"></textarea>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="question-btn">
                        <input type="submit" class="btn large" value="제 출">
                        <input type="button" class="btn large curser" onclick="history.back(-1)" value="취 소">
                    </div>
                </form>
            </div>
            <!-- 마이페이지 [e] -->
        </div>
    </div>
	
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
	
</body>
</html>