package com.example.tasktracker.service;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.TaskStatus;
import com.example.tasktracker.output.ConsoleWriter;
import com.example.tasktracker.output.OutputWriter;
import com.example.tasktracker.repository.TaskFileRepository;
import com.example.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CliService implements TaskService {
    private final TaskRepository repository;
    private final OutputWriter writer;

    public CliService(TaskFileRepository repository, ConsoleWriter writer) {
        this.repository = repository;
        this.writer = writer;
    }

    public Integer add(String name) {
        Task task = Task.builder()
                .description(name)
                .status(TaskStatus.TODO)
                .createdAt(new Date())
                .build();

        return repository.add(task);
    }

    public void list() {
        writer.printTasksAsTable(repository.getAll());
    }
}
