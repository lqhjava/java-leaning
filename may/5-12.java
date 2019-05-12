<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>表单标签2</title>
		<<!--script>
			function selectChange(){
				var jg  = document.getElementById("jg");
				alert(jg.value) ;
			}
		</script>-->
<!--
	
	常用的表单的分类
			
			input
				type = "text"  文本输入框
				type="password" 密码输入框
				type="radio"    单选按钮
				type="checkbox" 复选框
				type="hidden"   隐藏域（没有效果，可以携带数据）
				type="button" value="默认值" 普通按钮
				type="file" 上传文件
				type="submit" 提交按钮
				type="reset"  重置按钮
				type="date" 填写日期(h5提供的)
				 
		    select 下拉菜单          应用场景:省市联动
		    	option :下拉选项
		    	
		    textarea :文本域
		     
		    
		    
-->
	</head>
<body>
	<!--
		input标签:
			必填项:name属性
		
	-->
<form>
用户名:<input type="text" name="username" /><br />
密码:<input type="password" name="password" /><br />
性别:
<!--
	
	将input标签内容:看成同一组信息,指定相同name属性
-->
<input type="radio" value="男" name="gender"  />男
<input type="radio" value="女" name="gender" />女<br />
爱好:
<!--将input标签内容:看成同一组信息,指定相同name属性-->
<input type="checkbox" value="足球" name="hobit" />足球
<input type="checkbox" value="篮球" name="hobit" />篮球
<input type="checkbox" value="跑步" name="hobit" />跑步<br />
日期:
<input type="date" name="date" /><br />
联系方式:<!--提交的时候:这个数据是数字类型的字符串-->
<input type="tel" /><br />
<!--隐藏域-->
<input type="hidden" name="id" /><br />
<!--
	下拉菜单
-->
籍贯
<!--js:省市联动-->
<select name="jiguan" id="jg"  onchange="selectChange()">
	<option>-请选择-</option>
	<option>陕西省</option>
	<option>广东省</option>
	<option>山西省</option>
</select><br />
<select id="city">
	<br />
上传图片:
<input type="file" name="photo" />
<br />
自我描述:
<!--rows:指定多少行
	cols:指定一行多个字符
-->
<textarea name="decription" rows="5" cols="20">
	
</textarea>
<br />
<input type="button" value="普通按钮"  onclick=""/>
<input type="submit" value="提交" />
<input type="reset" value="重置" />
</select>
</form>
</body>
</html>
