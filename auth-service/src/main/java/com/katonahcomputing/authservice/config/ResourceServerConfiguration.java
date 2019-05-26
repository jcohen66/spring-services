package com.katonahcomputing.authservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


/**
 * The ResourceServer hosts the REST API the client
 * is interested in.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/publishes").permitAll();
        // .anyRequest (). authenticated ();
        http.requestMatchers().antMatchers("/private") // Deny access to "/ private"
                .and().authorizeRequests()
                .antMatchers("/private").access("hasRole ('USER')")
                .and().requestMatchers().antMatchers("/admin") // Deny access to "/ admin"
                .and().authorizeRequests()
                .antMatchers("/admin").access("hasRole ('ADMIN')");
    }
}
