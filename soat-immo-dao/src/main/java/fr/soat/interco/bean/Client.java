package fr.soat.interco.bean;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Class qui représente un client
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idclient;

    private String nom;
    private String prenom;

    @Column
    @Type(type="org.joda.time.contrib.hibernate.PersistentLocalDate")
    private LocalDate dateNaissance;

    private Double salaire;

    private boolean periodEssai;

    @OneToMany(mappedBy = "client")
    private List<Visite> visits;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public Long getIdclient() {
        return idclient;
    }

    public void setIdclient(Long idclient) {
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


    public List<Visite> getVisits() {
        return visits;
    }

    public void setVisits(List<Visite> visits) {
        this.visits = visits;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
