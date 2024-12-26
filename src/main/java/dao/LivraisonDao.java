package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import dbConnection.DatabaseConnection;

public class LivraisonDao {
	private Connection dbConnect;

    public LivraisonDao() {
        dbConnect = DatabaseConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("Erreur de connexion à la base de données.");
            System.exit(1);
        }
    }

    public boolean addLivraison(int commandeId) {
        String query = "INSERT INTO ESHOP_LIVRAISON (commande_id,date_livraison_estimee,statut) VALUES (?,?,?)";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query)) {
            pstm1.setInt(1, commandeId);
            LocalDate today5=LocalDate.now();
            Date sqlDate=Date.valueOf(today5.plusDays(5));
            pstm1.setDate(2,sqlDate);
            pstm1.setString(3, "EXPEDIE");
            
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
}
