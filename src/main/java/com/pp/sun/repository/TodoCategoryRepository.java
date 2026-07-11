package com.pp.sun.repository;


import com.pp.sun.entity.TodoCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoCategoryRepository
        extends JpaRepository<TodoCategory, Long> {

    Optional<TodoCategory> findByCategoryName(String categoryName);

}