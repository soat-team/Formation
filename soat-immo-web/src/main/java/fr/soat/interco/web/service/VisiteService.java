package fr.soat.interco.web.service;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.bean.BienImmobilier;
import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.Visite;
import org.springframework.transaction.annotation.Transactional;

/**
 * Visits service.
 */
@Transactional
public interface VisiteService {

    /**
     * Finds an return the visit by its id.
     * @param id
     * @return
     */
    public Visite findVisitById(Long id);

    /**
     * Returns all the visits.
     * @return
     */
    public Iterable<Visite> findAll();

    /**
     * Renvoie le client associé à cette visite.
     * @param id
     * @return
     */
    public Client findClientForVisit(Long id);

    /**
     *  Renvoie l'agent associé à cette visite.
     * @param id
     * @return
     */
    public Agent findAgentForVisit(Long id);


    /**
     * Renvoie le bien immobilier associé à cette visite.
     * @param id
     * @return
     */
    public BienImmobilier findBienImmoForVisit(Long id);

    /**
     * Finds the visit for the specified client.
     * @param idClient
     * @return
     */
    public Visite findVisiteForClient(Long idClient, Long idVisite);


}
