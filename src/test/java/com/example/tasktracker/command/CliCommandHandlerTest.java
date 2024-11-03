package com.example.tasktracker.command;

import com.example.tasktracker.logger.GenericLogger;
import com.example.tasktracker.service.CliService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CliCommandHandlerTest {

    @Mock
    private CliService service;

    @Mock
    private GenericLogger logger;


    @InjectMocks
    private CliCommandHandler cliCommandHandler;

    @BeforeEach
    void setUp() {
        cliCommandHandler = new CliCommandHandler(service, logger);
    }

    @Test
    void testHandleWithValidListCommand() {
        String[] args = {"LIST"};

        cliCommandHandler.handle(args);

        verify(service, times(1)).list();
        verify(logger, never()).error(anyString(), any(Exception.class));
    }

    @Test
    void testHandleWithValidAddCommand() {
        String[] args = {"ADD", "New Task"};

        cliCommandHandler.handle(args);

        verify(service, times(1)).add("New Task");
        verify(logger, never()).error(anyString(), any(Exception.class));
    }
}
