package com.xenenergy.projects.dbconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@PropertySource({ "classpath:config/application.properties" })
@EnableJpaRepositories(
        basePackages = "com.xenenergy.projects.dao.arm",
        entityManagerFactoryRef = "armEntityManager",
        transactionManagerRef = "armTransactionManager"

)
public class DbConfigArm {
    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean armEntityManager() {
            LocalContainerEntityManagerFactoryBean em
                    = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(armDataSource());
            em.setPackagesToScan(
                    new String[] { "com.xenenergy.projects.entities.arm" });
            HibernateJpaVendorAdapter vendorAdapter
                    = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(vendorAdapter);
            HashMap<String, Object> properties = new HashMap<>();
            properties.put("spring.jpa.hibernate.ddl-auto",
                    env.getProperty("spring.jpa.hibernate.ddl-auto"));
            properties.put("spring.jpa.properties.hibernate.dialect",
                    env.getProperty("spring.jpa.properties.hibernate.dialect"));
            em.setJpaPropertyMap(properties);
            return em;
    }

    @Primary
    @Bean
    public DataSource armDataSource() {
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("spring.datasource.arm.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.arm.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.arm.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.arm.password"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager armTransactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                armEntityManager().getObject());
        return transactionManager;
    }
}
