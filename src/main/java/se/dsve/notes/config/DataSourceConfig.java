package se.dsve.notes.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @Value("${DATABASE_USER}")
    private String databaseUser;

    @Value("${DATABASE_PASSWORD}")
    private String databasePassword;

    @Bean
    public DataSource dataSource() {
        // TODO: Implement dataSource
        return null;
    }
}
