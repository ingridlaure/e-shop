package metier;

import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cart {
	private int id;
	private User userr;
	private Boolean actif;
	List<CartItem> cartItems;

	public Cart() {

	}

	public Cart(int id, User userr, Boolean actif, List<CartItem> items) {

		this.id = id;
		this.userr = userr;
		this.actif = actif;
		this.cartItems = items;
	}

	public Cart(User userr, Boolean actif, List<CartItem> items) {

		this.userr = userr;
		this.actif = actif;
		this.cartItems = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserr() {
		return userr;
	}

	public void setUserr(User userr) {
		this.userr = userr;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public List<CartItem> getItems() {
		return cartItems;
	}

	public void setItems(List<CartItem> items) {
		this.cartItems = items;
	}
	
	public void addItem(CartItem item) {
		for(CartItem cartItem : cartItems) {
			if(cartItem.getProduit() ==item.getProduit()) {
				cartItem.setQuantite(cartItem.getQuantite()+item.getQuantite());
				return;
			}
		}
		cartItems.add(item);
	}
	
	public double getTotalPrice() {
		return cartItems.stream().mapToDouble(item->item.getPrice()*item.getQuantite()).sum();
	}

}
