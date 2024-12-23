<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="metier.Product" %>
    <%@ page import="metier.User" %>
    <%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<% 

 // Récupérer l'utilisateur depuis la session
                    HttpSession sess = request.getSession(false);
                    User user = (sess!= null) ? (User) sess.getAttribute("user") : null;

                    if (user != null && "USER".equals(user.getRole())) {
                %>
                <jsp:include page="header.jsp"></jsp:include>
                    
                <%
                    } else{
                    	%>
                    	<jsp:include page="../eshopAdmin/headerAdmin.jsp"></jsp:include>
                    	
                    	<% 
                    }
                %>
            

<div class="container my-5">
    <h2 class="text-center mb-4">Détails de la Commande</h2>
    <%
        // Récupérer la commande et les articles de la requête
        org.json.JSONObject order = (org.json.JSONObject) request.getAttribute("orderDetails");
        org.json.JSONArray items = order.getJSONArray("orderItems");

        // Récupérer les informations de la commande
        int orderId = order.getInt("id");
        String statut = order.getString("statut");
        String adresseLivraison = order.optString("adresseLivraison", "Non spécifiée");
        double total = order.getDouble("total");
        long timestamp = order.getLong("dateCommande"); // Récupération du timestamp
	 	Date dateCommande = new Date(timestamp);
	    String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(dateCommande);
		
    %>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Commande #<%= orderId %></h5>
            <p class="card-text"><strong>Date :</strong> <%= dateCommande %></p>
            <p class="card-text"><strong>Statut :</strong> <%= statut %></p>
            <p class="card-text"><strong>Adresse de Livraison :</strong> <%= adresseLivraison %></p>
            <p class="card-text"><strong>Total :</strong> € <%= total %></p>
        </div>
    </div>

    <h3 class="mt-4">Articles</h3>
    <table class="table table-hover">
        <thead class="thead-light">
        <tr>
            <th scope="col">Produit</th>
            <th scope="col">Quantité</th>
            <th scope="col">Prix Unitaire</th>
            <th scope="col">Total</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Parcourir les articles de la commande
            for (int i = 0; i < items.length(); i++) {
                org.json.JSONObject item = items.getJSONObject(i);
                org.json.JSONObject produitJson = item.getJSONObject("produit");
                int quantite = item.getInt("quantite");
                double prixUnitaire = item.getDouble("price");
                double totalArticle = quantite * prixUnitaire;
        %>
        <tr>
            <td><img src="../images/<%= produitJson.getString("image") %>" class="card-img-top img-fluid"  style="height: 100px; width: auto; object-fit: contain;" >
            </br>
                        
                        <%=produitJson.getString("nom") %>
            
            </td>
            <td><%= quantite %></td>
            <td>€ <%= prixUnitaire %></td>
            <td>€ <%= totalArticle %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    			<% 
                    if (user != null && "USER".equals(user.getRole())) {
                %>
                <a href="<%= request.getContextPath() %>/eshopPublic/products.jsp" class="btn btn-primary mt-3">Continuer mes achats</a>
                    
                <%
                    } else{
                    	%>
                    	<a href="<%= request.getContextPath() %>/eshopAdmin/ordersManager.jsp" class="btn btn-primary mt-3">retour aux commandes</a>
                    	
                    	<% 
                    }
                %>

    
</div>

<jsp:include page="footer.jsp"></jsp:include>



</body>
</html>