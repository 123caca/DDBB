$(function() {

    $(".user.member .table-wrap tr").click(function() {
        if ($(this).index() != 0)
            $(this).next().stop().slideToggle(0);
    });
    
    
    // --------------------
    // 		관리자 페이지
    // --------------------
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