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

<c:set var="type_large" value="listCust"/>
<%@ include file="./_largeNavbar.jsp" %>

<div class="modal fade" id="mainModal" tabindex="-1" role="dialog" aria-labelledby="mainModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="mainModalLabel">Внесіть інформацію по аккаунту: </h4>
            </div>
            <div class="modal-body">
                <form method="GET" id="formx" action="javascript:void(null);" onsubmit="call()">
                    <input id="account" name="acc"  type="hidden">
                    <input name="type" value="1" type="hidden">
                    <input name="onhold" value="0"  type="hidden">
                    <input name="staff" value="<%= request.getUserPrincipal().getName() %>" type="hidden">
                    <!-- acc, type, staff,rate,comm -->
                    <div class="form-group">
                        <div id = "radioGroup">
                            <label class="radio-inline"><input type="radio" name="rate" value="1">1</label>
                            <label class="radio-inline"><input type="radio" name="rate" value="2">2</label>
                            <label class="radio-inline"><input type="radio" name="rate" value="3">3</label>
                            <label class="radio-inline"><input type="radio" name="rate" value="4">4</label>
                            <label class="radio-inline"><input type="radio" name="rate" value="5">5</label>
                            <label class="radio-inline"><input type="radio" name="rate" value="6">6</label>
                            <label class="radio-inline"><input type="radio" name="rate" value="7">7</label>
                            <label class="radio-inline"><input type="radio" name="rate" value="8">8</label>
                            <label class="radio-inline"><input type="radio" name="rate" value="9">9</label>
                            <label class="radio-inline"><input type="radio" name="rate" value="10">10</label>
                            <label class="radio-inline"><input type="radio" name="rate" value="-1">Відкласти</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">Коментар:</label>
                        <textarea class="form-control" name="comm" id="message-text"></textarea>
                        <br/>
                        <select id="pattern1">
                            <option selected disabled>Выбрать</option>
                            <option>Все хорошо</option>
                            <option>Нормально</option>
                            <option>Средне</option>
                            <option>Плохо</option>
                            <option>Нет ответа</option>
                            <option>Нет номера</option>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрити</button>
                        <button type="submit" class="btn btn-primary">Зберегти</button>
                    </div>
                </form>
            </div>
        </div>
        </div>
    </div>
</div>

<div class="container">
    <!-- left, vertical navbar & content -->

    <div class="row">
        <!-- left, vertical navbar -->

        <c:set var="type" value="new"/>
        <%@ include file="./_leftNavbarNew.jsp" %>

        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h1>Список нових клієнтів</h1>
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
                            <th>Тел. Домашній</th>
                            <th>Тел. Робочий</th>
                            <th>Тел. Мобільний</th>
                            <th>Дія</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cust" items="${listCustomer}" varStatus="status">
                            <tr  id="${cust.accountnumber}">
                                <td>${status.index + 1}</td>
                                <td><a href="../accounting/${cust.accountnumber}">${cust.accountnumber}</a></td>
                                <td>${cust.accountname}</td>
                                <td>${cust.bs}</td>
                                <td>${cust.phoneHome}</td>
                                <td>${cust.phoneOffice}</td>
                                <td>${cust.phoneMobile}</td>
                                <td><button type="button" class="btn btn-sm btn-success" data-toggle="modal" data-target="#mainModal" data-whatever="${cust.accountnumber}">Зберегти</button>

                                </td>
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