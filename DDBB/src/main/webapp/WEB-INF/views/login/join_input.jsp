<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵</title>

<style type="text/css">
.join_input_btn {
	text-align: center;
	padding-top: 30px;
}
</style>
</head>
<body>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="resources/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
	// 우편번호 찾기
	function addressSearch(){
    daum.postcode.load(function(){
        new daum.Postcode({
            oncomplete: function(data) {
    			$('[name=address1]').val(data.zonecode); // 우편번호 (5자리)
    			$('[name=address3]').val(data.address);
            }
        }).open();
    });
	}
    
	// 데이터 유효성 검사
	function checkValue(){
		// 중복된 아이디 
		if(document.getElementById("idcheck").innerText=='중복된 아이디'){
			 alert("중복된 아이디입니다.");
	            document.getElementById("id").focus();
	            return false;
		}
		// 미입력 확인
		if(!document.getElementById("id").value){
            alert("아이디를 입력하세요.");
            document.getElementById("id").focus();
            return false;
        }else if(!document.getElementById("name").value){
            alert("이름을 입력하세요.");
            document.getElementById("name").focus();
            return false;
        }else if(!document.getElementById("pwd").value){
            alert("비밀번호를 입력하세요.");
            document.getElementById("pwd").focus();
            return false;
        }else if(document.getElementById("pwd").value != document.getElementById("pwdChk").value){
            alert("비밀번호를 동일하게 입력하세요.");
            document.getElementById("pwd").focus();
            return false;
        }else if(!document.getElementById("email1").value){
            alert("이메일을 입력하세요.");
            document.getElementById("email1").focus();
            return false;
        }else if(document.getElementById("email2").options[document.getElementById("email2").selectedIndex].value=="1"){
            alert("이메일을 선택하세요.");
            document.getElementById("email2").focus();
            return false;
        }else if(!document.getElementById("phone2").value){
            alert("전화번호를 입력하세요.");
            document.getElementById("phone2").focus();
            return false;
        }else if(!document.getElementById("phone3").value){
            alert("전화번호를 입력하세요.");
            document.getElementById("phone3").focus();
            return false;
        }else if(!document.getElementById("address1").value){
            alert("우편번호를 입력하세요.");
            document.getElementById("address1").focus();
            return false;
        }else if(!document.getElementById("address3").value){
            alert("주소를 입력하세요.");
            document.getElementById("address3").focus();
            return false;
        }else if(!document.getElementById("address4").value){
            alert("나머지 주소를 입력하세요.");
            document.getElementById("address4").focus();
            return false;
        }
        // 아이디 공백 제거
        if (document.join_info.id.value.indexOf(" ") >= 0) {
            alert("아이디에 공백을 사용할 수 없습니다.")
            document.join_info.id.focus();
            return false;
        }
        // 이름 공백 제거
        if (document.join_info.name.value.indexOf(" ") >= 0) {
            alert("이름에 공백을 사용할 수 없습니다.")
            document.join_info.name.focus();
            return false;
        }
        // 비밀번호 공백 제거
        if (document.join_info.pwd.value.indexOf(" ") >= 0) {
            alert("비밀번호에 공백을 사용할 수 없습니다.")
            document.join_info.pwd.focus();
            return false;
        }
        // 이메일 공백 제거
        if (document.join_info.email1.value.indexOf(" ") >= 0) {
            alert("이메일에 공백을 사용할 수 없습니다.")
            document.join_info.email1.focus();
            return false;
        }
        // 핸드폰 번호2 공백 제거
        if (document.join_info.phone2.value.indexOf(" ") >= 0) {
            alert("번호에 공백을 사용할 수 없습니다.")
            document.join_info.phone2.focus();
            return false;
        }
        // 핸드폰 번호3 공백 제거
        if (document.join_info.phone3.value.indexOf(" ") >= 0) {
            alert("번호에 공백을 사용할 수 없습니다.")
            document.join_info.phone3.focus();
            return false;
        }
        // 아이디 길이 체크 (4~12자)
        if (document.join_info.id.value.length<4 || document.join_info.id.value.length>20) {
            alert("아이디를 4~20자까지 입력해주세요.")
            document.join_info.id.focus()
            return false;
        }
        // 이름 길이 체크(20자 까지 허용)
        if (document.join_info.name.value.length>20) {
            alert("이름을 20자까지 입력해주세요.")
            document.join_info.name.focus()
            return false;
        }
        // 비밀번호 길이 체크(8~20자 까지 허용)
        if (document.join_info.pwd.value.length<8 || document.join_info.pwd.value.length>20) {
            alert("비밀번호를 8~20자까지 입력해주세요.")
            document.join_info.pwd.focus()
            return false;
        }
        // 이메일 길이 체크(20자 까지 허용)
        if (document.join_info.email1.value.length>20) {
            alert("이메일을 20자까지 입력해주세요.")
            document.join_info.email1.focus()
            return false;
        }
        // 핸드폰 번호2 유효성 검사 (숫자만 허용)
        for (i = 0; i < document.join_info.phone2.value.length; i++) {
            ch = document.join_info.phone2.value.charAt(i)
            if (!(ch >= '0' && ch <= '9')) {
                alert("번호는 숫자만 입력가능합니다.")
                document.join_info.phone2.focus()
                return false;
            }
        }
        // 핸드폰 번호3 유효성 검사 (숫자만 허용)
        for (i = 0; i < document.join_info.phone3.value.length; i++) {
            ch = document.join_info.phone3.value.charAt(i)
            if (!(ch >= '0' && ch <= '9')) {
                alert("번호는 숫자만 입력가능합니다.")
                document.join_info.phone3.focus()
                return false;
            }
        }
        // 핸드폰 번호2 길이 체크(4자 까지 허용)
        if (document.join_info.phone2.value.length>4) {
            alert("번호를 4자까지 입력해주세요.")
            document.join_info.phone2.focus()
            return false;
        }
        // 핸드폰 번호3 길이 체크(4자 까지 허용)
        if (document.join_info.phone3.value.length>4) {
            alert("번호를 4자까지 입력해주세요.")
            document.join_info.phone3.focus()
            return false;
        }
	}
	
	// 아이디 중복 확인(ajax)
	function idchkF(){
	var userId= document.getElementById("id").value;
		$.ajax({
			url:"idchk",
			type:"GET",
			data:{userId},
			success:function(data){
				if(data==0 && userId!=''){
					idvalue=true;
					document.getElementById('idcheck').innerHTML = '';
					document.getElementById('idcheck').style.color = "green";
					document.getElementById('idcheck').innerHTML = '사용 가능한 아이디';
				}else{
					idvalue=false;
					document.getElementById('idcheck').innerHTML = '';
					document.getElementById('idcheck').style.color = "red";
					document.getElementById('idcheck').innerHTML = '중복된 아이디';
				}
			},
			error:function(){
				alert(userid);
			}
		})
	}

