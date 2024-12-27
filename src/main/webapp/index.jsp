
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>site de ecommerce</title>
</head>
<jsp:include page="eshopPublic/header.jsp"></jsp:include>
<!-- Bannière d'accueil -->
<div class="jumbotron jumbotron-fluid text-center bg-light">
    <div class="container">
        <h1 class="display-4">Bienvenue sur notre Boutique en ligne</h1>
        <p class="lead">Découvrez nos derniers models en tissu pagne.</p>
        
    </div>
</div>

<!-- Liste des produits -->
<div class="container">

   
        <div class="row g-3">
    <%
			//recuperer les données de ma requete
			org.json.JSONArray products =(org.json.JSONArray) getServletContext().getAttribute("products");
    System.out.println("valeur du contexte :"+getServletContext().getAttribute("products"));
			if(products==null){
				out.println("<li>Aucun Produit trouvé</li>");
			}else{
				for(int i=0;i<4;i++){
					//Recuperer le personnage 
					org.json.JSONObject product =products.getJSONObject(i);
					//out.println("<li><a href=DetailProduitServlet?idProduit="+product.getInt("id")+">"+film.getString("titre")+"</a></li>");
					%>
       
         <div class="col-3 d-flex align-items-stretch"> <!-- 3 colonnes sur écrans moyens+ -->
            <div class="card w-200">
              
                <img src="images/<%=product.getString("image")%>" class="card-img-top img-fluid" style="height: 200px; object-fit: cover;" alt="<%= product.getString("nom") %>">

                <div class="card-body text-center d-flex flex-column justify-content-between">
                   
                    <h6 class="card-title text-truncate" ><%= product.getString("nom") %></h6>

                  
                    <p class="card-text" style="font-size: 1.2rem; color: #28a745;"><%= product.getDouble("prix") %> €</p>

                  
                   
                    <a href="#" class="btn btn-outline-success btn-sm">Voir Détails</a>
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
<div class="bg-light py-5">
    <div class="container">
        <h4 class="text-center">Ce que disent nos clients</h4>
        <div class="row">
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>“Un excellent service, les produits sont de grande qualité !”</p>
                    <footer class="blockquote-footer">Marie, Mons</footer>
                </blockquote>
            </div>
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>“Livraison rapide et support client réactif. Très satisfait !”</p>
                    <footer class="blockquote-footer">Ahmed, Brussel</footer>
                </blockquote>
            </div>
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>“Je recommande à 100%, merci pour les réductions !”</p>
                    <footer class="blockquote-footer">Sophia, Tournai</footer>
                </blockquote>
            </div>
        </div>
    </div>
</div>
 <div class="py-4">
    <div class="container text-center">
        <p>Besoin d'aide ? Contactez-nous :</p>
        <p>Email : support@ecshop.com | Téléphone : +32 1 23 45 67 89</p>
        <div class="d-flex justify-content-center">
            <a href="#" class="text-white me-3"><i class="bi bi-facebook"></i></a>
            <a href="#" class="text-white me-3"><i class="bi bi-twitter"></i></a>
            <a href="#" class="text-white"><i class="bi bi-instagram"></i></a>
        </div>
    </div>
</div>


<jsp:include page="eshopPublic/footer.jsp" ></jsp:include>

</html>
