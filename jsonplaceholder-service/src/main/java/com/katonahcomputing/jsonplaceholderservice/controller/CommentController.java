package com.katonahcomputing.jsonplaceholderservice.controller;

import com.katonahcomputing.jsonplaceholderservice.connector.JSONPlaceholderHttpConnector;

import com.katonahcomputing.jsonplaceholderservice.domain.CommentDTO;
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
public class CommentController {
    Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    JSONPlaceholderHttpConnector connector;

    @RequestMapping("comment")
    public CommentDTO getCommentByIndexParam(@RequestParam("index") Long index) throws IOException {
        return connector.getComment(index);
    }

    @RequestMapping("comment/{index}")
    public CommentDTO getCommentByIndexPath(@PathVariable("index") Long index) throws IOException {
        return connector.getComment(index);
    }

    @RequestMapping("comments")
    public List<CommentDTO> getComment() throws IOException {
        return connector.getComments();
    }
}
