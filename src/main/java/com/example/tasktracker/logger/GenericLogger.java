package com.example.tasktracker.logger;

import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class GenericLogger implements AppLogger {
    private final Logger logger;

    public GenericLogger() {
        this.logger = Logger.getLogger(LOGGER_NAME);
    }

    public void info(String msg, Object p) {
        logger.log(Level.INFO, msg, p);
    }

    public void error(String msg, Object p) {
        logger.log(Level.SEVERE, msg, p);
    }
}
