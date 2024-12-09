<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<!-- Titre de la page -->
    <div class="container my-5">
        <h1 class="text-center mb-4">Tous les Produits</h1>
        
        <!-- Grille des produits -->
        <div class="row">
            <!-- Produit 1 -->
            <div class="col-md-3 mb-4">
                <div class="card h-100">
                    <img src="https://via.placeholder.com/200" class="card-img-top" alt="Produit 1">
                    <div class="card-body text-center">
                        <h5 class="card-title">Produit 1</h5>
                        <p class="card-text text-danger">49,99 €</p>
                        <a href="#" class="btn btn-outline-primary btn-sm">Voir Détails</a>
                        <button class="btn btn-primary btn-sm mt-2">Ajouter au Panier</button>
                    </div>
                </div>
            </div>

            <!-- Produit 2 -->
            <div class="col-md-3 mb-4">
                <div class="card h-100">
                    <img src="https://via.placeholder.com/200" class="card-img-top" alt="Produit 2">
                    <div class="card-body text-center">
                        <h5 class="card-title">Produit 2</h5>
                        <p class="card-text text-danger">59,99 €</p>
                        <a href="#" class="btn btn-outline-primary btn-sm">Voir Détails</a>
                        <button class="btn btn-primary btn-sm mt-2">Ajouter au Panier</button>
                    </div>
                </div>
            </div>

            <!-- Produit 3 -->
            <div class="col-md-3 mb-4">
                <div class="card h-100">
                    <img src="https://via.placeholder.com/200" class="card-img-top" alt="Produit 3">
                    <div class="card-body text-center">
                        <h5 class="card-title">Produit 3</h5>
                        <p class="card-text text-danger">39,99 €</p>
                        <a href="#" class="btn btn-outline-primary btn-sm">Voir Détails</a>
                        <button class="btn btn-primary btn-sm mt-2">Ajouter au Panier</button>
                    </div>
                </div>
            </div>

            <!-- Produit 4 -->
            <div class="col-md-3 mb-4">
                <div class="card h-100">
                    <img src="https://via.placeholder.com/200" class="card-img-top" alt="Produit 4">
                    <div class="card-body text-center">
                        <h5 class="card-title">Produit 4</h5>
                        <p class="card-text text-danger">89,99 €</p>
                        <a href="#" class="btn btn-outline-primary btn-sm">Voir Détails</a>
                        <button class="btn btn-primary btn-sm mt-2">Ajouter au Panier</button>
                    </div>
                </div>
            </div>
        </div>
</div>
<jsp:include page="footer.jsp" ></jsp:include>

</body>
</html>