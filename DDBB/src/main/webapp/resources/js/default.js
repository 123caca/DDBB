$(function() {

	// 자주하는 질문 슬라이드 토글
    $(".faq-wrap p:first-child()").click(function() {
        $(".faq-wrap p:last-child()").slideUp();
        $(this).next().stop().slideToggle();

        if($(this).children().hasClass("active")) {
            $(this).children().removeClass("active");
        } else {
            $(".faq-wrap p:first-child()").children().removeClass("active");
            $(this).children().toggleClass("active");
        }
    });

    // 리뷰 클릭 시 슬라이드 토글
    $(".review_toggle").click(function(){
    	$(".review_toggle").css('-webkit-line-clamp','3');
    	$(this).css('-webkit-line-clamp','initial');
    });
    
    // 전체 체크
   	$("#allCheck").click(function() {
   		var chk = $("#allCheck").prop("checked");
   		if (chk) {
   			$(".chBox").prop("checked", true);
   		} else {
   			$(".chBox").prop("checked", false);
   		}
   	});
   	
   	// 개별 체크 시 전체체크 체크버튼 비활성화
   	$(".chBox").click(function() {
   		$("#allCheck").prop("checked", false);
   	});
    
});