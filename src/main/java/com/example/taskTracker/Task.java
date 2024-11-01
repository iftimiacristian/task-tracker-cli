package com.example.taskTracker;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {
    private int id;
    private String description;
    private TaskStatus status;
}
