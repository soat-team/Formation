package fr.soat.interco.dao;

import fr.soat.interco.bean.Visite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.soat.interco.bean.Agent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.xml.ws.ResponseWrapper;
import java.util.List;

/**
 * Dao pour accéder aux agents.
 */
@RepositoryRestResource(collectionResourceRel = "agent", path = "agent")
public interface AgentDao extends PagingAndSortingRepository<Agent, Integer> {
	
	 @Query("from Agent a where a.nom = ?1 and a.prenom = ?2")
	 public Agent findAgentByNomAndPrenom(String nom, String prenom);

    /**
     * Retrieves all the visits for agent.
     * @param id
     * @return
     */
    @Query("select visits from Agent a where a.id = ?1")
     public List<Visite> findVisitsForAgent(Integer id);
}
