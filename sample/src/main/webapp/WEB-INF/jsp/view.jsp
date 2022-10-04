<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>view</title>
    
<!--     
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->
	<link type="text/css" rel="stylesheet" href="/resources/css/sample.css"></link>
    <link type="text/css" rel="stylesheet" href="/resources/css/reply.css"></link>
	
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
        <form>
        	<h2> 게시글 상세보기 </h2>
        	<table>
                <tr>
                    <th>제목</th>
                    <td><input readonly="readonly" value="${board.title}" type="text" id="title" name="title"></td>
                </tr>
                <tr>
                    <th>게시글ID</th>
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
                    <td><pre><textarea readonly="readonly" cols="100" rows="30" id="content" name="content">${board.content}</textarea></pre></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td>
                    <c:forEach items="${board.files}" var="file">
						<a href="/download/${file.file_no}"> ${file.org_file_name}</a><br>
					</c:forEach>
					</td>
                </tr>
           </table>
         	<div align=right>
				<button id='btnEdit' 	type="button" class= 'btn' >수정</button>
				<button id='btnDelete' 	type="button" class= 'btn' >삭제</button>
			</div>
		</form>	
		
		<div id="reply">
			<div>
				<form name="replyForm">
					<table width=500 align="center">
						<tbody>
							<tr>
								<td>
								댓글
								<input id="r_writer" name="r_writer" placeholder="작성자를 입력해 주세요.">
        						<input id="r_content" name="r_content" placeholder="댓글을 입력해 주세요.">
        						<button id='btnReplySubmit' type="button" class= 'btn'>Submit</button>
								</td>
							</tr>
						</tbody>
					</table>
					
				</form>
			</div>
			
			<div>
				<table width=500 align="center">
				
					<tbody>
    					<c:forEach items="${board.replies}" var="reply">
    					<c:if test="${reply.parentReplyId == 0}">
    						<tr> 
    							<td colspan ="2">
    							
    							작성자 : ${reply.writer}
    							작성일자 : ${reply.inst_date}
    							<button class="ReplyReply-btn" type="button">대댓글</button>
    							</td>
    						</tr>
      						<tr>
								<td colspan ="2">내용 : ${reply.content}</td>
							</tr>
							<tr>
								<td>
									<form class="replyReplyForm">
									<div class="replyReply" style="display:none">
										ㄴ대댓글
										<input class="parent_reply_id" type="hidden" name="parent_reply_id" value="${reply.replyId}">
										<input class="rr_writer" name="rr_writer" placeholder="작성자를 입력해 주세요.">
        								<input class="rr_content" name="rr_content" placeholder="댓글을 입력해 주세요.">
        								<button class='ReplyReplySubmit-btn' type="button">Submit</button>
									</div>
									</form>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${reply.parentReplyId != 0}">
    						<tr> 
    							<td colspan ="2">
    							ㄴ[대댓글]
    							test: ${reply.parentReplyId}
    							작성자 : ${reply.writer}
    							작성일자 : ${reply.inst_date}
    							</td>
    						</tr>
      						<tr>
								<td colspan ="2">내용 : ${reply.content}</td>
							</tr>
							
						</c:if>
						
							<%-- <c:forEach items="${reReply}" var="reReply">
								<c:if test="${reReply.parent_reply_id == reply.reply_id}"> 
									<tr> 
    									<td colspan ="2">
    										ㄴ대댓글-
    										작성자 : ${reReply.r_writer}
    										작성일자 : ${reReply.inst_date}
    									</td>
    								</tr>
      								<tr>
										<td colspan ="2">내용 : ${reReply.r_content}</td>
									</tr>
								</c:if>	
							</c:forEach> --%>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/resources/js/view.js"></script>
</html>