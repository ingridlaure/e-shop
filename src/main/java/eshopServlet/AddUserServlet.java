package eshopServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.User;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Dans le post de l'ajout d'un utlisateur");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String address = request.getParameter("address");

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String hashPassword = encoder.encode(password);
		System.out.println(hashPassword);

		User user = new User(email, hashPassword, "USER", lastname, firstname, address);

		try {

			JSONObject userJson = new JSONObject(user);
			HttpClientHelper.send("http://localhost:8081/e-shop/api/users/create", userJson.toString());
			response.sendRedirect(request.getContextPath() + "/eshopPublic/login.jsp");

		} catch (Exception e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}

	}

}
