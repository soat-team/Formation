package fr.soat.interco.dao;

import fr.soat.interco.bean.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface de Dao pour accéder aux clients
 */
public interface ClientDao extends CrudRepository<Client, Integer> {

    /**
     * Permet de retrouver un client par son et prenom
     * @param nom le nom du client
     * @param prenom le prenom du client
     * @return le client associé.
     */
    @Query("from Client c where c.nom = ?1 and c.prenom = ?2")
    public Client findClientByNomAndPrenom(String nom, String prenom);
}
