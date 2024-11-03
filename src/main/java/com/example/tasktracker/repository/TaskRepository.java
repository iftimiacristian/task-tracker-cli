package com.example.tasktracker.repository;

import com.example.tasktracker.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> getAll();

    int add(Task t);
}
