package metier;

import java.util.ArrayList;
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
	private String deliveryAddress;
	private List<CartItem> orderItems=new ArrayList<>();

	public Order(int id, User utilisateur, Double total, Date dateCommande, String statut,String deliveryAdress) {
		this.id = id;
		this.utilisateur = utilisateur;
		this.total = total;
		this.dateCommande = dateCommande;
		this.statut = statut;
		this.deliveryAddress=deliveryAdress;
	}

	public Order(int id, Double total, Date dateCommande, String statut,String deliveryAdress) {
		this.id = id;
		this.total = total;
		this.dateCommande = dateCommande;
		this.statut = statut;
		this.deliveryAddress=deliveryAdress;
	}

	public Order(User utilisateur, Double total, List<CartItem> orderItems,String deliveryAdress) {
		this.utilisateur = utilisateur;
		this.total = total;
		this.orderItems = orderItems;
		this.statut="EN_ATTENTE";
		this.deliveryAddress=deliveryAdress;
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

	public List<CartItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<CartItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public void addItem(CartItem item) {
		
		orderItems.add(item);
	}
	
	

}
