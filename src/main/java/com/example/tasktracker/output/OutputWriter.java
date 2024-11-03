package com.example.tasktracker.output;

import com.example.tasktracker.model.Task;

import java.util.List;

public interface OutputWriter {
    void printTasksAsTable(List<Task> tasks);
}
