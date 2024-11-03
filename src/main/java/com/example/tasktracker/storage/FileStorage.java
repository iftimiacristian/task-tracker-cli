package com.example.tasktracker.storage;

import com.example.tasktracker.logger.AppLogger;
import com.example.tasktracker.logger.GenericLogger;
import com.example.tasktracker.model.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class FileStorage implements Storage {
    public static final String FILE_NAME = "storage.json";
    private File file;
    private final ObjectMapper mapper = new ObjectMapper();
    private final AppLogger logger;

    public FileStorage(GenericLogger logger) {
        this.logger = logger;
        initFile();
    }

    private void initFile() {
        try {
            file = new File(FILE_NAME);

            if (!file.exists()) {
                if (file.createNewFile()) {
                    writeToFile("[]");
                    logger.info("File created", file);
                }
            }
        } catch (IOException e) {
            logger.error("File storage issue", e);
        }
    }

    public List<Task> load() {
        List<Task> tasks = List.of();
        try {
            tasks = mapper.readValue(file, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            logger.error("Problem loading list of files", e);
        }

        return tasks;
    }

    public void save(List<Task> taskList) {
        String json = "";

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(taskList);
        } catch (JsonProcessingException e) {
            logger.error("Problem converting to JSON", e);
        }
        writeToFile(json);
    }

    private void writeToFile(String string) {
        FileWriter writer;
        try {
            writer = new FileWriter(FILE_NAME);
        } catch (IOException e) {
            logger.error("Problem initializing file writer", e);
            return;
        }
        try {
            writer.write(string);
        } catch (IOException e) {
            logger.error("Problem writing to file", e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            logger.error("Problem closing file", e);
        }
    }

}
