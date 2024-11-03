package com.example.tasktracker.command;

import com.example.tasktracker.exception.RequiredArgumentException;

public interface Command {
    void validate() throws RequiredArgumentException;
}
