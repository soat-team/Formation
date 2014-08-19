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
    private Long idVisite;

    @ManyToOne
    @JoinColumn(name = "id_bien_immo", nullable = false)
    private BienImmobilier immobilier;

    @ManyToOne
    @JoinColumn(name = "id_agent")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @Embedded
    private Creneau creneau;

    public Long getIdVisite() {
        return idVisite;
    }

    public void setIdVisite(Long idVisite) {
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

    public boolean isConfirmed(){
        return agent != null;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }
}
