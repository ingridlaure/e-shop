package metier;

import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Cart {
	private int id;
    private User userr;
    private Boolean actif;
    List<CartItem> items;
    public Cart() {
		
	}
	public Cart(int id, User userr, Boolean actif, List<CartItem> items) {
	
		this.id = id;
		this.userr = userr;
		this.actif = actif;
		this.items = items;
	}
	
	public Cart(User userr, Boolean actif, List<CartItem> items) {
		
		this.userr = userr;
		this.actif = actif;
		this.items = items;
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
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}


}
