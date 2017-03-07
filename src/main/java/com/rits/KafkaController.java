package com.rits;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by ritesh on 7/3/17.
 */
//@RestController
//@RequestMapping("/kafka")
public class KafkaController {

    // @RequestMapping(value = "/${message}",method = RequestMethod.GET)
    public void sendMessage(@PathVariable String val) {
        System.out.println("-----" + val);

    }
}
