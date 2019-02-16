<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html lang="zh-cmn-Hans">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        .myCenter{
            margin: 0 auto;
        }
        .myheader{
            background: url('header.png');
            background-size: myheader;
            height:25%;
        }
        .mybody{
            background-color:#f8f8f8;
        }
    </style>
    <!-- Bootstrap CSS -->
     <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>用户登录和注册切换</title>
</head>

<body class="mybody">
    <header>
        <div class="myheader text-dark text-center"></div>
   </header>
    <main>
        <section class="text-center">
            <h2 class="text-center">用户登录</h2>
            <div class="container">
                    <div class="col-md-4 myCenter">
                        <ul class="nav nav-tabs" >
                            <li class="nav-item col-md-6"><a href="#east" class="nav-link active" data-toggle="tab">登陆</a></li>
                            <li class="nav-item col-md-6"><a href="#west" class="nav-link" data-toggle="tab">注册</a></li>
                        </ul>
                    </div>
                <div class="tab-content py-3">
                    <div id="east" class="tab-pane active">
                        <form action="${pageContext.request.contextPath }/login.action" method="post">
                            <table align="center"><tr><td>
                            <table class="my-3" cellspacing="0" cellpadding="0">
                                <tr><td>
                                    <div class="input-group row">
                                        <span class="input-group-addon col-md-4">用户名:</span>
                                        <input class="form-control col-md-8" name="username" type="text" maxlength="15"/>
                                    </div>
                                    </td>
                                </tr>	
                                <tr><td>
                                    
                                    <div class="input-group row py-3">
                                        <span class="input-group-addon col-md-4">密码:</span>
                                        <input class="form-control col-md-8" name="password" type="password" maxlength="15" required/>
                                    </div>
                                    </td>
                                </tr>
                                <tr><td colspan="2" align="center" height="50px">
                                        <input class="btn btn-primary" type="submit" value="登陆"/>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <input class="btn btn-info" type="reset" value="重置">
                                    </td>
                                </tr>
                            </table>
                            </td></tr>
                            </table>
                        </form>
                    </div>
                    <div id="west" class="tab-pane">
                        <p>用户注册</p>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>