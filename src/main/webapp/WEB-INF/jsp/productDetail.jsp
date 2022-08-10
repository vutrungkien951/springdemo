<%-- 
    Document   : productDetail.jsp
    Created on : 8 Aug 2022, 20:57:43
    Author     : kien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product ${product.name}</title>
    </head>
    <body>
        <h1 class="text-center text-danger">Product Details</h1>
        <div class="col-md-6 col-sm-12">
            <img class="card-img-top" src="${product.image}" alt="Card image">
            <div class="card-body">
                <h4 class="card-title">${product.name}</h4>
                <p class="card-text"><fmt:formatNumber type="number" maxFractionDigits="3" value="${product.price}"/> VND</p>
                <p class="card-text">${product.description}</p>
            </div>
            <c:url value="/" var="home"/>
            <p class="card-text"><a class="btn btn-primary" href="${home}">Back to list product</a></p>
        </div>
    </body>
</html>
