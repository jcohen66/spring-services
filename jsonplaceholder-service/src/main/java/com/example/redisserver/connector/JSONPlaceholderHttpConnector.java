package com.example.redisserver.connector;

import com.example.redisserver.domain.*;

import java.util.List;

public interface JSONPlaceholderHttpConnector {
    TodoDTO getTodo(Long index);

    List<TodoDTO> getTodos();

    UserDTO getUser(Long index);

    List<UserDTO> getUsers();

    PhotoDTO getPhoto(Long index);

    List<PhotoDTO> getPhotos();

    PostDTO getPost(Long index);

    List<PostDTO> getPosts();

    CommentDTO getComment(Long index);

    List<CommentDTO> getComments();
}
