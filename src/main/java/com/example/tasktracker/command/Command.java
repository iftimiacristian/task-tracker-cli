package com.example.tasktracker.command;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum Command {
    ADD("add"),
    UPDATE("update"),
    DELETE("delete"),

    MARK_IN_PROGRESS("mark-in-progress"),
    MARK_DONE("mark-done"),

    LIST("list");

    private final String name;

    Command(String name) {
        this.name = name;
    }

    public static Optional<Command> fromString(String text) {

        for (Command commandType : Command.values()) {
            if (commandType.name.equalsIgnoreCase(text)) {
                return Optional.of(commandType);
            }
        }
        return Optional.<Command>empty();
    }

}
