package com.katonahcomputing.domainservice.event;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

public class AnnotationDrivenContextStartedListener {

    // @Async
    @EventListener
    public void handleContextStart(ContextStartedEvent cse) {
        System.out.println("Handling context started event.");
    }
}
