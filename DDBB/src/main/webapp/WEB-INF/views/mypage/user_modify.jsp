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
.user_modify_btn {
	text-align: center;
	padding-top: 30px;
}
</style>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="resources/js/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
// 우편번호 찾기
function ModifyAddressSearch(){
    daum.postcode.load(function(){
        new daum.Postcode({
            oncomplete: function(data) {
            	$('[name=address1]').val("");
    			$('[name=address1]').val(data.zonecode); // 우편번호 (5자리)
    			$('[name=address3]').val("");
    			$('[name=address3]').val(data.address);
            }
        }).open();
    });
	}
	// 데이터 유효성 검사
	function pwdChkF() {
		// 미입력 확인
		if(!document.getElementById("name").value){
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
        // 비밀번호에 공백 사용하지 않기
        if (document.user_modify_info.pwd.value.indexOf(" ") >= 0) {
            alert("비밀번호에 공백을 사용할 수 없습니다.")
            document.user_modify_info.pwd.focus();
            document.user_modify_info.pwd.select()
            return false;
        }
        // 이메일에 공백 사용하지 않기
        if (document.user_modify_info.email1.value.indexOf(" ") >= 0) {
            alert("이메일에 공백을 사용할 수 없습니다.")
            document.user_modify_info.email1.focus();
            document.user_modify_info.email1.select()
            return false;
        }
        // 이름 길이 체크(20자 까지 허용)
        if (document.user_modify_info.name.value.length>20) {
            alert("이름을 20자까지 입력해주세요.")
            document.user_modify_info.name.focus()
            document.user_modify_info.name.select()
            return false;
        }
        // 비밀번호 길이 체크(8~20자 까지 허용)
        if (document.user_modify_info.pwd.value.length<8 || document.user_modify_info.pwd.value.length>20) {
            alert("비밀번호를 8~20자까지 입력해주세요.")
            document.user_modify_info.pwd.focus()
            document.user_modify_info.pwd.select()
            return false;
        }
        // 이메일 길이 체크(20자 까지 허용)
        if (document.user_modify_info.email1.value.length>20) {
            alert("이메일을 20자까지 입력해주세요.")
            document.user_modify_info.email1.focus()
            document.user_modify_info.email1.select()
            return false;
        }
        // 핸드폰 번호2 유효성 검사 (숫자만 허용)
        for (i = 0; i < document.user_modify_info.phone2.value.length; i++) {
            ch = document.user_modify_info.phone2.value.charAt(i)
            if (!(ch >= '0' && ch <= '9')) {
                alert("번호는 숫자만 입력가능합니다.")
                document.user_modify_info.phone2.focus()
                document.user_modify_info.phone2.select()
                return false;
            }
        }
        // 핸드폰 번호3 유효성 검사 (숫자만 허용)
        for (i = 0; i < document.user_modify_info.phone3.value.length; i++) {
            ch = document.user_modify_info.phone3.value.charAt(i)
            if (!(ch >= '0' && ch <= '9')) {
                alert("번호는 숫자만 입력가능합니다.")
                document.user_modify_info.phone3.focus()
                document.user_modify_info.phone3.select()
                return false;
            }
        }
        // 핸드폰 번호2 길이 체크(4자 까지 허용)
        if (document.user_modify_info.phone2.value.length>4) {
            alert("번호를 4자까지 입력해주세요.")
            document.user_modify_info.phone2.focus()
            document.user_modify_info.phone2.select()
            return false;
        }
        // 핸드폰 번호3 길이 체크(4자 까지 허용)
        if (document.user_modify_info.phone3.value.length>4) {
            alert("번호를 4자까지 입력해주세요.")
            document.user_modify_info.phone3.focus()
            document.user_modify_info.phone3.select()
            return false;
        }

	}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<div class="content-wrap">
		<div class="input-wrap buy-all">
			<div class="content-title buy-title">
				<h2>회원 정보 수정</h2>
				<div class="page-location">
					<img src="resources/images/common/home.jpg" alt="집 아이콘">
					<p>
						<span>마이페이지</span> > <span>회원 정보 수정</span>
					</p>
				</div>
			</div>
			<div class="input-title buy-ptag">
				<p>회원 정보</p>
			</div>
			<!-- 기본정보 -->
			<!--  데이터 입력 칸 출력 ( 이름, 비밀번호, 비밀번호 확인, 이메일, 핸드폰번호, 주소 )  -->
			<form action="user_modify_result" name="user_modify_info" onsubmit="return pwdChkF()">
				<div class="input-content">
					<table>
						<tr>
							<th>아이디</th>
							<td style="line-height: 31px;">
								<span>${ user.getUserId() }</span>
								<input type="hidden" name="id" value="${ user.getUserId() }">
							</td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" id="name" value="${ user.getUserName() }"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="pwd" id="pwd" value="${ user.getUserPwd() }"></td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td><input type="password" id="pwdChk"></td></tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" name="email1" id="email1" value="${ user.getUserEmail().substring(0,user.getUserEmail().indexOf("@")) }">@
								<div class="select-wrap">
									<select name="email2" id="email2" style="width: 170px;">
										<option value="naver.com" <c:if test="${user.getUserEmail().substring(user.getUserEmail().indexOf('@')+1) == 'naver.com'}">selected</c:if>>naver.com</option>
										<option value="gmail.com" <c:if test="${user.getUserEmail().substring(user.getUserEmail().indexOf('@')+1) == 'gmail.com'}">selected</c:if>>gmail.com</option>
										<option value="daum.net" <c:if test="${user.getUserEmail().substring(user.getUserEmail().indexOf('@')+1) == 'daum.net'}">selected</c:if>>daum.net</option>
										<option value="hanmail.com" <c:if test="${user.getUserEmail().substring(user.getUserEmail().indexOf('@')+1) == 'hanmail.com'}">selected</c:if>>hanmail.com</option>
									</select>
								</div></td>
						</tr>
						<tr class="phone">
							<th>핸드폰 번호</th>
							<td>
								<div class="select-wrap">
									<select name="phone1" id="phone1" style="width: 100px;">
										<option value="010" <c:if test="${user.getUserPhone().substring(0,user.getUserPhone().indexOf('-')) == '010'}">selected</c:if>>010</option>
										<option value="011" <c:if test="${user.getUserPhone().substring(0,user.getUserPhone().indexOf('-')) == '011'}">selected</c:if>>011</option>
										<option value="016" <c:if test="${user.getUserPhone().substring(0,user.getUserPhone().indexOf('-')) == '016'}">selected</c:if>>016</option>
										<option value="019" <c:if test="${user.getUserPhone().substring(0,user.getUserPhone().indexOf('-')) == '019'}">selected</c:if>>019</option>
									</select>
								</div> - <input class="small" type="text" name="phone2" id="phone2" value="${ user.getUserPhone().substring(user.getUserPhone().indexOf('-')+1,user.getUserPhone().lastIndexOf('-')) }">
								- <input class="small" type="text" name="phone3" id="phone3" value="${ user.getUserPhone().substring(user.getUserPhone().lastIndexOf('-')+1) }">
							</td>
						</tr>
						<tr class="address">
							<th>주소</th>
							<td><input class="small" type="text" name="address1" id="address1" value="${user.getUserAddress().substring(0,user.getUserAddress().indexOf('-'))}" readonly>
								<button type="button" class="btn small curser" onclick="ModifyAddressSearch()" >우편변호 찾기</button><br> 
								<input class="long" type="text" name="address3" id="address3" value="${ user.getUserAddress().substring(user.getUserAddress().indexOf('-')+1,user.getUserAddress().indexOf('-',user.getUserAddress().indexOf('-')+1)) }" readonly><br>
								나머지 주소 <input class="mid" type="text" name="address4" id="address4" value="${ user.getUserAddress().substring(user.getUserAddress().lastIndexOf('-')+1) }"></td>
						</tr>
					</table>
				</div>
				<div class="user_modify_btn">
					<input type="submit" class="btn large" value="저장"> 
					<input type="button" class="btn large curser" value="취 소" onclick="location.href='user_info'">
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />

</body>
</html>