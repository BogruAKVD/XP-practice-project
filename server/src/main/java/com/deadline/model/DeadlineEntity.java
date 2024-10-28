package com.deadline.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
public class DeadlineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "deadline", nullable = false)
    private OffsetDateTime deadline;

    @Column(name = "time_to_complete", nullable = false)
    private Long timeToComplete; // Time in minutes

    @Column(name = "user_id", nullable = false)
    private Long userId;
}
