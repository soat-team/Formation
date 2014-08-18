package fr.soat.interco.bean;

import javax.persistence.Embeddable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by formation on 18/08/14.
 */
@Embeddable
public class Creneau {

    private Date dateVisite;

    private Time heureDebut;

    private Time heureFin;

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public Time getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Time heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Time getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Time heureFin) {
        this.heureFin = heureFin;
    }
}
