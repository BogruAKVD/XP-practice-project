package org.xpapp.userinterface.DeadlineAppication.model;

import java.time.OffsetDateTime;

public class Deadline {

    private String name;
    private OffsetDateTime deadline;
    private Long timeToComplete;

    public Deadline(String name, OffsetDateTime deadline, Long timeToComplete) {
        this.name = name;
        this.deadline = deadline;
        this.timeToComplete = timeToComplete;
    }

}
