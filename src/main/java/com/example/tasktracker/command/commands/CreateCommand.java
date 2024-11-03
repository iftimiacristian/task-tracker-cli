package com.example.tasktracker.command.commands;

import com.example.tasktracker.command.Command;
import com.example.tasktracker.command.CommandType;
import com.example.tasktracker.exception.RequiredArgumentException;

public class CreateCommand extends BaseCommand{
    public CreateCommand(String[] args) {
        super(args);
        this.setType(CommandType.ADD);
        this.setRequiredArgs(1);
    }
}
