package org.mapthree;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskList {
    private final List<Task> tasks = new ArrayList<>();

    public TaskList() {}

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Optional<Task> getTask(int index) {
        if (index >= 0 && index < tasks.size())
            return Optional.of(tasks.get(index));
        else
            return Optional.empty();
    }

    public int size() {
        return tasks.size();
    }

}