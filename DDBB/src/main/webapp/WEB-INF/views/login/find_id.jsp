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
	//  데이터 유효성 검사 
	function idChkF(){
		if(!document.getElementById("name").value){
            alert("이름을 입력하세요.");
            document.getElementById("name").focus();
            return false;
        } else if(!document.getElementById("phone2").value){
            alert("전화번호를 입력하세요.");
            document.getElementById("phone2").focus();
            return false;
        }else if(!document.getElementById("phone3").value){
            alert("전화번호를 입력하세요.");
            document.getElementById("phone3").focus();
            return false;
        }

        // 이름 공백 제거
        if (document.find_id_info.name.value.indexOf(" ") >= 0) {
            alert("이름에 공백을 사용할 수 없습니다.")
            document.find_id_info.name.focus();
            return false;
        }
        // 핸드폰 번호2 공백 제거
        if (document.find_id_info.phone2.value.indexOf(" ") >= 0) {
            alert("번호에 공백을 사용할 수 없습니다.")
            document.find_id_info.phone2.focus();
            return false;
        }
        // 핸드폰 번호3 공백 제거
        if (document.find_id_info.phone3.value.indexOf(" ") >= 0) {
            alert("번호에 공백을 사용할 수 없습니다.")
            document.find_id_info.phone3.focus();
            return false;
        }
	    // 이름 길이 체크(20자 까지 허용)
        if (document.find_id_info.name.value.length>20) {
            alert("이름을 20자까지 입력해주세요.")
            document.find_id_info.name.focus()
            return false;
        }
		// 핸드폰 번호2 유효성 검사 (숫자만 허용)
        for (i = 0; i < document.find_id_info.phone2.value.length; i++) {
            ch = document.find_id_info.phone2.value.charAt(i)
            if (!(ch >= '0' && ch <= '9')) {
                alert("번호는 숫자만 입력가능합니다.")
                document.find_id_info.phone2.focus()
                return false;
            }
        }
        // 핸드폰 번호3 유효성 검사 (숫자만 허용)
        for (i = 0; i < document.find_id_info.phone3.value.length; i++) {
            ch = document.find_id_info.phone3.value.charAt(i)
            if (!(ch >= '0' && ch <= '9')) {
                alert("번호는 숫자만 입력가능합니다.")
                document.find_id_info.phone3.focus()
                return false;
            }
        }
        // 핸드폰 번호2 길이 체크(4자 까지 허용)
        if (document.find_id_info.phone2.value.length>4) {
            alert("번호를 4자까지 입력해주세요.")
            document.find_id_info.phone2.focus()
            return false;
        }
        // 핸드폰 번호3 길이 체크(4자 까지 허용)
        if (document.find_id_info.phone3.value.length>4) {
            alert("번호를 4자까지 입력해주세요.")
            document.find_id_info.phone3.focus()
            return false;
        }
	}
</script>
<style>
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<div class="content-wrap login">
		<div class="content-title">
			<h2>아이디 찾기</h2>
			<div class="page-location">
				<img src="resources/images/common/home.jpg" alt="집 아이콘">
				<p>
					<span>로그인</span> > <span>아이디 찾기</span>
				</p>
			</div>
		</div>
		<div class="input-wrap login-form">
			<div class="input-content">
				<!--  데이터 입력 칸 출력 ( 이름, 핸드폰번호 )  -->
				<form action="find_id_result" name="find_id_info" method="post" onsubmit="return idChkF()">
					<div class="select-wrap">
						<p>
							<span>이 름</span> <input type="text" name="name" id="name" style="width: 358px;">
						</p>
						<p>
							<span>핸드폰번호</span> <select name="phone1" id="phone1" style="width: 100px;">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="019">019</option>
							</select> - <input class="small" type="text" name="phone2" id="phone2"> - 
							<input class="small" type="text" name="phone3" id="phone3">
						</p>
					</div>
					<p style="margin-top: 30px;">
						<input type="submit" class="btn large" value="아이디 찾기"> 
						<input type="button" class="btn large curser" value="취 소" onclick="location.href='login'">
					</p>
					<p>
						<a href="login">로그인</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="find_pw">비밀번호 찾기</a>
					</p>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>