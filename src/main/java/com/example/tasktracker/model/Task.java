package com.example.tasktracker.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class Task {
    private int id;
    private String description;
    private TaskStatus status;
    private Date createdAt;
    private Date updatedAt;
}
