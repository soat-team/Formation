package fr.soat.interco.web.service;

import fr.soat.interco.bean.Client;
import fr.soat.interco.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Implementation des services pour le client.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public Client findClientByNomAndPrenom(String nom, String prenom) {
        return clientDao.findClientByNomAndPrenom(nom, prenom);
    }

    @Override
    public Iterable<Client> findAllClients() {
        return clientDao.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return clientDao.save(client);
    }

    @Override
    public Client findClientById(Long id) {
        return clientDao.findOne(id);
    }

    @Override
    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
}
