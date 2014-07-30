package fr.soat.interco.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Class qui représente un client
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idclient;

    private String nom;
    private String prenom;
    private Date date_de_naissance;
    private Integer salaire;
    private boolean periodEssai;
    private String criteres_recherche;

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
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

    public Integer getSalaire() {
        return salaire;
    }

    public void setSalaire(Integer salaire) {
        this.salaire = salaire;
    }

    public boolean isPeriodEssai() {
        return periodEssai;
    }

    public void setPeriodEssai(boolean periodEssai) {
        this.periodEssai = periodEssai;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getCriteres_recherche() {
        return criteres_recherche;
    }

    public void setCriteres_recherche(String criteres_recherche) {
        this.criteres_recherche = criteres_recherche;
    }
}
