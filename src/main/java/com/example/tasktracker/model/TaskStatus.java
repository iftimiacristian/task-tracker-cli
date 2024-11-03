package com.example.tasktracker.model;

import lombok.Getter;

@Getter
public enum TaskStatus {
    TODO("todo"),
    IN_PROGRESS("in-progress"),
    DONE("done");

    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public static TaskStatus fromString(String text) {
        for (TaskStatus commandType : TaskStatus.values()) {
            if (commandType.status.equalsIgnoreCase(text)) {
                return commandType;
            }
        }
        return null;
    }

    public String toString(){
        return status;
    }
}
