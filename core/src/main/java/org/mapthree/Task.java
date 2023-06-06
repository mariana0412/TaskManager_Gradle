package org.mapthree;

/**
 * Represents a task with a description and completion status.
 */
public class Task {
    private final String description;
    private boolean done;

    /**
     * Constructs a new Task object with the given description.
     *
     * @param description the description of the task
     */
    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if the task is marked as done.
     *
     * @return true if the task is done, false otherwise
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Sets the task as done or undone.
     *
     * @param done the new completion status of the task
     */
    public void setDone(boolean done) {
        this.done = done;
    }
}
