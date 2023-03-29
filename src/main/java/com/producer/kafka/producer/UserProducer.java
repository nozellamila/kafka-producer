package com.producer.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Component
public class UserProducer {
    @Value("${users.topic}")
    private String userTopic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send(final @RequestBody Object user) {
        final String mensageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(userTopic, mensageKey, user);
    }
}
