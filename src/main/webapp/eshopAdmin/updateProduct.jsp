<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mettre à jour un Produit</title>
</head>
<body>
<jsp:include page="headerAdmin.jsp"></jsp:include>

<div class="container my-5">
    <h1 class="text-center mb-4">Modifier Produit</h1>

    <form action="<%= request.getContextPath() %>/UpdateProductServlet" method="post" class="p-4 border rounded shadow-sm">
        <!-- Champ caché pour l'ID du produit -->
        <input type="text" id="id" name="id" value="<%= request.getAttribute("productId") %>">
         <input type="hidden" name="existingImage" value="<%= request.getAttribute("productImage") %>">

        <div class="mb-3">
            <label for="productName" class="form-label">Nom du Produit</label>
            <input type="text" class="form-control" id="productName" name="name" 
                   value="<%= request.getAttribute("productName") %>" required>
        </div>

        <div class="mb-3">
            <label for="productDescription" class="form-label">Description</label>
            <textarea class="form-control" id="productDescription" name="description" rows="4">
                <%= request.getAttribute("productDescription") %>
            </textarea>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="productPrice" class="form-label">Prix (€)</label>
                <input type="number" step="0.01" class="form-control" id="productPrice" name="price" 
                       value="<%= request.getAttribute("productPrice") %>" required>
            </div>
            <div class="col-md-6 mb-3">
                <label for="productStock" class="form-label">Stock</label>
                <input type="number" class="form-control" id="productStock" name="stock" 
                       value="<%= request.getAttribute("productStock") %>" required>
            </div>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-success">Mettre à jour</button>
            <a href="<%= request.getContextPath() %>/ProductListServlet" class="btn btn-secondary">Annuler</a>
        </div>
    </form>
</div>

<jsp:include page="footerAdmin.jsp"></jsp:include>
</body>
</html>