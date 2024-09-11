package com.web.sparta_spring_1.dto;

import lombok.Getter;

@Getter
public class TodoSimpleResponseDto {

    private final String name;
    private final String pw;

    public TodoSimpleResponseDto(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }
}
