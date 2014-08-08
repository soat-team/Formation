package fr.soat.interco.web.test;

import fr.soat.interco.web.service.AgentService;
import fr.soat.interco.web.service.BienImmoService;
import fr.soat.interco.web.service.ClientService;
import fr.soat.interco.web.service.VisiteService;
import fr.soat.interco.web.test.config.WebConfigTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  WebConfigTest.class)
public class ParentTests {

    @Autowired
    protected AgentService agentService;

    @Autowired
    protected ClientService clientService;

    @Autowired
    protected BienImmoService bienImmoService;

    @Autowired
    protected VisiteService visiteService;

    @Test
    public void testIfServiceIsBootStrapped(){
        Assertions.assertThat(agentService).isNotNull();
        Assertions.assertThat(clientService).isNotNull();
        Assertions.assertThat(bienImmoService).isNotNull();
        Assertions.assertThat(visiteService).isNotNull();
    }
}
