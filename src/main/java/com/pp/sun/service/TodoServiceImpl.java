package com.pp.sun.service;

import com.pp.sun.dto.TodoRequest;
import com.pp.sun.dto.TodoResponse;
import com.pp.sun.entity.Todo;
import com.pp.sun.entity.TodoCategory;
import com.pp.sun.exception.ResourceNotFoundException;
import com.pp.sun.helper.TodoPriority;
import com.pp.sun.helper.TodoStatus;
import com.pp.sun.helper.TodoType;
import com.pp.sun.mapper.TodoMapper;
import com.pp.sun.repository.TodoCategoryRepository;
import com.pp.sun.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoCategoryRepository categoryRepository;

    @Override
    public TodoResponse createTodo(TodoRequest request) {
   
        TodoCategory category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Todo todo = Todo.builder().todoName(request.getTodoName()).todoDescription(request.getTodoDescription()).status(request.getStatus()).priority(request.getPriority()).type(request.getType()).dueDate(request.getDueDate()).category(category).build();

        return TodoMapper.toResponse(todoRepository.save(todo));
    }

    @Override
    public List<TodoResponse> getAllTodos() {

        return todoRepository.findAll().stream().map(TodoMapper::toResponse).toList();
    }

    @Override
    public TodoResponse getTodoById(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

        return TodoMapper.toResponse(todo);
    }

    @Override
    public TodoResponse updateTodo(Long id, TodoRequest request) {

        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));

        TodoCategory category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        todo.setTodoName(request.getTodoName());
        todo.setTodoDescription(request.getTodoDescription());
        todo.setStatus(request.getStatus());
        todo.setPriority(request.getPriority());
        todo.setType(request.getType());
        todo.setDueDate(request.getDueDate());
        todo.setCategory(category);

        return TodoMapper.toResponse(todoRepository.save(todo));
    }

    @Override
    public void deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));

        todoRepository.delete(todo);
    }

    @Override
    public List<TodoResponse> getTodosByStatus(TodoStatus status) {

        return todoRepository.findByStatus(status).stream().map(TodoMapper::toResponse).toList();
    }

    @Override
    public List<TodoResponse> getTodosByPriority(TodoPriority priority) {

        return todoRepository.findByPriority(priority).stream().map(TodoMapper::toResponse).toList();
    }

    @Override
    public List<TodoResponse> getTodosByType(TodoType type) {

        return todoRepository.findByType(type).stream().map(TodoMapper::toResponse).toList();
    }

    @Override
    public List<TodoResponse> getTodosByCategory(String category) {

        return todoRepository.findByCategory_CategoryName(category).stream().map(TodoMapper::toResponse).toList();
    }

    @Override
    public List<TodoResponse> getTodosByDueDate(LocalDate startDate, LocalDate endDate) {

        return todoRepository.findByDueDateBetween(startDate, endDate).stream().map(TodoMapper::toResponse).toList();
    }
}