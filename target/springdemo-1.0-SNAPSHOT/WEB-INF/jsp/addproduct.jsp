<%-- 
    Document   : addproduct
    Created on : 19 Jul 2022, 13:56:20
    Author     : kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add product</title>
    </head>
    <body>

        <c:url value="/admin/addproduct" var="action" />
        <form:form 
            action="${action}"
            method="POST"
            modelAttribute="product"
            enctype="multipart/form-data"
            >
            <form:errors path="*" element="div class='alert alert-danger'" />
            <h1 class="text-center text-danger">Add product</h1>
            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Name:</label>
                <form:input type="text" class="form-control" path="name" />
                <form:errors path="name" cssClass="text-danger" />
            </div>
            <div class="mb-3 mt-3">
                <label for="categoryId" class="form-label">Category:</label>
                <form:select path="categoryId">
                    <c:forEach items="${categories}" var="c">
                        <form:option value="${c.id}">${c.name}</form:option>
                    </c:forEach>
                </form:select> 
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price:</label>
                <form:input type="currency" class="form-control" path="price"/>
                <form:errors path="price" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label for="image" class="form-label">Image</label>
                <form:input type="file" class="form-control" path="img" />
            </div>
            <button type="submit" class="btn btn-primary">Add product</button>
        </form:form> 
    </body>
</html>
