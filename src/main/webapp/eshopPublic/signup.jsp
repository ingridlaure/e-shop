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
	<div class="d-flex justify-content-center align-items-center vh-50">
        <div class="card p-4 shadow" style="width: 100%; max-width: 400px;">
            <h3 class="text-center mb-4">Créer un Compte</h3>
            <!-- Formulaire d'inscription -->
            <form action="<%= request.getContextPath() %>/AddUserServlet"  method="post">
               
                <div class="mb-3">
                    <label for="email" class="form-label">Adresse Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Entrez votre adresse email" required>
                </div>
                 
                <div class="mb-3">
                    <label for="password" class="form-label">Mot de passe</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Entrez un mot de passe sécurisé" required>
                </div>
                <div class="mb-3">
                    <label for="username" class="form-label">Nom</label>
                    <input type="text" class="form-control" id="username" name="lastname" placeholder="Entrez votre nom d'utilisateur" required>
                </div> <div class="mb-3">
                    <label for="username" class="form-label">Prenom</label>
                    <input type="text" class="form-control" id="username" name="firstname" placeholder="Entrez votre nom d'utilisateur" required>
                </div>
                <div class="mb-3">
                    <label for="adress" class="form-label">Adresse</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="Entrez votre adresse" required>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-success" >S'inscrire</button>
                </div>
            </form>
            <div class="mt-3 text-center">
                <p>Vous avez déjà un compte ? <a href="login.jsp">Connectez-vous</a></p>
            </div>
        </div>
    </div>
        

</body>
</html>