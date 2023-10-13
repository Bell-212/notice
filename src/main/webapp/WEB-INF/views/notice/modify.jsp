<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>

  <div>
    <h3>공지사항 편집하기</h3>
    <div>
      <form method="post" action="${contextPath}/notice/modify.do">
        <div>
          <label for="gubun">구분</label>
          <select id="gubun" name="gubun" value="${notice.gubun}">
            <option value="1">일반</option>
            <option value="2">긴급</option>
          </select>
        </div>
        <div>
          <label for="title">제목</label>
          <input type="text" id="title" name="title" value="${notice.title}">
        </div>
        <div>
          내용
          <div>
            <textarea id="content" name="content" rows="5" cols="30" >${notice.content}</textarea>
          </div>
        </div>
        <input type="hidden" name="notice_no" value="${notice.notice_no}">
        <button type="submit">편집완료</button>
        <button type="button" id="btn_list">목록</button>        
      </form>
    </div>

  </div>
  <script>
  	$('#btn_list').click(function(){
  		location.href = "${contextPath}/notice/list.do"
  	})
  </script>

</body>
</html>