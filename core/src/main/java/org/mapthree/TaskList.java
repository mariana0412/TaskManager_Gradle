package org.mapthree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    private final List<Task> tasks = new ArrayList<>();

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {}

    /**
     * Adds a task to the task list.
     *
     * @param task the task to be added
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Retrieves a task from the task list based on the index.
     *
     * @param index the index of the task
     * @return an Optional containing the task if it exists, or an empty Optional otherwise
     */
    public Optional<Task> getTask(int index) {
        if (index >= 0 && index < tasks.size())
            return Optional.of(tasks.get(index));
        else
            return Optional.empty();
    }

    /**
     * Returns the size of the task list.
     *
     * @return the number of tasks in the list
     */
    public int size() {
        return tasks.size();
    }
}
