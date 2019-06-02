package com.katonahcomputing.domainservice.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.katonahcomputing.domainservice.model.DetailsDTO;
import com.katonahcomputing.domainservice.model.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sayHello() throws JSONException {
        //Get data from service layer into entityList.
        List<Entity> entityList = new ArrayList<>();

        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (Entity n : entityList) {
            JSONObject entity = new JSONObject();
            entity.put("aa", "bb");
            entities.add(entity);
        }
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    /**
     * Receive the JSON object without having to know the request payload
     * structure and without having to use the Java domain object.
     * <p>
     * Request payload can change without having to change controller code.
     *
     * @param jsonNode
     * @return
     */
    @RequestMapping(value = "/ping", method = RequestMethod.POST)
    public JsonNode ping(@RequestBody JsonNode jsonNode) {
        logger.info("Received JSON:" + jsonNode.toString());
        return jsonNode;
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public JsonNode index(@RequestBody JsonNode jsonNode) {
        logger.info("Received JSON:" + jsonNode.toString());

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<JsonNode> request = new HttpEntity<>(jsonNode);

        String url = "http://localhost:9004/api/v1/submitRequest";
        ResponseEntity<JsonNode> response =
                restTemplate.exchange(url,
                        HttpMethod.POST,
                        request,
                        JsonNode.class);
        JsonNode responsePayload = response.getBody();
        return responsePayload;
    }


    @RequestMapping("/submitRequest")
    public ResponseObject processRequest(@RequestBody JsonNode request) {

        logger.info("Request:" + request);
        ResponseObject response = ResponseObject.builder()
                .responseMessage("Processed Successfully")
                .responseStatus("Success")
                .build();

        return response;
    }
}
