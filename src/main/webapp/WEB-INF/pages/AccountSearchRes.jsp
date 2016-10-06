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
    <title>Список клієнтів</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" media="screen" href="../res/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="../res/bootstrap-theme.min.css">

    <!-- Bootstrap Admin Theme -->
    <link rel="stylesheet" media="screen" href="../res/bootstrap-admin-theme.css">
    <link rel="stylesheet" media="screen" href="../res/bootstrap-admin-theme-change-size.css">

    <!-- Datatables -->
    <!--link rel="stylesheet" media="screen" href="../res/DT_bootstrap.css"-->

    <!-- My -->
    <link rel="stylesheet" media="screen" href="../res/my.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../res/html5shiv.js"></script>
    <script type="text/javascript" src="../res/respond.min.js"></script>
    <![endif]-->
</head>
<body class="bootstrap-admin-with-small-navbar">
<!-- small navbar -->
<%@ include file="./_smallNavbar.jsp" %>

<!-- main / large navbar -->

<%@ include file="./_largeNavbar.jsp" %>


<div class="container">
    <!-- left, vertical navbar & content -->

    <div class="row">
        <!-- left, vertical navbar -->


        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h1>Результати пошуку</h1>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Акаунт</th>
                            <th>Ім'я</th>
                            <th>Категорія</th>
                            <th>Активація</th>
                            <th>Статус</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="acc" items="${account}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td><a href="../${acc.ACCOUNTNUMBER}">${acc.ACCOUNTNUMBER}</a></td>
                                <td>${acc.ACCOUNTNAME}</td>
                                <td>${acc.BILLINGAREANAME}</td>
                                <td>${acc.ACTIVATION}</td>
                                <td>${acc.ACCOUNTSTATUSNAME}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../res/bootstrap.min.js"></script>
<script type="text/javascript" src="../res/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="../res/bootstrap-admin-theme-change-size.js"></script>
<script type="text/javascript" src="../res/my.js"></script>
</body>
</html>