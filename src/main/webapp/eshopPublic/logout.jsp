<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
<% 
 if (session != null) {
        session.invalidate();
    }
    // Rediriger vers la page d'accueil
    response.sendRedirect(request.getContextPath() + "/index.jsp");
    %>
</body>
</html>