package com.pp.sun.controller;

import com.pp.sun.dto.TodoRequest;
import com.pp.sun.dto.TodoResponse;
import com.pp.sun.helper.TodoPriority;
import com.pp.sun.helper.TodoStatus;
import com.pp.sun.helper.TodoType;
import com.pp.sun.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@Valid @RequestBody TodoRequest request) {

        return new ResponseEntity<>(todoService.createTodo(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id) {

        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, @Valid @RequestBody TodoRequest request) {

        return ResponseEntity.ok(todoService.updateTodo(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {

        todoService.deleteTodo(id);

        return ResponseEntity.ok("Todo deleted successfully.");
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TodoResponse>> getByStatus(@PathVariable TodoStatus status) {

        return ResponseEntity.ok(todoService.getTodosByStatus(status));
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<TodoResponse>> getByPriority(@PathVariable TodoPriority priority) {

        return ResponseEntity.ok(todoService.getTodosByPriority(priority));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<TodoResponse>> getByType(@PathVariable TodoType type) {

        return ResponseEntity.ok(todoService.getTodosByType(type));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<TodoResponse>> getByCategory(@PathVariable String category) {

        return ResponseEntity.ok(todoService.getTodosByCategory(category));
    }

    @GetMapping("/due-date")
    public ResponseEntity<List<TodoResponse>> getByDueDateRange(

            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,

            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        return ResponseEntity.ok(todoService.getTodosByDueDate(start, end));
    }
}