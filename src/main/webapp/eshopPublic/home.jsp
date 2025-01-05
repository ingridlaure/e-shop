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
<div class="jumbotron jumbotron-fluid text-center">
    <div class="container">
        <h1 class="display-4">Bienvenue sur eCommerce!</h1>
        <p class="lead">Découvrez nos derniers produits et offres exclusives.</p>
        <a class="btn btn-primary btn-lg" href="#" role="button">Voir les Produits</a>
    </div>
</div>


<div class="container">
    <div class="row">
    <%
			
			org.json.JSONArray products =(org.json.JSONArray) request.getAttribute("products");
			if(products==null){
				out.println("<li>Aucun Produit trouvé</li>");
			}else{
				for(int i=0;i<products.length();i++){
					
					org.json.JSONObject product =products.getJSONObject(i);
					
					%>
        
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