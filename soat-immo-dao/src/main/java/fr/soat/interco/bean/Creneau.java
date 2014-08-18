package fr.soat.interco.bean;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.Interval;
import org.joda.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 *
 */
@Embeddable
public class Creneau {

    @Column
    @Type(type="org.joda.time.contrib.hibernate.PersistentLocalDate")
    private LocalDate dateVisite;

    @Columns(columns={@Column(name="heureDebut"),@Column(name="heureFin")})
    @Type(type="org.joda.time.contrib.hibernate.PersistentInterval")
    private Interval duration;

    public LocalDate getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(LocalDate dateVisite) {
        this.dateVisite = dateVisite;
    }

    public Interval getDuration() {
        return duration;
    }

    public void setDuration(Interval duration) {
        this.duration = duration;
    }
}
