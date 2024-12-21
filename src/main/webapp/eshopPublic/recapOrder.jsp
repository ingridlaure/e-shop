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
<div class="container mt-5">
        <h1 class="text-center">Confirmation de la commande</h1>
        <form action="<%= request.getContextPath() %>/FinalizeOrderServlet" method="POST">
            <h3 class="mt-4">Détails de la livraison</h3>
            <div class="mb-3">
                <label for="deliveryAddress" class="form-label">Adresse de livraison</label>
                <textarea name="deliveryAddress" id="deliveryAddress" class="form-control" rows="3" required></textarea>
            </div>

            <h3 class="mt-4">Méthode de paiement</h3>
            <div class="mb-3">
                <select name="paymentMethod" class="form-select" required>
                    <option value="credit_card">Carte de crédit</option>
                    <option value="paypal">PayPal</option>
                    <option value="cash_on_delivery">Paiement à la livraison</option>
                </select>
            </div>

            <h3 class="mt-4">Récapitulatif du panier</h3>
            <ul class="list-group mb-4">
                <% 
                    Cart cart = (Cart) session.getAttribute("cart");
                    if (cart != null) {
                        for (CartItem item : cart.getItems()) { 
                %>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <%= item.getProduit().getNom() %> (x<%= item.getQuantite() %>)
                    <span><%= item.getPrice() * item.getQuantite() %> €</span>
                </li>
                <% 
                        } 
                    } 
                %>
            </ul>

            <div class="d-flex justify-content-between">
                <h4>Total : <%= cart != null ? cart.getTotalPrice() : 0 %> €</h4>
                <button type="submit" class="btn btn-success">Confirmer la commande</button>
            </div>
        </form>
    </div>
<jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>