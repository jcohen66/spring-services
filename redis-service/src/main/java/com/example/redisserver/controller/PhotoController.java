package com.example.redisserver.controller;

import com.example.redisserver.connector.JSONPlaceholderHttpConnector;
import com.example.redisserver.domain.PhotoDTO;
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
public class PhotoController {
    Logger logger = LoggerFactory.getLogger(PhotoController.class);

    @Autowired
    JSONPlaceholderHttpConnector connector;

    @RequestMapping("photo")
    public PhotoDTO getPhotoByIndexParam(@RequestParam("index") Long index) throws IOException {
        return connector.getPhoto(index);
    }

    @RequestMapping("photo/{index}")
    public PhotoDTO getPhotoByIndexPath(@PathVariable("index") Long index) throws IOException {
        return connector.getPhoto(index);
    }

    @RequestMapping("photos")
    public List<PhotoDTO> getTodos() throws IOException {
        return connector.getPhotos();
    }
}
