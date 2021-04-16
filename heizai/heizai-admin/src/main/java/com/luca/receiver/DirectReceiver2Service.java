package com.luca.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver2Service {

    /**
     * 和DirectReceiverService监听同一个队列，不会重复消费，轮询消费
     * @param testMessage
     */
    @RabbitHandler
    public void process(Map testMessage) {
        log.info("DirectReceiver消费者2收到消息  : " + testMessage.toString());
    }
}
