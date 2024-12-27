<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
        <h1 class="text-center mb-4">Gestion des Commandes</h1>

        <!-- Table des commandes -->
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID Commande</th>
                    <th>Client</th>
                    <th>Date</th>
                    <th>Total</th>
                    <th>Statut</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
			//recuperer les données de mon contexte
			org.json.JSONArray orders =(org.json.JSONArray) getServletContext().getAttribute("orders");
                System.out.println("valeur des orders :"+getServletContext().getAttribute("orders"));
			if(orders==null){
				out.println("<li>Aucune commande trouvé</li>");
			}else{
				for(int i=0;i<orders.length();i++){
					//Recuperer le personnage 
					org.json.JSONObject order =orders.getJSONObject(i);
					org.json.JSONObject user=order.getJSONObject("utilisateur");
					long timestamp = order.getLong("dateCommande"); // Récupération du timestamp
				 	Date dateCommande = new Date(timestamp);
				    String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(dateCommande);
	
				    System.out.println("Date formatée : " + formattedDate);
				
					%>
                <tr>
                    <td>#<%= order.getInt("id")%></td>
                    <td><%= user.getString("nom")%> <%= user.getString("prenom")%></td>
                    <td><%= formattedDate  %></td>
                    <td><%= order.getDouble("total")%> €</td>
                    <td>
                        <% 
			        String statut = order.optString("statut"); // "EN COURS" comme valeur par défaut
			        String badgeClass = "badge ";
			        
			        if ("LIVREE".equals(statut)) {
			            badgeClass += "bg-success"; 
			        } else if ("EXPEDIEE".equals(statut)) {
			            badgeClass += "bg-primary"; 
			        } else {
			            badgeClass += "bg-warning"; 
			        }
			    %>
    					<span class="<%= badgeClass %>"><%= statut %></span>

                    </td>
                    <td>
                        <a href="<%= request.getContextPath() %>/GetOrdersDetailServlet?idOrder=<%= order.getInt("id") %>"class="btn btn-primary btn-sm">Detail</a>
				                        
						<% if ("EN TRAITEMENT".equals(order.getString("statut"))) { %>
				            <form action="<%= request.getContextPath() %>/DeliveryServlet" method="post">
				                <input type="hidden" name="action" value="expedier">
				                <input type="hidden" name="commandeId" value="<%= order.getInt("id") %>">
				                <button type="submit" class="btn btn-warning btn-sm">Expédier</button>
				            </form>
				        <% } else if ("LIVREE".equals(order.getString("statut"))) { %>
				            <span class="badge badge-success">Livrée</span>
				        <% } %>

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