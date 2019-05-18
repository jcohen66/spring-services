package com.example.redisserver.Exception;

import com.example.redisserver.domain.TodoDTO;
import com.example.redisserver.exception.NotFoundException;
import com.example.redisserver.exception.RestTemplateResponseErrorHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {NotFoundException.class, TodoDTO.class})
@RestClientTest
public class RestTemplateResponseErrorHandlerIntegrationTest {

    private String url = "https://jsonplaceholder.typicode.com/todos/20000";
    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private RestTemplateBuilder builder;

    @Test(expected = NotFoundException.class)
    public void givenRemoteApiCall_when404Error_thenThrowNotFoundException() {
        Assert.assertNotNull(this.builder);
        Assert.assertNotNull(this.server);

        RestTemplate restTemplate = this.builder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();

        this.server
                .expect(ExpectedCount.once(), requestTo(url))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(NOT_FOUND));

        TodoDTO response = restTemplate
                .getForObject(url, TodoDTO.class);

        this.server.verify();
    }
}
