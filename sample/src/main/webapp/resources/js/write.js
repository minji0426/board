$(document).ready(function() {

	$("#btnSubmit").click(function() {
		var title = $("#title").val();
		var	writer = $("#writer").val();
		var	content = $("#content").val();

		if(title == ""){
			alert("제목을 입력하세요.");
			document.boardForm.title.focus();
			return;
		}
		if(writer == ""){
			alert("작성자를 입력하세요.");
			document.boardForm.writer.focus();
			return;
		}
				
		alert("등록되었습니다.");
		
		document.boardForm.submit();
	});
	
	$(".btnAdd").click(function() {
		$(".addInput").append(
			'<input type="file" multiple="multiple" id="uploadFiles" name="uploadFiles">\
			<button type="button" class="btnRemove">삭제</button><br>'
		);
		
		$(".btnRemove").click(function() {
			$(this).prev().remove();
			$(this).next().remove();
			$(this).remove();
		});
	});
	
	
});

