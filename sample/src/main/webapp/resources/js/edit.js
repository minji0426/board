$(document).ready(function() {
	/*
	$("#btnEditComplete").click(function() {
		//$(this).closest("fileForm").submit();
		var params = {
			title:		$("#title").val(),
			content:	$("#content").val(),
			id: 		$("#id").val()
		}
		
		$.ajax({
			type:		"POST",
			url: 		"/edit",
			datatype:	"json",
			data: 		JSON.stringify(params),
			contentType: "application/json",
			//processData: false, 
			//contentType: false,
			//enctype: 'multipart/form-data', 

			error: function(e) {
				alert("수정 중 오류가 발생하였습니다." + e);
			},

			success: function(data) {
				//document.fileForm.submit();
				alert("수정되었습니다.");
				location.href = "view?id=" + params.id;
			}
		});
	});
	*/
	$("#btnEditComplete").click(function() {
		document.editForm.submit();
	});
	

	$(".btnDeleteFile").click(function() {
		var idx = $(".btnDeleteFile").index(this);

		var params = {
			del_yn:		'Y',
			file_no: 	$(".fileNo").eq(idx).val(),
			id: 		$("#id").val()
		}
		$.ajax({
			type:	"POST",
			url: 	"/deleteFile",
			datatype:"json",
			data: 	JSON.stringify(params),
			contentType: "application/json",
			error: function(e) {
				alert("삭제 중 오류가 발생하였습니다." + e);
			},

			success: function(data) {
				location.href = "edit?id=" + params.id;
			}
		});
	});
	
	$(".btnAdd").click(function() {
		$(".addInput").append(			
			'<div>'
			+'<input type="file" multiple="multiple" id="uploadFiles" name="uploadFiles">'
			+'<button type="button" class="btnRemove">삭제</button>'
			+'</div>'
		);
		
		$(".btnRemove").click(function() {
			$(this).parent().remove();
		});
	});
	
	/*
	$(".btnUpload").click(function() {
		
		$("#fileForm").ajaxForm({
			type:	"POST",
			enctype: 'multipart/form-data',  
			url: 	"/editUpload",
			datatype:"json",
			//data: 	JSON.stringify(params),
			data: formData,
			processData: false,  
			contentType: false,
			//contentType: "application/json",
			error: function(e) {
				alert("업로드 중 오류가 발생하였습니다." + e);
			},

			success: function(data) {
				alert("v");
				document.fileForm.submit();
				location.href = "edit?id=" + params.id;
			}
		});
		$("#fileForm").submit();
	});
	*/
	
	/*
	$(".btnUpload").click(function() {
		var id = $("#boardId").val();
		//var formData = new FormData();
		//var files = $("#uploadFiles")[0].files;
		
		//for (var index = 0; index < files.length; index++) {
        //    formData.append(`files[${index}].file`, files[index]);
        //    formData.append(`files[${index}].id`, index + 1);
        //}
        
        //console.log(formData);
        
        //formData.append('id', id);
        
        //console.log(formData);
		var form = $('#fileForm');
		console.log(form);
        var data = new FormData(form);
        //data.append('id', id);
		
		console.log(data);
		
		 $.ajax({
		        type: "POST",
		        enctype: 'multipart/form-data',
		        url: "/editUpload?id="+id,
		        //data: formData,
		        data: data,
		        processData: false,
		        contentType: false,
		        cache: false,
		        timeout: 600000,
		        success: function (data) {
		            alert("성공");
		            location.href = "edit?id=" + id;
		        },
		        error: function (e) {
		            alert("실패");
		        }
		});
	});
	

/*
	$(".btnUpload").click(function() {
		//document.fileForm.submit();
		$(this).closest("fileForm").submit();
	});
*/
});
