package fr.soat.interco.controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoaderListener;

/**
 * Created by formation on 04/08/14.
 */
@Controller
@RequestMapping("/")
public class ControllerExample {


    @RequestMapping("/hello")
    public String hello(){
        return "index.jsp";
    }
}
