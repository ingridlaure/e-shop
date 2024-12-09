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
        <h1 class="text-center mb-4">Gestion des Produits</h1>

        <!-- Bouton pour ajouter un produit -->
        <div class="d-flex justify-content-end mb-3">
           <a class="btn btn-primary" href="addProduct.jsp" role="button">Ajouter un produit</a>
        </div>

        <!-- Table des produits -->
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Stock</th>
                    <th>Catégorie</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Exemple de produit -->
                <tr>
                    <td>1</td>
                    <td>Produit Exemple</td>
                    <td>49,99 €</td>
                    <td>20</td>
                    <td>Électronique</td>
                    <td>
                        <a class="btn btn-success" href="updateProduct.jsp" role="button">Modifier</a>
                        <button class="btn btn-danger btn-sm">Supprimer</button>
                    </td>
                </tr>
                <!-- Produits dynamiques ici -->
            </tbody>
        </table>
    </div>

   

   

<jsp:include page="footerAdmin.jsp"></jsp:include>
</body>
</html>