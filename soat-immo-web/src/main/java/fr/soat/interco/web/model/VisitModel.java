package fr.soat.interco.web.model;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.bean.BienImmobilier;
import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.Visite;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a model of Visits.
 */
public class VisitModel {

    private Integer idVisite;
    private Integer idBienImmobilier;
    private Integer idAgent;
    private Integer idClient;
    private Date heure_debut;
    private Date heure_fin;


    /**
     * Creates a new visit model from the visit bean.
     * @param visite
     */
    public VisitModel(Visite visite){
        Objects.requireNonNull(visite, "Visite bean must not be null");

        this.idVisite = visite.getIdVisite();

        if(visite.getAgent() != null){
            this.idAgent = visite.getAgent().getIdAgent();
        }
        if(visite.getClient() != null){
            this.idClient = visite.getClient().getIdclient();
        }
        if(visite.getImmobilier() != null){
            this.idBienImmobilier = visite.getImmobilier().getIdbien_immobiler();
        }

        this.heure_debut = visite.getHeure_debut();
        this.heure_fin = visite.getHeure_fin();
    }


    /**
     * Converts the model object to the bean to persist.
     * @return
     */
    public Visite toVisite(){
        Visite visite = new Visite();

        if(this.idVisite != null){
            visite.setIdVisite(this.idVisite);
        }

        if(this.idBienImmobilier != null){
            BienImmobilier bienImmobilier = new BienImmobilier();
            bienImmobilier.setIdbien_immobiler(this.idBienImmobilier);
            visite.setImmobilier(bienImmobilier);
        }

        if(this.idAgent != null){
            Agent agent = new Agent();
            agent.setIdAgent(this.idAgent);
            visite.setAgent(agent);
        }

        if(this.idClient != null){
            Client client = new Client();
            client.setIdclient(this.idClient);
            visite.setClient(client);
        }

        visite.setHeure_debut(this.heure_debut);
        visite.setHeure_fin(this.heure_fin);

        return visite;
    }

    public Integer getIdVisite() {
        return idVisite;
    }

    public void setIdVisite(Integer idVisite) {
        this.idVisite = idVisite;
    }

    public Integer getIdBienImmobilier() {
        return idBienImmobilier;
    }

    public void setIdBienImmobilier(Integer idBienImmobilier) {
        this.idBienImmobilier = idBienImmobilier;
    }

    public Integer getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(Integer idAgent) {
        this.idAgent = idAgent;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
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
