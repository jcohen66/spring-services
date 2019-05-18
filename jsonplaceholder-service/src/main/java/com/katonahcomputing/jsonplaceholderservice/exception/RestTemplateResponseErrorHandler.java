package com.katonahcomputing.jsonplaceholderservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    Logger logger = LoggerFactory.getLogger(RestTemplateResponseErrorHandler.class);


    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return (
                clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                        || clientHttpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);

    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

        logger.error("Exception caught!");

        if (clientHttpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            // Handle SERVER_ERROR
        } else if (clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle CLIENT_ERROR
            if (clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                logger.error(HttpStatus.NOT_FOUND.toString());
                throw new NotFoundException();
            }
        }
    }
}
