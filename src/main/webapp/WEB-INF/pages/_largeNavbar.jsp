<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar bootstrap-admin-navbar-under-small" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".main-navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand-my" href="#"><img class="logo" alt="Brand" src="${pageContext.request.contextPath}/res/logo_main.png"></a>
                </div>
                <div class="collapse navbar-collapse ">
                    <ul class="nav navbar-nav">
                        <li class="<c:if test="${type_large!='main'}">in</c:if>active"><a href="${pageContext.request.contextPath}">Головна</a></li>

                        <sec:authorize access="hasRole('ROLE_USER')">
                            <li class="<c:if test="${type_large!='BSInfo'}">in</c:if>active"><a href="${pageContext.request.contextPath}/accounting/BSInfo" target="_blank">БС Інфо</a></li>
                            <li class="<c:if test="${type_large!='cashalot'}">in</c:if>active"><a href="${pageContext.request.contextPath}/accounting/cashalot" target="_blank">Cashalot</a></li>

                        </sec:authorize>

                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-hover="dropdown">Прозвон <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li role="presentation" class="dropdown-header">Оберіть варіант</li>
                                    <li class="<c:if test="${type_large!='listCust'}">in</c:if>active"><a href="${pageContext.request.contextPath}/admin/listCustomers">Клієнти 1д.</a></li>
                                    <li class="<c:if test="${type_large!='listCustTen'}">in</c:if>active"><a href="${pageContext.request.contextPath}/admin/listCustomersTen">Клієнти 10д.</a></li>
                                    <li class="<c:if test="${type_large!='listCustHist'}">in</c:if>active"><a href="${pageContext.request.contextPath}/admin/listCustomersHistory/1">Історія</a></li>
                                    <li class="<c:if test="${type_large!='listCustOnHold'}">in</c:if>active"><a href="${pageContext.request.contextPath}/admin/listCustomersOnHold/1">Відкладено</a></li>
                                </ul>
                            </li>
                        </sec:authorize>
                        <!--li><a href="testkayako.html">Kayako</a></li-->
                    </ul>
                    <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/accounting/search/accountname" role="search">
                        <div class="form-group">
                            <input type="text" name="val" class="form-control" placeholder="Search">
                        </div>
                        <div class="btn-group">
                            <button type="submit" class="btn btn-default">Пошук</button>
                            <button type="submit" data-toggle="dropdown" class="btn btn-default dropdown-toggle">&nbsp<span class="caret"></span>&nbsp</button>
                            <ul class="dropdown-menu">
                                <li><a href="#">Username</a></li>
                                <li><a href="#">Accountname</a></li>
                                <li><a href="#">CPE ID</a></li>
                                <li><a href="#">Договір</a></li>
                                <li><a href="#">Номер телефону</a></li>
                            </ul>
                        </div>
                    </form>
                </div><!-- /.navbar-collapse -->

            </div>
        </div>
    </div><!-- /.container -->
</nav>