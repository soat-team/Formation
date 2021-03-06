package fr.soat.interco.web.controller;

import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.Visite;
import fr.soat.interco.dao.VisiteDao;
import fr.soat.interco.web.service.ClientService;
import fr.soat.interco.web.service.UserService;
import fr.soat.interco.web.service.VisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Client Controller.
 */
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @Autowired
    private VisiteDao visiteDao;


    /**
     * This method retrieves all the clients in the database.
     * But only an admin can access to all the client.
     */
    @RequestMapping(value = "/soat/immo/clients")
    @ResponseBody
    public Iterable<Client> getAllClients() {
        Iterable<Client> allClients = clientService.findAllClients();
        return allClients;
    }

    /**
     * This method returns the client for the current id.
     * When a client is authenticated, he is redirected to his profile page
     * with the current url. If it's an agent, it access the profile information
     * of the client
     *
     * @param idClient the id of the client.
     * @return the client for the specified id.
     */
    @RequestMapping(value = "/soat/immo/clients/{idClient}")
    @ResponseBody
    public Client getClient(@PathVariable("idClient") Long idClient) {
        return clientService.findClientById(idClient);
    }


    /**
     *
     * @param login
     * @param password
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/soat/immot/clients/auth", method = RequestMethod.GET)
    @ResponseBody
    public Client authenticateClient(@RequestParam("login") String login,
                                     @RequestParam("login") String password, HttpServletResponse response) throws IOException {
        Client client = userService.authenticateClient(login, password);
        if (client == null) {
            response.setContentType("application/json");
            response.sendError(404, "client not found");
            return null;
        }
        return client;
    }


    /**
     *
     * @param idClient
     * @return
     */
    @RequestMapping(value = "/soat/immo/clients/{idClient}/visits")
    @ResponseBody
    public List<Visite> findVisitsForClient(@PathVariable("idClient") Long idClient){
        Client client = clientService.findClientById(idClient);
        return client.getVisits();
    }

    /**
     *
     * @param idClient
     * @param idVisite
     * @return
     */
    @RequestMapping(value = "/soat/immo/clients/{idClient}/visits/{idVisite}")
    @ResponseBody
    public Visite getVisitForClient(@PathVariable("idClient") Long idClient, @PathVariable("idVisite") Long idVisite){
        return visiteDao.findVisiteForClient(idClient,idVisite);
    }
}
