<%-- 
    Document   : products
    Created on : 2 Aug 2022, 09:50:37
    Author     : kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-danger">List product</h1>
<div class="spinner-border text-warning" id="myLoading"></div>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Image</th>
        <th>Price</th>
        <th></th>
    </tr>
    <tbody id="adminProd">

    </tbody>
</table>
<script src="<c:url value="/js/product.js" />" />
<script>
    <c:url value="/api/products" var="u" />
    window.onload = function () {
        loadProduct("${u}")
    }
</script>