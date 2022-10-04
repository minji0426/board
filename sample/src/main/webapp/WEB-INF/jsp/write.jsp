<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>write</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/sample.css"></link>
    <style>
        td {
            text-align: left !important;
        }    
    	h1 {
    		text-align: center;
    	}
    </style>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="wrap">
	    <h1><a href="list"> 게시판 </a></h1>
	
        <form method="post" action="#" enctype="multipart/form-data" id="boardForm" name="boardForm">
        	<h2> 글 작성하기 </h2>
            <table>
                <tr>
                    <th>제목 *</th>
                    <td><input placeholder="제목을 입력하세요." type="text" id="title" name="title"></td>
                </tr>
                <tr>
                    <th>작성자 *</th>
                    <td><input placeholder="작성자를 입력하세요." type="text" id="writer" name="writer"></td>
                </tr>
                <tr>
                    <th>내용 *</th>
                    <td><textarea placeholder="내용을 입력하세요." cols="100" rows="30" id="content" name="content"></textarea></td>
                </tr>
                <tr>
                	<th>파일 첨부</th>
                	<td>
                		<div class="addInput">
                			
                		</div>
                		
                		<button class="btnAdd" type="button" >+</button>
                		
                		
                	</td>
                </tr>
            </table>
            <div align=right>
				<button id='btnSubmit' 	type="button" class= 'btn' >등록</button>
			</div>
        </form>
	</div>
</body>
<script type="text/javascript" src="/resources/js/write.js"></script>
</html>



    

    