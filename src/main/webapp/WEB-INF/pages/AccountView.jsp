<%--
  Created by IntelliJ IDEA.
  User: MKrasnyi
  Date: 10.05.2016
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Аккаунт: ${account.ACCOUNTNUMBER}</title>

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

        <c:set var="type" value="acc"/>
        <%@ include file="./_leftNavbarAcc.jsp" %>

        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h3>${account.ACCOUNTNAME} </h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-md-5">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="text-muted bootstrap-admin-box-title">Інформація по акаунту</div>
                                </div>
                                <table class="table table-hover table-bordered table-striped" style="font-size:14px;">
                                    <tbody>

                                        <tr>  <td> <b>Категорія: </b> </td> <td style="text-align:right">${account.BILLINGAREANAME}</td></tr>
                                        <tr>  <td> <b>Номер акаунту:</b> </td> <td style="text-align:right">${account.ACCOUNTNUMBER}</td></tr>
                                        <tr>  <td> <b>Логін:</b> </td> <td style="text-align:right">${account.ACCOUNTUSERNAME}</td></tr>
                                        <tr>  <td> <b>Пароль:</b> </td> <td style="text-align:right">${account.PASSW}</td></tr>
                                        <c:if test="${account.MANAGER!='-'}"><tr>  <td> <b>Менеджер: </b> </td> <td style="text-align:right">${account.MANAGER}</td></tr></c:if>

                                    </tbody>
                                </table>

                            </div>
                        </div>

                        <div class="col-md-7">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="text-muted bootstrap-admin-box-title">BILLING</div>
                                </div>
                                <table class="table table-hover table-bordered table-striped" style="font-size:14px;">
                                    <tbody>

                                    <tr>
                                        <td> <b>Тариф: </b> </td> <td style="text-align:right">
                                        <c:choose>
                                            <c:when test="${account.TECH == 'WiMax'}">${account.SERVICE}</c:when>
                                            <c:otherwise>${account.CANOPY_CHARGE}</c:otherwise>
                                        </c:choose>
                                    </td></tr>
                                    <tr>
                                        <c:choose>
                                            <c:when test="${account.TECH != 'WiMax'}">
                                                <td> <b>CPEID: </b> </td> <td style="text-align:right">${account.CPEID}</td>
                                            </c:when>
                                            <c:when test="${account.RENT!= '-'}">
                                                <td><b>Оренда: </b> </td> <td style="text-align:right">${account.RENT}</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><b>Обладнання: </b> </td> <td style="text-align:right">${account.CPENAME}</td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                    <c:if test="${account.ACTIVATION!='-'}"><tr>  <td> <b>Активація: </b> </td> <td style="text-align:right">${account.ACTIVATION}</td></tr></c:if>
                                    <tr class="<c:if test="${account.AMOUNT>=0 && account.IS_EXP!='true'}">success</c:if><c:if test="${account.AMOUNT<0 || (account.IS_EXP=='true' && account.AMOUNT_NEED>0)}">Danger</c:if>">
                                        <td> <b>Баланс: </b> </td> <td style="text-align:right">${account.AMOUNT}<c:if test="${account.IS_EXP=='true' && account.AMOUNT_NEED>0}"> (${account.AMOUNT_NEED})</c:if></td>
                                    </tr>
                                    <c:choose>
                                        <c:when test="${account.EXP_DATE != '-'}">
                                            <tr class="<c:if test="${account.IS_EXP=='true'}">Danger</c:if><c:if test="${!account.IS_EXP=='true'}">success</c:if>">
                                                <td> <b>Дійсний до: </b> </td> <td style="text-align:right">${account.EXP_DATE}</td>
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr class="<c:if test="${account.ACCOUNTSTATUSNAME!='Active'}">Danger</c:if><c:if test="${account.ACCOUNTSTATUSNAME=='Active'}">success</c:if>">
                                                <td> <b>Статус: </b> </td> <td style="text-align:right">${account.ACCOUNTSTATUSNAME}</td>
                                            </tr>
                                        </c:otherwise>
                                    </c:choose>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="text-muted bootstrap-admin-box-title">Контакти</div>
                                </div>
                                <table class="table table-hover table-bordered table-striped" style="font-size:14px;">
                                    <tbody>

                                    <tr>  <td> <b>Домашній тел.: </b> </td> <td>${account.HPHONENO}</td></tr>
                                    <tr>  <td> <b>Мобільный тел.:</b> </td> <td>${account.MPHONENO}</td></tr>
                                    <tr>  <td> <b>Робочий тел.:</b> </td> <td>${account.OPHONENO}</td></tr>
                                    <tr>  <td> <b>E-mail:</b> </td> <td>${account.EMAILADDRESS}</td></tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-7">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="text-muted bootstrap-admin-box-title">Інше</div>
                                </div>
                                <table class="table table-hover table-bordered table-striped" style="font-size:14px;">
                                    <tbody> <c:if test="${account.STATIC_IP!='-'}"><tr>  <td> <b>Статика: </b> </td> <td style="text-align:right">${account.STATIC_IP}</td></tr></c:if>

                                        <c:if test="${account.USED_TRAF_MBYTES!='-' && account.USED_TRAF_MBYTES!='0 MB'}"><tr>  <td> <b>Трафік: </b> </td> <td style="text-align:right">${account.USED_TRAF_MBYTES}</td></tr></c:if>
                                        <c:if test="${account.REPLY_GROUP!='-'}"><tr>  <td> <b>Пріоритет: </b> </td> <td style="text-align:right">${account.REPLY_GROUP}</td></tr></c:if>
                                        <c:if test="${account.PARENT!='-'}"><tr>  <td> <b>Груповий: </b> </td> <td style="text-align:right">${account.PARENT}</td></tr></c:if>
                                        <c:if test="${account.PREFBS!='-'}"><tr>  <td> <b>БС: </b> </td> <td style="text-align:right">${account.PREFBS}</td></tr></c:if>
                                        <c:if test="${account.MAC!='-'}"><tr>  <td> <b>MAC: </b> </td> <td style="text-align:right">${account.MAC}</td></tr></c:if>
                                        <tr>  <td> <b>Адреса фіз.:</b> </td> <td>${account.PERMANENTADRESS}</td></tr>
                                        <tr>  <td> <b>Адреса юр.:</b> </td> <td>${account.BILLINGADRESS}</td></tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <a href="http://aaalogviewer.intellecom.int/search.php?plogin=${account.ACCOUNTUSERNAME}&mac1=&mac2=&mac3=&mac4=&mac5=&mac6=&date1=${date}&date2=${date}&p_alu=1&p_samsung=1">
                            <button type="button" class="btn btn-lg btn-block btn-default">AAA</button>
                        </a>
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