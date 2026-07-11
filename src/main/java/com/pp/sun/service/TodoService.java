package com.pp.sun.service;


import com.pp.sun.dto.TodoRequest;
import com.pp.sun.dto.TodoResponse;
import com.pp.sun.helper.TodoPriority;
import com.pp.sun.helper.TodoStatus;
import com.pp.sun.helper.TodoType;

import java.time.LocalDate;
import java.util.List;

public interface TodoService {

    TodoResponse createTodo(TodoRequest request);

    List<TodoResponse> getAllTodos();

    TodoResponse getTodoById(Long id);

    TodoResponse updateTodo(Long id, TodoRequest request);

    void deleteTodo(Long id);

    List<TodoResponse> getTodosByStatus(TodoStatus status);

    List<TodoResponse> getTodosByPriority(TodoPriority priority);

    List<TodoResponse> getTodosByType(TodoType type);

    List<TodoResponse> getTodosByCategory(String category);

    List<TodoResponse> getTodosByDueDate(LocalDate startDate, LocalDate endDate);
}