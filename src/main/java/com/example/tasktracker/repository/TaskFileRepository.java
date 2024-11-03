package com.example.tasktracker.repository;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.storage.FileStorage;
import com.example.tasktracker.storage.Storage;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class TaskFileRepository implements TaskRepository {
    private final Storage storage;
    private Map<Integer, Task> taskMap;
    private final AtomicInteger idGenerator = new AtomicInteger();

    public TaskFileRepository(FileStorage storage) {
        this.storage = storage;

        loadFromFile();
        updateId();
    }

    public List<Task> getAll() {
        return new ArrayList<>(taskMap.values());
    }

    public int add(Task task) {
        int id = idGenerator.incrementAndGet();
        task.setId(id);

        taskMap.put(task.getId(), task);
        save();

        return task.getId();
    }

    private void save() {
        storage.save(new ArrayList<>(taskMap.values()));
    }

    private void loadFromFile() {
        taskMap = storage.load()
                .stream()
                .collect(Collectors.toMap(Task::getId, task -> task));
    }

    private void updateId() {
        if (taskMap.isEmpty()) {
            return;
        }

        Optional<Integer> maxId = taskMap.keySet().stream()
                .max(Comparator.naturalOrder());

        maxId.ifPresent(idGenerator::set);
    }

}
