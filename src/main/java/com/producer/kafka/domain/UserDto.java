package com.producer.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Integer age;
    private String name;
    private String profile;
    private Integer levelUpdrs;
}
