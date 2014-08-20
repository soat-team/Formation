package fr.soat.interco.web.controller;

import fr.soat.interco.web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Client Controller.
 */
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;


}
