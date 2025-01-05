<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des produits - eshop</title>
</head>
<body>
<jsp:include page="headerAdmin.jsp"></jsp:include>

    <div class="container my-5">
        <h1 class="text-center mb-4">Gestion des Produits</h1>

        <div class="d-flex justify-content-end mb-3">
           <a class="btn btn-success" href="<%= request.getContextPath() %>/eshopAdmin/addProduct.jsp" role="button"><i class="bi bi-plus"></i>Ajouter un produit</a>
        </div>

       >
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
					org.json.JSONObject product =products.getJSONObject(i);

					%>
               
                <tr>
                    <td><%= product.getString("nom") %></td>
                    <td><%= product.getString("description") %></td>
                    <td><%= product.getDouble("prix") %></td>
                    <td><%= product.getInt("stock") %></td>
                    <td> 
                        <a href="<%= request.getContextPath() %>/GetProductDetailServlet?idProduct=<%= product.getInt("id") %>" class="btn btn-success btn-sm">
                        <i class="bi bi-eye"></i>
			    </a>
				<a href="<%= request.getContextPath() %>/EditProductServlet?id=<%= product.getInt("id") %>" class="btn btn-primary btn-sm">
			        <i class="bi bi-pencil"></i>
			    </a>
			    <form action="<%= request.getContextPath() %>/DeleteProductServlet" method="post" style="display:inline;">
			        <input type="hidden" name="id" value="<%= product.getInt("id") %>">
			        <button type="submit" class="btn btn-danger btn-sm">
			            <i class="bi bi-trash"></i>
			        </button>
		        </form>
                    </td>
                </tr>
                			<%
				}
			}
			%>
            </tbody>
        </table>
    </div>

   

   

<jsp:include page="footerAdmin.jsp"></jsp:include>
</body>
</html>