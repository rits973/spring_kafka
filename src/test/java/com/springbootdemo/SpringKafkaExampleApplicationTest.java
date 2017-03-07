package com.springbootdemo;

import com.rits.Listener;
import com.rits.SpringKafka;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Created by ritesh on 6/3/17.
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringKafka.class)
public class SpringKafkaExampleApplicationTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private Listener listener;
    @Test
    public void contextLoads() throws InterruptedException {
        ListenableFuture<SendResult<String, String>> future = null;
        for (int i = 0; i < 10; i++) {
            // future = kafkaTemplate.send("topic1"+i, "ABC--"+i);
           /* future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onSuccess(SendResult<String, String> result) {
                    System.out.println("success");
                }

                @Override
                public void onFailure(Throwable ex) {
                    System.out.println("failed");
                }
            });*/
        }


        System.out.println(Thread.currentThread().getId());
        System.out.println("Ok");
        //assertThat(this.listener.countDownLatch1.await(60, TimeUnit.SECONDS)).isTrue();


    }

}