package com.pp.sun.entity;

import com.pp.sun.helper.TodoPriority;
import com.pp.sun.helper.TodoStatus;
import com.pp.sun.helper.TodoType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TODOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TODO_NAME", nullable = false)
    private String todoName;

    @Column(name = "TODO_DESCRIPTION", length = 1000)
    private String todoDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "TODO_STATUS", nullable = false)
    private TodoStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "TODO_PRIORITY", nullable = false)
    private TodoPriority priority;

    @Enumerated(EnumType.STRING)
    @Column(name = "TODO_TYPE", nullable = false)
    private TodoType type;

    @Column(name = "DUE_DATE", nullable = false)
    private LocalDate dueDate;

    @CreationTimestamp
    @Column(name = "CREATION_DATE", updatable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATED_DATE")
    private LocalDateTime lastUpdatedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private TodoCategory category;
}