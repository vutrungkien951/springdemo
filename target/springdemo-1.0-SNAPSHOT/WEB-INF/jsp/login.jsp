<%-- 
    Document   : login
    Created on : 17 Aug 2022, 15:46:56
    Author     : kien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--<title><fmt:message key="label.login"/></title>-->
<h1 class="text-center text-danger"><fmt:message key="label.login" /></h1>
<c:url value="/login" var="action"/>
<form action="${action}" method="post" >
    <div class="form-group">
        <label for="usernameId">
            Username
        </label>
        <input name="username" id="usernameId" class="form-control" />
    </div>
    <div class="form-group">
        <label for="passwordId">
            Password
        </label>
        <input id="passwordId" name="password" 
               class="form-control" type="password" />
    </div>
    <div class="form-group">
        <button class="pull-right" type="submit">
            Submit
        </button>
    </div>
</form>