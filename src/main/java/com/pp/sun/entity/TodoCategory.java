package com.pp.sun.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TODO_CATEGORY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "CATEGORY_NAME", nullable = false, unique = true)
    private String categoryName;
}