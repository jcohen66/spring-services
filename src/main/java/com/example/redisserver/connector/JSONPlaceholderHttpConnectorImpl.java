package com.example.redisserver.connector;

import com.example.redisserver.domain.*;
import com.example.redisserver.exception.RestTemplateResponseErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JSONPlaceholderHttpConnectorImpl implements JSONPlaceholderHttpConnector {
    Logger logger = LoggerFactory.getLogger(JSONPlaceholderHttpConnectorImpl.class);


    @Value("${jsonplaceholder.url}")
    private String url;

    private final RestTemplate restTemplate;

    public JSONPlaceholderHttpConnectorImpl(RestTemplateBuilder restTemplateBuilder) {

        restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    @Override
    public TodoDTO getTodo(Long index) {
        String request = url + "/todos/" + index;
        ResponseEntity<TodoDTO> response = restTemplate.getForEntity(request, TodoDTO.class);
        logger.info("Request: " + request);
        logger.info("Response: " + response.getStatusCode());
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

    @Override
    public List<TodoDTO> getTodos() {
        String request = url + "/todos";
        ResponseEntity<List<TodoDTO>> response = restTemplate.exchange(
                request,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TodoDTO>>() {});
        logger.info("Request: " + request);
        logger.info("Response: " + response.getStatusCode());
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

    @Override
    public UserDTO getUser(Long index) {
        String request = url + "/users/" + index;
        ResponseEntity<UserDTO> response = restTemplate.getForEntity(request, UserDTO.class);
        logger.info("Request: " + request);
        logger.info("Response: " + response.getStatusCode());
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

    @Override
    public List<UserDTO> getUsers() {
        String request = url + "/users";
        ResponseEntity<List<UserDTO>> response = restTemplate.exchange(
                request,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserDTO>>() {});
        logger.info("Request: " + request);
        logger.info("Response: " + response.getStatusCode());
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

    @Override
    public PhotoDTO getPhoto(Long index) {
        String request = url + "/photos/" + index;
        ResponseEntity<PhotoDTO> response = restTemplate.getForEntity(request, PhotoDTO.class);
        logger.info("Request: " + request);
        logger.info("Response: " + response.getStatusCode());
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

    @Override
    public List<PhotoDTO> getPhotos() {
        String request = url + "/photos";
        ResponseEntity<List<PhotoDTO>> response = restTemplate.exchange(
                request,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PhotoDTO>>() {});
        logger.info("Request: " + request);
        logger.info("Response: " + response.getStatusCode());
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

    @Override
    public PostDTO getPost(Long index) {
        String request = url + "/posts/" + index;
        ResponseEntity<PostDTO> response = restTemplate.getForEntity(request, PostDTO.class);
        logger.info("Request: " + request);
        logger.info("Response: " + response.getStatusCode());
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

    @Override
    public List<PostDTO> getPosts() {
        String request = url + "/posts";
        ResponseEntity<List<PostDTO>> response = restTemplate.exchange(
                request,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PostDTO>>() {});
        logger.info("Request: " + request);
        logger.info("Response: " + response.getStatusCode());
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

    @Override
    public CommentDTO getComment(Long index) {
        String request = url + "/comments/" + index;
        ResponseEntity<CommentDTO> response = restTemplate.getForEntity(request, CommentDTO.class);
        logger.info("Request: " + request);
        logger.info("Response: " + response.getStatusCode());
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

    @Override
    public List<CommentDTO> getComments() {
        String request = url + "/comments";
        ResponseEntity<List<CommentDTO>> response = restTemplate.exchange(
                request,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CommentDTO>>() {});
        logger.info("Request: " + request);
        logger.info("Response: " + response.getStatusCode());
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

}
