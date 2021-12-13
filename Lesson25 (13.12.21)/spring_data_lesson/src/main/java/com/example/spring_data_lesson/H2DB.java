package com.example.spring_data_lesson;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class H2DB {
    static {
        try{
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @Bean
    public static DataSource getDataSource(){
        JdbcDataSource h2DataSource = new JdbcDataSource();
        h2DataSource.setUser("sa");
        h2DataSource.setPassword("");
        h2DataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        return h2DataSource;
    }
}
