<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<jsp:useBean id="now" class="java.util.Date" scope="page"/>--%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<%@include file="/client/pages/common/head.jsp"%>
	<link rel="stylesheet" href="static/css/upload.css">
	<link rel="stylesheet" href="static/css/common.css">
	<link rel="stylesheet" href="static/css/iconfont1.css">
	<link type="text/css" rel="stylesheet" href="static/css/top.css">
<title>上传作品</title>
</head>

<body>
	<!--  顶部导航栏  -->
	<%@include file="/client/pages/common/menu.jsp"%>
	<%--页面主体--%>
	<main class="main">
	<form id="uploadForm" enctype="multipart/form-data" action="worksServlet?action=fileUpload" method="post">
		<div class="main-zone">
			<input type="hidden" name="id" value="${sessionScope.user.id}" />
			<input type="hidden" name="author" value="${sessionScope.user.name}" />
<%--			<input type="hidden" name="upload_time" value="${now}" />--%>
			<a href="#"> <strong> +</strong>从相册中导入</a>
			<ul class="photo-list clearfix">
				<li class="photo-item">
					<div class="upload-photo">
						<div class="hid1">
							<div class="ic">
								<i class="iconfont icon-jiahao"></i>
							</div>
							<p>最大支持20MB的JPEG格式照片 <br> 不建议加画框和水印签名</p>
						</div>
						<input type="file" name="upload"  class="file-input" onchange="upload1(this.files)" multiple accept="image/jpeg,image/jpg" />
					</div>
				</li>

				<li class="photo-item">
					<div class="upload-photo">
						<div class="hid2">
							<div class="ic">
								<i class="iconfont icon-jiahao"></i>
							</div>
							<p>最大支持20MB的JPEG格式照片 <br> 不建议加画框和水印签名</p>
						</div>
						<input type="file" name="upload"  class="file-input" onchange="upload2(this.files)" multiple accept="image/jpeg,image/jpg" />
					</div>
				</li>

				<li class="photo-item">
					<div class="upload-photo">
						<div class="hid3">
							<div class="ic">
								<i class="iconfont icon-jiahao"></i>
							</div>
							<p>最大支持20MB的JPEG格式照片 <br> 不建议加画框和水印签名</p>
						</div>
						<input type="file" name="upload"  class="file-input" onchange="upload3(this.files)" multiple accept="image/jpeg,image/jpg" />
					</div>
				</li>
			</ul>
			<img src="" alt="">
		</div>

		<script src="static/js/upload.js"></script>

		<div class="up">
			<div class="uploads">
				<p>上传到:</p>
				<select class="upsel" name="aaa">
					<option value="Myindex">我的主页</option>
					<option value="Myphoto">我的相册</option>
				</select>

				<p>标题:</p>
				<input type="text" name="title" class="tit" min="1" placeholder="请在这里输入标题" />
				<p>作品描述:</p>
				<textarea name="describe" class="describe" maxlength="200" placeholder="说说你的拍摄经历(字数不得超过200)"></textarea>
				<p>标签 —————————（10个字以内）</p>
				<input type="text" <%--name="category"--%> class="tit" maxlength="10" placeholder="输入标签名称(可选择已有标签)" />
				<p>推荐标签</p>
				<div class="atitles">
					<c:forEach items="${sessionScope.categoryList}" var="category">
						<input type="checkbox" name="category" value="${category.name}" /> ${category.name}
					</c:forEach>
				</div>
				<input type="submit" class="sub" value="发 布" />
			</div>
		</div>
	</form>
	</main>
</body>

</html>