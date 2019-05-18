package com.katonahcomputing.jsonplaceholderservice.controller;

import com.katonahcomputing.jsonplaceholderservice.connector.JSONPlaceholderHttpConnector;
import com.katonahcomputing.jsonplaceholderservice.domain.PostDTO;
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
public class PostController {
    Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    JSONPlaceholderHttpConnector connector;

    @RequestMapping("post")
    public PostDTO getPostByIndexParam(@RequestParam("index") Long index) throws IOException {
        return connector.getPost(index);
    }

    @RequestMapping("post/{index}")
    public PostDTO getPostByIndexPath(@PathVariable("index") Long index) throws IOException {
        return connector.getPost(index);
    }

    @RequestMapping("posts")
    public List<PostDTO> getPost() throws IOException {
        return connector.getPosts();
    }
}
