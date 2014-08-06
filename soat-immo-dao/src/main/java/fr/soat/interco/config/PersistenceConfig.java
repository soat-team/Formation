package fr.soat.interco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by formation on 30/07/14.
 */
@Configuration
@EnableJpaRepositories(ConfigUtils.BASE_PACKAGE_TO_SCAN)
@EnableTransactionManagement
public class PersistenceConfig extends AbstractConfig {

    @Bean
    @Override
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/SoatImmo");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("formation");
        return driverManagerDataSource;
    }

    @Override
    protected Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        //properties.setProperty("hibernate.ejb.naming_strategy", "fr.soat.interco.config.utils.CustomNamingStrategy");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }
}
