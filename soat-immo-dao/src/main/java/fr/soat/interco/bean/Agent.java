package fr.soat.interco.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agent")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAgent;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    private List<Visite> visits;

    public Integer getIdAgent() {
        return idAgent;
    }
    public void setIdAgent(Integer idAgent) {
        this.idAgent = idAgent;
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

    public List<Visite> getVisits() {
        return visits;
    }
    public void setVisits(List<Visite> visits) {
        this.visits = visits;
    }
}
