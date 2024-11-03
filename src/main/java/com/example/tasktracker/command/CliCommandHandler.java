package com.example.tasktracker.command;

import com.example.tasktracker.exception.InvalidCommandException;
import com.example.tasktracker.logger.AppLogger;
import com.example.tasktracker.logger.GenericLogger;
import com.example.tasktracker.service.CliService;
import com.example.tasktracker.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CliCommandHandler implements CommandHandler {
    private final TaskService service;
    private String[] args;
    private Command commandType;
    private final AppLogger logger;

    public CliCommandHandler(CliService service, GenericLogger logger) {
        this.service = service;
        this.logger = logger;
    }

    public void handle(String[] commandArgs) {
        try {
            parseCommand(commandArgs);
            execute();
        } catch (InvalidCommandException e) {
            logger.error("Command not found", e);
        }
    }

    private void parseCommand(String[] commandArgs) throws InvalidCommandException {
        this.args = commandArgs;
        Optional<Command> optionalCommandType = Command.fromString(commandArgs[0]);
        if (optionalCommandType.isEmpty()) {
            throw new InvalidCommandException("Command not found: " + commandArgs[0]);
        } else {
            commandType = optionalCommandType.get();
        }
    }

    private void execute() {
        switch (commandType) {
            case LIST -> service.list();
            case ADD -> service.add(args[1]);
        }
    }
}
