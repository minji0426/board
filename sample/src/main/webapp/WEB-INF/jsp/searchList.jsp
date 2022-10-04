<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>searchList</title>
    <link rel="stylesheet" href="/resources/css/sample.css"></link>
    <style>
    	h1 {
    		text-align: center;
    	}
    	
    </style>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
	<div id="wrap">
	    <h1><a href="list"> 게시판 </a></h1>
	    
	    <button id='btnWrite' type="button" class= 'btn' style="float:right"> 글쓰기 </button>
	    
	    <table width=500 align="center">
	    	<colgroup>
	    	
	    	</colgroup>
	    	<thead>    		
				<tr align="center">
					<th>ID</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일자</th>
					<th>조회수</th>
				</tr>		
			</thead>
			<tbody>
				<c:forEach items="${searchBoard}" var="board">
				<tr align="center">
					<td>${board.id}</td>
					<td><a href="${path}view?id=${board.id}">${board.title}&nbsp;</a></td>
					<td>${board.writer}</td>
					<td>${board.inst_date}</td>
					<td>${board.views}</td>
				</tr>
				</c:forEach>
			</tbody>
	    </table>
    </div>
    <div style="padding-right:10px" align="center">
    	<form id="searchForm" name="searchForm">
    		<select name="searchType" id="searchType">
    			<option value="title"> 제목 </option>
    			<option value="writer"> 작성자 </option>
    			<option value="content"> 내용 </option>
    		</select>
    	
    		<input placeholder="키워드를 입력하세요." type="text" name="keyword" id="keyword">
    	
    		<button name="btnSearch" id="btnSearch"> 검색 </button>
    	</form>
    </div>

</body>

<script type="text/javascript" src="/resources/js/list.js"></script>

</html>