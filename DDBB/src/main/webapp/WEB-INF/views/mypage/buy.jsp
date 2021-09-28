<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뛰뛰빵빵</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
// 나의 우편번호 찾기
function BuyAddressSearch(){
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
//받는 사람 우편번호 찾기
function BuyOderAddressSearch(){
    daum.postcode.load(function(){
        new daum.Postcode({
            oncomplete: function(data) {
            	$('[name=orderaddress1]').val("");
    			$('[name=orderaddress1]').val(data.zonecode); // 우편번호 (5자리)
    			$('[name=orderaddress3]').val("");
    			$('[name=orderaddress3]').val(data.address);
            }
        }).open();
    });
	}
	function checkValue() {
		// 주문자
		if (!document.getElementById("name").value) {
			alert("주문한 사람의 이름을 입력하세요.");
			document.getElementById("name").focus();  
			return false;
		} else if (!document.getElementById("address1").value) {
			alert("주문한 사람의 주소를 입력하세요.");
			document.getElementById("address1").focus();
			return false;
		} else if (!document.getElementById("address3").value) {
			alert("주문한 사람의 주소를 입력하세요");
			document.getElementById("address3").focus();
			return false;
		} else if (!document.getElementById("address4").value) {
			alert("주문한 사람의 주소를 입력하세요");
			document.getElementById("address4").focus();
			return false;
		} else if (!document.getElementById("email1").value) {
			alert("주문한 사람의 이메일을 입력하세요.");
			document.getElementById("email1").focus();
			return false;
		} else if (!document.getElementById("email2").value) {
			alert("주문한 사람의 이메일을 입력하세요.");
			document.getElementById("email2").focus();
			return false;
		} else if (!document.getElementById("phone1").value) {
			alert("주문한 사람의 핸드폰 번호를 입력하세요");
			document.getElementById("phone1").focus();
			return false;
		} else if (!document.getElementById("phone2").value) {
			alert("주문한 사람의 핸드폰 번호를 입력하세요");
			document.getElementById("phone2").focus();
			return false;
		} else if (!document.getElementById("phone3").value) {
			alert("주문한 사람의 핸드폰 번호를 입력하세요.");
			document.getElementById("phone3").focus();
			return false;
		} 
		// 배송지
		else if (!document.getElementById("ordername").value) {
			alert("받는 사람의 이름을 입력하세요.");
			document.getElementById("ordername").focus();  
			return false;
		} else if (!document.getElementById("orderaddress1").value) {
			alert("받는 사람의 주소를 입력하세요.");
			document.getElementById("orderaddress1").focus();
			return false;
		} else if (!document.getElementById("orderaddress3").value) {
			alert("받는 사람의 주소를 입력하세요");
			document.getElementById("orderaddress3").focus();
			return false;
		} else if (!document.getElementById("orderaddress4").value) {
			alert("받는 사람의 주소를 입력하세요");
			document.getElementById("orderaddress4").focus();
			return false;
		} else if (!document.getElementById("orderemail1").value) {
			alert("받는 사람의 이메일을 입력하세요.");
			document.getElementById("orderemail1").focus();
			return false;
		} else if (!document.getElementById("orderemail2").value) {
			alert("받는 사람의 이메일을 입력하세요.");
			document.getElementById("orderemail2").focus();
			return false;
		} else if (!document.getElementById("orderphone1").value) {
			alert("받는 사람의 핸드폰 번호를 입력하세요");
			document.getElementById("orderphone1").focus();
			return false;
		} else if (!document.getElementById("orderphone2").value) {
			alert("받는 사람의 핸드폰 번호를 입력하세요");
			document.getElementById("orderphone2").focus();
			return false;
		} else if (!document.getElementById("orderphone3").value) {
			alert("받는 사람의 핸드폰 번호를 입력하세요.");
			document.getElementById("orderphone3").focus();
			return false;
		}
		return true;
	}


	function equals_info_chkF() {
		var equalsInfo = document.getElementById("equalsInfo").checked;
		if (!equalsInfo) {
			document.getElementById('ordername').value = '';
			document.getElementById('orderaddress1').value = '';
			document.getElementById('orderaddress3').value = '';
			document.getElementById('orderaddress4').value = '';
			document.getElementById('orderphone1').value = '';
			document.getElementById('orderphone2').value = '';
			document.getElementById('orderphone3').value = '';
			document.getElementById('orderemail1').value = '';
			document.getElementById('orderemail2').value = '';
		} else if (equalsInfo) {
			document.getElementById('ordername').value = document
					.getElementById('name').value;
			document.getElementById('orderaddress1').value = document
					.getElementById('address1').value;
			document.getElementById('orderaddress3').value = document
					.getElementById('address3').value;
			document.getElementById('orderaddress4').value = document
					.getElementById('address4').value;
			document.getElementById('orderphone1').value = document
					.getElementById('phone1').value;
			document.getElementById('orderphone2').value = document
					.getElementById('phone2').value;
			document.getElementById('orderphone3').value = document
					.getElementById('phone3').value;
			document.getElementById('orderemail1').value = document
					.getElementById('email1').value;
			document.getElementById('orderemail2').value = document
					.getElementById('email2').value;
		}
	}

	// 파라미터 값 가져오기
	function getParameterByName(name) {
		name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex
				.exec(location.search);
		return results === null ? "" : decodeURIComponent(results[1].replace(
				/\+/g, " "));
	}
// 	var chBox = getParameterByName('chBox');
	if (getParameterByName('chBox') == "") {
		  var chBox = getParameterByName('proName');
	} else {
	   	  var chBox = getParameterByName('chBox');
	}
	var size = Number(getParameterByName('size'));
	var amount = Number(getParameterByName('orderSimSelectCost')) + 100;
	if (size == 1)
		var orderProName = chBox;
	else
		var orderProName = chBox + " 외 " + (size - 1) + "개";
		

	var pay_method = "";
	// 결제 방법 선택
	$(function() {
		$(".buy-way input").click(function() {
			pay_method = $("input[name='buy_way']:checked").val();
		});
	});

	function paymentfn() {
		
		if(checkValue()){
			var IMP = window.IMP; // 생략가능
			IMP.init('imp50292878');
			IMP.request_pay({ // param
				pg : "html5_inicis",
				pay_method : 'card',
				merchant_uid : new Date().getTime(),
				name : orderProName,
				amount : amount,,
				buyer_email : document.getElementById('email1').value + "@"
							+ document.getElementById('email2').value,
				buyer_name : document.getElementById('name').value,
				buyer_tel :   document.getElementById('phone1').value + "-"
							+ document.getElementById('phone2').value + " "
							+ document.getElementById('phone3').value,
				buyer_addr :  document.getElementById('address1').value + " "
							+ document.getElementById('address3').value + " "
							+ document.getElementById('address4').value
			}, function(rsp) { // callback
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					document.getElementById("orderProName").value = orderProName;
					document.getElementById("orderProNumber").value = rsp.merchant_uid;
					document.getElementById("orderTracking").value = 1;
					alert(msg);
					
					var form = document.payment;
					form.submit();
				} else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
					alert(msg);
				}
			});
		}
	}
	
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />

	<div class="content-wrap">
		<div class="input-wrap buy-all">

			<div class="content-title buy-title">
				<h2>주문하기</h2>
				<div class="page-location">
					<img src="resources/images/common/home.jpg" alt="집 아이콘">
					<p>
						<span>마이페이지</span> > <span>주문하기</span>
					</p>
				</div>
			</div>

			<!-- 주문정보 -->
			<div class="input-title buy-ptag">
				<p>주문 정보</p>
			</div>
			<form action="buy_fn" method="POST" name="payment">
				<input type="hidden" name="orderProNumber" id="orderProNumber">
				<input type="hidden" name="orderProName" id="orderProName">
				<input type="hidden" name="orderTracking" id="orderTracking">
				<input type="hidden" name="proName" id="proName" value="${param.proName }">
				<input type="hidden" name="orderSimSelectCost" id="orderSimSelectCost" value="${param.orderSimSelectCost }">
				<c:forEach var="list" items="${chBox }">
					<input type="hidden" name="cartList" value="${list }">
				</c:forEach>
				<div class="input-content">
					<table>
						<tr>
							<th>주문자</th>
							<td><input type="text" name="name" id="name" value="${user.getUserName() }"></td>
						</tr>
						<tr class="address">
							<th>주소</th>
							<td><input class="small" type="text" name="address1" id="address1" value="${user.getUserAddress().substring(0,user.getUserAddress().indexOf('-'))}" readonly>
								<button type="button" class="btn small curser" onclick="BuyAddressSearch()" >우편변호 찾기</button><br> 
								<input class="long" type="text" name="address3" id="address3" value="${ user.getUserAddress().substring(user.getUserAddress().indexOf('-')+1,user.getUserAddress().indexOf('-',user.getUserAddress().indexOf('-')+1)) }" readonly><br>
								나머지 주소 <input class="mid" type="text" name="address4" id="address4" value="${ user.getUserAddress().substring(user.getUserAddress().lastIndexOf('-')+1) }"></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>
								<input type="text" name="email1" id="email1" value="${ user.getUserEmail().substring(0,user.getUserEmail().indexOf("@")) }">@
								<div class="select-wrap">
									<select name="email2" id="email2" style="width: 170px;">
										<option value="naver.com" <c:if test="${user.getUserEmail().substring(user.getUserEmail().indexOf('@')+1) == 'naver.com'}">selected</c:if>>
											naver.com
										</option>
										<option value="gmail.com" <c:if test="${user.getUserEmail().substring(user.getUserEmail().indexOf('@')+1) == 'gmail.com'}">selected</c:if>>
											gmail.com
										</option>
										<option value="daum.net" <c:if test="${user.getUserEmail().substring(user.getUserEmail().indexOf('@')+1) == 'daum.net'}">selected</c:if>>
											daum.net
										</option>
										<option value="hanmail.com" <c:if test="${user.getUserEmail().substring(user.getUserEmail().indexOf('@')+1) == 'hanmail.com'}">selected</c:if>>
											hanmail.com
										</option>
									</select>
								</div>
							</td>
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
								</div> 
								- 
								<input class="small" type="text" name="phone2" id="phone2"
								value="${ user.getUserPhone().substring(user.getUserPhone().indexOf('-')+1,user.getUserPhone().lastIndexOf('-')) }">
								- 
								<input class="small" type="text" name="phone3" id="phone3"
								value="${ user.getUserPhone().substring(user.getUserPhone().lastIndexOf('-')+1) }">
							</td>
						</tr>
					</table>
				</div>

				<!-- 배송정보 -->
				<div class="input-title buy-ptag">
					<span>배송 정보</span>&nbsp;&nbsp;&nbsp;&nbsp; 
					<label>
						<input type="checkbox" id="equalsInfo" onclick="equals_info_chkF()">
						<span class="next-way">위 정보와 동일</span>
					</label>
				</div>
				<div class="input-content">
					<table>
						<tr>
							<th>받는 사람</th>
							<td><input type="text" name="ordername" id="ordername"></td>
						</tr>
						<tr class="address">
							<th>주소</th>
							<td><input class="small" type="text" name="orderaddress1" id="orderaddress1"  readonly>
								<button type="button" class="btn small curser" onclick="BuyOderAddressSearch()" >우편변호 찾기</button><br> 
								<input class="long" type="text" name="orderaddress3" id="orderaddress3"  readonly><br>
								나머지 주소 <input class="mid" type="text" name="orderaddress4" id="orderaddress4" ></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>
								<input type="text" name="orderemail1" id="orderemail1">
								@
								<div class="select-wrap">
									<select name="orderemail2" id="orderemail2" style="width: 170px;">
										<option value="">선택하세요</option>
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
									<select name="orderphone1" id="orderphone1" style="width: 100px;">
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="019">019</option>
									</select>
								</div> 
								- 
								<input class="small" type="text" name="orderphone2" id="orderphone2"> 
								- 
								<input class="small" type="text" name="orderphone3" id="orderphone3">
							</td>
						</tr>
						<tr class="message">
							<th>배송 메세지</th>
							<td><textarea rows="10px" cols="50px" name="ordermsg"></textarea></td>
						</tr>
					</table>
				</div>

				<!-- 결제 예정 금액 -->
				<div class="input-title buy-ptag">
					<p>결제 예정 금액</p>
				</div>
				<div class="cart-total buy-total">
					<table>
						<tr>
							<th>총상품금액</th>
							<th>배송비</th>
							<th>결제예정금액</th>
						</tr>
						<tr>
							<td><span>${param.orderSimSelectCost }</span>원</td>
							<td>2500원</td>
							<td><span>${param.orderSimSelectCost + 2500 }</span>원</td>
						</tr>
					</table>
				</div>

				<!-- 결제 버튼 -->
				<div class="buy-center">
					<input type="button" class="btn large curser" onclick="paymentfn()" id="check_module" value="결제하기"> 
					<input type="button" class="btn large curser" onclick="history.back()" value="취소하기">
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />

</body>
</html>