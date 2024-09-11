package com.web.sparta_spring_1.controller;

import com.web.sparta_spring_1.dto.*;
import com.web.sparta_spring_1.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 저장
    @PostMapping("/todos")
    public TodoSaveResponseDto saveTodo(@RequestBody TodoSaveRequestDto requestDto) {
        return todoService.saveTodo(requestDto);
    }

    //전체 조회
    @GetMapping("/todos")
    public List<TodoSimpleResponseDto> getTodo() {
        return todoService.getTodo();
    }

    //단건 조회
    @GetMapping("/todos/{todoId}")
    public TodoDetailResponseDto detailTodo(@PathVariable Long todoId) {
        return todoService.detailTodo(todoId);
    }

    // 수정
    @PutMapping("/todos/{todoId}")
    public TodoUpdateResponseDto updateTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequestDto requestDto) {
        return todoService.updateTodo(todoId, requestDto);
    }

    //삭제
    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
    }

}
