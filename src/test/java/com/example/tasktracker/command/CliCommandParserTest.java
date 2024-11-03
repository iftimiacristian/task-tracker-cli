package com.example.tasktracker.command;

import com.example.tasktracker.command.commands.BaseCommand;
import com.example.tasktracker.command.commands.CreateCommand;
import com.example.tasktracker.command.commands.ListCommand;
import com.example.tasktracker.exception.InvalidCommandException;
import com.example.tasktracker.exception.RequiredArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CliCommandParserTest {

    @Test
    void testParseCommandWithValidListCommand() throws RequiredArgumentException, InvalidCommandException {
        String[] args = {"list"};
        CliCommandParser parser = new CliCommandParser(args);

        BaseCommand command = parser.parseCommand();

        assertInstanceOf(ListCommand.class, command);
        assertEquals(CommandType.LIST, command.getType());
    }

    @Test
    void testParseCommandWithValidAddCommand() throws RequiredArgumentException, InvalidCommandException {
        String[] args = {"add", "New Task"};
        CliCommandParser parser = new CliCommandParser(args);

        BaseCommand command = parser.parseCommand();

        assertInstanceOf(CreateCommand.class, command);
        assertEquals(CommandType.ADD, command.getType());
        assertEquals("New Task", command.getArgs()[0]);
    }

    @Test
    void testParseCommandWithNoArgs() {
        String[] args = {};
        CliCommandParser parser = new CliCommandParser(args);

        assertThrows(RequiredArgumentException.class, parser::parseCommand);
    }

    @Test
    void testParseCommandWithInvalidCommand() {
        String[] args = {"asdfasfas"};
        CliCommandParser parser = new CliCommandParser(args);

        assertThrows(InvalidCommandException.class, parser::parseCommand);
    }

    @Test
    void testParseCommandWithMissingArgsForAdd() {
        String[] args = {"add"};
        CliCommandParser parser = new CliCommandParser(args);

        assertThrows(RequiredArgumentException.class, parser::parseCommand);
    }
}