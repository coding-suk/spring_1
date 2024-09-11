package com.web.sparta_spring_1.repository;

import com.web.sparta_spring_1.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
