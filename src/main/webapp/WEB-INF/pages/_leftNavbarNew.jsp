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
        <li class="<c:if test="${type!='new'}">in</c:if>active">
            <a href="${pageContext.request.contextPath}/admin/listCustomers"><i class="glyphicon glyphicon-chevron-right"></i> Нові абоненти</a>
        </li>
        <li class="<c:if test="${type!='ten'}">in</c:if>active">
            <a href="${pageContext.request.contextPath}/admin/listCustomersTen"><i class="glyphicon glyphicon-chevron-right"></i> Абоненти 10д.</a>
        </li>
        <li class="<c:if test="${type!='history'}">in</c:if>active">
            <a href="${pageContext.request.contextPath}/admin/listCustomersHistory/1"><i class="glyphicon glyphicon-chevron-right"></i> Історія</a><!-- calendar.html -->
        </li>
        <li class="<c:if test="${type!='hold'}">in</c:if>active">
            <a href="${pageContext.request.contextPath}/admin/listCustomersOnHold/1"><i class="glyphicon glyphicon-chevron-right"></i> Відкладено</a><!-- calendar.html -->
        </li>
    </ul>
</div>