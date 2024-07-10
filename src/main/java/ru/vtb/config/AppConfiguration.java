package ru.vtb.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public HikariDataSource hikariDataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/javapro");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("root");
        hikariConfig.setMaximumPoolSize(5);

        return hikariConfig;
    }

    @Bean
    public String aaa() {
        return "aaaa";
    }
}
