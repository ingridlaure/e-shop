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
                <!-- Exemple de commande -->
                <tr>
                    <td>101</td>
                    <td>Jean Dupont</td>
                    <td>2024-11-28</td>
                    <td>120,50 €</td>
                    <td>
                        <span class="badge bg-warning">En cours</span>
                    </td>
                    <td>
                        <button class="btn btn-primary btn-sm">Détails</button>
                        <button class="btn btn-success btn-sm">Marquer comme Livré</button>
                    </td>
                </tr>
                <!-- Plus de commandes dynamiques ici -->
            </tbody>
        </table>
    </div>

   

<jsp:include page="footerAdmin.jsp"></jsp:include>
</body>
</html>