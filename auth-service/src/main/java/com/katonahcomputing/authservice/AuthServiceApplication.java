package com.katonahcomputing.authservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;


@SpringBootApplication
@EnableJpaRepositories("com.katonahcomputing.dao")
public class AuthServiceApplication extends SpringBootServletInitializer {

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}