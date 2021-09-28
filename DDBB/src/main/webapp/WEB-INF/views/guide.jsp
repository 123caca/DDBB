<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Guide</title>
    <link rel="stylesheet" href="../lib/css/reset.css">
    <style type="text/css">
    table {
        width: 1000px;
        margin: 0 auto;
    }
    .menu {
        border-top: 3px solid #000;
    }
    .menu td:first-child {
        font-weight: bold;
    }
    tr {
        line-height: 40px;
    }
    th {
        padding: 8px;
        border-bottom: 1px solid #000;
    }
    td {
        padding: 5px 15px;
        border-bottom: 1px solid #000;
    }
    td:nth-child(1) {
        width: 12%;
    }
    td:nth-child(2) {
        width: 18%;
    }
    td:nth-child(3) {
        width: 19%;
    }
    td:nth-child(4) {
        width: 41%;
        text-align: center;
    }
    td:nth-child(5) {
        width: 15%;
        text-align: center;
    }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>depth1</th>
            <th>depth2</th>
            <th>depth3</th>
            <th>링크</th>
            <th>완료여부</th>
        </tr>    

        <!-- layout -->
        <tr class="menu">
            <td>header</td>
            <td></td>
            <td></td>
            <td>
                <a href="./layout/header.html">/layout/header.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr class="menu">
            <td>footer</td>
            <td></td>
            <td></td>
            <td>
                <a href="./layout/footer.html">/layout/footer.html</a>
            </td>
            <td>O</td>
        </tr>   

        <!-- index -->
        <tr class="menu">
            <td>index</td>
            <td></td>
            <td></td>
            <td>
                <a href="./index.html">/index.html</a>
            </td>
            <td>O</td>
        </tr>

        <!-- search -->
        <tr class="menu">
            <td>search</td>
            <td></td>
            <td></td>
            <td>
                <a href="./search.html">/search.html</a>
            </td>
            <td>O</td>
        </tr>

        <!-- product -->
        <tr class="menu">
            <td>product</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td>상품 리스트</td>
            <td></td>
            <td>
                <a href="./product/product.html">/product/product.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>상품 상세페이지</td>
            <td>
                <a href="./product/product_con.html">/product/product_con.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>상품 문의글 페이지</td>
            <td>
                <a href="./product/product_qna_con.html">/product/product_qna_con.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>상품 문의글 작성</td>
            <td>
                <a href="./product/product_qna_write.html">/product/product_qna_write.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>상품 문의글 수정</td>
            <td>
                <a href="./product/product_qna_update.html">/product/product_qna_update.html</a>
            </td>
            <td>O</td>
        </tr>

        <!-- login -->
        <tr class="menu">
            <td>login</td>
            <td></td>
            <td></td>
            <td>
                <a href="./login/login.html">/login/login.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr>
            <td></td>
            <td>ID찾기</td>
            <td></td>
            <td>
                <a href="./login/find_id.html">/login/find_id.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr>
            <td></td>
            <td>ID찾기 결과</td>
            <td></td>
            <td>
                <a href="./login/find_id_result.html">/login/find_id_result.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr>
            <td></td>
            <td>PW찾기</td>
            <td></td>
            <td>
                <a href="./login/find_pw.html">/login/find_pw.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr>
            <td></td>
            <td>PW찾기 결과</td>
            <td></td>
            <td>
                <a href="./login/find_pw_result.html">/login/find_pw_result.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr>
            <td></td>
            <td>회원가입</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>   
        <tr>
            <td></td>
            <td></td>
            <td>약관동의</td>
            <td>
                <a href="./login/join_agree.html">/login/join_agree.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr>
            <td></td>
            <td></td>
            <td>정보입력</td>
            <td>
                <a href="./login/join_input.html">/login/join_input.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr>
            <td></td>
            <td></td>
            <td>가입완료</td>
            <td>
                <a href="./login/join_fin.html">/login/join_fin.html</a>
            </td>
            <td>O</td>
        </tr>   

        <!-- customer -->
        <tr class="menu">
            <td>customer</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>     
        <tr>
            <td></td>
            <td>자주하는질문</td>
            <td></td>
            <td>
                <a href="./customer/faq.html">/customer/faq.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td>1:1문의 리스트</td>
            <td></td>
            <td>
                <a href="./customer/question.html">/customer/question.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr>
            <td></td>
            <td></td>
            <td>문의 글 페이지</td>
            <td>
                <a href="./customer/question_con.html">/customer/question_con.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>문의 글 작성</td>
            <td>
                <a href="./customer/question_write.html">/customer/question_write.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>문의 글 수정</td>
            <td>
                <a href="./customer/question_update.html">/customer/question_update.html</a>
            </td>
            <td>O</td>
        </tr>        
        <tr>
            <td></td>
            <td>공지사항 리스트</td>
            <td></td>
            <td>
                <a href="./customer/notice.html">/customer/notice.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td></td>
            <td>공지사항 페이지</td>
            <td>
                <a href="./customer/notice_con.html">/customer/notice_con.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td>이벤트 리스트</td>
            <td></td>
            <td>
                <a href="./customer/event.html">/customer/event.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td></td>
            <td>이벤트 글 페이지</td>
            <td>
                <a href="./customer/event_con.html">/customer/event_con.html</a>
            </td>
            <td>O</td>
        </tr>     

        <!-- mypage -->
        <tr class="menu">
            <td>mypage</td>
            <td></td>
            <td></td>
            <td>
                <a href="./mypage/mypage.html">/mypage/mypage.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td>회원정보관리</td>
            <td></td>
            <td>
                <a href="./mypage/user_info.html">/mypage/user_info.html</a>
            </td>
            <td>O</td>
        </tr>    
        <tr>
            <td></td>
            <td></td>
            <td>회원정보 비번 확인</td>
            <td>
                <a href="./mypage/user_modify_chk.html">/mypage/user_modify_chk.html</a>
            </td>
            <td>O</td>
        </tr>      
        <tr>
            <td></td>
            <td></td>
            <td>회원정보수정</td>
            <td>
                <a href="./mypage/user_modify.html">/mypage/user_modify.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr>
            <td></td>
            <td></td>
            <td>회원탈퇴 비번 확인</td>
            <td>
                <a href="./mypage/user_delete.html">/mypage/user_delete.html</a>
            </td>
            <td>O</td>
        </tr>       
        <tr>
            <td></td>
            <td></td>
            <td>회원탈퇴 체크</td>
            <td>
                <a href="./mypage/user_delete_chk.html">/mypage/user_delete_chk.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td>장바구니</td>
            <td></td>
            <td>
                <a href="./mypage/cart.html">/mypage/cart.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td></td>
            <td>구매</td>
            <td>
                <a href="./mypage/buy.html">/mypage/buy.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td></td>
            <td>결제</td>
            <td>
                <a href="./mypage/payment.html">/mypage/payment.html</a>
            </td>
            <td></td>
        </tr>     
        <tr>
            <td></td>
            <td>찜하기</td>
            <td></td>
            <td>
                <a href="./mypage/wish_list.html">/mypage/wish_list.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td>주문정보</td>
            <td></td>
            <td>
                <a href="./mypage/buy_list.html">/mypage/buy_list.html</a>
            </td>
            <td>O</td>
        </tr> 
        <tr>
            <td></td>
            <td>주문정보 상세페이지</td>
            <td></td>
            <td>
                <a href="./mypage/buy_list_con.html">/mypage/buy_list_con.html</a>
            </td>
            <td>O</td>
        </tr>   
        <tr>
            <td></td>
            <td>내 질답</td>
            <td></td>
            <td>
                <a href="./mypage/user_question.html">/mypage/user_question.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td></td>
            <td>내 질답 상세</td>
            <td>
                <a href="./mypage/user_question_con.html">/mypage/user_question_con.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td>내가 쓴 상품평</td>
            <td></td>
            <td>
                <a href="./mypage/user_review.html">/mypage/user_review.html</a>
            </td>
            <td>O</td>
        </tr>      
        <tr>
            <td></td>
            <td></td>
            <td>상품평쓰기</td>
            <td>
                <a href="./mypage/review_write.html">/mypage/review_write.html</a>
            </td>
            <td>O</td>
        </tr>     
        <tr>
            <td></td>
            <td></td>
            <td>상품평수정</td>
            <td>
                <a href="./mypage/review_update.html">/mypage/review_update.html</a>
            </td>
            <td>O</td>
        </tr>    
    </table>
</body>
</html>