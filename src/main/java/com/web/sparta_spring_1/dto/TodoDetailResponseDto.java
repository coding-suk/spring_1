package com.web.sparta_spring_1.dto;

import lombok.Getter;

@Getter
public class TodoDetailResponseDto {

    private final Long id;
    private final String name;
    private final String pw;

    public TodoDetailResponseDto(Long id, String name, String pw) {
        this.id = id;
        this.name = name;
        this.pw = pw;
    }
}
