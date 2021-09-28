<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵 관리자 페이지</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>

</head>
<script type="text/javascript">
// 사번 중복 확인
function adminUserNumChkF(){
var adminUserNum= document.getElementById("adminUserNum").value;
	$.ajax({
		url:"overlapchk",
		type:"GET",
		data:{ adminUserNum },
		success:function(data){
			if(data==0 && adminUserNum!=''){
				idvalue=true;
				document.getElementById('adminUserNumCheck').innerHTML = '';
				document.getElementById('adminUserNumCheck').style.color = "green";
				document.getElementById('adminUserNumCheck').innerHTML = '가능';
				// 사번 문자 & 숫자 판별
				for (i = 0; i < adminUserNum.length; i++) {
			        ch = adminUserNum.charAt(i)
			        if (!(ch >= '0' && ch <= '9')) {
						document.getElementById('adminUserNumCheck').innerHTML = '';
						document.getElementById('adminUserNumCheck').style.color = "red";
						document.getElementById('adminUserNumCheck').innerHTML = '불가능';
			        }
			    }
				// 공백 체크
		        if (adminUserNum.indexOf(" ") >= 0) {
					document.getElementById('adminUserIdCheck').innerHTML = '';
					document.getElementById('adminUserIdCheck').style.color = "red";
					document.getElementById('adminUserIdCheck').innerHTML = '공백제거';
		        }
		        // 사번 길이 체크(4 ~ 20자 까지 허용)
		        if (adminUserNum.length < 4 || adminUserNum.length >= 20) {
					document.getElementById('adminUserNumCheck').innerHTML = '';
					document.getElementById('adminUserNumCheck').style.color = "red";
					document.getElementById('adminUserNumCheck').innerHTML = '글자수제한';
		        }
			}else{
				idvalue=false;
				document.getElementById('adminUserNumCheck').innerHTML = '';
				document.getElementById('adminUserNumCheck').style.color = "red";
				document.getElementById('adminUserNumCheck').innerHTML = '불가능';
			}
		},
		error:function(){
		}
	})
}
// 아이디 중복 확인
function adminUserIdChkF(){
var adminUserId= document.getElementById("adminUserId").value;
	$.ajax({
		url:"overlapchk",
		type:"GET",
		data:{ adminUserId },
		success:function(data){
			if(data==0 && adminUserId!=''){
				idvalue=true;
				document.getElementById('adminUserIdCheck').innerHTML = '';
				document.getElementById('adminUserIdCheck').style.color = "green";
				document.getElementById('adminUserIdCheck').innerHTML = '가능';
				// 공백 체크
		        if (adminUserId.indexOf(" ") >= 0) {
					document.getElementById('adminUserIdCheck').innerHTML = '';
					document.getElementById('adminUserIdCheck').style.color = "red";
					document.getElementById('adminUserIdCheck').innerHTML = '공백제거';
		        }
		        // 아이디 길이 체크(4 ~ 20자 까지 허용)
		        if (adminUserId.length < 4 || adminUserId.length >= 20) {
					document.getElementById('adminUserIdCheck').innerHTML = '';
					document.getElementById('adminUserIdCheck').style.color = "red";
					document.getElementById('adminUserIdCheck').innerHTML = '글자수제한';
		        }
			}else{
				idvalue=false;
				document.getElementById('adminUserIdCheck').innerHTML = '';
				document.getElementById('adminUserIdCheck').style.color = "red";
				document.getElementById('adminUserIdCheck').innerHTML = '불가능';
			}
		},
		error:function(){
		}
	})
}
//미입력 확인
function checkValuesF(){
	if(!document.getElementById("adminUserNum").value){
        alert("사번을 입력하세요.");
        document.getElementById("adminUserNum").focus();
        return false;
    } else if($("#adminUserNumCheck").text()=="불가능"){
        document.getElementById("adminUserNum").focus();
    	alert("사번을 다시 입력 해 주세요.");
        return false;
    } else if($("#adminUserNumCheck").text()=="공백제거"){
        document.getElementById("adminUserNum").focus();
    	alert("사번에 공백을 사용할 수 없습니다.");
        return false;
    } else if($("#adminUserNumCheck").text()=="글자수제한"){
        document.getElementById("adminUserId").focus();
    	alert("사번을 4 ~ 20자까지 입력해주세요");
        return false;
    } else if(!document.getElementById("adminUserName").value){
        alert("이름을 입력하세요.");
        document.getElementById("adminUserName").focus();
        return false;
    } else if (document.getElementById("adminUserName").value.indexOf(" ") >= 0) {
        alert("이름에 공백을 사용할 수 없습니다.");
        document.getElementById("adminUserName").focus();
		return false;
    } else if(!document.getElementById("adminUserId").value){
        alert("아이디를 입력하세요.");
        document.getElementById("adminUserId").focus();
        return false;
    } else if($("#adminUserIdCheck").text()=="불가능"){
        document.getElementById("adminUserId").focus();
    	alert("이미 사용중인 아이디입니다.");
    } else if($("#adminUserIdCheck").text()=="공백제거"){
        document.getElementById("adminUserId").focus();
    	alert("아이디에 공백을 사용할 수 없습니다.");
        return false;
    } else if($("#adminUserIdCheck").text()=="글자수제한"){
        document.getElementById("adminUserId").focus();
    	alert("아이디를 4 ~ 20자까지 입력해주세요");
        return false;
    } else if(!document.getElementById("adminUserPwd").value){
        alert("비밀번호를 입력하세요.");
        document.getElementById("adminUserPwd").focus();
        return false;
    } else if (document.getElementById("adminUserPwd").value.indexOf(" ") >= 0) {
        alert("비밀번호에 공백을 사용할 수 없습니다.");
        document.getElementById("adminUserPwd").focus();
		return false;
    }
	
	// 이름 길이 체크 (2 ~ 20자)
    if (document.getElementById("adminUserName").value.length < 2 || document.getElementById("adminUserName").value.length >= 20) {
        alert("이름을 2 ~ 20자까지 입력해주세요.")
        document.getElementById("adminUserName").focus()
        return false;
    }
	// 비밀번호 길이 체크 (4 ~ 20자)
    else if (document.getElementById("adminUserPwd").value.length < 4 || document.getElementById("adminUserPwd").value.length >= 20) {
        alert("비밀번호 4 ~ 20자까지 입력해주세요.")
        document.getElementById("adminUserPwd").focus()
        return false;
    }
}
</script>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

	<div class="container user admin">
		<h1>직원 정보 수정</h1>
		<form action="admin_update_result" method="POST"
			onsubmit="return checkValuesF()">
			<div class="input-wrap">
				<span>사번</span>
				<input type="text" id="adminUserNum" name="adminUserNum" onchange="adminUserNumChkF()" value="${adminUserDTO.getAdminUserNum() }">
				<label id="adminUserNumCheck"></label><br> 
				<span>아이디</span>
				<input type="text" id="adminUserId" name="adminUserId" onchange="adminUserIdChkF()" value="${adminUserDTO.getAdminUserId() }"><br>
				<span>이름</span>
				<input type="text" name="adminUserName" id="adminUserName" value="${adminUserDTO.getAdminUserName() }">
				<label id="adminUserIdCheck"></label><br> 
				<span>비밀번호</span>
				<input type="text" name="adminUserPwd" id="adminUserPwd" value="${adminUserDTO.getAdminUserPwd() }"> 
				<input type="hidden" name="id" value="${adminUserDTO.getAdminUserId() }">
			</div>
			<div class="chk-box">
				<p>권한</p>
				<label>
				<input type="checkbox" name="adminUserBanner" value="adminUserBanner"
				<c:if test="${adminUserDTO.getAdminUserBanner()==1}">checked</c:if>>
					슬라이드 배너
				</label> 
				<label>
				<input type="checkbox" name="adminUserCustomer" value="adminUserCustomer"
					<c:if test="${adminUserDTO.getAdminUserCustomer()==1}">checked</c:if>>
					고객센터
				</label> 
				<label>
				<input type="checkbox" name="adminUserProduct" value="adminUserProduct"
					<c:if test="${adminUserDTO.getAdminUserProduct()==1}">checked</c:if>>
					상품등록
				</label> 
				<label>
				<input type="checkbox" name="adminUserOrder" value="adminUserOrder"
					<c:if test="${adminUserDTO.getAdminUserOrder()==1}">checked</c:if>>
					주문/배송
				</label>
			</div>
			<div class="btn-wrap">
				<input type="submit" class="btn mid" value="저장"> 
            	<input type="button" onclick="history.back()" class="btn mid" value="목록">
			</div>
		</form>
	</div>
</body>
</html>