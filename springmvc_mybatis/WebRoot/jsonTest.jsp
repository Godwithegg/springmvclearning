<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>json交互的测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
//请求的是json（商品信息）输出的是json（商品信息）
function requestJson()
{	console.log('12');
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/requestJson.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		data:'{"name":"手机","price":999}',
		success:function(data){
			//返回json结果
			alert(data);
			console.log(data);
		}
	})
	
}
//请求的是key/value，输出是json
function responseJson()
{
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/responseJson.action',
		//contentType:'application/json;charset=utf-8'
		//这里不需要指定contenttype因为他默认是key/value类型
		//数据格式是json串
		data:'name=手机&price=999',
		success:function(data){
			//返回json结果
			alert(data);
		}
	})
}
</script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json输出json">
<input type="button" onclick="responseJson()" value="请求key/value输出json">
</body>
</html>