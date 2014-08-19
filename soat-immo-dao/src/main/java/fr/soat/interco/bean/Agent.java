package fr.soat.interco.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAgent;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    private List<Visite> visits;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public Long getIdAgent() {
        return idAgent;
    }
    public void setIdAgent(Long idAgent) {
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

        Agent agent = (Agent) o;

        if (idAgent != null ? !idAgent.equals(agent.idAgent) : agent.idAgent != null) return false;
        if (!nom.equals(agent.nom)) return false;
        if (!prenom.equals(agent.prenom)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAgent != null ? idAgent.hashCode() : 0;
        result = 31 * result + nom.hashCode();
        result = 31 * result + prenom.hashCode();
        return result;
    }
}
