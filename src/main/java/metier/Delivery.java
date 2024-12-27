package metier;

import java.sql.Date;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Delivery {
	
	private int id;
    private Order commande;
    private String adresseLivraison;
    private Date dateLivraisonEstimee;
    private Date dateLivraisonReelle;
    private String statut;

    
    public Delivery() {
    }
    public Delivery(Order order) {
    	this.commande=order;
    }

    public Delivery(int id,Order order, String adresseLivraison, Date dateLivraisonEstimee, Date dateLivraisonReelle, String statut) {
        this.id = id;
        this.commande = order;
        this.adresseLivraison = adresseLivraison;
        this.dateLivraisonEstimee = dateLivraisonEstimee;
        this.dateLivraisonReelle = dateLivraisonReelle;
        this.statut = statut;
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

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public Date getDateLivraisonEstimee() {
        return dateLivraisonEstimee;
    }

    public void setDateLivraisonEstimee(Date dateLivraisonEstimee) {
        this.dateLivraisonEstimee = dateLivraisonEstimee;
    }

    public Date getDateLivraisonReelle() {
        return dateLivraisonReelle;
    }

    public void setDateLivraisonReelle(Date dateLivraisonReelle) {
        this.dateLivraisonReelle = dateLivraisonReelle;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }



}
