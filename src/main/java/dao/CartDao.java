package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnection.DatabaseConnection;
import metier.Cart;
import metier.CartItem;
import metier.Product;
import metier.User;

public class CartDao {

	Connection dbConnect;

	public CartDao() {
		dbConnect = DatabaseConnection.getConnection();
		if (dbConnect == null) {
			System.err.println("erreur de connexion");
			System.exit(1);
		}
	}
	
	
	public Cart getCart(User user) {
		String query="SELECT id from ESHOP_PANIER where utilisateur_id =? and actif=1"; 
		Cart cart=null;
		try(PreparedStatement ps=dbConnect.prepareStatement(query)){
			ps.setInt(1,user.getId());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				int cartId=rs.getInt("id");
				cart =new Cart(cartId,user);
				getCartItems(cart);
				cart.setTotal(cart.getTotalPrice());
			}
			
		} catch (SQLException e) {
			System.out.println("erreur :" + e);
		}
		return cart;
	}
	
	
	public void getCartItems(Cart cart) {
		ProductDAO productDAO =new ProductDAO();
		String query="SELECT produit_id,quantite,prix FROM ESHOP_PANIER_ITEM where panier_id=?";
		try(PreparedStatement ps=dbConnect.prepareStatement(query)){
			ps.setInt(1, cart.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int produitId=rs.getInt("produit_id");
				int quantite=rs.getInt("quantite");
				double prix=rs.getDouble("prix");
				Product p=productDAO.getProduct(produitId);
				CartItem cartItem=new CartItem(p,quantite,prix);
				System.out.println("nom produit:"+p.getNom());
				cart.addItem(cartItem);
				
			}
			}catch (SQLException e) {
				System.out.println("erreur :" + e);
			}
			
		
		
		
	}
	
	
	
	public void addItem(CartItem item, User user) {
		int cartId=0;
		String query1 = "SELECT id from ESHOP_PANIER where utilisateur_id=? AND actif=1";
		try (PreparedStatement ps1 = dbConnect.prepareStatement(query1)) {
			ps1.setInt(1, user.getId());
			ResultSet rs1 = ps1.executeQuery();
			
			if (rs1.next()) {

				cartId = rs1.getInt(1);
			} else {
				String query2 = "INSERT INTO ESHOP_PANIER(utilisateur_id) values (?)";
				try (PreparedStatement ps2 = dbConnect.prepareStatement(query2,
						PreparedStatement.RETURN_GENERATED_KEYS)) {
					ps2.setInt(1, user.getId());
					
					ps2.executeUpdate();
					ResultSet rs2 = ps2.getGeneratedKeys();
					rs2.next();
					cartId = rs2.getInt(1);

				} catch (SQLException e) {
					System.out.println("erreur :" + e);
				}
			}

		} catch (SQLException e) {
			System.out.println("erreur :" + e);
		}
			String query3="SELECT id, quantite FROM ESHOP_PANIER_ITEM WHERE id=? AND produit_id=?";
			try (PreparedStatement ps3 = dbConnect.prepareStatement(query3)) {
				ps3.setInt(1, cartId);
				ps3.setInt(2, item.getProduit().getId());
				ResultSet rs3 = ps3.executeQuery();
				if(rs3.next()) {
                    int existingQuantity = rs3.getInt("quantite");
                    String query4 = "UPDATE ESHOP_PANIER_ITEM SET quantite = ? WHERE id = ?";
                    try( PreparedStatement ps4 = dbConnect.prepareStatement(query4)){
                    ps4.setInt(1, existingQuantity + item.getQuantite());
                    ps4.setInt(2, rs3.getInt("id"));
                    ps4.executeUpdate();
                    }catch (SQLException e) {
        				System.out.println("erreur :" + e);
        			}
                } else {
                    // Ajouter un nouvel article au panier
                    String query5 = "INSERT INTO ESHOP_PANIER_ITEM (panier_id, produit_id, quantite, priX) VALUES (?, ?, ?, ?)";
                    try( PreparedStatement ps5 = dbConnect.prepareStatement(query5)){
                    ps5.setInt(1, cartId);
                    ps5.setInt(2, item.getProduit().getId());
                    ps5.setInt(3, item.getQuantite());
                    ps5.setDouble(4, item.getPrice());
                    ps5.executeUpdate();
                    
                    }catch (SQLException e) {
        				System.out.println("erreur :" + e);
        			}
                }
           
			}
			catch (SQLException e) {
				System.out.println("erreur :" + e);
			}
			
		
	
	}
	
	

	public void mergeCart(Cart tempCart, User user) throws SQLException {
		int cartId = 0;
		String query1 = "SELECT id from ESHOP_PANIER where utilisateur_id=? AND actif=1";
		try (PreparedStatement ps1 = dbConnect.prepareStatement(query1)) {
			ps1.setInt(1, user.getId());
			ResultSet rs1 = ps1.executeQuery();
			
			if (rs1.next()) {

				cartId = rs1.getInt(1);
			} else {
				String query2 = "INSERT INTO ESHOP_PANIER(utilisateur_id) values (?)";
				try (PreparedStatement ps2 = dbConnect.prepareStatement(query2,
						PreparedStatement.RETURN_GENERATED_KEYS)) {
					ps2.setInt(1, user.getId());
					ps2.executeUpdate();
					ResultSet rs2 = ps2.getGeneratedKeys();
					rs2.next();
					cartId = rs2.getInt(1);

				} catch (SQLException e) {
					System.out.println("erreur :" + e);
				}
			}

		} catch (SQLException e) {
			System.out.println("erreur :" + e);
		}
		
		for(CartItem item: tempCart.getItems()) {
			String query3="SELECT id, quantite FROM ESHOP_PANIER_ITEM WHERE id=? AND produit_id=?";
			try (PreparedStatement ps3 = dbConnect.prepareStatement(query3)) {
				ps3.setInt(1, cartId);
				ps3.setInt(2, item.getProduit().getId());
				ResultSet rs3 = ps3.executeQuery();
				
				if(rs3.next()) {
				
                    int existingQuantity = rs3.getInt("quantite");
                    String query4 = "UPDATE ESHOP_PANIER_ITEM SET quantite = ? WHERE id = ?";
                    try( PreparedStatement ps4 = dbConnect.prepareStatement(query4)){
                    ps4.setInt(1, existingQuantity + item.getQuantite());
                    ps4.setInt(2, rs3.getInt("id"));
                    ps4.executeUpdate();
                    }catch (SQLException e) {
        				System.out.println("erreur :" + e);
        			}
                } else {
                    // Ajouter un nouvel article au panier
                    String query5 = "INSERT INTO ESHOP_PANIER_ITEM (panier_id, produit_id, quantite, priX) VALUES (?, ?, ?, ?)";
                    try( PreparedStatement ps5 = dbConnect.prepareStatement(query5)){
                    ps5.setInt(1, cartId);
                    ps5.setInt(2, item.getProduit().getId());
                    ps5.setInt(3, item.getQuantite());
                    ps5.setDouble(4, item.getPrice());
                    ps5.executeUpdate();
                    
                    }catch (SQLException e) {
        				System.out.println("erreur :" + e);
        			}
                }
           
			}
			catch (SQLException e) {
				System.out.println("erreur :" + e);
			}
			
		
	}
	}
}
