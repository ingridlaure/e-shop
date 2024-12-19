package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static Connection dbConnect = null;

	private DatabaseConnection() {
	}

	public static Connection getConnection() {
		if (dbConnect != null)
			return dbConnect;
		String serverName = "mons-oracle19.condorcet.be";
		String dbName = "orcl.condorcet.be";
		String username = "ora36";
		String password = "oracle36";
		String dbPort = "1521";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@//" + serverName + ":" + dbPort + "/" + dbName;
			dbConnect = DriverManager.getConnection(url, username, password);
			return dbConnect;
		} catch (Exception e) {
			System.out.println("erreur de connexion " + e);
			e.printStackTrace();
			return null;
		}

	}

}
