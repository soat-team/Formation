package fr.soat.interco.bean;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Une entité pour un bien immobilier.
 */
@Entity
public class BienImmobilier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBienImmo;

    @Enumerated(EnumType.STRING)
    private TypeImmo type;

    @OneToMany(mappedBy = "immobilier",fetch = FetchType.LAZY)
    private List<Visite> visits;

    private String adresse;

    private String surface;

    private int nbPieces;

    private int etage;

    private Boolean ascenseur;

    private String typeChauffage;

    private String typeProdEauChaude;

    private Double loyer;

    private Double charges;

    private Date dateDisponibilite;

    private Boolean active;

    private Boolean published;

    private Boolean publishedSeLoger;

    private String url_photo;


    public Integer getIdBienImmo() {
        return idBienImmo;
    }

    public void setIdBienImmo(Integer idBienImmo) {
        this.idBienImmo = idBienImmo;
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

    public int getNbPieces() {
        return nbPieces;
    }

    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public Boolean getAscenseur() {
        return ascenseur;
    }

    public void setAscenseur(Boolean ascenseur) {
        this.ascenseur = ascenseur;
    }

    public String getTypeChauffage() {
        return typeChauffage;
    }

    public void setTypeChauffage(String typeChauffage) {
        this.typeChauffage = typeChauffage;
    }

    public String getTypeProdEauChaude() {
        return typeProdEauChaude;
    }

    public void setTypeProdEauChaude(String typeProdEauChaude) {
        this.typeProdEauChaude = typeProdEauChaude;
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


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean getPublishedSeLoger() {
        return publishedSeLoger;
    }

    public void setPublishedSeLoger(Boolean publishedSeLoger) {
        this.publishedSeLoger = publishedSeLoger;
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
}
