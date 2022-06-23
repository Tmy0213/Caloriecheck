<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <% String filename=(String)request.getAttribute("filename"); %>
  <% String file = "file:///C:/java_2020/pleiades/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Calorie/upload/"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calorie Search</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c&family=Oleo+Script+Swash+Caps&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Hachi+Maru+Pop&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
    <script>
    function fnc_submit(form) {

    		form.submit();

    }

    function del_submit(form){

    	var result = window.confirm('削除してもいいですか？');

        if( result ) {
        	form.submit();
        }
        else {
        }
    }
    function logout_submit(form){

    	var result = window.confirm('ログアウトしますか？');

        if( result ) {
        	form.submit();
        }
        else {
        }
    }
    </script>

</head>
<body>
<div class="log">
	<form name ="logout" action="<%=request.getContextPath()%>/LoginCal" method="post">
		<c:forEach items="${logdata}" var="datalog">
			<p>ようこそ${datalog.username}さん</>
		</c:forEach>
		<input type="button" value="LOGOUT" onclick="logout_submit(this.form)">
	</form>
</div>
<div class="main">
        <header class="main-header" >
             <h1><span class="head_color">C</span>alorie <span class="head_color">C</span>hecker</h1>
        </header>
        <section class="form_dsp">
	        <form name="form1" action="<%=request.getContextPath()%>/SearchCalbtn" method="post">
		        <div class="top">
			      	<table class="search">
				    	<tr class="table_in" >
				        	<th><span class="head_color">　　　I</span>D:</th>
				        	<td><input type="text" name="foodid" placeholder="半角数字を入力" class="narabi" style="width: 200px; height: 25px;"></td>
				            <td><input type="button" name="searchBtn" value="SEARCH" class="btn1"  onclick="fnc_submit(this.form)" ><td>
				     	</tr>
				 	</table>
				 </div>
	        </form>
	       <form name="form2" action="<%=request.getContextPath()%>/SearchCalbtn2" method="post">
		        <div class="top">
			      	<table class="search">
				    	<tr class="table_in" >
				        	<th><span class="head_color">　料</span>理名:</th>
				        	<td><input type="text" name="foodName" class="narabi"style="width: 200px; height: 25px;"></td>
				            <td><input type="button" name="searchBtn" value="SEARCH" class="btn1" onclick="fnc_submit(this.form)"><td>
				     	</tr>
				 	</table>
				 </div>
	        </form>
		</section>
		<form name="form3" action="<%=request.getContextPath()%>/DeleteCalbtn" method="post">
	        <table class="itiran">
	            <tr>
	                <th class="align">check</th>
	                <th class="align">ID</th>
	                <th>料理名</th>
	                <th>カロリー</th>
	                <th><span class="red">P</span><span class="blue">F</span><span class="yellow">C</span>バランス</th>
	                <th>picture</th>
	                <th>登録日</th>
	            </tr>
				<c:forEach items="${dbdata}" var="dataLine">
		            <tr>
		                <td><input type="radio" name="chk" value="${dataLine.foodId}" class="align" > </td>
		                <td>${dataLine.foodId} </td>
		                <td>${dataLine.foodName}</td>
		                <td>${dataLine.foodCal}kcal</td>
		                <td>${dataLine.foodPfc}</td>
		                <td><img src="http://localhost:8080/Calorie/upload/${dataLine.foodImg}" alt="写真" style="height:80px; width:100px;"> </td>
		                <td>${dataLine.date}</td>
		            </tr>
	    		</c:forEach>
	        </table>
	        <div class="btnalign">
	        	<input type="button" name="delete" value="DELETE" class="btn" onclick="del_submit(this.form)">
	        </div>
		</form>
		<div class ="btnalign1">
			<form name="form4" action="<%=request.getContextPath()%>/DspRegistar" method="post">
				<input type="button" name="registar" value="REGISTAR" class="btn" onclick="fnc_submit(this.form)">
		    </form>
		    <form name="form5" action="<%=request.getContextPath()%>/DspUpdate" method="post">
			    <input type="button" name="updata" value="UPDATA" class="btn" onclick="fnc_submit(this.form)">
			</form>
		</div>
    </div>
</body>
</html>