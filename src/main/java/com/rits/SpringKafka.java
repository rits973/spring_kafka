package com.rits;

/**
 * Created by ritesh on 6/3/17.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableAutoConfiguration
@RestController
public class SpringKafka {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private Listener listener;

    public static void main(String[] args) {
        SpringApplication.run(SpringKafka.class, args);
    }


    @RequestMapping(path = "/{message}", method = RequestMethod.GET)
    public String sendMessage(@PathVariable String message) {
        System.out.println("Sending message----" + message);
        ListenableFuture<SendResult<String, String>> future = null;
        // for(int i=0;i<100;i++){
        future = kafkaTemplate.send("topic1", message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("success");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("failed");
            }
        });
        //}
        return listener.getSentMessage();

    }
}