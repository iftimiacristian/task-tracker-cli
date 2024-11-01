package com.example.taskTracker;

import java.util.List;

public class TaskRepository {
    private final FileStorage fileStorage = new FileStorage();
    private final List<Task> taskList;

    public TaskRepository(){
        taskList = fileStorage.loadFromFile();
    }

    public List<Task> all() {
        return taskList;
    }

    public void addTask(Task task){
        taskList.add(task);
        saveToFile();
    }

    public void saveToFile(){
        fileStorage.writeToFile(taskList);
    }
}
