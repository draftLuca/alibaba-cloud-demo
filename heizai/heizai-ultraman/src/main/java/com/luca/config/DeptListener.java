package com.luca.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeptListener implements ApplicationListener<DepteEvent> {

    @Async
    @Override
    public void onApplicationEvent(DepteEvent event) {
        Object source = event.getSource();
        log.info("OrderSubmitListener onApplicationEvent source:[{}]", ToStringBuilder.reflectionToString(source));

    }
}
