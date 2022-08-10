<%-- 
    Document   : index
    Created on : 12 Jul 2022, 13:49:18
    Author     : kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="<c:url value="/css/style.css" />"/>
        <title><fmt:message key="label.title"/></title>
    </head>
    <body>
        <div class="container">
          <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
          </ul>
          <ul>
	</ul>
       
          <div class="row">
                <c:forEach items="${products}" var="p">
                    <c:url value="/${p.id}" var="productId"/>
                    <div class="col-sm-12 col-12 col-lg-3">
                        <div class="card">
                            <img class="card-img-top" src="data:image/jpg;base64,${p.image}" alt="${p.name}">
                            <div class="card-body">
                              <h4 class="card-title">${p.name}</h4>
                              <p class="card-text">${p.price} VND</p>
                              <a href="${productId}" class="btn btn-primary">Xem chi tiết</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
          </div> 
        </div>
    </body>
</html>
