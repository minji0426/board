$(document).ready(function() {
	
	$("#btnEdit").click(function() {
		var id = $("#id").val();
		location.href = "edit?id=" + id;
	});
	
	
	$("#btnDelete").click(function() {
		var params = {
			del_yn:		'Y',
			id: 		$("#id").val()
		}
		//console.log(JSON.stringify(params));
		$.ajax({
			type:	"POST",
			url: 	"/delete",
			datatype:"json",
			//data: params,
			data: 	JSON.stringify(params),
			contentType: "application/json",

			error: function(e) {
				alert("삭제 중 오류가 발생하였습니다." + e);
			},

			success: function(data) {
				alert("삭제되었습니다.");
				location.href = "list";
			}
		});
	});
	
	//댓글 작성 버튼
	$("#btnReplySubmit").click(function() {
		var params = {
			writer:	$("#r_writer").val(),
			content:	$("#r_content").val(),
			id:			$("#id").val()
		}
		
		$.ajax({
			type:	"POST",
			url: 	"/reply",
			datatype:"json",
			data: 	JSON.stringify(params),
			contentType: "application/json",
			
			error: function(e) {
				alert("오류가 발생하였습니다." + e);
			},

			success: function(data) {
				location.href = "view?id=" + params.id;
			}
		});
	});
	
	//대댓글 작성 버튼
	$(".ReplyReplySubmit-btn").click(function() {
		var idx = $(".ReplyReplySubmit-btn").index(this);
		
		var params = {
			writer:		$(".rr_writer").eq(idx).val(),
			content:		$(".rr_content").eq(idx).val(),
			parentReplyId:$(".parent_reply_id").eq(idx).val(),
			id:				$("#id").val()
		}
		$.ajax({
			type:	"POST",
			url: 	"/reply",
			datatype:"json",
			data: 	JSON.stringify(params),
			contentType: "application/json",
			
			error: function(e) {
				alert("오류가 발생하였습니다." + e);
			},

			success: function(data) {
				location.href = "view?id=" + params.id;
			}
		});
	});
	
	
	//대댓글 버튼
	$(".ReplyReply-btn").click(function() {
		var idx = $(".ReplyReply-btn").index(this);
		if($(".replyReply").eq(idx).css("display") == "none"){
			$(".replyReply").eq(idx).show();
		}
	});
});