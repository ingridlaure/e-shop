package metier;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private int id;
	private String nom;
	private String description;
	private Double prix;
	private Integer stock;
	private String image;

	public Product() {

	}

	public Product(int id, String nom, String description, Double prix, Integer stock, String image) {

		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
		this.image = image;
	}

	public Product(String nom, String description, Double prix, Integer stock, String image) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
