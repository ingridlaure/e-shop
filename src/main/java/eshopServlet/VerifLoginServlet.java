package eshopServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.User;

import java.io.IOException;

import dao.UserDao;

@WebServlet("/VerifLoginServlet")
public class VerifLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userDAO = new UserDao();
		// Valider les informations utilisateur
		User user = userDAO.verifUser(username, password);

		if (user != null) {
			// Créer une session pour l'utilisateur
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// Rediriger en fonction du rôle
			if ("ADMIN".equals(user.getRole())) {
				response.sendRedirect(request.getContextPath() + "/eshopAdmin/homeAdmin.jsp");
			} else {

				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
		} else {
			// Rediriger vers la page de connexion avec un message d'erreur
			request.setAttribute("errorMessage", "Identifiants invalides !");
			System.out.println(request.getContextPath() + "/eshopPublic/login.jsp");
			request.getRequestDispatcher("/eshopPublic/login.jsp").forward(request, response);

		}
	}

}
