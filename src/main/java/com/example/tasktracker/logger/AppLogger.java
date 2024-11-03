package com.example.tasktracker.logger;

public interface AppLogger {
    static String LOGGER_NAME = "FILE_STORAGE";

    void info(String msg, Object p);
    void error(String msg, Object p);
}
