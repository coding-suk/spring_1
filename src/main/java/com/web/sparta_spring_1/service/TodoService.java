package com.web.sparta_spring_1.service;

import com.web.sparta_spring_1.dto.*;
import com.web.sparta_spring_1.entity.Todo;
import com.web.sparta_spring_1.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto requestDto) {
        Todo newTodo = new Todo(requestDto.getName(), requestDto.getPw());
        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponseDto(savedTodo.getId(), savedTodo.getName(), savedTodo.getPw());
    }

    public List<TodoSimpleResponseDto> getTodo() {
        List<Todo> todoList = todoRepository.findAll();

        List<TodoSimpleResponseDto> dtoList = new ArrayList<>();
        for (Todo todo : todoList) {
            TodoSimpleResponseDto dto = new TodoSimpleResponseDto(todo.getName(), todo.getPw());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public TodoDetailResponseDto detailTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("할일이 없습니다"));

        return new TodoDetailResponseDto(todo.getId(), todo.getName(), todo.getPw());
    }

    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto requestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("할일이 없습니다"));

        todo.update(requestDto.getName());
        return new TodoUpdateResponseDto(todo.getId(), todo.getName(), todo.getPw());
    }

    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("보드가 없습니다"));

        todoRepository.delete(todo);
    }
}
