package fr.soat.interco.web.service;

import fr.soat.interco.bean.Client;
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
    public Client findClientByNomAndPrenom(String nom, String prenom);


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
    public Client findClientById(Integer id);

    /**
     * Supprime un client de la base.
     * @param client
     */
    public void deleteClient(Client client);
}
