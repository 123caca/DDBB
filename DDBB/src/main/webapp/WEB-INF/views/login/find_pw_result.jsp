<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵</title>
<script type="text/javascript">
	// 데이터 유효성 검사
	function pwdEqlualsChk(){
		// 미입력 확인
		if(!document.getElementById("pwd").value){
            alert("비밀번호를 입력하세요.");
            document.getElementById("pwd").focus();
            return false;
        }else if(document.getElementById("pwd").value != document.getElementById("pwdchk").value){
            alert("비밀번호를 동일하게 입력하세요.");
            document.getElementById("pwd").focus();
            return false;
        }
		 // 비밀번호 공백 제거
        if (document.pwChange.pwd.value.indexOf(" ") >= 0) {
            alert("비밀번호에 공백을 사용할 수 없습니다.")
            document.pwChange.pwd.focus();
            return false;
        }
		// 비밀번호 길이 체크(8~20자 까지 허용)
        if (document.pwChange.pwd.value.length<8 || document.pwChange.pwd.value.length>20) {
            alert("비밀번호를 8~20자까지 입력해주세요.")
            document.pwChange.pwd.focus()
            return false;
        }
	}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<div class="content-wrap login">
		<div class="content-title">
			<h2>비밀번호 찾기</h2>
			<div class="page-location">
				<img src="resources/images/common/home.jpg" alt="집 아이콘">
				<p>
					<span>로그인</span> > <span>비밀번호 찾기</span>
				</p>
			</div>
		</div>
		<div class="search-pw">
			<c:if test="${userDTO ==null }">
				<p>다시 입력해주세요.</p>
				<p style="margin-top: 30px;">
					<input type="button" class="btn large curser" value="다시입력" onclick="location.href='find_pw'">
				</p>
			</c:if>
			<c:if test="${userDTO !=null }">
				<form action="find_pw_update" name="pwChange" method="POST" onsubmit="return pwdEqlualsChk()">
					<div>
						<input type="hidden" name="id" value="${param.id }" />
						<span>새로운비밀번호 </span><input type="password" name="pwd" id="pwd"><br> 
						<span>새로운 비밀번호 확인 </span><input type="password" name="pwdchk" id="pwdchk">
					</div>
					<input type="submit" class="btn large" value="비밀번호 변경"> 
					<input type="button" class="btn large curser" value="취 소" onclick="location.href='login'">
				</form>
			</c:if>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>