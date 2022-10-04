<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>edit</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/sample.css"></link>
    <style>
        td {
            text-align: left !important;
        }    
    	h1 {
    		text-align: center;
    	}
    </style>
     
</head>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<body>
	<div id="wrap">
	    <h1><a href="list"> 게시판 </a></h1>
        <form method="post" action="#" enctype="multipart/form-data" id="editForm" name="editForm">
        	<h2> 게시글 수정하기 </h2>
        	<table>
                <tr>
                    <th>제목</th>
                    <td><input value="${board.title}" type="text" id="title" name="title"></td>
                </tr>
                <tr>
                    <th>게시글 ID</th>
                    <td><input readonly="readonly" value="${board.id}" type="text" id="id" name="id"></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input readonly="readonly" value="${board.writer}" type="text" id="writer" name="writer"></td>
                </tr>
                <tr>
                    <th>작성일자</th>
                    <td><input readonly="readonly" value="${board.inst_date}" type="text" id="inst_date" name="inst_date"></td>
                </tr>
                <tr>
                    <th>조회수</th>
                    <td><input readonly="readonly" value="${board.views}" type="text" id="views" name="views"></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><pre><textarea cols="100" rows="30" id="content" name="content">${board.content}</textarea></pre></td>
                </tr>
                <tr>
                	<th>파일 첨부</th>
                	<td>
                		<c:forEach items="${file}" var="file">
							${file.org_file_name} <input class="fileNo" type="hidden" value="${file.file_no}" />
							<button class='btnDeleteFile' 	type="button">삭제</button><br>
						</c:forEach>
						<!-- <form method="post" action="#" enctype="multipart/form-data" id="fileForm" name="fileForm"> -->
							<%-- <input id="boardId" type="hidden" value="${board.id}" /> --%>
                			<div class="addInput">
                			
                			</div>
                		
                			<button class="btnAdd" type="button" >+</button>
                		<!-- </form> -->
                		
                	</td>
                </tr>
           </table>
         	<div align=right>
				<button id='btnEditComplete' type="button" class= 'btn' >수정 완료</button>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="/resources/js/edit.js"></script>

<!-- 
	ajax -> 수정 처리 -> 성공 상태 response -> 상세보기 페이지로 이동 
 -->
</html>