package metier;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderItem {
	private int id;
	private Order commande;
	private Product produit;
	private Integer quantite;
	private Double prixAchat;

	public OrderItem(int id, Order commande, Product produit, Integer quantite, Double prixAchat) {

		this.id = id;
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
		this.prixAchat = prixAchat;
	}

	public OrderItem(Order commande, Product produit, Integer quantite, Double prixAchat) {

		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
		this.prixAchat = prixAchat;
	}

	public OrderItem() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getCommande() {
		return commande;
	}

	public void setCommande(Order commande) {
		this.commande = commande;
	}

	public Product getProduit() {
		return produit;
	}

	public void setProduit(Product produit) {
		this.produit = produit;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}

}
