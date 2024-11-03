package com.example.tasktracker.command;

import com.example.tasktracker.command.commands.BaseCommand;
import com.example.tasktracker.command.commands.CreateCommand;
import com.example.tasktracker.command.commands.ListCommand;
import com.example.tasktracker.exception.InvalidCommandException;
import com.example.tasktracker.exception.RequiredArgumentException;

import java.util.Arrays;
import java.util.Optional;

public class CliCommandParser implements CommandParser {
    private CommandType commandType;
    private BaseCommand command;
    private final String[] args;

    public CliCommandParser(String[] args) {
        this.args = args;
    }

    public BaseCommand parseCommand() throws RequiredArgumentException, InvalidCommandException {
        validateBaseArgs();
        validateCommandType();
        validateCommand();
        return command;
    }

    private void validateBaseArgs() throws RequiredArgumentException {
        if (args.length == 0) {
            throw new RequiredArgumentException("At least one parameter is required");
        }
    }

    private void validateCommandType() throws InvalidCommandException {
        Optional<CommandType> optionalCommandType = CommandType.fromString(args[0]);
        if (optionalCommandType.isEmpty()) {
            throw new InvalidCommandException("Command not found: " + args[0]);
        } else {
            commandType = optionalCommandType.get();
        }
    }

    private void validateCommand() throws InvalidCommandException, RequiredArgumentException {
        Optional<BaseCommand> optionalCommand = getCommand();
        if(optionalCommand.isEmpty()){
            throw new InvalidCommandException("Command not found: " + args[0]);
        } else {
            command = optionalCommand.get();
            command.validate();
        }
    }

    private Optional<BaseCommand> getCommand() {
        String[] commandArgs = Arrays.copyOfRange(args, 1, args.length);
        switch(commandType){
            case LIST -> {
                return Optional.of(new ListCommand(commandArgs));
            }
            case ADD -> {
                return Optional.of(new CreateCommand(commandArgs));
            }
        }

        return Optional.empty();
    }

}
