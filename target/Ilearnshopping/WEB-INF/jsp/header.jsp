<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
	String ctxPath = request.getContextPath();
%>
<div id="in-nav">
	<div class="container">
		<div class="row">
			<div class="span12">
				<h4>
					<a id="logo" href="../../index.jsp"> 电商平台后台<strong>管理</strong>
					</a>
				</h4>
				<script>
					(function() {
						$("#logout").click(function(){
							if(confirm("您确定退出系统吗")){
								$(this).attr("href","logout.admin");
							}
						});
					}());
				</script>
			</div>
		</div>
	</div>

</div>
<div id="in-sub-nav">
	<div class="container">
		<div class="row">
			<div class="span12">
				<ul>
					<li><a href="../../index.jsp" class="active"><i
							class="batch home"></i><br />登陆</a></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
	</div>
</div>