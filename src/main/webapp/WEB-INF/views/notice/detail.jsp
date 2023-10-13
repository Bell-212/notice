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
  <%-- detail --%>
  <div>
    <h3>${notice.notice_no}번 공지사항</h3>
    <form id="frm_detail"method="post" action="${contextPath}/contact/modify.do">
      <div>
        구분 : ${notice.gubun}
      </div>
      <div>
        제목 : ${notice.title}
      </div>
      <div>
        ${notice.content}
      </div>
      <hr>
      <button type="button" id="btn_modify">편집</button>
      <button type="button" id="btn_delete">삭제</button>
      <button type="button" id="btn_list">목록</button>
    </form>
    
    
  </div>
  

  
  
  
  <script>
  
  
    $('#btn_list').click(function(){
      location.href = "${contextPath}/notice/list.do"
    })
	
    $('#btn_modify').click(function(){
      location.href = "${contextPath}/notice/modify.go?notice_no=${notice.notice_no}"
    })
    
    function fnDeleteNotice(){
		$('#btn_delete').click(function(){
			if(confirm('연락처를 삭제할까요?')){
				$('#frm_detail').attr('action', '${contextPath}/notice/delete.do?notice_no=${notice.notice_no}');
				$('#frm_detail').submit();
			}
		})	
	}
	
	function fnModifyResult(){
		var modifyResult = '${modifyResult}';
		if(modifyResult !== ''){
			if(modifyResult === '1'){
				alert('연락처가 수정되었습니다.');
			} else {
				alert('연락처 수정이 실패했습니다.');
			}
		}
	}
	
  </script>


</body>
</html>