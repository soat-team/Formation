package fr.soat.interco.web.test.service;

import fr.soat.interco.bean.Client;
import fr.soat.interco.web.service.ClientService;
import fr.soat.interco.web.test.ParentTests;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Client Service Test.
 */
public class ClientServiceTest extends ParentTests {

    private static final int NB_CLIENTS = 10;
    private static final String AGENT_NAME = "NOM_";
    private static final String AGENT_FNAME = "PRENOM_";
    private final Random random = new Random();

    @Autowired
    private ClientService clientService;

    @Before
    public void setupData(){

        Assertions.assertThat(clientService).isNotNull();

        for(int i = 0; i < NB_CLIENTS; i++){
            Client Client = new Client();
            Client.setNom(AGENT_NAME + i);
            Client.setPrenom(AGENT_FNAME + i);
            clientService.saveClient(Client);
        }

        Iterable<Client> allAgents = clientService.findAllClients();
        Assertions.assertThat(allAgents).isNotEmpty();
    }


    @Test
    public void testAllClientsService(){

        int randomId = random.nextInt(NB_CLIENTS);

        //Test save Client
        Client Client = createClient("Charles", "Dimitri");
        Client saveClient = clientService.saveClient(Client);
        Assertions.assertThat(saveClient).isNotNull();
        Assertions.assertThat(saveClient).isEqualTo(Client);

        //Test findAllAgents
        Iterable<Client> allClients = clientService.findAllClients();
        Assertions.assertThat(allClients).isNotEmpty();
        Assertions.assertThat(allClients).hasSize(NB_CLIENTS + 1);

        //Test findAgentByNomAndPrenom
        Client clientByNomAndPrenom =
                clientService.findClientByNomAndPrenom(AGENT_NAME + randomId,
                        AGENT_FNAME + randomId);
        Assertions.assertThat(clientByNomAndPrenom).isNotNull();
        Assertions.assertThat(clientByNomAndPrenom.getNom()).isEqualTo(AGENT_NAME + randomId);
        Assertions.assertThat(clientByNomAndPrenom.getPrenom()).isEqualTo(AGENT_FNAME + randomId);
        Assertions.assertThat(clientByNomAndPrenom.getIdclient()).isNotNull();

        //test findAgentById
        Client clientById = clientService.findClientById(Long.valueOf(randomId));
        Assertions.assertThat(clientById).isNotNull();
        Assertions.assertThat(clientById.getNom()).isEqualTo(AGENT_NAME + (randomId - 1));
        Assertions.assertThat(clientById.getPrenom()).isEqualTo(AGENT_FNAME + (randomId - 1));
        Assertions.assertThat(clientById.getIdclient()).isNotNull();


        //test deleteAgent
        Long idclient = clientById.getIdclient();
        clientService.deleteClient(clientById);
        Client clientById1 = clientService.findClientById(idclient);
        Assertions.assertThat(clientById1).isNull();
    }


    @After
    public void dropData(){
        Iterable<Client> allClients = clientService.findAllClients();
        Assertions.assertThat(allClients).isNotEmpty();

        for(Client Client : allClients){
            clientService.deleteClient(Client);
        }

        allClients = clientService.findAllClients();
        Assertions.assertThat(allClients).isEmpty();
    }


    /*
    *
    * ECRIRE CAS de test non nominaux pour chaque méthode qui échoue
    * ****************************************
     */
     
    private Client createClient(String nom, String prenom){
        Client Client = new Client();
        Client.setNom(nom);
        Client.setPrenom(prenom);
        return Client;
    }

}
