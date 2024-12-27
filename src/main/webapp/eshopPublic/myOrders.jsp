
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="metier.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Mes Commandes - eCommerce</title>
  
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>


<jsp:include page="header.jsp"></jsp:include>

<div class="container my-5">
    <h2 class="text-center mb-4">Mes Commandes</h2>
    <div class="row">
    <% 
    		org.json.JSONArray orders =(org.json.JSONArray) request.getAttribute("ordersUser");
    HttpSession sess = request.getSession(false);
    User user = (sess!= null) ? (User) sess.getAttribute("user") : null;
    System.out.println("valeur de ordersuser :"+request.getAttribute("ordersUser"));
			if(orders==null || user==null){
				out.println("<li>Vous n'avez pas de commande</li>");
			}else{
    %>
        <div class="col-md-12">
            <table class="table table-hover">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Numéro de Commande</th>
                    <th scope="col">Date</th>
                    <th scope="col">Total</th>
                    <th scope="col">Statut</th>
                    <th scope="col">Détails</th>
                </tr>
                </thead>
                <tbody>
              
                   <%
			//recuperer les données de ma requete
				
				for(int i=0;i<orders.length();i++){
				
					org.json.JSONObject order =orders.getJSONObject(i);
					long timestamp = order.getLong("dateCommande"); // Récupération du timestamp
				 	Date dateCommande = new Date(timestamp);
				    String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(dateCommande);
					
					
					%>
                <tr>
                    <td>#<%= order.getInt("id") %></td>
                    <td><%= formattedDate  %></td>
    				 <td>€ <%= order.getDouble("total")%></td>
                    <td>
			         <% 
			        String statut = order.optString("statut"); 
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
                    <td><a href="<%= request.getContextPath() %>/GetOrdersDetailServlet?idOrder=<%= order.getInt("id") %>"class="btn btn-primary btn-sm">Voir</a></td>
                </tr>
                		<%
					
				}
			}
			%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" ></jsp:include>

</html>


