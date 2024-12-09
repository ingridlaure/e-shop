package metier;

import java.util.Date;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Order {
	
	private int id;
    private User utilisateur;
    private Double total;
    private Date dateCommande;
    private String statut; 
    private List<OrderItem> orderItems;
    
	public Order(int id, User utilisateur, Double total, Date dateCommande, String statut, List<OrderItem> orderItems) {
		
		this.id = id;
		this.utilisateur = utilisateur;
		this.total = total;
		this.dateCommande = dateCommande;
		this.statut = statut;
		this.orderItems = orderItems;
	}
	public Order(User utilisateur, Double total, Date dateCommande, String statut, List<OrderItem> orderItems) {
		
		this.utilisateur = utilisateur;
		this.total = total;
		this.dateCommande = dateCommande;
		this.statut = statut;
		this.orderItems = orderItems;
	}
	public Order() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
    

}
