package fr.soat.interco.bean;

import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.List;

/**
 * Une entité pour un bien immobilier.
 */
@Entity
public class BienImmobilier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBien;

    @Enumerated(EnumType.STRING)
    private TypeImmo type;

    @OneToMany(mappedBy = "immobilier",fetch = FetchType.LAZY)
    private List<Visite> visits;

    private String adresse;

    private String surface;

    private short nbPieces;

    private short etage;

    private Boolean ascenseur;

    @Enumerated(EnumType.STRING)
    private TypeChauffage typeChauffage;

    private String typeProdEauChaude;

    private Double loyer;

    private Double charges;

    private LocalDate dateDisponibilite;

    private Boolean active;

    private Boolean published;

    private Boolean publishedSeLoger;

    @OneToMany
    @JoinTable(name = "BI_PHOTOS",
            joinColumns = { @JoinColumn(name = "idBien", referencedColumnName = "idBien"),
        @JoinColumn(name = "idPhoto", referencedColumnName = "idPhoto")})
    private List<Photo> photos;

    private String description;


    public Long getIdBien() {
        return idBien;
    }

    public void setIdBien(Long idBien) {
        this.idBien = idBien;
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

    public short getNbPieces() {
        return nbPieces;
    }

    public void setNbPieces(short nbPieces) {
        this.nbPieces = nbPieces;
    }

    public short getEtage() {
        return etage;
    }

    public void setEtage(short etage) {
        this.etage = etage;
    }

    public Boolean getAscenseur() {
        return ascenseur;
    }

    public void setAscenseur(Boolean ascenseur) {
        this.ascenseur = ascenseur;
    }

    public TypeChauffage getTypeChauffage() {
        return typeChauffage;
    }

    public void setTypeChauffage(TypeChauffage typeChauffage) {
        this.typeChauffage = typeChauffage;
    }

    public LocalDate getDateDisponibilite() {
        return dateDisponibilite;
    }

    public void setDateDisponibilite(LocalDate dateDisponibilite) {
        this.dateDisponibilite = dateDisponibilite;
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

    public List<Visite> getVisits() {
        return visits;
    }

    public void setVisits(List<Visite> visits) {
        this.visits = visits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
