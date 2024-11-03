package com.example.tasktracker;

import com.example.tasktracker.command.CliCommandHandler;
import com.example.tasktracker.command.CommandHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskTrackerApplication implements CommandLineRunner {

    private final CommandHandler handler;

    public TaskTrackerApplication(CliCommandHandler handler) {
        this.handler = handler;
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        handler.handle(args);
    }
}
