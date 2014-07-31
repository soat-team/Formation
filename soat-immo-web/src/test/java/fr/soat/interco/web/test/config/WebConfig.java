package fr.soat.interco.web.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by formation on 31/07/14.
 */
@WebAppConfiguration
@ImportResource({"classpath:application-config-test.xml"})
public class WebConfig {
}
