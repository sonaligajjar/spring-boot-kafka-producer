package com.techprimers.kafka.springbootkafkaproducerexample.resource;

import com.techprimers.kafka.springbootkafkaproducerexample.model.User;
import com.techprimers.kafka.springbootkafkaproducerexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    private UserService userService;

    private static final String SMS_TOPIC = "bank1_SMS";
    private static final String EMAIL_TOPIC = "bank1_Email";

    @PostMapping("/publish")
    public String post(@RequestBody User user) {

        String s = userService.save(user);
        kafkaTemplate.send(SMS_TOPIC, new User(user.getName(), user.getDept(), user.getSalary()));
        kafkaTemplate.send(EMAIL_TOPIC, new User(user.getName(), user.getDept(), user.getSalary()));
        return s;
    }
}
