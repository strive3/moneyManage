<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>

    <title>用户注册</title>
    <%@include file="../head.jspf" %>
    <script type="text/javascript">
        function register() {
            var username = $("#username").val();
            $.post("${pageContext.request.contextPath }/user/check.do", {username: username}, function (data) {
                // alert(username);
                if (data.status == 1) {
                    $("#rgmsg").text(data.msg);
                } else {
                    $("#rgmsg").text("");
                }
                // alert(data.msg);
            });
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

        function click() {
            var username = $("#username").val();
            var pwd = $("#pwd").val();
            $.post("${pageContext.request.contextPath }/user/add.do", {username: username, pwd: pwd}, function (data) {
                if (data.status == 0) {
                    alert("注册成功");
                }
            });
        }


    </script>
    <link href="${pageContext.request.contextPath}/css/layer.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layer.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>

</head>
<body>
<!-- header部分 -->
<%@include file="../header.jsp" %>
<div class="page">
    <div class="page-container">
        <div class="container">
            <div class="row">
                <div class="span12">
                    <h4 class="header">用户注册</h4>
                    <form action="${pageContext.request.contextPath }/user/add.do" method="post">
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
                                <td><input type="password" id="pwd" name="pwd"/></td>
                            </tr>
                            <tr>
                                <th>确认密码</th>
                                <td><input type="password" id="repwd" name="repwd" onblur="check()"/></td>
                                <span id="msg" style="position:relative;top: 147px;left: 393px"></span>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input class="btn btn-success" type="submit"
                                           id="sub" value="注册"/>&nbsp;&nbsp;&nbsp;<input class="btn btn-danger"
                                                                                         type="reset" value="重置"/>
                                    <input id="button" class="btn btn-success" type="button"
                                           onclick="click()" value="注册"/>
                                </td>
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
<%@include file="../footer.jsp" %>
</body>
<script src="${pageContext.request.contextPath }/js/d3-setup.js"></script>
<script>
    protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
    address = protocol + window.location.host + window.location.pathname
        + '/ws';
    socket = new WebSocket(address);
    socket.onmessage = function (msg) {
        msg.data == 'reload' && window.location.reload()
    }
</script>
</html>