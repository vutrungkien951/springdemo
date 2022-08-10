<%-- 
    Document   : stat
    Created on : 8 Aug 2022, 13:32:32
    Author     : kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <title><fmt:message key="stats.title"/></title>
</head>
<h1 class="text-center text-danger">Thong ke san pham</h1>
<div class="row">
    <div class="col-md-6"> 
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Count</th>
            </tr>
            <c:forEach items="${cateStats}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>${c[2]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6">
        <canvas id="myChart"></canvas>
    </div>
</div>
<div class="row">
    <div class="col-md-6">
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Total</th>
            </tr>
            <c:forEach items="${renueve}" var="r">
                <tr>
                    <td>${r[0]}</td>
                    <td>${r[1]}</td>
                    <td><fmt:formatNumber maxFractionDigits="3" type="number" value="${r[2]}" /> VND</td>
                </tr>
            </c:forEach> 
        </table>
    </div>

    <div class="col-md-6">
        <canvas id="myChart2"></canvas>
            <c:url value="/admin/stats" var="action" />
        <form class="d-flex" action="${action}">
            <select class="form-select" name="quarter">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
            </select>
            <input class="form-control me-2" name="year" type="text" placeholder="<spring:message code="stats.year.textbox"/>">
            <button class="btn btn-primary" type="submit"><spring:message code="label.search"/></button>
        </form>
    </div>
</div>
<script src="<c:url value="/js/stats.js" />"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    window.onload = function () {
        let data = [];
        let labels = [];
        let data2 = [];
        let labels2 = [];
    <c:forEach items="${cateStats}" var="c">
        data.push(${c[2]});
        labels.push('${c[1]}');
    </c:forEach>
    <c:forEach items="${renueve}" var="r">
        data2.push(${r[2]});
        labels2.push('${r[1]}');
    </c:forEach>
        abc(data, labels);
        abc1(data2, labels2);
    }
</script>

