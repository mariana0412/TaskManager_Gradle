package org.mapthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Properties;

public class TaskUI {
    private TaskList taskList;
    private final TaskStorage taskStorage;
    private final String filePath;
    private boolean exitRequested = false;

    public TaskUI() throws IOException {
        taskStorage = new TaskStorage();
        filePath = findFilePath();
        System.out.println(filePath);
        try {
            taskList = taskStorage.load(filePath);
            System.out.println(taskList);
        } catch (IOException e) {
            System.out.println("in catch");
            e.printStackTrace();
            taskList = new TaskList();
        }
    }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while(!exitRequested) {
            System.out.println("Enter command: add <task> | done <index> | list | exit");
            line = reader.readLine();

            String[] commandParts = splitLine(line);
            if(commandIsCorrect(commandParts))
                processCommand(commandParts);
            else
                System.out.println("Unknown command!");
        }
        taskStorage.save(filePath, taskList);
    }

    private String[] splitLine(String line) {
        return line.split(" ", 2);
    }

    private boolean commandIsCorrect(String[] commandParts) {
        if(commandParts.length == 0)
            return false;

        String keyWord = commandParts[0];
        if(commandParts.length == 1)
            return keyWord.equals("list") || keyWord.equals("exit");
        else
            return keyWord.equals("add") || keyWord.equals("done");
    }

    private void processCommand(String[] commandParts) {
        String command = commandParts[0];

        switch (command) {
            case "add" -> addTask(commandParts);
            case "done" -> markTaskAsDone(commandParts);
            case "list" -> listTasks();
            case "exit" -> exitApplication();
        }
    }

    private void addTask(String[] parts) {
        String taskDescription = parts[1];
        Task taskToAdd = new Task(taskDescription);
        taskList.addTask(taskToAdd);
    }

    private void markTaskAsDone(String[] parts) {
        try {
            int index = Integer.parseInt(parts[1]) - 1;
            Optional<Task> taskOptional = taskList.getTask(index);
            Task task = taskOptional
                    .orElseThrow(() -> new IllegalArgumentException("Index is out of bounds!"));
            task.setDone(true);
        } catch (NumberFormatException e) {
            System.out.println("Invalid task index!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listTasks() {
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.getTask(i).get();
            int index = i + 1;
            System.out.println(index + ": " + task.getDescription() + (task.isDone() ? " DONE" : ""));
        }
    }

    private void exitApplication() {
        exitRequested = true;
    }

    private static String findFilePath() throws IOException {
        Properties properties = new Properties();
        properties.load(TaskUI.class.getResourceAsStream("/config.properties"));
        return properties.getProperty("resource.file");
    }
}

