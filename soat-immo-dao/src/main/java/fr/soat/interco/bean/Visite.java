package fr.soat.interco.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Classe représentant une visite.
 * Une visite concerne un agent, un client et un bien Immobilier.
 */
@Entity
public class Visite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idVisite;

    @ManyToOne
    @JoinColumn(name = "id_bien_immo", nullable = false)
    private BienImmobilier immobilier;

    @ManyToOne
    @JoinColumn(name = "id_agent", nullable = false)
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    private Date heure_debut;

    private Date heure_fin;


    public Integer getIdVisite() {
        return idVisite;
    }

    public void setIdVisite(Integer idVisite) {
        this.idVisite = idVisite;
    }

    public BienImmobilier getImmobilier() {
        return immobilier;
    }

    public void setImmobilier(BienImmobilier immobilier) {
        this.immobilier = immobilier;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(Date heure_debut) {
        this.heure_debut = heure_debut;
    }

    public Date getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(Date heure_fin) {
        this.heure_fin = heure_fin;
    }
}
