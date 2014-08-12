package fr.soat.interco.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Une entité pour un bien immobilier.
 */
@Entity
public class BienImmobilier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idbien_immobiler;

    @Enumerated(EnumType.STRING)
    private TypeImmo type;

    private String adresse;

    private String surface;

    private int nb_pieces;

    private int etage;

    private Boolean ascenceur;

    private String type_chauffage;

    private String type_production_eau_chaude;

    private Double loyer;

    private Double charges;

    private Date date_disponibilite;

    private Boolean annonce_active;

    private Boolean publication_site_web;

    private Boolean publication_seLoger;

    private String url_photo;

    @OneToMany(mappedBy = "immobilier",fetch = FetchType.LAZY)
    private List<Visite> visits;


    public Integer getIdbien_immobiler() {
        return idbien_immobiler;
    }

    public void setIdbien_immobiler(Integer idbien_immobiler) {
        this.idbien_immobiler = idbien_immobiler;
    }

    public TypeImmo getType() {
        return type;
    }

    public void setType(TypeImmo type) {
        this.type = type;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public int getNb_pieces() {
        return nb_pieces;
    }

    public void setNb_pieces(int nb_pieces) {
        this.nb_pieces = nb_pieces;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public Boolean getAscenceur() {
        return ascenceur;
    }

    public void setAscenceur(Boolean ascenceur) {
        this.ascenceur = ascenceur;
    }

    public String getType_chauffage() {
        return type_chauffage;
    }

    public void setType_chauffage(String type_chauffage) {
        this.type_chauffage = type_chauffage;
    }

    public String getType_production_eau_chaude() {
        return type_production_eau_chaude;
    }

    public void setType_production_eau_chaude(String type_production_eau_chaude) {
        this.type_production_eau_chaude = type_production_eau_chaude;
    }

    public Double getLoyer() {
        return loyer;
    }

    public void setLoyer(Double loyer) {
        this.loyer = loyer;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public Date getDate_disponibilite() {
        return date_disponibilite;
    }

    public void setDate_disponibilite(Date date_disponibilite) {
        this.date_disponibilite = date_disponibilite;
    }

    public Boolean getAnnonce_active() {
        return annonce_active;
    }

    public void setAnnonce_active(Boolean annonce_active) {
        this.annonce_active = annonce_active;
    }

    public Boolean getPublication_site_web() {
        return publication_site_web;
    }

    public void setPublication_site_web(Boolean publication_site_web) {
        this.publication_site_web = publication_site_web;
    }

    public Boolean getPublication_seLoger() {
        return publication_seLoger;
    }

    public void setPublication_seLoger(Boolean publication_seLoger) {
        this.publication_seLoger = publication_seLoger;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public List<Visite> getVisits() {
        return visits;
    }

    public void setVisits(List<Visite> visits) {
        this.visits = visits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BienImmobilier that = (BienImmobilier) o;

        if (etage != that.etage) return false;
        if (nb_pieces != that.nb_pieces) return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        if (charges != null ? !charges.equals(that.charges) : that.charges != null) return false;
        if (loyer != null ? !loyer.equals(that.loyer) : that.loyer != null) return false;
        if (surface != null ? !surface.equals(that.surface) : that.surface != null) return false;
        if (type != that.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (surface != null ? surface.hashCode() : 0);
        result = 31 * result + nb_pieces;
        result = 31 * result + etage;
        result = 31 * result + (loyer != null ? loyer.hashCode() : 0);
        result = 31 * result + (charges != null ? charges.hashCode() : 0);
        return result;
    }
}
