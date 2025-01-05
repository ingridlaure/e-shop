<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="metier.Product" %>
    <%@ page import="metier.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail produit</title>
</head>
<body>
<%
   HttpSession sess = request.getSession(false);
                    User user = (sess!= null) ? (User) sess.getAttribute("user") : null;

                    if (user == null ||  "USER".equals(user.getRole())) {
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
    <h1 class="text-center mb-4">Détails du Produit</h1>
    

    <%

        org.json.JSONObject product = (org.json.JSONObject) request.getAttribute("productDetails");
    %>

    <div class="card">
        <div class="row g-0">
            <div class="col-md-4">
                <img src="<%= request.getContextPath() %>/images/<%= product.getString("image") %>" 
                     class="img-fluid rounded-start" alt="<%= product.getString("nom") %>">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h3 class="card-title"><%= product.getString("nom") %></h3>
                    <p class="card-text"><strong>Description :</strong> <%= product.getString("description") %></p>
                    <p class="card-text"><strong>Prix :</strong> € <%= product.getDouble("prix") %></p>
                    <p class="card-text"><strong>Stock Disponible :</strong> <%= product.getInt("stock") %> unités</p>
                </div>
            </div>
        </div>
    </div>

 
    <div class="text-center mt-4">
        <form action="<%= request.getContextPath() %>/AddToCartServlet" method="post">
        <input type="hidden" name="productId" value="<%= product.getInt("id") %>">
		                <input type="hidden" name="productName" value="<%= product.getString("nom") %>">
		                <input type="hidden" name="productPrice" value="<%= product.getDouble("prix") %>">
		                <input type="hidden" name="productImage" value="<%= product.getString("image") %>">
		                <div class="input-group">
		                    <input type="number" name="productQuantity" value="1" min="1" class="form-control" style="max-width: 70px;">
		                    
		                    <button type="submit" class="btn btn-success btn-sm"><i class="bi bi-plus"></i><i class="bi bi-cart"></i> Ajouter</button>

		                </div>
        </form>
    </div>


    <div class="text-center mt-3">
    <% 
                    if (user == null || "USER".equals(user.getRole())) {
                %>
                <a href="<%= request.getContextPath() %>/eshopPublic/products.jsp" class="btn btn-secondary mt-3">Continuer mes achats</a>
                    
                <%
                    } else{
                    	%>
                    	<a href="<%= request.getContextPath() %>/eshopAdmin/productsManager.jsp" class="btn btn-secondary mt-3">retour aux produits</a>
                    	
                    	<% 
                    }
                %>
       
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>