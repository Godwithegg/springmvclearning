<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>

<c:if test="${allErrors != null}">
	<c:forEach items="${allErrors }" var="error">
		${error.defaultMessage }<br/>
	</c:forEach>
</c:if>

<body> 
<form action="${pageContext.request.contextPath }/items/editItemsSubmit.action" method="post" enctype="multipart/form-data">

<input type="hidden" name="id" value="${item.id}">
修改商品信息：
<table width="100%" border=1>

<tr>
	<td>商品名称</td>
	<td>
	<input type="text" name="name" value="${item.name }">
	</td>
</tr>
<tr>
	<td>商品价格</td>
	<td><input type="text" name="price" value="${item.price }"></td>
</tr>
<tr>
	<td>生产日期</td>
	<td><input type="text" name="createtime"  value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
</tr>

<tr>
<td>商品图片</td>
<td>
	<c:if test="${item.pic != null }">
		<img src="/pic/${item.pic }" width=100 height=100/><br/>
	</c:if>
	<input type="file" name="items_pic"/>
</td>
</tr>

<tr>
	<td>商品描述</td>
	<td><input type="text" name="detail" value="${item.detail }"></td>
</tr>


<tr>
	<td colspan="2" align="center"><input type="submit" value="提交"/>
	</td>
</tr>



</table>



</form>
</body>

</html>