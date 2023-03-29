package com.producer.kafka.controller;

import com.producer.kafka.domain.UserDto;
import com.producer.kafka.producer.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserProducer userProducer;

    @RequestMapping(method = RequestMethod.POST)
    public void send(@RequestBody UserDto user) {
        userProducer.send(user);
    }
}
