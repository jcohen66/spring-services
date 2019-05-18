package com.katonahcomputing.redisservice.connector;

import com.katonahcomputing.jsonplaceholderservice.connector.JSONPlaceholderHttpConnectorImpl;
import com.katonahcomputing.jsonplaceholderservice.domain.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class JSONPlaceholderConnectorTest {

    private String url = "https://jsonplaceholder.typicode.com/todos/1";


    @Mock
    private JSONPlaceholderHttpConnectorImpl connector;


    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedTodoObject() {
        TodoDTO todo = TodoDTO.builder()
                .userId(1L)
                .id(2L)
                .title("I am human")
                .completed(true)
                .build();

        Long id = 1L;

        Mockito
                .when(connector.getTodo(1L))
                .thenReturn(todo);

        TodoDTO todoCompare = connector.getTodo(id);
        Assert.assertEquals(todo, todoCompare);
    }

    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedCommentObject() {
        CommentDTO comment = CommentDTO.builder()
                .userId(1L)
                .id(2L)
                .email("me@gmail.com")
                .name("tom Jones")
                .body("audantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium")
                .build();

        Long id = 1L;

        Mockito
                .when(connector.getComment(1L))
                .thenReturn(comment);

        CommentDTO commentCompare = connector.getComment(id);
        Assert.assertEquals(comment, commentCompare);
    }

    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedPhotoObject() {
        PhotoDTO photo = PhotoDTO.builder()
                .albumId(1L)
                .id(1L)
                .thumbnailUrl("google.com/photo-1.jpg")
                .title("Aye, yer not hailing me without an amnesty!")
                .build();

        Long id = 1L;

        Mockito
                .when(connector.getPhoto(1L))
                .thenReturn(photo);

        PhotoDTO photoCompare = connector.getPhoto(id);
        Assert.assertEquals(photo, photoCompare);
    }

    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedPostObject() {
        PostDTO post = PostDTO.builder()
                .userId(1L)
                .id(1L)
                .body("The sainthood is a superior sinner.")
                .title("Aye, yer not hailing me without an amnesty!")
                .build();

        Long id = 1L;

        Mockito
                .when(connector.getPost(1L))
                .thenReturn(post);

        PostDTO postCompare = connector.getPost(id);
        Assert.assertEquals(post, postCompare);
    }

    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedUserObject() {

        GeoDTO geo = GeoDTO.builder()
                .lat("79.3214")
                .lng("34.5412")
                .build();

        AddressDTO address = AddressDTO.builder()
                .street("123 Oak St.")
                .city("Anytown")
                .zipcode("12345")
                .suite("24")
                .geo(geo)
                .build();


        UserDTO user = UserDTO.builder()
                .name("Tom Jones")
                .username("tjones")
                .id(1L)
                .address(address)
                .build();

        Long id = 1L;

        Mockito
                .when(connector.getUser(1L))
                .thenReturn(user);

        UserDTO userCompare = connector.getUser(id);
        Assert.assertEquals(user, userCompare);
    }
}
