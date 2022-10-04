$(document).ready(function(){
	/*
		id = btnSubmit 인 attribute 를 찾아서 
		onlcik event -> 
	*/
	
	
	/*
		
		1. 저장 -> submit //
		
				
		2. 수정&삭제 -> ajax  -> 수정 -> 성공 -> alert('수정되었습니다') ->  1) 수정 : 게시물 상세 페이지로 이동
		 															2) 삭제 : 리스트 조회 페이지로 이동 
								   -> 실패 -> alert('수정중 오류가 발생하였습니다') -> end
	*/

	/*
	$('#btnSubmit').click(function(){
		$('#boardForm').submit();
	});
	
	$('#boardForm').submit(function(){
		$('#boardForm').submit();
	});
	*/
	$("#btnEdit").click(function(){
		alert("클릭");
		$("#editForm").submit();
	});
});
