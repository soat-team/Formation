package fr.soat.interco.web.service;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.dao.AgentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentDao agentDao;
	
	@Override
	public Agent findAgentByNomAndPrenom(String nom, String prenom) {
		return agentDao.findAgentByNomAndPrenom(nom, prenom);
	}

	@Override
	public Iterable<Agent> findAllAgents() {
		return agentDao.findAll();
	}

	@Override
	public Agent saveAgent(Agent agent) {
		return agentDao.save(agent);
	}

	@Override
	public Agent findAgentById(Integer id) {
		return agentDao.findOne(id);
	}

	@Override
	public void deleteAgent(Agent agent) {
		agentDao.delete(agent);
	}

}
