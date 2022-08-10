<%-- 
    Document   : products
    Created on : 2 Aug 2022, 09:50:37
    Author     : kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 id="hello">Hello world</h1>
<table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Image</th>
        <th>Price</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody id="adminProd">
        
    </tbody>
    
    <script src="<c:url value="/js/product.js" />"></script>
    <script>
        <c:url value="/api/products" var="endpoint"/>
        
        window.onload = function(){
            loadProduct('${endpoint}');
        }
    </script>
</table>