package com.katonahcomputing.domainservice.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * Spring events are synchronous.  Blocks until all listeners
     * are finished processing the event.
     *
     * @param message
     */
    public void doStuffAndPublishEvent(final String message) {
        System.out.println("Publishing custom event.");
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
