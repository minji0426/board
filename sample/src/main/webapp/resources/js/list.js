$(document).ready(function() {
	$("#btnWrite").click(function() {
		location.href = "write";
	});

	$("#btnTest").click(function() {
		$.ajax({
			type:		"POST",
			url: 		"/test",
			datatype:	"json",
			contentType: "application/json",

			error: function(e) {
				alert("오류가 발생하였습니다." + e);
			},

			success: function(data) {
				location.href = "list";
			}
		});
	});

	$("#btnSearch").click(function() {
		search()
	});
	
	$("#selectSize").change(function() {
		search()
	});
	
	$('.pageNumb').click(function(e){
		var idx = $(".pageNumb").index(this);
		var num = $(".pageNum").eq(idx).val();
		movePage(num);
	})
	
	$('#prev').click(function(e){
		var num = $("#num").val();
		num = parseInt(num) - 1;
		movePage(num);
	})
	
	$('#next').click(function(e){
		var num = $("#num").val();
		num = parseInt(num) + 1;
		movePage(num);
	})
	
});

function search(/*num*/){
	//$("#num").val(num);
	document.searchForm.submit();
}

function movePage(num){
	var selectSize = $("#selectSize").val();
	var searchType = $("#searchType").val();
	var keyword = $("#keyword").val();
	
	location.href="/list?num=" + num +"&selectSize=" + selectSize
		+ "&searchType=" + searchType + "&keyword=" + keyword;
}
