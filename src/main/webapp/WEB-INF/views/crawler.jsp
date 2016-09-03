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
		<div class="jumbotron">
			<h2>${name }</h2>
			<h3>${college } , ${major }</h3>
			<p>根据名字进行搜索，然后会将符合条件的显示在上面。</p>
		</div>
		${message }
		<c:if test="${peoples.size() > 0 }">
			<c:forEach var="p" items="${peoples }">
				<div class="well">
					<h3>${p.getTitle() }</h3>
					<p>${p.getDescription() }</p>
					<a class="btn btn-link" href="detail?url=${p.getInfoSource()}">查看详细信息</a>
				</div>
			</c:forEach>
		</c:if>
	</div>

</body>
</html>
