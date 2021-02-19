﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>显示</title>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<%@include file="/client/pages/common/head.jsp" %>
<link rel="stylesheet" href="pages/showWorks/css/swiper.min.css">
<style>
* {
	padding: 0;
	margin: 0;
}
	body{background-color: #252525}
.clearfix:after {
	visibility: hidden;
	display: block;
	content: "";
	height: 0;
	line-height: 0;
	clear: both;
}
.clearfix {
	zoom: 1;
}
html, body {
	position: relative;
	height: 100%;
}
body {
	font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
	font-size: 14px;
	color: #000;
	margin: 0;
	padding: 0;
}
.swiper-container {
	width: 100%;
	margin-left: auto;
	margin-right: auto;
}
.gallery-top {
	padding-bottom: 12px;
	width: 100%;
}
.gallery-top .swiper-slide {
	max-width: 100%;
	max-width: 100%;
	width: auto;
	overflow: hidden;
	opacity: 0.5;
}
.gallery-top .swiper-slide img {
	max-width: 100%;
	height: 100%;
}
.gallery-top .swiper-slide-active {
	opacity: 1;
}
.gallery-thumbs {
	height: 65px;
	box-sizing: border-box;
	padding-top: 2px;
}
.gallery-thumbs .swiper-slide {
	max-width: 100%;
	max-height: 100%;
	width: auto;
	height: 100%;
	overflow: hidden;
}
.gallery-thumbs .swiper-slide img {
	max-width: 100%;
	height: 100%;
}
.gallery-thumbs-box {
	position: relative;
	width: 100%;
	height: 65px;
}
.gallery-thumbs-box .swiper-container {
	margin-left: auto;
	margin-right: auto;
}
.gallery-thumbs-box .swiper-button-prev {
	background-image: url(pages/showWorks/images/left-small.png);
	width: 10px;
	height: 65px;
	background-size: 10px 18px;
	left: 10px;
	margin-top: 0;
	top: 0;
	outline: none;
}
.gallery-thumbs-box .swiper-button-next {
	background-image: url(pages/showWorks/images/next-small.png);
	width: 10px;
	height: 65px;
	background-size: 10px 18px;
	right: 10px;
	margin-top: 0;
	top: 0;
	outline: none;
}
.gallery-top-box {
	position: relative;
	width: 100%;
}
.gallery-top-box .swiper-container {
	margin-left: auto;
	margin-right: auto;
}
.gallery-top-box .swiper-button-prev {
	background-image: url(pages/showWorks/images/left-lg.png);
	width: 18px;
	background-size: 18px 38px;
	left: 10px;
	margin-top: 0;
	top: 50%;
	outline: none;
	transform: translate(0, -50%)
}
.gallery-top-box .swiper-button-next {
	background-image: url(pages/showWorks/images/next-lg.png);
	width: 18px;
	background-size: 18px 38px;
	right: 10px;
	margin-top: 0;
	top: 50%;
	outline: none;
	transform: translate(0, -50%)
}
.slideshow {
	float: right;
	margin-right: 30px;
	margin-top: 15px;
	display: inline-block;
	background-repeat: no-repeat;
	background-position: center right;
	background-image: url("pages/showWorks/images/play.png");
	cursor: pointer;
	padding-right: 15px;
	color: #999;
	transition: all 0.3s ease
}
.pauseed {
	background-image: url("pages/showWorks/images/pause.png");
}
</style>

</head>
<body >

<div class="headernav" style="height:86px;line-height:86px;text-align:center;overflow:hidden;">

</div>

<!-- Swiper -->
<div class="gallery-top-box">
	<c:set value="0" var="id"></c:set>
		<div class="swiper-container gallery-top">
			<div class="swiper-wrapper">
				<c:forEach items="${requestScope.worksList}" var="works" varStatus="status">
					<div class="swiper-slide" data-id="${id=id+1}">
						<img src="worksServlet?action=showWorks&id=${works.id}" alt="aaaa"/>
					</div>
				</c:forEach>
			</div>
			<div class="swiper-scrollbar"></div>
		</div>
	<div class="swiper-button-prev"></div>
	<div class="swiper-button-next"></div>
</div>

<div class="gallery-thumbs-box">
	<div class="swiper-container gallery-thumbs">
		<div class="swiper-wrapper">
			<c:forEach items="${requestScope.worksList}" var="works" varStatus="status">
				<div class="swiper-slide" data-id="${id=id+1}">
					<img src="worksServlet?action=showWorks&id=${works.id}" alt="aaaa"/>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="swiper-button-prev"></div>
	<div class="swiper-button-next"></div>
</div>
<!-- Swiper -->
<div class="footernav clearfix" style="height:32px;overflow:hidden;">
  <div class="slideshow">slideshow</div>
</div>

<!-- Swiper JS --> 
<script src="pages/showWorks/js/jquery.min.js"></script>
<script src="pages/showWorks/js/swiper.min.js"></script>
<script>
  	//图片等比例
	galleryTopHeight()
	$(window).resize(function(){
		galleryTopHeight()
	})
	
    var galleryTop = new Swiper('.gallery-top-box .gallery-top', {
	  centeredSlides: true,
	  autoplay:{
		delay:4000,
		disableOnInteraction: false 
	  },
	  slidesPerView: 'auto',
      spaceBetween: 10,
      navigation: {
        nextEl: '.gallery-top-box .swiper-button-next',
        prevEl: '.gallery-top-box .swiper-button-prev',
      },
	  scrollbar: {
        el: '.swiper-scrollbar',
        hide: false,
		draggable: true,
		dragSize:150,
      }
    });
	
	$(".slideshow").click(function(){
		if($(this).hasClass("pauseed")){
			//播放
			$(this).removeClass("pauseed")
			galleryTop.autoplay.start()
		}else{
			//暂停
			$(this).addClass("pauseed")
			galleryTop.autoplay.stop()
			
		}
	})
	
	galleryTop.scrollbar.$el.css({
		"bottom":"0px",
		"background":"none",
		"height":"5px"
	});
	galleryTop.scrollbar.$dragEl.css({
		'background':'rgba(171,171,171,171.6)'
	}); 
	galleryTop.scrollbar.updateSize();
	
    var galleryThumbs = new Swiper('.gallery-thumbs-box .gallery-thumbs', {
      spaceBetween: 10,
      slidesPerView: 'auto',
      touchRatio: 0.2,
	  navigation: {
        nextEl: '.gallery-thumbs-box .swiper-button-next',
        prevEl: '.gallery-thumbs-box .swiper-button-prev',
      }
    });
	
	galleryTop.controller.control = galleryThumbs;
	
	<!--注意添加objThumbs,objTop对应的索引值1 ~ N -->
	var objThumbs = $(".gallery-thumbs .swiper-wrapper .swiper-slide");
	var objTop = $(".gallery-top .swiper-wrapper .swiper-slide");
	objThumbs.click(function(e){
		var currentId = $(this).attr("data-id");
		for(var i = 0 ; i< objTop.length; i++){
			if($(objTop[i]).attr("data-id") === currentId){
				$(objTop[i-1]).addClass("swiper-slide-prev")
				$(objTop[i-1]).siblings().removeClass("swiper-slide-prev")
				$(objTop[i]).addClass("swiper-slide-active")
				$(objTop[i]).siblings().removeClass("swiper-slide-active")
				$(objTop[i+1]).addClass("swiper-slide-next")
				$(objTop[i+1]).siblings().removeClass("swiper-slide-next")
				e.preventDefault();
				galleryTop.slideTo(i,1000, false);
			}
		}
	})
	
	function galleryTopHeight(){
		//处理图片比例
		var wh = $(window).height();
		var headernav_height = $(".headernav").height()
		var footernav_height = $(".footernav").height()
		var galleryThumbs_height = $(".gallery-thumbs").height()
		var galleryTop_height = wh - galleryThumbs_height - headernav_height - footernav_height - 22
		$(".gallery-top").css("height",galleryTop_height)
		//缩略图
		var galleryThumbs_width = $(window).width() - 60
		$(".gallery-thumbs-box .swiper-container").css("width",galleryThumbs_width)
		//大图
		var galleryTop_width = $(window).width() - 80
		$(".gallery-top-box .swiper-container").css("width",galleryTop_width)
	}

</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#ffffff">
<p>适用浏览器：360、FireFox、Chrome、Opera、傲游、搜狗、世界之窗. 不支持Safari、IE8及以下浏览器。</p>
</div>
</body>
</html>