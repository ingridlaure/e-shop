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
        <%
			//recuperer les données de ma requete
			org.json.JSONArray products =(org.json.JSONArray) getServletContext().getAttribute("products");
    System.out.println("valeur du contexte :"+getServletContext().getAttribute("products"));
			if(products==null){
				out.println("<li>Aucun Produit trouvé</li>");
			}else{
				for(int i=0;i<products.length();i++){
				
					org.json.JSONObject product =products.getJSONObject(i);
					
					%>
            <div class="col-3 d-flex align-items-stretch"> 
            <div class="card w-200">
              
                <img src="../images/<%=product.getString("image")%>" class="card-img-top img-fluid" style="height: 200px; object-fit: cover;" alt="<%= product.getString("nom") %>">

                <div class="card-body text-center d-flex flex-column justify-content-between">
                   
                    <h6 class="card-title text-truncate" ><%= product.getString("nom") %></h6>

                  
                    <p class="card-text" style="font-size: 1.2rem; color: #28a745;"><%= product.getDouble("prix") %> €</p>

                  
                   
                    <a href="#" class="btn btn-outline-success btn-sm">Voir Détails</a>
                    
                    <!-- Formulaire d'ajout au panier -->
		            <form action="<%= request.getContextPath() %>/AddToCartServlet" method="post" class="mt-2">
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
            </div>
            </div> 
                 			<%
				}
			}
			%>

</div>
</div>
<jsp:include page="footer.jsp" ></jsp:include>

</body>
</html>