package com.katonahcomputing.jsonplaceholderservice.controller;

import com.katonahcomputing.jsonplaceholderservice.connector.JSONPlaceholderHttpConnector;
import com.katonahcomputing.jsonplaceholderservice.domain.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("json")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    JSONPlaceholderHttpConnector connector;

    @RequestMapping("user")
    public UserDTO getUserByIndexParam(@RequestParam("index") Long index) throws IOException {
        return connector.getUser(index);
    }

    @RequestMapping("user/{index}")
    public UserDTO getUserByIndexPath(@PathVariable("index") Long index) throws IOException {
        return connector.getUser(index);
    }

    @RequestMapping("users")
    public List<UserDTO> getUser() throws IOException {
        return connector.getUsers();
    }
}
