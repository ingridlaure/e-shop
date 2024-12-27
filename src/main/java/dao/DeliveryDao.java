package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DatabaseConnection;
import metier.Delivery;
import metier.Order;

public class DeliveryDao {
	private Connection dbConnect;

    public DeliveryDao() {
        dbConnect = DatabaseConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("Erreur de connexion à la base de données.");
            System.exit(1);
        }
    }
    
    public List<Delivery> getDeliveries(){
    		OrderDao orderDAO= new OrderDao();
    		String query="SELECT * from ESHOP_LIVRAISON order by id desc"; 
    		List<Delivery> deliveries=new ArrayList<>();
    		try(PreparedStatement ps=dbConnect.prepareStatement(query)){
    			ResultSet rs=ps.executeQuery();
    			while(rs.next()) {
    				int deliveryId=rs.getInt("id");
    				String adresseLivraison=rs.getString("adresse_livraison");
    				Date dteEstimee=rs.getDate("date_livraison_estimee");
    				Date dteReelle=rs.getDate("date_livraison_reelle");
    				String statut=rs.getString("statut");
    				int orderId=rs.getInt("commande_id");
    				Order order=new Order();
    				order=orderDAO.getOrderById(orderId);
    				Delivery delivery=new Delivery(deliveryId,order,adresseLivraison,dteEstimee,dteReelle,statut);
    				 deliveries.add(delivery);
    			}
    			
    		} catch (SQLException e) {
    			System.out.println("erreur :" + e);
    			
    		}
    		return deliveries;
    }

    public boolean addLivraison(Delivery delivery) {
    	System.out.println("Dans la requette pour ajouter une livrasion");
        String query = "INSERT INTO ESHOP_LIVRAISON (commande_id,date_livraison_estimee,statut,adresse_livraison) VALUES (?,?,?,?)";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query)) {
            pstm1.setInt(1, delivery.getCommande().getId());
            LocalDate today5=LocalDate.now();
            Date sqlDate=Date.valueOf(today5.plusDays(5));
            pstm1.setDate(2,sqlDate);
            pstm1.setString(3, "EN COURS");
            pstm1.setString(4, delivery.getCommande().getDeliveryAddress());
            
            int n = pstm1.executeUpdate();
			if (n == 1) {
				System.out.println("commande expédié avec success");
				return true;
			} else {
				System.err.println("record introuvable");
				return false;
			}

		} catch (SQLException e) {
			System.err.println("erreur sql de add :" + e);
			return false;
		}
}
    
    public boolean updateLivraisonStatus(int livraisonId, String newStatus) {
        String query = "UPDATE ESHOP_LIVRAISON SET statut = ?, date_livraison_reelle = ? WHERE id = ?";
        try (PreparedStatement pstmt = dbConnect.prepareStatement(query)) {
            pstmt.setString(1, newStatus);
            Date sqlDate=Date.valueOf(LocalDate.now());
            pstmt.setDate(2, sqlDate);
            pstmt.setInt(3, livraisonId);
            int n= pstmt.executeUpdate();
            return n> 0;
        } catch (SQLException e) {
        	System.err.println("erreur sql de update :" + e);
			return false;
        }
    }

    
    
}
