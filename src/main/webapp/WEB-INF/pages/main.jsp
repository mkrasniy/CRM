<%--
  Created by IntelliJ IDEA.
  User: MKrasnyi
  Date: 28.04.2016
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Головна сторынка</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/res/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/res/bootstrap-theme.min.css">

    <!-- Bootstrap Admin Theme -->
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/res/bootstrap-admin-theme.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/res/bootstrap-admin-theme-change-size.css">

    <!-- Datatables -->

    <!-- My -->
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/res/my.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/html5shiv.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/respond.min.js"></script>
    <![endif]-->
</head>
<body class="bootstrap-admin-with-small-navbar">
<!-- small navbar -->
<%@ include file="./_smallNavbar.jsp" %>

<!-- main / large navbar -->
<c:set var="type_large" value="main"/>
<%@ include file="./_largeNavbar.jsp" %>

<div class="container">
    <!-- left, vertical navbar & content -->
    <div class="row">
        <!-- content -->
        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header bootstrap-admin-content-title">
                        <h1>Welcome</h1>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/bootstrap-admin-theme-change-size.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/my.js"></script>
</body>
</html>