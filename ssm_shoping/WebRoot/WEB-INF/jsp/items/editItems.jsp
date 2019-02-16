<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<title>查询商品列表</title>
</head>
<style>
	body{background-color:#f8f8f8;}
</style>

<c:if test="${allErrors != null}">
	<c:forEach items="${allErrors }" var="error">
		${error.defaultMessage }<br/>
	</c:forEach>
</c:if>

<body> 
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">    <!--navbar-fixed-bottom决定了顶部底部，固定的-->
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">当前用户：${username }</a></li>
            <li class="dropdown">
                <c:if test="${username != null}">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/logout.action">退出登录</a>
                </c:if>
            </li>
        </ul>
    </nav>
    <br/><br/><br/>

<form action="${pageContext.request.contextPath }/items/editItemsSubmit.action" method="post" enctype="multipart/form-data">

    <input type="hidden" name="id" value="${item.id}">
    <div class="text-primary col-sm-4">修改商品信息：</div>
    <div class="col-sm-12">
        <table class="table">
            <thead>
                
            </thead>
        <tbody>
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
        </tbody>
        </table>
    </div>
</form>
</body>

</html>