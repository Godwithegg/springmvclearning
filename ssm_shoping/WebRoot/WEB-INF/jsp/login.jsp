<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆用户</title>
<style>

	body{
		background-color:#f8f8f8;
	}

	.f1{
		width:20px;
		height:4px;
		
		margin:0px;
		margin:0px auto;
	}
	.tableTheme{
		width:250px;
		height:300px;
		background-color:white;	
	}
	.intp{
		padding:8px;
	}
	.tableHead{
		background:pink;
	
	}
</style>

</head>
<body>
	
	<form action="${pageContext.request.contextPath }/login.action" method="post">
	<table class="tableHead" border="1"  align="center"><tr><td>
	<table class="tableTheme" cellspacing="0" cellpadding="0">
		<tr><td><center><h3>登陆</h3></center></td></tr>
		<tr><td class="tdTxt">
			<font class="f1">用户名：</font><input name="username" type="text" maxlength="15"/>
			</td>
		</tr>	
		<tr><td class="tdTxt">
			<font class="f1">&nbsp;&nbsp;&nbsp;密码：</font><input name="password" type="password" maxlength="15" required/>
			</td>
		</tr>
		<tr><td colspan="2" align="center" height="50px">
				<b class="intp"><input type="submit" value="登陆"/></b>
				<b class="intp"><input type="reset" value="重置"></td></b>
		</tr>
	</table>
	</td></tr>
	</table>
	</form>
</body>
</html>