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
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IMMOBILIER_ID", nullable = false)
    private BienImmobilier immobilier;

    @ManyToOne
    @JoinColumn(name = "AGENT_ID", nullable = false)
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

    private Date dateVisite;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }
}
