<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="headerAdmin.jsp"></jsp:include>
<!-- Contenu principal -->
    <div class="container my-5">
        <h1 class="text-center mb-4">Ajouter un Nouveau Produit</h1>

        <!-- Formulaire d'ajout de produit -->
        <form action="AddProductServlet" method="post" enctype="multipart/form-data" class="p-4 border rounded shadow-sm">
            <div class="mb-3">
                <label for="productName" class="form-label">Nom du Produit</label>
                <input type="text" class="form-control" id="productName" name="name" placeholder="Nom du produit" required>
            </div>

            <div class="mb-3">
                <label for="productDescription" class="form-label">Description</label>
                <textarea class="form-control" id="productDescription" name="description" rows="4" placeholder="Description du produit"></textarea>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="productPrice" class="form-label">Prix (€)</label>
                    <input type="number" step="0.01" class="form-control" id="productPrice" name="price" placeholder="Prix du produit" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="productStock" class="form-label">Stock</label>
                    <input type="number" class="form-control" id="productStock" name="stock" placeholder="Quantité en stock" required>
                </div>
            </div>
            <div class="mb-3">
                <label for="productImage" class="form-label">Image du Produit</label>
                <input type="file" class="form-control" id="productImage" name="image" accept="image/*" required>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-success">Ajouter le Produit</button>
                <a href="gestion-produits.jsp" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </div>

<jsp:include page="footerAdmin.jsp"></jsp:include>
</body>
</html>