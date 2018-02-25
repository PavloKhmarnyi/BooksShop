package com.pavlo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by pavlo on 2/25/2018.
 */

@Configuration
@Profile(value = "local")
public class LocalDataSourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String dbDriverClass;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource bookDataSource() throws SQLException, ClassNotFoundException {
        SimpleDriverDataSource targetDataSource = new SimpleDriverDataSource();
        targetDataSource.setDriverClass((Class<? extends java.sql.Driver>) Class.forName(dbDriverClass));
        targetDataSource.setUrl(url);
        targetDataSource.setUsername(username);
        targetDataSource.setPassword(password);
        return targetDataSource;
    }
}
