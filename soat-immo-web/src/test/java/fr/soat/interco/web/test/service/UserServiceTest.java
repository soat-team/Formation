package fr.soat.interco.web.test.service;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.User;
import fr.soat.interco.web.service.AgentService;
import fr.soat.interco.web.service.ClientService;
import fr.soat.interco.web.service.UserService;
import fr.soat.interco.web.test.ParentTests;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User service test.
 */
public class UserServiceTest extends ParentTests {

    @Autowired
    private UserService userService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private ClientService clientService;

    private static final String LOGIN_AGENT = "login";
    private static final String PASS_AGENT = "123456";

    private static final String LOGIN_CLIENT = "client_login";
    private static final String PASS_CLIENT = "987654";

    private Agent agent;
    private Client client;


    @Before
    public void setupData(){
        User userAgent = User.create().withLogin(LOGIN_AGENT)
                .withPassword(PASS_AGENT).build();

        User userClient = User.create()
                .withLogin(LOGIN_CLIENT).withPassword(PASS_CLIENT).build();


        agent = Agent.create().withNom("Charles").withPrenom("Dimitri")
                .withUser(userAgent).build();

        client = Client.create().withPrenom("Clarence").withNom("Charles")
                        .withUser(userClient).build();

        userService.saveUser(userAgent);
        userService.saveUser(userClient);

        agentService.saveAgent(agent);
        clientService.saveClient(client);
    }

    @Test
    public void testUserService(){
        Iterable<Agent> allAgents = agentService.findAllAgents();
        Assertions.assertThat(allAgents).isNotEmpty();
        Assertions.assertThat(allAgents).hasSize(1);

        Iterable<Client> allClients = clientService.findAllClients();
        Assertions.assertThat(allClients).isNotEmpty();
        Assertions.assertThat(allClients).hasSize(1);


        Agent agentAuthenticated = userService.authenticateAgent(LOGIN_AGENT, PASS_AGENT);
        Assertions.assertThat(agentAuthenticated).isNotNull();
        Assertions.assertThat(agentAuthenticated).isEqualTo(agent);

        Client authenticateClient = userService.authenticateClient(LOGIN_CLIENT, PASS_CLIENT);
        Assertions.assertThat(authenticateClient).isNotNull();
        Assertions.assertThat(authenticateClient).isEqualTo(client);
    }
}
