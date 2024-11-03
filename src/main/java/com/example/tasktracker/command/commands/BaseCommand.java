package com.example.tasktracker.command.commands;

import com.example.tasktracker.command.Command;
import com.example.tasktracker.command.CommandType;
import com.example.tasktracker.exception.RequiredArgumentException;
import lombok.Data;

@Data
public class BaseCommand implements Command {
    private CommandType type;
    private Integer requiredArgs = 0;
    private final String[] args;

    public BaseCommand(String[] args) {
        this.args = args;
    }

    protected void checkParamsNumber() throws RequiredArgumentException {
        if(args.length != requiredArgs){
            String message = "This command needs %d parameters";
            throw new RequiredArgumentException(String.format(message, this.requiredArgs));
        }
    }

    public void validate() throws RequiredArgumentException {
        checkParamsNumber();
    }
}
