<%-- 
    Document   : register
    Created on : 17 Aug 2022, 15:19:01
    Author     : kien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--<title><fmt:message key="label.register"/></title>-->
<h1 class="text-center text-danger"><fmt:message key="label.register" /></h1>
<c:url value="/register" var="action"/>
<form:form 
    action="${action}"
    method="POST"
    modelAttribute="user">
    <div class="mb-3 mt-3">
        <label for="text" class="form-label">Username:</label>
        <form:input type="text" class="form-control" placeholder="Enter username" path="username" />
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Password:</label>
        <form:input type="password" class="form-control" placeholder="Enter password" path="password" />
    </div>
    <div class="mb-3 mt-3">
        <label for="text" class="form-label">First name:</label>
        <form:input type="text" class="form-control" placeholder="Enter first name" path="firstName" />
    </div>
    <div class="mb-3 mt-3">
        <label for="text" class="form-label">Last name:</label>
        <form:input type="text" class="form-control" placeholder="Enter last name" path="lastName" />
    </div>
    <div class="mb-3 mt-3">
        <label for="text" class="form-label">Email: </label>
        <form:input type="email" class="form-control" placeholder="Enter email" path="email" />
    </div>
    <div class="mb-3 mt-3">
        <label for="text" class="form-label">Phone:</label>
        <form:input type="text" class="form-control" placeholder="Enter phone" path="phone" />
    </div>
    <div class="mb-3 mt-3">
        <label for="text" class="form-label">User role:</label>
        <form:input type="text" class="form-control" placeholder="Enter user role" path="userRole" />
    </div>
    <button type="submit" class="btn btn-primary"><fmt:message key="label.register"/></button>
</form:form> 