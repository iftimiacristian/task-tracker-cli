package com.example.tasktracker.command;

import com.example.tasktracker.command.commands.BaseCommand;
import com.example.tasktracker.exception.InvalidCommandException;
import com.example.tasktracker.exception.RequiredArgumentException;
import com.example.tasktracker.logger.AppLogger;
import com.example.tasktracker.logger.GenericLogger;
import com.example.tasktracker.service.CliService;
import com.example.tasktracker.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class CliCommandHandler implements CommandHandler {
    private final TaskService service;
    private BaseCommand command;
    private final AppLogger logger;

    public CliCommandHandler(CliService service, GenericLogger logger) {
        this.service = service;
        this.logger = logger;
    }

    public void handle(String[] commandArgs) {
        CommandParser commandParser = new CliCommandParser(commandArgs);
        try {
            this.command = commandParser.parseCommand();
            execute();
        } catch (InvalidCommandException | RequiredArgumentException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void execute() {
        switch (command.getType()) {
            case LIST -> service.list();
            case ADD -> service.add(command.getArgs()[0]);
        }
    }
}
