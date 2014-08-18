package fr.soat.interco.dao;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.bean.BienImmobilier;
import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.Visite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by formation on 08/08/14.
 */
public interface VisiteDao extends CrudRepository<Visite, Integer> {

    /**
     * Renvoie le client associé à cette visite.
     * @param id
     * @return
     */
    @Query("select client from Visite v where v.idVisite = ?1")
    public Client findClientForVisit(Integer id);

    /**
     * Renvoie l'agent associé à cette visite.
     * @param id
     * @return
     */
    @Query("select agent from Visite v where v.idVisite = ?1")
    public Agent findAgentForVisit(Integer id);

    /**
     * Renvoie le bien immobilier associé à cette visite.
     * @param id
     * @return
     */
    @Query("select immobilier from Visite v where v.idVisite = ?1")
    public BienImmobilier findBienImmoForVisit(Integer id);




}
