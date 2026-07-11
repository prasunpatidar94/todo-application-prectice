package com.pp.sun.repository;

import com.pp.sun.entity.Todo;
import com.pp.sun.helper.TodoPriority;
import com.pp.sun.helper.TodoStatus;
import com.pp.sun.helper.TodoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByStatus(TodoStatus status);

    List<Todo> findByPriority(TodoPriority priority);

    List<Todo> findByType(TodoType type);

    List<Todo> findByCategory_CategoryName(String categoryName);

    List<Todo> findByDueDateBetween(LocalDate startDate,
                                    LocalDate endDate);
}