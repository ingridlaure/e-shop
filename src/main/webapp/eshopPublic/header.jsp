<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="metier.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Accueil - eCommerce</title>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <a class="navbar-brand" href="#">e-shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link fw-bold" href="<%= request.getContextPath() %>/index.jsp">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link fw-bold" href="<%= request.getContextPath() %>/eshopPublic/products.jsp">Produits</a>
            </li>
            <li class="nav-item">
                <a class="nav-link fw-bold" href="<%= request.getContextPath() %>/eshopPublic/myCart.jsp">Panier</a>
            </li>
            <li class="nav-item">
                <a class="nav-link fw-bold" href="<%= request.getContextPath() %>/getOrdersByUserServlet">commandes</a>
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
                    } else {
                %>
            
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/eshopPublic/login.jsp">Connexion</a>
            </li>
            <%} %>
        </ul>
    </div>
</nav>
</body>
</html>

