<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <thead class="table-dark">
                    <tr>
                        <th>Produit</th>
                        <th>Quantité</th>
                        <th>Prix Unitaire</th>
                        <th>Total</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Exemple d'article -->
                    <tr>
                        <td>Produit 1</td>
                        <td>
                            <input type="number" value="1" class="form-control text-center" min="1">
                        </td>
                        <td>15.00€</td>
                        <td>15.00€</td>
                        <td>
                            <button class="btn btn-danger btn-sm">Supprimer</button>
                        </td>
                    </tr>
                    <tr>
                        <td>Produit 2</td>
                        <td>
                            <input type="number" value="2" class="form-control text-center" min="1">
                        </td>
                        <td>25.00€</td>
                        <td>50.00€</td>
                        <td>
                            <button class="btn btn-danger btn-sm">Supprimer</button>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr class="table-light">
                        <td colspan="3" class="text-end fw-bold">Total :</td>
                        <td colspan="2" class="text-start">65.00€</td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <!-- Boutons -->
        <div class="d-flex justify-content-between">
            <a href="#" class="btn btn-secondary">Continuer vos achats</a>
            <a href="#" class="btn btn-success">Passer la commande</a>
        </div>
    </div>
		
	<jsp:include page="footer.jsp" ></jsp:include>

</body>
</html>