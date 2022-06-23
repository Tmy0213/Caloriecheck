<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c&family=Oleo+Script+Swash+Caps&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Hachi+Maru+Pop&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <script>
    function fnc_submit(form) {
    	if(document.login.user.value == ""){
    		alert("USERIDを入力してください。");
    	}
    	if(document.login.pass.value ==""){
    		alert("PASSWORDを入力してください。")
    	}
    	form.submit();
    }
    </script>
</head>
<body>
<div class="main">
	<div class="center">
		<header class="main-header" >
			<h1><span class="head_color">C</span>alorie <span class="head_color">C</span>hecker<br>
			<span class="head_color">C</span><span class="small">&</span><span class="head_color">C</span></h1>
		</header>
		<div class="main-log">
			<form name ="login" action="<%=request.getContextPath()%>/LoginCal" method="post">
				<input type ="text" name="user" placeholder="USERID"  class="txt">
				<br>
				<input type ="password" name="pass" placeholder="PASSWORD" class="txt" >
				<br>
				<input type="button" value="Login" name="loginbtn" class="btn"  onclick="fnc_submit(this.form)">
				<% String result = (String)request.getAttribute("result"); %>
				<%if(result != null) {%>
				<p>※<%= result %></p>
				<% }else{%>
				<p></p>
				<%} %>
			</form>
		</div>
	</div>
</div>

</body>
</html>