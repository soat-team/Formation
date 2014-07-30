package fr.soat.interco.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.soat.interco.bean.Agent;

public interface AgentDao extends CrudRepository<Agent, Integer>{
	
	 @Query("from Agent a where a.nom = ?1 and a.prenom = ?2")
	 public Agent findAgentByNomAndPrenom(String nom, String prenom);
}
