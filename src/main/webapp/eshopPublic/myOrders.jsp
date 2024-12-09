
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Mes Commandes - eCommerce</title>
    <!-- Importer Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>


<jsp:include page="header.jsp"></jsp:include>
<!-- Mes Commandes -->
<div class="container my-5">
    <h2 class="text-center mb-4">Mes Commandes</h2>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <thead class="thead-light">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Numéro de Commande</th>
                    <th scope="col">Date</th>
                    <th scope="col">Statut</th>
                    <th scope="col">Total</th>
                    <th scope="col">Détails</th>
                </tr>
                </thead>
                <tbody>
                <!-- Exemple de ligne de commande -->
                <tr>
                    <th scope="row">1</th>
                    <td>CMD12345</td>
                    <td>25/11/2024</td>
                    <td>Expédiée</td>
                    <td>€150.00</td>
                    <td><a href="#" class="btn btn-primary btn-sm">Voir</a></td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>CMD12346</td>
                    <td>22/11/2024</td>
                    <td>En cours de traitement</td>
                    <td>€200.00</td>
                    <td><a href="#" class="btn btn-primary btn-sm">Voir</a></td>
                </tr>
                <!-- Fin de l'exemple -->
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" ></jsp:include>

</html>


