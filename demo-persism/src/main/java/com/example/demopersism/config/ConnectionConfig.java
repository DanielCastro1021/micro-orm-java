package com.example.demopersism.config;

import static net.sf.persism.Parameters.*;
import static net.sf.persism.SQL.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConnectionConfig {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
