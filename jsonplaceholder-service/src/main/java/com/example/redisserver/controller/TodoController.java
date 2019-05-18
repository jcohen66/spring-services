package com.example.redisserver.controller;

import com.example.redisserver.connector.JSONPlaceholderHttpConnector;
import com.example.redisserver.domain.TodoDTO;
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
public class TodoController {
    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    JSONPlaceholderHttpConnector connector;

    @RequestMapping("todo")
    public TodoDTO getTodoByIndexParam(@RequestParam("index") Long index) throws IOException {
        return connector.getTodo(index);
    }

    @RequestMapping("todo/{index}")
    public TodoDTO getTodoByIndexPath(@PathVariable("index") Long index) throws IOException {
        return connector.getTodo(index);
    }

    @RequestMapping("todos")
    public List<TodoDTO> getTodos() throws IOException {
        return connector.getTodos();
    }
}
