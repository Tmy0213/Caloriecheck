<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c&family=Oleo+Script+Swash+Caps&family=Sacramento&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style1.css">
			<script>

			function fnc_submit(form) {
				var flag = 0;


				// 設定開始（チェックする項目を設定してください）

				if(document.form1.food_id.value.match(/[^0-9]+/)){
					flag = 1;
					alert("半角数字を入力してください");
				}

				var error = 0;
				//ID欄のチェック
				if(document.form1.food_id.value ==""){
					error = 1;
				}//料理名チェック
				if(document.form1.food_name.value ==""){
					error = 1;
				}//カロリーチェック
				if(document.form1.food_calorie.value == ""){
					error = 1;
				}//ｐｆｃチェック
				if(document.form1.food_pfc.value == ""){
					error = 1;
				}
				if(document.form1.food_img.value == ""){
					error = 1;
				}
				if(error == 0){
				   //空欄がなければ実行
					form.submit();
				}else{
				//空欄がある場合の処理
					alert("※は入力必須項目です。");
				}
			}
			function back_submit(form){
				//メイン画面に戻る
				form.submit();
			}
			function re_set(){
				var txt ="";
				document.getElementById("id").value=txt;
				document.getElementById("name").value=txt;
				document.getElementById("cal").value=txt;
				document.getElementById("pfc1").value=txt;
				document.getElementById("pfc2").value=txt;
				document.getElementById("pfc3").value=txt;
				document.getElementById("photo").value=txt;
				document.getElementById("date").value=txt;
			}

			 </script>
</head>
        <body>
            <div class="main">
	                <header class="main-header">
	                     <h1><span class="head_color">C</span>alorie <span class="head_color">C</span>hecker</h1>
	                </header>
	                <div class="registar">
	                	<h1><span class="head_color">R</span>egistar</h1>
	                </div>
			<form name="form1" action="<%=request.getContextPath()%>/InsertCalbtn" method="post" enctype="multipart/form-data">
				<div class="s_table">
					<table class="search_table">
						<tr class="display">
							<th>※<span class="head_color">I</span>D</th>
							<td><input type="text" id="id" name="food_id" style="width: 200px; height: 25px;" class="narabi"></td>
						</tr>
						<br>
						<tr class="display">
							<th>※<span class="head_color">料</span>理名</th>
							<td><input type="text" id="name" name="food_name" style="width: 200px; height: 25px;" class="narabi"></td>
						</tr>
	                    <br>
	                    <tr class="display">
	                    	<th>※<span class="head_color">カ</span>ロリー</th>
	                         <td><input type="text" id="cal" name="food_calorie"  style="width: 170px; height: 25px; " class="narabi">kcal</td>
	                    </tr>
	                    <br>
	                    <tr class="display">
	                    	<th>※<span class="head_color">PFC</span></th>
	                        <td>P:<input type="text" id="pfc1" name="food_pfc" style="width: 20px; height: 25px;" class="narabi">
		                        F:<input type="text" id ="pfc2" name="food_pfc2" style="width: 20px; height: 25px;" class="narabi">
		                        C:<input type="text" id="pfc3"name="food_pfc3" style="width: 20px; height: 25px;" class="narabi"></td>
	                    </tr>
	                    <br>
	                    <tr class="display">
	                    	<th>※<span class="head_color">P</span>hoto</th>
	                        <td><input type="file" id="photo" name="food_img" style="width: 200px; height: 25px;" class="narabi"></td>
	                    </tr>
	                    <br>
	                    <tr class="display">
	                    	<th><span class="head_color">登</span>録日</th>
	                        <td><input type="date" id="date"  name="registar" style="width: 200px; height: 25px;" class="narabi"></td>
	                    </tr>
					</table>
				</div>
				<div class="btn_disp">
					<input type="button" name="regBtn" value="登録" class="btn" onclick="fnc_submit(this.form)">
	                <input type="button" name="reset" value="リセット" class="btn" onclick="re_set()">
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