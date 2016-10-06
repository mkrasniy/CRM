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
    <title>Історія</title>

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

<c:set var="type_large" value="listCustHist"/>
<%@ include file="./_largeNavbar.jsp" %>


<div class="container">
    <!-- left, vertical navbar & content -->

    <div class="row">
        <!-- left, vertical navbar -->

        <c:set var="type" value="history"/>
        <%@ include file="./_leftNavbarNew.jsp" %>

        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h1>Список оброблених записів</h1>
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
                            <th>Базова станція</th>
                            <th>Оцінка/Днів</th>
                            <th>Коментар</th>
                            <th>Дата</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cust" items="${listCustomer}" varStatus="status">
                            <tr>
                                <td>${cust.rn}</td>
                                <td><a href="${pageContext.request.contextPath}/accounting/${cust.accountnumber}">${cust.accountnumber}</a></td>
                                <td>${cust.accountname}</td>
                                <td>${cust.bs}</td>
                                <td>${cust.rate}/${cust.type}</td>
                                <td>${cust.comm}</td>
                                <td>${cust.dt}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12" style="text-align: center">
                    <div class="pagination-container pagination-container-first" >
                        <ul class="pagination pagination-lg">
                            <c:forEach var="p" items="${Pagins}">
                                <li class="${p.class_}"><a href="${p.h}">${p.val}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../res/bootstrap.min.js"></script>
<script type="text/javascript" src="../res/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="../res/bootstrap-admin-theme-change-size.js"></script>
</body>
</html>