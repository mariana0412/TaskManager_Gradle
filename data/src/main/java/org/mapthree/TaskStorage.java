package org.mapthree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class TaskStorage {
    private final Gson gson;

    public TaskStorage() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public TaskList load(String fileName) throws IOException {
        Type taskListType = new TypeToken<TaskList>() {}.getType();
        try (FileReader reader = new FileReader(fileName)) {
            TaskList taskList = gson.fromJson(reader, taskListType);
            return taskList != null ? taskList : new TaskList();
        }
    }

    public void save(String fileName, TaskList taskList) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(taskList, writer);
        }
    }
}