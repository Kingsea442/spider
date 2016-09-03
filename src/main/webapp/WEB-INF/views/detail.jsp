<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Spider</title>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- <link rel="stylesheet" href="css/home.css"> -->
<!-- <link rel="stylesheet" href="css/golbal.css"> -->

<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/pkg/wiki-lemma_74e1370.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-common/pkg/wiki-common-base_5dec560.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/lemma_content/configModule/secondsKnow/perfect-scrollbar/index_c66d49f.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/tools/announcement/announcement_b0d7681.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/tools/label/label_461cbe0.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/tools/newSideShare/sideShare_ebee986.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/tools/praise/praise_2120cd2.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/tools/searchHeader/toolButtons/toolButtons_a2c470f.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/tools/searchHeader/toolButtons/userInfo_9ba20c1.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/tools/video/pageMask/pageMask_ff9a193.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/pkg/wiki-lemma-module_95b08c6.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/lemma_content/configModule/secondsKnow/secondsKnow_f25918a.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/lemma_content/configModule/focusAndRelation/focusAndRelation_15df9cb.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/lemma_content/configModule/hotspotmining/hotspotmining_5093dcd.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/feature/star/starMovieAndTvplay/starMovieAndTvplay_ce74616.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/lemma_content/mainContent/mainContent_1a67233.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/lemma_content/mainContent/lemmaRelation/lemmaRelation_9f629f5.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/lemma_content/configModule/zhixin/zhixin_1c34583.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/lemma_content/configModule/microBlog/microBlog_75f0224.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/feature/enterprise/creditModule/creditModule_83cd8e5.css" />
<link rel="stylesheet" type="text/css"
	href="http://baike.bdimg.com/static/wiki-lemma/widget/tools/searchHeader/searchHeader_e786bfb.css" />
</head>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	padding-top: 70px;
	padding-bottom: 30px;
}

.theme-dropdown .dropdown-menu {
	position: static;
	display: block;
	margin-bottom: 20px;
}

.theme-showcase>p>.btn {
	margin: 5px 0;
}

.theme-showcase .navbar .container {
	width: auto;
}
</style>
</head>
<body role="document">
	 <!-- navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index">Spider</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="index">主页</a></li>
            <li><a href="about">关于</a></li>
          </ul>
          <form class="navbar-form navbar-right" action="crawler" role="form">
            <div class="form-group">
              <input type="text" required="true" placeholder="姓名" name="name" class="form-control">
              <input type="text" required="true" placeholder="专业" name="major" class="form-control">
              <input type="text" required="true" placeholder="大学" name="college" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">搜索</button>
          </form>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

	<!-- container -->
	<div class="container" role="main">
		${introduce }
	</div>
</body>
		</html>




	</div>

</body>
</html>
