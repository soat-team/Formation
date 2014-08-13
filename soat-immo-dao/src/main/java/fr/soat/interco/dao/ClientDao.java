package fr.soat.interco.dao;

import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.Visite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Interface de Dao pour accéder aux clients
 */
@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientDao extends PagingAndSortingRepository<Client, Integer> {

    /**
     * Permet de retrouver un client par son et prenom
     * @param nom le nom du client
     * @param prenom le prenom du client
     * @return le client associé.
     */
    @Query("from Client c where c.nom = ?1 and c.prenom = ?2")
    public Client findClientByNomAndPrenom(String nom, String prenom);


    /**
     * Retrieves all the visits for a client.
     * @param id
     * @return
     */
    @Query("select visits from Client c where c.id = ?1")
    public List<Visite> findVisitsForAgent(Integer id);
}
