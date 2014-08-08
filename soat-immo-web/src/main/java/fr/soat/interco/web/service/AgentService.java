package fr.soat.interco.web.service;

import org.springframework.transaction.annotation.Transactional;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.bean.Client;


/**
 * @author Formation
 *
 */

@Transactional
public interface AgentService {
	
	
    /**
     * @param nom
     * @param prenom
     * @return
     */
    public Agent findAgentByNomAndPrenom(String nom, String prenom);


    /**
     * @return
     */
    public Iterable<Agent> findAllAgents();

    
    /**
     * @param agent
     * @return
     */
    public Agent saveAgent(Agent agent);

   
    /**
     * @param id
     * @return
     */
    public Agent findAgentById(Integer id);

   
    /**
     * @param agent
     */
    public void deleteAgent(Agent agent);

}
