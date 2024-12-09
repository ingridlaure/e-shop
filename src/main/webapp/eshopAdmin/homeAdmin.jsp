<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administration - Mon Site E-commerce</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="headerAdmin.jsp"></jsp:include>
   
    <!-- Contenu principal -->
    <div class="container my-5">
        <h1 class="text-center mb-4">Bienvenue, Administrateur</h1>
        <p class="text-center">Utilisez la barre de navigation pour accéder aux sections de gestion.</p>

        <!-- Statistiques principales -->
        <div class="row text-center">
            <div class="col-md-4">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">Produits</h5>
                        <p class="card-text fs-1 text-primary">120</p>
                        <a href="productsManager.jsp" class="btn btn-outline-primary">Gérer les Produits</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">Commandes</h5>
                        <p class="card-text fs-1 text-success">45</p>
                        <a href="ordersManager.jsp" class="btn btn-outline-success">Gérer les Commandes</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">Livraisons</h5>
                        <p class="card-text fs-1 text-warning">15</p>
                        <a href="deliveriesManager.jsp" class="btn btn-outline-warning">Gérer les Livraisons</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="footerAdmin.jsp"></jsp:include>
    
</body>
</html>


    