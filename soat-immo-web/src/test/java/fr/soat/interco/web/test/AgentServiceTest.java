package fr.soat.interco.web.test;

import fr.soat.interco.bean.Agent;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by formation on 06/08/14.
 */
public class AgentServiceTest extends ParentTests {

    @Test
    public void testSaveAgent(){
        Agent agent = new Agent();
        agent.setPrenom("Dimitrov");
        agent.setNom("Charlus");

        Agent saveAgent = agentService.saveAgent(agent);
        Assertions.assertThat(saveAgent).isNotNull();
        Assertions.assertThat(saveAgent.getNom()).isEqualTo("Charlus");
        Assertions.assertThat(saveAgent.getPrenom()).isEqualTo("Dimitrov");
    }

    @Test
    public void testFindAgentByNomAndPrenom(){
        Agent agentByNomAndPrenom = agentService.findAgentByNomAndPrenom("Charlus", "Dimitrov");
        Assertions.assertThat(agentByNomAndPrenom).isNotNull();
        Assertions.assertThat(agentByNomAndPrenom.getNom()).isEqualTo("Charlus");
        Assertions.assertThat(agentByNomAndPrenom.getPrenom()).isEqualTo("Dimitrov");
    }

    @Test
    public void testFindAgentById(){
        Agent agent = new Agent();
        agent.setPrenom("Dimitrov");
        agent.setNom("Charlus");

        Agent saveAgent = agentService.saveAgent(agent);
        Assertions.assertThat(saveAgent).isNotNull();

        Agent agentById = agentService.findAgentById(saveAgent.getIdAgent());
        Assertions.assertThat(agentById.getNom()).isEqualTo(agent.getNom());
        Assertions.assertThat(agentById.getPrenom()).isEqualTo(agent.getPrenom());
    }

    @Test
    public void findAllAgents(){
        for(int i = 0; i < 5; i++){
            Agent agent = new Agent();
            agent.setNom("NOM + " + i);
            agent.setPrenom("PRENOM " + i);
            agentService.saveAgent(agent);
        }

        Iterable<Agent> allAgents = agentService.findAllAgents();
        Assertions.assertThat(allAgents).isNotEmpty();
    }



}
