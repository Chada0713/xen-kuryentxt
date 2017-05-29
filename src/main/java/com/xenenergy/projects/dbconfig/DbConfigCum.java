package com.xenenergy.projects.dbconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "cumEntityManager",
        transactionManagerRef = "cumTransactionManager",
        basePackages = "com.xenenergy.projects.dao.cum"
)
public class DbConfigCum {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.cum.url")
    public DataSourceProperties cumDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.cum.url")
    public DataSource cumDataSource() {
        return cumDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "cumEntityManager")
    public LocalContainerEntityManagerFactoryBean cumEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(cumDataSource())
                .packages("com.xenenergy.projects.entities.cum")
                .persistenceUnit("cum")
                .build();
    }

    @Bean(name = "cumTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("cumEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
