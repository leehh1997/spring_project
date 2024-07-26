<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 연습</title>
</head>
<body>
<form id="frm">
아이디 : <input type="text" name="mid">
<input type="button" value="전송" onclick="post_data()">
</form>
</body>
<script>
function post_data(){
	frm.method="post";
	frm.action="./loginok.do";
	frm.submit();
}
</script>
</html>