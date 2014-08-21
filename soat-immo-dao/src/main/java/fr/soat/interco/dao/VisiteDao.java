package fr.soat.interco.dao;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.bean.BienImmobilier;
import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.Visite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface Dao pour les visites.
 */
public interface VisiteDao extends CrudRepository<Visite, Long> {

    /**
     * Renvoie le client associé à cette visite.
     * @param id
     * @return
     */
    @Query("select client from Visite v where v.idVisite = ?1")
    public Client findClientForVisit(Long id);

    /**
     * Renvoie l'agent associé à cette visite.
     * @param id
     * @return
     */
    @Query("select agent from Visite v where v.idVisite = ?1")
    public Agent findAgentForVisit(Long id);

    /**
     * Renvoie le bien immobilier associé à cette visite.
     * @param id
     * @return
     */
    @Query("select immobilier from Visite v where v.idVisite = ?1")
    public BienImmobilier findBienImmoForVisit(Long id);


    /**
     * Retursn the specified visit for the client.
     * @param idClient
     * @return
     */
    @Query("select v from Visite v where v.id_client = ?1 and v.idVisite = ?2")
    public Visite findVisiteForClient(Long idClient, Long idVisite);


    /**
     *
     * @param idAgent
     * @param idVisite
     * @return
     */
    @Query("select v from Visite v where v.id_agent = ?1 and v.idVisite = ?2")
    public Visite findVisiteForAgent(Long idAgent, Long idVisite);


    /**
     *
     * @param id_bien_immo
     * @param idVisite
     * @return
     */
    @Query("select v from Visite v v.id_bien_immo = ?1 and v.idVisite = ?2")
    public Visite findVisiteForBI(Long id_bien_immo, Long idVisite);



}
