package com.example.tasktracker.command.commands;

import com.example.tasktracker.exception.RequiredArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseCommandTest {

    @Test
    void testCheckParamsNumberWithCorrectNumberOfArgs() throws RequiredArgumentException {
        String[] args = {"arg1", "arg2"};
        BaseCommand command = new BaseCommand(args);
        command.setRequiredArgs(2);
        assertDoesNotThrow(command::checkParamsNumber);
    }

    @Test
    void testCheckParamsNumberWithIncorrectNumberOfArgs() {
        String[] args = {"arg1"};
        BaseCommand command = new BaseCommand(args);
        command.setRequiredArgs(2);
        RequiredArgumentException exception = assertThrows(RequiredArgumentException.class, command::checkParamsNumber);
        assertEquals("This command needs 2 parameters", exception.getMessage());
    }

    @Test
    void testValidateWithCorrectNumberOfArgs() throws RequiredArgumentException {
        String[] args = {"arg1", "arg2"};
        BaseCommand command = new BaseCommand(args);
        command.setRequiredArgs(2);
        assertDoesNotThrow(command::validate);
    }

    @Test
    void testValidateWithIncorrectNumberOfArgs() {
        String[] args = {"arg1"};
        BaseCommand command = new BaseCommand(args);
        command.setRequiredArgs(2);
        RequiredArgumentException exception = assertThrows(RequiredArgumentException.class, command::validate);
        assertEquals("This command needs 2 parameters", exception.getMessage());
    }
}
