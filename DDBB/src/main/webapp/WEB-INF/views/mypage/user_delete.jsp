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
	// 비밀번호 확인
	function pwdChkF2(){
		var pwd=document.getElementById("pwd").value;
		if(pwd!="${ user.getUserPwd()}"){
			alert("비밀번호를 다시 입력해주세요.");
			return false;
		} 
	}
</script>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
    <div class="content-wrap">
        <div class="content-title">
            <h2>회원탈퇴</h2>
            <div class="page-location">
                <img src="resources/images/common/home.jpg" alt="집 아이콘">
                <p>
                    <span>마이페이지</span> > <span>회원탈퇴</span>
                </p>
            </div>
        </div>
        <div class="input-wrap user_delete">
            <div class="input-content">
            	<!--  데이터 입력 칸 출력 ( 비밀번호 )  -->
                <form action="user_delete_chk" onsubmit="return pwdChkF2()">
                    <label>비밀번호 확인 <input type="password" class="grande" id="pwd"></label>
                    <input type="button" onclick="history.back()" class="btn large curser" value="이전">
                    <input type="submit" class="btn large" value="다음">
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</body>
</html>