package metier;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class User {
	private int id;
    private String email;
    private String password;
    private String role; 
    private String nom;
    private String prenom;
    private Date dateCreation;
    
    public User() {
    	
    }
	public User(int id, String email, String password, String role, String nom, String prenom) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public User(String email, String password, String role, String nom, String prenom) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
	}

	public  int getId() {
		return id;
	}
	public void setId( int id) {
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
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
    
}