package fr.soat.interco.web.controller;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.bean.Visite;
import fr.soat.interco.dao.VisiteDao;
import fr.soat.interco.web.service.AgentService;
import fr.soat.interco.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by formation on 21/08/14.
 */
@Controller
public class AgentController {

    @Autowired
    private AgentService agentService;

    @Autowired
    private UserService userService;

    @Autowired
    private VisiteDao visiteDao;

    /**
     * This method retrieves all the clients in the database.
     * But only an admin can access to all the client.
     */
    @RequestMapping(value = "/soat/immo/agents")
    @ResponseBody
    public Iterable<Agent> getAllClients() {
        Iterable<Agent> allClients = agentService.findAllAgents();
        return allClients;
    }

    /**
     * This method returns the client for the current id.
     * When a client is authenticated, he is redirected to his profile page
     * with the current url. If it's an agent, it access the profile information
     * of the client
     *
     * @param idAgent the id of the client.
     * @return the client for the specified id.
     */
    @RequestMapping(value = "/soat/immo/agents/{idAgent}")
    @ResponseBody
    public Agent getClient(@PathVariable("idAgent") Long idAgent) {
        return agentService.findAgentById(idAgent);
    }



    /**
     *
     * @param login
     * @param password
     * @param response
     * @return
     * @throws java.io.IOException
     */
    @RequestMapping(value = "/soat/immot/agents/auth", method = RequestMethod.GET)
    @ResponseBody
    public Agent authenticateClient(@RequestParam("login") String login,
                                     @RequestParam("login") String password, HttpServletResponse response) throws IOException {
        Agent client = userService.authenticateAgent(login, password);
        if (client == null) {
            response.setContentType("application/json");
            response.sendError(404, "client not found");
            return null;
        }
        return client;
    }


    /**
     *
     * @param idAgent
     * @return
     */
    @RequestMapping(value = "/soat/immo/agents/{idAgent}/visits")
    @ResponseBody
    public List<Visite> findVisitsForClient(@PathVariable("idAgent") Long idAgent){
        Agent agent = agentService.findAgentById(idAgent);
        return agent.getVisits();
    }

    /**
     *
     * @param idAgent
     * @param idVisite
     * @return
     */
    @RequestMapping(value = "/soat/immo/clients/{idAgent}/visits/{idVisite}")
    @ResponseBody
    public Visite getVisitForClient(@PathVariable("idAgent") Long idAgent, @PathVariable("idVisite") Long idVisite){
        return visiteDao.findVisiteForAgent(idAgent,idVisite);
    }
}
