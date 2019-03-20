<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<title>用户注册</title>
	<%@include file="../head.jspf"%>
	<%--<script type="text/javascript" src="js/prototype.js"></script>--%>
	<script type="text/javascript">
        function register(){
			var username = $("#username").val();
			$.post("${pageContext.request.contextPath }/user/check.do",{username:username},function (data) {
				// alert(username);
				if (data.status == 1){
                    $("#rgmsg").text(data.msg);
                }else {
                    $("#rgmsg").text("");
				}
			    // alert(data.msg);
            });

            /*//创建 XMLHttpRequest
            var xhr = new XMLHttpRequest();
            var username = document.getElementById("username").value;

            //开启
            xhr.open("POST","${pageContext.request.contextPath }/user/check.do",true);
            xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            xhr.onreadystatechange = function(){
                if(xhr.readyState == 4 || xhr.status ==200){
					 var rgmsg = xhr.responseText;
					 if (rgmsg == "用户名可以使用") {
                         document.getElementById("rgmsg").style.color = "green";
                         document.getElementById("rgmsg").innerHTML = rgmsg;
                     }else{
                         document.getElementById("rgmsg").style.color = "red";
                         document.getElementById("rgmsg").innerHTML = rgmsg;
					 }

                }
            };
            //post的提交信息
            xhr.send("username="+username);*/
        }
		function check() {
            var pwd = document.getElementById("pwd").value;
            var repwd = document.getElementById("repwd").value;

            if (pwd != repwd) {
                document.getElementById("msg").style.color = "red";
                document.getElementById("msg").innerHTML = "两次输入的密码不一致";
            } else {
                document.getElementById("msg").style.color = "green";
                document.getElementById("msg").innerHTML = "可以注册";
            }

        }

	</script>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />

</head>
<body>
	<!-- header部分 -->
	<%@include file="../header.jsp"%>
	<div class="page">
		<div class="page-container">
			<div class="container">
				<div class="row">
					<div class="span12">
						<h4 class="header">添加用户</h4>
						<form action="add.do" method="post">
							<table class="table table-striped sortable">
								<thead>
								</thead>
								<tbody>
									<tr>
										<th>用户名</th>

										<td><input type="text" name="username" id="username" onblur="register()"/></td>
										<span id="rgmsg" style="position:relative;top: 35px;left: 490px;color: red"></span>
									</tr>
									<tr>
										<th>密码</th>
										<td><input type="password" id="pwd" name="pwd" /></td>
									</tr>
									<tr>
										<th>确认密码</th>
										<td><input type="password" id="repwd" name="repwd" onblur="check()"/></td>
										<span id="msg" style="position:relative;top: 147px;left: 393px"></span>
									</tr>
									<tr>
										<td></td>
										<td><input class="btn btn-success" type="submit"
												    value="注册" />&nbsp;&nbsp;&nbsp;<input class="btn btn-danger"
											type="reset" value="重置" /></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
</body>
<script src="${pageContext.request.contextPath }/js/d3-setup.js"></script>
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