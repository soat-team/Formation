package fr.soat.interco.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe représentant une photo
 */
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPhoto;

    private String photoUrl;

    public Photo(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Long getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(Long idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
