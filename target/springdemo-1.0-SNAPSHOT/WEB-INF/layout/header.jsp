<%-- 
    Document   : header
    Created on : 19 Jul 2022, 16:31:59
    Author     : kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">WebSale Online</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <c:url value="/" var="home"/>
                        <a class="nav-link" href="${home}">Trang chủ</a>
                    </li>
                    <c:forEach items="${categories}" var="c">
                        <c:url value="/" var="categoryLink">
                            <c:param name="cateId" value="${c.id}"/>
                        </c:url>
                        <li class="nav-item">
                            <a class="nav-link" href="${categoryLink}">${c.name}</a>
                        </li>
                    </c:forEach>
                    <li class="nav-item"><a class="nav-link" href="?lang=en"><fmt:message key="label.lang.en" /></a></li>
                    <li class="nav-item"><a class="nav-link" href="?lang=vn"><fmt:message key="label.lang.vn" /></a></li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value="/login"/>"><fmt:message key="label.login" /></a></li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value="/register"/>"><fmt:message key="label.register" /></a></li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value="/admin/addproduct"/>">Abc</a></li>
                </ul>
                <c:url value="/" var="action" />
                <form class="d-flex" action="${action}">
                    <input class="form-control me-2" name="kw" type="text" placeholder="<spring:message code="label.search.textbox" />" />
                    <button class="btn btn-primary" type="submit"><spring:message code="label.search" /></button>
                </form>

            </div>
        </div>

    </div>
</nav>
