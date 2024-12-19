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
            <h3 class="text-center mb-4">Connexion</h3>
           <%
                            String loginError = (String) request.getAttribute("errorMessage");
                            if (loginError != null) {
                        %>
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                <%= loginError %>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        <%
                            }
                        %>
            <!-- Formulaire de connexion -->
            <form action="<%= request.getContextPath() %>/VerifLoginServlet"  method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Nom d'utilisateur</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Entrez votre nom d'utilisateur" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Mot de passe</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Entrez votre mot de passe" required>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-success">Se connecter</button>
                </div>
            </form>
            <div class="mt-3 text-center">
            
                <p>Vous n'avez pas de compte ? <a href="<%= request.getContextPath() %>/eshopPublic/signup.jsp">Inscrivez-vous</a></p>
            </div>
        </div>
</div>
</body>
</html>