package com.web.sparta_spring_1.dto;

import lombok.Getter;

@Getter
public class TodoUpdateResponseDto {

    private final Long id;
    private final String name;
    private final String contents;

    public TodoUpdateResponseDto(Long id, String name, String contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;
    }
}
