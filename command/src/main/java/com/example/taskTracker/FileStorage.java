package com.example.taskTracker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileStorage {
    public static final String FILE_NAME = "storage.json";
    private File file;
    private ObjectMapper mapper;
    private final Logger logger;

    public FileStorage() {
        logger = Logger.getLogger("FILE_STORAGE");
        initFile();
    }

    private void initFile() {
        try {
            file = new File(FILE_NAME);

            if (!file.exists()) {
                if (file.createNewFile()) {
                    logger.log(Level.INFO, "File created", file);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File storage issue", e);
        }
    }

    public List<Task> loadFromFile(){
        try {
            return mapper.readValue(file, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Problem loading list of files", e);
        }

        return List.of();
    }

    public void writeToFile(List<Task> taskList) {
        String json = "";

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(taskList);
        } catch (JsonProcessingException e) {
            logger.log(Level.SEVERE, "Problem converting to JSON", e);
        }
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Problem writing to file", e);
        }
    }
}
