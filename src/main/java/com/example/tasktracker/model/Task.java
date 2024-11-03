package com.example.tasktracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private int id;
    private String description;
    private TaskStatus status;
    private Date createdAt;
    private Date updatedAt;
}
