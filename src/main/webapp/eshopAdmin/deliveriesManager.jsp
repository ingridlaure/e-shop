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
    <div class="container my-5">
        <h1 class="text-center mb-4">Gestion des Livraisons</h1>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID Livraison</th>
                    <th>ID Commande</th>
                    <th>Adresse de Livraison</th>
                    <th>Statut</th>
                    <th>Date livraison estimee</th>
                    <th>Date livraison Reelle</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
               <% //recuperer les données de mon contexte
			org.json.JSONArray deliveries =(org.json.JSONArray) getServletContext().getAttribute("deliveries");
                System.out.println("valeur des livraisons:"+getServletContext().getAttribute("deliveries"));
			if(deliveries==null){
				out.println("<li>Aucune livraison trouvées</li>");
			}else{
				for(int i=0;i<deliveries.length();i++){
					
					org.json.JSONObject delivery =deliveries.getJSONObject(i);
					org.json.JSONObject commande= delivery.getJSONObject("commande");
					
		              long timestamp1 = delivery.optLong("dateLivraisonEstimee", 0);
		              String formattedDate1 = timestamp1 > 0? new SimpleDateFormat("dd/MM/yyyy").format(new Date(timestamp1)) : "Non défini";

		           
		              long timestamp2 = delivery.optLong("dateLivraisonReelle", 0);
		              String formattedDate2 = timestamp2 > 0 ? new SimpleDateFormat("dd/MM/yyyy").format(new Date(timestamp2)) : "Non défini";
					%>
                <tr>
                	<td><%= delivery.getInt("id")%></td>
                    <td><%= commande.getInt("id")%></td>
                    <td><%= commande.getString("deliveryAddress")%></td>
                      <td>
                       <% 
						        String statut = delivery.getString("statut");
                      			 String badgeClass = "badge ";
						        
						        if ("LIVREE".equals(statut)) {
						            badgeClass += "bg-success"; 
						       
						        } else {
						            badgeClass += "bg-warning"; 
						        }%>
                        <span class="<%= badgeClass%>"><%= statut %></span>
                    </td>
                    <td><%= formattedDate1 %></td>
                    <td><%= formattedDate2 %></td>
                    <td>
                       <% if ("EN COURS".equals(delivery.getString("statut"))) { %>
				            <form action="<%= request.getContextPath() %>/DeliveryServlet" method="post">
				                <input type="hidden" name="action" value="livrer">
				                <input type="hidden" name="livraisonId" value="<%= delivery.getInt("id") %>">
				                 <input type="hidden" name="commandeId" value="<%= commande.getInt("id") %>">
				                <button type="submit" class="btn btn-warning btn-sm">livrer</button>
				            </form>
				        <% } else if ("LIVREE".equals(delivery.getString("statut"))) { %>
				            <span class="badge text-secondary">Livrée</span>
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