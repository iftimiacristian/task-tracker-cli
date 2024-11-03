package com.example.tasktracker.command.commands;

import com.example.tasktracker.command.Command;
import com.example.tasktracker.command.CommandType;
import com.example.tasktracker.exception.RequiredArgumentException;

public class ListCommand extends BaseCommand {

    public ListCommand(String[] args) {
        super(args);
        this.setType(CommandType.LIST);
    }
}
