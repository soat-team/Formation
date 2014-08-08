package fr.soat.interco.web.test;

import fr.soat.interco.bean.Client;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Date;

/**
 * Client service tests.
 */
public class ClientServiceTest extends ParentTests {


    @Test
    public void testSaveClient(){
        Client clientData = new Client();
        clientData.setDate_de_naissance(new Date());
        clientData.setNom("Lamrous");
        clientData.setPrenom("Feriel");
        clientData.setPeriodEssai(false);
        clientData.setSalaire(Double.valueOf(37000.35));

        Client client = clientService.saveClient(clientData);
        Assertions.assertThat(client).isNotNull();
        Assertions.assertThat(client.getNom()).isEqualTo(clientData.getNom());
        Assertions.assertThat(client.getSalaire()).isEqualTo(clientData.getSalaire());
    }


    @Test
    public void testFindClientByNomAndPrenom(){
        Client clientByNomAndPrenom = clientService.findClientByNomAndPrenom("Lamrous", "Feriel");
        Assertions.assertThat(clientByNomAndPrenom).isNotNull();
        Assertions.assertThat(clientByNomAndPrenom.getNom()).isEqualTo("Lamrous");
        Assertions.assertThat(clientByNomAndPrenom.getPrenom()).isEqualTo("Feriel");
    }

    @Test
    public void testFindAllClients(){
        for(int i = 0; i < 5; i++){
            Client clientData = new Client();
            clientData.setDate_de_naissance(new Date());
            clientData.setNom("nom " + i);
            clientData.setPrenom("prenom" + i);
            clientData.setPeriodEssai(false);
            clientData.setSalaire(Double.valueOf(37000.35));
            clientService.saveClient(clientData);
        }

        Iterable<Client> allClients = clientService.findAllClients();
        Assertions.assertThat(allClients).isNotEmpty();
    }


    @Test
    public void testFindClientById(){

        Client clientData = new Client();
        clientData.setDate_de_naissance(new Date());
        clientData.setNom("Lamrous");
        clientData.setPrenom("Feriel");
        clientData.setPeriodEssai(false);
        clientData.setSalaire(Double.valueOf(37000.35));

        Client client = clientService.saveClient(clientData);

        Assertions.assertThat(client).isNotNull();

        Client clientById = clientService.findClientById(client.getIdclient());
        Assertions.assertThat(clientById).isEqualTo(client);
        Assertions.assertThat(clientById.getIdclient()).isEqualTo(client.getIdclient());
    }

    @Test
    public void testDeleteClient(){

        Client clientByNomAndPrenom = clientService.findClientByNomAndPrenom("Lamrous", "Feriel");
        Assertions.assertThat(clientByNomAndPrenom.getNom()).isEqualTo("Lamrous");
        Assertions.assertThat(clientByNomAndPrenom.getPrenom()).isEqualTo("Feriel");

        clientService.deleteClient(clientByNomAndPrenom);
        Client clientById = clientService.findClientById(clientByNomAndPrenom.getIdclient());
        Assertions.assertThat(clientById).isNull();
    }
}
