package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dbConnection.DatabaseConnection;
import metier.CartItem;
import metier.Order;
import metier.Product;
import metier.User;

public class OrderDao {
	Connection dbConnect;

	ProductDAO productDAO =new ProductDAO();
	UserDao userDAO =new UserDao();
	public OrderDao() {
		dbConnect = DatabaseConnection.getConnection();
		if (dbConnect == null) {
			System.err.println("erreur de connexion");
			System.exit(1);
		}
	}
	
	public List<Order> getOrders() {
		String query="SELECT * from ESHOP_COMMANDE order by id desc"; 
		List<Order> orders=new ArrayList<>();
		try(PreparedStatement ps=dbConnect.prepareStatement(query)){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int orderId=rs.getInt("id");
				Double total=rs.getDouble("total");
				Date dte=rs.getDate("date_commande");
				String statut=rs.getString("statut");
				String deliveryAdress=rs.getString("adresse_livraison");
				int utilisateurId=rs.getInt("utilisateur_id");
				User user=userDAO.getUser(utilisateurId);
				Order order= new Order(orderId,user,total,dte,statut,deliveryAdress);
				getOrderItems(order);
				 orders.add(order);
			}
			
		} catch (SQLException e) {
			System.out.println("erreur :" + e);
			
		}
		return orders;
		
	}
	
	public List<Order> getOrdersByUser(User user) {
		String query="SELECT * from ESHOP_COMMANDE WHERE utilisateur_id =? order by id desc"; 
		List<Order> orders=new ArrayList<>();
		try(PreparedStatement ps=dbConnect.prepareStatement(query)){
			ps.setInt(1,user.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int orderId=rs.getInt("id");
				Double total=rs.getDouble("total");
				Date dte=rs.getDate("date_commande");
				String statut=rs.getString("statut");
				String deliveryAdress=rs.getString("adresse_livraison");
				Order order= new Order(orderId,user,total,dte,statut,deliveryAdress);
				getOrderItems(order);
				 orders.add(order);
			}
			
		} catch (SQLException e) {
			System.out.println("erreur :" + e);
			
		}
		return orders;
		
		
	}
	public Order getOrderById(int index) {
		Order order=null;
		String query = "select * from ESHOP_COMMANDE where ID=?";
		try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
			pstm.setInt(1, index);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int orderId=rs.getInt("id");
				Double total=rs.getDouble("total");
				Date dte=rs.getDate("date_commande");
				String statut=rs.getString("statut");
				String deliveryAdress=rs.getString("adresse_livraison");
				order= new Order(orderId,total,dte,statut,deliveryAdress);
				getOrderItems(order);
				 
			}
			System.out.println(order);
		
		} catch (SQLException e) {
			System.err.println("erreur sql :" + e);
		}

		return order;

	}
	public void getOrderItems(Order order) {
		String query="SELECT * FROM ESHOP_COMMANDE_ITEM where commande_id=?";
		try(PreparedStatement ps=dbConnect.prepareStatement(query)){
			ps.setInt(1, order.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int produitId=rs.getInt("produit_id");
				int quantite=rs.getInt("quantite");
				double prix=rs.getDouble("prix_achat");
				Product p=productDAO.getProduct(produitId);
				CartItem orderItem=new CartItem(p,quantite,prix);
				System.out.println("nom produit:"+p.getNom());
				order.addItem(orderItem);
				
			}
			}catch (SQLException e) {
				System.out.println("erreur :" + e);
			}
			
		
	}
	

	public Boolean addOrder(Order order) {
		int orderId = 0;
		// Ajouter la commande à la base de données
		String query = "insert into ESHOP_COMMANDE(utilisateur_id,total,statut,adresse_livraison) VALUES(?,?,?,?)";
		try (PreparedStatement pstm1 = dbConnect.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
			System.out.println(" try de inser commande");
			pstm1.setInt(1, order.getUtilisateur().getId());
			pstm1.setDouble(2, order.getTotal());
			pstm1.setString(3, "EN TRAITEMENT");
			pstm1.setString(4, order.getDeliveryAddress());
			pstm1.executeUpdate();
			System.out.println(" tavant le detgenerated key");
			ResultSet rs2 = pstm1.getGeneratedKeys();
			System.out.println(" avant le next");
			rs2.next();
			String rowId = rs2.getString(1); // Récupération du ROWID
			System.out.println("ROWID généré : " + rowId);
			String idQuery = "SELECT ID FROM ESHOP_COMMANDE WHERE ROWID = ?";
			try (PreparedStatement idPstm = dbConnect.prepareStatement(idQuery)) {
				idPstm.setString(1, rowId);
				ResultSet idRs = idPstm.executeQuery();
				if (idRs.next()) {
					orderId = idRs.getInt("ID");
					System.out.println("ID généré : " + orderId);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			// pour chaque ligne de panier, ajouter une ligne de commande
			for (CartItem item : order.getOrderItems()) {
				int qteStock = 0;
				String query4 = "SELECT stock from ESHOP_PRODUIT WHERE id=?";
				String query5 = "INSERT INTO ESHOP_COMMANDE_ITEM(commande_id, produit_id, quantite, prix_achat) VALUES (?, ?, ?, ?)";
				String query6 = "UPDATE ESHOP_PRODUIT SET stock=? WHERE id=?";

				// on selection le stock actuel
				try (PreparedStatement pstm = dbConnect.prepareStatement(query4)) {
					System.out.println(" try de select stcok");
					pstm.setInt(1, item.getProduit().getId());
					ResultSet rs = pstm.executeQuery();
					while (rs.next()) {
						qteStock = rs.getInt(1);
						System.out.println(" tquantite en stock :" + qteStock);

					}

				} catch (SQLException e) {
					System.out.println("erreur :" + e);
				}

				// on insere la ligne de commande n
				try (PreparedStatement ps5 = dbConnect.prepareStatement(query5)) {
					System.out.println(" try de inser commande item ");
					ps5.setInt(1, orderId);
					ps5.setInt(2, item.getProduit().getId());
					ps5.setInt(3, item.getQuantite());
					ps5.setDouble(4, item.getPrice());
					ps5.executeUpdate();

				} catch (SQLException e) {
					System.out.println("erreur :" + e);
				}

				// on update le stock du produit inserer

				try (PreparedStatement ps6 = dbConnect.prepareStatement(query6)) {
					System.out.println(" try de inser update stock ");
					ps6.setInt(1, qteStock - item.getQuantite());
					ps6.setInt(2, item.getProduit().getId());
					ps6.executeUpdate();
				} catch (SQLException e) {
					System.out.println("erreur :" + e);
				}

			}

			return true;

		} catch (SQLException e) {
			System.err.println("erreur sql :" + e);
			return false;
		}
	}

	public boolean updateOrderStatus(int commandeId, String statut) {
		
		String query = "UPDATE ESHOP_COMMANDE SET statut=? WHERE ID = ?";
	    try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
	    	pstm.setString(1, statut);
	        pstm.setInt(2, commandeId);
	        int n = pstm.executeUpdate();
	        if (n> 0) {
	            System.out.println("commande mis à jour avec succes");
	            return true;
	        } else {
	            System.err.println("echec de la mise à jour");
	            return false;
	        }
	    } catch (SQLException e) {
	        System.err.println("erreur sql: " + e);
	        return false;
	    }
	}
	
	
	
}
