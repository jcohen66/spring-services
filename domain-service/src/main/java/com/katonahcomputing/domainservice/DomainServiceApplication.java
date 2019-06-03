package com.katonahcomputing.domainservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DomainServiceApplication extends SpringBootServletInitializer {

    private static Logger logger = LoggerFactory.getLogger(DomainServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DomainServiceApplication.class);

        addInitHooks(application);

        application.run(args);
    }

    @PostConstruct
    private void init() {
        logger.info("InitDemoApplication initialization logic ...");
        // ...
    }

    static void addInitHooks(SpringApplication application) {
        application.addListeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
            String version = event.getEnvironment().getProperty("java.runtime.version");
            logger.info("Running with Java {}", version);
        });
    }
}
