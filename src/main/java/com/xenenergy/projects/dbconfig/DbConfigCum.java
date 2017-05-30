package com.xenenergy.projects.dbconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Configuration
@PropertySource({"classpath:config/application.properties"})
@EnableJpaRepositories(
        basePackages = "com.xenenergy.projects.dao.cum",
        entityManagerFactoryRef = "cumEntityManager",
        transactionManagerRef = "cumTransactionManager"
)
public class DbConfigCum {
    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean cumEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(cumDataSource());
        em.setPackagesToScan(
                new String[]{"com.xenenergy.projects.entities.cum"});
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("spring.jpa.hibernate.ddl-auto",
                env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("spring.jpa.properties.hibernate.dialect",
                env.getProperty("spring.jpa.properties.hibernate.dialect"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    public DataSource cumDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("spring.datasource.cum.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.cum.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.cum.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.cum.password"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager cumTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                cumEntityManager().getObject());
        return transactionManager;
    }
}
