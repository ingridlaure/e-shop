
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>site de ecommerce</title>
</head>
<jsp:include page="eshopPublic/header.jsp"></jsp:include>
<!-- Bannière d'accueil -->
<div class="jumbotron jumbotron-fluid text-center">
    <div class="container">
        <h1 class="display-4">Bienvenue sur eCommerce!</h1>
        <p class="lead">Découvrez nos derniers produits et offres exclusives.</p>
        <a class="btn btn-primary btn-lg" href="#" role="button">Voir les Produits</a>
    </div>
</div>

<!-- Liste des produits -->
<div class="container">
    <div class="row">
        <!-- Produit 1 -->
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="images/product1.jpg" class="card-img-top" alt="Produit 1">
                <div class="card-body">
                    <h5 class="card-title">Produit 1</h5>
                    <p class="card-text">Description du produit 1.</p>
                    <a href="#" class="btn btn-success">Ajouter au Panier</a>
                </div>
            </div>
        </div>
        <!-- Produit 2 -->
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="images/product2.jpg" class="card-img-top" alt="Produit 2">
                <div class="card-body">
                    <h5 class="card-title">Produit 2</h5>
                    <p class="card-text">Description du produit 2.</p>
                    <a href="#" class="btn btn-success">Ajouter au Panier</a>
                </div>
            </div>
        </div>
        <!-- Produit 3 -->
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="images/product3.jpg" class="card-img-top" alt="Produit 3">
                <div class="card-body">
                    <h5 class="card-title">Produit 3</h5>
                    <p class="card-text">Description du produit 3.</p>
                    <a href="#" class="btn btn-success">Ajouter au Panier</a>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="eshopPublic/footer.jsp" ></jsp:include>

</html>
