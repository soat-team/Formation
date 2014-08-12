package fr.soat.interco.web.test;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.web.service.AgentService;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Agent Service Test.
 */
public class AgentServiceTest extends ParentTests {

    private static final int NB_AGENTS = 10;
    private static final String AGENT_NAME = "NOM_";
    private static final String AGENT_FNAME = "PRENOM_";
    private final Random random = new Random();

    @Autowired
    private AgentService agentService;

    @Before
    public void setupData(){
        Assertions.assertThat(agentService).isNotNull();
        for(int i = 0; i < NB_AGENTS; i++){
            Agent agent = new Agent();
            agent.setNom(AGENT_NAME + i);
            agent.setPrenom(AGENT_FNAME + i);
            agentService.saveAgent(agent);
        }

        Iterable<Agent> allAgents = agentService.findAllAgents();
        Assertions.assertThat(allAgents).isNotEmpty();
    }


    @Test
    public void testAllAgentService(){

        int randomId = random.nextInt(NB_AGENTS);

        //Test save agent
        Agent agent = createAgent("Charles", "Dimitri");
        Agent saveAgent = agentService.saveAgent(agent);
        Assertions.assertThat(saveAgent).isNotNull();
        Assertions.assertThat(saveAgent).isEqualTo(agent);

        //Test findAllAgents
        Iterable<Agent> allAgents = agentService.findAllAgents();
        Assertions.assertThat(allAgents).isNotEmpty();
        Assertions.assertThat(allAgents).hasSize(NB_AGENTS + 1);

        //Test findAgentByNomAndPrenom
        Agent agentByNomAndPrenom =
                agentService.findAgentByNomAndPrenom(AGENT_NAME + randomId,
                        AGENT_FNAME + randomId);
        Assertions.assertThat(agentByNomAndPrenom).isNotNull();
        Assertions.assertThat(agentByNomAndPrenom.getNom()).isEqualTo(AGENT_NAME+randomId );
        Assertions.assertThat(agentByNomAndPrenom.getPrenom()).isEqualTo(AGENT_FNAME+randomId);
        Assertions.assertThat(agentByNomAndPrenom.getIdAgent()).isNotNull();

        //test findAgentById
        Agent agentById = agentService.findAgentById(Integer.valueOf(randomId));
        Assertions.assertThat(agentById).isNotNull();
        Assertions.assertThat(agentById.getNom()).isEqualTo(AGENT_NAME+(randomId-1));
        Assertions.assertThat(agentById.getPrenom()).isEqualTo(AGENT_FNAME + (randomId-1));
        Assertions.assertThat(agentById.getIdAgent()).isNotNull();


        //test deleteAgent
        Integer idAgent = agentById.getIdAgent();
        agentService.deleteAgent(agentById);
        Agent agentById1 = agentService.findAgentById(idAgent);
        Assertions.assertThat(agentById1).isNull();
    }


    @After
    public void dropData(){
        Iterable<Agent> allAgents = agentService.findAllAgents();
        Assertions.assertThat(allAgents).isNotEmpty();

        for(Agent agent : allAgents){
            agentService.deleteAgent(agent);
        }

        allAgents = agentService.findAllAgents();
        Assertions.assertThat(allAgents).isEmpty();
    }


    /*
    *
    * ECRIRE CAS de test non nominaux pour chaque méthode qui échoue
    * ****************************************
     */

    private Agent createAgent(String nom, String prenom){
        Agent agent = new Agent();
        agent.setNom(nom);
        agent.setPrenom(prenom);
        return agent;
    }

}
