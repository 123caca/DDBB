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
        width: 15%;
    }
    td:nth-child(2) {
        width: 15%;
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
                <a href="../layout/header.html">./layout/header.html</a>
            </td>
            <td>O</td>
        </tr> 

        <!-- search -->
        <tr class="menu">
            <td>search</td>
            <td></td>
            <td></td>
            <td>
                <a href="search.html">search.html</a>
            </td>
            <td>O</td>
        </tr> 

        <!-- index -->
        <tr class="menu">
            <td>index</td>
            <td></td>
            <td></td>
            <td>
                <a href="index.html">index.html</a>
            </td>
            <td>O</td>
        </tr> 

        <!-- login -->
        <tr class="menu">
            <td>login</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td>로그인</td>
            <td></td>
            <td>
                <a href="../login/login.html">./login/login.html</a>
            </td>
            <td>O</td>
        </tr>

        <!-- main -->
        <tr class="menu">
            <td>main</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td>배너 리스트</td>
            <td></td>
            <td>
                <a href="../main/banner.html">./main/banner.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>배너 추가</td>
            <td></td>
            <td>
                <a href="../main/banner_add.html">./main/banner_add.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>배너 수정</td>
            <td></td>
            <td>
                <a href="../main/banner_update.html">./main/banner_update.html</a>
            </td>
            <td>O</td>
        </tr>

        <!-- user -->
        <tr class="menu">
            <td>user</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td>아이디 생성</td>
            <td></td>
            <td>
                <a href="../user/join.html">./user/join.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>사용자 정보</td>
            <td></td>
            <td>
                <a href="../user/member.html">./user/member.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>사용자 상세정보</td>
            <td>
                <a href="../user/member_con.html">./user/member_con.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>관리자 정보</td>
            <td></td>
            <td>
                <a href="../user/admin.html">./user/admin.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>정보 수정</td>
            <td>
                <a href="../user/admin_update.html">./user/admin_update.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>등급별 할인</td>
            <td></td>
            <td>
                <a href="../user/discount.html">./user/discount.html</a>
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
            <td>자주하는 문의</td>
            <td></td>
            <td>
                <a href="../customer/faq.html">./customer/faq.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>문의 추가</td>
            <td>
                <a href="../customer/faq_add.html">./customer/faq_add.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>문의 수정</td>
            <td>
                <a href="../customer/faq_update.html">./customer/faq_update.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>1:1 문의</td>
            <td></td>
            <td>
                <a href="../customer/question.html">./customer/question.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>문의 답변</td>
            <td>
                <a href="../customer/question_answer.html">./customer/question_answer.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>공지사항</td>
            <td></td>
            <td>
                <a href="../customer/notice.html">./customer/notice.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>문의 추가</td>
            <td>
                <a href="../customer/notice_add.html">./customer/notice_add.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>문의 수정</td>
            <td>
                <a href="../customer/notice_update.html">./customer/notice_update.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>이벤트</td>
            <td></td>
            <td>
                <a href="../customer/event.html">./customer/event.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>이벤트 추가</td>
            <td>
                <a href="../customer/event_add.html">./customer/event_add.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>이벤트 수정</td>
            <td>
                <a href="../customer/event_update.html">./customer/event_update.html</a>
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
                <a href="../product/product.html">./product/product.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>상품 등록</td>
            <td></td>
            <td>
                <a href="../product/product_add.html">./product/product_add.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>상품 수정</td>
            <td></td>
            <td>
                <a href="../product/product_update.html">./product/product_update.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td>상품 Q&A</td>
            <td></td>
            <td>
                <a href="../product/product_qna.html">./product/product_qna.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>답변</td>
            <td>
                <a href="../product/product_qna_answer.html">./product/product_qna_answer.html</a>
            </td>
            <td>O</td>
        </tr>

        <!-- order -->
        <tr class="menu">
            <td>order</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td>주문 / 배송</td>
            <td></td>
            <td>
                <a href="../order/order.html">./order/order.html</a>
            </td>
            <td>O</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>상세페이지</td>
            <td>
                <a href="../order/order_con.html">./order/order_con.html</a>
            </td>
            <td>O</td>
        </tr>
    </table>
</body>
</html>