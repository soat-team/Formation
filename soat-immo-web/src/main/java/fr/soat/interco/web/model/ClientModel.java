package fr.soat.interco.web.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by formation on 12/08/14.
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

    //Autres champs periodEssai et criteres_recherche; à remplir par l'agent.

}
