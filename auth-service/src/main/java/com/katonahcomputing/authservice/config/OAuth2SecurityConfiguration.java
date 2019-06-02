package com.katonahcomputing.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


/**
 * This is used for web login/authorization.  Usually this should be
 * read from the database.
 */
@Configuration
@EnableWebSecurity
public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        UserDetails user = User.builder().username("user")
                .password("{noop}secret")
                .roles("USER").build();
        UserDetails userAdmin = User.builder().username("admin")
                .password("{noop}secret")
                .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user, userAdmin);
        // return new JdbcUserDetailsManager(dataSource);
    }

    /*
    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
    */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/api/v1/index", "/api/v1/public").permitAll()
                .antMatchers("/api/v1/private").authenticated()
                .antMatchers("/api/v1/admin").hasRole("ADMIN").and()
                .formLogin()
                .loginPage("/api/v1/login")
                .permitAll()
                .and()
                .logout() // Method get then I have disabled CSRF
                .permitAll();
    }
}
