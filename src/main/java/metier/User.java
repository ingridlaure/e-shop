package metier;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int id;
	private String email;
	private String password;
	private String role;
	private String nom;
	private String prenom;
	private String adresse;

	public User() {

	}
	public User(int id) {
		this.id=id;
		}

	public User(int id, String email, String password, String role, String nom, String prenom, String addresse) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = addresse;
	}

	public User(String email, String password, String role, String nom, String prenom, String addresse) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = addresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
