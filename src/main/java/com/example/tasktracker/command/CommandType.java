package com.example.tasktracker.command;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum CommandType {
    ADD("add"),
    UPDATE("update"),
    DELETE("delete"),

    MARK_IN_PROGRESS("mark-in-progress"),
    MARK_DONE("mark-done"),

    LIST("list");

    private final String name;

    CommandType(String name) {
        this.name = name;
    }

    public static Optional<CommandType> fromString(String text) {

        for (CommandType commandType : CommandType.values()) {
            if (commandType.name.equalsIgnoreCase(text)) {
                return Optional.of(commandType);
            }
        }
        return Optional.empty();
    }

}
