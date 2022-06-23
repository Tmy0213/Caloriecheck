<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c&family=Oleo+Script+Swash+Caps&family=Sacramento&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/updata.css">
			<script>
			function fnc_submit(form) {
				var error = 0;
				var num = 0;

			if(document.form1.food_id.value == ""){ // idチェック
				error = 1;
			}
			if(error){
				window.alert('IDは入力必須項目です');
			}
			if(isNaN(document.form1.food_id.value)){
				num =1;
			}

			if(num){
			    window.alert("半角数字以外が入力されています");
			}

			if(error==1 || num==1){
				return false;
			}
			form.submit();
			}
			function back_submit(form){
				form.submit();
			}

			function re_set(){
				var txt ="";
				document.getElementById("id").value=txt;
				document.getElementById("name").value=txt;
				document.getElementById("cal").value=txt;
				document.getElementById("pfc1").value=txt;
				document.getElementById("date").value=txt;
			}





			 </script>
</head>
        <body>
            <div class="main">
	                <header class="main-header">
	                     <h1><span class="head_color">C</span>alorie <span class="head_color">C</span>hecker</h1>
	                </header>
	                 <div class="update">
	                	<h1><span class="head_color">U</span>pdate</h1>
	                </div>
			<form name="form1" action="<%=request.getContextPath()%>/UpdataCalbtn" method="post">
				<div class="s_table">
					<table class="search_table">
						<tr class="display">
							<th>※<span class="head_color">I</span>D</th>
							<td><input type="text" id="id" name="food_id"   style="width: 200px; height: 25px;" class="narabi"></td>
						</tr>
						<br>
						<tr class="display">
							<th><span class="head_color">料</span>理名</th>
							<td><input type="text" id="name" name="food_name"  style="width: 200px; height: 25px;" class="narabi"></td>
						</tr>
	                    <br>
	                    <tr class="display">
	                    	<th><span class="head_color">カ</span>ロリー</th>
	                        <td><input type="text" id="cal" name="food_calorie"  style="width: 170px; height: 25px; " class="narabi">kcal</td>
	                    </tr>
	                    <br>
	                    <tr class="display">
	                    	<th><span class="head_color">PFC</span></th>
	                        <td><input type="text" id="pfc1" name="food_pfc" placeholder="スラッシュで区切ってください" style="width: 200px; height: 25px;" class="narabi"></td>
	                    </tr>
	                    <br>
	               <!-- <tr class="display">
	                    	<th><span class="head_color">P</span>hoto</th>
	                        <td><input type="text" name="food_img" style="width: 200px; height: 25px;" class="narabi"></td>
	                    </tr>
	                    <br>-->
	                    <tr class="display">
	                    	<th><span class="head_color">登</span>録日</th>
	                        <td><input type="date" id="date" name="registar"  style="width: 200px; height: 25px;" class="narabi"></td>
	                    </tr>
					</table>
				</div>
				<div class="btn_disp">
					<input type="button" name="regBtn" value="更新" class="btn" onclick="fnc_submit(this.form)">
	                <input type="button" name="reset" value="リセット" class="btn" onclick="re_set();" >
				</div>
				</form>
				<div class="backbtn">
					<form  name ="form2" action="<%=request.getContextPath()%>/DispSearchCal" method="post">
					 	<input type="button" name="back" value="戻る" class="btn2" onclick="back_submit(this.form)">
					 </form>
				 </div>
			</div>
		</body>
</html>