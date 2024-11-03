package com.example.tasktracker.command.commands;

import com.example.tasktracker.command.CommandType;

public class ListCommand extends BaseCommand {

    public ListCommand(String[] args) {
        super(args);
        this.setType(CommandType.LIST);
    }
}
