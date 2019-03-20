<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
<meta name="description" content="description of your site" />
<meta name="author" content="author of the site" />
<title>登录页面</title>
<%@include file="head.jspf"%>

<%
     String ctxPath = request.getContextPath();
%>
	<script>
		window.onload = function () {
		    var img = document.getElementById("verifyCode");
		    img.onclick = function () {
		       var xmlHttp = new XMLHttpRequest();
                xmlHttp.open("get","${pageContext.request.contextPath }/user/code.do");
                xmlHttp.send();
                //alert("111");
            }
		}
	</script>
</head>
<body>
	<div id="in-nav">
		<div class="container">
			<div class="row">
				<div class="span12">
					<ul class="pull-right">
						<%--<li><a href="#">Link2</a></li>
						<li><a href="#">Link3</a></li>--%>
						<li><a href="${pageContext.request.contextPath }/user/login.do">登录</a></li>
					</ul>
					<h4>
						<a id="logo" href="../../index.jsp"> 电商平台<strong>管理员登录</strong></a>
					</h4>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="span6 offset2">
				<div class="login">
					<form class="form-horizontal" action="${pageContext.request.contextPath }/user/logon.do" method="post">
						<div class="control-group">
							<div class="controls">
								<h4>登录</h4>
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">用户名 </label>
							<div class="controls">
								<input id="inputEmail" name="username" type="text"
									placeholder="请输入用户名" /> 
									<span style="color: red;">${error_msg }</span>


							</div>
						</div>
						<div class="control-group">
							<label for="inputPassword" class="control-label">密码 </label>
							<div class="controls">
								<input id="inputPassword" name="pwd" type="password"
									placeholder="请输入密码" />
							</div>
						</div>
						<div class="control-group">
							<label for="inputPassword" class="control-label">验证码 </label>
							<div class="controls">
								<input id="inputvalidate" style="width: 100px" name="code"
									type="text" placeholder="请输验证码" /> 
									<a href="javascript:;" id="verifyCode"><img
									src="${pageContext.request.contextPath }/user/code.do" id="img" class="change"><span class="change">看不清，换一个</span></a>
									</br>
									<span style="color: red;">${error_msg_code }</span>
							</div>
							<script type="text/javascript">
							/* 	函数的自调用	 */
								(function(){ 
									$(".change").click(function(){
										$("#img").attr("src","${pageContext.request.contextPath }/user/code.do?date=" + new Date);
									});
								 })(); 
							</script>

						</div>
						
							
						<div class="control-group">
							<div class="controls">
								<input type="submit" class="btn" value="登录"> <%--<input
									type="button" class="btn" value="注册"
									onclick="window.location.href='add_admin.html'">--%>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
	address = protocol + window.location.host + window.location.pathname
			+ '/ws';
	socket = new WebSocket(address);
	socket.onmessage = function(msg) {
		msg.data == 'reload' && window.location.reload()
	}
</script>
</html>