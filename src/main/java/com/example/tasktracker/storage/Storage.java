package com.example.tasktracker.storage;

import com.example.tasktracker.model.Task;

import java.util.List;

public interface Storage {
    List<Task> load();

    void save(List<Task> taskList);
}
