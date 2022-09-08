package com.example.simple_rest_api.config;

import com.example.simple_rest_api.controller.LiveStreamMapper;
import com.example.simple_rest_api.model.LiveStream;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.example.simple_rest_api")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    @Value("${spring.datasource.driverClassName}")
    private String dbDriver;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Bean
    @Qualifier("hikariDataSource")
    public DataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        config.setDriverClassName(dbDriver);
        config.setUsername(dbUser);
        config.setPassword(dbPassword);
        config.addDataSourceProperty("cachePrepStmts", "true");
        return new HikariDataSource(config);
    }

    @Bean
    @Qualifier("liveStreamMapper")
    public RowMapper<LiveStream> liveStreamMapper(){
        return new LiveStreamMapper();
    }
}
