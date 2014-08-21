package fr.soat.interco.web.service;

import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.Visite;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interface de service avec le client.
 */
@Transactional
public interface ClientService {

    /**
     * Renvoie un client par son nom et son prénom
     * @param nom
     * @param prenom
     * @return
     */
    public  List<Client> findClientByNomAndPrenom(String nom, String prenom);


    /**
     * Renvoie la liste de tous les clients présents dans la base
     * @return
     */
    public Iterable<Client> findAllClients();

    /**
     * Permet de sauvegarder un client dans la basse.
     * @param client
     * @return
     */
    public Client saveClient(Client client);

    /**
     * Retrouve un lient par son Id;
     * @param id
     * @return
     */
    public Client findClientById(Long id);

    /**
     * Supprime un client de la base.
     * @param client
     */
    public void deleteClient(Client client);


    /**
     *
     * @param id
     * @return
     */
    public List<Visite> getVisitsForClient(Long id);
}
