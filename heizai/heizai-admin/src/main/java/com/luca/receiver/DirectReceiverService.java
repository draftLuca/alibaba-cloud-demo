package com.luca.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiverService {

    @RabbitHandler
    public void process(Map testMessage) {
//        int i = 1/0;
        log.info("DirectReceiver消费者1收到消息  : " + testMessage.toString());
    }
}
