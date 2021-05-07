package com.luca.config;

import org.springframework.context.ApplicationEvent;

public class DepteEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public DepteEvent(Object source) {
        super(source);
    }
}
