package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dbConnection.DatabaseConnection;

import metier.User;

public class UserDao {

	Connection dbConnect;

	public UserDao() {
		dbConnect = DatabaseConnection.getConnection();
		if (dbConnect == null) {
			System.err.println("erreur de connexion");
			System.exit(1);
		}
	}

	public Boolean addUser(User user) {
		String query1 = "select * from ESHOP_UTILISATEUR where email=?";
		try (PreparedStatement pstm = dbConnect.prepareStatement(query1)) {
			pstm.setString(1, user.getEmail());
			ResultSet rs = pstm.executeQuery();
			if (!rs.next()) {
				String query = "insert into ESHOP_UTILISATEUR (email,password,role,nom,prenom,adresse) VALUES(?,?,?,?,?,?)";
				try (PreparedStatement pstm1 = dbConnect.prepareStatement(query)) {
					pstm1.setString(1, user.getEmail());
					pstm1.setString(2, user.getPassword());
					pstm1.setString(3, user.getRole());
					pstm1.setString(4, user.getNom());
					pstm1.setString(5, user.getPrenom());
					pstm1.setString(6, user.getAdresse());
					int n = pstm1.executeUpdate();
					if (n == 1) {
						return true;
					} else {
						System.err.println("record introuvable");
						return false;
					}

				} catch (SQLException e) {
					System.err.println("erreur sql :" + e);
					return false;
				}
			}

			else {
				System.err.println("record deja existant");
				return false;
			}
		} catch (SQLException e) {
			System.err.println("erreur sql :" + e);
			return false;
		}

	}

	public User getUser(int index) {
		User user = new User();
		String query = "select * from ESHOP_UTILISATEUR where ID=?";
		try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
			pstm.setInt(1, index);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String email = rs.getString(2);
				String password = rs.getString(3);
				String role = rs.getString(4);
				String nom = rs.getString(5);
				String prenom = rs.getString(6);
				String adresse = rs.getString(7);
				user = new User(id, email, password, role, nom, prenom, adresse);
			}
			System.out.println(user);
			return user;
		} catch (SQLException e) {
			System.err.println("erreur sql :" + e);
			return null;
		}
	}

	public User verifUser(String email, String password) {
		User user = new User();
		String query = "select * from ESHOP_UTILISATEUR where email=?";
		try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
			pstm.setString(1, email);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				String hashedPassword = rs.getString("password");
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				int id = rs.getInt(1);
				String role = rs.getString(4);
				String nom = rs.getString(5);
				String prenom = rs.getString(6);
				String adresse = rs.getString(7);
				user = new User(id, email, password, role, nom, prenom, adresse);
				System.out.println(user);
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.err.println("erreur sql :" + e);
			return null;

		}

	}
}
