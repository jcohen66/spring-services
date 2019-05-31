package com.katonahcomputing.authservice.Controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.katonahcomputing.authservice.model.DetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
public class WebController {

    private Logger logger = LoggerFactory.getLogger(WebController.class);
    private ObjectMapper objectMapper;
    ObjectWriter writer;

    public WebController() {
        objectMapper = new ObjectMapper()
                .findAndRegisterModules()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        writer = objectMapper.writer().withRootName("data");
    }

    @RequestMapping({"/", "index"})
    public String home() {
        return "index";
    }

    @RequestMapping("/private")
    @JsonFormat
    public String webPrivate() throws JsonProcessingException {

        // This should be migrated to a service.
        LocalDate start = LocalDate.now();
        DetailsDTO returnObj = DetailsDTO.builder()
                .startDate(start)
                .endDate(start.plusYears(1))
                .label("Subscription")
                .build();

        String returnVal = "Queried subscription info: " + writer.writeValueAsString(returnObj);
        logger.info(returnVal);

        return returnVal;
    }

    @RequestMapping("/public")
    public String loginpub() {
        return "public";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}