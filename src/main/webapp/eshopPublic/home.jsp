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
    <%
			//recuperer les données de ma requete
			org.json.JSONArray products =(org.json.JSONArray) request.getAttribute("products");
			if(products==null){
				out.println("<li>Aucun Produit trouvé</li>");
			}else{
				for(int i=0;i<products.length();i++){
					//Recuperer le personnage 
					org.json.JSONObject product =products.getJSONObject(i);
					//out.println("<li><a href=DetailProduitServlet?idProduit="+product.getInt("id")+">"+film.getString("titre")+"</a></li>");
					%>
        <!-- Produit 1 -->
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="<%= product.getString("image") %>" class="card-img-top" alt="Produit 1">
                <div class="card-body">
                    <h5 class="card-title"><%= product.getString("nom") %></h5>
                    <p class="card-text"><%= product.getDouble("prix") %></p>
                    <a href="#" class="btn btn-success">Ajouter au Panier</a>
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