</script>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<div class="content-wrap">
		<div class="input-wrap buy-all">
			<div class="content-title buy-title">
				<h2>회원가입</h2>
				<div class="page-location">
					<img src="resources/images/common/home.jpg" alt="집 아이콘">
					<p>
						<span>로그인</span> > <span>회원가입</span>
					</p>
				</div>
			</div>

			<!-- 기본정보 -->
			<div class="join_agree">
				<div class="join_agree_img">
					<img src="resources/images/login/join_input.png">
				</div>
				<div class="join_agree_con">
					<div class="agree_userinfo">
						<div class="agree_con_tit" style="margin-bottom: 0;">
							<span>기본 정보</span>
						</div>
						<div class="input-content">
							<!--  데이터 입력 칸 출력 ( 아이디, 이름, 비밀번호, 비밀번호 확인, 이메일, 핸드폰번호, 주소 )  -->
							<form action="join_fin" name="join_info" method="post" onsubmit="return checkValue()">
								<table>
									<tr>
										<th>아이디</th>
										<td><input type="text" name="id" id="id" onchange="idchkF()"><label id="idcheck"></label></td>
									</tr>
									<tr>
										<th>이름</th>
										<td><input type="text" id="name" name="name"></td>
									</tr>
									<tr>
										<th>비밀번호</th>
										<td><input type="password" id="pwd" name="pwd"></td>
									</tr>
									<tr>
										<th>비밀번호 확인</th>
										<td><input type="password" id="pwdChk"></td>
									</tr>
									<tr>
										<th>이메일</th>
										<td>
											<input type="text" id="email1" name="email1">@
											<div class="select-wrap">
												<select id="email2" name="email2" style="width: 170px;">
													<option value="1" selected>선택하세요</option>
													<option value="naver.com">naver.com</option>
													<option value="gmail.com">gmail.com</option>
													<option value="daum.net">daum.net</option>
													<option value="hanmail.com">hanmail.com</option>
												</select>
											</div>
										</td>
									</tr>
									<tr class="phone">
										<th>핸드폰 번호</th>
										<td>
											<div class="select-wrap">
												<select id="phone1" name="phone1" style="width: 100px;">
													<option value="010">010</option>
													<option value="011">011</option>
													<option value="016">016</option>
													<option value="019">019</option>
												</select>
											</div> - <input class="small" type="text" id="phone2" name="phone2">
											- <input class="small" type="text" id="phone3" name="phone3">
										</td>
									</tr>
									<tr class="address">
										<th>주소</th>
										<td>
											<input class="small" type="text" id="address1" name="address1" readonly> 
											<button type="button" class="btn small curser" onclick="addressSearch()" >우편변호 찾기</button><br> 
											<input class="long" type="text" id="address3" name="address3" readonly><br>
											나머지 주소 <input class="mid" type="text" id="address4" name="address4">
										</td>
									</tr>
								</table>
								<div class="join_input_btn">
									<input class="btn large curser" type="button" onclick="location.href='login'" value="취 소">
									<input class="btn large" type="submit" value="다 음">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>