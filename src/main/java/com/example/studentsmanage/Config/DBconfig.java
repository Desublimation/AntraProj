package com.example.studentsmanage.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@ComponentScan("com.example.studentsmanage")
public class DBconfig {
    public DBconfig() {}
//    private Properties loadProperties() {
//        Properties properties = new Properties();
//        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db-config.properties")) {
//            if (input == null) {
//                throw new RuntimeException("Database configuration file not found in resources folder");
//            }
//            properties.load(input);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to load database configuration", e);
//        }
//        return properties;
//    }

    @Bean
    public DataSource dataSource() {
//        Properties properties = loadProperties();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/antra");
        dataSource.setUsername("root");
        dataSource.setPassword("hua12345");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
