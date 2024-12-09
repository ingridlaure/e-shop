package metier;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CartItem {
	private int id;
    private Cart panier;
    private Product produit;
    private Integer quantite;
    
	public CartItem(int id, Cart panier, Product produit, Integer quantite) {
		
		this.id = id;
		this.panier = panier;
		this.produit = produit;
		this.quantite = quantite;
	}

	public CartItem(Cart panier, Product produit, Integer quantite) {
		
		this.panier = panier;
		this.produit = produit;
		this.quantite = quantite;
	}

	public CartItem() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getPanier() {
		return panier;
	}

	public void setPanier(Cart panier) {
		this.panier = panier;
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
	
	
	

}
