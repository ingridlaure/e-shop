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
        <h1 class="text-center mb-4">Gestion des Livraisons</h1>

        <!-- Table des livraisons -->
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID Livraison</th>
                    <th>ID Commande</th>
                    <th>Transporteur</th>
                    <th>Adresse de Livraison</th>
                    <th>Statut</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Exemple de livraison -->
                <tr>
                    <td>501</td>
                    <td>101</td>
                    <td>Transporteur XYZ</td>
                    <td>12 Rue de Paris, 75000, Paris</td>
                    <td>
                        <span class="badge bg-warning">En transit</span>
                    </td>
                    <td>
                        <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#viewDeliveryModal">Détails</button>
                        <button class="btn btn-success btn-sm" onclick="updateDeliveryStatus(501, 'Livré')">Marquer comme Livré</button>
                    </td>
                </tr>
                <!-- Plus de livraisons dynamiques ici -->
            </tbody>
        </table>
    </div>

   
<jsp:include page="footerAdmin.jsp"></jsp:include>
</body>
</html>