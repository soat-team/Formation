package fr.soat.interco.web.service;

import fr.soat.interco.bean.Client;
import fr.soat.interco.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by formation on 31/07/14.
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
    public Client findClientById(Integer id) {
        return clientDao.findOne(id);
    }

    @Override
    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
}
