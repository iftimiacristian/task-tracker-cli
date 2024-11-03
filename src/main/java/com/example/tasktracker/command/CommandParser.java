package com.example.tasktracker.command;

import com.example.tasktracker.command.commands.BaseCommand;
import com.example.tasktracker.exception.InvalidCommandException;
import com.example.tasktracker.exception.RequiredArgumentException;

public interface CommandParser {
    BaseCommand parseCommand() throws RequiredArgumentException, InvalidCommandException;
}
