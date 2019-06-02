package com.katonahcomputing.domainservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.katonahcomputing.domainservice.model.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class GenericResponseController {

    private Logger logger = LoggerFactory.getLogger(WebController.class);
    private ObjectMapper objectMapper;
    ObjectWriter writer;

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
