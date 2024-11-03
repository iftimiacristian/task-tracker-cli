package com.example.tasktracker.logger;

public interface AppLogger {
    String LOGGER_NAME = "TASK_TRACKER";

    void info(String msg, Object p);
    void error(String msg, Object p);
}
