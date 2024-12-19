<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="headerAdmin.jsp"></jsp:include>
 <!-- Contenu principal -->
    <div class="container my-5">
        <h1 class="text-center mb-4">Gestion des Produits</h1>

        <!-- Bouton pour ajouter un produit -->
        <div class="d-flex justify-content-end mb-3">
           <a class="btn btn-success" href="<%= request.getContextPath() %>/eshopAdmin/addProduct.jsp" role="button"><i class="bi bi-plus"></i>Ajouter un produit</a>
        </div>

        <!-- Table des produits -->
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
             
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Prix</th>
                    <th>Stock</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <%
			//recuperer les données de ma requete
			org.json.JSONArray products =(org.json.JSONArray) getServletContext().getAttribute("products");
			if(products==null){
				out.println("<li>Aucun Produit trouvé</li>");
			}else{
				for(int i=0;i<products.length();i++){
					//Recuperer le personnage 
					org.json.JSONObject product =products.getJSONObject(i);
					//out.println("<li><a href=DetailProduitServlet?idProduit="+product.getInt("id")+">"+film.getString("titre")+"</a></li>");
					%>
               
                <tr>
                    <td><%= product.getString("nom") %></td>
                    <td><%= product.getString("description") %></td>
                    <td><%= product.getDouble("prix") %></td>
                    <td><%= product.getInt("stock") %></td>
                    <td>
                        <!-- <a class="btn btn-success" href="updateProduct.jsp" role="button"><i class="bi bi-pencil"></i></a> -->

                         <button class="btn btn-success btn-sm"><i class="bi bi-pencil"></i></button>
                         <button class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></button>
                    </td>
                </tr>
                			<%
				}
			}
			%>
                <!-- Produits dynamiques ici -->
            </tbody>
        </table>
    </div>

   

   

<jsp:include page="footerAdmin.jsp"></jsp:include>
</body>
</html>