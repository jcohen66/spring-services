package com.katonahcomputing.json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public abstract class BaseSingularResponse {

    private String root;

    protected BaseSingularResponse(String rootName) {
        this.root = rootName;
    }

    public String serialize() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().withRootName(root);
        String result = null;
        try {
            result = writer.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            result = e.getMessage();
        }
        return result;
    }
}
