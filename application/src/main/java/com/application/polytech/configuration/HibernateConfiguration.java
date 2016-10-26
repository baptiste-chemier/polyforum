package com.application.polytech.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Class HibernateConfiguration.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.application.polytech.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

    /** The environment. */
    @Autowired
    private Environment environment;

    /**
     * Session factory.
     *
     * @return the local session factory bean
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(this.dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.websystique.spring.model" });
        sessionFactory.setHibernateProperties(this.hibernateProperties());
        return sessionFactory;
    }

    /**
     * Data source.
     *
     * @return the data source
     */
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(this.environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(this.environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(this.environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    /**
     * Hibernate properties.
     *
     * @return the properties
     */
    private Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", this.environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", this.environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", this.environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    /**
     * Transaction manager.
     *
     * @param s the s
     * @return the hibernate transaction manager
     */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(final SessionFactory s) {
        final HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}
