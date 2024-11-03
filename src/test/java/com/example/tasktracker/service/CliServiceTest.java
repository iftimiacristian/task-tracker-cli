package com.example.tasktracker.service;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.TaskStatus;
import com.example.tasktracker.output.ConsoleWriter;
import com.example.tasktracker.repository.TaskFileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CliServiceTest {

    @Mock
    private TaskFileRepository repository;

    @Mock
    private ConsoleWriter writer;

    @InjectMocks
    private CliService cliService;

    @BeforeEach
    void setUp() {
        cliService = new CliService(repository, writer);
    }

    @Test
    void testAdd() {
        String taskName = "New Task";
        Task task = Task.builder()
                .description(taskName)
                .status(TaskStatus.TODO)
                .createdAt(new Date())
                .build();

        cliService.add(taskName);

        verify(repository, times(1)).add(task);
    }

    @Test
    void testList() {
        List<Task> tasks = Collections.singletonList(
                Task.builder()
                        .id(1)
                        .description("Task 1")
                        .status(TaskStatus.TODO)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build()
        );

        when(repository.getAll()).thenReturn(tasks);

        cliService.list();

        verify(writer, times(1)).printTasksAsTable(tasks);
    }
}
