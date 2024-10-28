package com.deadline.model;

import jakarta.persistence.Column;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
public class DeadlineDTO {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "deadline", nullable = false)
    private OffsetDateTime deadline;

    @Column(name = "time_to_complete", nullable = false)
    private Long timeToComplete; // Time in minutes
}
