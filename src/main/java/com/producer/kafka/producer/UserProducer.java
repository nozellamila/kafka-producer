package com.producer.kafka.producer;

import com.producer.kafka.domain.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserProducer {
    @Value("${users.topic}")
    private String userTopic;

    @Autowired
    private KafkaTemplate<String, UserDto> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProducer.class);

    public void send(UserDto user) {

        LOGGER.info(String.format("Enviando mensagem: %s", user.toString()));

        Message<UserDto> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, userTopic)
                .build();

        kafkaTemplate.send(message);
    }
}
