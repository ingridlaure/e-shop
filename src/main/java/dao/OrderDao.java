package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnection.DatabaseConnection;
import metier.CartItem;
import metier.Order;


public class OrderDao {
	Connection dbConnect;

	public OrderDao() {
		dbConnect = DatabaseConnection.getConnection();
		if (dbConnect == null) {
			System.err.println("erreur de connexion");
			System.exit(1);
		}
	}

	
	public Boolean addOrder(Order order) {
		String query = "insert into ESHOP_ORDER (utilisateur_id,total,statut) VALUES(?,?,?)";
		try (PreparedStatement pstm1 = dbConnect.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS)) {
			pstm1.setInt(1, order.getUtilisateur().getId());
			pstm1.setDouble(2, order.getTotal());
			pstm1.setString(3, "EN TRAITEMENT");
			pstm1.executeUpdate();
			ResultSet rs2 = pstm1.getGeneratedKeys();
			rs2.next();
			int orderId = rs2.getInt(1);
			
			for( CartItem item: order.getOrderItems())
			{
			String query5 = "INSERT INTO ESHOP_COMMANDE_ITEM (commande_id, produit_id, quantite, priX) VALUES (?, ?, ?, ?)";
            try( PreparedStatement ps5 = dbConnect.prepareStatement(query5)){
            ps5.setInt(1, orderId);
            ps5.setInt(2, item.getProduit().getId());
            ps5.setInt(3, item.getQuantite());
            ps5.setDouble(4, item.getPrice());
            ps5.executeUpdate();
            
            }catch (SQLException e) {
				System.out.println("erreur :" + e);
			}
			}
			return true;
			

		} catch (SQLException e) {
			System.err.println("erreur sql :" + e);
			return false;
		}
	}
}
