package com.example.tasktracker.output;

import com.example.tasktracker.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleWriter implements OutputWriter {
    private static final String COLUMN_SIZE_SMALL = "%-5";
    private static final String COLUMN_SIZE_MID = "%-15";
    private static final String COLUMN_SIZE_LARGE = "%-20";

    public void printTasksAsTable(List<Task> tasks) {
        printTableHeader();
        printTasks(tasks);
    }

    private void printTableHeader() {
        String lineFormat = COLUMN_SIZE_SMALL + "s " + COLUMN_SIZE_LARGE + "s " + COLUMN_SIZE_MID + "s%n";
        System.out.printf(lineFormat, "ID", "Description", "Status");
    }

    private void printTasks(List<Task> tasks) {
        String lineFormat = COLUMN_SIZE_SMALL + "d " + COLUMN_SIZE_LARGE + "s " + COLUMN_SIZE_MID + "s%n";

        tasks.forEach(task -> System.out.printf(lineFormat,
                task.getId(), task.getDescription(), task.getStatus()));
    }
}
