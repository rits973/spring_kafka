package com.rits;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ritesh on 6/3/17.
 */
public class Listener {

    public final CountDownLatch countDownLatch1 = new CountDownLatch(1);
    ConsumerRecord<?, ?> record;

    @KafkaListener(id = "foo", topics = "topic1", group = "group1")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("message received ---" + record.value());
        countDownLatch1.countDown();
        this.record = record;
    }

    public String getSentMessage() {
        return record.value().toString();
    }

}
