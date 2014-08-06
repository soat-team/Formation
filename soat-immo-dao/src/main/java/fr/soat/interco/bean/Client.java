package fr.soat.interco.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Class qui représente un client
 */
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idclient;

    private String nom;
    private String prenom;
    private Date date_de_naissance;
    private Double salaire;
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

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (idclient != null ? !idclient.equals(client.idclient) : client.idclient != null) return false;
        if (nom != null ? !nom.equals(client.nom) : client.nom != null) return false;
        if (prenom != null ? !prenom.equals(client.prenom) : client.prenom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idclient != null ? idclient.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        return result;
    }
}
