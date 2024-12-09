package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DatabaseConnection;
import metier.*;

public class ProductDAO {
	Connection dbConnect;
	
	public ProductDAO() {
		dbConnect = DatabaseConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
	}
	
	public List<Product> getProducts(){
		List<Product> products=new ArrayList<>();
		String query="select * from ESHOP_PRODUIT";
		try(Statement stm=dbConnect.createStatement()){
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt(1);
				String nom=rs.getString(2);
				String description=rs.getString(3);
				Double prix= rs.getDouble(4);
				int stock=rs.getInt(5);
				String image=rs.getString(6);
				Product product=new Product(id,nom,description,prix,stock,image);
				products.add(product);
			}
			
		}catch(SQLException e) {
			System.err.println("erreur sql:"+e);
			return null;
		}
		return products;
	}
	
	public Boolean addProduct(Product product) {
		String query="insert into ESHOP_PRODUIT (nom,description,prix,stock) VALUES(?,?,?,?,?)";
		try(PreparedStatement pstm1=dbConnect.prepareStatement(query)){
			pstm1.setString(1, product.getNom());
			pstm1.setString(2,product.getDescription());
			pstm1.setDouble(3, product.getPrix());
			pstm1.setInt(4, product.getStock());
			pstm1.setString(5, product.getImage());
			int n=pstm1.executeUpdate();
			if(n==1) {
				return true;
			}	
			else {
				System.err.println("record introuvable");
                return false;
			}
			
			}catch(SQLException e) {
				System.err.println("erreur sql :"+e);
	            return false;
			}
	}
	public Product getProduct(int index) {
		Product product=new Product();
		String query="select * from ESHOP_PRODUIT where ID=?";
				try(PreparedStatement pstm=dbConnect.prepareStatement(query)){
					pstm.setInt(1, index);
					ResultSet rs=pstm.executeQuery();
					while(rs.next()) {
						int id=rs.getInt(1);
						String nom=rs.getString(2);
						String description=rs.getString(3);
						Double prix= rs.getDouble(4);
						int stock=rs.getInt(5);
						String image=rs.getString(6);
						product=new Product(id,nom,description,prix,stock,image);
					}
					System.out.println(product);
					return product;
				}catch(SQLException e) {
					System.err.println("erreur sql :"+e);
		            return null;
				}
	}
	
	public void updateProduct(int index,Product product) {
		
	}
	
	public void deleteProduct(int index) {
		String query = "delete from ESHOP_PRODUCT where ID=?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,index);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

        }
		
	}
}
