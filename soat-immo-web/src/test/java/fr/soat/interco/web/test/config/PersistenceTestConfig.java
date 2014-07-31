package fr.soat.interco.web.test.config;

import fr.soat.interco.config.AbstractConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by formation on 31/07/14.
 */
public class PersistenceTestConfig extends AbstractConfig {



    @Override
    @Bean
    protected DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        driverManagerDataSource.setUrl("jdbc:h2:mem:soatflix;DB_CLOSE_DELAY=-1");
        return driverManagerDataSource;
    }

    @Override
    @Bean
    protected Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }
}
