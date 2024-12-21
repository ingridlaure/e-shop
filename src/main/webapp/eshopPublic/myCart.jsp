<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="metier.Cart" %>
<%@ page import="metier.CartItem" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container my-5">
        <h1 class="text-center">Mon Panier</h1>
        <div class="table-responsive">
            <table class="table table-bordered text-center">
                <thead class="thead-light">
                    <tr>
                        <th>Produit</th>
                        <th>Quantité</th>
                        <th>Prix Unitaire</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <%
                Cart cart= (Cart) session.getAttribute("cart");
                if(cart!=null && !cart.getItems().isEmpty()){
                	
                	for(CartItem item:cart.getItems()){
                		
                %>
                
                    <tr>
                        <td>
                        <img src="../images/<%= item.getProduit().getImage() %>" class="card-img-top img-fluid"  style="height: 100px; width: auto; object-fit: contain;"  alt="<%= item.getProduit().getNom() %>"></br>
                        
                        <%=item.getProduit().getNom() %>
                        </td>
                        <td>
                            <%=item.getQuantite() %>
                        </td>
                        <td><%= item.getPrice()%> € </td>
                    
                        <td>
                            <button class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></button>
                        </td>
                    </tr>
                    <% 	}
                	
                } else{
                	%>
                	
                	<tr>
                	<td colspan="4" class="text-center">Votre panier est vide.</td>
                	</tr>
                	
                	<%	
                	}%>
                    
                </tbody>
                <tfoot>
                <% 
                  if (cart != null && !cart.getItems().isEmpty()) {
                %>
                    <tr class="table-light">
                        <td colspan="3" class="text-end fw-bold">Total :</td>
                        <td colspan="2" class="text-start"><%=cart.getTotalPrice() %></td>
                    </tr>
                    <%
                }
                %>
                </tfoot>
            </table>
        </div>
        <!-- Boutons -->
        <div class="d-flex justify-content-between">
            <a href="<%= request.getContextPath() %>/eshopPublic/products.jsp" class="btn btn-secondary">Continuer vos achats</a>
             <% 
                  if (cart != null && !cart.getItems().isEmpty()) {
                %>
            <a href="<%= request.getContextPath() %>/eshopPublic/recapOrder.jsp" class="btn btn-success">Passer la commande</a>
                 <%
                }
                %>
        </div>
    </div>
		
	<jsp:include page="footer.jsp" ></jsp:include>

</body>
</html>