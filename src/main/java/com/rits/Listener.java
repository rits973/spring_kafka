package com.rits;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by thrymr on 6/3/17.
 */
public class Listener {

    public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

    @KafkaListener(id = "foo", topics = "topic1", group = "group1")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println(record);
        countDownLatch1.countDown();
    }

}
