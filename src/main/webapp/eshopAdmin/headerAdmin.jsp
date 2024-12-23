<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="metier.User" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administration - e-shop</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">e-shop administration</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="<%= request.getContextPath() %>/eshopAdmin/homeAdmin.jsp">Accueil</a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/eshopAdmin/productsManager.jsp">Gestion des Produit</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/eshopAdmin/ordersManager.jsp">Gestion des Commandes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/eshopAdmin/deliveriesManager.jsp">Gestion des Livraisons</a>
                    </li>
                     <%
                    // Récupérer l'utilisateur depuis la session
                    HttpSession sess = request.getSession(false);
                    User user = (sess!= null) ? (User) sess.getAttribute("user") : null;

                    if (user != null) {
                %>
                    <li class="nav-item">
                        <a class="nav-link fw-bold text-warning"> <%= user.getPrenom() +" " +user.getNom() %></a>
                    </li> 
                    <li class="nav-item">
                        <a class="nav-link fw-bold" href="<%= request.getContextPath() %>/eshopPublic/logout.jsp">Se déconnecter</a>
                    </li>
                <%
                    }
                %>
            
            
            
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>