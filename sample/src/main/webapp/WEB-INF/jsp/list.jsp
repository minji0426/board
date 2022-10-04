<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>list</title>
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
	    
	    <button id='btnTest' type="button" style="float:left"> test </button>
	    
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
				<c:forEach items="${list}" var="board">
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
    	
	    <div style="padding-right:10px" align="center">
    		<c:if test="${prev}">
 				<span>[<a id="prev" href="#">이전</a>]</span>
			</c:if>
			<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
 				<span>
  					<c:if test="${select != num}">
   						<a class="pageNumb" href="#">${num}<input class="pageNum" type="hidden" value="${num}" /></a>
 					</c:if>    
  
  					<c:if test="${select == num}">
   						<b>${num}</b>
  					</c:if>
 				</span>
			</c:forEach>
			<c:if test="${next}">
 				<span>[<a id="next" href="#">다음</a>] </span>
			</c:if>
    	</div>

    </div>
    <input id="num" name="num" type="hidden" value="${num}" />
    
    
    <div style="padding-right:10px" align="center">
    	<form id="searchForm" name="searchForm">
    	<%
    			String selectSize = request.getParameter("selectSize");
    			if(selectSize == null) selectSize = "10";
    			
    	    	String searchType = request.getParameter("searchType");
    	    	String keyword = request.getParameter("keyword");

    	    	if(searchType == null) searchType = "";
    	    	if(keyword == null) keyword = "";
    	
   		%>
   		<input id="num1" name="num1" type="hidden" value="${1}" />
   		
			<select id="selectSize" name="selectSize" >
  				<option value="1" <%=selectSize.equals("1")|| selectSize == null?"selected":""%>>1</option>
  				<option value="5" <%=selectSize.equals("5")|| selectSize == null?"selected":""%>>5</option>
  				<option value="10" <%=selectSize.equals("10")|| selectSize == null?"selected":""%>>10</option>
  				<option value="20" <%=selectSize.equals("20")|| selectSize == null?"selected":""%>>20</option>
  				<option value="100" <%=selectSize.equals("100")|| selectSize == null?"selected":""%>>100</option>
			</select>
      		<select name="searchType" id="searchType">
    			<option value="title" <%=searchType.equals("title")|| searchType == null?"selected":""%> id="title"> 제목 </option>
    			<option value="writer" <%=searchType.equals("writer")|| searchType == null?"selected":""%> id="writer"> 작성자 </option>
    			<option value="content" <%=searchType.equals("content")|| searchType == null?"selected":""%> id="content"> 내용 </option>
    		</select>
    	
    		<input placeholder="키워드를 입력하세요." value="${param.keyword}" type="text" name="keyword" id="keyword">
    	
    		<button type="button" name="btnSearch" id="btnSearch"> 검색 </button>
    	</form>
    </div>
    
</body>

<script type="text/javascript" src="/resources/js/list.js"></script>

</html>