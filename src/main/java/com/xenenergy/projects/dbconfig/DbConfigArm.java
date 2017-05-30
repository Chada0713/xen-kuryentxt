package com.xenenergy.projects.dbconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
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
        entityManagerFactoryRef = "armEntityManager",
        transactionManagerRef = "armTransactionManager",
        basePackages = "com.xenenergy.projects.dao.arm"
)
public class DbConfigArm {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.url")
    public DataSourceProperties armDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "dsArm")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.url")
    public DataSource armDataSource() {
        return armDataSourceProperties().initializeDataSourceBuilder().build();
    }


    @Primary
    @Bean(name = "armEntityManager")
    public LocalContainerEntityManagerFactoryBean armEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(armDataSource())
                .packages("com.xenenergy.projects.entities.arm")
                .persistenceUnit("arm")
                .build();
    }

    @Primary
    @Bean(name = "armTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("armEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
