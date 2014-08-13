package fr.soat.interco.web.model;

import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.Visite;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * A model for the client.
 */
public class ClientModel {

    private Integer idclient;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    private Date date_de_naissance;

    private Double salaire;

    private List<VisitModel> visits;

    //Autres champs periodEssai et criteres_recherche; à remplir par l'agent.
    public ClientModel(Client client){
        Objects.requireNonNull(client, "Client must not be null");
        this.idclient = client.getIdclient();

        if(client.getNom() != null){
            this.nom = client.getNom();
        }

        if(client.getPrenom() != null){
            this.prenom = client.getPrenom();
        }

        if(client.getDate_de_naissance() != null){
            this.date_de_naissance = client.getDate_de_naissance();
        }

        if(client.getSalaire() != null){
            this.salaire = client.getSalaire();
        }

        if(visits == null){
            visits = new ArrayList<>();
            if(client.getVisits() != null){
                List<Visite> visiteList = client.getVisits();
                for(Visite v : visiteList){
                    visits.add(new VisitModel(v));
                }
            }
        }

    }


    /**
     * Converts a model to a client.
     * @return
     */
    public Client toClient(){
        Client client = new Client();
        client.setIdclient(this.idclient);
        client.setNom(this.nom);
        client.setPrenom(this.prenom);

        if(this.salaire != null){
            client.setSalaire(this.salaire);
        }

        if(this.date_de_naissance != null){
            client.setDate_de_naissance(this.date_de_naissance);
        }
        List<Visite> visiteBeans = new ArrayList<>();
        for(VisitModel vm : visits){
            Visite visite = vm.toVisite();
            visiteBeans.add(visite);
        }

        client.setVisits(visiteBeans);
        return client;
    }


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

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public List<VisitModel> getVisits() {
        return visits;
    }

    public void setVisits(List<VisitModel> visits) {
        this.visits = visits;
    }
}
