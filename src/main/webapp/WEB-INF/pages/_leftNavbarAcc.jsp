<%--
  Created by IntelliJ IDEA.
  User: MKrasnyi
  Date: 06.05.2016
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- left, vertical navbar -->
<div class="col-md-2 bootstrap-admin-col-left">
    <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
        <li class="<c:if test="${type!='acc'}">in</c:if>active">
            <a href="${pageContext.request.contextPath}/accounting/${acc}"><i class="glyphicon glyphicon-chevron-right"></i> Акаунт</a>
        </li>
        <li class="<c:if test="${type!='saldo'}">in</c:if>active">
            <a href="${pageContext.request.contextPath}/accounting/${acc}/bill_pay"><i class="glyphicon glyphicon-chevron-right"></i> Розрахунки</a>
        </li>
        <li class="<c:if test="${type!='history'}">in</c:if>active">
            <a href="${pageContext.request.contextPath}/accounting/${acc}/history"><i class="glyphicon glyphicon-chevron-right"></i> Історія</a>
        </li>
    </ul>
</div>